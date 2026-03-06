package org.assimbly.sql;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

import java.util.Objects;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SqlEndpoint that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(component, that.component);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), component);
    }

}