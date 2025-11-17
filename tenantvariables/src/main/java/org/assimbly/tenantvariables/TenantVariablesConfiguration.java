package org.assimbly.tenantvariables;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.apache.camel.spi.UriPath;
import org.assimbly.tenantvariables.domain.Operation;


@UriParams
public class TenantVariablesConfiguration implements Cloneable {

    @UriPath
    @Metadata(required = true)
    private String name;

    @UriParam
    @Metadata(required = true)
    private Operation operation;

    @UriParam
    private String language;

    @UriParam
    @Metadata(required = true, defaultValue = "default")
    private String tenantDbName;

    @UriParam
    @Metadata(required = true)
    private String environment;

    @UriParam
    private String value;

    @UriParam
    private String headerName;

    @UriParam
    private boolean encrypt;

    @UriParam
    private String groupName;

    @UriParam
    private String flowName;

    public TenantVariablesConfiguration() { }

    /**
     * Operation to preform on the given variable.
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    /**
     * The name of the variable to use.
     */
    public void setTenantDbName(String tenantDbName) {
        this.tenantDbName = tenantDbName;
    }

    /**
     * The name of the variable to use.
     */
    public void setEnvironment(String environment) {
        this.environment = environment;
    }


    /**
     * The name of the variable to use.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Value of the given variable, can be a Base64 representation of an encrypted value.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Header name on which the value of the given variable should be put.
     */
    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    /**
     * Whether or not the given value for the given variable should be encrypted.
     */
    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }

    public void setGroupName(String groupName) { this.groupName = groupName; }

    public Operation getOperation() {
        return operation;
    }

    public String getTenantDbName() {
        return tenantDbName;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getHeaderName() {
        return headerName;
    }

    public String getGroupName() { return groupName; }

    public boolean isEncrypt() {
        return encrypt;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }
}
