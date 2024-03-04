package org.assimbly.jsontoxmllegacy.transaction;

import org.assimbly.jsontoxmllegacy.JsonToXmlConfiguration;
import org.w3c.dom.Element;

public interface NodeTransaction {

    Element process(JsonToXmlConfiguration config);

}
