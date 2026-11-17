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
package org.assimbly.smb;

import org.apache.camel.component.file.*;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.RuntimeCamelException;
import org.apache.camel.util.FileUtil;
import org.codelibs.jcifs.smb.impl.SmbException;
import org.codelibs.jcifs.smb.impl.SmbFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Supplier;

public class SmbConsumer extends GenericFileConsumer<SmbFile> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmbConsumer.class);

    private final String endpointPath;
    private String currentRelativePath = "";

    public SmbConsumer(final GenericFileEndpoint<SmbFile> endpoint, final Processor processor, final GenericFileOperations<SmbFile> operations, final GenericFileProcessStrategy<SmbFile> strategy) {
        super(endpoint, processor, operations, strategy);
        this.endpointPath = endpoint.getConfiguration().getDirectory();
    }

    @Override
    protected boolean pollDirectory(Exchange exchange, String fileName, final List<GenericFile<SmbFile>> fileList, int depth) {

        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("pollDirectory() running. My delay is [{}] and my strategy is [{}]", this.getDelay(), this.getPollStrategy().getClass());
            LOGGER.trace("pollDirectory() fileName[{}]", fileName);
        }


        SmbFile[] smbFiles = operations.listFiles(fileName);
        for (SmbFile smbFile : smbFiles) {
            if (!canPollMoreFiles(fileList)) {
                return false;
            }
            if (isDirectory(smbFile)) {
                if (endpoint.isRecursive()) {
                    currentRelativePath = smbFile.getName().split("/")[0] + "/";
                    int nextDepth = depth++;
                    pollDirectory(exchange,fileName + "/" + smbFile.getName(), fileList, nextDepth);
                } else {
                    currentRelativePath = "";
                }
            } else {
                addIfMatched(exchange, fileName, smbFile, fileList);
            }
        }
        return true;
    }

    private boolean isDirectory(final SmbFile smbFile) {
        try {
            return smbFile.isDirectory();
        } catch (SmbException e) {
            throw RuntimeCamelException.wrapRuntimeCamelException(e);
        }
    }

    private void addIfMatched(final Exchange exchange, final String fileName, final SmbFile smbFile, final List<GenericFile<SmbFile>> fileList) {
        GenericFile<SmbFile> genericFile = asGenericFile(fileName, smbFile);
        SmbFile[] singleFileArray = { smbFile };

        boolean valid = isMatched(
                exchange,
                () -> genericFile,
                smbFile.getName(),
                smbFile.getCanonicalPath(),
                () -> currentRelativePath + smbFile.getName(),
                false,
                singleFileArray
        );

        if (valid) {
            fileList.add(asGenericFile(fileName, smbFile));
        }
    }

    @Override
    protected void updateFileHeaders(final GenericFile<SmbFile> genericFile, final Message message) {
        // Intentionally empty: the SMB component documents no consumer headers beyond the standard Camel file headers.
    }

    @Override
    protected Supplier<String> getRelativeFilePath(String endpointPath, String path, String absolutePath, SmbFile file) {
        return null;
    }

    @Override
    protected boolean isMatched(Supplier<GenericFile<SmbFile>> file, String doneFileName, SmbFile[] files) {
        return false;
    }

    private GenericFile<SmbFile> asGenericFile(final String path, final SmbFile file) {
        SmbGenericFile<SmbFile> answer = new SmbGenericFile<>();
        answer.setAbsoluteFilePath(path + answer.getFileSeparator() + file.getName());
        answer.setAbsolute(true);
        answer.setEndpointPath(endpointPath);
        answer.setFileNameOnly(file.getName());
        answer.setFileLength(file.getContentLengthLong());
        answer.setFile(file);
        answer.setLastModified(file.getLastModified());
        answer.setFileName(currentRelativePath + file.getName());
        answer.setRelativeFilePath(currentRelativePath + file.getName());

        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("asGenericFile():");
            LOGGER.trace("absoluteFilePath[{}] endpointpath[{}] filenameonly[{}] filename[{}] relativepath[{}]", answer.getAbsoluteFilePath(), answer.getEndpointPath(), answer.getFileNameOnly(), answer.getFileName(), answer.getRelativeFilePath());
        }
        return answer;
    }

    protected boolean isMatched(final String doneFileName, final SmbFile[] files) {
        String onlyName = FileUtil.stripPath(doneFileName);

        for (SmbFile f : files) {
            if (f.getName().equals(onlyName)) {
                return true;
            }
        }

        LOGGER.trace("Done file: {} does not exist", doneFileName);
        return false;
    }

    @Override
    protected Exchange createExchange(final GenericFile<SmbFile> file) {
        Exchange exchange = createExchange(true);
        if (file != null) {
            file.bindToExchange(exchange, false);
        }
        return exchange;
    }

}