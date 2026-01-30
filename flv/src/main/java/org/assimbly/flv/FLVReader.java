package org.assimbly.flv;

import org.milyn.cdr.SmooksResourceConfiguration;
import org.xml.sax.InputSource;
import org.assimbly.smooksnoxml.BaseXmlReader;

import java.util.*;

public class FLVReader extends BaseXmlReader {

    private static final String GROUP_TAG = "group";

    private List<LineReader> lineReaders;

    // 0-arg constructor needs to be available for reflective instantiation
    public FLVReader() {
    }

    // setter needs to be here for instance configuration through reflection
    @SuppressWarnings({"unchecked", "unused"})
    public void setConfiguration(SmooksResourceConfiguration config) {
        // order matters!
        lineReaders = new LinkedList<>();
        lineReaders.addAll((List<LineReader>) config.getParameter(FLVConfigurator.PARAM_LINE_READERS).getObjValue());

        // sort line readers based on the header length
        Collections.sort(lineReaders, new HeaderLengthComparator());
        // make sure line readers are traversed from most specific (longer header) to least
        Collections.reverse(lineReaders);
    }

    @Override
    public void parse(InputSource inputSource) {
        Scanner scanner = new Scanner(inputSource.getCharacterStream());
        scanner.useDelimiter("\n");

        documentHandler.startDocument();
        documentHandler.startElement("flv-message");

        sendRulesElements();

        boolean groupIsOpen = false;

        while(scanner.hasNext()) {
            String line = scanner.next();

            LineReader lineReader = determineReaderForLine(line);

            if(lineReader == null) {
                continue;
            } else if(lineReader.isGroup() && groupIsOpen) {
                documentHandler.endElement(GROUP_TAG);
                documentHandler.startElement(GROUP_TAG);
            } else if(lineReader.isGroup()) {
                groupIsOpen = true;
                documentHandler.startElement(GROUP_TAG);
            }

            lineReader.sendLineNode(documentHandler, line);
        }

        if(groupIsOpen) documentHandler.endElement(GROUP_TAG);

        documentHandler.endElement("flv-message");
        documentHandler.endDocument();
    }

    private LineReader determineReaderForLine(String line) {
        for(LineReader lineReader: lineReaders) {
            if(lineReader.supports(line))
                return lineReader;
        }
        return null;
    }

    private void sendRulesElements() {
        for(LineReader lineReader: lineReaders) {
            lineReader.sendRuleElement(documentHandler);
        }
    }

    /**
     * Favors line readers with longer headers, which provide more specific matches
     * Example: header ARTDUMMY is more specific than ART
      */
    private static class HeaderLengthComparator implements Comparator<LineReader> {
        @Override
        public int compare(LineReader a, LineReader b) {
            int lengthDiff = a.getHeader().length() - b.getHeader().length();

            if (lengthDiff != 0) {
                return lengthDiff;
            }

            // If lengths are the same, sort alphabetically to ensure
            // deterministic behavior across different JDKs
            return a.getHeader().compareTo(b.getHeader());
        }
    }

}
