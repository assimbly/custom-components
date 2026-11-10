package org.assimbly.googledrive;

import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;
import org.apache.camel.support.DefaultProducer;
import org.assimbly.tenantvariables.mongo.MongoDao;
import org.assimbly.tenantvariables.helper.ExchangeHelper;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

@SuppressWarnings("PackageAccessibility")
public class GoogleDriveProducer extends DefaultProducer {

    private Drive service;
    private final GoogleDriveConfiguration configuration;

    public GoogleDriveProducer(GoogleDriveEndpoint endpoint) {
        super(endpoint);
        this.configuration = endpoint.getConfiguration();
    }

    public void process() throws Exception {
        process((Exchange) null);
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        Object body = exchange.getIn().getBody();

        File file = null;
        String fileName;
        AbstractInputStreamContent content;

        if (body instanceof GenericFile<?> gf) {
            //noinspection unchecked
            GenericFile<File> genericFile = (GenericFile<File>) gf;
            file = genericFile.getFile();
            fileName = genericFile.getFileName();
            content = new FileContent(guessMimeType(fileName), file);
        } else {
            fileName = exchange.getIn().getHeader("CamelFileName", String.class);
            content = new ByteArrayContent(guessMimeType(fileName), exchange.getIn().getBody(byte[].class));
        }

        prepareGoogleDriveClient();

        String googleDriveFileId = uploadToGoogleDrive(fileName, content, exchange);

        exchange.getIn().setHeader("GoogleDriveFileId", googleDriveFileId);

        if (file != null) {
            postProcess(file);
        }
    }

    private void prepareGoogleDriveClient() {
        boolean forceClient = MongoDao.isTenantVar(configuration.getAccessTokenNoInterporlation());
        this.service = ((GoogleDriveEndpoint) getEndpoint()).getClient(forceClient);
    }

    private String guessMimeType(String fileName) {
        return URLConnection.guessContentTypeFromName(fileName);
    }

    private String uploadToGoogleDrive(String fileName, AbstractInputStreamContent mediaContent, Exchange exchange) throws IOException {

        String directoryId = ExchangeHelper.interpolate(configuration.getDirectoryId(), exchange);

        com.google.api.services.drive.model.File fileMetadata = new com.google.api.services.drive.model.File();
        fileMetadata.setParents(Collections.singletonList(directoryId));
        fileMetadata.setName(fileName);

        return service.files().create(fileMetadata, mediaContent)
                .setFields("id, parents")
                .execute().getId();
    }

    private void postProcess(File tempFile) throws IOException {
        Files.delete(Path.of(tempFile.getPath()));
    }
}
