package org.assimbly.googledrive;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.UserCredentials;
import org.apache.camel.RuntimeCamelException;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("PackageAccessibility")
public class GoogleDriveClientFactory {

    private static final Logger logger = Logger.getLogger(GoogleDriveClientFactory.class.getName());

    private NetHttpTransport transport;
    private final GsonFactory jsonFactory;

    public GoogleDriveClientFactory() {
        try {
            transport = GoogleNetHttpTransport.newTrustedTransport();
        } catch (GeneralSecurityException | IOException e) {
            logger.log(Level.SEVERE, "Failed to create trusted transport", e);
        }
        this.jsonFactory = new GsonFactory();
    }

    public Drive makeClient(String clientId, String clientSecret, String applicationName, String accessToken) {
        if (clientId == null || clientSecret == null) {
            throw new IllegalArgumentException("clientId and clientSecret are required to create Google Drive client.");
        }
        try {
            UserCredentials credentials = authorize(clientId, clientSecret, accessToken);
            HttpCredentialsAdapter credentialsAdapter = new HttpCredentialsAdapter(credentials);
            return new Drive.Builder(transport, jsonFactory, credentialsAdapter)
                    .setApplicationName(applicationName)
                    .build();
        } catch (Exception e) {
            throw new RuntimeCamelException("Could not create Google Drive client.", e);
        }
    }

    private UserCredentials authorize(String clientId, String clientSecret, String accessToken) {
        UserCredentials.Builder builder = UserCredentials.newBuilder()
                .setClientId(clientId)
                .setClientSecret(clientSecret);

        if (accessToken != null && !accessToken.isEmpty()) {
            builder.setAccessToken(AccessToken.newBuilder()
                    .setTokenValue(accessToken)
                    .build());
        }

        return builder.build();
    }
}