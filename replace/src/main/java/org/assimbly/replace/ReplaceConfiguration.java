package org.assimbly.replace;

import java.util.*;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

@UriParams
public class ReplaceConfiguration {

    @UriParam
    @Metadata(required = true)
    private String regex;

    @UriParam
    @Metadata(required = true)
    private String replaceWith;

    @UriParam
    private int group;

    @UriParam
    private String flags;

    public ReplaceConfiguration() {
        // Used for serialization or reflection
    }

    /**
     * Regex pattern to match what you want to be replaced.
     */
    public void setRegex(String regex) {
        this.regex = regex;
    }

    /**
     * Text you want the match(es) to be replaced with.
     */
    public void setReplaceWith(String replaceWith) {
        this.replaceWith = replaceWith;
    }

    /**
     * Optional: Group of the regex match you want to be replaced.
     */
    public void setGroup(int group) {
        this.group = group;
    }

    /**
     * Optional: Flags that should be used matching the regex pattern.
     */
    public void setFlags(String flags) {
        this.flags = flags;
    }

    public String getRegex() {
        return regex;
    }

    public String getReplaceWith() {
        return replaceWith;
    }

    public int getGroup() {
        return group;
    }

    public List<String> getFlags() {
        String[] flagsArray = new String[]{};

        if(flags != null) {
            if(flags.startsWith("[") && flags.endsWith("]")){
                String flagsCommaSeparatedList = flags.trim().substring(1, flags.length() - 1);
                flagsArray = flagsCommaSeparatedList.split(",");
            }else{
                flagsArray = flags.split(",");
            }

        }

        return Arrays.asList(flagsArray);
    }

    int getFlagsMagicConstant() {
        List<Integer> usedFlags = new ArrayList<>();

        for (String flag : getFlagBits().keySet()) {
            if(getFlags().contains(flag))
                usedFlags.add(getFlagBits().get(flag));
        }

        return usedFlags.stream().reduce(0, (a, b) -> a | b);
    }

    private static Map<String, Integer> getFlagBits() {

        Map<String, Integer> flags = new ConcurrentHashMap<>();

        flags.put("i", Pattern.CASE_INSENSITIVE);
        flags.put("m", Pattern.MULTILINE);
        flags.put("s", Pattern.DOTALL);

        return flags;

    }

}
