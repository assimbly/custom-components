package org.assimbly.googledrive;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.assimbly.tenantvariables.mongo.MongoDao;

public class GoogleDriveConfiguration {

    public GoogleDriveConfiguration() {
    }

    // common options

    @UriParam
    @Metadata(required = true)
    protected String accessToken;

    @UriParam
    @Metadata(required = true)
    protected String tenant;

    @UriParam
    protected String directoryId;

    // consumer options

    @UriParam(label = "consumer")
    protected String filterFiles;

    @UriParam(label = "consumer")
    protected String moveTo;

    @UriParam(label = "consumer")
    protected String delay;

    @UriParam(label = "consumer")
    protected String initialDelay;

    @UriParam(label = "consumer")
    protected String gSuiteFiles;

    public String getMoveTo() {
        return moveTo;
    }

    public void setMoveTo(String moveTo) {
        this.moveTo = moveTo;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getDirectoryId() {
        return directoryId;
    }

    public void setDirectoryId(String directoryId) {
        this.directoryId = directoryId;
    }

    public String getInitialDelay() {
        return initialDelay;
    }

    public void setInitialDelay(String initialDelay) {
        this.initialDelay = initialDelay;
    }

    public String getAccessToken() {
        return MongoDao.interpolatePossibleTenantVariable(accessToken, getTenant());
    }

    public String getAccessTokenNoInterporlation() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getFilterFiles() {
        return filterFiles;
    }

    public void setFilterFiles(String filterFiles) {
        this.filterFiles = filterFiles;
    }

    public String getGSuiteFiles() {
        return gSuiteFiles;
    }

    public void setGSuiteFiles(String gSuiteFiles) {
        this.gSuiteFiles = gSuiteFiles;
    }
}
