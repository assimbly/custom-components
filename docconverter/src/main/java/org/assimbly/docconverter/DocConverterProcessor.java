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
    public void process(Exchange exchange) throws Exception {

        Message in = exchange.getIn();
        String body = in.getBody(String.class);

        String uri = endpoint.getUriPath().toLowerCase();
        String source2target = uri.replace("docconverter://","");

        String convertedBody = switch (source2target) {
            case "xml2json", "xmltojson" -> DocConverter.convertXmlToJson(body);
            case "xml2yaml", "xmltoyaml" -> DocConverter.convertXmlToYaml(body);
            case "xml2csv", "xmltocsv" -> DocConverter.convertXmlToCsv(body);
            case "json2xml", "jsontoxml" -> DocConverter.convertJsonToXml(body);
            case "json2yaml", "jsontoyaml" -> DocConverter.convertJsonToYaml(body);
            case "json2csv", "jsontocsv" -> DocConverter.convertJsonToCsv(body);
            case "yaml2xml", "yamltoxml" -> DocConverter.convertYamlToXml(body);
            case "yaml2json", "yamltojson" -> DocConverter.convertYamlToJson(body);
            case "yaml2csv", "yamltocsv" -> DocConverter.convertYamlToCsv(body);
            case "csv2xml", "csvtoxml" -> DocConverter.convertCsvToXml(body);
            case "csv2json", "csvtojson" -> DocConverter.convertCsvToJson(body);
            case "csv2yaml", "csvtoyaml" -> DocConverter.convertCsvToYaml(body);
            default -> {
                in.setHeader("docconverter", source2target + " isn't a valid path (source2target). For example xml2json");
                yield body;
            }
        };

        in.setBody(convertedBody);

    }

}