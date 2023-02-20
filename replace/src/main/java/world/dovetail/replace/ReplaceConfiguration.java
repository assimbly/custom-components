package world.dovetail.replace;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.assimbly.util.helper.Base64Helper;

import java.nio.charset.StandardCharsets;
import java.util.*;
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

    public ReplaceConfiguration() {}

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
        return Base64Helper.unmarshal(regex, StandardCharsets.UTF_8);
    }

    public String getReplaceWith() {
        return Base64Helper.unmarshal(replaceWith, StandardCharsets.UTF_8);
    }

    public int getGroup() {
        return group;
    }

    public List<String> getFlags() {
        String[] flagsArray = new String[]{};

        if(flags != null) {
            flagsArray = flags.split(",");
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

        return new HashMap<String, Integer>() {{
            put("i", Pattern.CASE_INSENSITIVE);
            put("m", Pattern.MULTILINE);
            put("s", Pattern.DOTALL);
        }};
    }
}
