package org.assimbly.fmuta;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

@UriParams
public class FmutaConfiguration {

    @UriParam
    @Metadata(required = true)
    private char decimalSeparator;

    public FmutaConfiguration() { }

    public void setDecimalSeparator(char decimalSeparator) {
        this.decimalSeparator = decimalSeparator;
    }

    public char getDecimalSeparator() {
        return decimalSeparator;
    }
}
