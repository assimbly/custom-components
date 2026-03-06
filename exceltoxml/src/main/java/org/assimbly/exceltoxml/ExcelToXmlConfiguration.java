package org.assimbly.exceltoxml;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import tools.jackson.core.JacksonException;
import org.assimbly.exceltoxml.domain.ExcelRule;
import java.util.List;

public class ExcelToXmlConfiguration {

    @UriParam
    @Metadata(required = true)
    private String encoding;

    @UriParam
    @Metadata(required = true)
    private String rules;

    public ExcelToXmlConfiguration() {
        //Used for serialization
    }

    /**
     * Charset to use when converting Excel contents to XML
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getEncoding() {
        return encoding;
    }


    /**
     * Base64 encoded excel rules set by the user
     */
    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }


    /**
     * Deserialized rules
     */
    public List<ExcelRule> getReadRules() throws JacksonException {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<ExcelRule>> typeRef = new TypeReference<List<ExcelRule>>() {};

        return mapper.readValue(rules, typeRef);

    }

}
