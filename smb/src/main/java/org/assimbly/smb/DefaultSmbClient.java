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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.camel.util.IOHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jcifs.context.SingletonContext;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

/**
 *
 */
public class DefaultSmbClient implements SmbClient {

  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSmbClient.class);

  private NtlmPasswordAuthentication authentication;
  private SmbApiFactory smbApiFactory = new JcifsSmbApiFactory();

  /**
   * Allows for overriding the default {@link SmbApiFactory} implementation.
   *
   * @param smbApiFactory a {@link SmbApiFactory} to use instead of the default
   *                      implementation.
   */
  public void setSmbApiFactory(final SmbApiFactory smbApiFactory) {
    this.smbApiFactory = smbApiFactory;
  }

  /**
   * Creates the internal NtlmPasswordAuthentication, that is used for
   * authentication, from the provided credentials.
   *
   * @param domain   User domain to use at login
   * @param username User name to use at login
   * @param password The password for the provided user
   */
  @Override
  public void login(final String domain, final String username, final String password) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("login() domain[" + domain + "] username[" + username + "] password[***]");
    }
    setAuthentication(new NtlmPasswordAuthentication(SingletonContext.getInstance(), domain, username,
        password));
  }

  /**
   * @param url
   * @param out
   * @return
   * @throws IOException
   * @throws MalformedURLException
   */
  @Override
  public boolean retrieveFile(final String url, final OutputStream out)
      throws IOException {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("retrieveFile() path[" + url + "]");
    }
    SmbFile smbFile = smbApiFactory.createSmbFile(url, authentication);
    IOHelper.copyAndCloseInput(smbFile.getInputStream(), out);
    return true;
  }

  @Override
  public boolean createDirs(final String url) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("createDirs() path[" + url + "]");
    }
    SmbFile smbFile;
    try {
      smbFile = smbApiFactory.createSmbFile(url, authentication);
      if (!smbFile.exists()) {
        smbFile.mkdirs();
      }
    } catch (IOException e) {
      LOGGER.error(
          "Could not locate or create directory '{}' due to '{}'",
          url, e.getMessage(), e);
      return false;
    }
    return true;

  }

  @Override
  public InputStream getInputStream(final String url) throws IOException {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("getInputStream() path[" + url + "]");
    }
    SmbFile smbFile = smbApiFactory.createSmbFile(url, authentication);
    return smbFile.getInputStream();
  }

  @Override
  public boolean storeFile(final String url, final InputStream inputStream, final boolean append, final Long lastModified)
      throws IOException {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("storeFile() path[" + url + "]");
    }
    SmbFile smbFile = smbApiFactory.createSmbFile(url, authentication);
    SmbFileOutputStream smbout = smbApiFactory.createSmbFileOutputStream(smbFile, append);
    byte[] buf = new byte[512 * 1024];
    int numRead;
    while ((numRead = inputStream.read(buf)) >= 0) {
      smbout.write(buf, 0, numRead);
    }
    smbout.close();
      if (lastModified != null) {
          smbFile.setLastModified(lastModified);
          if (LOGGER.isTraceEnabled()) {
              LOGGER.trace("Keeping last modified timestamp: {} on file: {}", new Object[]{lastModified, smbFile});
          }
      }
    return true;
  }

  @Override
  public List<SmbFile> listFiles(final String url) throws IOException {
    final List<SmbFile> fileList = new ArrayList<>();
    final SmbFile dir = smbApiFactory.createSmbFile(url, authentication);
    // Catch NPE for empty folders - see the following discussion for
    // details:
    // http://camel-extra.1091541.n5.nabble.com/NPE-on-SmbOperations-td256.html
    // Catch NPE for empty folders - see the following discussion for details:
    // http://camel-extra.1091541.n5.nabble.com/NPE-on-SmbOperations-td256.html
    try {
      fileList.addAll(Arrays.asList(dir.listFiles()));
    } catch (NullPointerException ex) {
      StackTraceElement[] elements = ex.getStackTrace();
      if (elements != null && elements.length > 0 && elements[0] != null
          && "jcifs.smb.Dfs".equals(elements[0].getClassName())
          && "resolve".equals(elements[0].getMethodName())) {
        LOGGER.warn("Ignoring NPE in jcifs.smb.Dfs.resolve: {}",
            ex.getMessage());
      } else {
        throw ex;
      }
    }
    return fileList;
  }

  @Override
  public boolean isExist(final String url) throws Exception {
    SmbFile sFile = smbApiFactory.createSmbFile(url, authentication);
    return sFile.exists();
  }

  @Override
  public boolean delete(final String url) throws Exception {
    SmbFile sFile = smbApiFactory.createSmbFile(url, authentication);
    try {
      // Only try to delete if the file do exists to avoid error message
      if ( sFile.exists() ) {
        sFile.delete();
      } else if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("File '{}' did not exist, skipped delete", url);
    }
    } catch (SmbException e) {
      LOGGER.error("Could not delete '{}' due to '{}'", url, e.getMessage(), e);
      return false;
    }
    return true;
  }

  @Override
  public boolean rename(final String fromUrl, final String toUrl) throws Exception {
    final SmbFile sFile = smbApiFactory.createSmbFile(fromUrl, authentication);
    final SmbFile renamedFile = smbApiFactory.createSmbFile(toUrl, authentication);

    try {
      if (sFile.exists()) {
        if (renamedFile.exists()) {
          throw new IOException("Could not rename source file '" + sFile.getName() + "' since target name '"
              + renamedFile.getName() + "' already exists.");
        }
        sFile.renameTo(renamedFile);
      }
    } catch (SmbException e) {
      LOGGER.error("Could not rename '{}' to '{}' due to '{}'", fromUrl, toUrl, e.getMessage(), e);
      return false;
    }
    return true;
  }

  public NtlmPasswordAuthentication getAuthentication() {
    return authentication;
  }

  public void setAuthentication(final NtlmPasswordAuthentication authentication) {
    this.authentication = authentication;
  }
}
