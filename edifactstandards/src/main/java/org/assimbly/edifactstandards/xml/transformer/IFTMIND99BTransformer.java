package org.assimbly.edifactstandards.xml.transformer;

import org.assimbly.edifactcommon.mapforce.IEnumerable;
import org.assimbly.edifactcommon.mapforce.IEnumerator;
import org.assimbly.edifactcommon.xml.XmlTreeOperations;
import org.assimbly.edifactstandards.xml.envelope.IFTMIND99BEnvelope;

public class IFTMIND99BTransformer extends org.assimbly.edifactcommon.TraceProvider
{
    private boolean runDoesCloseAll = true;
    public void setCloseObjectsAfterRun(boolean c) {runDoesCloseAll = c;}
    public boolean getCloseObjectsAfterRun() {return runDoesCloseAll;}


    static class main implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_IFTMIN_D99B_Instance;

        public main(org.assimbly.edifactcommon.mapforce.IMFNode var1_IFTMIN_D99B_Instance)
        {
            this.var1_IFTMIN_D99B_Instance = var1_IFTMIN_D99B_Instance;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 2;
            Object current;
            main closure;
            IEnumerator var2_Envelope;
            public Enumerator(main closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 4:	if (moveNext_4()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_2() throws Exception {
                state = 3;
                var2_Envelope = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("Envelope", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_IFTMIN_D99B_Instance)).enumerator();
                return false;
            }
            private boolean moveNext_3() throws Exception {
                state = 3;
                if (!var2_Envelope.moveNext()) {state = 4; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("Envelope", (new seq1_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_Envelope.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_4() throws Exception {
                state = 0;
                if( var2_Envelope != null ) { var2_Envelope.close(); var2_Envelope = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_Envelope != null ) { var2_Envelope.close(); var2_Envelope = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq1_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq1_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq1_map closure;
            IEnumerator var2_Interchange;
            public Enumerator(seq1_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_Interchange = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("Interchange", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_Interchange.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("Interchange", (new seq2_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_Interchange.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_Interchange != null ) { var2_Interchange.close(); var2_Interchange = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_Interchange != null ) { var2_Interchange.close(); var2_Interchange = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq2_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq2_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq2_join closure;
            IEnumerator var2_UNB;
            IEnumerator var3_Group;
            IEnumerator var4_UNZ;
            public Enumerator(seq2_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_UNB = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNB", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_UNB.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("UNB", (new seq3_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_UNB.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_UNB != null ) { var2_UNB.close(); var2_UNB = null; }
                var3_Group = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("Group", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_Group.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("Group", (new seq9_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_Group.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_Group != null ) { var3_Group.close(); var3_Group = null; }
                var4_UNZ = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNZ", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_UNZ.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("UNZ", (new seq151_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_UNZ.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_UNZ != null ) { var4_UNZ.close(); var4_UNZ = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_UNB != null ) { var2_UNB.close(); var2_UNB = null; }
                    if( var3_Group != null ) { var3_Group.close(); var3_Group = null; }
                    if( var4_UNZ != null ) { var4_UNZ.close(); var4_UNZ = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq3_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq3_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq3_join closure;
            IEnumerator var2_F0020;
            IEnumerator var3_F0026;
            IEnumerator var4_F0029;
            IEnumerator var5_F0031;
            IEnumerator var6_F0032;
            IEnumerator var7_F0035;
            IEnumerator var8_S001;
            IEnumerator var9_S002;
            IEnumerator var10_S003;
            IEnumerator var11_S004;
            IEnumerator var12_S005;
            public Enumerator(seq3_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 27:	if (moveNext_27()) return true; break;
                        case 29:	if (moveNext_29()) return true; break;
                        case 30:	if (moveNext_30()) return true; break;
                        case 32:	if (moveNext_32()) return true; break;
                        case 33:	if (moveNext_33()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0020 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0020", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0020.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0020", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0020.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0020 != null ) { var2_F0020.close(); var2_F0020 = null; }
                var3_F0026 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0026", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0026.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0026", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0026.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F0026 != null ) { var3_F0026.close(); var3_F0026 = null; }
                var4_F0029 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0029", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F0029.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0029", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F0029.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F0029 != null ) { var4_F0029.close(); var4_F0029 = null; }
                var5_F0031 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0031", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F0031.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0031", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F0031.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F0031 != null ) { var5_F0031.close(); var5_F0031 = null; }
                var6_F0032 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0032", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F0032.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0032", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F0032.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_F0032 != null ) { var6_F0032.close(); var6_F0032 = null; }
                var7_F0035 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0035", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_F0035.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0035", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_F0035.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_F0035 != null ) { var7_F0035.close(); var7_F0035 = null; }
                var8_S001 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S001", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_S001.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("S001", (new seq4_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_S001.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_S001 != null ) { var8_S001.close(); var8_S001 = null; }
                var9_S002 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S002", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_S002.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("S002", (new seq5_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_S002.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_S002 != null ) { var9_S002.close(); var9_S002 = null; }
                var10_S003 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S003", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_S003.moveNext()) {state = 27; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("S003", (new seq6_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_S003.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 29;
                if( var10_S003 != null ) { var10_S003.close(); var10_S003 = null; }
                var11_S004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S004", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 29;
                if (!var11_S004.moveNext()) {state = 30; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("S004", (new seq7_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_S004.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_30() throws Exception {
                state = 32;
                if( var11_S004 != null ) { var11_S004.close(); var11_S004 = null; }
                var12_S005 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S005", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_32() throws Exception {
                state = 32;
                if (!var12_S005.moveNext()) {state = 33; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("S005", (new seq8_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var12_S005.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_33() throws Exception {
                state = 0;
                if( var12_S005 != null ) { var12_S005.close(); var12_S005 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0020 != null ) { var2_F0020.close(); var2_F0020 = null; }
                    if( var3_F0026 != null ) { var3_F0026.close(); var3_F0026 = null; }
                    if( var4_F0029 != null ) { var4_F0029.close(); var4_F0029 = null; }
                    if( var5_F0031 != null ) { var5_F0031.close(); var5_F0031 = null; }
                    if( var6_F0032 != null ) { var6_F0032.close(); var6_F0032 = null; }
                    if( var7_F0035 != null ) { var7_F0035.close(); var7_F0035 = null; }
                    if( var8_S001 != null ) { var8_S001.close(); var8_S001 = null; }
                    if( var9_S002 != null ) { var9_S002.close(); var9_S002 = null; }
                    if( var10_S003 != null ) { var10_S003.close(); var10_S003 = null; }
                    if( var11_S004 != null ) { var11_S004.close(); var11_S004 = null; }
                    if( var12_S005 != null ) { var12_S005.close(); var12_S005 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq4_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq4_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq4_join closure;
            IEnumerator var2_F0001;
            IEnumerator var3_F0002;
            IEnumerator var4_F0080;
            IEnumerator var5_F0133;
            IEnumerator var6_F0076;
            public Enumerator(seq4_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0001 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0001", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0001.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0001", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0001.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0001 != null ) { var2_F0001.close(); var2_F0001 = null; }
                var3_F0002 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0002", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0002.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0002", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0002.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F0002 != null ) { var3_F0002.close(); var3_F0002 = null; }
                var4_F0080 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0080", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F0080.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0080", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F0080.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F0080 != null ) { var4_F0080.close(); var4_F0080 = null; }
                var5_F0133 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0133", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F0133.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0133", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F0133.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F0133 != null ) { var5_F0133.close(); var5_F0133 = null; }
                var6_F0076 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0076", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F0076.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0076", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F0076.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_F0076 != null ) { var6_F0076.close(); var6_F0076 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0001 != null ) { var2_F0001.close(); var2_F0001 = null; }
                    if( var3_F0002 != null ) { var3_F0002.close(); var3_F0002 = null; }
                    if( var4_F0080 != null ) { var4_F0080.close(); var4_F0080 = null; }
                    if( var5_F0133 != null ) { var5_F0133.close(); var5_F0133 = null; }
                    if( var6_F0076 != null ) { var6_F0076.close(); var6_F0076 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq5_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq5_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq5_join closure;
            IEnumerator var2_F0004;
            IEnumerator var3_F0007;
            IEnumerator var4_F0008;
            IEnumerator var5_F0042;
            public Enumerator(seq5_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0004", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0004.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0004", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0004.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0004 != null ) { var2_F0004.close(); var2_F0004 = null; }
                var3_F0007 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0007", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0007.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0007", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0007.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F0007 != null ) { var3_F0007.close(); var3_F0007 = null; }
                var4_F0008 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0008", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F0008.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0008", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F0008.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F0008 != null ) { var4_F0008.close(); var4_F0008 = null; }
                var5_F0042 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0042", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F0042.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0042", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F0042.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F0042 != null ) { var5_F0042.close(); var5_F0042 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0004 != null ) { var2_F0004.close(); var2_F0004 = null; }
                    if( var3_F0007 != null ) { var3_F0007.close(); var3_F0007 = null; }
                    if( var4_F0008 != null ) { var4_F0008.close(); var4_F0008 = null; }
                    if( var5_F0042 != null ) { var5_F0042.close(); var5_F0042 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq6_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq6_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq6_join closure;
            IEnumerator var2_F0010;
            IEnumerator var3_F0007;
            IEnumerator var4_F0014;
            IEnumerator var5_F0046;
            public Enumerator(seq6_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0010 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0010", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0010.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0010", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0010.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0010 != null ) { var2_F0010.close(); var2_F0010 = null; }
                var3_F0007 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0007", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0007.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0007", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0007.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F0007 != null ) { var3_F0007.close(); var3_F0007 = null; }
                var4_F0014 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0014", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F0014.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0014", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F0014.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F0014 != null ) { var4_F0014.close(); var4_F0014 = null; }
                var5_F0046 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0046", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F0046.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0046", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F0046.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F0046 != null ) { var5_F0046.close(); var5_F0046 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0010 != null ) { var2_F0010.close(); var2_F0010 = null; }
                    if( var3_F0007 != null ) { var3_F0007.close(); var3_F0007 = null; }
                    if( var4_F0014 != null ) { var4_F0014.close(); var4_F0014 = null; }
                    if( var5_F0046 != null ) { var5_F0046.close(); var5_F0046 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq7_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq7_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq7_join closure;
            IEnumerator var2_F0017;
            IEnumerator var3_F0019;
            public Enumerator(seq7_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0017 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0017", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0017.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0017", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0017.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0017 != null ) { var2_F0017.close(); var2_F0017 = null; }
                var3_F0019 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0019", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0019.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0019", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0019.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F0019 != null ) { var3_F0019.close(); var3_F0019 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0017 != null ) { var2_F0017.close(); var2_F0017 = null; }
                    if( var3_F0019 != null ) { var3_F0019.close(); var3_F0019 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq8_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq8_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq8_join closure;
            IEnumerator var2_F0022;
            IEnumerator var3_F0025;
            public Enumerator(seq8_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0022 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0022", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0022.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0022", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0022.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0022 != null ) { var2_F0022.close(); var2_F0022 = null; }
                var3_F0025 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0025", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0025.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0025", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0025.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F0025 != null ) { var3_F0025.close(); var3_F0025 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0022 != null ) { var2_F0022.close(); var2_F0022 = null; }
                    if( var3_F0025 != null ) { var3_F0025.close(); var3_F0025 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq9_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq9_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq9_join closure;
            IEnumerator var2_UNG;
            IEnumerator var3_Message_IFTMIN;
            IEnumerator var4_UNE;
            public Enumerator(seq9_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_UNG = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNG", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_UNG.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("UNG", (new seq10_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_UNG.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_UNG != null ) { var2_UNG.close(); var2_UNG = null; }
                var3_Message_IFTMIN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("Message_IFTMIN", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_Message_IFTMIN.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("Message_IFTMIN", (new seq14_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_Message_IFTMIN.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_Message_IFTMIN != null ) { var3_Message_IFTMIN.close(); var3_Message_IFTMIN = null; }
                var4_UNE = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNE", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_UNE.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("UNE", (new seq150_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_UNE.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_UNE != null ) { var4_UNE.close(); var4_UNE = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_UNG != null ) { var2_UNG.close(); var2_UNG = null; }
                    if( var3_Message_IFTMIN != null ) { var3_Message_IFTMIN.close(); var3_Message_IFTMIN = null; }
                    if( var4_UNE != null ) { var4_UNE.close(); var4_UNE = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq10_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq10_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq10_join closure;
            IEnumerator var2_F0038;
            IEnumerator var3_F0048;
            IEnumerator var4_F0051;
            IEnumerator var5_F0058;
            IEnumerator var6_S006;
            IEnumerator var7_S007;
            IEnumerator var8_S004;
            IEnumerator var9_S008;
            public Enumerator(seq10_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0038 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0038", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0038.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0038", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0038.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0038 != null ) { var2_F0038.close(); var2_F0038 = null; }
                var3_F0048 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0048", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0048.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0048", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0048.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F0048 != null ) { var3_F0048.close(); var3_F0048 = null; }
                var4_F0051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0051", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F0051.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0051", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F0051.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F0051 != null ) { var4_F0051.close(); var4_F0051 = null; }
                var5_F0058 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0058", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F0058.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0058", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F0058.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F0058 != null ) { var5_F0058.close(); var5_F0058 = null; }
                var6_S006 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S006", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_S006.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("S006", (new seq11_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_S006.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_S006 != null ) { var6_S006.close(); var6_S006 = null; }
                var7_S007 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S007", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_S007.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("S007", (new seq12_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_S007.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_S007 != null ) { var7_S007.close(); var7_S007 = null; }
                var8_S004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S004", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_S004.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("S004", (new seq7_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_S004.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_S004 != null ) { var8_S004.close(); var8_S004 = null; }
                var9_S008 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S008", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_S008.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("S008", (new seq13_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_S008.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 0;
                if( var9_S008 != null ) { var9_S008.close(); var9_S008 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0038 != null ) { var2_F0038.close(); var2_F0038 = null; }
                    if( var3_F0048 != null ) { var3_F0048.close(); var3_F0048 = null; }
                    if( var4_F0051 != null ) { var4_F0051.close(); var4_F0051 = null; }
                    if( var5_F0058 != null ) { var5_F0058.close(); var5_F0058 = null; }
                    if( var6_S006 != null ) { var6_S006.close(); var6_S006 = null; }
                    if( var7_S007 != null ) { var7_S007.close(); var7_S007 = null; }
                    if( var8_S004 != null ) { var8_S004.close(); var8_S004 = null; }
                    if( var9_S008 != null ) { var9_S008.close(); var9_S008 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq11_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq11_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq11_join closure;
            IEnumerator var2_F0040;
            IEnumerator var3_F0007;
            public Enumerator(seq11_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0040 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0040", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0040.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0040", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0040.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0040 != null ) { var2_F0040.close(); var2_F0040 = null; }
                var3_F0007 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0007", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0007.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0007", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0007.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F0007 != null ) { var3_F0007.close(); var3_F0007 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0040 != null ) { var2_F0040.close(); var2_F0040 = null; }
                    if( var3_F0007 != null ) { var3_F0007.close(); var3_F0007 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq12_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq12_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq12_join closure;
            IEnumerator var2_F0044;
            IEnumerator var3_F0007;
            public Enumerator(seq12_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0044 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0044", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0044.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0044", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0044.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0044 != null ) { var2_F0044.close(); var2_F0044 = null; }
                var3_F0007 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0007", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0007.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0007", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0007.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F0007 != null ) { var3_F0007.close(); var3_F0007 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0044 != null ) { var2_F0044.close(); var2_F0044 = null; }
                    if( var3_F0007 != null ) { var3_F0007.close(); var3_F0007 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq13_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq13_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq13_join closure;
            IEnumerator var2_F0052;
            IEnumerator var3_F0054;
            IEnumerator var4_F0057;
            public Enumerator(seq13_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0052 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0052", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0052.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0052", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0052.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0052 != null ) { var2_F0052.close(); var2_F0052 = null; }
                var3_F0054 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0054", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0054.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0054", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0054.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F0054 != null ) { var3_F0054.close(); var3_F0054 = null; }
                var4_F0057 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0057", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F0057.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0057", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F0057.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F0057 != null ) { var4_F0057.close(); var4_F0057 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0052 != null ) { var2_F0052.close(); var2_F0052 = null; }
                    if( var3_F0054 != null ) { var3_F0054.close(); var3_F0054 = null; }
                    if( var4_F0057 != null ) { var4_F0057.close(); var4_F0057 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq14_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq14_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq14_join closure;
            IEnumerator var2_UNH;
            IEnumerator var3_BGM;
            IEnumerator var4_CTA;
            IEnumerator var5_COM;
            IEnumerator var6_DTM;
            IEnumerator var7_TSR;
            IEnumerator var8_CUX;
            IEnumerator var9_MOA;
            IEnumerator var10_FTX;
            IEnumerator var11_CNT;
            IEnumerator var12_DOC;
            IEnumerator var13_GDS;
            IEnumerator var14_SG1;
            IEnumerator var15_SG2;
            IEnumerator var16_SG3;
            IEnumerator var17_SG4;
            IEnumerator var18_SG6;
            IEnumerator var19_SG7;
            IEnumerator var20_SG8;
            IEnumerator var21_SG11;
            IEnumerator var22_SG18;
            IEnumerator var23_SG37;
            IEnumerator var24_UNT;
            public Enumerator(seq14_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 27:	if (moveNext_27()) return true; break;
                        case 29:	if (moveNext_29()) return true; break;
                        case 30:	if (moveNext_30()) return true; break;
                        case 32:	if (moveNext_32()) return true; break;
                        case 33:	if (moveNext_33()) return true; break;
                        case 35:	if (moveNext_35()) return true; break;
                        case 36:	if (moveNext_36()) return true; break;
                        case 38:	if (moveNext_38()) return true; break;
                        case 39:	if (moveNext_39()) return true; break;
                        case 41:	if (moveNext_41()) return true; break;
                        case 42:	if (moveNext_42()) return true; break;
                        case 44:	if (moveNext_44()) return true; break;
                        case 45:	if (moveNext_45()) return true; break;
                        case 47:	if (moveNext_47()) return true; break;
                        case 48:	if (moveNext_48()) return true; break;
                        case 50:	if (moveNext_50()) return true; break;
                        case 51:	if (moveNext_51()) return true; break;
                        case 53:	if (moveNext_53()) return true; break;
                        case 54:	if (moveNext_54()) return true; break;
                        case 56:	if (moveNext_56()) return true; break;
                        case 57:	if (moveNext_57()) return true; break;
                        case 59:	if (moveNext_59()) return true; break;
                        case 60:	if (moveNext_60()) return true; break;
                        case 62:	if (moveNext_62()) return true; break;
                        case 63:	if (moveNext_63()) return true; break;
                        case 65:	if (moveNext_65()) return true; break;
                        case 66:	if (moveNext_66()) return true; break;
                        case 68:	if (moveNext_68()) return true; break;
                        case 69:	if (moveNext_69()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_UNH = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNH", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_UNH.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("UNH", (new seq15_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_UNH.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_UNH != null ) { var2_UNH.close(); var2_UNH = null; }
                var3_BGM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("BGM", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_BGM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("BGM", (new seq21_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_BGM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_BGM != null ) { var3_BGM.close(); var3_BGM = null; }
                var4_CTA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CTA", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_CTA.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("CTA", (new seq24_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_CTA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_CTA != null ) { var4_CTA.close(); var4_CTA = null; }
                var5_COM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("COM", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_COM.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("COM", (new seq26_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_COM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_COM != null ) { var5_COM.close(); var5_COM = null; }
                var6_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_DTM.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq28_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_DTM != null ) { var6_DTM.close(); var6_DTM = null; }
                var7_TSR = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TSR", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_TSR.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TSR", (new seq30_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_TSR.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_TSR != null ) { var7_TSR.close(); var7_TSR = null; }
                var8_CUX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CUX", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_CUX.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("CUX", (new seq35_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_CUX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_CUX != null ) { var8_CUX.close(); var8_CUX = null; }
                var9_MOA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MOA", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_MOA.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MOA", (new seq37_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_MOA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_MOA != null ) { var9_MOA.close(); var9_MOA = null; }
                var10_FTX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FTX", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_FTX.moveNext()) {state = 27; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("FTX", (new seq39_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_FTX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 29;
                if( var10_FTX != null ) { var10_FTX.close(); var10_FTX = null; }
                var11_CNT = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CNT", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 29;
                if (!var11_CNT.moveNext()) {state = 30; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("CNT", (new seq42_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_CNT.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_30() throws Exception {
                state = 32;
                if( var11_CNT != null ) { var11_CNT.close(); var11_CNT = null; }
                var12_DOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DOC", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_32() throws Exception {
                state = 32;
                if (!var12_DOC.moveNext()) {state = 33; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DOC", (new seq44_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var12_DOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_33() throws Exception {
                state = 35;
                if( var12_DOC != null ) { var12_DOC.close(); var12_DOC = null; }
                var13_GDS = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("GDS", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_35() throws Exception {
                state = 35;
                if (!var13_GDS.moveNext()) {state = 36; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("GDS", (new seq46_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var13_GDS.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_36() throws Exception {
                state = 38;
                if( var13_GDS != null ) { var13_GDS.close(); var13_GDS = null; }
                var14_SG1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG1", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_38() throws Exception {
                state = 38;
                if (!var14_SG1.moveNext()) {state = 39; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG1", (new seq47_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var14_SG1.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_39() throws Exception {
                state = 41;
                if( var14_SG1 != null ) { var14_SG1.close(); var14_SG1 = null; }
                var15_SG2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG2", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_41() throws Exception {
                state = 41;
                if (!var15_SG2.moveNext()) {state = 42; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG2", (new seq52_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var15_SG2.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_42() throws Exception {
                state = 44;
                if( var15_SG2 != null ) { var15_SG2.close(); var15_SG2 = null; }
                var16_SG3 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG3", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_44() throws Exception {
                state = 44;
                if (!var16_SG3.moveNext()) {state = 45; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG3", (new seq55_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var16_SG3.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_45() throws Exception {
                state = 47;
                if( var16_SG3 != null ) { var16_SG3.close(); var16_SG3 = null; }
                var17_SG4 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG4", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_47() throws Exception {
                state = 47;
                if (!var17_SG4.moveNext()) {state = 48; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG4", (new seq58_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var17_SG4.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_48() throws Exception {
                state = 50;
                if( var17_SG4 != null ) { var17_SG4.close(); var17_SG4 = null; }
                var18_SG6 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG6", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_50() throws Exception {
                state = 50;
                if (!var18_SG6.moveNext()) {state = 51; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG6", (new seq65_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var18_SG6.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_51() throws Exception {
                state = 53;
                if( var18_SG6 != null ) { var18_SG6.close(); var18_SG6 = null; }
                var19_SG7 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG7", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_53() throws Exception {
                state = 53;
                if (!var19_SG7.moveNext()) {state = 54; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG7", (new seq69_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var19_SG7.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_54() throws Exception {
                state = 56;
                if( var19_SG7 != null ) { var19_SG7.close(); var19_SG7 = null; }
                var20_SG8 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG8", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_56() throws Exception {
                state = 56;
                if (!var20_SG8.moveNext()) {state = 57; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG8", (new seq83_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var20_SG8.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_57() throws Exception {
                state = 59;
                if( var20_SG8 != null ) { var20_SG8.close(); var20_SG8 = null; }
                var21_SG11 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG11", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_59() throws Exception {
                state = 59;
                if (!var21_SG11.moveNext()) {state = 60; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG11", (new seq90_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var21_SG11.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_60() throws Exception {
                state = 62;
                if( var21_SG11 != null ) { var21_SG11.close(); var21_SG11 = null; }
                var22_SG18 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG18", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_62() throws Exception {
                state = 62;
                if (!var22_SG18.moveNext()) {state = 63; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG18", (new seq101_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var22_SG18.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_63() throws Exception {
                state = 65;
                if( var22_SG18 != null ) { var22_SG18.close(); var22_SG18 = null; }
                var23_SG37 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG37", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_65() throws Exception {
                state = 65;
                if (!var23_SG37.moveNext()) {state = 66; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG37", (new seq142_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var23_SG37.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_66() throws Exception {
                state = 68;
                if( var23_SG37 != null ) { var23_SG37.close(); var23_SG37 = null; }
                var24_UNT = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNT", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_68() throws Exception {
                state = 68;
                if (!var24_UNT.moveNext()) {state = 69; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("UNT", (new seq149_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var24_UNT.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_69() throws Exception {
                state = 0;
                if( var24_UNT != null ) { var24_UNT.close(); var24_UNT = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_UNH != null ) { var2_UNH.close(); var2_UNH = null; }
                    if( var3_BGM != null ) { var3_BGM.close(); var3_BGM = null; }
                    if( var4_CTA != null ) { var4_CTA.close(); var4_CTA = null; }
                    if( var5_COM != null ) { var5_COM.close(); var5_COM = null; }
                    if( var6_DTM != null ) { var6_DTM.close(); var6_DTM = null; }
                    if( var7_TSR != null ) { var7_TSR.close(); var7_TSR = null; }
                    if( var8_CUX != null ) { var8_CUX.close(); var8_CUX = null; }
                    if( var9_MOA != null ) { var9_MOA.close(); var9_MOA = null; }
                    if( var10_FTX != null ) { var10_FTX.close(); var10_FTX = null; }
                    if( var11_CNT != null ) { var11_CNT.close(); var11_CNT = null; }
                    if( var12_DOC != null ) { var12_DOC.close(); var12_DOC = null; }
                    if( var13_GDS != null ) { var13_GDS.close(); var13_GDS = null; }
                    if( var14_SG1 != null ) { var14_SG1.close(); var14_SG1 = null; }
                    if( var15_SG2 != null ) { var15_SG2.close(); var15_SG2 = null; }
                    if( var16_SG3 != null ) { var16_SG3.close(); var16_SG3 = null; }
                    if( var17_SG4 != null ) { var17_SG4.close(); var17_SG4 = null; }
                    if( var18_SG6 != null ) { var18_SG6.close(); var18_SG6 = null; }
                    if( var19_SG7 != null ) { var19_SG7.close(); var19_SG7 = null; }
                    if( var20_SG8 != null ) { var20_SG8.close(); var20_SG8 = null; }
                    if( var21_SG11 != null ) { var21_SG11.close(); var21_SG11 = null; }
                    if( var22_SG18 != null ) { var22_SG18.close(); var22_SG18 = null; }
                    if( var23_SG37 != null ) { var23_SG37.close(); var23_SG37 = null; }
                    if( var24_UNT != null ) { var24_UNT.close(); var24_UNT = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq15_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq15_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq15_join closure;
            IEnumerator var2_F0062;
            IEnumerator var3_F0068;
            IEnumerator var4_S009;
            IEnumerator var5_S010;
            IEnumerator var6_S016;
            IEnumerator var7_S017;
            IEnumerator var8_S018;
            public Enumerator(seq15_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0062 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0062", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0062.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0062", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0062.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0062 != null ) { var2_F0062.close(); var2_F0062 = null; }
                var3_F0068 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0068", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0068.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0068", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0068.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F0068 != null ) { var3_F0068.close(); var3_F0068 = null; }
                var4_S009 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S009", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_S009.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("S009", (new seq16_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_S009.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_S009 != null ) { var4_S009.close(); var4_S009 = null; }
                var5_S010 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S010", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_S010.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("S010", (new seq17_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_S010.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_S010 != null ) { var5_S010.close(); var5_S010 = null; }
                var6_S016 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S016", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_S016.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("S016", (new seq18_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_S016.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_S016 != null ) { var6_S016.close(); var6_S016 = null; }
                var7_S017 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S017", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_S017.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("S017", (new seq19_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_S017.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_S017 != null ) { var7_S017.close(); var7_S017 = null; }
                var8_S018 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S018", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_S018.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("S018", (new seq20_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_S018.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 0;
                if( var8_S018 != null ) { var8_S018.close(); var8_S018 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0062 != null ) { var2_F0062.close(); var2_F0062 = null; }
                    if( var3_F0068 != null ) { var3_F0068.close(); var3_F0068 = null; }
                    if( var4_S009 != null ) { var4_S009.close(); var4_S009 = null; }
                    if( var5_S010 != null ) { var5_S010.close(); var5_S010 = null; }
                    if( var6_S016 != null ) { var6_S016.close(); var6_S016 = null; }
                    if( var7_S017 != null ) { var7_S017.close(); var7_S017 = null; }
                    if( var8_S018 != null ) { var8_S018.close(); var8_S018 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq16_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq16_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq16_join closure;
            IEnumerator var2_F0065;
            IEnumerator var3_F0052;
            IEnumerator var4_F0054;
            IEnumerator var5_F0051;
            IEnumerator var6_F0057;
            IEnumerator var7_F0110;
            IEnumerator var8_F0113;
            public Enumerator(seq16_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0065 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0065", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0065.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0065", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0065.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0065 != null ) { var2_F0065.close(); var2_F0065 = null; }
                var3_F0052 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0052", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0052.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0052", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0052.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F0052 != null ) { var3_F0052.close(); var3_F0052 = null; }
                var4_F0054 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0054", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F0054.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0054", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F0054.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F0054 != null ) { var4_F0054.close(); var4_F0054 = null; }
                var5_F0051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0051", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F0051.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0051", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F0051.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F0051 != null ) { var5_F0051.close(); var5_F0051 = null; }
                var6_F0057 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0057", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F0057.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0057", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F0057.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_F0057 != null ) { var6_F0057.close(); var6_F0057 = null; }
                var7_F0110 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0110", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_F0110.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0110", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_F0110.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_F0110 != null ) { var7_F0110.close(); var7_F0110 = null; }
                var8_F0113 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0113", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_F0113.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0113", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_F0113.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 0;
                if( var8_F0113 != null ) { var8_F0113.close(); var8_F0113 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0065 != null ) { var2_F0065.close(); var2_F0065 = null; }
                    if( var3_F0052 != null ) { var3_F0052.close(); var3_F0052 = null; }
                    if( var4_F0054 != null ) { var4_F0054.close(); var4_F0054 = null; }
                    if( var5_F0051 != null ) { var5_F0051.close(); var5_F0051 = null; }
                    if( var6_F0057 != null ) { var6_F0057.close(); var6_F0057 = null; }
                    if( var7_F0110 != null ) { var7_F0110.close(); var7_F0110 = null; }
                    if( var8_F0113 != null ) { var8_F0113.close(); var8_F0113 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq17_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq17_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq17_join closure;
            IEnumerator var2_F0070;
            IEnumerator var3_F0073;
            public Enumerator(seq17_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0070 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0070", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0070.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0070", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0070.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0070 != null ) { var2_F0070.close(); var2_F0070 = null; }
                var3_F0073 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0073", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0073.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0073", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0073.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F0073 != null ) { var3_F0073.close(); var3_F0073 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0070 != null ) { var2_F0070.close(); var2_F0070 = null; }
                    if( var3_F0073 != null ) { var3_F0073.close(); var3_F0073 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq18_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq18_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq18_join closure;
            IEnumerator var2_F0115;
            IEnumerator var3_F0116;
            IEnumerator var4_F0118;
            IEnumerator var5_F0051;
            public Enumerator(seq18_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0115 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0115", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0115.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0115", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0115.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0115 != null ) { var2_F0115.close(); var2_F0115 = null; }
                var3_F0116 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0116", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0116.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0116", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0116.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F0116 != null ) { var3_F0116.close(); var3_F0116 = null; }
                var4_F0118 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0118", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F0118.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0118", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F0118.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F0118 != null ) { var4_F0118.close(); var4_F0118 = null; }
                var5_F0051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0051", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F0051.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0051", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F0051.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F0051 != null ) { var5_F0051.close(); var5_F0051 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0115 != null ) { var2_F0115.close(); var2_F0115 = null; }
                    if( var3_F0116 != null ) { var3_F0116.close(); var3_F0116 = null; }
                    if( var4_F0118 != null ) { var4_F0118.close(); var4_F0118 = null; }
                    if( var5_F0051 != null ) { var5_F0051.close(); var5_F0051 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq19_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq19_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq19_join closure;
            IEnumerator var2_F0121;
            IEnumerator var3_F0122;
            IEnumerator var4_F0124;
            IEnumerator var5_F0051;
            public Enumerator(seq19_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0121 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0121", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0121.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0121", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0121.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0121 != null ) { var2_F0121.close(); var2_F0121 = null; }
                var3_F0122 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0122", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0122.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0122", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0122.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F0122 != null ) { var3_F0122.close(); var3_F0122 = null; }
                var4_F0124 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0124", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F0124.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0124", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F0124.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F0124 != null ) { var4_F0124.close(); var4_F0124 = null; }
                var5_F0051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0051", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F0051.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0051", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F0051.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F0051 != null ) { var5_F0051.close(); var5_F0051 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0121 != null ) { var2_F0121.close(); var2_F0121 = null; }
                    if( var3_F0122 != null ) { var3_F0122.close(); var3_F0122 = null; }
                    if( var4_F0124 != null ) { var4_F0124.close(); var4_F0124 = null; }
                    if( var5_F0051 != null ) { var5_F0051.close(); var5_F0051 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq20_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq20_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq20_join closure;
            IEnumerator var2_F0127;
            IEnumerator var3_F0128;
            IEnumerator var4_F0130;
            IEnumerator var5_F0051;
            public Enumerator(seq20_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0127 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0127", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0127.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0127", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0127.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0127 != null ) { var2_F0127.close(); var2_F0127 = null; }
                var3_F0128 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0128", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0128.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0128", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0128.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F0128 != null ) { var3_F0128.close(); var3_F0128 = null; }
                var4_F0130 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0130", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F0130.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0130", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F0130.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F0130 != null ) { var4_F0130.close(); var4_F0130 = null; }
                var5_F0051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0051", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F0051.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0051", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F0051.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F0051 != null ) { var5_F0051.close(); var5_F0051 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0127 != null ) { var2_F0127.close(); var2_F0127 = null; }
                    if( var3_F0128 != null ) { var3_F0128.close(); var3_F0128 = null; }
                    if( var4_F0130 != null ) { var4_F0130.close(); var4_F0130 = null; }
                    if( var5_F0051 != null ) { var5_F0051.close(); var5_F0051 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq21_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq21_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq21_join closure;
            IEnumerator var2_F1225;
            IEnumerator var3_F4343;
            IEnumerator var4_C002;
            IEnumerator var5_C106;
            public Enumerator(seq21_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F1225 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1225", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F1225.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1225", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F1225.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F1225 != null ) { var2_F1225.close(); var2_F1225 = null; }
                var3_F4343 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4343", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F4343.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4343", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F4343.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F4343 != null ) { var3_F4343.close(); var3_F4343 = null; }
                var4_C002 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C002", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C002.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C002", (new seq22_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C002.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_C002 != null ) { var4_C002.close(); var4_C002 = null; }
                var5_C106 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C106", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C106.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C106", (new seq23_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C106.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_C106 != null ) { var5_C106.close(); var5_C106 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F1225 != null ) { var2_F1225.close(); var2_F1225 = null; }
                    if( var3_F4343 != null ) { var3_F4343.close(); var3_F4343 = null; }
                    if( var4_C002 != null ) { var4_C002.close(); var4_C002 = null; }
                    if( var5_C106 != null ) { var5_C106.close(); var5_C106 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq22_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq22_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq22_join closure;
            IEnumerator var2_F1001;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F1000;
            public Enumerator(seq22_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F1001 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1001", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F1001.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1001", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F1001.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F1001 != null ) { var2_F1001.close(); var2_F1001 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                var5_F1000 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1000", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F1000.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1000", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F1000.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F1000 != null ) { var5_F1000.close(); var5_F1000 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F1001 != null ) { var2_F1001.close(); var2_F1001 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F1000 != null ) { var5_F1000.close(); var5_F1000 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq23_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq23_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq23_join closure;
            IEnumerator var2_F1004;
            IEnumerator var3_F1056;
            IEnumerator var4_F1060;
            public Enumerator(seq23_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F1004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1004", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F1004.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1004", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F1004.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F1004 != null ) { var2_F1004.close(); var2_F1004 = null; }
                var3_F1056 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1056", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1056.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1056", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1056.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1056 != null ) { var3_F1056.close(); var3_F1056 = null; }
                var4_F1060 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1060", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F1060.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1060", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F1060.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F1060 != null ) { var4_F1060.close(); var4_F1060 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F1004 != null ) { var2_F1004.close(); var2_F1004 = null; }
                    if( var3_F1056 != null ) { var3_F1056.close(); var3_F1056 = null; }
                    if( var4_F1060 != null ) { var4_F1060.close(); var4_F1060 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq24_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq24_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq24_join closure;
            IEnumerator var2_F3139;
            IEnumerator var3_C056;
            public Enumerator(seq24_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3139 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3139", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3139.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3139", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3139.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3139 != null ) { var2_F3139.close(); var2_F3139 = null; }
                var3_C056 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C056", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C056.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C056", (new seq25_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C056.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_C056 != null ) { var3_C056.close(); var3_C056 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3139 != null ) { var2_F3139.close(); var2_F3139 = null; }
                    if( var3_C056 != null ) { var3_C056.close(); var3_C056 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq25_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq25_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq25_join closure;
            IEnumerator var2_F3413;
            IEnumerator var3_F3412;
            public Enumerator(seq25_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3413 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3413", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3413.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3413", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3413.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3413 != null ) { var2_F3413.close(); var2_F3413 = null; }
                var3_F3412 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3412", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F3412.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3412", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F3412.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F3412 != null ) { var3_F3412.close(); var3_F3412 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3413 != null ) { var2_F3413.close(); var2_F3413 = null; }
                    if( var3_F3412 != null ) { var3_F3412.close(); var3_F3412 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq26_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq26_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq26_map closure;
            IEnumerator var2_C076;
            public Enumerator(seq26_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_C076 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C076", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C076.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C076", (new seq27_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C076.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_C076 != null ) { var2_C076.close(); var2_C076 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_C076 != null ) { var2_C076.close(); var2_C076 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq27_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq27_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq27_join closure;
            IEnumerator var2_F3148;
            IEnumerator var3_F3155;
            public Enumerator(seq27_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3148 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3148", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3148.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3148", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3148.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3148 != null ) { var2_F3148.close(); var2_F3148 = null; }
                var3_F3155 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3155", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F3155.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3155", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F3155.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F3155 != null ) { var3_F3155.close(); var3_F3155 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3148 != null ) { var2_F3148.close(); var2_F3148 = null; }
                    if( var3_F3155 != null ) { var3_F3155.close(); var3_F3155 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq28_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq28_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq28_map closure;
            IEnumerator var2_C507;
            public Enumerator(seq28_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_C507 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C507", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C507.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C507", (new seq29_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C507.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_C507 != null ) { var2_C507.close(); var2_C507 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_C507 != null ) { var2_C507.close(); var2_C507 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq29_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq29_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq29_join closure;
            IEnumerator var2_F2005;
            IEnumerator var3_F2380;
            IEnumerator var4_F2379;
            public Enumerator(seq29_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F2005 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F2005", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F2005.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F2005", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F2005.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F2005 != null ) { var2_F2005.close(); var2_F2005 = null; }
                var3_F2380 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F2380", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F2380.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F2380", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F2380.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F2380 != null ) { var3_F2380.close(); var3_F2380 = null; }
                var4_F2379 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F2379", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F2379.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F2379", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F2379.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F2379 != null ) { var4_F2379.close(); var4_F2379 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F2005 != null ) { var2_F2005.close(); var2_F2005 = null; }
                    if( var3_F2380 != null ) { var3_F2380.close(); var3_F2380 = null; }
                    if( var4_F2379 != null ) { var4_F2379.close(); var4_F2379 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq30_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq30_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq30_join closure;
            IEnumerator var2_C536;
            IEnumerator var3_C233;
            IEnumerator var4_C537;
            IEnumerator var5_C703;
            public Enumerator(seq30_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_C536 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C536", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C536.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C536", (new seq31_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C536.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_C536 != null ) { var2_C536.close(); var2_C536 = null; }
                var3_C233 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C233", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C233.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C233", (new seq32_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C233.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_C233 != null ) { var3_C233.close(); var3_C233 = null; }
                var4_C537 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C537", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C537.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C537", (new seq33_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C537.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_C537 != null ) { var4_C537.close(); var4_C537 = null; }
                var5_C703 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C703", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C703.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C703", (new seq34_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C703.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_C703 != null ) { var5_C703.close(); var5_C703 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_C536 != null ) { var2_C536.close(); var2_C536 = null; }
                    if( var3_C233 != null ) { var3_C233.close(); var3_C233 = null; }
                    if( var4_C537 != null ) { var4_C537.close(); var4_C537 = null; }
                    if( var5_C703 != null ) { var5_C703.close(); var5_C703 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq31_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq31_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq31_join closure;
            IEnumerator var2_F4065;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            public Enumerator(seq31_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4065 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4065", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4065.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4065", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4065.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4065 != null ) { var2_F4065.close(); var2_F4065 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4065 != null ) { var2_F4065.close(); var2_F4065 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq32_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq32_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq32_join closure;
            IEnumerator var2_F7273_1;
            IEnumerator var3_F1131_1;
            IEnumerator var4_F3055_1;
            IEnumerator var5_F7273_2;
            IEnumerator var6_F1131_2;
            IEnumerator var7_F3055_2;
            public Enumerator(seq32_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7273_1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7273_1", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7273_1.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7273_1", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7273_1.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7273_1 != null ) { var2_F7273_1.close(); var2_F7273_1 = null; }
                var3_F1131_1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131_1", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131_1.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131_1", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131_1.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131_1 != null ) { var3_F1131_1.close(); var3_F1131_1 = null; }
                var4_F3055_1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055_1", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055_1.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055_1", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055_1.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3055_1 != null ) { var4_F3055_1.close(); var4_F3055_1 = null; }
                var5_F7273_2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7273_2", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F7273_2.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7273_2", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F7273_2.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F7273_2 != null ) { var5_F7273_2.close(); var5_F7273_2 = null; }
                var6_F1131_2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131_2", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F1131_2.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131_2", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F1131_2.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_F1131_2 != null ) { var6_F1131_2.close(); var6_F1131_2 = null; }
                var7_F3055_2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055_2", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_F3055_2.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055_2", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_F3055_2.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_F3055_2 != null ) { var7_F3055_2.close(); var7_F3055_2 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7273_1 != null ) { var2_F7273_1.close(); var2_F7273_1 = null; }
                    if( var3_F1131_1 != null ) { var3_F1131_1.close(); var3_F1131_1 = null; }
                    if( var4_F3055_1 != null ) { var4_F3055_1.close(); var4_F3055_1 = null; }
                    if( var5_F7273_2 != null ) { var5_F7273_2.close(); var5_F7273_2 = null; }
                    if( var6_F1131_2 != null ) { var6_F1131_2.close(); var6_F1131_2 = null; }
                    if( var7_F3055_2 != null ) { var7_F3055_2.close(); var7_F3055_2 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq33_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq33_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq33_join closure;
            IEnumerator var2_F4219;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            public Enumerator(seq33_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4219 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4219", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4219.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4219", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4219.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4219 != null ) { var2_F4219.close(); var2_F4219 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4219 != null ) { var2_F4219.close(); var2_F4219 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq34_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq34_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq34_join closure;
            IEnumerator var2_F7085;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            public Enumerator(seq34_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7085 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7085", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7085.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7085", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7085.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7085 != null ) { var2_F7085.close(); var2_F7085 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7085 != null ) { var2_F7085.close(); var2_F7085 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq35_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq35_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq35_join closure;
            IEnumerator var2_F5402;
            IEnumerator var3_F6341;
            IEnumerator var4_C504;
            public Enumerator(seq35_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F5402 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5402", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F5402.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5402", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F5402.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F5402 != null ) { var2_F5402.close(); var2_F5402 = null; }
                var3_F6341 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6341", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F6341.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6341", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F6341.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F6341 != null ) { var3_F6341.close(); var3_F6341 = null; }
                var4_C504 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C504", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C504.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C504", (new seq36_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C504.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_C504 != null ) { var4_C504.close(); var4_C504 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F5402 != null ) { var2_F5402.close(); var2_F5402 = null; }
                    if( var3_F6341 != null ) { var3_F6341.close(); var3_F6341 = null; }
                    if( var4_C504 != null ) { var4_C504.close(); var4_C504 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq36_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq36_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq36_join closure;
            IEnumerator var2_F6347;
            IEnumerator var3_F6345;
            IEnumerator var4_F6343;
            IEnumerator var5_F6348;
            public Enumerator(seq36_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6347 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6347", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F6347.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6347", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F6347.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F6347 != null ) { var2_F6347.close(); var2_F6347 = null; }
                var3_F6345 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6345", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F6345.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6345", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F6345.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F6345 != null ) { var3_F6345.close(); var3_F6345 = null; }
                var4_F6343 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6343", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F6343.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6343", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F6343.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F6343 != null ) { var4_F6343.close(); var4_F6343 = null; }
                var5_F6348 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6348", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F6348.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6348", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F6348.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F6348 != null ) { var5_F6348.close(); var5_F6348 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F6347 != null ) { var2_F6347.close(); var2_F6347 = null; }
                    if( var3_F6345 != null ) { var3_F6345.close(); var3_F6345 = null; }
                    if( var4_F6343 != null ) { var4_F6343.close(); var4_F6343 = null; }
                    if( var5_F6348 != null ) { var5_F6348.close(); var5_F6348 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq37_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq37_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq37_map closure;
            IEnumerator var2_C516;
            public Enumerator(seq37_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_C516 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C516", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C516.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C516", (new seq38_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C516.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_C516 != null ) { var2_C516.close(); var2_C516 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_C516 != null ) { var2_C516.close(); var2_C516 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq38_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq38_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq38_join closure;
            IEnumerator var2_F5025;
            IEnumerator var3_F5004;
            IEnumerator var4_F6345;
            IEnumerator var5_F6343;
            IEnumerator var6_F4405;
            public Enumerator(seq38_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F5025 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5025", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F5025.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5025", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F5025.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F5025 != null ) { var2_F5025.close(); var2_F5025 = null; }
                var3_F5004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5004", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F5004.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5004", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F5004.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F5004 != null ) { var3_F5004.close(); var3_F5004 = null; }
                var4_F6345 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6345", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F6345.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6345", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F6345.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F6345 != null ) { var4_F6345.close(); var4_F6345 = null; }
                var5_F6343 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6343", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F6343.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6343", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F6343.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F6343 != null ) { var5_F6343.close(); var5_F6343 = null; }
                var6_F4405 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4405", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F4405.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4405", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F4405.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_F4405 != null ) { var6_F4405.close(); var6_F4405 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F5025 != null ) { var2_F5025.close(); var2_F5025 = null; }
                    if( var3_F5004 != null ) { var3_F5004.close(); var3_F5004 = null; }
                    if( var4_F6345 != null ) { var4_F6345.close(); var4_F6345 = null; }
                    if( var5_F6343 != null ) { var5_F6343.close(); var5_F6343 = null; }
                    if( var6_F4405 != null ) { var6_F4405.close(); var6_F4405 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq39_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq39_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq39_join closure;
            IEnumerator var2_F4451;
            IEnumerator var3_F4453;
            IEnumerator var4_F3453;
            IEnumerator var5_F4447;
            IEnumerator var6_C107;
            IEnumerator var7_C108;
            public Enumerator(seq39_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4451 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4451", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4451.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4451", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4451.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4451 != null ) { var2_F4451.close(); var2_F4451 = null; }
                var3_F4453 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4453", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F4453.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4453", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F4453.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F4453 != null ) { var3_F4453.close(); var3_F4453 = null; }
                var4_F3453 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3453", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3453.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3453", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3453.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3453 != null ) { var4_F3453.close(); var4_F3453 = null; }
                var5_F4447 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4447", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F4447.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4447", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F4447.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F4447 != null ) { var5_F4447.close(); var5_F4447 = null; }
                var6_C107 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C107", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_C107.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C107", (new seq40_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C107.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_C107 != null ) { var6_C107.close(); var6_C107 = null; }
                var7_C108 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C108", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_C108.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C108", (new seq41_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_C108.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_C108 != null ) { var7_C108.close(); var7_C108 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4451 != null ) { var2_F4451.close(); var2_F4451 = null; }
                    if( var3_F4453 != null ) { var3_F4453.close(); var3_F4453 = null; }
                    if( var4_F3453 != null ) { var4_F3453.close(); var4_F3453 = null; }
                    if( var5_F4447 != null ) { var5_F4447.close(); var5_F4447 = null; }
                    if( var6_C107 != null ) { var6_C107.close(); var6_C107 = null; }
                    if( var7_C108 != null ) { var7_C108.close(); var7_C108 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq40_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq40_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq40_join closure;
            IEnumerator var2_F4441;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            public Enumerator(seq40_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4441 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4441", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4441.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4441", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4441.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4441 != null ) { var2_F4441.close(); var2_F4441 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4441 != null ) { var2_F4441.close(); var2_F4441 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq41_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq41_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq41_map closure;
            IEnumerator var2_F4440;
            public Enumerator(seq41_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4440 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4440", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4440.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4440", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4440.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_F4440 != null ) { var2_F4440.close(); var2_F4440 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4440 != null ) { var2_F4440.close(); var2_F4440 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq42_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq42_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq42_map closure;
            IEnumerator var2_C270;
            public Enumerator(seq42_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_C270 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C270", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C270.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C270", (new seq43_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C270.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_C270 != null ) { var2_C270.close(); var2_C270 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_C270 != null ) { var2_C270.close(); var2_C270 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq43_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq43_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq43_join closure;
            IEnumerator var2_F6069;
            IEnumerator var3_F6066;
            IEnumerator var4_F6411;
            public Enumerator(seq43_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6069 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6069", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F6069.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6069", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F6069.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F6069 != null ) { var2_F6069.close(); var2_F6069 = null; }
                var3_F6066 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6066", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F6066.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6066", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F6066.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F6066 != null ) { var3_F6066.close(); var3_F6066 = null; }
                var4_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F6411.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6411", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F6411.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F6411 != null ) { var4_F6411.close(); var4_F6411 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F6069 != null ) { var2_F6069.close(); var2_F6069 = null; }
                    if( var3_F6066 != null ) { var3_F6066.close(); var3_F6066 = null; }
                    if( var4_F6411 != null ) { var4_F6411.close(); var4_F6411 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq44_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq44_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq44_join closure;
            IEnumerator var2_F3153;
            IEnumerator var3_F1220;
            IEnumerator var4_F1218;
            IEnumerator var5_C002;
            IEnumerator var6_C503;
            public Enumerator(seq44_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3153 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3153", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3153.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3153", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3153.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3153 != null ) { var2_F3153.close(); var2_F3153 = null; }
                var3_F1220 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1220", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1220.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1220", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1220.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1220 != null ) { var3_F1220.close(); var3_F1220 = null; }
                var4_F1218 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1218", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F1218.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1218", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F1218.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F1218 != null ) { var4_F1218.close(); var4_F1218 = null; }
                var5_C002 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C002", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C002.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C002", (new seq22_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C002.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_C002 != null ) { var5_C002.close(); var5_C002 = null; }
                var6_C503 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C503", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_C503.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C503", (new seq45_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C503.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_C503 != null ) { var6_C503.close(); var6_C503 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3153 != null ) { var2_F3153.close(); var2_F3153 = null; }
                    if( var3_F1220 != null ) { var3_F1220.close(); var3_F1220 = null; }
                    if( var4_F1218 != null ) { var4_F1218.close(); var4_F1218 = null; }
                    if( var5_C002 != null ) { var5_C002.close(); var5_C002 = null; }
                    if( var6_C503 != null ) { var6_C503.close(); var6_C503 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq45_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq45_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq45_join closure;
            IEnumerator var2_F1004;
            IEnumerator var3_F1373;
            IEnumerator var4_F1366;
            IEnumerator var5_F3453;
            IEnumerator var6_F1056;
            IEnumerator var7_F1060;
            public Enumerator(seq45_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F1004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1004", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F1004.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1004", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F1004.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F1004 != null ) { var2_F1004.close(); var2_F1004 = null; }
                var3_F1373 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1373", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1373.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1373", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1373.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1373 != null ) { var3_F1373.close(); var3_F1373 = null; }
                var4_F1366 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1366", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F1366.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1366", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F1366.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F1366 != null ) { var4_F1366.close(); var4_F1366 = null; }
                var5_F3453 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3453", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F3453.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3453", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F3453.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F3453 != null ) { var5_F3453.close(); var5_F3453 = null; }
                var6_F1056 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1056", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F1056.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1056", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F1056.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_F1056 != null ) { var6_F1056.close(); var6_F1056 = null; }
                var7_F1060 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1060", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_F1060.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1060", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_F1060.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_F1060 != null ) { var7_F1060.close(); var7_F1060 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F1004 != null ) { var2_F1004.close(); var2_F1004 = null; }
                    if( var3_F1373 != null ) { var3_F1373.close(); var3_F1373 = null; }
                    if( var4_F1366 != null ) { var4_F1366.close(); var4_F1366 = null; }
                    if( var5_F3453 != null ) { var5_F3453.close(); var5_F3453 = null; }
                    if( var6_F1056 != null ) { var6_F1056.close(); var6_F1056 = null; }
                    if( var7_F1060 != null ) { var7_F1060.close(); var7_F1060 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq46_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq46_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq46_map closure;
            IEnumerator var2_C703;
            public Enumerator(seq46_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_C703 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C703", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C703.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C703", (new seq34_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C703.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_C703 != null ) { var2_C703.close(); var2_C703 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_C703 != null ) { var2_C703.close(); var2_C703 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq47_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq47_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq47_join closure;
            IEnumerator var2_LOC;
            IEnumerator var3_DTM;
            public Enumerator(seq47_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_LOC.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq48_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_LOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_LOC != null ) { var2_LOC.close(); var2_LOC = null; }
                var3_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_DTM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq28_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_LOC != null ) { var2_LOC.close(); var2_LOC = null; }
                    if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq48_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq48_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq48_join closure;
            IEnumerator var2_F3227;
            IEnumerator var3_F5479;
            IEnumerator var4_C517;
            IEnumerator var5_C519;
            IEnumerator var6_C553;
            public Enumerator(seq48_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3227 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3227", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3227.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3227", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3227.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3227 != null ) { var2_F3227.close(); var2_F3227 = null; }
                var3_F5479 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5479", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F5479.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5479", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F5479.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F5479 != null ) { var3_F5479.close(); var3_F5479 = null; }
                var4_C517 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C517", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C517.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C517", (new seq49_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C517.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_C517 != null ) { var4_C517.close(); var4_C517 = null; }
                var5_C519 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C519", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C519.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C519", (new seq50_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C519.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_C519 != null ) { var5_C519.close(); var5_C519 = null; }
                var6_C553 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C553", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_C553.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C553", (new seq51_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C553.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_C553 != null ) { var6_C553.close(); var6_C553 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3227 != null ) { var2_F3227.close(); var2_F3227 = null; }
                    if( var3_F5479 != null ) { var3_F5479.close(); var3_F5479 = null; }
                    if( var4_C517 != null ) { var4_C517.close(); var4_C517 = null; }
                    if( var5_C519 != null ) { var5_C519.close(); var5_C519 = null; }
                    if( var6_C553 != null ) { var6_C553.close(); var6_C553 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq49_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq49_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq49_join closure;
            IEnumerator var2_F3225;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F3224;
            public Enumerator(seq49_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3225 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3225", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3225.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3225", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3225.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3225 != null ) { var2_F3225.close(); var2_F3225 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                var5_F3224 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3224", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F3224.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3224", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F3224.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F3224 != null ) { var5_F3224.close(); var5_F3224 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3225 != null ) { var2_F3225.close(); var2_F3225 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F3224 != null ) { var5_F3224.close(); var5_F3224 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq50_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq50_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq50_join closure;
            IEnumerator var2_F3223;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F3222;
            public Enumerator(seq50_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3223 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3223", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3223.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3223", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3223.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3223 != null ) { var2_F3223.close(); var2_F3223 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                var5_F3222 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3222", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F3222.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3222", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F3222.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F3222 != null ) { var5_F3222.close(); var5_F3222 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3223 != null ) { var2_F3223.close(); var2_F3223 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F3222 != null ) { var5_F3222.close(); var5_F3222 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq51_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq51_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq51_join closure;
            IEnumerator var2_F3233;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F3232;
            public Enumerator(seq51_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3233 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3233", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3233.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3233", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3233.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3233 != null ) { var2_F3233.close(); var2_F3233 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                var5_F3232 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3232", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F3232.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3232", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F3232.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F3232 != null ) { var5_F3232.close(); var5_F3232 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3233 != null ) { var2_F3233.close(); var2_F3233 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F3232 != null ) { var5_F3232.close(); var5_F3232 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq52_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq52_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq52_join closure;
            IEnumerator var2_TOD;
            IEnumerator var3_LOC;
            public Enumerator(seq52_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_TOD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TOD", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_TOD.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TOD", (new seq53_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_TOD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_TOD != null ) { var2_TOD.close(); var2_TOD = null; }
                var3_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_LOC.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq48_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_LOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_LOC != null ) { var3_LOC.close(); var3_LOC = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_TOD != null ) { var2_TOD.close(); var2_TOD = null; }
                    if( var3_LOC != null ) { var3_LOC.close(); var3_LOC = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq53_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq53_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq53_join closure;
            IEnumerator var2_F4055;
            IEnumerator var3_F4215;
            IEnumerator var4_C100;
            public Enumerator(seq53_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4055.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4055 != null ) { var2_F4055.close(); var2_F4055 = null; }
                var3_F4215 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4215", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F4215.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4215", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F4215.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F4215 != null ) { var3_F4215.close(); var3_F4215 = null; }
                var4_C100 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C100", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C100.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C100", (new seq54_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C100.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_C100 != null ) { var4_C100.close(); var4_C100 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4055 != null ) { var2_F4055.close(); var2_F4055 = null; }
                    if( var3_F4215 != null ) { var3_F4215.close(); var3_F4215 = null; }
                    if( var4_C100 != null ) { var4_C100.close(); var4_C100 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq54_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq54_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq54_join closure;
            IEnumerator var2_F4053;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F4052;
            public Enumerator(seq54_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4053 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4053", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4053.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4053", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4053.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4053 != null ) { var2_F4053.close(); var2_F4053 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                var5_F4052 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4052", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F4052.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4052", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F4052.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F4052 != null ) { var5_F4052.close(); var5_F4052 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4053 != null ) { var2_F4053.close(); var2_F4053 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F4052 != null ) { var5_F4052.close(); var5_F4052 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq55_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq55_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq55_join closure;
            IEnumerator var2_RFF;
            IEnumerator var3_DTM;
            public Enumerator(seq55_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_RFF = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RFF", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_RFF.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("RFF", (new seq56_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_RFF.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_RFF != null ) { var2_RFF.close(); var2_RFF = null; }
                var3_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_DTM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq28_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_RFF != null ) { var2_RFF.close(); var2_RFF = null; }
                    if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq56_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq56_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq56_map closure;
            IEnumerator var2_C506;
            public Enumerator(seq56_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_C506 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C506", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C506.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C506", (new seq57_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C506.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_C506 != null ) { var2_C506.close(); var2_C506 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_C506 != null ) { var2_C506.close(); var2_C506 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq57_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq57_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq57_join closure;
            IEnumerator var2_F1153;
            IEnumerator var3_F1154;
            IEnumerator var4_F1156;
            IEnumerator var5_F4000;
            IEnumerator var6_F1060;
            public Enumerator(seq57_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F1153 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1153", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F1153.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1153", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F1153.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F1153 != null ) { var2_F1153.close(); var2_F1153 = null; }
                var3_F1154 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1154", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1154.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1154", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1154.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1154 != null ) { var3_F1154.close(); var3_F1154 = null; }
                var4_F1156 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1156", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F1156.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1156", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F1156.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F1156 != null ) { var4_F1156.close(); var4_F1156 = null; }
                var5_F4000 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4000", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F4000.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4000", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F4000.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F4000 != null ) { var5_F4000.close(); var5_F4000 = null; }
                var6_F1060 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1060", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F1060.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1060", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F1060.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_F1060 != null ) { var6_F1060.close(); var6_F1060 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F1153 != null ) { var2_F1153.close(); var2_F1153 = null; }
                    if( var3_F1154 != null ) { var3_F1154.close(); var3_F1154 = null; }
                    if( var4_F1156 != null ) { var4_F1156.close(); var4_F1156 = null; }
                    if( var5_F4000 != null ) { var5_F4000.close(); var5_F4000 = null; }
                    if( var6_F1060 != null ) { var6_F1060.close(); var6_F1060 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq58_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq58_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq58_join closure;
            IEnumerator var2_GOR;
            IEnumerator var3_DTM;
            IEnumerator var4_LOC;
            IEnumerator var5_SEL;
            IEnumerator var6_FTX;
            IEnumerator var7_SG5;
            public Enumerator(seq58_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_GOR = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("GOR", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_GOR.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("GOR", (new seq59_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_GOR.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_GOR != null ) { var2_GOR.close(); var2_GOR = null; }
                var3_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_DTM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq28_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                var4_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_LOC.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq48_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_LOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_LOC != null ) { var4_LOC.close(); var4_LOC = null; }
                var5_SEL = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SEL", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_SEL.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SEL", (new seq61_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_SEL.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_SEL != null ) { var5_SEL.close(); var5_SEL = null; }
                var6_FTX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FTX", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_FTX.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("FTX", (new seq39_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_FTX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_FTX != null ) { var6_FTX.close(); var6_FTX = null; }
                var7_SG5 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG5", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_SG5.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG5", (new seq64_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_SG5.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_SG5 != null ) { var7_SG5.close(); var7_SG5 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_GOR != null ) { var2_GOR.close(); var2_GOR = null; }
                    if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                    if( var4_LOC != null ) { var4_LOC.close(); var4_LOC = null; }
                    if( var5_SEL != null ) { var5_SEL.close(); var5_SEL = null; }
                    if( var6_FTX != null ) { var6_FTX.close(); var6_FTX = null; }
                    if( var7_SG5 != null ) { var7_SG5.close(); var7_SG5 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq59_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq59_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq59_join closure;
            IEnumerator var2_F8323;
            IEnumerator var3_C232;
            public Enumerator(seq59_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8323 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8323", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8323.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8323", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8323.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8323 != null ) { var2_F8323.close(); var2_F8323 = null; }
                var3_C232 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C232", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C232.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C232", (new seq60_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C232.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_C232 != null ) { var3_C232.close(); var3_C232 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8323 != null ) { var2_F8323.close(); var2_F8323 = null; }
                    if( var3_C232 != null ) { var3_C232.close(); var3_C232 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq60_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq60_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq60_join closure;
            IEnumerator var2_F9415;
            IEnumerator var3_F9411;
            IEnumerator var4_F9417;
            IEnumerator var5_F9353;
            public Enumerator(seq60_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F9415 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F9415", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F9415.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F9415", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F9415.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F9415 != null ) { var2_F9415.close(); var2_F9415 = null; }
                var3_F9411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F9411", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F9411.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F9411", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F9411.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F9411 != null ) { var3_F9411.close(); var3_F9411 = null; }
                var4_F9417 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F9417", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F9417.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F9417", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F9417.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F9417 != null ) { var4_F9417.close(); var4_F9417 = null; }
                var5_F9353 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F9353", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F9353.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F9353", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F9353.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F9353 != null ) { var5_F9353.close(); var5_F9353 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F9415 != null ) { var2_F9415.close(); var2_F9415 = null; }
                    if( var3_F9411 != null ) { var3_F9411.close(); var3_F9411 = null; }
                    if( var4_F9417 != null ) { var4_F9417.close(); var4_F9417 = null; }
                    if( var5_F9353 != null ) { var5_F9353.close(); var5_F9353 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq61_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq61_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq61_join closure;
            IEnumerator var2_F9308;
            IEnumerator var3_F4517;
            IEnumerator var4_C215;
            IEnumerator var5_C208;
            public Enumerator(seq61_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F9308 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F9308", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F9308.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F9308", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F9308.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F9308 != null ) { var2_F9308.close(); var2_F9308 = null; }
                var3_F4517 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4517", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F4517.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4517", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F4517.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F4517 != null ) { var3_F4517.close(); var3_F4517 = null; }
                var4_C215 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C215", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C215.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C215", (new seq62_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C215.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_C215 != null ) { var4_C215.close(); var4_C215 = null; }
                var5_C208 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C208", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C208.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C208", (new seq63_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C208.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_C208 != null ) { var5_C208.close(); var5_C208 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F9308 != null ) { var2_F9308.close(); var2_F9308 = null; }
                    if( var3_F4517 != null ) { var3_F4517.close(); var3_F4517 = null; }
                    if( var4_C215 != null ) { var4_C215.close(); var4_C215 = null; }
                    if( var5_C208 != null ) { var5_C208.close(); var5_C208 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq62_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq62_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq62_join closure;
            IEnumerator var2_F9303;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F9302;
            public Enumerator(seq62_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F9303 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F9303", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F9303.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F9303", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F9303.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F9303 != null ) { var2_F9303.close(); var2_F9303 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                var5_F9302 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F9302", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F9302.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F9302", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F9302.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F9302 != null ) { var5_F9302.close(); var5_F9302 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F9303 != null ) { var2_F9303.close(); var2_F9303 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F9302 != null ) { var5_F9302.close(); var5_F9302 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq63_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq63_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq63_map closure;
            IEnumerator var2_F7402;
            public Enumerator(seq63_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7402 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7402", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7402.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7402", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7402.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_F7402 != null ) { var2_F7402.close(); var2_F7402 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7402 != null ) { var2_F7402.close(); var2_F7402 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq64_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq64_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq64_join closure;
            IEnumerator var2_DOC;
            IEnumerator var3_DTM;
            public Enumerator(seq64_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_DOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DOC", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_DOC.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DOC", (new seq44_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_DOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_DOC != null ) { var2_DOC.close(); var2_DOC = null; }
                var3_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_DTM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq28_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_DOC != null ) { var2_DOC.close(); var2_DOC = null; }
                    if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq65_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq65_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq65_join closure;
            IEnumerator var2_CPI;
            IEnumerator var3_RFF;
            IEnumerator var4_CUX;
            IEnumerator var5_LOC;
            IEnumerator var6_MOA;
            public Enumerator(seq65_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_CPI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CPI", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_CPI.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("CPI", (new seq66_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_CPI.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_CPI != null ) { var2_CPI.close(); var2_CPI = null; }
                var3_RFF = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RFF", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_RFF.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("RFF", (new seq56_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_RFF.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_RFF != null ) { var3_RFF.close(); var3_RFF = null; }
                var4_CUX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CUX", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_CUX.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("CUX", (new seq35_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_CUX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_CUX != null ) { var4_CUX.close(); var4_CUX = null; }
                var5_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_LOC.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq48_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_LOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_LOC != null ) { var5_LOC.close(); var5_LOC = null; }
                var6_MOA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MOA", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_MOA.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MOA", (new seq37_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_MOA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_MOA != null ) { var6_MOA.close(); var6_MOA = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_CPI != null ) { var2_CPI.close(); var2_CPI = null; }
                    if( var3_RFF != null ) { var3_RFF.close(); var3_RFF = null; }
                    if( var4_CUX != null ) { var4_CUX.close(); var4_CUX = null; }
                    if( var5_LOC != null ) { var5_LOC.close(); var5_LOC = null; }
                    if( var6_MOA != null ) { var6_MOA.close(); var6_MOA = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq66_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq66_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq66_join closure;
            IEnumerator var2_F4237;
            IEnumerator var3_C229;
            IEnumerator var4_C231;
            public Enumerator(seq66_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4237 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4237", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4237.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4237", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4237.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4237 != null ) { var2_F4237.close(); var2_F4237 = null; }
                var3_C229 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C229", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C229.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C229", (new seq67_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C229.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_C229 != null ) { var3_C229.close(); var3_C229 = null; }
                var4_C231 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C231", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C231.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C231", (new seq68_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C231.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_C231 != null ) { var4_C231.close(); var4_C231 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4237 != null ) { var2_F4237.close(); var2_F4237 = null; }
                    if( var3_C229 != null ) { var3_C229.close(); var3_C229 = null; }
                    if( var4_C231 != null ) { var4_C231.close(); var4_C231 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq67_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq67_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq67_join closure;
            IEnumerator var2_F5237;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            public Enumerator(seq67_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F5237 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5237", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F5237.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5237", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F5237.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F5237 != null ) { var2_F5237.close(); var2_F5237 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F5237 != null ) { var2_F5237.close(); var2_F5237 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq68_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq68_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq68_join closure;
            IEnumerator var2_F4215;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            public Enumerator(seq68_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4215 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4215", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4215.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4215", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4215.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4215 != null ) { var2_F4215.close(); var2_F4215 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4215 != null ) { var2_F4215.close(); var2_F4215 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq69_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq69_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq69_join closure;
            IEnumerator var2_TCC;
            IEnumerator var3_LOC;
            IEnumerator var4_FTX;
            IEnumerator var5_CUX;
            IEnumerator var6_PRI;
            IEnumerator var7_EQN;
            IEnumerator var8_PCD;
            IEnumerator var9_MOA;
            IEnumerator var10_QTY;
            public Enumerator(seq69_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 27:	if (moveNext_27()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_TCC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TCC", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_TCC.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TCC", (new seq70_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_TCC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_TCC != null ) { var2_TCC.close(); var2_TCC = null; }
                var3_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_LOC.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq48_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_LOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_LOC != null ) { var3_LOC.close(); var3_LOC = null; }
                var4_FTX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FTX", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_FTX.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("FTX", (new seq39_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_FTX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_FTX != null ) { var4_FTX.close(); var4_FTX = null; }
                var5_CUX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CUX", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_CUX.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("CUX", (new seq35_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_CUX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_CUX != null ) { var5_CUX.close(); var5_CUX = null; }
                var6_PRI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PRI", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_PRI.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PRI", (new seq75_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_PRI.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_PRI != null ) { var6_PRI.close(); var6_PRI = null; }
                var7_EQN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("EQN", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_EQN.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("EQN", (new seq77_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_EQN.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_EQN != null ) { var7_EQN.close(); var7_EQN = null; }
                var8_PCD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PCD", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_PCD.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PCD", (new seq79_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_PCD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_PCD != null ) { var8_PCD.close(); var8_PCD = null; }
                var9_MOA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MOA", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_MOA.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MOA", (new seq37_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_MOA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_MOA != null ) { var9_MOA.close(); var9_MOA = null; }
                var10_QTY = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("QTY", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_QTY.moveNext()) {state = 27; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("QTY", (new seq81_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_QTY.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 0;
                if( var10_QTY != null ) { var10_QTY.close(); var10_QTY = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_TCC != null ) { var2_TCC.close(); var2_TCC = null; }
                    if( var3_LOC != null ) { var3_LOC.close(); var3_LOC = null; }
                    if( var4_FTX != null ) { var4_FTX.close(); var4_FTX = null; }
                    if( var5_CUX != null ) { var5_CUX.close(); var5_CUX = null; }
                    if( var6_PRI != null ) { var6_PRI.close(); var6_PRI = null; }
                    if( var7_EQN != null ) { var7_EQN.close(); var7_EQN = null; }
                    if( var8_PCD != null ) { var8_PCD.close(); var8_PCD = null; }
                    if( var9_MOA != null ) { var9_MOA.close(); var9_MOA = null; }
                    if( var10_QTY != null ) { var10_QTY.close(); var10_QTY = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq70_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq70_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq70_join closure;
            IEnumerator var2_C200;
            IEnumerator var3_C203;
            IEnumerator var4_C528;
            IEnumerator var5_C554;
            public Enumerator(seq70_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_C200 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C200", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C200.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C200", (new seq71_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C200.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_C200 != null ) { var2_C200.close(); var2_C200 = null; }
                var3_C203 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C203", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C203.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C203", (new seq72_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C203.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_C203 != null ) { var3_C203.close(); var3_C203 = null; }
                var4_C528 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C528", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C528.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C528", (new seq73_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C528.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_C528 != null ) { var4_C528.close(); var4_C528 = null; }
                var5_C554 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C554", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C554.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C554", (new seq74_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C554.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_C554 != null ) { var5_C554.close(); var5_C554 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_C200 != null ) { var2_C200.close(); var2_C200 = null; }
                    if( var3_C203 != null ) { var3_C203.close(); var3_C203 = null; }
                    if( var4_C528 != null ) { var4_C528.close(); var4_C528 = null; }
                    if( var5_C554 != null ) { var5_C554.close(); var5_C554 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq71_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq71_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq71_join closure;
            IEnumerator var2_F8023;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F8022;
            IEnumerator var6_F4237;
            IEnumerator var7_F7140;
            public Enumerator(seq71_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8023 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8023", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8023.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8023", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8023.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8023 != null ) { var2_F8023.close(); var2_F8023 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                var5_F8022 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8022", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F8022.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8022", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F8022.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F8022 != null ) { var5_F8022.close(); var5_F8022 = null; }
                var6_F4237 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4237", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F4237.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4237", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F4237.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_F4237 != null ) { var6_F4237.close(); var6_F4237 = null; }
                var7_F7140 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7140", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_F7140.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7140", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_F7140.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_F7140 != null ) { var7_F7140.close(); var7_F7140 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8023 != null ) { var2_F8023.close(); var2_F8023 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F8022 != null ) { var5_F8022.close(); var5_F8022 = null; }
                    if( var6_F4237 != null ) { var6_F4237.close(); var6_F4237 = null; }
                    if( var7_F7140 != null ) { var7_F7140.close(); var7_F7140 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq72_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq72_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq72_join closure;
            IEnumerator var2_F5243;
            IEnumerator var3_F1131_1;
            IEnumerator var4_F3055_1;
            IEnumerator var5_F5242;
            IEnumerator var6_F5275_1;
            IEnumerator var7_F1131_2;
            IEnumerator var8_F3055_2;
            IEnumerator var9_F5275_2;
            IEnumerator var10_F1131_3;
            IEnumerator var11_F3055_3;
            public Enumerator(seq72_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 27:	if (moveNext_27()) return true; break;
                        case 29:	if (moveNext_29()) return true; break;
                        case 30:	if (moveNext_30()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F5243 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5243", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F5243.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5243", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F5243.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F5243 != null ) { var2_F5243.close(); var2_F5243 = null; }
                var3_F1131_1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131_1", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131_1.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131_1", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131_1.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131_1 != null ) { var3_F1131_1.close(); var3_F1131_1 = null; }
                var4_F3055_1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055_1", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055_1.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055_1", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055_1.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3055_1 != null ) { var4_F3055_1.close(); var4_F3055_1 = null; }
                var5_F5242 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5242", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F5242.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5242", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F5242.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F5242 != null ) { var5_F5242.close(); var5_F5242 = null; }
                var6_F5275_1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5275_1", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F5275_1.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5275_1", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F5275_1.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_F5275_1 != null ) { var6_F5275_1.close(); var6_F5275_1 = null; }
                var7_F1131_2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131_2", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_F1131_2.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131_2", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_F1131_2.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_F1131_2 != null ) { var7_F1131_2.close(); var7_F1131_2 = null; }
                var8_F3055_2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055_2", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_F3055_2.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055_2", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_F3055_2.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_F3055_2 != null ) { var8_F3055_2.close(); var8_F3055_2 = null; }
                var9_F5275_2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5275_2", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_F5275_2.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5275_2", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_F5275_2.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_F5275_2 != null ) { var9_F5275_2.close(); var9_F5275_2 = null; }
                var10_F1131_3 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131_3", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_F1131_3.moveNext()) {state = 27; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131_3", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_F1131_3.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 29;
                if( var10_F1131_3 != null ) { var10_F1131_3.close(); var10_F1131_3 = null; }
                var11_F3055_3 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055_3", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 29;
                if (!var11_F3055_3.moveNext()) {state = 30; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055_3", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_F3055_3.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_30() throws Exception {
                state = 0;
                if( var11_F3055_3 != null ) { var11_F3055_3.close(); var11_F3055_3 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F5243 != null ) { var2_F5243.close(); var2_F5243 = null; }
                    if( var3_F1131_1 != null ) { var3_F1131_1.close(); var3_F1131_1 = null; }
                    if( var4_F3055_1 != null ) { var4_F3055_1.close(); var4_F3055_1 = null; }
                    if( var5_F5242 != null ) { var5_F5242.close(); var5_F5242 = null; }
                    if( var6_F5275_1 != null ) { var6_F5275_1.close(); var6_F5275_1 = null; }
                    if( var7_F1131_2 != null ) { var7_F1131_2.close(); var7_F1131_2 = null; }
                    if( var8_F3055_2 != null ) { var8_F3055_2.close(); var8_F3055_2 = null; }
                    if( var9_F5275_2 != null ) { var9_F5275_2.close(); var9_F5275_2 = null; }
                    if( var10_F1131_3 != null ) { var10_F1131_3.close(); var10_F1131_3 = null; }
                    if( var11_F3055_3 != null ) { var11_F3055_3.close(); var11_F3055_3 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq73_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq73_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq73_join closure;
            IEnumerator var2_F7357;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            public Enumerator(seq73_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7357 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7357", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7357.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7357", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7357.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7357 != null ) { var2_F7357.close(); var2_F7357 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7357 != null ) { var2_F7357.close(); var2_F7357 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq74_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq74_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq74_join closure;
            IEnumerator var2_F5243;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            public Enumerator(seq74_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F5243 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5243", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F5243.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5243", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F5243.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F5243 != null ) { var2_F5243.close(); var2_F5243 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F5243 != null ) { var2_F5243.close(); var2_F5243 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq75_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq75_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq75_join closure;
            IEnumerator var2_F5213;
            IEnumerator var3_C509;
            public Enumerator(seq75_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F5213 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5213", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F5213.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5213", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F5213.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F5213 != null ) { var2_F5213.close(); var2_F5213 = null; }
                var3_C509 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C509", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C509.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C509", (new seq76_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C509.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_C509 != null ) { var3_C509.close(); var3_C509 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F5213 != null ) { var2_F5213.close(); var2_F5213 = null; }
                    if( var3_C509 != null ) { var3_C509.close(); var3_C509 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq76_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq76_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq76_join closure;
            IEnumerator var2_F5125;
            IEnumerator var3_F5118;
            IEnumerator var4_F5375;
            IEnumerator var5_F5387;
            IEnumerator var6_F5284;
            IEnumerator var7_F6411;
            public Enumerator(seq76_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F5125 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5125", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F5125.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5125", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F5125.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F5125 != null ) { var2_F5125.close(); var2_F5125 = null; }
                var3_F5118 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5118", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F5118.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5118", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F5118.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F5118 != null ) { var3_F5118.close(); var3_F5118 = null; }
                var4_F5375 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5375", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F5375.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5375", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F5375.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F5375 != null ) { var4_F5375.close(); var4_F5375 = null; }
                var5_F5387 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5387", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F5387.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5387", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F5387.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F5387 != null ) { var5_F5387.close(); var5_F5387 = null; }
                var6_F5284 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5284", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F5284.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5284", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F5284.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_F5284 != null ) { var6_F5284.close(); var6_F5284 = null; }
                var7_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_F6411.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6411", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_F6411.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_F6411 != null ) { var7_F6411.close(); var7_F6411 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F5125 != null ) { var2_F5125.close(); var2_F5125 = null; }
                    if( var3_F5118 != null ) { var3_F5118.close(); var3_F5118 = null; }
                    if( var4_F5375 != null ) { var4_F5375.close(); var4_F5375 = null; }
                    if( var5_F5387 != null ) { var5_F5387.close(); var5_F5387 = null; }
                    if( var6_F5284 != null ) { var6_F5284.close(); var6_F5284 = null; }
                    if( var7_F6411 != null ) { var7_F6411.close(); var7_F6411 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq77_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq77_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq77_map closure;
            IEnumerator var2_C523;
            public Enumerator(seq77_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_C523 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C523", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C523.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C523", (new seq78_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C523.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_C523 != null ) { var2_C523.close(); var2_C523 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_C523 != null ) { var2_C523.close(); var2_C523 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq78_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq78_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq78_join closure;
            IEnumerator var2_F6350;
            IEnumerator var3_F6353;
            public Enumerator(seq78_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6350 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6350", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F6350.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6350", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F6350.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F6350 != null ) { var2_F6350.close(); var2_F6350 = null; }
                var3_F6353 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6353", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F6353.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6353", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F6353.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F6353 != null ) { var3_F6353.close(); var3_F6353 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F6350 != null ) { var2_F6350.close(); var2_F6350 = null; }
                    if( var3_F6353 != null ) { var3_F6353.close(); var3_F6353 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq79_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq79_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq79_map closure;
            IEnumerator var2_C501;
            public Enumerator(seq79_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_C501 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C501", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C501.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C501", (new seq80_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C501.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_C501 != null ) { var2_C501.close(); var2_C501 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_C501 != null ) { var2_C501.close(); var2_C501 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq80_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq80_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq80_join closure;
            IEnumerator var2_F5245;
            IEnumerator var3_F5482;
            IEnumerator var4_F5249;
            IEnumerator var5_F1131;
            IEnumerator var6_F3055;
            public Enumerator(seq80_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F5245 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5245", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F5245.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5245", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F5245.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F5245 != null ) { var2_F5245.close(); var2_F5245 = null; }
                var3_F5482 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5482", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F5482.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5482", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F5482.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F5482 != null ) { var3_F5482.close(); var3_F5482 = null; }
                var4_F5249 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5249", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F5249.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5249", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F5249.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F5249 != null ) { var4_F5249.close(); var4_F5249 = null; }
                var5_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F1131.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F1131 != null ) { var5_F1131.close(); var5_F1131 = null; }
                var6_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F3055.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_F3055 != null ) { var6_F3055.close(); var6_F3055 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F5245 != null ) { var2_F5245.close(); var2_F5245 = null; }
                    if( var3_F5482 != null ) { var3_F5482.close(); var3_F5482 = null; }
                    if( var4_F5249 != null ) { var4_F5249.close(); var4_F5249 = null; }
                    if( var5_F1131 != null ) { var5_F1131.close(); var5_F1131 = null; }
                    if( var6_F3055 != null ) { var6_F3055.close(); var6_F3055 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq81_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq81_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq81_map closure;
            IEnumerator var2_C186;
            public Enumerator(seq81_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_C186 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C186", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C186.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C186", (new seq82_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C186.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_C186 != null ) { var2_C186.close(); var2_C186 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_C186 != null ) { var2_C186.close(); var2_C186 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq82_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq82_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq82_join closure;
            IEnumerator var2_F6063;
            IEnumerator var3_F6060;
            IEnumerator var4_F6411;
            public Enumerator(seq82_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6063 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6063", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F6063.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6063", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F6063.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F6063 != null ) { var2_F6063.close(); var2_F6063 = null; }
                var3_F6060 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6060", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F6060.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6060", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F6060.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F6060 != null ) { var3_F6060.close(); var3_F6060 = null; }
                var4_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F6411.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6411", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F6411.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F6411 != null ) { var4_F6411.close(); var4_F6411 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F6063 != null ) { var2_F6063.close(); var2_F6063 = null; }
                    if( var3_F6060 != null ) { var3_F6060.close(); var3_F6060 = null; }
                    if( var4_F6411 != null ) { var4_F6411.close(); var4_F6411 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq83_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq83_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq83_join closure;
            IEnumerator var2_TDT;
            IEnumerator var3_DTM;
            IEnumerator var4_TSR;
            IEnumerator var5_SG9;
            IEnumerator var6_SG10;
            public Enumerator(seq83_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_TDT = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TDT", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_TDT.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TDT", (new seq84_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_TDT.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_TDT != null ) { var2_TDT.close(); var2_TDT = null; }
                var3_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_DTM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq28_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                var4_TSR = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TSR", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_TSR.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TSR", (new seq30_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_TSR.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_TSR != null ) { var4_TSR.close(); var4_TSR = null; }
                var5_SG9 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG9", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_SG9.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG9", (new seq47_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_SG9.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_SG9 != null ) { var5_SG9.close(); var5_SG9 = null; }
                var6_SG10 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG10", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_SG10.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG10", (new seq55_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_SG10.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_SG10 != null ) { var6_SG10.close(); var6_SG10 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_TDT != null ) { var2_TDT.close(); var2_TDT = null; }
                    if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                    if( var4_TSR != null ) { var4_TSR.close(); var4_TSR = null; }
                    if( var5_SG9 != null ) { var5_SG9.close(); var5_SG9 = null; }
                    if( var6_SG10 != null ) { var6_SG10.close(); var6_SG10 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq84_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq84_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq84_join closure;
            IEnumerator var2_F8051;
            IEnumerator var3_F8028;
            IEnumerator var4_F8101;
            IEnumerator var5_F8281;
            IEnumerator var6_C220;
            IEnumerator var7_C228;
            IEnumerator var8_C040;
            IEnumerator var9_C401;
            IEnumerator var10_C222;
            public Enumerator(seq84_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 27:	if (moveNext_27()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8051", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8051.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8051", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8051.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8051 != null ) { var2_F8051.close(); var2_F8051 = null; }
                var3_F8028 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8028", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F8028.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8028", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F8028.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F8028 != null ) { var3_F8028.close(); var3_F8028 = null; }
                var4_F8101 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8101", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F8101.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8101", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F8101.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F8101 != null ) { var4_F8101.close(); var4_F8101 = null; }
                var5_F8281 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8281", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F8281.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8281", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F8281.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F8281 != null ) { var5_F8281.close(); var5_F8281 = null; }
                var6_C220 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C220", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_C220.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C220", (new seq85_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C220.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_C220 != null ) { var6_C220.close(); var6_C220 = null; }
                var7_C228 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C228", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_C228.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C228", (new seq86_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_C228.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_C228 != null ) { var7_C228.close(); var7_C228 = null; }
                var8_C040 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C040", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_C040.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C040", (new seq87_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_C040.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_C040 != null ) { var8_C040.close(); var8_C040 = null; }
                var9_C401 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C401", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_C401.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C401", (new seq88_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_C401.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_C401 != null ) { var9_C401.close(); var9_C401 = null; }
                var10_C222 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C222", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_C222.moveNext()) {state = 27; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C222", (new seq89_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_C222.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 0;
                if( var10_C222 != null ) { var10_C222.close(); var10_C222 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8051 != null ) { var2_F8051.close(); var2_F8051 = null; }
                    if( var3_F8028 != null ) { var3_F8028.close(); var3_F8028 = null; }
                    if( var4_F8101 != null ) { var4_F8101.close(); var4_F8101 = null; }
                    if( var5_F8281 != null ) { var5_F8281.close(); var5_F8281 = null; }
                    if( var6_C220 != null ) { var6_C220.close(); var6_C220 = null; }
                    if( var7_C228 != null ) { var7_C228.close(); var7_C228 = null; }
                    if( var8_C040 != null ) { var8_C040.close(); var8_C040 = null; }
                    if( var9_C401 != null ) { var9_C401.close(); var9_C401 = null; }
                    if( var10_C222 != null ) { var10_C222.close(); var10_C222 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq85_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq85_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq85_join closure;
            IEnumerator var2_F8067;
            IEnumerator var3_F8066;
            public Enumerator(seq85_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8067 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8067", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8067.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8067", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8067.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8067 != null ) { var2_F8067.close(); var2_F8067 = null; }
                var3_F8066 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8066", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F8066.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8066", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F8066.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F8066 != null ) { var3_F8066.close(); var3_F8066 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8067 != null ) { var2_F8067.close(); var2_F8067 = null; }
                    if( var3_F8066 != null ) { var3_F8066.close(); var3_F8066 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq86_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq86_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq86_join closure;
            IEnumerator var2_F8179;
            IEnumerator var3_F8178;
            public Enumerator(seq86_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8179 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8179", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8179.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8179", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8179.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8179 != null ) { var2_F8179.close(); var2_F8179 = null; }
                var3_F8178 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8178", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F8178.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8178", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F8178.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F8178 != null ) { var3_F8178.close(); var3_F8178 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8179 != null ) { var2_F8179.close(); var2_F8179 = null; }
                    if( var3_F8178 != null ) { var3_F8178.close(); var3_F8178 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq87_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq87_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq87_join closure;
            IEnumerator var2_F3127;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F3128;
            public Enumerator(seq87_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3127 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3127", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3127.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3127", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3127.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3127 != null ) { var2_F3127.close(); var2_F3127 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                var5_F3128 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3128", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F3128.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3128", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F3128.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F3128 != null ) { var5_F3128.close(); var5_F3128 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3127 != null ) { var2_F3127.close(); var2_F3127 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F3128 != null ) { var5_F3128.close(); var5_F3128 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq88_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq88_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq88_join closure;
            IEnumerator var2_F8457;
            IEnumerator var3_F8459;
            IEnumerator var4_F7130;
            public Enumerator(seq88_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8457 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8457", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8457.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8457", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8457.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8457 != null ) { var2_F8457.close(); var2_F8457 = null; }
                var3_F8459 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8459", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F8459.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8459", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F8459.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F8459 != null ) { var3_F8459.close(); var3_F8459 = null; }
                var4_F7130 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7130", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F7130.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7130", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F7130.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F7130 != null ) { var4_F7130.close(); var4_F7130 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8457 != null ) { var2_F8457.close(); var2_F8457 = null; }
                    if( var3_F8459 != null ) { var3_F8459.close(); var3_F8459 = null; }
                    if( var4_F7130 != null ) { var4_F7130.close(); var4_F7130 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq89_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq89_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq89_join closure;
            IEnumerator var2_F8213;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F8212;
            IEnumerator var6_F8453;
            public Enumerator(seq89_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8213 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8213", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8213.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8213", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8213.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8213 != null ) { var2_F8213.close(); var2_F8213 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                var5_F8212 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8212", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F8212.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8212", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F8212.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F8212 != null ) { var5_F8212.close(); var5_F8212 = null; }
                var6_F8453 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8453", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F8453.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8453", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F8453.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_F8453 != null ) { var6_F8453.close(); var6_F8453 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8213 != null ) { var2_F8213.close(); var2_F8213 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F8212 != null ) { var5_F8212.close(); var5_F8212 = null; }
                    if( var6_F8453 != null ) { var6_F8453.close(); var6_F8453 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq90_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq90_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq90_join closure;
            IEnumerator var2_NAD;
            IEnumerator var3_LOC;
            IEnumerator var4_MOA;
            IEnumerator var5_SG12;
            IEnumerator var6_SG13;
            IEnumerator var7_SG14;
            IEnumerator var8_SG15;
            IEnumerator var9_SG16;
            IEnumerator var10_SG17;
            public Enumerator(seq90_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 27:	if (moveNext_27()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_NAD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("NAD", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_NAD.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("NAD", (new seq91_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_NAD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_NAD != null ) { var2_NAD.close(); var2_NAD = null; }
                var3_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_LOC.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq48_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_LOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_LOC != null ) { var3_LOC.close(); var3_LOC = null; }
                var4_MOA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MOA", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_MOA.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MOA", (new seq37_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_MOA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_MOA != null ) { var4_MOA.close(); var4_MOA = null; }
                var5_SG12 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG12", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_SG12.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG12", (new seq97_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_SG12.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_SG12 != null ) { var5_SG12.close(); var5_SG12 = null; }
                var6_SG13 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG13", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_SG13.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG13", (new seq64_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_SG13.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_SG13 != null ) { var6_SG13.close(); var6_SG13 = null; }
                var7_SG14 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG14", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_SG14.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG14", (new seq98_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_SG14.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_SG14 != null ) { var7_SG14.close(); var7_SG14 = null; }
                var8_SG15 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG15", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_SG15.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG15", (new seq55_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_SG15.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_SG15 != null ) { var8_SG15.close(); var8_SG15 = null; }
                var9_SG16 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG16", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_SG16.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG16", (new seq65_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_SG16.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_SG16 != null ) { var9_SG16.close(); var9_SG16 = null; }
                var10_SG17 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG17", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_SG17.moveNext()) {state = 27; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG17", (new seq99_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_SG17.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 0;
                if( var10_SG17 != null ) { var10_SG17.close(); var10_SG17 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_NAD != null ) { var2_NAD.close(); var2_NAD = null; }
                    if( var3_LOC != null ) { var3_LOC.close(); var3_LOC = null; }
                    if( var4_MOA != null ) { var4_MOA.close(); var4_MOA = null; }
                    if( var5_SG12 != null ) { var5_SG12.close(); var5_SG12 = null; }
                    if( var6_SG13 != null ) { var6_SG13.close(); var6_SG13 = null; }
                    if( var7_SG14 != null ) { var7_SG14.close(); var7_SG14 = null; }
                    if( var8_SG15 != null ) { var8_SG15.close(); var8_SG15 = null; }
                    if( var9_SG16 != null ) { var9_SG16.close(); var9_SG16 = null; }
                    if( var10_SG17 != null ) { var10_SG17.close(); var10_SG17 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq91_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq91_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq91_join closure;
            IEnumerator var2_F3035;
            IEnumerator var3_F3164;
            IEnumerator var4_F3251;
            IEnumerator var5_F3207;
            IEnumerator var6_C082;
            IEnumerator var7_C058;
            IEnumerator var8_C080;
            IEnumerator var9_C059;
            IEnumerator var10_C819;
            public Enumerator(seq91_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 27:	if (moveNext_27()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3035 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3035", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3035.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3035", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3035.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3035 != null ) { var2_F3035.close(); var2_F3035 = null; }
                var3_F3164 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3164", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F3164.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3164", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F3164.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F3164 != null ) { var3_F3164.close(); var3_F3164 = null; }
                var4_F3251 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3251", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3251.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3251", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3251.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3251 != null ) { var4_F3251.close(); var4_F3251 = null; }
                var5_F3207 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3207", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F3207.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3207", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F3207.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F3207 != null ) { var5_F3207.close(); var5_F3207 = null; }
                var6_C082 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C082", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_C082.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C082", (new seq92_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C082.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_C082 != null ) { var6_C082.close(); var6_C082 = null; }
                var7_C058 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C058", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_C058.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C058", (new seq93_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_C058.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_C058 != null ) { var7_C058.close(); var7_C058 = null; }
                var8_C080 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C080", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_C080.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C080", (new seq94_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_C080.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_C080 != null ) { var8_C080.close(); var8_C080 = null; }
                var9_C059 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C059", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_C059.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C059", (new seq95_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_C059.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_C059 != null ) { var9_C059.close(); var9_C059 = null; }
                var10_C819 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C819", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_C819.moveNext()) {state = 27; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C819", (new seq96_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_C819.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 0;
                if( var10_C819 != null ) { var10_C819.close(); var10_C819 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3035 != null ) { var2_F3035.close(); var2_F3035 = null; }
                    if( var3_F3164 != null ) { var3_F3164.close(); var3_F3164 = null; }
                    if( var4_F3251 != null ) { var4_F3251.close(); var4_F3251 = null; }
                    if( var5_F3207 != null ) { var5_F3207.close(); var5_F3207 = null; }
                    if( var6_C082 != null ) { var6_C082.close(); var6_C082 = null; }
                    if( var7_C058 != null ) { var7_C058.close(); var7_C058 = null; }
                    if( var8_C080 != null ) { var8_C080.close(); var8_C080 = null; }
                    if( var9_C059 != null ) { var9_C059.close(); var9_C059 = null; }
                    if( var10_C819 != null ) { var10_C819.close(); var10_C819 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq92_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq92_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq92_join closure;
            IEnumerator var2_F3039;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            public Enumerator(seq92_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3039 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3039", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3039.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3039", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3039.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3039 != null ) { var2_F3039.close(); var2_F3039 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3039 != null ) { var2_F3039.close(); var2_F3039 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq93_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq93_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq93_map closure;
            IEnumerator var2_F3124;
            public Enumerator(seq93_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3124 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3124", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3124.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3124", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3124.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_F3124 != null ) { var2_F3124.close(); var2_F3124 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3124 != null ) { var2_F3124.close(); var2_F3124 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq94_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq94_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq94_join closure;
            IEnumerator var2_F3036;
            IEnumerator var3_F3045;
            public Enumerator(seq94_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3036 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3036", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3036.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3036", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3036.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3036 != null ) { var2_F3036.close(); var2_F3036 = null; }
                var3_F3045 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3045", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F3045.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3045", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F3045.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F3045 != null ) { var3_F3045.close(); var3_F3045 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3036 != null ) { var2_F3036.close(); var2_F3036 = null; }
                    if( var3_F3045 != null ) { var3_F3045.close(); var3_F3045 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq95_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq95_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq95_map closure;
            IEnumerator var2_F3042;
            public Enumerator(seq95_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3042 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3042", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3042.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3042", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3042.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_F3042 != null ) { var2_F3042.close(); var2_F3042 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3042 != null ) { var2_F3042.close(); var2_F3042 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq96_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq96_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq96_join closure;
            IEnumerator var2_F3229;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F3228;
            public Enumerator(seq96_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3229 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3229", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3229.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3229", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3229.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3229 != null ) { var2_F3229.close(); var2_F3229 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                var5_F3228 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3228", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F3228.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3228", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F3228.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F3228 != null ) { var5_F3228.close(); var5_F3228 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3229 != null ) { var2_F3229.close(); var2_F3229 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F3228 != null ) { var5_F3228.close(); var5_F3228 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq97_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq97_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq97_join closure;
            IEnumerator var2_CTA;
            IEnumerator var3_COM;
            public Enumerator(seq97_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_CTA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CTA", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_CTA.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("CTA", (new seq24_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_CTA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_CTA != null ) { var2_CTA.close(); var2_CTA = null; }
                var3_COM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("COM", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_COM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("COM", (new seq26_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_COM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_COM != null ) { var3_COM.close(); var3_COM = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_CTA != null ) { var2_CTA.close(); var2_CTA = null; }
                    if( var3_COM != null ) { var3_COM.close(); var3_COM = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq98_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq98_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq98_join closure;
            IEnumerator var2_TCC;
            IEnumerator var3_CUX;
            IEnumerator var4_PRI;
            IEnumerator var5_EQN;
            IEnumerator var6_PCD;
            IEnumerator var7_MOA;
            IEnumerator var8_QTY;
            public Enumerator(seq98_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_TCC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TCC", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_TCC.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TCC", (new seq70_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_TCC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_TCC != null ) { var2_TCC.close(); var2_TCC = null; }
                var3_CUX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CUX", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_CUX.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("CUX", (new seq35_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_CUX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_CUX != null ) { var3_CUX.close(); var3_CUX = null; }
                var4_PRI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PRI", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_PRI.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PRI", (new seq75_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_PRI.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_PRI != null ) { var4_PRI.close(); var4_PRI = null; }
                var5_EQN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("EQN", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_EQN.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("EQN", (new seq77_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_EQN.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_EQN != null ) { var5_EQN.close(); var5_EQN = null; }
                var6_PCD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PCD", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_PCD.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PCD", (new seq79_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_PCD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_PCD != null ) { var6_PCD.close(); var6_PCD = null; }
                var7_MOA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MOA", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_MOA.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MOA", (new seq37_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_MOA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_MOA != null ) { var7_MOA.close(); var7_MOA = null; }
                var8_QTY = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("QTY", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_QTY.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("QTY", (new seq81_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_QTY.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 0;
                if( var8_QTY != null ) { var8_QTY.close(); var8_QTY = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_TCC != null ) { var2_TCC.close(); var2_TCC = null; }
                    if( var3_CUX != null ) { var3_CUX.close(); var3_CUX = null; }
                    if( var4_PRI != null ) { var4_PRI.close(); var4_PRI = null; }
                    if( var5_EQN != null ) { var5_EQN.close(); var5_EQN = null; }
                    if( var6_PCD != null ) { var6_PCD.close(); var6_PCD = null; }
                    if( var7_MOA != null ) { var7_MOA.close(); var7_MOA = null; }
                    if( var8_QTY != null ) { var8_QTY.close(); var8_QTY = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq99_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq99_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq99_join closure;
            IEnumerator var2_TSR;
            IEnumerator var3_RFF;
            IEnumerator var4_LOC;
            IEnumerator var5_TPL;
            IEnumerator var6_FTX;
            public Enumerator(seq99_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_TSR = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TSR", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_TSR.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TSR", (new seq30_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_TSR.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_TSR != null ) { var2_TSR.close(); var2_TSR = null; }
                var3_RFF = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RFF", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_RFF.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("RFF", (new seq56_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_RFF.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_RFF != null ) { var3_RFF.close(); var3_RFF = null; }
                var4_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_LOC.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq48_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_LOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_LOC != null ) { var4_LOC.close(); var4_LOC = null; }
                var5_TPL = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TPL", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_TPL.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TPL", (new seq100_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_TPL.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_TPL != null ) { var5_TPL.close(); var5_TPL = null; }
                var6_FTX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FTX", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_FTX.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("FTX", (new seq39_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_FTX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_FTX != null ) { var6_FTX.close(); var6_FTX = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_TSR != null ) { var2_TSR.close(); var2_TSR = null; }
                    if( var3_RFF != null ) { var3_RFF.close(); var3_RFF = null; }
                    if( var4_LOC != null ) { var4_LOC.close(); var4_LOC = null; }
                    if( var5_TPL != null ) { var5_TPL.close(); var5_TPL = null; }
                    if( var6_FTX != null ) { var6_FTX.close(); var6_FTX = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq100_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq100_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq100_map closure;
            IEnumerator var2_C222;
            public Enumerator(seq100_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_C222 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C222", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C222.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C222", (new seq89_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C222.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_C222 != null ) { var2_C222.close(); var2_C222 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_C222 != null ) { var2_C222.close(); var2_C222 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq101_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq101_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq101_join closure;
            IEnumerator var2_GID;
            IEnumerator var3_HAN;
            IEnumerator var4_TMP;
            IEnumerator var5_RNG;
            IEnumerator var6_TMD;
            IEnumerator var7_LOC;
            IEnumerator var8_MOA;
            IEnumerator var9_PIA;
            IEnumerator var10_FTX;
            IEnumerator var11_PCD;
            IEnumerator var12_SG19;
            IEnumerator var13_GDS;
            IEnumerator var14_SG20;
            IEnumerator var15_SG21;
            IEnumerator var16_SG22;
            IEnumerator var17_SG23;
            IEnumerator var18_SG24;
            IEnumerator var19_SG25;
            IEnumerator var20_SG27;
            IEnumerator var21_SG29;
            IEnumerator var22_SG31;
            IEnumerator var23_SG32;
            public Enumerator(seq101_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 27:	if (moveNext_27()) return true; break;
                        case 29:	if (moveNext_29()) return true; break;
                        case 30:	if (moveNext_30()) return true; break;
                        case 32:	if (moveNext_32()) return true; break;
                        case 33:	if (moveNext_33()) return true; break;
                        case 35:	if (moveNext_35()) return true; break;
                        case 36:	if (moveNext_36()) return true; break;
                        case 38:	if (moveNext_38()) return true; break;
                        case 39:	if (moveNext_39()) return true; break;
                        case 41:	if (moveNext_41()) return true; break;
                        case 42:	if (moveNext_42()) return true; break;
                        case 44:	if (moveNext_44()) return true; break;
                        case 45:	if (moveNext_45()) return true; break;
                        case 47:	if (moveNext_47()) return true; break;
                        case 48:	if (moveNext_48()) return true; break;
                        case 50:	if (moveNext_50()) return true; break;
                        case 51:	if (moveNext_51()) return true; break;
                        case 53:	if (moveNext_53()) return true; break;
                        case 54:	if (moveNext_54()) return true; break;
                        case 56:	if (moveNext_56()) return true; break;
                        case 57:	if (moveNext_57()) return true; break;
                        case 59:	if (moveNext_59()) return true; break;
                        case 60:	if (moveNext_60()) return true; break;
                        case 62:	if (moveNext_62()) return true; break;
                        case 63:	if (moveNext_63()) return true; break;
                        case 65:	if (moveNext_65()) return true; break;
                        case 66:	if (moveNext_66()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_GID = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("GID", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_GID.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("GID", (new seq102_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_GID.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_GID != null ) { var2_GID.close(); var2_GID = null; }
                var3_HAN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("HAN", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_HAN.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("HAN", (new seq104_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_HAN.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_HAN != null ) { var3_HAN.close(); var3_HAN = null; }
                var4_TMP = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TMP", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_TMP.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TMP", (new seq107_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_TMP.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_TMP != null ) { var4_TMP.close(); var4_TMP = null; }
                var5_RNG = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RNG", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_RNG.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("RNG", (new seq109_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_RNG.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_RNG != null ) { var5_RNG.close(); var5_RNG = null; }
                var6_TMD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TMD", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_TMD.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TMD", (new seq111_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_TMD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_TMD != null ) { var6_TMD.close(); var6_TMD = null; }
                var7_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_LOC.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq48_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_LOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_LOC != null ) { var7_LOC.close(); var7_LOC = null; }
                var8_MOA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MOA", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_MOA.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MOA", (new seq37_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_MOA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_MOA != null ) { var8_MOA.close(); var8_MOA = null; }
                var9_PIA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PIA", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_PIA.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PIA", (new seq113_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_PIA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_PIA != null ) { var9_PIA.close(); var9_PIA = null; }
                var10_FTX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FTX", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_FTX.moveNext()) {state = 27; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("FTX", (new seq39_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_FTX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 29;
                if( var10_FTX != null ) { var10_FTX.close(); var10_FTX = null; }
                var11_PCD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PCD", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 29;
                if (!var11_PCD.moveNext()) {state = 30; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PCD", (new seq79_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_PCD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_30() throws Exception {
                state = 32;
                if( var11_PCD != null ) { var11_PCD.close(); var11_PCD = null; }
                var12_SG19 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG19", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_32() throws Exception {
                state = 32;
                if (!var12_SG19.moveNext()) {state = 33; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG19", (new seq115_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var12_SG19.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_33() throws Exception {
                state = 35;
                if( var12_SG19 != null ) { var12_SG19.close(); var12_SG19 = null; }
                var13_GDS = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("GDS", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_35() throws Exception {
                state = 35;
                if (!var13_GDS.moveNext()) {state = 36; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("GDS", (new seq46_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var13_GDS.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_36() throws Exception {
                state = 38;
                if( var13_GDS != null ) { var13_GDS.close(); var13_GDS = null; }
                var14_SG20 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG20", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_38() throws Exception {
                state = 38;
                if (!var14_SG20.moveNext()) {state = 39; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG20", (new seq116_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var14_SG20.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_39() throws Exception {
                state = 41;
                if( var14_SG20 != null ) { var14_SG20.close(); var14_SG20 = null; }
                var15_SG21 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG21", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_41() throws Exception {
                state = 41;
                if (!var15_SG21.moveNext()) {state = 42; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG21", (new seq120_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var15_SG21.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_42() throws Exception {
                state = 44;
                if( var15_SG21 != null ) { var15_SG21.close(); var15_SG21 = null; }
                var16_SG22 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG22", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_44() throws Exception {
                state = 44;
                if (!var16_SG22.moveNext()) {state = 45; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG22", (new seq55_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var16_SG22.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_45() throws Exception {
                state = 47;
                if( var16_SG22 != null ) { var16_SG22.close(); var16_SG22 = null; }
                var17_SG23 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG23", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_47() throws Exception {
                state = 47;
                if (!var17_SG23.moveNext()) {state = 48; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG23", (new seq123_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var17_SG23.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_48() throws Exception {
                state = 50;
                if( var17_SG23 != null ) { var17_SG23.close(); var17_SG23 = null; }
                var18_SG24 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG24", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_50() throws Exception {
                state = 50;
                if (!var18_SG24.moveNext()) {state = 51; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG24", (new seq64_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var18_SG24.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_51() throws Exception {
                state = 53;
                if( var18_SG24 != null ) { var18_SG24.close(); var18_SG24 = null; }
                var19_SG25 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG25", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_53() throws Exception {
                state = 53;
                if (!var19_SG25.moveNext()) {state = 54; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG25", (new seq128_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var19_SG25.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_54() throws Exception {
                state = 56;
                if( var19_SG25 != null ) { var19_SG25.close(); var19_SG25 = null; }
                var20_SG27 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG27", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_56() throws Exception {
                state = 56;
                if (!var20_SG27.moveNext()) {state = 57; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG27", (new seq129_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var20_SG27.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_57() throws Exception {
                state = 59;
                if( var20_SG27 != null ) { var20_SG27.close(); var20_SG27 = null; }
                var21_SG29 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG29", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_59() throws Exception {
                state = 59;
                if (!var21_SG29.moveNext()) {state = 60; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG29", (new seq130_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var21_SG29.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_60() throws Exception {
                state = 62;
                if( var21_SG29 != null ) { var21_SG29.close(); var21_SG29 = null; }
                var22_SG31 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG31", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_62() throws Exception {
                state = 62;
                if (!var22_SG31.moveNext()) {state = 63; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG31", (new seq133_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var22_SG31.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_63() throws Exception {
                state = 65;
                if( var22_SG31 != null ) { var22_SG31.close(); var22_SG31 = null; }
                var23_SG32 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG32", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_65() throws Exception {
                state = 65;
                if (!var23_SG32.moveNext()) {state = 66; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG32", (new seq134_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var23_SG32.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_66() throws Exception {
                state = 0;
                if( var23_SG32 != null ) { var23_SG32.close(); var23_SG32 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_GID != null ) { var2_GID.close(); var2_GID = null; }
                    if( var3_HAN != null ) { var3_HAN.close(); var3_HAN = null; }
                    if( var4_TMP != null ) { var4_TMP.close(); var4_TMP = null; }
                    if( var5_RNG != null ) { var5_RNG.close(); var5_RNG = null; }
                    if( var6_TMD != null ) { var6_TMD.close(); var6_TMD = null; }
                    if( var7_LOC != null ) { var7_LOC.close(); var7_LOC = null; }
                    if( var8_MOA != null ) { var8_MOA.close(); var8_MOA = null; }
                    if( var9_PIA != null ) { var9_PIA.close(); var9_PIA = null; }
                    if( var10_FTX != null ) { var10_FTX.close(); var10_FTX = null; }
                    if( var11_PCD != null ) { var11_PCD.close(); var11_PCD = null; }
                    if( var12_SG19 != null ) { var12_SG19.close(); var12_SG19 = null; }
                    if( var13_GDS != null ) { var13_GDS.close(); var13_GDS = null; }
                    if( var14_SG20 != null ) { var14_SG20.close(); var14_SG20 = null; }
                    if( var15_SG21 != null ) { var15_SG21.close(); var15_SG21 = null; }
                    if( var16_SG22 != null ) { var16_SG22.close(); var16_SG22 = null; }
                    if( var17_SG23 != null ) { var17_SG23.close(); var17_SG23 = null; }
                    if( var18_SG24 != null ) { var18_SG24.close(); var18_SG24 = null; }
                    if( var19_SG25 != null ) { var19_SG25.close(); var19_SG25 = null; }
                    if( var20_SG27 != null ) { var20_SG27.close(); var20_SG27 = null; }
                    if( var21_SG29 != null ) { var21_SG29.close(); var21_SG29 = null; }
                    if( var22_SG31 != null ) { var22_SG31.close(); var22_SG31 = null; }
                    if( var23_SG32 != null ) { var23_SG32.close(); var23_SG32 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq102_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq102_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq102_join closure;
            IEnumerator var2_F1496;
            IEnumerator var3_C213;
            public Enumerator(seq102_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F1496 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1496", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F1496.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1496", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F1496.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F1496 != null ) { var2_F1496.close(); var2_F1496 = null; }
                var3_C213 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C213", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C213.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C213", (new seq103_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C213.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_C213 != null ) { var3_C213.close(); var3_C213 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F1496 != null ) { var2_F1496.close(); var2_F1496 = null; }
                    if( var3_C213 != null ) { var3_C213.close(); var3_C213 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq103_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq103_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq103_join closure;
            IEnumerator var2_F7224;
            IEnumerator var3_F7065;
            IEnumerator var4_F1131;
            IEnumerator var5_F3055;
            IEnumerator var6_F7064;
            IEnumerator var7_F7233;
            public Enumerator(seq103_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7224 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7224", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7224.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7224", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7224.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7224 != null ) { var2_F7224.close(); var2_F7224 = null; }
                var3_F7065 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7065", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F7065.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7065", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F7065.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F7065 != null ) { var3_F7065.close(); var3_F7065 = null; }
                var4_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F1131.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F1131 != null ) { var4_F1131.close(); var4_F1131 = null; }
                var5_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F3055.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F3055 != null ) { var5_F3055.close(); var5_F3055 = null; }
                var6_F7064 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7064", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F7064.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7064", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F7064.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_F7064 != null ) { var6_F7064.close(); var6_F7064 = null; }
                var7_F7233 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7233", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_F7233.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7233", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_F7233.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_F7233 != null ) { var7_F7233.close(); var7_F7233 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7224 != null ) { var2_F7224.close(); var2_F7224 = null; }
                    if( var3_F7065 != null ) { var3_F7065.close(); var3_F7065 = null; }
                    if( var4_F1131 != null ) { var4_F1131.close(); var4_F1131 = null; }
                    if( var5_F3055 != null ) { var5_F3055.close(); var5_F3055 = null; }
                    if( var6_F7064 != null ) { var6_F7064.close(); var6_F7064 = null; }
                    if( var7_F7233 != null ) { var7_F7233.close(); var7_F7233 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq104_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq104_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq104_join closure;
            IEnumerator var2_C524;
            IEnumerator var3_C218;
            public Enumerator(seq104_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_C524 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C524", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C524.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C524", (new seq105_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C524.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_C524 != null ) { var2_C524.close(); var2_C524 = null; }
                var3_C218 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C218", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C218.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C218", (new seq106_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C218.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_C218 != null ) { var3_C218.close(); var3_C218 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_C524 != null ) { var2_C524.close(); var2_C524 = null; }
                    if( var3_C218 != null ) { var3_C218.close(); var3_C218 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq105_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq105_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq105_join closure;
            IEnumerator var2_F4079;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F4078;
            public Enumerator(seq105_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4079 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4079", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4079.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4079", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4079.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4079 != null ) { var2_F4079.close(); var2_F4079 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                var5_F4078 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4078", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F4078.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4078", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F4078.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F4078 != null ) { var5_F4078.close(); var5_F4078 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4079 != null ) { var2_F4079.close(); var2_F4079 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F4078 != null ) { var5_F4078.close(); var5_F4078 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq106_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq106_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq106_join closure;
            IEnumerator var2_F7419;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F7418;
            public Enumerator(seq106_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7419 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7419", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7419.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7419", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7419.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7419 != null ) { var2_F7419.close(); var2_F7419 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                var5_F7418 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7418", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F7418.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7418", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F7418.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F7418 != null ) { var5_F7418.close(); var5_F7418 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7419 != null ) { var2_F7419.close(); var2_F7419 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F7418 != null ) { var5_F7418.close(); var5_F7418 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq107_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq107_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq107_join closure;
            IEnumerator var2_F6245;
            IEnumerator var3_C239;
            public Enumerator(seq107_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6245 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6245", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F6245.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6245", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F6245.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F6245 != null ) { var2_F6245.close(); var2_F6245 = null; }
                var3_C239 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C239", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C239.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C239", (new seq108_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C239.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_C239 != null ) { var3_C239.close(); var3_C239 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F6245 != null ) { var2_F6245.close(); var2_F6245 = null; }
                    if( var3_C239 != null ) { var3_C239.close(); var3_C239 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq108_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq108_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq108_join closure;
            IEnumerator var2_F6246;
            IEnumerator var3_F6411;
            public Enumerator(seq108_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6246 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6246", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F6246.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6246", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F6246.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F6246 != null ) { var2_F6246.close(); var2_F6246 = null; }
                var3_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F6411.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6411", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F6411.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F6411 != null ) { var3_F6411.close(); var3_F6411 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F6246 != null ) { var2_F6246.close(); var2_F6246 = null; }
                    if( var3_F6411 != null ) { var3_F6411.close(); var3_F6411 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq109_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq109_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq109_join closure;
            IEnumerator var2_F6167;
            IEnumerator var3_C280;
            public Enumerator(seq109_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6167 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6167", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F6167.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6167", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F6167.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F6167 != null ) { var2_F6167.close(); var2_F6167 = null; }
                var3_C280 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C280", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C280.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C280", (new seq110_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C280.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_C280 != null ) { var3_C280.close(); var3_C280 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F6167 != null ) { var2_F6167.close(); var2_F6167 = null; }
                    if( var3_C280 != null ) { var3_C280.close(); var3_C280 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq110_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq110_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq110_join closure;
            IEnumerator var2_F6411;
            IEnumerator var3_F6162;
            IEnumerator var4_F6152;
            public Enumerator(seq110_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F6411.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6411", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F6411.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F6411 != null ) { var2_F6411.close(); var2_F6411 = null; }
                var3_F6162 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6162", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F6162.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6162", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F6162.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F6162 != null ) { var3_F6162.close(); var3_F6162 = null; }
                var4_F6152 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6152", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F6152.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6152", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F6152.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F6152 != null ) { var4_F6152.close(); var4_F6152 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F6411 != null ) { var2_F6411.close(); var2_F6411 = null; }
                    if( var3_F6162 != null ) { var3_F6162.close(); var3_F6162 = null; }
                    if( var4_F6152 != null ) { var4_F6152.close(); var4_F6152 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq111_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq111_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq111_join closure;
            IEnumerator var2_F8332;
            IEnumerator var3_F8341;
            IEnumerator var4_C219;
            public Enumerator(seq111_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8332 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8332", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8332.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8332", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8332.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8332 != null ) { var2_F8332.close(); var2_F8332 = null; }
                var3_F8341 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8341", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F8341.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8341", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F8341.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F8341 != null ) { var3_F8341.close(); var3_F8341 = null; }
                var4_C219 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C219", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C219.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C219", (new seq112_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C219.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_C219 != null ) { var4_C219.close(); var4_C219 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8332 != null ) { var2_F8332.close(); var2_F8332 = null; }
                    if( var3_F8341 != null ) { var3_F8341.close(); var3_F8341 = null; }
                    if( var4_C219 != null ) { var4_C219.close(); var4_C219 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq112_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq112_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq112_join closure;
            IEnumerator var2_F8335;
            IEnumerator var3_F8334;
            public Enumerator(seq112_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8335 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8335", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8335.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8335", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8335.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8335 != null ) { var2_F8335.close(); var2_F8335 = null; }
                var3_F8334 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8334", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F8334.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8334", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F8334.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F8334 != null ) { var3_F8334.close(); var3_F8334 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8335 != null ) { var2_F8335.close(); var2_F8335 = null; }
                    if( var3_F8334 != null ) { var3_F8334.close(); var3_F8334 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq113_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq113_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq113_join closure;
            IEnumerator var2_F4347;
            IEnumerator var3_C212;
            public Enumerator(seq113_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4347 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4347", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4347.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4347", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4347.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4347 != null ) { var2_F4347.close(); var2_F4347 = null; }
                var3_C212 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C212", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C212.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C212", (new seq114_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C212.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_C212 != null ) { var3_C212.close(); var3_C212 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4347 != null ) { var2_F4347.close(); var2_F4347 = null; }
                    if( var3_C212 != null ) { var3_C212.close(); var3_C212 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq114_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq114_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq114_join closure;
            IEnumerator var2_F7140;
            IEnumerator var3_F7143;
            IEnumerator var4_F1131;
            IEnumerator var5_F3055;
            public Enumerator(seq114_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7140 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7140", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7140.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7140", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7140.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7140 != null ) { var2_F7140.close(); var2_F7140 = null; }
                var3_F7143 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7143", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F7143.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7143", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F7143.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F7143 != null ) { var3_F7143.close(); var3_F7143 = null; }
                var4_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F1131.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F1131 != null ) { var4_F1131.close(); var4_F1131 = null; }
                var5_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F3055.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F3055 != null ) { var5_F3055.close(); var5_F3055 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7140 != null ) { var2_F7140.close(); var2_F7140 = null; }
                    if( var3_F7143 != null ) { var3_F7143.close(); var3_F7143 = null; }
                    if( var4_F1131 != null ) { var4_F1131.close(); var4_F1131 = null; }
                    if( var5_F3055 != null ) { var5_F3055.close(); var5_F3055 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq115_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq115_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq115_join closure;
            IEnumerator var2_NAD;
            IEnumerator var3_DTM;
            IEnumerator var4_LOC;
            public Enumerator(seq115_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_NAD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("NAD", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_NAD.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("NAD", (new seq91_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_NAD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_NAD != null ) { var2_NAD.close(); var2_NAD = null; }
                var3_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_DTM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq28_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                var4_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_LOC.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq48_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_LOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_LOC != null ) { var4_LOC.close(); var4_LOC = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_NAD != null ) { var2_NAD.close(); var2_NAD = null; }
                    if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                    if( var4_LOC != null ) { var4_LOC.close(); var4_LOC = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq116_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq116_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq116_join closure;
            IEnumerator var2_MEA;
            IEnumerator var3_EQN;
            public Enumerator(seq116_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_MEA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MEA", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_MEA.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MEA", (new seq117_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_MEA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_MEA != null ) { var2_MEA.close(); var2_MEA = null; }
                var3_EQN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("EQN", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_EQN.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("EQN", (new seq77_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_EQN.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_EQN != null ) { var3_EQN.close(); var3_EQN = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_MEA != null ) { var2_MEA.close(); var2_MEA = null; }
                    if( var3_EQN != null ) { var3_EQN.close(); var3_EQN = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq117_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq117_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq117_join closure;
            IEnumerator var2_F6311;
            IEnumerator var3_F7383;
            IEnumerator var4_C502;
            IEnumerator var5_C174;
            public Enumerator(seq117_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6311 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6311", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F6311.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6311", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F6311.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F6311 != null ) { var2_F6311.close(); var2_F6311 = null; }
                var3_F7383 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7383", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F7383.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7383", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F7383.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F7383 != null ) { var3_F7383.close(); var3_F7383 = null; }
                var4_C502 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C502", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C502.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C502", (new seq118_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C502.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_C502 != null ) { var4_C502.close(); var4_C502 = null; }
                var5_C174 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C174", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C174.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C174", (new seq119_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C174.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_C174 != null ) { var5_C174.close(); var5_C174 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F6311 != null ) { var2_F6311.close(); var2_F6311 = null; }
                    if( var3_F7383 != null ) { var3_F7383.close(); var3_F7383 = null; }
                    if( var4_C502 != null ) { var4_C502.close(); var4_C502 = null; }
                    if( var5_C174 != null ) { var5_C174.close(); var5_C174 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq118_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq118_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq118_join closure;
            IEnumerator var2_F6313;
            IEnumerator var3_F6321;
            IEnumerator var4_F6155;
            IEnumerator var5_F6154;
            public Enumerator(seq118_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6313 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6313", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F6313.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6313", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F6313.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F6313 != null ) { var2_F6313.close(); var2_F6313 = null; }
                var3_F6321 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6321", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F6321.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6321", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F6321.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F6321 != null ) { var3_F6321.close(); var3_F6321 = null; }
                var4_F6155 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6155", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F6155.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6155", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F6155.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F6155 != null ) { var4_F6155.close(); var4_F6155 = null; }
                var5_F6154 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6154", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F6154.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6154", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F6154.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F6154 != null ) { var5_F6154.close(); var5_F6154 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F6313 != null ) { var2_F6313.close(); var2_F6313 = null; }
                    if( var3_F6321 != null ) { var3_F6321.close(); var3_F6321 = null; }
                    if( var4_F6155 != null ) { var4_F6155.close(); var4_F6155 = null; }
                    if( var5_F6154 != null ) { var5_F6154.close(); var5_F6154 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq119_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq119_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq119_join closure;
            IEnumerator var2_F6411;
            IEnumerator var3_F6314;
            IEnumerator var4_F6162;
            IEnumerator var5_F6152;
            IEnumerator var6_F6432;
            public Enumerator(seq119_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F6411.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6411", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F6411.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F6411 != null ) { var2_F6411.close(); var2_F6411 = null; }
                var3_F6314 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6314", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F6314.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6314", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F6314.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F6314 != null ) { var3_F6314.close(); var3_F6314 = null; }
                var4_F6162 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6162", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F6162.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6162", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F6162.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F6162 != null ) { var4_F6162.close(); var4_F6162 = null; }
                var5_F6152 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6152", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F6152.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6152", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F6152.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F6152 != null ) { var5_F6152.close(); var5_F6152 = null; }
                var6_F6432 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6432", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F6432.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6432", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F6432.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_F6432 != null ) { var6_F6432.close(); var6_F6432 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F6411 != null ) { var2_F6411.close(); var2_F6411 = null; }
                    if( var3_F6314 != null ) { var3_F6314.close(); var3_F6314 = null; }
                    if( var4_F6162 != null ) { var4_F6162.close(); var4_F6162 = null; }
                    if( var5_F6152 != null ) { var5_F6152.close(); var5_F6152 = null; }
                    if( var6_F6432 != null ) { var6_F6432.close(); var6_F6432 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq120_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq120_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq120_join closure;
            IEnumerator var2_DIM;
            IEnumerator var3_EQN;
            public Enumerator(seq120_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_DIM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DIM", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_DIM.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DIM", (new seq121_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_DIM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_DIM != null ) { var2_DIM.close(); var2_DIM = null; }
                var3_EQN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("EQN", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_EQN.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("EQN", (new seq77_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_EQN.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_EQN != null ) { var3_EQN.close(); var3_EQN = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_DIM != null ) { var2_DIM.close(); var2_DIM = null; }
                    if( var3_EQN != null ) { var3_EQN.close(); var3_EQN = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq121_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq121_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq121_join closure;
            IEnumerator var2_F6145;
            IEnumerator var3_C211;
            public Enumerator(seq121_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6145 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6145", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F6145.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6145", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F6145.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F6145 != null ) { var2_F6145.close(); var2_F6145 = null; }
                var3_C211 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C211", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C211.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C211", (new seq122_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C211.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_C211 != null ) { var3_C211.close(); var3_C211 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F6145 != null ) { var2_F6145.close(); var2_F6145 = null; }
                    if( var3_C211 != null ) { var3_C211.close(); var3_C211 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq122_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq122_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq122_join closure;
            IEnumerator var2_F6411;
            IEnumerator var3_F6168;
            IEnumerator var4_F6140;
            IEnumerator var5_F6008;
            public Enumerator(seq122_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F6411.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6411", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F6411.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F6411 != null ) { var2_F6411.close(); var2_F6411 = null; }
                var3_F6168 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6168", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F6168.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6168", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F6168.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F6168 != null ) { var3_F6168.close(); var3_F6168 = null; }
                var4_F6140 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6140", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F6140.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6140", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F6140.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F6140 != null ) { var4_F6140.close(); var4_F6140 = null; }
                var5_F6008 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6008", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F6008.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6008", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F6008.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F6008 != null ) { var5_F6008.close(); var5_F6008 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F6411 != null ) { var2_F6411.close(); var2_F6411 = null; }
                    if( var3_F6168 != null ) { var3_F6168.close(); var3_F6168 = null; }
                    if( var4_F6140 != null ) { var4_F6140.close(); var4_F6140 = null; }
                    if( var5_F6008 != null ) { var5_F6008.close(); var5_F6008 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq123_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq123_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq123_join closure;
            IEnumerator var2_PCI;
            IEnumerator var3_RFF;
            IEnumerator var4_DTM;
            IEnumerator var5_GIN;
            public Enumerator(seq123_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_PCI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PCI", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_PCI.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PCI", (new seq124_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_PCI.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_PCI != null ) { var2_PCI.close(); var2_PCI = null; }
                var3_RFF = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RFF", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_RFF.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("RFF", (new seq56_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_RFF.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_RFF != null ) { var3_RFF.close(); var3_RFF = null; }
                var4_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_DTM.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq28_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_DTM != null ) { var4_DTM.close(); var4_DTM = null; }
                var5_GIN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("GIN", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_GIN.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("GIN", (new seq127_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_GIN.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_GIN != null ) { var5_GIN.close(); var5_GIN = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_PCI != null ) { var2_PCI.close(); var2_PCI = null; }
                    if( var3_RFF != null ) { var3_RFF.close(); var3_RFF = null; }
                    if( var4_DTM != null ) { var4_DTM.close(); var4_DTM = null; }
                    if( var5_GIN != null ) { var5_GIN.close(); var5_GIN = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq124_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq124_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq124_join closure;
            IEnumerator var2_F4233;
            IEnumerator var3_F8275;
            IEnumerator var4_C210;
            IEnumerator var5_C827;
            public Enumerator(seq124_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4233 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4233", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4233.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4233", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4233.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4233 != null ) { var2_F4233.close(); var2_F4233 = null; }
                var3_F8275 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8275", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F8275.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8275", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F8275.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F8275 != null ) { var3_F8275.close(); var3_F8275 = null; }
                var4_C210 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C210", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C210.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C210", (new seq125_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C210.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_C210 != null ) { var4_C210.close(); var4_C210 = null; }
                var5_C827 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C827", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C827.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C827", (new seq126_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C827.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_C827 != null ) { var5_C827.close(); var5_C827 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4233 != null ) { var2_F4233.close(); var2_F4233 = null; }
                    if( var3_F8275 != null ) { var3_F8275.close(); var3_F8275 = null; }
                    if( var4_C210 != null ) { var4_C210.close(); var4_C210 = null; }
                    if( var5_C827 != null ) { var5_C827.close(); var5_C827 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq125_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq125_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq125_map closure;
            IEnumerator var2_F7102;
            public Enumerator(seq125_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7102 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7102", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7102.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7102", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7102.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_F7102 != null ) { var2_F7102.close(); var2_F7102 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7102 != null ) { var2_F7102.close(); var2_F7102 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq126_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq126_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq126_join closure;
            IEnumerator var2_F7511;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            public Enumerator(seq126_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7511 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7511", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7511.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7511", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7511.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7511 != null ) { var2_F7511.close(); var2_F7511 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7511 != null ) { var2_F7511.close(); var2_F7511 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq127_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq127_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq127_join closure;
            IEnumerator var2_F7405;
            IEnumerator var3_C208;
            public Enumerator(seq127_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7405 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7405", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7405.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7405", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7405.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7405 != null ) { var2_F7405.close(); var2_F7405 = null; }
                var3_C208 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C208", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C208.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C208", (new seq63_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C208.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_C208 != null ) { var3_C208.close(); var3_C208 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7405 != null ) { var2_F7405.close(); var2_F7405 = null; }
                    if( var3_C208 != null ) { var3_C208.close(); var3_C208 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq128_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq128_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq128_join closure;
            IEnumerator var2_GOR;
            IEnumerator var3_DTM;
            IEnumerator var4_LOC;
            IEnumerator var5_SEL;
            IEnumerator var6_FTX;
            IEnumerator var7_SG26;
            public Enumerator(seq128_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_GOR = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("GOR", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_GOR.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("GOR", (new seq59_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_GOR.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_GOR != null ) { var2_GOR.close(); var2_GOR = null; }
                var3_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_DTM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq28_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                var4_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_LOC.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq48_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_LOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_LOC != null ) { var4_LOC.close(); var4_LOC = null; }
                var5_SEL = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SEL", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_SEL.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SEL", (new seq61_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_SEL.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_SEL != null ) { var5_SEL.close(); var5_SEL = null; }
                var6_FTX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FTX", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_FTX.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("FTX", (new seq39_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_FTX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_FTX != null ) { var6_FTX.close(); var6_FTX = null; }
                var7_SG26 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG26", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_SG26.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG26", (new seq64_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_SG26.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_SG26 != null ) { var7_SG26.close(); var7_SG26 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_GOR != null ) { var2_GOR.close(); var2_GOR = null; }
                    if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                    if( var4_LOC != null ) { var4_LOC.close(); var4_LOC = null; }
                    if( var5_SEL != null ) { var5_SEL.close(); var5_SEL = null; }
                    if( var6_FTX != null ) { var6_FTX.close(); var6_FTX = null; }
                    if( var7_SG26 != null ) { var7_SG26.close(); var7_SG26 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq129_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq129_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq129_join closure;
            IEnumerator var2_TPL;
            IEnumerator var3_SG28;
            public Enumerator(seq129_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_TPL = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TPL", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_TPL.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TPL", (new seq100_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_TPL.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_TPL != null ) { var2_TPL.close(); var2_TPL = null; }
                var3_SG28 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG28", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_SG28.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG28", (new seq116_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_SG28.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_SG28 != null ) { var3_SG28.close(); var3_SG28 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_TPL != null ) { var2_TPL.close(); var2_TPL = null; }
                    if( var3_SG28 != null ) { var3_SG28.close(); var3_SG28 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq130_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq130_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq130_join closure;
            IEnumerator var2_SGP;
            IEnumerator var3_SG30;
            public Enumerator(seq130_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_SGP = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SGP", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_SGP.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SGP", (new seq131_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_SGP.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_SGP != null ) { var2_SGP.close(); var2_SGP = null; }
                var3_SG30 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG30", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_SG30.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG30", (new seq116_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_SG30.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_SG30 != null ) { var3_SG30.close(); var3_SG30 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_SGP != null ) { var2_SGP.close(); var2_SGP = null; }
                    if( var3_SG30 != null ) { var3_SG30.close(); var3_SG30 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq131_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq131_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq131_join closure;
            IEnumerator var2_F7224;
            IEnumerator var3_C237;
            public Enumerator(seq131_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7224 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7224", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7224.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7224", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7224.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7224 != null ) { var2_F7224.close(); var2_F7224 = null; }
                var3_C237 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C237", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C237.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C237", (new seq132_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C237.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_C237 != null ) { var3_C237.close(); var3_C237 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7224 != null ) { var2_F7224.close(); var2_F7224 = null; }
                    if( var3_C237 != null ) { var3_C237.close(); var3_C237 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq132_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq132_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq132_join closure;
            IEnumerator var2_F8260;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F3207;
            public Enumerator(seq132_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8260 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8260", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8260.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8260", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8260.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8260 != null ) { var2_F8260.close(); var2_F8260 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                var5_F3207 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3207", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F3207.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3207", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F3207.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F3207 != null ) { var5_F3207.close(); var5_F3207 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8260 != null ) { var2_F8260.close(); var2_F8260 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F3207 != null ) { var5_F3207.close(); var5_F3207 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq133_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq133_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq133_join closure;
            IEnumerator var2_TCC;
            IEnumerator var3_CUX;
            IEnumerator var4_PRI;
            IEnumerator var5_EQN;
            IEnumerator var6_PCD;
            IEnumerator var7_MOA;
            IEnumerator var8_QTY;
            IEnumerator var9_LOC;
            public Enumerator(seq133_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_TCC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TCC", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_TCC.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TCC", (new seq70_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_TCC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_TCC != null ) { var2_TCC.close(); var2_TCC = null; }
                var3_CUX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CUX", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_CUX.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("CUX", (new seq35_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_CUX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_CUX != null ) { var3_CUX.close(); var3_CUX = null; }
                var4_PRI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PRI", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_PRI.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PRI", (new seq75_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_PRI.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_PRI != null ) { var4_PRI.close(); var4_PRI = null; }
                var5_EQN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("EQN", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_EQN.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("EQN", (new seq77_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_EQN.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_EQN != null ) { var5_EQN.close(); var5_EQN = null; }
                var6_PCD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PCD", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_PCD.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PCD", (new seq79_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_PCD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_PCD != null ) { var6_PCD.close(); var6_PCD = null; }
                var7_MOA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MOA", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_MOA.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MOA", (new seq37_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_MOA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_MOA != null ) { var7_MOA.close(); var7_MOA = null; }
                var8_QTY = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("QTY", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_QTY.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("QTY", (new seq81_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_QTY.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_QTY != null ) { var8_QTY.close(); var8_QTY = null; }
                var9_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_LOC.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq48_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_LOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 0;
                if( var9_LOC != null ) { var9_LOC.close(); var9_LOC = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_TCC != null ) { var2_TCC.close(); var2_TCC = null; }
                    if( var3_CUX != null ) { var3_CUX.close(); var3_CUX = null; }
                    if( var4_PRI != null ) { var4_PRI.close(); var4_PRI = null; }
                    if( var5_EQN != null ) { var5_EQN.close(); var5_EQN = null; }
                    if( var6_PCD != null ) { var6_PCD.close(); var6_PCD = null; }
                    if( var7_MOA != null ) { var7_MOA.close(); var7_MOA = null; }
                    if( var8_QTY != null ) { var8_QTY.close(); var8_QTY = null; }
                    if( var9_LOC != null ) { var9_LOC.close(); var9_LOC = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq134_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq134_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq134_join closure;
            IEnumerator var2_DGS;
            IEnumerator var3_FTX;
            IEnumerator var4_SG33;
            IEnumerator var5_SG34;
            IEnumerator var6_SG35;
            public Enumerator(seq134_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_DGS = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DGS", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_DGS.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DGS", (new seq135_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_DGS.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_DGS != null ) { var2_DGS.close(); var2_DGS = null; }
                var3_FTX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FTX", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_FTX.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("FTX", (new seq39_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_FTX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_FTX != null ) { var3_FTX.close(); var3_FTX = null; }
                var4_SG33 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG33", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_SG33.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG33", (new seq97_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_SG33.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_SG33 != null ) { var4_SG33.close(); var4_SG33 = null; }
                var5_SG34 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG34", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_SG34.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG34", (new seq116_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_SG34.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_SG34 != null ) { var5_SG34.close(); var5_SG34 = null; }
                var6_SG35 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG35", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_SG35.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG35", (new seq141_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_SG35.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_SG35 != null ) { var6_SG35.close(); var6_SG35 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_DGS != null ) { var2_DGS.close(); var2_DGS = null; }
                    if( var3_FTX != null ) { var3_FTX.close(); var3_FTX = null; }
                    if( var4_SG33 != null ) { var4_SG33.close(); var4_SG33 = null; }
                    if( var5_SG34 != null ) { var5_SG34.close(); var5_SG34 = null; }
                    if( var6_SG35 != null ) { var6_SG35.close(); var6_SG35 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq135_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq135_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq135_join closure;
            IEnumerator var2_F8273;
            IEnumerator var3_F8339;
            IEnumerator var4_F8364;
            IEnumerator var5_F8410;
            IEnumerator var6_F8126;
            IEnumerator var7_F8255;
            IEnumerator var8_F8325;
            IEnumerator var9_F8211;
            IEnumerator var10_C205;
            IEnumerator var11_C234;
            IEnumerator var12_C223;
            IEnumerator var13_C235;
            IEnumerator var14_C236;
            public Enumerator(seq135_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 27:	if (moveNext_27()) return true; break;
                        case 29:	if (moveNext_29()) return true; break;
                        case 30:	if (moveNext_30()) return true; break;
                        case 32:	if (moveNext_32()) return true; break;
                        case 33:	if (moveNext_33()) return true; break;
                        case 35:	if (moveNext_35()) return true; break;
                        case 36:	if (moveNext_36()) return true; break;
                        case 38:	if (moveNext_38()) return true; break;
                        case 39:	if (moveNext_39()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8273 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8273", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8273.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8273", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8273.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8273 != null ) { var2_F8273.close(); var2_F8273 = null; }
                var3_F8339 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8339", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F8339.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8339", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F8339.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F8339 != null ) { var3_F8339.close(); var3_F8339 = null; }
                var4_F8364 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8364", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F8364.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8364", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F8364.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F8364 != null ) { var4_F8364.close(); var4_F8364 = null; }
                var5_F8410 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8410", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F8410.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8410", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F8410.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F8410 != null ) { var5_F8410.close(); var5_F8410 = null; }
                var6_F8126 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8126", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F8126.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8126", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F8126.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_F8126 != null ) { var6_F8126.close(); var6_F8126 = null; }
                var7_F8255 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8255", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_F8255.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8255", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_F8255.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_F8255 != null ) { var7_F8255.close(); var7_F8255 = null; }
                var8_F8325 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8325", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_F8325.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8325", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_F8325.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_F8325 != null ) { var8_F8325.close(); var8_F8325 = null; }
                var9_F8211 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8211", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_F8211.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8211", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_F8211.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_F8211 != null ) { var9_F8211.close(); var9_F8211 = null; }
                var10_C205 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C205", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_C205.moveNext()) {state = 27; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C205", (new seq136_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_C205.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 29;
                if( var10_C205 != null ) { var10_C205.close(); var10_C205 = null; }
                var11_C234 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C234", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 29;
                if (!var11_C234.moveNext()) {state = 30; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C234", (new seq137_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_C234.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_30() throws Exception {
                state = 32;
                if( var11_C234 != null ) { var11_C234.close(); var11_C234 = null; }
                var12_C223 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C223", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_32() throws Exception {
                state = 32;
                if (!var12_C223.moveNext()) {state = 33; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C223", (new seq138_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var12_C223.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_33() throws Exception {
                state = 35;
                if( var12_C223 != null ) { var12_C223.close(); var12_C223 = null; }
                var13_C235 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C235", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_35() throws Exception {
                state = 35;
                if (!var13_C235.moveNext()) {state = 36; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C235", (new seq139_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var13_C235.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_36() throws Exception {
                state = 38;
                if( var13_C235 != null ) { var13_C235.close(); var13_C235 = null; }
                var14_C236 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C236", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_38() throws Exception {
                state = 38;
                if (!var14_C236.moveNext()) {state = 39; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C236", (new seq140_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var14_C236.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_39() throws Exception {
                state = 0;
                if( var14_C236 != null ) { var14_C236.close(); var14_C236 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8273 != null ) { var2_F8273.close(); var2_F8273 = null; }
                    if( var3_F8339 != null ) { var3_F8339.close(); var3_F8339 = null; }
                    if( var4_F8364 != null ) { var4_F8364.close(); var4_F8364 = null; }
                    if( var5_F8410 != null ) { var5_F8410.close(); var5_F8410 = null; }
                    if( var6_F8126 != null ) { var6_F8126.close(); var6_F8126 = null; }
                    if( var7_F8255 != null ) { var7_F8255.close(); var7_F8255 = null; }
                    if( var8_F8325 != null ) { var8_F8325.close(); var8_F8325 = null; }
                    if( var9_F8211 != null ) { var9_F8211.close(); var9_F8211 = null; }
                    if( var10_C205 != null ) { var10_C205.close(); var10_C205 = null; }
                    if( var11_C234 != null ) { var11_C234.close(); var11_C234 = null; }
                    if( var12_C223 != null ) { var12_C223.close(); var12_C223 = null; }
                    if( var13_C235 != null ) { var13_C235.close(); var13_C235 = null; }
                    if( var14_C236 != null ) { var14_C236.close(); var14_C236 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq136_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq136_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq136_join closure;
            IEnumerator var2_F8351;
            IEnumerator var3_F8078;
            IEnumerator var4_F8092;
            public Enumerator(seq136_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8351 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8351", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8351.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8351", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8351.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8351 != null ) { var2_F8351.close(); var2_F8351 = null; }
                var3_F8078 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8078", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F8078.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8078", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F8078.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F8078 != null ) { var3_F8078.close(); var3_F8078 = null; }
                var4_F8092 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8092", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F8092.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8092", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F8092.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F8092 != null ) { var4_F8092.close(); var4_F8092 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8351 != null ) { var2_F8351.close(); var2_F8351 = null; }
                    if( var3_F8078 != null ) { var3_F8078.close(); var3_F8078 = null; }
                    if( var4_F8092 != null ) { var4_F8092.close(); var4_F8092 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq137_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq137_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq137_join closure;
            IEnumerator var2_F7124;
            IEnumerator var3_F7088;
            public Enumerator(seq137_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7124 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7124", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7124.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7124", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7124.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7124 != null ) { var2_F7124.close(); var2_F7124 = null; }
                var3_F7088 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7088", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F7088.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7088", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F7088.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F7088 != null ) { var3_F7088.close(); var3_F7088 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7124 != null ) { var2_F7124.close(); var2_F7124 = null; }
                    if( var3_F7088 != null ) { var3_F7088.close(); var3_F7088 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq138_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq138_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq138_join closure;
            IEnumerator var2_F7106;
            IEnumerator var3_F6411;
            public Enumerator(seq138_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7106 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7106", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7106.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7106", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7106.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7106 != null ) { var2_F7106.close(); var2_F7106 = null; }
                var3_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F6411.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6411", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F6411.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F6411 != null ) { var3_F6411.close(); var3_F6411 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7106 != null ) { var2_F7106.close(); var2_F7106 = null; }
                    if( var3_F6411 != null ) { var3_F6411.close(); var3_F6411 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq139_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq139_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq139_join closure;
            IEnumerator var2_F8158;
            IEnumerator var3_F8186;
            public Enumerator(seq139_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8158 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8158", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8158.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8158", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8158.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8158 != null ) { var2_F8158.close(); var2_F8158 = null; }
                var3_F8186 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8186", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F8186.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8186", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F8186.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F8186 != null ) { var3_F8186.close(); var3_F8186 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8158 != null ) { var2_F8158.close(); var2_F8158 = null; }
                    if( var3_F8186 != null ) { var3_F8186.close(); var3_F8186 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq140_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq140_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq140_map closure;
            IEnumerator var2_F8246;
            public Enumerator(seq140_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8246 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8246", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8246.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8246", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8246.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_F8246 != null ) { var2_F8246.close(); var2_F8246 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8246 != null ) { var2_F8246.close(); var2_F8246 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq141_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq141_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq141_join closure;
            IEnumerator var2_SGP;
            IEnumerator var3_SG36;
            public Enumerator(seq141_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_SGP = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SGP", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_SGP.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SGP", (new seq131_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_SGP.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_SGP != null ) { var2_SGP.close(); var2_SGP = null; }
                var3_SG36 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG36", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_SG36.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG36", (new seq116_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_SG36.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_SG36 != null ) { var3_SG36.close(); var3_SG36 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_SGP != null ) { var2_SGP.close(); var2_SGP = null; }
                    if( var3_SG36 != null ) { var3_SG36.close(); var3_SG36 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq142_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq142_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq142_join closure;
            IEnumerator var2_EQD;
            IEnumerator var3_EQN;
            IEnumerator var4_TMD;
            IEnumerator var5_MEA;
            IEnumerator var6_DIM;
            IEnumerator var7_SEL;
            IEnumerator var8_TPL;
            IEnumerator var9_HAN;
            IEnumerator var10_TMP;
            IEnumerator var11_FTX;
            IEnumerator var12_RFF;
            IEnumerator var13_SG38;
            IEnumerator var14_SG39;
            IEnumerator var15_SG41;
            IEnumerator var16_SG42;
            public Enumerator(seq142_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 27:	if (moveNext_27()) return true; break;
                        case 29:	if (moveNext_29()) return true; break;
                        case 30:	if (moveNext_30()) return true; break;
                        case 32:	if (moveNext_32()) return true; break;
                        case 33:	if (moveNext_33()) return true; break;
                        case 35:	if (moveNext_35()) return true; break;
                        case 36:	if (moveNext_36()) return true; break;
                        case 38:	if (moveNext_38()) return true; break;
                        case 39:	if (moveNext_39()) return true; break;
                        case 41:	if (moveNext_41()) return true; break;
                        case 42:	if (moveNext_42()) return true; break;
                        case 44:	if (moveNext_44()) return true; break;
                        case 45:	if (moveNext_45()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_EQD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("EQD", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_EQD.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("EQD", (new seq143_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_EQD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_EQD != null ) { var2_EQD.close(); var2_EQD = null; }
                var3_EQN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("EQN", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_EQN.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("EQN", (new seq77_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_EQN.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_EQN != null ) { var3_EQN.close(); var3_EQN = null; }
                var4_TMD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TMD", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_TMD.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TMD", (new seq111_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_TMD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_TMD != null ) { var4_TMD.close(); var4_TMD = null; }
                var5_MEA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MEA", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_MEA.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MEA", (new seq117_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_MEA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_MEA != null ) { var5_MEA.close(); var5_MEA = null; }
                var6_DIM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DIM", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_DIM.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DIM", (new seq121_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_DIM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_DIM != null ) { var6_DIM.close(); var6_DIM = null; }
                var7_SEL = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SEL", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_SEL.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SEL", (new seq61_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_SEL.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_SEL != null ) { var7_SEL.close(); var7_SEL = null; }
                var8_TPL = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TPL", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_TPL.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TPL", (new seq100_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_TPL.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_TPL != null ) { var8_TPL.close(); var8_TPL = null; }
                var9_HAN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("HAN", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_HAN.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("HAN", (new seq104_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_HAN.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_HAN != null ) { var9_HAN.close(); var9_HAN = null; }
                var10_TMP = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TMP", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_TMP.moveNext()) {state = 27; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TMP", (new seq107_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_TMP.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 29;
                if( var10_TMP != null ) { var10_TMP.close(); var10_TMP = null; }
                var11_FTX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FTX", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 29;
                if (!var11_FTX.moveNext()) {state = 30; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("FTX", (new seq39_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_FTX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_30() throws Exception {
                state = 32;
                if( var11_FTX != null ) { var11_FTX.close(); var11_FTX = null; }
                var12_RFF = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RFF", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_32() throws Exception {
                state = 32;
                if (!var12_RFF.moveNext()) {state = 33; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("RFF", (new seq56_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var12_RFF.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_33() throws Exception {
                state = 35;
                if( var12_RFF != null ) { var12_RFF.close(); var12_RFF = null; }
                var13_SG38 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG38", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_35() throws Exception {
                state = 35;
                if (!var13_SG38.moveNext()) {state = 36; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG38", (new seq98_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var13_SG38.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_36() throws Exception {
                state = 38;
                if( var13_SG38 != null ) { var13_SG38.close(); var13_SG38 = null; }
                var14_SG39 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG39", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_38() throws Exception {
                state = 38;
                if (!var14_SG39.moveNext()) {state = 39; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG39", (new seq145_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var14_SG39.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_39() throws Exception {
                state = 41;
                if( var14_SG39 != null ) { var14_SG39.close(); var14_SG39 = null; }
                var15_SG41 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG41", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_41() throws Exception {
                state = 41;
                if (!var15_SG41.moveNext()) {state = 42; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG41", (new seq146_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var15_SG41.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_42() throws Exception {
                state = 44;
                if( var15_SG41 != null ) { var15_SG41.close(); var15_SG41 = null; }
                var16_SG42 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG42", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_44() throws Exception {
                state = 44;
                if (!var16_SG42.moveNext()) {state = 45; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG42", (new seq148_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var16_SG42.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_45() throws Exception {
                state = 0;
                if( var16_SG42 != null ) { var16_SG42.close(); var16_SG42 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_EQD != null ) { var2_EQD.close(); var2_EQD = null; }
                    if( var3_EQN != null ) { var3_EQN.close(); var3_EQN = null; }
                    if( var4_TMD != null ) { var4_TMD.close(); var4_TMD = null; }
                    if( var5_MEA != null ) { var5_MEA.close(); var5_MEA = null; }
                    if( var6_DIM != null ) { var6_DIM.close(); var6_DIM = null; }
                    if( var7_SEL != null ) { var7_SEL.close(); var7_SEL = null; }
                    if( var8_TPL != null ) { var8_TPL.close(); var8_TPL = null; }
                    if( var9_HAN != null ) { var9_HAN.close(); var9_HAN = null; }
                    if( var10_TMP != null ) { var10_TMP.close(); var10_TMP = null; }
                    if( var11_FTX != null ) { var11_FTX.close(); var11_FTX = null; }
                    if( var12_RFF != null ) { var12_RFF.close(); var12_RFF = null; }
                    if( var13_SG38 != null ) { var13_SG38.close(); var13_SG38 = null; }
                    if( var14_SG39 != null ) { var14_SG39.close(); var14_SG39 = null; }
                    if( var15_SG41 != null ) { var15_SG41.close(); var15_SG41 = null; }
                    if( var16_SG42 != null ) { var16_SG42.close(); var16_SG42 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq143_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq143_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq143_join closure;
            IEnumerator var2_F8053;
            IEnumerator var3_F8077;
            IEnumerator var4_F8249;
            IEnumerator var5_F8169;
            IEnumerator var6_C237;
            IEnumerator var7_C224;
            public Enumerator(seq143_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8053 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8053", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8053.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8053", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8053.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8053 != null ) { var2_F8053.close(); var2_F8053 = null; }
                var3_F8077 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8077", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F8077.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8077", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F8077.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F8077 != null ) { var3_F8077.close(); var3_F8077 = null; }
                var4_F8249 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8249", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F8249.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8249", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F8249.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F8249 != null ) { var4_F8249.close(); var4_F8249 = null; }
                var5_F8169 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8169", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F8169.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8169", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F8169.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F8169 != null ) { var5_F8169.close(); var5_F8169 = null; }
                var6_C237 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C237", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_C237.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C237", (new seq132_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C237.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_C237 != null ) { var6_C237.close(); var6_C237 = null; }
                var7_C224 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C224", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_C224.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C224", (new seq144_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_C224.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_C224 != null ) { var7_C224.close(); var7_C224 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8053 != null ) { var2_F8053.close(); var2_F8053 = null; }
                    if( var3_F8077 != null ) { var3_F8077.close(); var3_F8077 = null; }
                    if( var4_F8249 != null ) { var4_F8249.close(); var4_F8249 = null; }
                    if( var5_F8169 != null ) { var5_F8169.close(); var5_F8169 = null; }
                    if( var6_C237 != null ) { var6_C237.close(); var6_C237 = null; }
                    if( var7_C224 != null ) { var7_C224.close(); var7_C224 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq144_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq144_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq144_join closure;
            IEnumerator var2_F8155;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F8154;
            public Enumerator(seq144_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8155 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8155", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8155.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8155", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8155.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8155 != null ) { var2_F8155.close(); var2_F8155 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1131.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1131", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1131.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3055.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3055", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3055.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                var5_F8154 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8154", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F8154.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8154", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F8154.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F8154 != null ) { var5_F8154.close(); var5_F8154 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8155 != null ) { var2_F8155.close(); var2_F8155 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F8154 != null ) { var5_F8154.close(); var5_F8154 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq145_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq145_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq145_join closure;
            IEnumerator var2_NAD;
            IEnumerator var3_DTM;
            IEnumerator var4_SG40;
            public Enumerator(seq145_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_NAD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("NAD", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_NAD.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("NAD", (new seq91_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_NAD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_NAD != null ) { var2_NAD.close(); var2_NAD = null; }
                var3_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_DTM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq28_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                var4_SG40 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG40", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_SG40.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG40", (new seq97_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_SG40.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_SG40 != null ) { var4_SG40.close(); var4_SG40 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_NAD != null ) { var2_NAD.close(); var2_NAD = null; }
                    if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                    if( var4_SG40 != null ) { var4_SG40.close(); var4_SG40 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq146_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq146_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq146_join closure;
            IEnumerator var2_EQA;
            IEnumerator var3_EQN;
            public Enumerator(seq146_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_EQA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("EQA", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_EQA.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("EQA", (new seq147_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_EQA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_EQA != null ) { var2_EQA.close(); var2_EQA = null; }
                var3_EQN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("EQN", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_EQN.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("EQN", (new seq77_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_EQN.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_EQN != null ) { var3_EQN.close(); var3_EQN = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_EQA != null ) { var2_EQA.close(); var2_EQA = null; }
                    if( var3_EQN != null ) { var3_EQN.close(); var3_EQN = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq147_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq147_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq147_join closure;
            IEnumerator var2_F8053;
            IEnumerator var3_C237;
            public Enumerator(seq147_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8053 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8053", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8053.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8053", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8053.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8053 != null ) { var2_F8053.close(); var2_F8053 = null; }
                var3_C237 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C237", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C237.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C237", (new seq132_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C237.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_C237 != null ) { var3_C237.close(); var3_C237 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8053 != null ) { var2_F8053.close(); var2_F8053 = null; }
                    if( var3_C237 != null ) { var3_C237.close(); var3_C237 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq148_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq148_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq148_join closure;
            IEnumerator var2_DGS;
            IEnumerator var3_FTX;
            IEnumerator var4_SG43;
            public Enumerator(seq148_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_DGS = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DGS", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_DGS.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DGS", (new seq135_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_DGS.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_DGS != null ) { var2_DGS.close(); var2_DGS = null; }
                var3_FTX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FTX", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_FTX.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("FTX", (new seq39_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_FTX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_FTX != null ) { var3_FTX.close(); var3_FTX = null; }
                var4_SG43 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG43", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_SG43.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG43", (new seq97_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_SG43.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_SG43 != null ) { var4_SG43.close(); var4_SG43 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_DGS != null ) { var2_DGS.close(); var2_DGS = null; }
                    if( var3_FTX != null ) { var3_FTX.close(); var3_FTX = null; }
                    if( var4_SG43 != null ) { var4_SG43.close(); var4_SG43 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq149_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq149_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq149_join closure;
            IEnumerator var2_F0074;
            IEnumerator var3_F0062;
            public Enumerator(seq149_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0074 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0074", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0074.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0074", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0074.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0074 != null ) { var2_F0074.close(); var2_F0074 = null; }
                var3_F0062 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0062", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0062.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0062", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0062.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F0062 != null ) { var3_F0062.close(); var3_F0062 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0074 != null ) { var2_F0074.close(); var2_F0074 = null; }
                    if( var3_F0062 != null ) { var3_F0062.close(); var3_F0062 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq150_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq150_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq150_join closure;
            IEnumerator var2_F0060;
            IEnumerator var3_F0048;
            public Enumerator(seq150_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0060 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0060", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0060.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0060", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0060.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0060 != null ) { var2_F0060.close(); var2_F0060 = null; }
                var3_F0048 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0048", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0048.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0048", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0048.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F0048 != null ) { var3_F0048.close(); var3_F0048 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0060 != null ) { var2_F0060.close(); var2_F0060 = null; }
                    if( var3_F0048 != null ) { var3_F0048.close(); var3_F0048 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq151_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq151_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq151_join closure;
            IEnumerator var2_F0036;
            IEnumerator var3_F0020;
            public Enumerator(seq151_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F0036 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0036", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0036.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0036", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0036.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F0036 != null ) { var2_F0036.close(); var2_F0036 = null; }
                var3_F0020 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0020", "http://www.blujaysolutions.com/2019/IFTMIN"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F0020.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0020", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F0020.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F0020 != null ) { var3_F0020.close(); var3_F0020 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0036 != null ) { var2_F0036.close(); var2_F0036 = null; }
                    if( var3_F0020 != null ) { var3_F0020.close(); var3_F0020 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class Outer implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_IFTMIN_D99B_Instance;

        public Outer(org.assimbly.edifactcommon.mapforce.IMFNode var1_IFTMIN_D99B_Instance)
        {
            this.var1_IFTMIN_D99B_Instance = var1_IFTMIN_D99B_Instance;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            Outer closure;
            IEnumerator var2_map;
            public Enumerator(Outer closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_map = ((new main(closure.var1_IFTMIN_D99B_Instance))).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_map.moveNext()) {state = 3; return false; }
                current = var2_map.current();
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_map != null ) { var2_map.close(); var2_map = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_map != null ) { var2_map.close(); var2_map = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }



    // instances
    protected org.w3c.dom.Node varIFTMIN_D99B2Instance;

    public void run(String IFTMIN_D99B2SourceFilename, String IFTMINTargetFilename) throws Exception {
        // open source streams
        writeTrace("Loading " + IFTMIN_D99B2SourceFilename + "...\n");
        org.assimbly.edifactcommon.io.FileInput IFTMIN_D99B2Source = new org.assimbly.edifactcommon.io.FileInput(IFTMIN_D99B2SourceFilename);
        // open target stream
        org.assimbly.edifactcommon.io.FileOutput IFTMINTarget = new org.assimbly.edifactcommon.io.FileOutput(IFTMINTargetFilename);

        // run

        run(IFTMIN_D99B2Source, IFTMINTarget);

        // close source streams
        IFTMIN_D99B2Source.close();
        // close target stream
        writeTrace("Saving " + IFTMINTargetFilename + "...\n");
        IFTMINTarget.close();
    }


    // main entry point

    public void run(org.assimbly.edifactcommon.io.Input IFTMIN_D99B2Source, org.assimbly.edifactcommon.io.Output IFTMINTarget) throws Exception {
        // Open the source(s)
        org.w3c.dom.Document doc_IFTMIN_D99B2 = XmlTreeOperations.loadDocument(IFTMIN_D99B2Source);
        varIFTMIN_D99B2Instance = doc_IFTMIN_D99B2;
        if (runDoesCloseAll)
            IFTMIN_D99B2Source.close();

        // Create the target
        IFTMIND99BEnvelope IFTMINTargetDoc = new IFTMIND99BEnvelope();
        org.assimbly.edifactcommon.text.ITextNode IFTMINTargetObject = IFTMINTargetDoc.getGenerator();

        // Execute mapping

        main mapping = new main(new org.assimbly.edifactcommon.xml.DOMDocumentAsMFNodeAdapter(varIFTMIN_D99B2Instance, IFTMIN_D99B2Source.getFilename()));

        org.assimbly.edifactcommon.text.MFTextWriter.write(mapping, IFTMINTargetObject);
        // Close the target
        IFTMINTargetDoc.setEncoding( "UTF-8", false, false );
        IFTMINTargetDoc.save(IFTMINTarget);


        if (runDoesCloseAll)
        {
            IFTMIN_D99B2Source.close();
            IFTMINTarget.close();
        }
    }
}