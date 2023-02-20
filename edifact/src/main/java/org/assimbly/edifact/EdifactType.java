package org.assimbly.edifact;

import org.milyn.edi.unedifact.d00a.D00AInterchangeFactory;
import org.milyn.edi.unedifact.d00b.D00BInterchangeFactory;
import org.milyn.edi.unedifact.d01a.D01AInterchangeFactory;
import org.milyn.edi.unedifact.d01b.D01BInterchangeFactory;
import org.milyn.edi.unedifact.d01c.D01CInterchangeFactory;
import org.milyn.edi.unedifact.d02a.D02AInterchangeFactory;
import org.milyn.edi.unedifact.d02b.D02BInterchangeFactory;
import org.milyn.edi.unedifact.d03a.D03AInterchangeFactory;
import org.milyn.edi.unedifact.d03b.D03BInterchangeFactory;
import org.milyn.edi.unedifact.d04a.D04AInterchangeFactory;
import org.milyn.edi.unedifact.d04b.D04BInterchangeFactory;
import org.milyn.edi.unedifact.d05a.D05AInterchangeFactory;
import org.milyn.edi.unedifact.d05b.D05BInterchangeFactory;
import org.milyn.edi.unedifact.d06a.D06AInterchangeFactory;
import org.milyn.edi.unedifact.d06b.D06BInterchangeFactory;
import org.milyn.edi.unedifact.d07b.D07BInterchangeFactory;
import org.milyn.edi.unedifact.d08a.D08AInterchangeFactory;
import org.milyn.edi.unedifact.d08b.D08BInterchangeFactory;
import org.milyn.edi.unedifact.d09a.D09AInterchangeFactory;
import org.milyn.edi.unedifact.d09b.D09BInterchangeFactory;
import org.milyn.edi.unedifact.d10a.D10AInterchangeFactory;
import org.milyn.edi.unedifact.d10b.D10BInterchangeFactory;
import org.milyn.edi.unedifact.d11a.D11AInterchangeFactory;
import org.milyn.edi.unedifact.d11b.D11BInterchangeFactory;
import org.milyn.edi.unedifact.d12a.D12AInterchangeFactory;
import org.milyn.edi.unedifact.d12b.D12BInterchangeFactory;
import org.milyn.edi.unedifact.d13a.D13AInterchangeFactory;
import org.milyn.edi.unedifact.d13b.D13BInterchangeFactory;
import org.milyn.edi.unedifact.d14a.D14AInterchangeFactory;
import org.milyn.edi.unedifact.d14b.D14BInterchangeFactory;
import org.milyn.edi.unedifact.d93a.D93AInterchangeFactory;
import org.milyn.edi.unedifact.d94a.D94AInterchangeFactory;
import org.milyn.edi.unedifact.d94b.D94BInterchangeFactory;
import org.milyn.edi.unedifact.d95a.D95AInterchangeFactory;
import org.milyn.edi.unedifact.d95b.D95BInterchangeFactory;
import org.milyn.edi.unedifact.d96a.D96AInterchangeFactory;
import org.milyn.edi.unedifact.d96b.D96BInterchangeFactory;
import org.milyn.edi.unedifact.d97a.D97AInterchangeFactory;
import org.milyn.edi.unedifact.d97b.D97BInterchangeFactory;
import org.milyn.edi.unedifact.d98a.D98AInterchangeFactory;
import org.milyn.edi.unedifact.d98b.D98BInterchangeFactory;
import org.milyn.edi.unedifact.d99a.D99AInterchangeFactory;
import org.milyn.edi.unedifact.d99b.D99BInterchangeFactory;
import org.milyn.smooks.edi.unedifact.model.UNEdifactInterchangeFactory;
import org.xml.sax.SAXException;

import java.io.IOException;

public enum EdifactType {

    D00A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D00AInterchangeFactory.getInstance();
        }
    },

    D00B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D00BInterchangeFactory.getInstance();
        }
    },

    D01A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D01AInterchangeFactory.getInstance();
        }
    },

    D01B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D01BInterchangeFactory.getInstance();
        }
    },

    D01C {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D01CInterchangeFactory.getInstance();
        }
    },

    D02A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D02AInterchangeFactory.getInstance();
        }
    },

    D02B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D02BInterchangeFactory.getInstance();
        }
    },

    D03A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D03AInterchangeFactory.getInstance();
        }
    },

    D03B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D03BInterchangeFactory.getInstance();
        }
    },

    D04A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D04AInterchangeFactory.getInstance();
        }
    },

    D04B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D04BInterchangeFactory.getInstance();
        }
    },

    D05A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D05AInterchangeFactory.getInstance();
        }
    },

    D05B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D05BInterchangeFactory.getInstance();
        }
    },

    D06A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D06AInterchangeFactory.getInstance();
        }
    },

    D06B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D06BInterchangeFactory.getInstance();
        }
    },

    D07B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D07BInterchangeFactory.getInstance();
        }
    },

    D08A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D08AInterchangeFactory.getInstance();
        }
    },

    D08B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D08BInterchangeFactory.getInstance();
        }
    },

    D09A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D09AInterchangeFactory.getInstance();
        }
    },

    D09B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D09BInterchangeFactory.getInstance();
        }
    },

    D10A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D10AInterchangeFactory.getInstance();
        }
    },

    D10B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D10BInterchangeFactory.getInstance();
        }
    },

    D11A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D11AInterchangeFactory.getInstance();
        }
    },

    D11B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D11BInterchangeFactory.getInstance();
        }
    },

    D12A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D12AInterchangeFactory.getInstance();
        }
    },

    D12B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D12BInterchangeFactory.getInstance();
        }
    },

    D13A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D13AInterchangeFactory.getInstance();
        }
    },

    D13B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D13BInterchangeFactory.getInstance();
        }
    },

    D14A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D14AInterchangeFactory.getInstance();
        }
    },

    D14B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D14BInterchangeFactory.getInstance();
        }
    },

    D93A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D93AInterchangeFactory.getInstance();
        }
    },

    D94A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D94AInterchangeFactory.getInstance();
        }
    },

    D94B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D94BInterchangeFactory.getInstance();
        }
    },

    D95A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D95AInterchangeFactory.getInstance();
        }
    },

    D95B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D95BInterchangeFactory.getInstance();
        }
    },

    D96A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D96AInterchangeFactory.getInstance();
        }
    },

    D96B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D96BInterchangeFactory.getInstance();
        }
    },

    D97A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D97AInterchangeFactory.getInstance();
        }
    },

    D97B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D97BInterchangeFactory.getInstance();
        }
    },

    D98A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D98AInterchangeFactory.getInstance();
        }
    },

    D98B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D98BInterchangeFactory.getInstance();
        }
    },

    D99A {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D99AInterchangeFactory.getInstance();
        }
    },

    D99B {
        @Override
        public UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException {
            return D99BInterchangeFactory.getInstance();
        }
    };

    public abstract UNEdifactInterchangeFactory interchangeFactory() throws IOException, SAXException;

    public String toString() {
        return name().toLowerCase();
    }

    public String urn() {
        return String.format("urn:org.milyn.edi.unedifact:%s-mapping:*", toString());
    }

    public String bindingConfigUri() {
        return String.format("/org/milyn/edi/unedifact/%s/interchange-bindingconfig.xml", toString());
    }

    public static EdifactType byName(String name) {
        for(EdifactType type: values()) {
            if(type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }
}
