/**************************************************************************************
 https://camel-extra.github.io

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation; either version 3
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Lesser General Public License for more details.


 You should have received a copy of the GNU Lesser General Public
 License along with this program; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 02110-1301, USA.

 http://www.gnu.org/licenses/lgpl-3.0-standalone.html
 ***************************************************************************************/
package org.assimbly.smb.strategy;

import java.util.Arrays;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.component.file.GenericFile;
import org.apache.camel.component.file.GenericFileEndpoint;
import org.apache.camel.component.file.GenericFileExclusiveReadLockStrategy;
import org.apache.camel.component.file.GenericFileOperations;
import org.apache.camel.spi.CamelLogger;
import org.apache.camel.util.StopWatch;
import org.codelibs.jcifs.smb.impl.SmbFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * see org.apache.camel.component.file.remote.strategy.SftpChangedExclusiveReadLockStrategy
 */
public class SmbChangedExclusiveReadLockStrategy implements GenericFileExclusiveReadLockStrategy<SmbFile> {
    private static final Logger LOG = LoggerFactory.getLogger(SmbChangedExclusiveReadLockStrategy.class);
    private long timeout;
    private long checkInterval = 5000;
    private LoggingLevel readLockLoggingLevel = LoggingLevel.WARN;
    private long minLength = 1;
    private long minAge;

    @Override
    public void prepareOnStartup(final GenericFileOperations<SmbFile> tGenericFileOperations, final GenericFileEndpoint<SmbFile> tGenericFileEndpoint) {
        // noop
    }

    @Override
    public boolean acquireExclusiveReadLock(final GenericFileOperations<SmbFile> operations, final GenericFile<SmbFile> file, final Exchange exchange) {
        LOG.trace("Waiting for exclusive read lock to file: {}", file);

        FileState previous = new FileState(Long.MIN_VALUE, Long.MIN_VALUE);
        StopWatch watch = new StopWatch();
        long startTime = System.currentTimeMillis();

        while (true) {
            if (timeout > 0 && watch.taken() > timeout) {
                CamelLogger.log(LOG, readLockLoggingLevel,
                        "Cannot acquire read lock within " + timeout + " millis. Will skip the file: " + file);
                // we could not get the lock within the timeout period, so return false
                return false;
            }

            FileState current = readFileState(operations, file);

            LOG.trace("Previous last modified: {}, new last modified: {}", previous.lastModified(), current.lastModified());
            LOG.trace("Previous length: {}, new length: {}", previous.length(), current.length());
            long newOlderThan = startTime + watch.taken() - minAge;
            LOG.trace("New older than threshold: {}", newOlderThan);

            if (isReadLockAcquirable(previous, current, newOlderThan)) {
                LOG.trace("Read lock acquired.");
                return true;
            }

            // set new base file change information
            previous = current;

            if (sleep()) {
                // we were interrupted while sleeping, we are likely being shutdown so return false
                return false;
            }
        }
    }

    private FileState readFileState(final GenericFileOperations<SmbFile> operations, final GenericFile<SmbFile> file) {
        LOG.trace("Using full directory listing to update file information for {}.", file);
        // fast option not available (smb listFiles only handles directories), so list the directory and filter the file name
        List<SmbFile> files = Arrays.asList(operations.listFiles(file.getParent()));

        LOG.trace("List files {} found {} files", file.getAbsoluteFilePath(), files.size());
        long lastModified = 0;
        long length = 0;
        for (SmbFile f : files) {
            // use same attribute sources as org.apacheextras.camel.component.jcifs.SmbConsumer#asGenericFile()
            if (f.getName().equals(file.getFileNameOnly())) {
                lastModified = f.getLastModified();
                length = f.getContentLengthLong();
            }
        }
        return new FileState(lastModified, length);
    }

    private boolean isReadLockAcquirable(final FileState previous, final FileState current, final long newOlderThan) {
        if (current.length() < minLength) {
            return false;
        }
        return minAge == 0 ? current.equals(previous) : current.lastModified() < newOlderThan;
    }

    private record FileState(long lastModified, long length) {
    }

    private boolean sleep() {
        LOG.trace("Exclusive read lock not granted. Sleeping for {} millis.", checkInterval);
        try {
            Thread.sleep(checkInterval);
            return false;
        } catch (InterruptedException _) {
            LOG.debug("Sleep interrupted while waiting for exclusive read lock, so breaking out");
            Thread.currentThread().interrupt();
            return true;
        }
    }

    @Override
    public void releaseExclusiveReadLockOnAbort(final GenericFileOperations<SmbFile> operations, final GenericFile<SmbFile> file, final Exchange exchange) {
        // noop
    }

    @Override
    public void releaseExclusiveReadLockOnRollback(final GenericFileOperations<SmbFile> operations, final GenericFile<SmbFile> file, final Exchange exchange) {
        // noop
    }

    @Override
    public void releaseExclusiveReadLockOnCommit(final GenericFileOperations<SmbFile> operations, final GenericFile<SmbFile> file, final Exchange exchange) {
        // noop
    }

    public long getTimeout() {
        return timeout;
    }

    @Override
    public void setTimeout(final long timeout) {
        this.timeout = timeout;
    }

    public long getCheckInterval() {
        return checkInterval;
    }

    @Override
    public void setCheckInterval(final long checkInterval) {
        this.checkInterval = checkInterval;
    }

    @Override
    public void setReadLockLoggingLevel(final LoggingLevel readLockLoggingLevel) {
        this.readLockLoggingLevel = readLockLoggingLevel;
    }

    public long getMinLength() {
        return minLength;
    }

    public void setMinLength(final long minLength) {
        this.minLength = minLength;
    }

    public long getMinAge() {
        return minAge;
    }

    public void setMinAge(final long minAge) {
        this.minAge = minAge;
    }

    @Override
    public void setMarkerFiler(final boolean markerFiler) {
        // noop - not supported by smb
    }

    @Override
    public void setDeleteOrphanLockFiles(final boolean deleteOrphanLockFiles) {
        // noop - not supported by smb
    }
}
