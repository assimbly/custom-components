package org.assimbly.aleris.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlerisCertificateSplitter {
    private static final Pattern specification = Pattern.compile("(.+)(?:SPECIFICATIES|DESCRIPTION)\\s*:", Pattern.DOTALL);
    private static final Pattern chemicalAnalysis = Pattern.compile("={2,}\\s*\\n.*\\n\\s*={2,}\\s*\\n(.+)\\n\\s*={2,}\\s*\\n.*\\n\\s*={2,}\\s*\\n", Pattern.DOTALL);
    private static final Pattern mechanicalProperties = Pattern.compile("={2,}.*={2,}.*={2,}.*={2,}(.+)(?:KISTINHOUD|CONT\\.PALLET)\\s*:\\s*(?:ROL|COIL)\\s*(?:DEELROL|SUBCOIL)\\s*(?:KISTNUMMER|PALLETNUMBER)\\s*(?:AANTAL|QUANTITY)", Pattern.DOTALL);
    private static final Pattern crateContent = Pattern.compile("(?:KISTINHOUD|CONT\\.PALLET)\\s*:\\s*(?:ROL|COIL)\\s*(?:DEELROL|SUBCOIL)\\s*(?:KISTNUMMER|PALLETNUMBER)\\s*(?:AANTAL|QUANTITY)(.+)", Pattern.DOTALL);

    public String getHeader(String textualCertificate) {
        return getFirstGroup(specification, textualCertificate, "The header is not found in the certificate");
    }

    public String getChemicalAnalysis(String textualCertificate) {
        return getFirstGroup(chemicalAnalysis, textualCertificate, "The chemical analysis is not found in the certificate");
    }

    public String getMechanicalProperties(String textualCertificate) {
        return getFirstGroup(mechanicalProperties, textualCertificate, "The mechanical properties are not found in the certificate");
    }

    public String getCrateContent(String textualCertificate) {
        return getFirstGroup(crateContent, textualCertificate, "The crate content is not found in the certificate");
    }

    private String getFirstGroup(Pattern pattern, String input, String errorMessage) {
        return getGroup(pattern, input, 1, errorMessage);
    }

    private String getGroup(Pattern pattern, String input, int groupNumber, String errorMessage) {
        Matcher matcher = pattern.matcher(input);
        boolean isFound = matcher.find();

        if (!isFound) {
            throw new IllegalAlerisCertificateException(errorMessage);
        }

        return matcher.group(groupNumber).trim();
    }
}
