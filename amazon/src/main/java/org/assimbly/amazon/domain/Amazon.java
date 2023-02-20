package org.assimbly.amazon.domain;

import org.assimbly.amazon.exception.MarketplaceNotFoundException;

import java.util.Arrays;
import java.util.List;

public enum Amazon {
    INSTANCE;

    private final List<Marketplace>  marketplaces = initMarketPlaces();

    private List<Marketplace> initMarketPlaces() {
        Marketplace[] marketplaces = new Marketplace[]{
                // NA
                new Marketplace("A2Q3Y263D00KWC", "Brazil", "BR", "https://mws.amazonservices.com"),
                new Marketplace("A2EUQ1WTGCTBG2", "Canada", "CA", "https://mws.amazonservices.ca"),
                new Marketplace("A1AM78C64UM0Y8", "Mexico", "MX", "https://mws.amazonservices.com.mx"),
                new Marketplace("ATVPDKIKX0DER", "US", "US", "https://mws.amazonservices.com"),

                // EU
                new Marketplace("A1PA6795UKMFR9", "Germany", "DE", "https://mws-eu.amazonservices.com"),
                new Marketplace("A1RKKUPIHCS9HS", "Spain", "ES", "https://mws-eu.amazonservices.com"),
                new Marketplace("A13V1IB3VIYZZH", "France", "FR", "https://mws-eu.amazonservices.com"),
                new Marketplace("A1F83G8C2ARO7P", "UK", "GB", "https://mws-eu.amazonservices.com"),
                new Marketplace("A21TJRUUN4KGV", "India", "IN", "https://mws.amazonservices.in"),
                new Marketplace("APJ6JRA9NG5V4", "Italy", "IT", "https://mws-eu.amazonservices.com"),
                new Marketplace("A33AVAJ2PDY3EV", "Turkey", "TR", "https://mws-eu.amazonservices.com"),
                new Marketplace("A1805IZSGTT6HS", "Netherlands", "NL", "https://mws-eu.amazonservices.com"),
                new Marketplace("A2VIGQ35RCS4UG", "United Arab Emirates", "AE", "https://mws.amazonservices.ae"),
                new Marketplace("A17E79C6D8DWNP", "Saudi Arabia", "SA", "https://mws-eu.amazonservices.com"),

                // Far East
                new Marketplace("A39IBJ37TRP1C6", "Australia", "AU", "https://mws.amazonservices.com.au"),
                new Marketplace("A1VC38T7YXB528", "Japan", "JP", "https://mws.amazonservices.jp"),
                new Marketplace("A19VAU5U5O7RUS", "Singapore", "SG", "https://mws-fe.amazonservices.com"),

                // China
                new Marketplace("AAHKV2X7AFYLW", "China", "CN", "https://mws.amazonservices.com.cn"),
        };

        return Arrays.asList(marketplaces);
    }

    public List<Marketplace> getMarketplaces() {
        return marketplaces;
    }

    /**
     * Finds a default marketplace for the given Region.
     * This method is used for Backwards Compatibility.
     *
     * @param region
     * @return Custom Marketplace with most common endpoint.
     */
    public Marketplace findMarketPlace(Region region) throws MarketplaceNotFoundException {
        switch (region) {
            case EU:
                return marketplaces.stream()
                        .filter(marketplace -> marketplace.getCountryCode().equals("DE"))
                        .findFirst().orElseThrow(MarketplaceNotFoundException::new);
            case NA:
            default:
                return marketplaces.stream()
                        .filter(marketplace -> marketplace.getCountryCode().equals("US"))
                        .findFirst().orElseThrow(MarketplaceNotFoundException::new);
        }
    }

    /**
     * Finds the marketplace related to the provided marketplace id.
     *
     * @param marketplaceId
     * @return Marketplace with according information
     *
     * @throws MarketplaceNotFoundException when there is no marketplace associated with the providedwsdl id.
     */
    public Marketplace findMarketPlace(String marketplaceId) throws MarketplaceNotFoundException {
        return marketplaces.stream()
                .filter(marketplace -> marketplace.getId().equals(marketplaceId))
                .findFirst().orElseThrow(MarketplaceNotFoundException::new);
    }
}
