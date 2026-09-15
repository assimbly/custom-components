package org.assimbly.docconverter;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class DocConverterProcessor implements Processor {

    private final DocConverterEndpoint endpoint;

    public DocConverterProcessor(DocConverterEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) {

        Message in = exchange.getIn();
        String body = in.getBody(String.class);

        String uri = endpoint.getUriPath().toLowerCase();
        String source2target = uri.replace("docconverter://","");

        String convertedBody = switch (source2target) {
            case "xml2json", "xmltojson" -> DocConverter.xmlToJson(body);
            case "xml2yaml", "xmltoyaml" -> DocConverter.xmlToYaml(body);
            case "xml2csv", "xmltocsv" -> DocConverter.xmlToCsv(body);
            case "json2xml", "jsontoxml" -> DocConverter.jsonToXml(body);
            case "json2yaml", "jsontoyaml" -> DocConverter.jsonToYaml(body);
            case "json2csv", "jsontocsv" -> DocConverter.jsonToCsv(body);
            case "yaml2xml", "yamltoxml" -> DocConverter.yamlToXml(body);
            case "yaml2json", "yamltojson" -> DocConverter.yamlToJson(body);
            case "yaml2csv", "yamltocsv" -> DocConverter.yamlToCsv(body);
            case "csv2xml", "csvtoxml" -> DocConverter.csvToXml(body);
            case "csv2json", "csvtojson" -> DocConverter.csvToJson(body);
            case "csv2yaml", "csvtoyaml" -> DocConverter.csvToYaml(body);
            default -> {
                in.setHeader("docconverter", source2target + " isn't a valid path (source2target). For example xml2json");
                yield body;
            }
        };

        in.setBody(convertedBody);

    }

}