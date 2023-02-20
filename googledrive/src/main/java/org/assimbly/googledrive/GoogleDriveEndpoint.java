package org.assimbly.googledrive;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import org.apache.camel.Consumer;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

import static org.assimbly.googledrive.domain.GSuiteFilesTypeHelper.getConversionMimeType;
import static org.assimbly.googledrive.domain.GSuiteFilesTypeHelper.getGSuiteFileName;
import static org.assimbly.googledrive.domain.GSuiteFilesTypeHelper.isGSuiteFile;

@UriEndpoint(
        firstVersion = "4.8.0",
        scheme = "google-drive",
        title = "Google Drive Component",
        syntax = "google-drive:")
@SuppressWarnings("PackageAccessibility")
public class GoogleDriveEndpoint extends ProcessorEndpoint {

    private static final String APPLICATION_NAME = "Assimbly";
    private static final String CLIENT_ID = System.getenv("GOOGLE_CLIENT_ID");
    private static final String CLIENT_SECRET = System.getenv("GOOGLE_CLIENT_SECRET");

    private GoogleDriveClientFactory clientFactory;
    private Drive client;

    private GoogleDriveComponent component;

    @UriParam
    private GoogleDriveConfiguration configuration;

    public GoogleDriveEndpoint(String uri, GoogleDriveComponent component, GoogleDriveConfiguration configuration) {
        super(uri, component);

        this.configuration = configuration;

        this.component = component;
    }

    @Override
    public GoogleDriveComponent getComponent(){
        return component;
    }

    @Override
    public Producer createProducer() throws Exception {
        return new GoogleDriveProducer(this);
    }

    @Override
    public Consumer createConsumer(Processor processor) throws Exception {
        GoogleDriveConsumer answer = new GoogleDriveConsumer(this, processor);
        configureGoogleDriveConsumer(answer);

        return answer;
    }

    private void configureGoogleDriveConsumer(GoogleDriveConsumer consumer) throws Exception {
        super.configureConsumer(consumer);
        consumer.setDelay(Long.parseLong(configuration.getDelay()));
        consumer.setInitialDelay(Long.parseLong(configuration.getInitialDelay()));
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    Drive getClient() {
        if (client == null) {
            client = getClientFactory().makeClient(CLIENT_ID, CLIENT_SECRET, APPLICATION_NAME,
                    configuration.getRefreshToken(), configuration.getAccessToken());
        }

        return client;
    }

    protected Exchange createExchange(Object body, File fileModel) {
        Exchange exchange = createExchange();

        exchange.getIn().setBody(body);

        if (isGSuiteFile(fileModel)) {
            exchange.getIn().setHeader("CamelFileName", getGSuiteFileName(fileModel));
            exchange.getIn().setHeader(Exchange.CONTENT_TYPE, getConversionMimeType(fileModel.getMimeType()));
        } else {
            exchange.getIn().setHeader("CamelFileName", fileModel.getName());
            exchange.getIn().setHeader(Exchange.CONTENT_TYPE, fileModel.getMimeType());
        }

        return exchange;
    }

    public GoogleDriveClientFactory getClientFactory() {

        if (clientFactory == null)
            clientFactory = new GoogleDriveClientFactory();

        return clientFactory;
    }

    public GoogleDriveConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(GoogleDriveConfiguration configuration) {
        this.configuration = configuration;
    }
}
