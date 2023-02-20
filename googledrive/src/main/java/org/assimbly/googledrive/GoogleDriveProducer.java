package org.assimbly.googledrive;

import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;
import org.apache.camel.support.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.assimbly.googledrive.exception.GoogleDriveException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Collections;

@SuppressWarnings("PackageAccessibility")
public class GoogleDriveProducer extends DefaultProducer {
	private static final Logger LOG = LoggerFactory.getLogger(GoogleDriveProducer.class);

    private Drive service;
    private GoogleDriveConfiguration configuration;

    public GoogleDriveProducer(GoogleDriveEndpoint endpoint) {
        super(endpoint);
        this.configuration = endpoint.getConfiguration();
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        Object body = exchange.getIn().getBody();

        @SuppressWarnings("unchecked")
        GenericFile<File> genericFile = (body instanceof GenericFile) ? (GenericFile) body : prepareCamelFile(exchange);

        prepareGoogleDriveClient();

        String googleDriveFileId = uploadToGoogleDrive(genericFile);

        exchange.getIn().setHeader("GoogleDriveFileId", googleDriveFileId);

        postProcess(genericFile.getFile());
    }

    private void prepareGoogleDriveClient() {
        this.service = ((GoogleDriveEndpoint) getEndpoint()).getClient();
    }

    private GenericFile<File> prepareCamelFile(Exchange exchange) throws IOException {

        String existing = exchange.getIn().getHeader("CamelFileName", String.class);
        GenericFile<File> genericFile = new GenericFile<>();
        File file;

        try {
            file = File.createTempFile("temp", "");
        } catch (IOException e) {
            throw new GoogleDriveException("upload", existing);
        }

        try (FileOutputStream outputStream = new FileOutputStream(file)) {

            outputStream.write(exchange.getIn().getBody(byte[].class));

            genericFile.setFileName(existing);
            genericFile.setFile(file);

        } catch (IOException e) {
            throw new GoogleDriveException("upload", existing);
        }

        return genericFile;
    }

    private String uploadToGoogleDrive(GenericFile<File> genericFile) throws IOException {

        com.google.api.services.drive.model.File fileMetadata = new com.google.api.services.drive.model.File();
        fileMetadata.setParents(Collections.singletonList(configuration.getDirectoryId()));
        fileMetadata.setName(genericFile.getFileName());

        String mimeType = URLConnection.guessContentTypeFromName(genericFile.getFileName());
        FileContent mediaContent = new FileContent(mimeType, genericFile.getFile());

        return service.files().create(fileMetadata, mediaContent)
                .setFields("id, parents")
                .execute().getId();
    }

    private void postProcess(File tempFile) throws IOException {
        tempFile.delete();
    }
}
