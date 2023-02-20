package org.assimbly.exceltoxml;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.assimbly.util.helper.Base64Helper;
import org.assimbly.exceltoxml.domain.ExcelRule;
import org.assimbly.exceltoxml.exception.Excel2XmlException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelToXmlConfiguration {

    @UriParam
    @Metadata(required = true)
    private String encoding;

    @UriParam
    @Metadata(required = true)
    private String rules;

    public ExcelToXmlConfiguration() {}

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
    public List<ExcelRule> getReadRules() {
        byte[] json = Base64Helper.unmarshal(rules);
        return deserializeRules(json);
    }

    @JsonCreator
    public List<ExcelRule> deserializeRules(byte[] json) {

        ObjectMapper mapper = new ObjectMapper();
        List<ExcelRule> rules = new ArrayList<>();

        try {
            @SuppressWarnings("unchecked")
            List<String> rulesJson = mapper.readValue(json, List.class);

            for (String rule : rulesJson) {
                rules.add(mapper.readValue(rule, ExcelRule.class));
            }
        } catch (IOException e) {
            throw new Excel2XmlException("Unable to deserialize rules: " + e.getMessage());
        }

        return rules;
    }
}
