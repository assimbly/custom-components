package org.assimbly.oriflame;

import org.assimbly.oriflame.details.EdiDetails;
import org.assimbly.smooksnoxml.BaseXmlReader;
import org.milyn.cdr.SmooksResourceConfiguration;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.AttributesImpl;

import java.util.*;

public class OriflameReader extends BaseXmlReader {
    private static final String GROUP_TAG = "GROUP_NAME";

    private List<OriflameLineReader> lineReaders;
    private EdiDetails type;

    // 0-arg constructor needs to be available for reflective instantiation
    public OriflameReader() {
    }

    // setter needs to be here for instance configuration through reflection
    @SuppressWarnings({"unchecked", "unused"})
    public void setConfiguration(SmooksResourceConfiguration config) {
        // order matters!
        lineReaders = new LinkedList<>();
        lineReaders.addAll((List<OriflameLineReader>) config.getParameter(OriflameConfigurator.PARAM_LINE_READERS).getObjValue());

        // sort line readers based on the header length
        Collections.sort(lineReaders, new HeaderLengthComparator());
        // make sure line readers are traversed from most specific (longer header) to least
        Collections.reverse(lineReaders);

        type = (EdiDetails) config.getParameter(OriflameConfigurator.PARAM_EDI_TYPE).getObjValue();
    }

    @Override
    public void parse(InputSource inputSource) {
        List<HashMap<String, String>> allTheLines = parseInput(inputSource);

        documentHandler.startDocument();

        documentHandler.startElement("soap:Envelope", createAttributes("xmlns:soap", "http://schemas.xmlsoap.org/soap/envelope/"));
        documentHandler.startElement("soap:Body");

        Stack<String> groupings = new Stack<>();

        if(type.hasMainGroup){
            allTheLines.add(0, determineReaderForLine("MAIN").parseLine("MAIN"));
        }

        for(HashMap<String, String> node : allTheLines) {

            if (node.containsKey(GROUP_TAG)) {
                List<String> groups = type.groupings.get(node.get(GROUP_TAG));
                String lastGroup = groups.get(groups.size()-1);

                if (groupings.empty() || !groupings.contains(lastGroup)) {
                    for(String g : groups){
                        groupings.push(g);
                        documentHandler.startElement(g, type.getNodeAttribute(g));
                    }

                } else {
                    while (!groupings.peek().equals(lastGroup)) {
                        documentHandler.endElement(groupings.pop());
                    }

                    documentHandler.endElement(lastGroup);
                    documentHandler.startElement(lastGroup);
                }

                for(String key : type.fields.get(node.get(GROUP_TAG))){
                    String value = node.containsKey(key) ? node.get(key) : type.additionalEntries.get(key);

                    if(value != null && !value.equals("") && !key.equals(GROUP_TAG)){

                        documentHandler.startElement(key);
                        documentHandler.sendCharacters(type.convert(key, value));
                        documentHandler.endElement(key);
                    }
                }
            } else {
                for(String key : type.fields.get(node.get("IGNORE"))){
                    String value = node.get(key);
                    if(value != null && !value.equals("") && !key.equals("IGNORE")){

                        documentHandler.startElement(key);
                        documentHandler.sendCharacters(type.convert(key, value));
                        documentHandler.endElement(key);
                    }
                }
            }
        }

        while(!groupings.empty()){
            documentHandler.endElement(groupings.pop());
        }

        documentHandler.endElement("soap:Body");
        documentHandler.endElement("soap:Envelope");
        documentHandler.endDocument();
    }

    private List<HashMap<String, String>> parseInput(InputSource inputSource) {
        Scanner scanner = new Scanner(inputSource.getCharacterStream());
        scanner.useDelimiter("\n");

        List<HashMap<String, String>> allTheLines = new ArrayList<>();

        while(scanner.hasNext()) {
            String line = scanner.next();

            OriflameLineReader lineReader = determineReaderForLine(line);

            if(lineReader == null) {
                continue;
            }

            allTheLines.add(lineReader.parseLine(line));
        }
        return allTheLines;
    }

    private AttributesImpl createAttributes(String name, String value) {
        AttributesImpl attributes = new AttributesImpl();
        attributes.addAttribute("", name, name, "CDATA", value);
        return attributes;
    }

    private OriflameLineReader determineReaderForLine(String line) {
        for(OriflameLineReader lineReader: lineReaders) {
            if(lineReader.supports(line))
                return lineReader;
        }
        return null;
    }

    /**
     * Favors line readers with longer headers, which provide more specific matches
     * Example: header ARTDUMMY is more specific than ART
     */
    private class HeaderLengthComparator implements Comparator<OriflameLineReader> {

        @Override
        public int compare(OriflameLineReader lineReader, OriflameLineReader otherLineReader) {
            return lineReader.getHeader().length() - otherLineReader.getHeader().length();
        }
    }

}
