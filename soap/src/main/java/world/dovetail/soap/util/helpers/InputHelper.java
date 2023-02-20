package world.dovetail.soap.util.helpers;

import javax.wsdl.Input;
import javax.wsdl.Part;
import javax.xml.namespace.QName;

public final class InputHelper {

    public static QName getMessagePart(Input input) {
        Part part = input.getMessage().getPart("parameters");

        if (part == null) {
            String first = (String) input.getMessage().getParts().keySet().iterator().next();
            part = (Part) input.getMessage().getParts().get(first);
        }

        if(part.getElementName() != null) {
            return part.getElementName();
        }

        if(part.getTypeName() != null) {
            return part.getTypeName();
        }

        throw new RuntimeException("Could not find message part element or type.");
    }
}
