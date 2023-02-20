package world.dovetail.amazon.service;

import org.apache.camel.Exchange;
import world.dovetail.amazon.api.FeedsApi;
import world.dovetail.amazon.api.OrdersApi;
import world.dovetail.amazon.api.ReportsApi;
import world.dovetail.amazon.api.SellersApi;
import world.dovetail.amazon.domain.Marketplace;
import world.dovetail.amazon.exception.MarketplaceNotFoundException;

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
