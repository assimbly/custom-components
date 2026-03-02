package org.assimbly.soap.util.helpers;

import javax.wsdl.BindingOperation;
import javax.wsdl.extensions.soap.SOAPOperation;
import javax.wsdl.extensions.soap12.SOAP12Operation;
import java.util.List;

public final class BindingOperationHelper {

    public static String getOperationAction(BindingOperation operation){
        List<?> exElem = operation.getExtensibilityElements();

        for (Object el : exElem) {
            if (el instanceof SOAPOperation pOperation)
                return pOperation.getSoapActionURI();

            if (el instanceof SOAP12Operation p12Operation)
                return p12Operation.getSoapActionURI();
        }

        return null;
    }
}
