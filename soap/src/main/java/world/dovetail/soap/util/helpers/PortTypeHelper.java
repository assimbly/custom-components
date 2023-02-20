package world.dovetail.soap.util.helpers;

import javax.wsdl.Input;
import javax.wsdl.Operation;
import javax.wsdl.PortType;

public final class PortTypeHelper {

    public static Input input(PortType portType, String action) {
        Operation operation;

        if (action.contains("/")) {
            operation = portType.getOperation(action.split("/")[1], null, null);

            if(operation == null)
                return null;

            return operation.getInput();
        } else {
            operation = portType.getOperation(action, null, null);

            if(operation == null)
                return null;

            return operation.getInput();
        }
    }
}
