package org.assimbly.soap.util.helpers;

import com.ibm.wsdl.extensions.soap.SOAPBodyImpl;
import com.ibm.wsdl.extensions.soap.SOAPHeaderImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12BodyImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12HeaderImpl;

import javax.wsdl.BindingInput;
import javax.wsdl.Message;
import javax.wsdl.Part;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.soap.SOAPHeader;
import javax.wsdl.extensions.soap12.SOAP12Header;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class BindingInputHelper {

    public static SOAPBodyImpl getSoapBody(BindingInput input) {
        List<?> exElem = input.getExtensibilityElements();

        for (Object el : exElem) {
            if (el instanceof SOAPBodyImpl) {
                return (SOAPBodyImpl) el;
            }
        }

        return null;
    }

    public static SOAP12BodyImpl getSoap12Body(BindingInput input) {
        List<?> exElem = input.getExtensibilityElements();

        for (Object el : exElem) {
            if (el instanceof SOAP12BodyImpl) {
                return (SOAP12BodyImpl) el;
            }
        }

        return null;
    }

    public static Part getHeaderPart(BindingInput bindingInput, Map<?, ?> messages, String element){
        List<?> exElem = bindingInput.getExtensibilityElements();

        for (Object el : exElem) {
            if (el instanceof SOAPHeader) {
                SOAPHeader header = (SOAPHeader) el;
                Message message = (Message) messages.get(header.getMessage());
                Part part = message.getPart(header.getPart());

                if(part.getElementName().getLocalPart().equals(element))
                    return part;
            }

            if (el instanceof SOAP12Header) {
                SOAP12Header header = (SOAP12Header) el;
                Message message = (Message) messages.get(header.getMessage());
                Part part = message.getPart(header.getPart());

                if(part.getElementName().getLocalPart().equals(element))
                    return part;
            }
        }

        return null;
    }

    public static List<SOAPHeaderImpl> getSoapHeaders(BindingInput bindingInput){
        List<SOAPHeaderImpl> result = new ArrayList<>();

        List<?> exElem = bindingInput.getExtensibilityElements();

        for (Object el : exElem) {
            if (el instanceof SOAPHeaderImpl) {
                result.add((SOAPHeaderImpl) el);
            }
        }

        return result;
    }

    public static List<SOAP12HeaderImpl> getSoap12Headers(BindingInput bindingInput){
        List<SOAP12HeaderImpl> result = new ArrayList<>();

        List<?> exElem = bindingInput.getExtensibilityElements();

        for (Object el : exElem) {
            if (el instanceof SOAP12HeaderImpl) {
                result.add((SOAP12HeaderImpl) el);
            }
        }

        return result;
    }
}
