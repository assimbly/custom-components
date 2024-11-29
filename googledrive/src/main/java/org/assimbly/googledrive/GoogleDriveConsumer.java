package org.assimbly.googledrive;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import org.apache.camel.Consumer;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.apache.camel.support.ScheduledPollConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.assimbly.googledrive.exception.GoogleDriveException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import static org.assimbly.googledrive.domain.GSuiteFilesTypeHelper.getConversionMimeType;
import static org.assimbly.googledrive.domain.GSuiteFilesTypeHelper.isGSuiteFile;

@SuppressWarnings("PackageAccessibility")
public class GoogleDriveConsumer extends ScheduledPollConsumer implements Consumer {

	private static final Logger LOG = LoggerFactory.getLogger(GoogleDriveConsumer.class);

    private final GoogleDriveEndpoint endpoint;
    private final GoogleDriveConfiguration configuration;
    private String moveDirectoryId;
    private Pattern filterPattern;
    private Drive service;

    private int connectionAttempts = 1;
    private final int connectionAttemptsMax = 60;

    GoogleDriveConsumer(GoogleDriveEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
        this.endpoint = endpoint;
        this.configuration = endpoint.getConfiguration();
    }

    @Override
    protected void doStart() throws Exception {
        super.doStart();
        service = this.endpoint.getClient(false);

        if (configuration.getFilterFiles() != null)
            filterPattern = Pattern.compile(configuration.getFilterFiles());
    }

    @Override
    protected int poll() throws Exception {

        try {
            if(configuration.getDirectoryId() == null)
                configuration.setDirectoryId("root");

            findOrCreateMoveToDirectory();

            List<File> filesToProcess = new ArrayList<>();
            String pageToken = null;

            do {
                FileList result = service.files().list()
                        .setQ( "'" + configuration.getDirectoryId() + "' in parents" +
                                " and mimeType != 'application/vnd.google-apps.folder'" +
                                " and trashed = false")
                        .setSpaces("drive")
                        .setFields("nextPageToken, files(id, name, mimeType)")
                        .setPageToken(pageToken)
                        .execute();

                for (File file : result.getFiles()) {
                    if (isGSuiteFile(file) && configuration.getGSuiteFiles().equals("Ignore"))
                        continue;

                    if (filterPattern == null || filterPattern.matcher(file.getName()).matches())
                        filesToProcess.add(file);
                }

                pageToken = result.getNextPageToken();

            } while (pageToken != null);

            for(File fileModel : filesToProcess) {

                java.io.File file = downloadFile(fileModel);

                Exchange exchange = endpoint.createExchange(file, fileModel);

                this.getProcessor().process(exchange);

                postProcess(fileModel, file);
            }
            connectionAttempts = 1;

        } catch (GoogleJsonResponseException e) {
            if(connectionAttempts <= connectionAttemptsMax) {
                long seconds = this.getDelay() / 1000L;
                LOG.warn(String.format(
                        "Could not connect to Google Drive directory. Try again after %s seconds (attempt %s of %s)",
                        seconds,
                        connectionAttempts,
                        connectionAttemptsMax
                ));
                connectionAttempts += 1;
                service = this.endpoint.getClient(true);
            } else {
                LOG.error("GoogleJsonResponseException occurred. Connect to Google Drive directory failed on flowId: "+configuration.getFlowId(), e);
            }
        }

        return 0;
    }

    private java.io.File downloadFile(File fileModel) {

        java.io.File file;

        try {
            file = java.io.File.createTempFile("temp", "");
        } catch (IOException e) {
            throw new GoogleDriveException("download", fileModel.getId());
        }

        try (OutputStream outputStream = new FileOutputStream(file)){

            if ( isGSuiteFile(fileModel) )
                service.files()
                        .export(fileModel.getId(), getConversionMimeType(fileModel.getMimeType()))
                        .executeMediaAndDownloadTo(outputStream);

            else service.files()
                    .get(fileModel.getId())
                    .executeMediaAndDownloadTo(outputStream);

        } catch (IOException e) {
            throw new GoogleDriveException("download", fileModel.getId());
        }

        return file;
    }

    private void postProcess(File fileModel, java.io.File tempFile) throws IOException {

        tempFile.delete();

        if (configuration.getMoveTo() == null)
            deleteFile(fileModel.getId());
        else
            moveFile(fileModel.getId());
    }

    private void deleteFile(String fileId) throws IOException {
        service.files().delete(fileId).execute();
    }

    private void moveFile(String fileId) throws IOException {
        File file = service.files().get(fileId).setFields("parents").execute();

        String previousParents = String.join(",", file.getParents());

        service.files().update(fileId, null)
                .setAddParents(moveDirectoryId)
                .setRemoveParents(previousParents)
                .setFields("id, parents")
                .execute();
    }

    private void findOrCreateMoveToDirectory() throws Exception {
        if (configuration.getMoveTo() != null) {

            moveDirectoryId = findMoveToDirectory();

            if (moveDirectoryId == null)
                moveDirectoryId = createMoveToDirectory();
        }
    }

    private String findMoveToDirectory() throws Exception {
        FileList result = service.files().list()
                .setQ( "'" + configuration.getDirectoryId() + "' in parents" +
                        " and mimeType = 'application/vnd.google-apps.folder'" +
                        " and trashed = false" +
                        " and name = '"+ configuration.getMoveTo() + "'")
                .execute();

        if (result.getFiles().size() > 0)
            return result.getFiles().get(0).getId();

        return null;
    }

    private String createMoveToDirectory() throws Exception {
        File fileMetadata = new File();
        fileMetadata.setName(configuration.getMoveTo());
        fileMetadata.setMimeType("application/vnd.google-apps.folder");

        if (configuration.getDirectoryId() != null)
            fileMetadata.setParents(Collections.singletonList(configuration.getDirectoryId()));

        File file = service.files().create(fileMetadata)
                .setFields("id, parents")
                .execute();

        return file.getId();
    }
}
