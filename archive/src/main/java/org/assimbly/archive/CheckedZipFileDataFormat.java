package org.assimbly.archive;

import org.apache.camel.Exchange;
import org.apache.camel.spi.DataFormat;
import org.assimbly.util.exception.ArchiveTooLargeException;
import org.assimbly.util.helper.PropertiesHelper;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CheckedZipFileDataFormat extends ZipFileDataFormat implements DataFormat {

    @Override
    public void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {
        super.marshal(exchange, graph, stream);
    }

    @Override
    public Object unmarshal(Exchange exchange, InputStream stream) throws Exception {

        long uncompressedSize = 0;
        long maxFileSize = Long.parseLong(PropertiesHelper.getProperty("max_uncompressed_file_size")); // In Bytes

        if (super.isUsingIterator()) {
            ZipInputStream zis = resolveInputStream(exchange);
            for (ZipEntry entry : entries(zis)) {
                uncompressedSize += entry.getSize();
            }
        } else {
            ZipInputStream zis = new ZipInputStream(stream);
            ZipEntry entry = zis.getNextEntry();
            if (entry != null) {
                uncompressedSize = entry.getSize();
            }
        }

        if (uncompressedSize > maxFileSize) {
            throw new ArchiveTooLargeException("Uncompressed archive size too large: " + uncompressedSize
                    + " Bytes. Max: " + maxFileSize + " Bytes");
        }

        return super.unmarshal(exchange, stream);
    }

    private ZipInputStream resolveInputStream(Exchange exchange) {
        InputStream inputStream = exchange.getIn().getBody(InputStream.class);

        return inputStream instanceof ZipInputStream ?
                (ZipInputStream) inputStream :
                new ZipInputStream(new BufferedInputStream(inputStream));
    }

    private List<ZipEntry> entries(ZipInputStream inputStream) throws IOException {
        List<ZipEntry> entries = new ArrayList<>();
        ZipEntry entry;

        while ((entry = inputStream.getNextEntry()) != null) {
            if (!entry.isDirectory()) {
                entries.add(entry);
            }
        }

        return entries;
    }
}