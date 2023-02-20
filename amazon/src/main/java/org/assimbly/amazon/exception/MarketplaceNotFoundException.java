package org.assimbly.amazon.exception;

import org.assimbly.util.helper.ExchangeHelper;

public class MarketplaceNotFoundException extends Exception {
    public MarketplaceNotFoundException() {
        super("Amazon Marketplace was not found");
    }
}
