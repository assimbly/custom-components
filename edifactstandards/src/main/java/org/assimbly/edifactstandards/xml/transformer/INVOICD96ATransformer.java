package org.assimbly.edifactstandards.xml.transformer;

import org.assimbly.edifactcommon.mapforce.IEnumerable;
import org.assimbly.edifactcommon.mapforce.IEnumerator;
import org.assimbly.edifactcommon.xml.XmlTreeOperations;
import org.assimbly.edifactstandards.xml.envelope.INVOICD96AEnvelope;

public class INVOICD96ATransformer extends org.assimbly.edifactcommon.TraceProvider
{
    private boolean runDoesCloseAll = true;
    public void setCloseObjectsAfterRun(boolean c) {runDoesCloseAll = c;}
    public boolean getCloseObjectsAfterRun() {return runDoesCloseAll;}


    static class main implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_INVOIC_D96A_Instance;

        public main(org.assimbly.edifactcommon.mapforce.IMFNode var1_INVOIC_D96A_Instance)
        {
            this.var1_INVOIC_D96A_Instance = var1_INVOIC_D96A_Instance;
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
                var2_Envelope = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("Envelope", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_INVOIC_D96A_Instance)).enumerator();
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
                var2_Interchange = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("Interchange", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var2_UNB = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNB", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_Group = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("Group", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_UNZ = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNZ", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_UNZ.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("UNZ", (new seq156_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_UNZ.current())))));
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
                var2_F0020 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0020", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0026 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0026", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F0029 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0029", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F0031 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0031", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var6_F0032 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0032", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var7_F0035 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0035", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var8_S001 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S001", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var9_S002 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S002", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var10_S003 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S003", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var11_S004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S004", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var12_S005 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S005", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var2_F0001 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0001", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0002 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0002", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F0080 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0080", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F0133 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0133", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var6_F0076 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0076", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var2_F0004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0004", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0007 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0007", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F0008 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0008", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F0042 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0042", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var2_F0010 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0010", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0007 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0007", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F0014 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0014", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F0046 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0046", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var2_F0017 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0017", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0019 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0019", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var2_F0022 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0022", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0025 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0025", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var3_Message_INVOIC;
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
                var2_UNG = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNG", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_Message_INVOIC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("Message_INVOIC", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_Message_INVOIC.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("Message_INVOIC", (new seq14_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_Message_INVOIC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_Message_INVOIC != null ) { var3_Message_INVOIC.close(); var3_Message_INVOIC = null; }
                var4_UNE = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNE", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_UNE.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("UNE", (new seq155_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_UNE.current())))));
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
                    if( var3_Message_INVOIC != null ) { var3_Message_INVOIC.close(); var3_Message_INVOIC = null; }
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
                var2_F0038 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0038", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0048 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0048", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F0051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0051", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F0058 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0058", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var6_S006 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S006", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var7_S007 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S007", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var8_S004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S004", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var9_S008 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S008", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var2_F0040 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0040", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0007 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0007", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var2_F0044 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0044", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0007 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0007", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var2_F0052 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0052", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0054 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0054", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F0057 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0057", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var4_DTM;
            IEnumerator var5_PAI;
            IEnumerator var6_ALI;
            IEnumerator var7_IMD;
            IEnumerator var8_FTX;
            IEnumerator var9_SG1;
            IEnumerator var10_SG2;
            IEnumerator var11_SG6;
            IEnumerator var12_SG7;
            IEnumerator var13_SG8;
            IEnumerator var14_SG9;
            IEnumerator var15_SG12;
            IEnumerator var16_SG13;
            IEnumerator var17_SG15;
            IEnumerator var18_SG22;
            IEnumerator var19_SG23;
            IEnumerator var20_SG24;
            IEnumerator var21_SG25;
            IEnumerator var22_UNS;
            IEnumerator var23_CNT;
            IEnumerator var24_SG48;
            IEnumerator var25_SG50;
            IEnumerator var26_SG51;
            IEnumerator var27_UNT;
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
                        case 71:	if (moveNext_71()) return true; break;
                        case 72:	if (moveNext_72()) return true; break;
                        case 74:	if (moveNext_74()) return true; break;
                        case 75:	if (moveNext_75()) return true; break;
                        case 77:	if (moveNext_77()) return true; break;
                        case 78:	if (moveNext_78()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_UNH = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNH", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_BGM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("BGM", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_DTM.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq23_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_DTM != null ) { var4_DTM.close(); var4_DTM = null; }
                var5_PAI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PAI", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_PAI.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PAI", (new seq25_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_PAI.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_PAI != null ) { var5_PAI.close(); var5_PAI = null; }
                var6_ALI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("ALI", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_ALI.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("ALI", (new seq27_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_ALI.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_ALI != null ) { var6_ALI.close(); var6_ALI = null; }
                var7_IMD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("IMD", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_IMD.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("IMD", (new seq28_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_IMD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_IMD != null ) { var7_IMD.close(); var7_IMD = null; }
                var8_FTX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FTX", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_FTX.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("FTX", (new seq30_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_FTX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_FTX != null ) { var8_FTX.close(); var8_FTX = null; }
                var9_SG1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG1", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_SG1.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG1", (new seq33_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_SG1.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_SG1 != null ) { var9_SG1.close(); var9_SG1 = null; }
                var10_SG2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG2", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_SG2.moveNext()) {state = 27; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG2", (new seq36_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_SG2.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 29;
                if( var10_SG2 != null ) { var10_SG2.close(); var10_SG2 = null; }
                var11_SG6 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG6", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 29;
                if (!var11_SG6.moveNext()) {state = 30; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG6", (new seq57_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_SG6.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_30() throws Exception {
                state = 32;
                if( var11_SG6 != null ) { var11_SG6.close(); var11_SG6 = null; }
                var12_SG7 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG7", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_32() throws Exception {
                state = 32;
                if (!var12_SG7.moveNext()) {state = 33; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG7", (new seq64_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var12_SG7.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_33() throws Exception {
                state = 35;
                if( var12_SG7 != null ) { var12_SG7.close(); var12_SG7 = null; }
                var13_SG8 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG8", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_35() throws Exception {
                state = 35;
                if (!var13_SG8.moveNext()) {state = 36; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG8", (new seq67_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var13_SG8.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_36() throws Exception {
                state = 38;
                if( var13_SG8 != null ) { var13_SG8.close(); var13_SG8 = null; }
                var14_SG9 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG9", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_38() throws Exception {
                state = 38;
                if (!var14_SG9.moveNext()) {state = 39; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG9", (new seq73_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var14_SG9.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_39() throws Exception {
                state = 41;
                if( var14_SG9 != null ) { var14_SG9.close(); var14_SG9 = null; }
                var15_SG12 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG12", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_41() throws Exception {
                state = 41;
                if (!var15_SG12.moveNext()) {state = 42; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG12", (new seq81_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var15_SG12.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_42() throws Exception {
                state = 44;
                if( var15_SG12 != null ) { var15_SG12.close(); var15_SG12 = null; }
                var16_SG13 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG13", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_44() throws Exception {
                state = 44;
                if (!var16_SG13.moveNext()) {state = 45; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG13", (new seq84_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var16_SG13.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_45() throws Exception {
                state = 47;
                if( var16_SG13 != null ) { var16_SG13.close(); var16_SG13 = null; }
                var17_SG15 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG15", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_47() throws Exception {
                state = 47;
                if (!var17_SG15.moveNext()) {state = 48; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG15", (new seq99_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var17_SG15.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_48() throws Exception {
                state = 50;
                if( var17_SG15 != null ) { var17_SG15.close(); var17_SG15 = null; }
                var18_SG22 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG22", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_50() throws Exception {
                state = 50;
                if (!var18_SG22.moveNext()) {state = 51; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG22", (new seq114_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var18_SG22.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_51() throws Exception {
                state = 53;
                if( var18_SG22 != null ) { var18_SG22.close(); var18_SG22 = null; }
                var19_SG23 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG23", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_53() throws Exception {
                state = 53;
                if (!var19_SG23.moveNext()) {state = 54; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG23", (new seq117_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var19_SG23.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_54() throws Exception {
                state = 56;
                if( var19_SG23 != null ) { var19_SG23.close(); var19_SG23 = null; }
                var20_SG24 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG24", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_56() throws Exception {
                state = 56;
                if (!var20_SG24.moveNext()) {state = 57; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG24", (new seq119_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var20_SG24.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_57() throws Exception {
                state = 59;
                if( var20_SG24 != null ) { var20_SG24.close(); var20_SG24 = null; }
                var21_SG25 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG25", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_59() throws Exception {
                state = 59;
                if (!var21_SG25.moveNext()) {state = 60; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG25", (new seq124_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var21_SG25.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_60() throws Exception {
                state = 62;
                if( var21_SG25 != null ) { var21_SG25.close(); var21_SG25 = null; }
                var22_UNS = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNS", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_62() throws Exception {
                state = 62;
                if (!var22_UNS.moveNext()) {state = 63; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("UNS", (new seq149_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var22_UNS.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_63() throws Exception {
                state = 65;
                if( var22_UNS != null ) { var22_UNS.close(); var22_UNS = null; }
                var23_CNT = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CNT", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_65() throws Exception {
                state = 65;
                if (!var23_CNT.moveNext()) {state = 66; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("CNT", (new seq150_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var23_CNT.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_66() throws Exception {
                state = 68;
                if( var23_CNT != null ) { var23_CNT.close(); var23_CNT = null; }
                var24_SG48 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG48", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_68() throws Exception {
                state = 68;
                if (!var24_SG48.moveNext()) {state = 69; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG48", (new seq152_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var24_SG48.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_69() throws Exception {
                state = 71;
                if( var24_SG48 != null ) { var24_SG48.close(); var24_SG48 = null; }
                var25_SG50 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG50", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_71() throws Exception {
                state = 71;
                if (!var25_SG50.moveNext()) {state = 72; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG50", (new seq113_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var25_SG50.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_72() throws Exception {
                state = 74;
                if( var25_SG50 != null ) { var25_SG50.close(); var25_SG50 = null; }
                var26_SG51 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG51", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_74() throws Exception {
                state = 74;
                if (!var26_SG51.moveNext()) {state = 75; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG51", (new seq153_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var26_SG51.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_75() throws Exception {
                state = 77;
                if( var26_SG51 != null ) { var26_SG51.close(); var26_SG51 = null; }
                var27_UNT = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNT", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_77() throws Exception {
                state = 77;
                if (!var27_UNT.moveNext()) {state = 78; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("UNT", (new seq154_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var27_UNT.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_78() throws Exception {
                state = 0;
                if( var27_UNT != null ) { var27_UNT.close(); var27_UNT = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_UNH != null ) { var2_UNH.close(); var2_UNH = null; }
                    if( var3_BGM != null ) { var3_BGM.close(); var3_BGM = null; }
                    if( var4_DTM != null ) { var4_DTM.close(); var4_DTM = null; }
                    if( var5_PAI != null ) { var5_PAI.close(); var5_PAI = null; }
                    if( var6_ALI != null ) { var6_ALI.close(); var6_ALI = null; }
                    if( var7_IMD != null ) { var7_IMD.close(); var7_IMD = null; }
                    if( var8_FTX != null ) { var8_FTX.close(); var8_FTX = null; }
                    if( var9_SG1 != null ) { var9_SG1.close(); var9_SG1 = null; }
                    if( var10_SG2 != null ) { var10_SG2.close(); var10_SG2 = null; }
                    if( var11_SG6 != null ) { var11_SG6.close(); var11_SG6 = null; }
                    if( var12_SG7 != null ) { var12_SG7.close(); var12_SG7 = null; }
                    if( var13_SG8 != null ) { var13_SG8.close(); var13_SG8 = null; }
                    if( var14_SG9 != null ) { var14_SG9.close(); var14_SG9 = null; }
                    if( var15_SG12 != null ) { var15_SG12.close(); var15_SG12 = null; }
                    if( var16_SG13 != null ) { var16_SG13.close(); var16_SG13 = null; }
                    if( var17_SG15 != null ) { var17_SG15.close(); var17_SG15 = null; }
                    if( var18_SG22 != null ) { var18_SG22.close(); var18_SG22 = null; }
                    if( var19_SG23 != null ) { var19_SG23.close(); var19_SG23 = null; }
                    if( var20_SG24 != null ) { var20_SG24.close(); var20_SG24 = null; }
                    if( var21_SG25 != null ) { var21_SG25.close(); var21_SG25 = null; }
                    if( var22_UNS != null ) { var22_UNS.close(); var22_UNS = null; }
                    if( var23_CNT != null ) { var23_CNT.close(); var23_CNT = null; }
                    if( var24_SG48 != null ) { var24_SG48.close(); var24_SG48 = null; }
                    if( var25_SG50 != null ) { var25_SG50.close(); var25_SG50 = null; }
                    if( var26_SG51 != null ) { var26_SG51.close(); var26_SG51 = null; }
                    if( var27_UNT != null ) { var27_UNT.close(); var27_UNT = null; }
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
                var2_F0062 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0062", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0068 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0068", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_S009 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S009", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_S010 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S010", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var6_S016 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S016", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var7_S017 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S017", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var8_S018 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S018", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var2_F0065 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0065", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0052 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0052", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F0054 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0054", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F0051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0051", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var6_F0057 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0057", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var7_F0110 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0110", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var8_F0113 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0113", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var2_F0070 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0070", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0073 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0073", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var2_F0115 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0115", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0116 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0116", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F0118 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0118", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F0051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0051", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var2_F0121 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0121", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0122 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0122", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F0124 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0124", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F0051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0051", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var2_F0127 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0127", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0128 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0128", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F0130 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0130", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F0051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0051", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_F1004;
            IEnumerator var3_F1225;
            IEnumerator var4_F4343;
            IEnumerator var5_C002;
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
                var2_F1004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1004", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F1225 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1225", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1225.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1225", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1225.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1225 != null ) { var3_F1225.close(); var3_F1225 = null; }
                var4_F4343 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4343", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F4343.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4343", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F4343.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F4343 != null ) { var4_F4343.close(); var4_F4343 = null; }
                var5_C002 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C002", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                state = 0;
                if( var5_C002 != null ) { var5_C002.close(); var5_C002 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F1004 != null ) { var2_F1004.close(); var2_F1004 = null; }
                    if( var3_F1225 != null ) { var3_F1225.close(); var3_F1225 = null; }
                    if( var4_F4343 != null ) { var4_F4343.close(); var4_F4343 = null; }
                    if( var5_C002 != null ) { var5_C002.close(); var5_C002 = null; }
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
                var2_F1001 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1001", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F1000 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1000", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
    static class seq23_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq23_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq23_map closure;
            IEnumerator var2_C507;
            public Enumerator(seq23_map closure)
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
                var2_C507 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C507", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C507.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C507", (new seq24_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C507.current())))));
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
            IEnumerator var2_F2005;
            IEnumerator var3_F2380;
            IEnumerator var4_F2379;
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
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F2005 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F2005", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F2380 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F2380", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F2379 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F2379", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
    static class seq25_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq25_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq25_map closure;
            IEnumerator var2_C534;
            public Enumerator(seq25_map closure)
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
                var2_C534 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C534", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C534.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C534", (new seq26_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C534.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_C534 != null ) { var2_C534.close(); var2_C534 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_C534 != null ) { var2_C534.close(); var2_C534 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq26_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq26_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq26_join closure;
            IEnumerator var2_F4439;
            IEnumerator var3_F4431;
            IEnumerator var4_F4461;
            IEnumerator var5_F1131;
            IEnumerator var6_F3055;
            IEnumerator var7_F4435;
            public Enumerator(seq26_join closure)
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
                var2_F4439 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4439", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4439.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4439", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4439.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4439 != null ) { var2_F4439.close(); var2_F4439 = null; }
                var3_F4431 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4431", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F4431.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4431", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F4431.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F4431 != null ) { var3_F4431.close(); var3_F4431 = null; }
                var4_F4461 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4461", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F4461.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4461", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F4461.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F4461 != null ) { var4_F4461.close(); var4_F4461 = null; }
                var5_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var6_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                state = 17;
                if( var6_F3055 != null ) { var6_F3055.close(); var6_F3055 = null; }
                var7_F4435 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4435", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_F4435.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4435", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_F4435.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_F4435 != null ) { var7_F4435.close(); var7_F4435 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4439 != null ) { var2_F4439.close(); var2_F4439 = null; }
                    if( var3_F4431 != null ) { var3_F4431.close(); var3_F4431 = null; }
                    if( var4_F4461 != null ) { var4_F4461.close(); var4_F4461 = null; }
                    if( var5_F1131 != null ) { var5_F1131.close(); var5_F1131 = null; }
                    if( var6_F3055 != null ) { var6_F3055.close(); var6_F3055 = null; }
                    if( var7_F4435 != null ) { var7_F4435.close(); var7_F4435 = null; }
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
            IEnumerator var2_F3239;
            IEnumerator var3_F9213;
            IEnumerator var4_F4183;
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
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3239 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3239", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3239.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3239", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3239.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3239 != null ) { var2_F3239.close(); var2_F3239 = null; }
                var3_F9213 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F9213", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F9213.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F9213", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F9213.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F9213 != null ) { var3_F9213.close(); var3_F9213 = null; }
                var4_F4183 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4183", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F4183.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4183", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F4183.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F4183 != null ) { var4_F4183.close(); var4_F4183 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3239 != null ) { var2_F3239.close(); var2_F3239 = null; }
                    if( var3_F9213 != null ) { var3_F9213.close(); var3_F9213 = null; }
                    if( var4_F4183 != null ) { var4_F4183.close(); var4_F4183 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq28_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq28_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq28_join closure;
            IEnumerator var2_F7077;
            IEnumerator var3_F7081;
            IEnumerator var4_F7383;
            IEnumerator var5_C273;
            public Enumerator(seq28_join closure)
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
                var2_F7077 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7077", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7077.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7077", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7077.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7077 != null ) { var2_F7077.close(); var2_F7077 = null; }
                var3_F7081 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7081", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F7081.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7081", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F7081.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F7081 != null ) { var3_F7081.close(); var3_F7081 = null; }
                var4_F7383 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7383", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F7383.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7383", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F7383.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F7383 != null ) { var4_F7383.close(); var4_F7383 = null; }
                var5_C273 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C273", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C273.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C273", (new seq29_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C273.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_C273 != null ) { var5_C273.close(); var5_C273 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7077 != null ) { var2_F7077.close(); var2_F7077 = null; }
                    if( var3_F7081 != null ) { var3_F7081.close(); var3_F7081 = null; }
                    if( var4_F7383 != null ) { var4_F7383.close(); var4_F7383 = null; }
                    if( var5_C273 != null ) { var5_C273.close(); var5_C273 = null; }
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
            IEnumerator var2_F7009;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F7008;
            IEnumerator var6_F3453;
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
                var2_F7009 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7009", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7009.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7009", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7009.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7009 != null ) { var2_F7009.close(); var2_F7009 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F7008 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7008", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F7008.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7008", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F7008.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F7008 != null ) { var5_F7008.close(); var5_F7008 = null; }
                var6_F3453 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3453", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F3453.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3453", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F3453.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_F3453 != null ) { var6_F3453.close(); var6_F3453 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7009 != null ) { var2_F7009.close(); var2_F7009 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F7008 != null ) { var5_F7008.close(); var5_F7008 = null; }
                    if( var6_F3453 != null ) { var6_F3453.close(); var6_F3453 = null; }
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
            IEnumerator var2_F4451;
            IEnumerator var3_F4453;
            IEnumerator var4_F3453;
            IEnumerator var5_C107;
            IEnumerator var6_C108;
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
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4451 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4451", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F4453 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4453", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3453 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3453", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_C107 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C107", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C107.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C107", (new seq31_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C107.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_C107 != null ) { var5_C107.close(); var5_C107 = null; }
                var6_C108 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C108", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_C108.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C108", (new seq32_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C108.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_C108 != null ) { var6_C108.close(); var6_C108 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4451 != null ) { var2_F4451.close(); var2_F4451 = null; }
                    if( var3_F4453 != null ) { var3_F4453.close(); var3_F4453 = null; }
                    if( var4_F3453 != null ) { var4_F3453.close(); var4_F3453 = null; }
                    if( var5_C107 != null ) { var5_C107.close(); var5_C107 = null; }
                    if( var6_C108 != null ) { var6_C108.close(); var6_C108 = null; }
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
            IEnumerator var2_F4441;
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
                var2_F4441 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4441", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
    static class seq32_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq32_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq32_map closure;
            IEnumerator var2_F4440;
            public Enumerator(seq32_map closure)
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
                var2_F4440 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4440", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_RFF;
            IEnumerator var3_DTM;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_RFF = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RFF", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_RFF.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("RFF", (new seq34_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_RFF.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_RFF != null ) { var2_RFF.close(); var2_RFF = null; }
                var3_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_DTM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq23_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_DTM.current())))));
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
    static class seq34_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq34_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq34_map closure;
            IEnumerator var2_C506;
            public Enumerator(seq34_map closure)
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
                var2_C506 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C506", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C506.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C506", (new seq35_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C506.current())))));
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
            IEnumerator var2_F1153;
            IEnumerator var3_F1154;
            IEnumerator var4_F1156;
            IEnumerator var5_F4000;
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
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F1153 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1153", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F1154 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1154", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F1156 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1156", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F4000 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4000", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                state = 0;
                if( var5_F4000 != null ) { var5_F4000.close(); var5_F4000 = null; }
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
            IEnumerator var2_NAD;
            IEnumerator var3_LOC;
            IEnumerator var4_FII;
            IEnumerator var5_SG3;
            IEnumerator var6_SG4;
            IEnumerator var7_SG5;
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
                var2_NAD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("NAD", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_NAD.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("NAD", (new seq37_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_NAD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_NAD != null ) { var2_NAD.close(); var2_NAD = null; }
                var3_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_LOC.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq42_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_LOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_LOC != null ) { var3_LOC.close(); var3_LOC = null; }
                var4_FII = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FII", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_FII.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("FII", (new seq46_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_FII.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_FII != null ) { var4_FII.close(); var4_FII = null; }
                var5_SG3 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG3", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_SG3.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG3", (new seq33_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_SG3.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_SG3 != null ) { var5_SG3.close(); var5_SG3 = null; }
                var6_SG4 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG4", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_SG4.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG4", (new seq49_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_SG4.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_SG4 != null ) { var6_SG4.close(); var6_SG4 = null; }
                var7_SG5 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG5", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_SG5.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG5", (new seq52_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_SG5.current())))));
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
                    if( var2_NAD != null ) { var2_NAD.close(); var2_NAD = null; }
                    if( var3_LOC != null ) { var3_LOC.close(); var3_LOC = null; }
                    if( var4_FII != null ) { var4_FII.close(); var4_FII = null; }
                    if( var5_SG3 != null ) { var5_SG3.close(); var5_SG3 = null; }
                    if( var6_SG4 != null ) { var6_SG4.close(); var6_SG4 = null; }
                    if( var7_SG5 != null ) { var7_SG5.close(); var7_SG5 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq37_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq37_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq37_join closure;
            IEnumerator var2_F3035;
            IEnumerator var3_F3164;
            IEnumerator var4_F3229;
            IEnumerator var5_F3251;
            IEnumerator var6_F3207;
            IEnumerator var7_C082;
            IEnumerator var8_C058;
            IEnumerator var9_C080;
            IEnumerator var10_C059;
            public Enumerator(seq37_join closure)
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
                var2_F3035 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3035", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F3164 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3164", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3229 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3229", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F3229.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3229", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F3229.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F3229 != null ) { var4_F3229.close(); var4_F3229 = null; }
                var5_F3251 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3251", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F3251.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3251", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F3251.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F3251 != null ) { var5_F3251.close(); var5_F3251 = null; }
                var6_F3207 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3207", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F3207.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3207", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F3207.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_F3207 != null ) { var6_F3207.close(); var6_F3207 = null; }
                var7_C082 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C082", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_C082.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C082", (new seq38_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_C082.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_C082 != null ) { var7_C082.close(); var7_C082 = null; }
                var8_C058 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C058", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_C058.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C058", (new seq39_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_C058.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_C058 != null ) { var8_C058.close(); var8_C058 = null; }
                var9_C080 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C080", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_C080.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C080", (new seq40_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_C080.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_C080 != null ) { var9_C080.close(); var9_C080 = null; }
                var10_C059 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C059", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_C059.moveNext()) {state = 27; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C059", (new seq41_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_C059.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 0;
                if( var10_C059 != null ) { var10_C059.close(); var10_C059 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3035 != null ) { var2_F3035.close(); var2_F3035 = null; }
                    if( var3_F3164 != null ) { var3_F3164.close(); var3_F3164 = null; }
                    if( var4_F3229 != null ) { var4_F3229.close(); var4_F3229 = null; }
                    if( var5_F3251 != null ) { var5_F3251.close(); var5_F3251 = null; }
                    if( var6_F3207 != null ) { var6_F3207.close(); var6_F3207 = null; }
                    if( var7_C082 != null ) { var7_C082.close(); var7_C082 = null; }
                    if( var8_C058 != null ) { var8_C058.close(); var8_C058 = null; }
                    if( var9_C080 != null ) { var9_C080.close(); var9_C080 = null; }
                    if( var10_C059 != null ) { var10_C059.close(); var10_C059 = null; }
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
            IEnumerator var2_F3039;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3039 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3039", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
    static class seq39_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq39_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq39_map closure;
            IEnumerator var2_F3124;
            public Enumerator(seq39_map closure)
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
                var2_F3124 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3124", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_F3036;
            IEnumerator var3_F3045;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3036 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3036", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F3045 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3045", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_F3042;
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
                var2_F3042 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3042", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
    static class seq42_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq42_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq42_join closure;
            IEnumerator var2_F3227;
            IEnumerator var3_F5479;
            IEnumerator var4_C517;
            IEnumerator var5_C519;
            IEnumerator var6_C553;
            public Enumerator(seq42_join closure)
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
                var2_F3227 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3227", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F5479 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5479", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_C517 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C517", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C517.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C517", (new seq43_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C517.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_C517 != null ) { var4_C517.close(); var4_C517 = null; }
                var5_C519 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C519", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C519.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C519", (new seq44_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C519.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_C519 != null ) { var5_C519.close(); var5_C519 = null; }
                var6_C553 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C553", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_C553.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C553", (new seq45_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C553.current())))));
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
            IEnumerator var2_F3225;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F3224;
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
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3225 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3225", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F3224 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3224", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_F3223;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F3222;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3223 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3223", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F3222 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3222", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_F3233;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F3232;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3233 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3233", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F3232 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3232", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
    static class seq46_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq46_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq46_join closure;
            IEnumerator var2_F3035;
            IEnumerator var3_F3207;
            IEnumerator var4_C078;
            IEnumerator var5_C088;
            public Enumerator(seq46_join closure)
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
                var2_F3035 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3035", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F3207 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3207", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F3207.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3207", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F3207.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F3207 != null ) { var3_F3207.close(); var3_F3207 = null; }
                var4_C078 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C078", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C078.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C078", (new seq47_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C078.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_C078 != null ) { var4_C078.close(); var4_C078 = null; }
                var5_C088 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C088", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C088.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C088", (new seq48_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C088.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_C088 != null ) { var5_C088.close(); var5_C088 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3035 != null ) { var2_F3035.close(); var2_F3035 = null; }
                    if( var3_F3207 != null ) { var3_F3207.close(); var3_F3207 = null; }
                    if( var4_C078 != null ) { var4_C078.close(); var4_C078 = null; }
                    if( var5_C088 != null ) { var5_C088.close(); var5_C088 = null; }
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
            IEnumerator var2_F3194;
            IEnumerator var3_F3192;
            IEnumerator var4_F6345;
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
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3194 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3194", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3194.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3194", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3194.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3194 != null ) { var2_F3194.close(); var2_F3194 = null; }
                var3_F3192 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3192", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F3192.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3192", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F3192.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F3192 != null ) { var3_F3192.close(); var3_F3192 = null; }
                var4_F6345 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6345", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                state = 0;
                if( var4_F6345 != null ) { var4_F6345.close(); var4_F6345 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3194 != null ) { var2_F3194.close(); var2_F3194 = null; }
                    if( var3_F3192 != null ) { var3_F3192.close(); var3_F3192 = null; }
                    if( var4_F6345 != null ) { var4_F6345.close(); var4_F6345 = null; }
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
            IEnumerator var2_F3433;
            IEnumerator var3_F1131_1;
            IEnumerator var4_F3055_1;
            IEnumerator var5_F3434;
            IEnumerator var6_F1131_2;
            IEnumerator var7_F3055_2;
            IEnumerator var8_F3432;
            IEnumerator var9_F3436;
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
                var2_F3433 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3433", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3433.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3433", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3433.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3433 != null ) { var2_F3433.close(); var2_F3433 = null; }
                var3_F1131_1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131_1", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055_1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055_1", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F3434 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3434", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F3434.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3434", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F3434.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F3434 != null ) { var5_F3434.close(); var5_F3434 = null; }
                var6_F1131_2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131_2", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var7_F3055_2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055_2", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                state = 20;
                if( var7_F3055_2 != null ) { var7_F3055_2.close(); var7_F3055_2 = null; }
                var8_F3432 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3432", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_F3432.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3432", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_F3432.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_F3432 != null ) { var8_F3432.close(); var8_F3432 = null; }
                var9_F3436 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3436", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_F3436.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3436", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_F3436.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 0;
                if( var9_F3436 != null ) { var9_F3436.close(); var9_F3436 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3433 != null ) { var2_F3433.close(); var2_F3433 = null; }
                    if( var3_F1131_1 != null ) { var3_F1131_1.close(); var3_F1131_1 = null; }
                    if( var4_F3055_1 != null ) { var4_F3055_1.close(); var4_F3055_1 = null; }
                    if( var5_F3434 != null ) { var5_F3434.close(); var5_F3434 = null; }
                    if( var6_F1131_2 != null ) { var6_F1131_2.close(); var6_F1131_2 = null; }
                    if( var7_F3055_2 != null ) { var7_F3055_2.close(); var7_F3055_2 = null; }
                    if( var8_F3432 != null ) { var8_F3432.close(); var8_F3432 = null; }
                    if( var9_F3436 != null ) { var9_F3436.close(); var9_F3436 = null; }
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
            IEnumerator var2_DOC;
            IEnumerator var3_DTM;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_DOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DOC", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_DOC.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DOC", (new seq50_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_DOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_DOC != null ) { var2_DOC.close(); var2_DOC = null; }
                var3_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_DTM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq23_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_DTM.current())))));
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
            IEnumerator var2_F3153;
            IEnumerator var3_F1220;
            IEnumerator var4_F1218;
            IEnumerator var5_C002;
            IEnumerator var6_C503;
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
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3153 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3153", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F1220 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1220", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F1218 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1218", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_C002 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C002", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var6_C503 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C503", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_C503.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C503", (new seq51_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C503.current())))));
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
            IEnumerator var2_F1004;
            IEnumerator var3_F1373;
            IEnumerator var4_F1366;
            IEnumerator var5_F3453;
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
                var2_F1004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1004", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F1373 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1373", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F1366 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1366", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F3453 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3453", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                state = 0;
                if( var5_F3453 != null ) { var5_F3453.close(); var5_F3453 = null; }
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
            IEnumerator var2_CTA;
            IEnumerator var3_COM;
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
                var2_CTA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CTA", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_CTA.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("CTA", (new seq53_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_CTA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_CTA != null ) { var2_CTA.close(); var2_CTA = null; }
                var3_COM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("COM", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_COM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("COM", (new seq55_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_COM.current())))));
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
            IEnumerator var2_F3139;
            IEnumerator var3_C056;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3139 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3139", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_C056 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C056", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C056.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C056", (new seq54_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C056.current())))));
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
            IEnumerator var2_F3413;
            IEnumerator var3_F3412;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F3413 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3413", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F3412 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3412", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
    static class seq55_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq55_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq55_map closure;
            IEnumerator var2_C076;
            public Enumerator(seq55_map closure)
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
                var2_C076 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C076", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C076.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C076", (new seq56_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C076.current())))));
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
    static class seq56_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq56_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq56_join closure;
            IEnumerator var2_F3148;
            IEnumerator var3_F3155;
            public Enumerator(seq56_join closure)
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
                var2_F3148 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3148", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F3155 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3155", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_TAX;
            IEnumerator var3_MOA;
            IEnumerator var4_LOC;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_TAX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TAX", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_TAX.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TAX", (new seq58_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_TAX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_TAX != null ) { var2_TAX.close(); var2_TAX = null; }
                var3_MOA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MOA", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_MOA.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MOA", (new seq62_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_MOA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_MOA != null ) { var3_MOA.close(); var3_MOA = null; }
                var4_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_LOC.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq42_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_LOC.current())))));
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
                    if( var2_TAX != null ) { var2_TAX.close(); var2_TAX = null; }
                    if( var3_MOA != null ) { var3_MOA.close(); var3_MOA = null; }
                    if( var4_LOC != null ) { var4_LOC.close(); var4_LOC = null; }
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
            IEnumerator var2_F5283;
            IEnumerator var3_F5286;
            IEnumerator var4_F5305;
            IEnumerator var5_F3446;
            IEnumerator var6_C241;
            IEnumerator var7_C533;
            IEnumerator var8_C243;
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
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F5283 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5283", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F5283.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5283", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F5283.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F5283 != null ) { var2_F5283.close(); var2_F5283 = null; }
                var3_F5286 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5286", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F5286.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5286", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F5286.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F5286 != null ) { var3_F5286.close(); var3_F5286 = null; }
                var4_F5305 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5305", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F5305.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5305", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F5305.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F5305 != null ) { var4_F5305.close(); var4_F5305 = null; }
                var5_F3446 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3446", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F3446.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3446", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F3446.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F3446 != null ) { var5_F3446.close(); var5_F3446 = null; }
                var6_C241 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C241", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_C241.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C241", (new seq59_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C241.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_C241 != null ) { var6_C241.close(); var6_C241 = null; }
                var7_C533 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C533", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_C533.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C533", (new seq60_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_C533.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_C533 != null ) { var7_C533.close(); var7_C533 = null; }
                var8_C243 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C243", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_C243.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C243", (new seq61_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_C243.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 0;
                if( var8_C243 != null ) { var8_C243.close(); var8_C243 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F5283 != null ) { var2_F5283.close(); var2_F5283 = null; }
                    if( var3_F5286 != null ) { var3_F5286.close(); var3_F5286 = null; }
                    if( var4_F5305 != null ) { var4_F5305.close(); var4_F5305 = null; }
                    if( var5_F3446 != null ) { var5_F3446.close(); var5_F3446 = null; }
                    if( var6_C241 != null ) { var6_C241.close(); var6_C241 = null; }
                    if( var7_C533 != null ) { var7_C533.close(); var7_C533 = null; }
                    if( var8_C243 != null ) { var8_C243.close(); var8_C243 = null; }
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
            IEnumerator var2_F5153;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F5152;
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
                var2_F5153 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5153", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F5153.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5153", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F5153.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F5153 != null ) { var2_F5153.close(); var2_F5153 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F5152 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5152", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F5152.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5152", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F5152.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F5152 != null ) { var5_F5152.close(); var5_F5152 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F5153 != null ) { var2_F5153.close(); var2_F5153 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F5152 != null ) { var5_F5152.close(); var5_F5152 = null; }
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
            IEnumerator var2_F5289;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F5289 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5289", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F5289.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5289", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F5289.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F5289 != null ) { var2_F5289.close(); var2_F5289 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                    if( var2_F5289 != null ) { var2_F5289.close(); var2_F5289 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
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
            IEnumerator var2_F5279;
            IEnumerator var3_F1131_1;
            IEnumerator var4_F3055_1;
            IEnumerator var5_F5278;
            IEnumerator var6_F5273;
            IEnumerator var7_F1131_2;
            IEnumerator var8_F3055_2;
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
                var2_F5279 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5279", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F5279.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5279", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F5279.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F5279 != null ) { var2_F5279.close(); var2_F5279 = null; }
                var3_F1131_1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131_1", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055_1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055_1", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F5278 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5278", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F5278.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5278", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F5278.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F5278 != null ) { var5_F5278.close(); var5_F5278 = null; }
                var6_F5273 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5273", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F5273.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5273", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F5273.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_F5273 != null ) { var6_F5273.close(); var6_F5273 = null; }
                var7_F1131_2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131_2", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var8_F3055_2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055_2", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                state = 0;
                if( var8_F3055_2 != null ) { var8_F3055_2.close(); var8_F3055_2 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F5279 != null ) { var2_F5279.close(); var2_F5279 = null; }
                    if( var3_F1131_1 != null ) { var3_F1131_1.close(); var3_F1131_1 = null; }
                    if( var4_F3055_1 != null ) { var4_F3055_1.close(); var4_F3055_1 = null; }
                    if( var5_F5278 != null ) { var5_F5278.close(); var5_F5278 = null; }
                    if( var6_F5273 != null ) { var6_F5273.close(); var6_F5273 = null; }
                    if( var7_F1131_2 != null ) { var7_F1131_2.close(); var7_F1131_2 = null; }
                    if( var8_F3055_2 != null ) { var8_F3055_2.close(); var8_F3055_2 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq62_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq62_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq62_map closure;
            IEnumerator var2_C516;
            public Enumerator(seq62_map closure)
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
                var2_C516 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C516", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C516.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C516", (new seq63_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C516.current())))));
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
    static class seq63_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq63_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq63_join closure;
            IEnumerator var2_F5025;
            IEnumerator var3_F5004;
            IEnumerator var4_F6345;
            IEnumerator var5_F6343;
            IEnumerator var6_F4405;
            public Enumerator(seq63_join closure)
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
                var2_F5025 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5025", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F5004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5004", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F6345 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6345", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F6343 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6343", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var6_F4405 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4405", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_CUX;
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
                var2_CUX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CUX", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_CUX.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("CUX", (new seq65_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_CUX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_CUX != null ) { var2_CUX.close(); var2_CUX = null; }
                var3_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_DTM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq23_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_DTM.current())))));
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
                    if( var2_CUX != null ) { var2_CUX.close(); var2_CUX = null; }
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
            IEnumerator var2_F5402;
            IEnumerator var3_F6341;
            IEnumerator var4_C504;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F5402 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5402", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F6341 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6341", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_C504 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C504", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C504.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C504", (new seq66_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C504.current())))));
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
            IEnumerator var2_F6347;
            IEnumerator var3_F6345;
            IEnumerator var4_F6343;
            IEnumerator var5_F6348;
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
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6347 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6347", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F6345 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6345", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F6343 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6343", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F6348 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6348", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_PAT;
            IEnumerator var3_DTM;
            IEnumerator var4_PCD;
            IEnumerator var5_MOA;
            IEnumerator var6_PAI;
            IEnumerator var7_FII;
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
                var2_PAT = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PAT", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_PAT.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PAT", (new seq68_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_PAT.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_PAT != null ) { var2_PAT.close(); var2_PAT = null; }
                var3_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_DTM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq23_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                var4_PCD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PCD", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_PCD.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PCD", (new seq71_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_PCD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_PCD != null ) { var4_PCD.close(); var4_PCD = null; }
                var5_MOA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MOA", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_MOA.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MOA", (new seq62_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_MOA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_MOA != null ) { var5_MOA.close(); var5_MOA = null; }
                var6_PAI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PAI", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_PAI.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PAI", (new seq25_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_PAI.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_PAI != null ) { var6_PAI.close(); var6_PAI = null; }
                var7_FII = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FII", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_FII.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("FII", (new seq46_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_FII.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_FII != null ) { var7_FII.close(); var7_FII = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_PAT != null ) { var2_PAT.close(); var2_PAT = null; }
                    if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                    if( var4_PCD != null ) { var4_PCD.close(); var4_PCD = null; }
                    if( var5_MOA != null ) { var5_MOA.close(); var5_MOA = null; }
                    if( var6_PAI != null ) { var6_PAI.close(); var6_PAI = null; }
                    if( var7_FII != null ) { var7_FII.close(); var7_FII = null; }
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
            IEnumerator var2_F4279;
            IEnumerator var3_C110;
            IEnumerator var4_C112;
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
                var2_F4279 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4279", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4279.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4279", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4279.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4279 != null ) { var2_F4279.close(); var2_F4279 = null; }
                var3_C110 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C110", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C110.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C110", (new seq69_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C110.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_C110 != null ) { var3_C110.close(); var3_C110 = null; }
                var4_C112 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C112", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C112.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C112", (new seq70_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C112.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_C112 != null ) { var4_C112.close(); var4_C112 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4279 != null ) { var2_F4279.close(); var2_F4279 = null; }
                    if( var3_C110 != null ) { var3_C110.close(); var3_C110 = null; }
                    if( var4_C112 != null ) { var4_C112.close(); var4_C112 = null; }
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
            IEnumerator var2_F4277;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F4276;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4277 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4277", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4277.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4277", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4277.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4277 != null ) { var2_F4277.close(); var2_F4277 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F4276 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4276", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F4276.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4276", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F4276.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F4276 != null ) { var5_F4276.close(); var5_F4276 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4277 != null ) { var2_F4277.close(); var2_F4277 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F4276 != null ) { var5_F4276.close(); var5_F4276 = null; }
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
            IEnumerator var2_F2475;
            IEnumerator var3_F2009;
            IEnumerator var4_F2151;
            IEnumerator var5_F2152;
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
                var2_F2475 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F2475", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F2475.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F2475", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F2475.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F2475 != null ) { var2_F2475.close(); var2_F2475 = null; }
                var3_F2009 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F2009", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F2009.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F2009", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F2009.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F2009 != null ) { var3_F2009.close(); var3_F2009 = null; }
                var4_F2151 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F2151", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F2151.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F2151", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F2151.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F2151 != null ) { var4_F2151.close(); var4_F2151 = null; }
                var5_F2152 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F2152", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F2152.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F2152", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F2152.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F2152 != null ) { var5_F2152.close(); var5_F2152 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F2475 != null ) { var2_F2475.close(); var2_F2475 = null; }
                    if( var3_F2009 != null ) { var3_F2009.close(); var3_F2009 = null; }
                    if( var4_F2151 != null ) { var4_F2151.close(); var4_F2151 = null; }
                    if( var5_F2152 != null ) { var5_F2152.close(); var5_F2152 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq71_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq71_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq71_map closure;
            IEnumerator var2_C501;
            public Enumerator(seq71_map closure)
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
                var2_C501 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C501", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C501.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C501", (new seq72_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C501.current())))));
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
            IEnumerator var2_F5245;
            IEnumerator var3_F5482;
            IEnumerator var4_F5249;
            IEnumerator var5_F1131;
            IEnumerator var6_F3055;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F5245 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5245", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F5482 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5482", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F5249 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5249", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var6_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_TDT;
            IEnumerator var3_SG10;
            IEnumerator var4_SG11;
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
                var2_TDT = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TDT", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_TDT.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TDT", (new seq74_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_TDT.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_TDT != null ) { var2_TDT.close(); var2_TDT = null; }
                var3_SG10 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG10", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_SG10.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG10", (new seq80_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_SG10.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_SG10 != null ) { var3_SG10.close(); var3_SG10 = null; }
                var4_SG11 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG11", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_SG11.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG11", (new seq33_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_SG11.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_SG11 != null ) { var4_SG11.close(); var4_SG11 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_TDT != null ) { var2_TDT.close(); var2_TDT = null; }
                    if( var3_SG10 != null ) { var3_SG10.close(); var3_SG10 = null; }
                    if( var4_SG11 != null ) { var4_SG11.close(); var4_SG11 = null; }
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
            IEnumerator var2_F8051;
            IEnumerator var3_F8028;
            IEnumerator var4_F8101;
            IEnumerator var5_F8281;
            IEnumerator var6_C220;
            IEnumerator var7_C228;
            IEnumerator var8_C040;
            IEnumerator var9_C401;
            IEnumerator var10_C222;
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
                var2_F8051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8051", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F8028 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8028", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F8101 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8101", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F8281 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8281", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var6_C220 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C220", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_C220.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C220", (new seq75_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C220.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_C220 != null ) { var6_C220.close(); var6_C220 = null; }
                var7_C228 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C228", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_C228.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C228", (new seq76_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_C228.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_C228 != null ) { var7_C228.close(); var7_C228 = null; }
                var8_C040 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C040", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_C040.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C040", (new seq77_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_C040.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_C040 != null ) { var8_C040.close(); var8_C040 = null; }
                var9_C401 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C401", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_C401.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C401", (new seq78_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_C401.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_C401 != null ) { var9_C401.close(); var9_C401 = null; }
                var10_C222 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C222", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_C222.moveNext()) {state = 27; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C222", (new seq79_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_C222.current())))));
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
            IEnumerator var2_F8067;
            IEnumerator var3_F8066;
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
                var2_F8067 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8067", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F8066 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8066", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_F8179;
            IEnumerator var3_F8178;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8179 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8179", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F8178 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8178", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
    static class seq77_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq77_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq77_join closure;
            IEnumerator var2_F3127;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F3128;
            public Enumerator(seq77_join closure)
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
                var2_F3127 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3127", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F3128 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3128", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_F8457;
            IEnumerator var3_F8459;
            IEnumerator var4_F7130;
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
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8457 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8457", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F8459 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8459", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F7130 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7130", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
    static class seq79_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq79_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq79_join closure;
            IEnumerator var2_F8213;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F8212;
            IEnumerator var6_F8453;
            public Enumerator(seq79_join closure)
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
                var2_F8213 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8213", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F8212 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8212", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var6_F8453 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8453", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_LOC;
            IEnumerator var3_DTM;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_LOC.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq42_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_LOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_LOC != null ) { var2_LOC.close(); var2_LOC = null; }
                var3_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_DTM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq23_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_DTM.current())))));
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
    static class seq81_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq81_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq81_join closure;
            IEnumerator var2_TOD;
            IEnumerator var3_LOC;
            public Enumerator(seq81_join closure)
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
                var2_TOD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TOD", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_TOD.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TOD", (new seq82_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_TOD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_TOD != null ) { var2_TOD.close(); var2_TOD = null; }
                var3_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_LOC.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq42_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_LOC.current())))));
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
            IEnumerator var2_F4055;
            IEnumerator var3_F4215;
            IEnumerator var4_C100;
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
                var2_F4055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F4215 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4215", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_C100 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C100", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C100.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C100", (new seq83_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C100.current())))));
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
            IEnumerator var2_F4053;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F4052;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4053 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4053", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F4052 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4052", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_PAC;
            IEnumerator var3_MEA;
            IEnumerator var4_SG14;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_PAC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PAC", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_PAC.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PAC", (new seq85_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_PAC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_PAC != null ) { var2_PAC.close(); var2_PAC = null; }
                var3_MEA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MEA", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_MEA.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MEA", (new seq90_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_MEA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_MEA != null ) { var3_MEA.close(); var3_MEA = null; }
                var4_SG14 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG14", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_SG14.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG14", (new seq93_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_SG14.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_SG14 != null ) { var4_SG14.close(); var4_SG14 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_PAC != null ) { var2_PAC.close(); var2_PAC = null; }
                    if( var3_MEA != null ) { var3_MEA.close(); var3_MEA = null; }
                    if( var4_SG14 != null ) { var4_SG14.close(); var4_SG14 = null; }
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
            IEnumerator var2_F7224;
            IEnumerator var3_C531;
            IEnumerator var4_C202;
            IEnumerator var5_C402;
            IEnumerator var6_C532;
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
                var2_F7224 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7224", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_C531 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C531", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C531.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C531", (new seq86_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C531.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_C531 != null ) { var3_C531.close(); var3_C531 = null; }
                var4_C202 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C202", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C202.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C202", (new seq87_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C202.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_C202 != null ) { var4_C202.close(); var4_C202 = null; }
                var5_C402 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C402", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C402.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C402", (new seq88_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C402.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_C402 != null ) { var5_C402.close(); var5_C402 = null; }
                var6_C532 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C532", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_C532.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C532", (new seq89_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C532.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_C532 != null ) { var6_C532.close(); var6_C532 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7224 != null ) { var2_F7224.close(); var2_F7224 = null; }
                    if( var3_C531 != null ) { var3_C531.close(); var3_C531 = null; }
                    if( var4_C202 != null ) { var4_C202.close(); var4_C202 = null; }
                    if( var5_C402 != null ) { var5_C402.close(); var5_C402 = null; }
                    if( var6_C532 != null ) { var6_C532.close(); var6_C532 = null; }
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
            IEnumerator var2_F7075;
            IEnumerator var3_F7233;
            IEnumerator var4_F7073;
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
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7075 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7075", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7075.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7075", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7075.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7075 != null ) { var2_F7075.close(); var2_F7075 = null; }
                var3_F7233 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7233", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F7233.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7233", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F7233.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F7233 != null ) { var3_F7233.close(); var3_F7233 = null; }
                var4_F7073 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7073", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F7073.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7073", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F7073.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F7073 != null ) { var4_F7073.close(); var4_F7073 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7075 != null ) { var2_F7075.close(); var2_F7075 = null; }
                    if( var3_F7233 != null ) { var3_F7233.close(); var3_F7233 = null; }
                    if( var4_F7073 != null ) { var4_F7073.close(); var4_F7073 = null; }
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
            IEnumerator var2_F7065;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F7064;
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
                var2_F7065 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7065", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7065.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7065", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7065.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7065 != null ) { var2_F7065.close(); var2_F7065 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F7064 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7064", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F7064.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7064", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F7064.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F7064 != null ) { var5_F7064.close(); var5_F7064 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7065 != null ) { var2_F7065.close(); var2_F7065 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F7064 != null ) { var5_F7064.close(); var5_F7064 = null; }
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
            IEnumerator var2_F7077;
            IEnumerator var3_F7064_1;
            IEnumerator var4_F7143_1;
            IEnumerator var5_F7064_2;
            IEnumerator var6_F7143_2;
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
                var2_F7077 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7077", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7077.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7077", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7077.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7077 != null ) { var2_F7077.close(); var2_F7077 = null; }
                var3_F7064_1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7064_1", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F7064_1.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7064_1", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F7064_1.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F7064_1 != null ) { var3_F7064_1.close(); var3_F7064_1 = null; }
                var4_F7143_1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7143_1", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F7143_1.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7143_1", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F7143_1.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F7143_1 != null ) { var4_F7143_1.close(); var4_F7143_1 = null; }
                var5_F7064_2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7064_2", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F7064_2.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7064_2", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F7064_2.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F7064_2 != null ) { var5_F7064_2.close(); var5_F7064_2 = null; }
                var6_F7143_2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7143_2", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F7143_2.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7143_2", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F7143_2.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_F7143_2 != null ) { var6_F7143_2.close(); var6_F7143_2 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7077 != null ) { var2_F7077.close(); var2_F7077 = null; }
                    if( var3_F7064_1 != null ) { var3_F7064_1.close(); var3_F7064_1 = null; }
                    if( var4_F7143_1 != null ) { var4_F7143_1.close(); var4_F7143_1 = null; }
                    if( var5_F7064_2 != null ) { var5_F7064_2.close(); var5_F7064_2 = null; }
                    if( var6_F7143_2 != null ) { var6_F7143_2.close(); var6_F7143_2 = null; }
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
            IEnumerator var2_F8395;
            IEnumerator var3_F8393;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8395 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8395", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F8395.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8395", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F8395.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F8395 != null ) { var2_F8395.close(); var2_F8395 = null; }
                var3_F8393 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8393", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F8393.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F8393", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F8393.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F8393 != null ) { var3_F8393.close(); var3_F8393 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F8395 != null ) { var2_F8395.close(); var2_F8395 = null; }
                    if( var3_F8393 != null ) { var3_F8393.close(); var3_F8393 = null; }
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
            IEnumerator var2_F6311;
            IEnumerator var3_F7383;
            IEnumerator var4_C502;
            IEnumerator var5_C174;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6311 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6311", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F7383 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7383", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_C502 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C502", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C502.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C502", (new seq91_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C502.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_C502 != null ) { var4_C502.close(); var4_C502 = null; }
                var5_C174 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C174", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C174.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C174", (new seq92_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C174.current())))));
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
            IEnumerator var2_F6313;
            IEnumerator var3_F6321;
            IEnumerator var4_F6155;
            IEnumerator var5_F6154;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6313 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6313", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F6321 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6321", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F6155 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6155", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F6154 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6154", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_F6411;
            IEnumerator var3_F6314;
            IEnumerator var4_F6162;
            IEnumerator var5_F6152;
            IEnumerator var6_F6432;
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
                var2_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F6314 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6314", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F6314.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6314", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F6314.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F6314 != null ) { var3_F6314.close(); var3_F6314 = null; }
                var4_F6162 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6162", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F6152 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6152", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var6_F6432 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6432", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
    static class seq93_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq93_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq93_join closure;
            IEnumerator var2_PCI;
            IEnumerator var3_RFF;
            IEnumerator var4_DTM;
            IEnumerator var5_GIN;
            public Enumerator(seq93_join closure)
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
                var2_PCI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PCI", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_PCI.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PCI", (new seq94_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_PCI.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_PCI != null ) { var2_PCI.close(); var2_PCI = null; }
                var3_RFF = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RFF", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_RFF.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("RFF", (new seq34_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_RFF.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_RFF != null ) { var3_RFF.close(); var3_RFF = null; }
                var4_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_DTM.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq23_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_DTM != null ) { var4_DTM.close(); var4_DTM = null; }
                var5_GIN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("GIN", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_GIN.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("GIN", (new seq97_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_GIN.current())))));
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
            IEnumerator var2_F4233;
            IEnumerator var3_F8275;
            IEnumerator var4_C210;
            IEnumerator var5_C827;
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
                var2_F4233 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4233", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F8275 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8275", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_C210 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C210", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C210.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C210", (new seq95_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C210.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_C210 != null ) { var4_C210.close(); var4_C210 = null; }
                var5_C827 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C827", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C827.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C827", (new seq96_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C827.current())))));
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
            IEnumerator var2_F7102;
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
                var2_F7102 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7102", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_F7511;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7511 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7511", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_F7405;
            IEnumerator var3_C208;
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
                var2_F7405 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7405", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_C208 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C208", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C208.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C208", (new seq98_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C208.current())))));
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
    static class seq98_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq98_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq98_map closure;
            IEnumerator var2_F7402;
            public Enumerator(seq98_map closure)
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
                var2_F7402 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7402", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_ALC;
            IEnumerator var3_ALI;
            IEnumerator var4_SG16;
            IEnumerator var5_SG17;
            IEnumerator var6_SG18;
            IEnumerator var7_SG19;
            IEnumerator var8_SG20;
            IEnumerator var9_SG21;
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
                var2_ALC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("ALC", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_ALC.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("ALC", (new seq100_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_ALC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_ALC != null ) { var2_ALC.close(); var2_ALC = null; }
                var3_ALI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("ALI", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_ALI.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("ALI", (new seq27_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_ALI.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_ALI != null ) { var3_ALI.close(); var3_ALI = null; }
                var4_SG16 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG16", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_SG16.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG16", (new seq33_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_SG16.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_SG16 != null ) { var4_SG16.close(); var4_SG16 = null; }
                var5_SG17 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG17", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_SG17.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG17", (new seq103_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_SG17.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_SG17 != null ) { var5_SG17.close(); var5_SG17 = null; }
                var6_SG18 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG18", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_SG18.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG18", (new seq108_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_SG18.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_SG18 != null ) { var6_SG18.close(); var6_SG18 = null; }
                var7_SG19 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG19", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_SG19.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG19", (new seq109_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_SG19.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_SG19 != null ) { var7_SG19.close(); var7_SG19 = null; }
                var8_SG20 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG20", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_SG20.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG20", (new seq110_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_SG20.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_SG20 != null ) { var8_SG20.close(); var8_SG20 = null; }
                var9_SG21 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG21", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_SG21.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG21", (new seq113_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_SG21.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 0;
                if( var9_SG21 != null ) { var9_SG21.close(); var9_SG21 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_ALC != null ) { var2_ALC.close(); var2_ALC = null; }
                    if( var3_ALI != null ) { var3_ALI.close(); var3_ALI = null; }
                    if( var4_SG16 != null ) { var4_SG16.close(); var4_SG16 = null; }
                    if( var5_SG17 != null ) { var5_SG17.close(); var5_SG17 = null; }
                    if( var6_SG18 != null ) { var6_SG18.close(); var6_SG18 = null; }
                    if( var7_SG19 != null ) { var7_SG19.close(); var7_SG19 = null; }
                    if( var8_SG20 != null ) { var8_SG20.close(); var8_SG20 = null; }
                    if( var9_SG21 != null ) { var9_SG21.close(); var9_SG21 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq100_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq100_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq100_join closure;
            IEnumerator var2_F5463;
            IEnumerator var3_F4471;
            IEnumerator var4_F1227;
            IEnumerator var5_C552;
            IEnumerator var6_C214;
            public Enumerator(seq100_join closure)
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
                var2_F5463 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5463", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F5463.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5463", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F5463.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F5463 != null ) { var2_F5463.close(); var2_F5463 = null; }
                var3_F4471 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4471", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F4471.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4471", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F4471.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F4471 != null ) { var3_F4471.close(); var3_F4471 = null; }
                var4_F1227 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1227", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F1227.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1227", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F1227.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F1227 != null ) { var4_F1227.close(); var4_F1227 = null; }
                var5_C552 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C552", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C552.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C552", (new seq101_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C552.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_C552 != null ) { var5_C552.close(); var5_C552 = null; }
                var6_C214 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C214", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_C214.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C214", (new seq102_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C214.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_C214 != null ) { var6_C214.close(); var6_C214 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F5463 != null ) { var2_F5463.close(); var2_F5463 = null; }
                    if( var3_F4471 != null ) { var3_F4471.close(); var3_F4471 = null; }
                    if( var4_F1227 != null ) { var4_F1227.close(); var4_F1227 = null; }
                    if( var5_C552 != null ) { var5_C552.close(); var5_C552 = null; }
                    if( var6_C214 != null ) { var6_C214.close(); var6_C214 = null; }
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
            IEnumerator var2_F1230;
            IEnumerator var3_F5189;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F1230 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1230", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F1230.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1230", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F1230.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F1230 != null ) { var2_F1230.close(); var2_F1230 = null; }
                var3_F5189 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5189", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F5189.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5189", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F5189.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F5189 != null ) { var3_F5189.close(); var3_F5189 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F1230 != null ) { var2_F1230.close(); var2_F1230 = null; }
                    if( var3_F5189 != null ) { var3_F5189.close(); var3_F5189 = null; }
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
            IEnumerator var2_F7161;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F7160;
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
                var2_F7161 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7161", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7161.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7161", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7161.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7161 != null ) { var2_F7161.close(); var2_F7161 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F7160 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7160", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F7160.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7160", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F7160.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F7160 != null ) { var5_F7160.close(); var5_F7160 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7161 != null ) { var2_F7161.close(); var2_F7161 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F7160 != null ) { var5_F7160.close(); var5_F7160 = null; }
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
            IEnumerator var2_QTY;
            IEnumerator var3_RNG;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_QTY = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("QTY", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_QTY.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("QTY", (new seq104_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_QTY.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_QTY != null ) { var2_QTY.close(); var2_QTY = null; }
                var3_RNG = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RNG", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_RNG.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("RNG", (new seq106_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_RNG.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_RNG != null ) { var3_RNG.close(); var3_RNG = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_QTY != null ) { var2_QTY.close(); var2_QTY = null; }
                    if( var3_RNG != null ) { var3_RNG.close(); var3_RNG = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq104_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq104_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq104_map closure;
            IEnumerator var2_C186;
            public Enumerator(seq104_map closure)
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
                var2_C186 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C186", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C186.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C186", (new seq105_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C186.current())))));
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
            IEnumerator var2_F6063;
            IEnumerator var3_F6060;
            IEnumerator var4_F6411;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6063 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6063", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F6060 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6060", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F6060.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6060", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F6060.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F6060 != null ) { var3_F6060.close(); var3_F6060 = null; }
                var4_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_F6167;
            IEnumerator var3_C280;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6167 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6167", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_C280 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C280", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C280.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C280", (new seq107_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C280.current())))));
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
            IEnumerator var2_F6411;
            IEnumerator var3_F6162;
            IEnumerator var4_F6152;
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
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F6162 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6162", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F6152 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6152", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_PCD;
            IEnumerator var3_RNG;
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
                var2_PCD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PCD", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_PCD.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PCD", (new seq71_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_PCD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_PCD != null ) { var2_PCD.close(); var2_PCD = null; }
                var3_RNG = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RNG", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_RNG.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("RNG", (new seq106_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_RNG.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_RNG != null ) { var3_RNG.close(); var3_RNG = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_PCD != null ) { var2_PCD.close(); var2_PCD = null; }
                    if( var3_RNG != null ) { var3_RNG.close(); var3_RNG = null; }
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
            IEnumerator var2_MOA;
            IEnumerator var3_RNG;
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
                var2_MOA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MOA", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_MOA.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MOA", (new seq62_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_MOA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_MOA != null ) { var2_MOA.close(); var2_MOA = null; }
                var3_RNG = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RNG", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_RNG.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("RNG", (new seq106_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_RNG.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_RNG != null ) { var3_RNG.close(); var3_RNG = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_MOA != null ) { var2_MOA.close(); var2_MOA = null; }
                    if( var3_RNG != null ) { var3_RNG.close(); var3_RNG = null; }
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
            IEnumerator var2_RTE;
            IEnumerator var3_RNG;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_RTE = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RTE", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_RTE.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("RTE", (new seq111_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_RTE.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_RTE != null ) { var2_RTE.close(); var2_RTE = null; }
                var3_RNG = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RNG", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_RNG.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("RNG", (new seq106_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_RNG.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_RNG != null ) { var3_RNG.close(); var3_RNG = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_RTE != null ) { var2_RTE.close(); var2_RTE = null; }
                    if( var3_RNG != null ) { var3_RNG.close(); var3_RNG = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq111_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq111_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq111_map closure;
            IEnumerator var2_C128;
            public Enumerator(seq111_map closure)
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
                var2_C128 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C128", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C128.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C128", (new seq112_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C128.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_C128 != null ) { var2_C128.close(); var2_C128 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_C128 != null ) { var2_C128.close(); var2_C128 = null; }
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
            IEnumerator var2_F5419;
            IEnumerator var3_F5420;
            IEnumerator var4_F5284;
            IEnumerator var5_F6411;
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
                var2_F5419 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5419", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F5419.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5419", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F5419.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F5419 != null ) { var2_F5419.close(); var2_F5419 = null; }
                var3_F5420 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5420", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F5420.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5420", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F5420.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F5420 != null ) { var3_F5420.close(); var3_F5420 = null; }
                var4_F5284 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5284", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F5284.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5284", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F5284.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F5284 != null ) { var4_F5284.close(); var4_F5284 = null; }
                var5_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F6411.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6411", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F6411.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F6411 != null ) { var5_F6411.close(); var5_F6411 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F5419 != null ) { var2_F5419.close(); var2_F5419 = null; }
                    if( var3_F5420 != null ) { var3_F5420.close(); var3_F5420 = null; }
                    if( var4_F5284 != null ) { var4_F5284.close(); var4_F5284 = null; }
                    if( var5_F6411 != null ) { var5_F6411.close(); var5_F6411 = null; }
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
            IEnumerator var2_TAX;
            IEnumerator var3_MOA;
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
                var2_TAX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TAX", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_TAX.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TAX", (new seq58_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_TAX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_TAX != null ) { var2_TAX.close(); var2_TAX = null; }
                var3_MOA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MOA", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_MOA.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MOA", (new seq62_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_MOA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_MOA != null ) { var3_MOA.close(); var3_MOA = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_TAX != null ) { var2_TAX.close(); var2_TAX = null; }
                    if( var3_MOA != null ) { var3_MOA.close(); var3_MOA = null; }
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
            IEnumerator var2_RCS;
            IEnumerator var3_RFF;
            IEnumerator var4_DTM;
            IEnumerator var5_FTX;
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
                var2_RCS = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RCS", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_RCS.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("RCS", (new seq115_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_RCS.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_RCS != null ) { var2_RCS.close(); var2_RCS = null; }
                var3_RFF = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RFF", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_RFF.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("RFF", (new seq34_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_RFF.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_RFF != null ) { var3_RFF.close(); var3_RFF = null; }
                var4_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_DTM.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq23_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_DTM != null ) { var4_DTM.close(); var4_DTM = null; }
                var5_FTX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FTX", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_FTX.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("FTX", (new seq30_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_FTX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_FTX != null ) { var5_FTX.close(); var5_FTX = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_RCS != null ) { var2_RCS.close(); var2_RCS = null; }
                    if( var3_RFF != null ) { var3_RFF.close(); var3_RFF = null; }
                    if( var4_DTM != null ) { var4_DTM.close(); var4_DTM = null; }
                    if( var5_FTX != null ) { var5_FTX.close(); var5_FTX = null; }
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
            IEnumerator var2_F7293;
            IEnumerator var3_F1229;
            IEnumerator var4_C550;
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
                var2_F7293 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7293", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7293.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7293", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7293.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7293 != null ) { var2_F7293.close(); var2_F7293 = null; }
                var3_F1229 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1229", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1229.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1229", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1229.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1229 != null ) { var3_F1229.close(); var3_F1229 = null; }
                var4_C550 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C550", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C550.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C550", (new seq116_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C550.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_C550 != null ) { var4_C550.close(); var4_C550 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7293 != null ) { var2_F7293.close(); var2_F7293 = null; }
                    if( var3_F1229 != null ) { var3_F1229.close(); var3_F1229 = null; }
                    if( var4_C550 != null ) { var4_C550.close(); var4_C550 = null; }
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
            IEnumerator var2_F7295;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F7294;
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
                var2_F7295 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7295", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7295.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7295", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7295.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7295 != null ) { var2_F7295.close(); var2_F7295 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F7294 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7294", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F7294.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7294", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F7294.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F7294 != null ) { var5_F7294.close(); var5_F7294 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7295 != null ) { var2_F7295.close(); var2_F7295 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F7294 != null ) { var5_F7294.close(); var5_F7294 = null; }
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
            IEnumerator var2_AJT;
            IEnumerator var3_FTX;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_AJT = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("AJT", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_AJT.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("AJT", (new seq118_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_AJT.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_AJT != null ) { var2_AJT.close(); var2_AJT = null; }
                var3_FTX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FTX", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_FTX.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("FTX", (new seq30_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_FTX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_FTX != null ) { var3_FTX.close(); var3_FTX = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_AJT != null ) { var2_AJT.close(); var2_AJT = null; }
                    if( var3_FTX != null ) { var3_FTX.close(); var3_FTX = null; }
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
            IEnumerator var2_F4465;
            IEnumerator var3_F1082;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4465 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4465", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4465.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4465", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4465.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4465 != null ) { var2_F4465.close(); var2_F4465 = null; }
                var3_F1082 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1082", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1082.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1082", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1082.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F1082 != null ) { var3_F1082.close(); var3_F1082 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4465 != null ) { var2_F4465.close(); var2_F4465 = null; }
                    if( var3_F1082 != null ) { var3_F1082.close(); var3_F1082 = null; }
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
            IEnumerator var2_INP;
            IEnumerator var3_FTX;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_INP = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("INP", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_INP.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("INP", (new seq120_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_INP.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_INP != null ) { var2_INP.close(); var2_INP = null; }
                var3_FTX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FTX", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_FTX.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("FTX", (new seq30_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_FTX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_FTX != null ) { var3_FTX.close(); var3_FTX = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_INP != null ) { var2_INP.close(); var2_INP = null; }
                    if( var3_FTX != null ) { var3_FTX.close(); var3_FTX = null; }
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
            IEnumerator var2_F1229;
            IEnumerator var3_C849;
            IEnumerator var4_C522;
            IEnumerator var5_C850;
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
                var2_F1229 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1229", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F1229.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1229", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F1229.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F1229 != null ) { var2_F1229.close(); var2_F1229 = null; }
                var3_C849 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C849", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C849.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C849", (new seq121_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C849.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_C849 != null ) { var3_C849.close(); var3_C849 = null; }
                var4_C522 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C522", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C522.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C522", (new seq122_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C522.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_C522 != null ) { var4_C522.close(); var4_C522 = null; }
                var5_C850 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C850", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_C850.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C850", (new seq123_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C850.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_C850 != null ) { var5_C850.close(); var5_C850 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F1229 != null ) { var2_F1229.close(); var2_F1229 = null; }
                    if( var3_C849 != null ) { var3_C849.close(); var3_C849 = null; }
                    if( var4_C522 != null ) { var4_C522.close(); var4_C522 = null; }
                    if( var5_C850 != null ) { var5_C850.close(); var5_C850 = null; }
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
            IEnumerator var2_F3301;
            IEnumerator var3_F3285;
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
                var2_F3301 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3301", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F3301.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3301", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F3301.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F3301 != null ) { var2_F3301.close(); var2_F3301 = null; }
                var3_F3285 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3285", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F3285.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3285", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F3285.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F3285 != null ) { var3_F3285.close(); var3_F3285 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F3301 != null ) { var2_F3301.close(); var2_F3301 = null; }
                    if( var3_F3285 != null ) { var3_F3285.close(); var3_F3285 = null; }
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
            IEnumerator var2_F4403;
            IEnumerator var3_F4401;
            IEnumerator var4_F1131;
            IEnumerator var5_F3055;
            IEnumerator var6_F4400;
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
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4403 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4403", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4403.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4403", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4403.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4403 != null ) { var2_F4403.close(); var2_F4403 = null; }
                var3_F4401 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4401", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F4401.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4401", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F4401.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F4401 != null ) { var3_F4401.close(); var3_F4401 = null; }
                var4_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var6_F4400 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4400", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_F4400.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4400", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_F4400.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_F4400 != null ) { var6_F4400.close(); var6_F4400 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4403 != null ) { var2_F4403.close(); var2_F4403 = null; }
                    if( var3_F4401 != null ) { var3_F4401.close(); var3_F4401 = null; }
                    if( var4_F1131 != null ) { var4_F1131.close(); var4_F1131 = null; }
                    if( var5_F3055 != null ) { var5_F3055.close(); var5_F3055 = null; }
                    if( var6_F4400 != null ) { var6_F4400.close(); var6_F4400 = null; }
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
            IEnumerator var2_F4405;
            IEnumerator var3_F3036;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4405 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4405", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4405.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4405", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4405.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4405 != null ) { var2_F4405.close(); var2_F4405 = null; }
                var3_F3036 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3036", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F3036.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F3036", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F3036.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F3036 != null ) { var3_F3036.close(); var3_F3036 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4405 != null ) { var2_F4405.close(); var2_F4405 = null; }
                    if( var3_F3036 != null ) { var3_F3036.close(); var3_F3036 = null; }
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
            IEnumerator var2_LIN;
            IEnumerator var3_PIA;
            IEnumerator var4_IMD;
            IEnumerator var5_MEA;
            IEnumerator var6_QTY;
            IEnumerator var7_PCD;
            IEnumerator var8_ALI;
            IEnumerator var9_DTM;
            IEnumerator var10_GIN;
            IEnumerator var11_GIR;
            IEnumerator var12_QVR;
            IEnumerator var13_EQD;
            IEnumerator var14_FTX;
            IEnumerator var15_SG26;
            IEnumerator var16_SG27;
            IEnumerator var17_SG28;
            IEnumerator var18_SG29;
            IEnumerator var19_SG30;
            IEnumerator var20_SG32;
            IEnumerator var21_SG33;
            IEnumerator var22_SG34;
            IEnumerator var23_SG38;
            IEnumerator var24_SG44;
            IEnumerator var25_SG46;
            IEnumerator var26_SG47;
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
                        case 71:	if (moveNext_71()) return true; break;
                        case 72:	if (moveNext_72()) return true; break;
                        case 74:	if (moveNext_74()) return true; break;
                        case 75:	if (moveNext_75()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_LIN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LIN", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_LIN.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LIN", (new seq125_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_LIN.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_LIN != null ) { var2_LIN.close(); var2_LIN = null; }
                var3_PIA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PIA", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_PIA.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PIA", (new seq128_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_PIA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_PIA != null ) { var3_PIA.close(); var3_PIA = null; }
                var4_IMD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("IMD", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_IMD.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("IMD", (new seq28_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_IMD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_IMD != null ) { var4_IMD.close(); var4_IMD = null; }
                var5_MEA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MEA", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_MEA.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MEA", (new seq90_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_MEA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_MEA != null ) { var5_MEA.close(); var5_MEA = null; }
                var6_QTY = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("QTY", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_QTY.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("QTY", (new seq104_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_QTY.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_QTY != null ) { var6_QTY.close(); var6_QTY = null; }
                var7_PCD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PCD", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_PCD.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PCD", (new seq71_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_PCD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_PCD != null ) { var7_PCD.close(); var7_PCD = null; }
                var8_ALI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("ALI", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_ALI.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("ALI", (new seq27_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_ALI.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_ALI != null ) { var8_ALI.close(); var8_ALI = null; }
                var9_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_DTM.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq23_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_DTM != null ) { var9_DTM.close(); var9_DTM = null; }
                var10_GIN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("GIN", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_GIN.moveNext()) {state = 27; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("GIN", (new seq97_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_GIN.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 29;
                if( var10_GIN != null ) { var10_GIN.close(); var10_GIN = null; }
                var11_GIR = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("GIR", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 29;
                if (!var11_GIR.moveNext()) {state = 30; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("GIR", (new seq129_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_GIR.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_30() throws Exception {
                state = 32;
                if( var11_GIR != null ) { var11_GIR.close(); var11_GIR = null; }
                var12_QVR = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("QVR", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_32() throws Exception {
                state = 32;
                if (!var12_QVR.moveNext()) {state = 33; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("QVR", (new seq131_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var12_QVR.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_33() throws Exception {
                state = 35;
                if( var12_QVR != null ) { var12_QVR.close(); var12_QVR = null; }
                var13_EQD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("EQD", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_35() throws Exception {
                state = 35;
                if (!var13_EQD.moveNext()) {state = 36; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("EQD", (new seq134_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var13_EQD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_36() throws Exception {
                state = 38;
                if( var13_EQD != null ) { var13_EQD.close(); var13_EQD = null; }
                var14_FTX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FTX", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_38() throws Exception {
                state = 38;
                if (!var14_FTX.moveNext()) {state = 39; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("FTX", (new seq30_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var14_FTX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_39() throws Exception {
                state = 41;
                if( var14_FTX != null ) { var14_FTX.close(); var14_FTX = null; }
                var15_SG26 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG26", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_41() throws Exception {
                state = 41;
                if (!var15_SG26.moveNext()) {state = 42; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG26", (new seq137_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var15_SG26.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_42() throws Exception {
                state = 44;
                if( var15_SG26 != null ) { var15_SG26.close(); var15_SG26 = null; }
                var16_SG27 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG27", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_44() throws Exception {
                state = 44;
                if (!var16_SG27.moveNext()) {state = 45; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG27", (new seq138_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var16_SG27.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_45() throws Exception {
                state = 47;
                if( var16_SG27 != null ) { var16_SG27.close(); var16_SG27 = null; }
                var17_SG28 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG28", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_47() throws Exception {
                state = 47;
                if (!var17_SG28.moveNext()) {state = 48; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG28", (new seq139_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var17_SG28.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_48() throws Exception {
                state = 50;
                if( var17_SG28 != null ) { var17_SG28.close(); var17_SG28 = null; }
                var18_SG29 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG29", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_50() throws Exception {
                state = 50;
                if (!var18_SG29.moveNext()) {state = 51; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG29", (new seq33_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var18_SG29.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_51() throws Exception {
                state = 53;
                if( var18_SG29 != null ) { var18_SG29.close(); var18_SG29 = null; }
                var19_SG30 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG30", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_53() throws Exception {
                state = 53;
                if (!var19_SG30.moveNext()) {state = 54; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG30", (new seq144_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var19_SG30.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_54() throws Exception {
                state = 56;
                if( var19_SG30 != null ) { var19_SG30.close(); var19_SG30 = null; }
                var20_SG32 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG32", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_56() throws Exception {
                state = 56;
                if (!var20_SG32.moveNext()) {state = 57; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG32", (new seq145_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var20_SG32.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_57() throws Exception {
                state = 59;
                if( var20_SG32 != null ) { var20_SG32.close(); var20_SG32 = null; }
                var21_SG33 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG33", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_59() throws Exception {
                state = 59;
                if (!var21_SG33.moveNext()) {state = 60; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG33", (new seq57_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var21_SG33.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_60() throws Exception {
                state = 62;
                if( var21_SG33 != null ) { var21_SG33.close(); var21_SG33 = null; }
                var22_SG34 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG34", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_62() throws Exception {
                state = 62;
                if (!var22_SG34.moveNext()) {state = 63; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG34", (new seq146_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var22_SG34.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_63() throws Exception {
                state = 65;
                if( var22_SG34 != null ) { var22_SG34.close(); var22_SG34 = null; }
                var23_SG38 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG38", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_65() throws Exception {
                state = 65;
                if (!var23_SG38.moveNext()) {state = 66; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG38", (new seq147_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var23_SG38.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_66() throws Exception {
                state = 68;
                if( var23_SG38 != null ) { var23_SG38.close(); var23_SG38 = null; }
                var24_SG44 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG44", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_68() throws Exception {
                state = 68;
                if (!var24_SG44.moveNext()) {state = 69; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG44", (new seq148_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var24_SG44.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_69() throws Exception {
                state = 71;
                if( var24_SG44 != null ) { var24_SG44.close(); var24_SG44 = null; }
                var25_SG46 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG46", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_71() throws Exception {
                state = 71;
                if (!var25_SG46.moveNext()) {state = 72; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG46", (new seq81_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var25_SG46.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_72() throws Exception {
                state = 74;
                if( var25_SG46 != null ) { var25_SG46.close(); var25_SG46 = null; }
                var26_SG47 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG47", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_74() throws Exception {
                state = 74;
                if (!var26_SG47.moveNext()) {state = 75; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG47", (new seq114_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var26_SG47.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_75() throws Exception {
                state = 0;
                if( var26_SG47 != null ) { var26_SG47.close(); var26_SG47 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_LIN != null ) { var2_LIN.close(); var2_LIN = null; }
                    if( var3_PIA != null ) { var3_PIA.close(); var3_PIA = null; }
                    if( var4_IMD != null ) { var4_IMD.close(); var4_IMD = null; }
                    if( var5_MEA != null ) { var5_MEA.close(); var5_MEA = null; }
                    if( var6_QTY != null ) { var6_QTY.close(); var6_QTY = null; }
                    if( var7_PCD != null ) { var7_PCD.close(); var7_PCD = null; }
                    if( var8_ALI != null ) { var8_ALI.close(); var8_ALI = null; }
                    if( var9_DTM != null ) { var9_DTM.close(); var9_DTM = null; }
                    if( var10_GIN != null ) { var10_GIN.close(); var10_GIN = null; }
                    if( var11_GIR != null ) { var11_GIR.close(); var11_GIR = null; }
                    if( var12_QVR != null ) { var12_QVR.close(); var12_QVR = null; }
                    if( var13_EQD != null ) { var13_EQD.close(); var13_EQD = null; }
                    if( var14_FTX != null ) { var14_FTX.close(); var14_FTX = null; }
                    if( var15_SG26 != null ) { var15_SG26.close(); var15_SG26 = null; }
                    if( var16_SG27 != null ) { var16_SG27.close(); var16_SG27 = null; }
                    if( var17_SG28 != null ) { var17_SG28.close(); var17_SG28 = null; }
                    if( var18_SG29 != null ) { var18_SG29.close(); var18_SG29 = null; }
                    if( var19_SG30 != null ) { var19_SG30.close(); var19_SG30 = null; }
                    if( var20_SG32 != null ) { var20_SG32.close(); var20_SG32 = null; }
                    if( var21_SG33 != null ) { var21_SG33.close(); var21_SG33 = null; }
                    if( var22_SG34 != null ) { var22_SG34.close(); var22_SG34 = null; }
                    if( var23_SG38 != null ) { var23_SG38.close(); var23_SG38 = null; }
                    if( var24_SG44 != null ) { var24_SG44.close(); var24_SG44 = null; }
                    if( var25_SG46 != null ) { var25_SG46.close(); var25_SG46 = null; }
                    if( var26_SG47 != null ) { var26_SG47.close(); var26_SG47 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq125_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq125_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq125_join closure;
            IEnumerator var2_F1082;
            IEnumerator var3_F1229;
            IEnumerator var4_F1222;
            IEnumerator var5_F7083;
            IEnumerator var6_C212;
            IEnumerator var7_C829;
            public Enumerator(seq125_join closure)
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
                var2_F1082 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1082", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F1082.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1082", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F1082.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F1082 != null ) { var2_F1082.close(); var2_F1082 = null; }
                var3_F1229 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1229", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1229.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1229", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1229.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F1229 != null ) { var3_F1229.close(); var3_F1229 = null; }
                var4_F1222 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1222", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F1222.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1222", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F1222.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_F1222 != null ) { var4_F1222.close(); var4_F1222 = null; }
                var5_F7083 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7083", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F7083.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7083", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F7083.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_F7083 != null ) { var5_F7083.close(); var5_F7083 = null; }
                var6_C212 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C212", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_C212.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C212", (new seq126_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C212.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_C212 != null ) { var6_C212.close(); var6_C212 = null; }
                var7_C829 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C829", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_C829.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C829", (new seq127_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_C829.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_C829 != null ) { var7_C829.close(); var7_C829 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F1082 != null ) { var2_F1082.close(); var2_F1082 = null; }
                    if( var3_F1229 != null ) { var3_F1229.close(); var3_F1229 = null; }
                    if( var4_F1222 != null ) { var4_F1222.close(); var4_F1222 = null; }
                    if( var5_F7083 != null ) { var5_F7083.close(); var5_F7083 = null; }
                    if( var6_C212 != null ) { var6_C212.close(); var6_C212 = null; }
                    if( var7_C829 != null ) { var7_C829.close(); var7_C829 = null; }
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
            IEnumerator var2_F7140;
            IEnumerator var3_F7143;
            IEnumerator var4_F1131;
            IEnumerator var5_F3055;
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
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7140 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7140", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F7143 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7143", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_F5495;
            IEnumerator var3_F1082;
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
                var2_F5495 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5495", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F5495.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5495", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F5495.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F5495 != null ) { var2_F5495.close(); var2_F5495 = null; }
                var3_F1082 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1082", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F1082.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F1082", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1082.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F1082 != null ) { var3_F1082.close(); var3_F1082 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F5495 != null ) { var2_F5495.close(); var2_F5495 = null; }
                    if( var3_F1082 != null ) { var3_F1082.close(); var3_F1082 = null; }
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
            IEnumerator var2_F4347;
            IEnumerator var3_C212;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4347 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4347", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_C212 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C212", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C212.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C212", (new seq126_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C212.current())))));
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
            IEnumerator var2_F7297;
            IEnumerator var3_C206;
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
                var2_F7297 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7297", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F7297.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7297", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F7297.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F7297 != null ) { var2_F7297.close(); var2_F7297 = null; }
                var3_C206 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C206", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C206.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C206", (new seq130_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C206.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_C206 != null ) { var3_C206.close(); var3_C206 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7297 != null ) { var2_F7297.close(); var2_F7297 = null; }
                    if( var3_C206 != null ) { var3_C206.close(); var3_C206 = null; }
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
            IEnumerator var2_F7402;
            IEnumerator var3_F7405;
            IEnumerator var4_F4405;
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
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F7402 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7402", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                state = 5;
                if( var2_F7402 != null ) { var2_F7402.close(); var2_F7402 = null; }
                var3_F7405 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7405", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F7405.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F7405", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F7405.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_F7405 != null ) { var3_F7405.close(); var3_F7405 = null; }
                var4_F4405 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4405", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_F4405.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4405", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_F4405.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_F4405 != null ) { var4_F4405.close(); var4_F4405 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F7402 != null ) { var2_F7402.close(); var2_F7402 = null; }
                    if( var3_F7405 != null ) { var3_F7405.close(); var3_F7405 = null; }
                    if( var4_F4405 != null ) { var4_F4405.close(); var4_F4405 = null; }
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
            IEnumerator var2_F4221;
            IEnumerator var3_C279;
            IEnumerator var4_C960;
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
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4221 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4221", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4221.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4221", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4221.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4221 != null ) { var2_F4221.close(); var2_F4221 = null; }
                var3_C279 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C279", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C279.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C279", (new seq132_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C279.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_C279 != null ) { var3_C279.close(); var3_C279 = null; }
                var4_C960 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C960", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C960.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C960", (new seq133_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C960.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_C960 != null ) { var4_C960.close(); var4_C960 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4221 != null ) { var2_F4221.close(); var2_F4221 = null; }
                    if( var3_C279 != null ) { var3_C279.close(); var3_C279 = null; }
                    if( var4_C960 != null ) { var4_C960.close(); var4_C960 = null; }
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
            IEnumerator var2_F6064;
            IEnumerator var3_F6063;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6064 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6064", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F6064.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6064", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F6064.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F6064 != null ) { var2_F6064.close(); var2_F6064 = null; }
                var3_F6063 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6063", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F6063.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F6063", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F6063.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F6063 != null ) { var3_F6063.close(); var3_F6063 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F6064 != null ) { var2_F6064.close(); var2_F6064 = null; }
                    if( var3_F6063 != null ) { var3_F6063.close(); var3_F6063 = null; }
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
            IEnumerator var2_F4295;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F4294;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4295 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4295", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4295.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4295", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4295.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4295 != null ) { var2_F4295.close(); var2_F4295 = null; }
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F4294 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4294", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_F4294.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4294", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F4294.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_F4294 != null ) { var5_F4294.close(); var5_F4294 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4295 != null ) { var2_F4295.close(); var2_F4295 = null; }
                    if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
                    if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
                    if( var5_F4294 != null ) { var5_F4294.close(); var5_F4294 = null; }
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
            IEnumerator var2_F8053;
            IEnumerator var3_F8077;
            IEnumerator var4_F8249;
            IEnumerator var5_F8169;
            IEnumerator var6_C237;
            IEnumerator var7_C224;
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
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8053 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8053", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F8077 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8077", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F8249 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8249", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F8169 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8169", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var6_C237 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C237", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_C237.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C237", (new seq135_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C237.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_C237 != null ) { var6_C237.close(); var6_C237 = null; }
                var7_C224 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C224", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_C224.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C224", (new seq136_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_C224.current())))));
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
            IEnumerator var2_F8260;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F3207;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8260 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8260", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F3207 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3207", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_F8155;
            IEnumerator var3_F1131;
            IEnumerator var4_F3055;
            IEnumerator var5_F8154;
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
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F8155 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8155", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F8154 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8154", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_MOA;
            IEnumerator var3_CUX;
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
                var2_MOA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MOA", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_MOA.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MOA", (new seq62_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_MOA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_MOA != null ) { var2_MOA.close(); var2_MOA = null; }
                var3_CUX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CUX", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_CUX.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("CUX", (new seq65_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_CUX.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_CUX != null ) { var3_CUX.close(); var3_CUX = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_MOA != null ) { var2_MOA.close(); var2_MOA = null; }
                    if( var3_CUX != null ) { var3_CUX.close(); var3_CUX = null; }
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
            IEnumerator var2_PAT;
            IEnumerator var3_DTM;
            IEnumerator var4_PCD;
            IEnumerator var5_MOA;
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
                var2_PAT = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PAT", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_PAT.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PAT", (new seq68_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_PAT.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_PAT != null ) { var2_PAT.close(); var2_PAT = null; }
                var3_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_DTM.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq23_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                var4_PCD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PCD", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_PCD.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PCD", (new seq71_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_PCD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_PCD != null ) { var4_PCD.close(); var4_PCD = null; }
                var5_MOA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MOA", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_MOA.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MOA", (new seq62_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_MOA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_MOA != null ) { var5_MOA.close(); var5_MOA = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_PAT != null ) { var2_PAT.close(); var2_PAT = null; }
                    if( var3_DTM != null ) { var3_DTM.close(); var3_DTM = null; }
                    if( var4_PCD != null ) { var4_PCD.close(); var4_PCD = null; }
                    if( var5_MOA != null ) { var5_MOA.close(); var5_MOA = null; }
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
            IEnumerator var2_PRI;
            IEnumerator var3_APR;
            IEnumerator var4_RNG;
            IEnumerator var5_DTM;
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
                var2_PRI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PRI", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_PRI.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PRI", (new seq140_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_PRI.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_PRI != null ) { var2_PRI.close(); var2_PRI = null; }
                var3_APR = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("APR", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_APR.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("APR", (new seq142_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_APR.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_APR != null ) { var3_APR.close(); var3_APR = null; }
                var4_RNG = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RNG", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_RNG.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("RNG", (new seq106_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_RNG.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_RNG != null ) { var4_RNG.close(); var4_RNG = null; }
                var5_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_DTM.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq23_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_DTM != null ) { var5_DTM.close(); var5_DTM = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_PRI != null ) { var2_PRI.close(); var2_PRI = null; }
                    if( var3_APR != null ) { var3_APR.close(); var3_APR = null; }
                    if( var4_RNG != null ) { var4_RNG.close(); var4_RNG = null; }
                    if( var5_DTM != null ) { var5_DTM.close(); var5_DTM = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq140_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq140_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq140_join closure;
            IEnumerator var2_F5213;
            IEnumerator var3_C509;
            public Enumerator(seq140_join closure)
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
                var2_F5213 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5213", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_C509 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C509", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C509.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C509", (new seq141_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C509.current())))));
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
            IEnumerator var2_F5125;
            IEnumerator var3_F5118;
            IEnumerator var4_F5375;
            IEnumerator var5_F5387;
            IEnumerator var6_F5284;
            IEnumerator var7_F6411;
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
                var2_F5125 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5125", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F5118 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5118", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F5375 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5375", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var5_F5387 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5387", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var6_F5284 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5284", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var7_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
            IEnumerator var2_F4043;
            IEnumerator var3_C138;
            IEnumerator var4_C960;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F4043 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4043", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F4043.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F4043", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F4043.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F4043 != null ) { var2_F4043.close(); var2_F4043 = null; }
                var3_C138 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C138", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_C138.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C138", (new seq143_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C138.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_C138 != null ) { var3_C138.close(); var3_C138 = null; }
                var4_C960 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C960", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_C960.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C960", (new seq133_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C960.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_C960 != null ) { var4_C960.close(); var4_C960 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F4043 != null ) { var2_F4043.close(); var2_F4043 = null; }
                    if( var3_C138 != null ) { var3_C138.close(); var3_C138 = null; }
                    if( var4_C960 != null ) { var4_C960.close(); var4_C960 = null; }
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
            IEnumerator var2_F5394;
            IEnumerator var3_F5393;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F5394 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5394", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F5394.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5394", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F5394.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_F5394 != null ) { var2_F5394.close(); var2_F5394 = null; }
                var3_F5393 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5393", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_F5393.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F5393", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F5393.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_F5393 != null ) { var3_F5393.close(); var3_F5393 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F5394 != null ) { var2_F5394.close(); var2_F5394 = null; }
                    if( var3_F5393 != null ) { var3_F5393.close(); var3_F5393 = null; }
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
            IEnumerator var2_PAC;
            IEnumerator var3_MEA;
            IEnumerator var4_SG31;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_PAC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PAC", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_PAC.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("PAC", (new seq85_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_PAC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_PAC != null ) { var2_PAC.close(); var2_PAC = null; }
                var3_MEA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MEA", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_MEA.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MEA", (new seq90_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_MEA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_MEA != null ) { var3_MEA.close(); var3_MEA = null; }
                var4_SG31 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG31", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_SG31.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG31", (new seq93_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_SG31.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_SG31 != null ) { var4_SG31.close(); var4_SG31 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_PAC != null ) { var2_PAC.close(); var2_PAC = null; }
                    if( var3_MEA != null ) { var3_MEA.close(); var3_MEA = null; }
                    if( var4_SG31 != null ) { var4_SG31.close(); var4_SG31 = null; }
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
            IEnumerator var2_LOC;
            IEnumerator var3_QTY;
            IEnumerator var4_DTM;
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
                var2_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_LOC.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq42_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_LOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_LOC != null ) { var2_LOC.close(); var2_LOC = null; }
                var3_QTY = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("QTY", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_QTY.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("QTY", (new seq104_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_QTY.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_QTY != null ) { var3_QTY.close(); var3_QTY = null; }
                var4_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_DTM.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq23_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_DTM != null ) { var4_DTM.close(); var4_DTM = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_LOC != null ) { var2_LOC.close(); var2_LOC = null; }
                    if( var3_QTY != null ) { var3_QTY.close(); var3_QTY = null; }
                    if( var4_DTM != null ) { var4_DTM.close(); var4_DTM = null; }
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
            IEnumerator var2_NAD;
            IEnumerator var3_LOC;
            IEnumerator var4_SG35;
            IEnumerator var5_SG36;
            IEnumerator var6_SG37;
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
                var2_NAD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("NAD", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_NAD.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("NAD", (new seq37_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_NAD.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_NAD != null ) { var2_NAD.close(); var2_NAD = null; }
                var3_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_LOC.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq42_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_LOC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_LOC != null ) { var3_LOC.close(); var3_LOC = null; }
                var4_SG35 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG35", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_SG35.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG35", (new seq33_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_SG35.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_SG35 != null ) { var4_SG35.close(); var4_SG35 = null; }
                var5_SG36 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG36", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_SG36.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG36", (new seq49_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_SG36.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_SG36 != null ) { var5_SG36.close(); var5_SG36 = null; }
                var6_SG37 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG37", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_SG37.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG37", (new seq52_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_SG37.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_SG37 != null ) { var6_SG37.close(); var6_SG37 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_NAD != null ) { var2_NAD.close(); var2_NAD = null; }
                    if( var3_LOC != null ) { var3_LOC.close(); var3_LOC = null; }
                    if( var4_SG35 != null ) { var4_SG35.close(); var4_SG35 = null; }
                    if( var5_SG36 != null ) { var5_SG36.close(); var5_SG36 = null; }
                    if( var6_SG37 != null ) { var6_SG37.close(); var6_SG37 = null; }
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
            IEnumerator var2_ALC;
            IEnumerator var3_ALI;
            IEnumerator var4_DTM;
            IEnumerator var5_SG39;
            IEnumerator var6_SG40;
            IEnumerator var7_SG41;
            IEnumerator var8_SG42;
            IEnumerator var9_SG43;
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
                var2_ALC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("ALC", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_ALC.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("ALC", (new seq100_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_ALC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_ALC != null ) { var2_ALC.close(); var2_ALC = null; }
                var3_ALI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("ALI", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_ALI.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("ALI", (new seq27_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_ALI.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_ALI != null ) { var3_ALI.close(); var3_ALI = null; }
                var4_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_DTM.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("DTM", (new seq23_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_DTM.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_DTM != null ) { var4_DTM.close(); var4_DTM = null; }
                var5_SG39 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG39", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_SG39.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG39", (new seq103_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_SG39.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_SG39 != null ) { var5_SG39.close(); var5_SG39 = null; }
                var6_SG40 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG40", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_SG40.moveNext()) {state = 15; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG40", (new seq108_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_SG40.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_SG40 != null ) { var6_SG40.close(); var6_SG40 = null; }
                var7_SG41 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG41", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_SG41.moveNext()) {state = 18; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG41", (new seq109_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_SG41.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_SG41 != null ) { var7_SG41.close(); var7_SG41 = null; }
                var8_SG42 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG42", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_SG42.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG42", (new seq110_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_SG42.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_SG42 != null ) { var8_SG42.close(); var8_SG42 = null; }
                var9_SG43 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG43", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_SG43.moveNext()) {state = 24; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG43", (new seq113_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_SG43.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 0;
                if( var9_SG43 != null ) { var9_SG43.close(); var9_SG43 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_ALC != null ) { var2_ALC.close(); var2_ALC = null; }
                    if( var3_ALI != null ) { var3_ALI.close(); var3_ALI = null; }
                    if( var4_DTM != null ) { var4_DTM.close(); var4_DTM = null; }
                    if( var5_SG39 != null ) { var5_SG39.close(); var5_SG39 = null; }
                    if( var6_SG40 != null ) { var6_SG40.close(); var6_SG40 = null; }
                    if( var7_SG41 != null ) { var7_SG41.close(); var7_SG41 = null; }
                    if( var8_SG42 != null ) { var8_SG42.close(); var8_SG42 = null; }
                    if( var9_SG43 != null ) { var9_SG43.close(); var9_SG43 = null; }
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
            IEnumerator var2_TDT;
            IEnumerator var3_SG45;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_TDT = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TDT", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_TDT.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("TDT", (new seq74_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_TDT.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_TDT != null ) { var2_TDT.close(); var2_TDT = null; }
                var3_SG45 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG45", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_SG45.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG45", (new seq80_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_SG45.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_SG45 != null ) { var3_SG45.close(); var3_SG45 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_TDT != null ) { var2_TDT.close(); var2_TDT = null; }
                    if( var3_SG45 != null ) { var3_SG45.close(); var3_SG45 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq149_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq149_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq149_map closure;
            IEnumerator var2_F0081;
            public Enumerator(seq149_map closure)
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
                var2_F0081 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0081", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_F0081.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("F0081", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F0081.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_F0081 != null ) { var2_F0081.close(); var2_F0081 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_F0081 != null ) { var2_F0081.close(); var2_F0081 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq150_map implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq150_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq150_map closure;
            IEnumerator var2_C270;
            public Enumerator(seq150_map closure)
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
                var2_C270 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C270", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_C270.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("C270", (new seq151_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C270.current())))));
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
            IEnumerator var2_F6069;
            IEnumerator var3_F6066;
            IEnumerator var4_F6411;
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
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_F6069 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6069", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F6066 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6066", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var4_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
    static class seq152_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq152_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq152_join closure;
            IEnumerator var2_MOA;
            IEnumerator var3_SG49;
            public Enumerator(seq152_join closure)
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
                var2_MOA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MOA", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_MOA.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MOA", (new seq62_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_MOA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_MOA != null ) { var2_MOA.close(); var2_MOA = null; }
                var3_SG49 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG49", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_SG49.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("SG49", (new seq33_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_SG49.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_SG49 != null ) { var3_SG49.close(); var3_SG49 = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_MOA != null ) { var2_MOA.close(); var2_MOA = null; }
                    if( var3_SG49 != null ) { var3_SG49.close(); var3_SG49 = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq153_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq153_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq153_join closure;
            IEnumerator var2_ALC;
            IEnumerator var3_ALI;
            IEnumerator var4_MOA;
            public Enumerator(seq153_join closure)
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
                var2_ALC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("ALC", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_ALC.moveNext()) {state = 3; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("ALC", (new seq100_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_ALC.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_ALC != null ) { var2_ALC.close(); var2_ALC = null; }
                var3_ALI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("ALI", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_ALI.moveNext()) {state = 6; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("ALI", (new seq27_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_ALI.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_ALI != null ) { var3_ALI.close(); var3_ALI = null; }
                var4_MOA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MOA", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_MOA.moveNext()) {state = 9; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement("MOA", (new seq62_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_MOA.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_MOA != null ) { var4_MOA.close(); var4_MOA = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_ALC != null ) { var2_ALC.close(); var2_ALC = null; }
                    if( var3_ALI != null ) { var3_ALI.close(); var3_ALI = null; }
                    if( var4_MOA != null ) { var4_MOA.close(); var4_MOA = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq154_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq154_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq154_join closure;
            IEnumerator var2_F0074;
            IEnumerator var3_F0062;
            public Enumerator(seq154_join closure)
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
                var2_F0074 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0074", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0062 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0062", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
    static class seq155_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq155_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq155_join closure;
            IEnumerator var2_F0060;
            IEnumerator var3_F0048;
            public Enumerator(seq155_join closure)
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
                var2_F0060 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0060", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0048 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0048", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
    static class seq156_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_current;

        public seq156_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
        {
            this.var1_current = var1_current;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq156_join closure;
            IEnumerator var2_F0036;
            IEnumerator var3_F0020;
            public Enumerator(seq156_join closure)
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
                var2_F0036 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0036", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
                var3_F0020 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0020", "http://www.blujaysolutions.com/2020/INVOIC"), closure.var1_current)).enumerator();
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
        org.assimbly.edifactcommon.mapforce.IMFNode var1_INVOIC_D96A_Instance;

        public Outer(org.assimbly.edifactcommon.mapforce.IMFNode var1_INVOIC_D96A_Instance)
        {
            this.var1_INVOIC_D96A_Instance = var1_INVOIC_D96A_Instance;
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
                var2_map = ((new main(closure.var1_INVOIC_D96A_Instance))).enumerator();
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
    protected org.w3c.dom.Node varINVOIC_D96A2Instance;

    public void run(String INVOIC_D96A2SourceFilename, String INVOICTargetFilename) throws Exception {
        // open source streams
        writeTrace("Loading " + INVOIC_D96A2SourceFilename + "...\n");
        org.assimbly.edifactcommon.io.FileInput INVOIC_D96A2Source = new org.assimbly.edifactcommon.io.FileInput(INVOIC_D96A2SourceFilename);
        // open target stream
        org.assimbly.edifactcommon.io.FileOutput INVOICTarget = new org.assimbly.edifactcommon.io.FileOutput(INVOICTargetFilename);

        // run

        run(INVOIC_D96A2Source, INVOICTarget);

        // close source streams
        INVOIC_D96A2Source.close();
        // close target stream
        writeTrace("Saving " + INVOICTargetFilename + "...\n");
        INVOICTarget.close();
    }


    // main entry point

    public void run(org.assimbly.edifactcommon.io.Input INVOIC_D96A2Source, org.assimbly.edifactcommon.io.Output INVOICTarget) throws Exception {
        // Open the source(s)
        org.w3c.dom.Document doc_INVOIC_D96A2 = XmlTreeOperations.loadDocument(INVOIC_D96A2Source);
        varINVOIC_D96A2Instance = doc_INVOIC_D96A2;
        if (runDoesCloseAll)
            INVOIC_D96A2Source.close();

        // Create the target
        INVOICD96AEnvelope envelope = new INVOICD96AEnvelope();
        org.assimbly.edifactcommon.text.ITextNode INVOICTargetObject = envelope.getGenerator();

        // Execute mapping

        main mapping = new main(new org.assimbly.edifactcommon.xml.DOMDocumentAsMFNodeAdapter(varINVOIC_D96A2Instance, INVOIC_D96A2Source.getFilename()));

        org.assimbly.edifactcommon.text.MFTextWriter.write(mapping, INVOICTargetObject);
        // Close the target
        envelope.setEncoding( "UTF-8", false, false );
        envelope.save(INVOICTarget);


        if (runDoesCloseAll)
        {
            INVOIC_D96A2Source.close();
            INVOICTarget.close();
        }
    }



}
