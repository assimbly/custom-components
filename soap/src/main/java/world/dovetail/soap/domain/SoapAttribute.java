package world.dovetail.soap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SoapAttribute {

    @JsonIgnore
    private String _id;

    private String name;
    private String value;

    public SoapAttribute() {}

    public SoapAttribute(String name) {
        this.name = name;
    }

    public SoapAttribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }
    public String getValue() { return value; }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
