package world.dovetail.csvtoxml.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@XStreamAlias("items")
public class Items {

    @XStreamImplicit
    private List<AnonymousObject> aObjects;

    @XStreamImplicit(itemFieldName="item")
    private List<HashMap<String, Object>> objects;

    public Items() {
        aObjects = new ArrayList<>();
        objects = new ArrayList<>();
    }

    public List<AnonymousObject> getAObjects() {
        return aObjects;
    }

    public void setAObjects(List<AnonymousObject> objects) {
        this.aObjects = objects;
    }

    public void addAObject(AnonymousObject object){
        this.aObjects.add(object);
    }

    public List<HashMap<String, Object>> getObjects() {
        return objects;
    }

    public void setObjects(List<HashMap<String, Object>> objects) {
        this.objects = objects;
    }
}
