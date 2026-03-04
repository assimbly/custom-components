package org.assimbly.aggregate.xml;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class XmlAggregateStrategy implements AggregationStrategy {

    protected Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Exchange aggregate(Exchange newExchange, Exchange splitExchange) {

        try {
            String splitXml = getBody(splitExchange);
            String newXml = getBody(newExchange);

            boolean isSplitXmlNull = splitXml == null;
            boolean isNewXmlNull = newXml == null;

            if(isNewXmlNull && isSplitXmlNull) {
                throw new Exception("XML Aggregate: Inputs are empty.");
            }

            if(isNewXmlNull) {
                newXml = buildAggregateBody("", splitXml);
                splitExchange.getIn().setBody(newXml);
                return splitExchange;
            }

            newXml = buildAggregateBody(newXml, splitXml);

            newExchange.getIn().setBody(newXml);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return newExchange;
    }

    private String buildAggregateBody(String newXml, String splitXml) {
        String result = "";

        if(containsXmlDeclaration(splitXml)) {
            // removes xml declaration from splitXml
            int declarationEndPos = splitXml.indexOf("?>");
            splitXml = splitXml.substring(declarationEndPos + 2);
        }

        String aggregateEndTag = "</Aggregated>";
        if(newXml.endsWith(aggregateEndTag)) {
            result = StringUtils.substring(newXml, 0, newXml.length() - aggregateEndTag.length()) + splitXml + aggregateEndTag;
        } else {
            String xmlDeclaration = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
            String aggregateStartTag = "<Aggregated>";
            result = xmlDeclaration + aggregateStartTag + splitXml + aggregateEndTag;
        }
        return result;
    }

    private boolean containsXmlDeclaration(String xml) {
        return xml.trim().startsWith("<?xml");
    }

    private String getBody(Exchange exchange) {

        try {
            return exchange.getIn().getBody(String.class);
        } catch (Exception _) {
            if (log.isDebugEnabled()) {
                log.debug("Unable to get data from the route to the Aggregate component.");
            }
        }

        return null;
    }
}
