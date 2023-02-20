package org.assimbly.googledrive;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import org.apache.camel.RuntimeCamelException;

import java.io.IOException;
import java.security.GeneralSecurityException;

@SuppressWarnings("PackageAccessibility")
public class GoogleDriveClientFactory {

    private NetHttpTransport transport;
    private JacksonFactory jsonFactory;

    public GoogleDriveClientFactory() {
        try {
            transport = GoogleNetHttpTransport.newTrustedTransport();
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }
        this.jsonFactory = new JacksonFactory();
    }

    public Drive makeClient(String clientId, String clientSecret, String applicationName, String refreshToken, String accessToken) {
        if (clientId == null || clientSecret == null) {
            throw new IllegalArgumentException("clientId and clientSecret are required to create Google Drive client.");
        }
        try {
            Credential credential = authorize(clientId, clientSecret);

            if (refreshToken != null && !"".equals(refreshToken)) {
                credential.setRefreshToken(refreshToken);
            }
            if (accessToken != null && !"".equals(accessToken)) {
                credential.setAccessToken(accessToken);
            }
            return new Drive.Builder(transport, jsonFactory, credential).setApplicationName(applicationName).build();
        } catch (Exception e) {
            throw new RuntimeCamelException("Could not create Google Drive client.", e);
        }
    }

    private Credential authorize(String clientId, String clientSecret) throws Exception {
        return new GoogleCredential.Builder()
                .setJsonFactory(jsonFactory)
                .setTransport(transport)
                .setClientSecrets(clientId, clientSecret)
                .build();
    }
}
