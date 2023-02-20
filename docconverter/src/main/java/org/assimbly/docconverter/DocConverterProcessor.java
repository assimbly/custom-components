package org.assimbly.docconverter;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class DocConverterProcessor implements Processor {

    private DocConverterEndpoint endpoint;
    private String convertedBody;

    public DocConverterProcessor(DocConverterEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        Message in = exchange.getIn();
        String body = in.getBody(String.class);

        String uri = endpoint.getUriPath().toLowerCase();
        String source2target = uri.replace("docconverter://","");

        switch(source2target)
        {
            case "xml2json":
            case "xmltojson":
                convertedBody = DocConverter.convertXmlToJson(body);
                break;
            case "xml2yaml":
            case "xmltoyaml":
                convertedBody = DocConverter.convertXmlToYaml(body);
                break;
            case "xml2csv":
            case "xmltocsv":
                convertedBody = DocConverter.convertXmlToCsv(body);
                break;
            case "json2xml":
            case "jsontoxml":
                convertedBody = DocConverter.convertJsonToXml(body);
                break;
            case "json2yaml":
            case "jsontoyaml":
                convertedBody = DocConverter.convertJsonToYaml(body);
                break;
            case "json2csv":
            case "jsontocsv":
                convertedBody = DocConverter.convertJsonToCsv(body);
                break;
            case "yaml2xml":
            case "yamltoxml":
                convertedBody = DocConverter.convertYamlToXml(body);
                break;
            case "yaml2json":
            case "yamltojson":
                convertedBody = DocConverter.convertYamlToJson(body);
                break;
            case "yaml2csv":
            case "yamltocsv":
                convertedBody = DocConverter.convertYamlToCsv(body);
                break;
            case "csv2xml":
            case "csvtoxml":
                convertedBody = DocConverter.convertCsvToXml(body);
                break;
            case "csv2json":
            case "csvtojson":
                convertedBody = DocConverter.convertCsvToJson(body);
                break;
            case "csv2yaml":
            case "csvtoyaml":
                convertedBody = DocConverter.convertCsvToYaml(body);
                break;
            default:
                in.setHeader("docconverter",source2target + " isn't a valid path (source2target). For example xml2json");
                convertedBody = body;
        }

        in.setBody(convertedBody);

    }

}