package world.dovetail.googledrive;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

public class GoogleDriveComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String context, Map<String, Object> parameters) throws Exception {

        GoogleDriveConfiguration configuration = new GoogleDriveConfiguration();

        GoogleDriveEndpoint googleDriveEndpoint = new GoogleDriveEndpoint(uri, this, configuration);

        setProperties(googleDriveEndpoint.getConfiguration(), parameters);

        return googleDriveEndpoint;
    }
}
