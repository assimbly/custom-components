package org.assimbly.mail.component.mail;

import org.apache.camel.Exchange;
import org.apache.camel.spi.HeaderFilterStrategy;
import org.apache.camel.support.DefaultHeaderFilterStrategy;

public class ExtendedHeaderFilterStrategy extends DefaultHeaderFilterStrategy {

    @Override
    protected boolean extendedFilter(HeaderFilterStrategy.Direction direction, String key, Object value, Exchange exchange) {
        if (direction == HeaderFilterStrategy.Direction.IN) {
            return false;
        }

        return (exchange.getContext().getTypeConverter().tryConvertTo(String.class, value).contains("\n"));
    }
}
