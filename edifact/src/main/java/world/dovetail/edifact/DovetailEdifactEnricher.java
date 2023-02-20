package world.dovetail.edifact;

import org.apache.commons.lang3.StringUtils;

public class DovetailEdifactEnricher {

    private final static String UNA = "UNA:+.? '\r\n";
    private final static String UNH = "UNH";
    private final static String UNT = "UNT";
    private final static String SEGMENT_SEPARATOR = "'";
    private final static String DATA_ELEMENT_SEPARATOR = "+";

    /**
     * Adds the missing UNA field and calculates the total
     * number of components and fills in the correct UNT value
     */
    public static void enrich(StringBuilder builder) throws Exception {
        builder.insert(0, UNA);
        insertSegmentCount(builder);
    }

    private static void insertSegmentCount(StringBuilder builder) {
        int count = calculateSegments(builder);

        int firstDataElementSeparator = builder.indexOf(DATA_ELEMENT_SEPARATOR, builder.indexOf(UNT)) + 1;
        int lastDataElementSeparator = builder.indexOf(DATA_ELEMENT_SEPARATOR, firstDataElementSeparator);

        builder.replace(firstDataElementSeparator, lastDataElementSeparator, String.valueOf(count));
    }

    /**
     * See http://www.unece.org/fileadmin/DAM/trade/untdid/texts/d423.htm#p8.3
     * section 8.3.10 for the correct definition of the UNT field
     */
    private static int calculateSegments(StringBuilder builder) {
        String segments = builder.substring(builder.indexOf(UNH), builder.indexOf(UNT));

        return StringUtils.countMatches(segments, SEGMENT_SEPARATOR) + 1;
    }
}
