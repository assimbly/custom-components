package world.dovetail.soap.util.helpers;

import javax.wsdl.BindingOperation;
import javax.wsdl.extensions.soap.SOAPOperation;
import javax.wsdl.extensions.soap12.SOAP12Operation;
import java.util.List;

public final class BindingOperationHelper {

    public static String getOperationAction(BindingOperation operation){
        List<?> exElem = operation.getExtensibilityElements();

        for (Object el : exElem) {
            if (el instanceof SOAPOperation)
                return ((SOAPOperation) el).getSoapActionURI();

            if (el instanceof SOAP12Operation)
                return ((SOAP12Operation) el).getSoapActionURI();
        }

        return null;
    }
}
