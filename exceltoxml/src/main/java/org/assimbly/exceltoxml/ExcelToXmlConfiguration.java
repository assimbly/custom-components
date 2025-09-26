package org.assimbly.exceltoxml;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.assimbly.util.helper.Base64Helper;
import org.assimbly.exceltoxml.domain.ExcelRule;
import org.assimbly.exceltoxml.exception.Excel2XmlException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
    public List<ExcelRule> getReadRules() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<ExcelRule>> typeRef = new TypeReference<List<ExcelRule>>() {};


        System.out.println("rules: " + rules);
        List<ExcelRule> excelRules = mapper.readValue(rules, typeRef);

        // Now you have the list of objects directly, no need for the inner loop and second deserialization
        for (ExcelRule rule : excelRules) {
            System.out.println("Rule Name: " + rule.getName()); // Example of accessing a property
        }

        return excelRules;

    }

    /*
    public List<ExcelRule> getReadRules() {
        byte[] json = Base64Helper.unmarshal(rules);

        System.out.println("getReadRules");
        String jsonString = new String(json, StandardCharsets.UTF_8);
        System.out.println(jsonString);

        return deserializeRules(json);
    }

    @JsonCreator
    public List<ExcelRule> deserializeRules(byte[] json) {

        ObjectMapper mapper = new ObjectMapper();
        List<ExcelRule> rules = new ArrayList<>();


    }

     */

}
