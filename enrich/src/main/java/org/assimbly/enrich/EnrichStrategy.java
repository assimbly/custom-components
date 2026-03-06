package org.assimbly.enrich;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.assimbly.enrich.attachment.AttachmentEnrichStrategy;
import org.assimbly.enrich.json.JsonEnrichStrategy;
import org.assimbly.enrich.override.OverrideEnrichStrategy;
import org.assimbly.enrich.xml.XmlEnrichStrategy;
import org.assimbly.enrich.zipfile.ZipFileEnrichStrategy;

public class EnrichStrategy implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange originalExchange, Exchange resourceExchange) {

        AggregationStrategy aggregationStrategy;

        String enrichType= "";

        if (originalExchange != null && originalExchange.getProperty("Enrich-Type") != null)
                enrichType = originalExchange.getProperty("Enrich-Type", String.class);

        aggregationStrategy = switch (enrichType) {
            case "text/xml" -> new XmlEnrichStrategy();
            case "application/json" -> new JsonEnrichStrategy();
            case "application/zip" -> new ZipFileEnrichStrategy();
            case "application/attachment" -> new AttachmentEnrichStrategy();
            case "application/override" -> new OverrideEnrichStrategy();
            default -> throw new UnsupportedOperationException();
        };

        return aggregationStrategy.aggregate(originalExchange, resourceExchange);
    }

}
