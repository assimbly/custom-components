package world.dovetail.soap.util.helpers;

import javax.wsdl.Port;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.soap.SOAPAddress;
import javax.wsdl.extensions.soap12.SOAP12Address;

public final class PortHelper {

    public static ExtensibilityElement address(Port port){
        for (int i = 0; i < port.getExtensibilityElements().size(); i++) {
            ExtensibilityElement el = (ExtensibilityElement) port.getExtensibilityElements().get(i);

            if(el instanceof SOAP12Address || el instanceof SOAPAddress){
                return el;
            }
        }

        return null;
    }

}
