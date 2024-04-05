package org.assimbly.aggregate.xml;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;


public class XmlAggregateStrategy implements AggregationStrategy {

    protected Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Exchange aggregate(Exchange newExchange, Exchange splitExchange) {

        try {

            try {
                int CamelSplitIndex = splitExchange.getProperty("CamelSplitIndex", Integer.class);
                if(CamelSplitIndex==0){
                    return splitExchange;
                }
            } catch (Exception e) {
                return splitExchange;
            }

            String splitXml = getBody(splitExchange);
            String newXml = getBody(newExchange);

            if(newXml == null && splitXml == null) {
                throw new Exception("XML Aggregate: Inputs are empty.");
            }

            newXml = newXml + splitXml;
            boolean CamelSplitComplete = splitExchange.getProperty("CamelSplitComplete",Boolean.class);

            if(CamelSplitComplete){
                newXml = format("<Aggregated>" + newXml + "</Aggregated>");
            }

            newExchange.getIn().setBody(newXml);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return newExchange;
    }

    private String getBody(Exchange exchange) {

        try {
            return exchange.getIn().getBody(String.class);
        } catch (Exception e) {

            if (log.isDebugEnabled()) {
                log.debug("Unable to get data from the route to the Aggregate component.");
            }
        }

        return null;
    }


    public String format(String xml) {

        try {
            final InputSource src = new InputSource(new StringReader(xml));
            final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();

            final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
            final LSSerializer writer = impl.createLSSerializer();

            writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE); // Set this to true if the output needs to be beautified.
            writer.getDomConfig().setParameter("xml-declaration", true);

            String serializedXml = writer.writeToString(document);
            serializedXml = serializedXml.replace("encoding=\"UTF-16\"", "encoding=\"UTF-8\"");

            return serializedXml;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
