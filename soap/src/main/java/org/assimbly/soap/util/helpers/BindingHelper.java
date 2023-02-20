package org.assimbly.soap.util.helpers;

import javax.wsdl.Binding;
import javax.wsdl.BindingOperation;
import java.util.Map;

public final class BindingHelper {

    public static BindingOperation operation(Binding binding, String action) {
        return binding.getBindingOperation(action, null, null);
    }

}
