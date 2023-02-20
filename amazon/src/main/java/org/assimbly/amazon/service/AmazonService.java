package org.assimbly.amazon.service;

import org.apache.camel.Exchange;
import org.assimbly.amazon.api.FeedsApi;
import org.assimbly.amazon.api.OrdersApi;
import org.assimbly.amazon.api.ReportsApi;
import org.assimbly.amazon.api.SellersApi;
import org.assimbly.amazon.domain.Marketplace;
import org.assimbly.amazon.exception.MarketplaceNotFoundException;

import java.util.Map;

/**
 * Allows interacting with the Amazon MWS API.
 */
public interface AmazonService {

    void configure(Marketplace marketplace, Map<String, String> parameters, String secretKey, Exchange exchange, boolean useBody)
            throws MarketplaceNotFoundException;

    SellersApi getSellersApi();
    FeedsApi getFeedsApi();
    ReportsApi getReportsApi();
    OrdersApi getOrdersApi();
}
