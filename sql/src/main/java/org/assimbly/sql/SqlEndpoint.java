package org.assimbly.sql;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

public class SqlEndpoint extends ProcessorEndpoint {

    @UriParam
    private SqlConfiguration configuration;
    private SqlComponent component;

    public SqlEndpoint(String uri, SqlComponent component, SqlConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() throws Exception {
        return new SqlProcessor(this);
    }

    public SqlConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public SqlComponent getComponent() {
        return component;
    }
}