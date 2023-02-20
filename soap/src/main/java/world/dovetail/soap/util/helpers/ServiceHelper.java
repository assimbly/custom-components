package world.dovetail.soap.util.helpers;

import javax.wsdl.Binding;
import javax.wsdl.Port;
import javax.wsdl.Service;

public final class ServiceHelper {

    public static Port portByBinding(Service service, Binding binding){
        for (Object s : service.getPorts().keySet()) {
            Port port = (Port) service.getPorts().get(s);

            if(port.getBinding() == binding){
                return port;
            }
        }

        return null;
    }

}
