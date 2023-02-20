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

import jcifs.context.SingletonContext;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

/**
 * Default implementation of the the {@link SmbApiFactory} uses the JCIFS API.
 */
public class JcifsSmbApiFactory implements SmbApiFactory {

    @Override
    public SmbFile createSmbFile(final String url, final NtlmPasswordAuthentication authentication) throws IOException {
        return new SmbFile(url, SingletonContext.getInstance().withCredentials(authentication));
    }

    @Override
    public SmbFile createSmbFile(String url) throws IOException {
        return null;
    }

    @Override
    public SmbFileOutputStream createSmbFileOutputStream(final SmbFile smbFile, final boolean b) throws IOException {
        return new SmbFileOutputStream(smbFile, b);
    }

}
