package org.assimbly.soap.util.helpers;

import org.w3c.dom.Node;

import javax.wsdl.Input;
import javax.wsdl.Part;
import java.util.ArrayList;
import java.util.List;

public final class PartHelper {

    public static boolean containsTypes(Input input){
        for(Object key: input.getMessage().getParts().keySet()) {
           Part part = (Part) input.getMessage().getParts().get(key);

           if(part.getTypeName() != null) {
               return true;
           }
        }

        return false;
    }

    public static boolean containsElements(Input input) {
        for(Object key: input.getMessage().getParts().keySet()) {
            Part part = (Part) input.getMessage().getParts().get(key);

            if(part.getElementName() != null) {
                return true;
            }
        }

        return false;
    }

    public static List<Part> getTypes(Input input) {
        List<Part> parts = new ArrayList<>();

        for(Object key: input.getMessage().getParts().keySet()) {
            Part part = (Part) input.getMessage().getParts().get(key);

            if(part.getTypeName() != null) {
                parts.add(part);
            }
        }

        return parts;
    }

    public static List<Part> getElements(Input input) {
        List<Part> parts = new ArrayList<>();

        for(Object key: input.getMessage().getParts().keySet()) {
            Part part = (Part) input.getMessage().getParts().get(key);

            if(part.getElementName() != null) {
                parts.add(part);
            }
        }

        return parts;
    }
}
