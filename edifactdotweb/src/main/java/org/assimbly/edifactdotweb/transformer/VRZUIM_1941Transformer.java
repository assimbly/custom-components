package org.assimbly.edifactdotweb.transformer;

import org.assimbly.edifactcommon.mapforce.*;
import org.assimbly.edifactcommon.xml.*;
import org.assimbly.edifactdotweb.envelope.VRZUIM_1941Envelope;

public class VRZUIM_1941Transformer extends org.assimbly.edifactcommon.TraceProvider
{
    private boolean runDoesCloseAll = true;
    public void setCloseObjectsAfterRun(boolean c) {runDoesCloseAll = c;}
    public boolean getCloseObjectsAfterRun() {return runDoesCloseAll;}


    static class main implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_VRZUIM_Instance;

        public main(org.assimbly.edifactcommon.mapforce.IMFNode var1_VRZUIM_Instance)
        {
            this.var1_VRZUIM_Instance = var1_VRZUIM_Instance;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 2;
            Object current;
            main closure;
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
                    }
                }
                return false;
            }

            private boolean moveNext_2() throws Exception {
                state = 0;
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("edifactmessages", ""), (new seq1_join(closure.var1_VRZUIM_Instance)));
                pos++;
                return true;
            }


            public void close()
            {
                try
                {
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq1_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_VRZUIM_Instance;

        public seq1_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_VRZUIM_Instance)
        {
            this.var1_VRZUIM_Instance = var1_VRZUIM_Instance;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq1_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            public Enumerator(seq1_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
                while (state != 0)
                {
                    switch (state)
                    {
                        case 1:	if (moveNext_1()) return true; break;
                        case 2:	if (moveNext_2()) return true; break;
                        case 3:	if (moveNext_3()) return true; break;
                        case 4:	if (moveNext_4()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 7:	if (moveNext_7()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                current = org.assimbly.edifactcommon.functions.Core.createAttribute(org.assimbly.edifactcommon.functions.Core.createQName("xsi:noNamespaceSchemaLocation", "http://www.w3.org/2001/XMLSchema-instance"), org.assimbly.edifactcommon.functions.Core.box("file:///C:/Users/Bart/Documents/dw/raet/Medewerker.xsd"));
                pos++;
                return true;
            }
            private boolean moveNext_2() throws Exception {
                state = 3;
                var2_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("Interchange", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("Envelope", closure.var1_VRZUIM_Instance)))).enumerator();
                return false;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if (!var2_filter_elements_nodename.moveNext()) {state = 4; return false; }
                var3_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("UNB", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_4() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 7;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                var4_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F0007", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("S002", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_6() throws Exception {
                state = 3;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("messages", ""), (new seq2_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_7() throws Exception {
                state = 7;
                if (!var4_filter_elements_nodename.moveNext()) {state = 8; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("raetSystemName", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_8() throws Exception {
                state = 5;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq2_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_cur;

        public seq2_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq2_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            org.assimbly.edifactcommon.mapforce.IEnumerable var4_filter_elements_nodename;
            org.assimbly.edifactcommon.mapforce.IEnumerable var5_filter_elements_nodename;
            org.assimbly.edifactcommon.mapforce.IEnumerable var6_filter_elements_nodename;
            org.assimbly.edifactcommon.mapforce.IEnumerable var7_filter_elements_nodename;
            org.assimbly.edifactcommon.mapforce.IEnumerable var8_filter_elements_nodename;
            org.assimbly.edifactcommon.mapforce.IEnumerable var9_filter_elements_nodename;
            org.assimbly.edifactcommon.mapforce.IEnumerable var10_filter_elements_nodename;
            org.assimbly.edifactcommon.mapforce.IEnumerable var11_filter_elements_nodename;
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
                        case 4:	if (moveNext_4()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("Group", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 4;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                var3_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("Message_VRZUIM", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_4() throws Exception {
                state = 4;
                if (!var3_filter_elements_nodename.moveNext()) {state = 5; return false; }
                var4_filter_elements_nodename = new org.assimbly.edifactcommon.functions.Core.SequenceCache(org.assimbly.edifactcommon.functions.Core.filterElements("NADWG", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_filter_elements_nodename.current()))));
                var5_filter_elements_nodename = new org.assimbly.edifactcommon.functions.Core.SequenceCache(org.assimbly.edifactcommon.functions.Core.filterElements("CTA", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_filter_elements_nodename.current()))));
                var6_filter_elements_nodename = new org.assimbly.edifactcommon.functions.Core.SequenceCache(org.assimbly.edifactcommon.functions.Core.filterElements("ADR02", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_filter_elements_nodename.current()))));
                var7_filter_elements_nodename = new org.assimbly.edifactcommon.functions.Core.SequenceCache(org.assimbly.edifactcommon.functions.Core.filterElements("NADMR", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_filter_elements_nodename.current()))));
                var8_filter_elements_nodename = new org.assimbly.edifactcommon.functions.Core.SequenceCache(org.assimbly.edifactcommon.functions.Core.filterElements("PNA02", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_filter_elements_nodename.current()))));
                var9_filter_elements_nodename = new org.assimbly.edifactcommon.functions.Core.SequenceCache(org.assimbly.edifactcommon.functions.Core.filterElements("PNA01", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_filter_elements_nodename.current()))));
                var10_filter_elements_nodename = new org.assimbly.edifactcommon.functions.Core.SequenceCache(org.assimbly.edifactcommon.functions.Core.filterElements("ADR01", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_filter_elements_nodename.current()))));
                var11_filter_elements_nodename = new org.assimbly.edifactcommon.functions.Core.SequenceCache(org.assimbly.edifactcommon.functions.Core.filterElements("NADFR", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_filter_elements_nodename.current()))));
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("message", ""), (new seq3_join(var8_filter_elements_nodename, var11_filter_elements_nodename, var10_filter_elements_nodename, var4_filter_elements_nodename, var5_filter_elements_nodename, ((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_filter_elements_nodename.current())), var6_filter_elements_nodename, var9_filter_elements_nodename, var7_filter_elements_nodename)));
                pos++;
                return true;
            }
            private boolean moveNext_5() throws Exception {
                state = 2;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq3_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IEnumerable var1_filter_elements_nodename;
        org.assimbly.edifactcommon.mapforce.IEnumerable var2_filter_elements_nodename;
        org.assimbly.edifactcommon.mapforce.IEnumerable var3_filter_elements_nodename;
        org.assimbly.edifactcommon.mapforce.IEnumerable var4_filter_elements_nodename;
        org.assimbly.edifactcommon.mapforce.IEnumerable var5_filter_elements_nodename;
        org.assimbly.edifactcommon.mapforce.IMFNode var6_cur;
        org.assimbly.edifactcommon.mapforce.IEnumerable var7_filter_elements_nodename;
        org.assimbly.edifactcommon.mapforce.IEnumerable var8_filter_elements_nodename;
        org.assimbly.edifactcommon.mapforce.IEnumerable var9_filter_elements_nodename;

        public seq3_join(org.assimbly.edifactcommon.mapforce.IEnumerable var1_filter_elements_nodename, org.assimbly.edifactcommon.mapforce.IEnumerable var2_filter_elements_nodename, org.assimbly.edifactcommon.mapforce.IEnumerable var3_filter_elements_nodename, org.assimbly.edifactcommon.mapforce.IEnumerable var4_filter_elements_nodename, org.assimbly.edifactcommon.mapforce.IEnumerable var5_filter_elements_nodename, org.assimbly.edifactcommon.mapforce.IMFNode var6_cur, org.assimbly.edifactcommon.mapforce.IEnumerable var7_filter_elements_nodename, org.assimbly.edifactcommon.mapforce.IEnumerable var8_filter_elements_nodename, org.assimbly.edifactcommon.mapforce.IEnumerable var9_filter_elements_nodename)
        {
            this.var1_filter_elements_nodename = var1_filter_elements_nodename;
            this.var2_filter_elements_nodename = var2_filter_elements_nodename;
            this.var3_filter_elements_nodename = var3_filter_elements_nodename;
            this.var4_filter_elements_nodename = var4_filter_elements_nodename;
            this.var5_filter_elements_nodename = var5_filter_elements_nodename;
            this.var6_cur = var6_cur;
            this.var7_filter_elements_nodename = var7_filter_elements_nodename;
            this.var8_filter_elements_nodename = var8_filter_elements_nodename;
            this.var9_filter_elements_nodename = var9_filter_elements_nodename;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq3_join closure;
            IEnumerator var10_filter_elements_nodename;
            IEnumerator var11_filter_elements_nodename;
            IEnumerator var12_filter_elements_nodename;
            IEnumerator var13_filter_elements_nodename;
            IEnumerator var14_filter_elements_nodename;
            IEnumerator var15_filter_elements_nodename;
            IEnumerator var16_filter_elements_nodename;
            IEnumerator var17_filter_elements_nodename;
            IEnumerator var18_filter_elements_nodename;
            IEnumerator var19_filter_elements_nodename;
            IEnumerator var20_filter_elements_nodename;
            IEnumerator var21_filter_elements_nodename;
            IEnumerator var22_filter_elements_nodename;
            IEnumerator var23_filter_elements_nodename;
            IEnumerator var24_filter_elements_nodename;
            IEnumerator var25_filter_elements_nodename;
            IEnumerator var26_filter_elements_nodename;
            IEnumerator var27_filter_elements_nodename;
            IEnumerator var28_filter_elements_nodename;
            IEnumerator var29_filter_elements_nodename;
            IEnumerator var30_filter_elements_nodename;
            IEnumerator var31_filter_elements_nodename;
            IEnumerator var33_filter_elements_nodename;
            IEnumerator var32_filter_elements_nodename;
            IEnumerator var34_filter_elements_nodename;
            IEnumerator var36_filter_elements_nodename;
            IEnumerator var35_filter_elements_nodename;
            IEnumerator var37_filter_elements_nodename;
            IEnumerator var38_filter_elements_nodename;
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
                        case 4:	if (moveNext_4()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 7:	if (moveNext_7()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 10:	if (moveNext_10()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 16:	if (moveNext_16()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 19:	if (moveNext_19()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 25:	if (moveNext_25()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 28:	if (moveNext_28()) return true; break;
                        case 29:	if (moveNext_29()) return true; break;
                        case 30:	if (moveNext_30()) return true; break;
                        case 31:	if (moveNext_31()) return true; break;
                        case 33:	if (moveNext_33()) return true; break;
                        case 34:	if (moveNext_34()) return true; break;
                        case 35:	if (moveNext_35()) return true; break;
                        case 37:	if (moveNext_37()) return true; break;
                        case 38:	if (moveNext_38()) return true; break;
                        case 39:	if (moveNext_39()) return true; break;
                        case 40:	if (moveNext_40()) return true; break;
                        case 42:	if (moveNext_42()) return true; break;
                        case 43:	if (moveNext_43()) return true; break;
                        case 44:	if (moveNext_44()) return true; break;
                        case 45:	if (moveNext_45()) return true; break;
                        case 47:	if (moveNext_47()) return true; break;
                        case 48:	if (moveNext_48()) return true; break;
                        case 49:	if (moveNext_49()) return true; break;
                        case 50:	if (moveNext_50()) return true; break;
                        case 52:	if (moveNext_52()) return true; break;
                        case 53:	if (moveNext_53()) return true; break;
                        case 54:	if (moveNext_54()) return true; break;
                        case 55:	if (moveNext_55()) return true; break;
                        case 57:	if (moveNext_57()) return true; break;
                        case 58:	if (moveNext_58()) return true; break;
                        case 59:	if (moveNext_59()) return true; break;
                        case 60:	if (moveNext_60()) return true; break;
                        case 62:	if (moveNext_62()) return true; break;
                        case 63:	if (moveNext_63()) return true; break;
                        case 64:	if (moveNext_64()) return true; break;
                        case 65:	if (moveNext_65()) return true; break;
                        case 66:	if (moveNext_66()) return true; break;
                        case 67:	if (moveNext_67()) return true; break;
                        case 69:	if (moveNext_69()) return true; break;
                        case 70:	if (moveNext_70()) return true; break;
                        case 71:	if (moveNext_71()) return true; break;
                        case 72:	if (moveNext_72()) return true; break;
                        case 73:	if (moveNext_73()) return true; break;
                        case 74:	if (moveNext_74()) return true; break;
                        case 76:	if (moveNext_76()) return true; break;
                        case 77:	if (moveNext_77()) return true; break;
                        case 78:	if (moveNext_78()) return true; break;
                        case 79:	if (moveNext_79()) return true; break;
                        case 80:	if (moveNext_80()) return true; break;
                        case 81:	if (moveNext_81()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("messageID", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString((org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("F0062", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("UNH", closure.var6_cur)))))));
                pos++;
                return true;
            }
            private boolean moveNext_2() throws Exception {
                state = 3;
                var10_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F1225", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("BGM", closure.var6_cur)))).enumerator();
                return false;
            }
            private boolean moveNext_3() throws Exception {
                state = 3;
                if (!var10_filter_elements_nodename.moveNext()) {state = 4; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("mutationType", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_4() throws Exception {
                state = 6;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("nadMR", ""), (new seq4_join(closure.var9_filter_elements_nodename)));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 7;
                var11_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("COM01", closure.var6_cur)).enumerator();
                return false;
            }
            private boolean moveNext_7() throws Exception {
                state = 7;
                if (!var11_filter_elements_nodename.moveNext()) {state = 8; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("phoneMR", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString((org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("F3148", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("C076", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("COM", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_filter_elements_nodename.current())))))))))));
                pos++;
                return true;
            }
            private boolean moveNext_8() throws Exception {
                state = 10;
                if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("nadFR", ""), (new seq5_join(closure.var2_filter_elements_nodename)));
                pos++;
                return true;
            }
            private boolean moveNext_10() throws Exception {
                state = 11;
                var12_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("COM03", closure.var6_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var12_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("phoneFR", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString((org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("F3148", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("C076", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("COM", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var12_filter_elements_nodename.current())))))))))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("nadWG", ""), (new seq6_join(closure.var4_filter_elements_nodename)));
                pos++;
                return true;
            }
            private boolean moveNext_14() throws Exception {
                state = 15;
                var13_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("COM05", closure.var6_cur)).enumerator();
                return false;
            }
            private boolean moveNext_15() throws Exception {
                state = 15;
                if (!var13_filter_elements_nodename.moveNext()) {state = 16; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("phoneWG", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString((org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("F3148", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("C076", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("COM", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var13_filter_elements_nodename.current())))))))))));
                pos++;
                return true;
            }
            private boolean moveNext_16() throws Exception {
                state = 18;
                if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                var14_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("RFF01", closure.var6_cur)).enumerator();
                return false;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if (!var14_filter_elements_nodename.moveNext()) {state = 19; return false; }
                var15_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F1154", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("C506", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("RFF", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var14_filter_elements_nodename.current())))))))).enumerator();
                return false;
            }
            private boolean moveNext_19() throws Exception {
                state = 23;
                if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                var16_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("RFF02", closure.var6_cur)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var15_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("wgbo", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var15_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 18;
                if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 25;
                if (!var16_filter_elements_nodename.moveNext()) {state = 24; return false; }
                var17_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F1154", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("C506", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("RFF", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var16_filter_elements_nodename.current())))))))).enumerator();
                return false;
            }
            private boolean moveNext_24() throws Exception {
                state = 28;
                if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                var18_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("RFF03", closure.var6_cur)).enumerator();
                return false;
            }
            private boolean moveNext_25() throws Exception {
                state = 25;
                if (!var17_filter_elements_nodename.moveNext()) {state = 26; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("sbi", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var17_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_26() throws Exception {
                state = 23;
                if( var17_filter_elements_nodename != null ) { var17_filter_elements_nodename.close(); var17_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_28() throws Exception {
                state = 30;
                if (!var18_filter_elements_nodename.moveNext()) {state = 29; return false; }
                var19_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F1154", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("C506", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("RFF", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var18_filter_elements_nodename.current())))))))).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 33;
                if( var18_filter_elements_nodename != null ) { var18_filter_elements_nodename.close(); var18_filter_elements_nodename = null; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("employee", ""), (new seq7_join(closure.var1_filter_elements_nodename, closure.var6_cur, closure.var8_filter_elements_nodename)));
                pos++;
                return true;
            }
            private boolean moveNext_30() throws Exception {
                state = 30;
                if (!var19_filter_elements_nodename.moveNext()) {state = 31; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("uwvNumber", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var19_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_31() throws Exception {
                state = 28;
                if( var19_filter_elements_nodename != null ) { var19_filter_elements_nodename.close(); var19_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_33() throws Exception {
                state = 34;
                var20_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("COM07", closure.var6_cur)).enumerator();
                return false;
            }
            private boolean moveNext_34() throws Exception {
                state = 34;
                if (!var20_filter_elements_nodename.moveNext()) {state = 35; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("phoneEMP", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString((org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("F3148", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("C076", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("COM", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var20_filter_elements_nodename.current())))))))))));
                pos++;
                return true;
            }
            private boolean moveNext_35() throws Exception {
                state = 37;
                if( var20_filter_elements_nodename != null ) { var20_filter_elements_nodename.close(); var20_filter_elements_nodename = null; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("address", ""), (new seq8_join(closure.var3_filter_elements_nodename)));
                pos++;
                return true;
            }
            private boolean moveNext_37() throws Exception {
                state = 38;
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("addressIllness", ""), (new seq9_join(closure.var7_filter_elements_nodename)));
                pos++;
                return true;
            }
            private boolean moveNext_38() throws Exception {
                state = 39;
                var21_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("COM09", closure.var6_cur)).enumerator();
                return false;
            }
            private boolean moveNext_39() throws Exception {
                state = 39;
                if (!var21_filter_elements_nodename.moveNext()) {state = 40; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("phoneIllness", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString((org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("F3148", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("C076", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("COM", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var21_filter_elements_nodename.current())))))))))));
                pos++;
                return true;
            }
            private boolean moveNext_40() throws Exception {
                state = 42;
                if( var21_filter_elements_nodename != null ) { var21_filter_elements_nodename.close(); var21_filter_elements_nodename = null; }
                var22_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("DTM05", closure.var6_cur)).enumerator();
                return false;
            }
            private boolean moveNext_42() throws Exception {
                state = 44;
                if (!var22_filter_elements_nodename.moveNext()) {state = 43; return false; }
                var23_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F2380", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("C507", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("DTM", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var22_filter_elements_nodename.current())))))))).enumerator();
                return false;
            }
            private boolean moveNext_43() throws Exception {
                state = 47;
                if( var22_filter_elements_nodename != null ) { var22_filter_elements_nodename.close(); var22_filter_elements_nodename = null; }
                var24_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("DTM06", closure.var6_cur)).enumerator();
                return false;
            }
            private boolean moveNext_44() throws Exception {
                state = 44;
                if (!var23_filter_elements_nodename.moveNext()) {state = 45; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("illnessStartDate", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var23_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_45() throws Exception {
                state = 42;
                if( var23_filter_elements_nodename != null ) { var23_filter_elements_nodename.close(); var23_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_47() throws Exception {
                state = 49;
                if (!var24_filter_elements_nodename.moveNext()) {state = 48; return false; }
                var25_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F2380", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("C507", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("DTM", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var24_filter_elements_nodename.current())))))))).enumerator();
                return false;
            }
            private boolean moveNext_48() throws Exception {
                state = 52;
                if( var24_filter_elements_nodename != null ) { var24_filter_elements_nodename.close(); var24_filter_elements_nodename = null; }
                var26_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("PCD02", closure.var6_cur)).enumerator();
                return false;
            }
            private boolean moveNext_49() throws Exception {
                state = 49;
                if (!var25_filter_elements_nodename.moveNext()) {state = 50; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("illnessMutationDate", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var25_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_50() throws Exception {
                state = 47;
                if( var25_filter_elements_nodename != null ) { var25_filter_elements_nodename.close(); var25_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_52() throws Exception {
                state = 54;
                if (!var26_filter_elements_nodename.moveNext()) {state = 53; return false; }
                var27_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F5482", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("C501", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("PCD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var26_filter_elements_nodename.current())))))))).enumerator();
                return false;
            }
            private boolean moveNext_53() throws Exception {
                state = 57;
                if( var26_filter_elements_nodename != null ) { var26_filter_elements_nodename.close(); var26_filter_elements_nodename = null; }
                var28_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("RFF04", closure.var6_cur)).enumerator();
                return false;
            }
            private boolean moveNext_54() throws Exception {
                state = 54;
                if (!var27_filter_elements_nodename.moveNext()) {state = 55; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("illnessPerc", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var27_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_55() throws Exception {
                state = 52;
                if( var27_filter_elements_nodename != null ) { var27_filter_elements_nodename.close(); var27_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_57() throws Exception {
                state = 59;
                if (!var28_filter_elements_nodename.moveNext()) {state = 58; return false; }
                var29_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F1154", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("C506", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("RFF", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var28_filter_elements_nodename.current())))))))).enumerator();
                return false;
            }
            private boolean moveNext_58() throws Exception {
                state = 62;
                if( var28_filter_elements_nodename != null ) { var28_filter_elements_nodename.close(); var28_filter_elements_nodename = null; }
                var30_filter_elements_nodename = (closure.var5_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_59() throws Exception {
                state = 59;
                if (!var29_filter_elements_nodename.moveNext()) {state = 60; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("illnessCode", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var29_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_60() throws Exception {
                state = 57;
                if( var29_filter_elements_nodename != null ) { var29_filter_elements_nodename.close(); var29_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_62() throws Exception {
                state = 64;
                if (!var30_filter_elements_nodename.moveNext()) {state = 63; return false; }
                var31_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C056", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var30_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_63() throws Exception {
                state = 69;
                if( var30_filter_elements_nodename != null ) { var30_filter_elements_nodename.close(); var30_filter_elements_nodename = null; }
                var33_filter_elements_nodename = (closure.var5_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_64() throws Exception {
                state = 66;
                if (!var31_filter_elements_nodename.moveNext()) {state = 65; return false; }
                var32_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3413", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var31_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_65() throws Exception {
                state = 62;
                if( var31_filter_elements_nodename != null ) { var31_filter_elements_nodename.close(); var31_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_66() throws Exception {
                state = 66;
                if (!var32_filter_elements_nodename.moveNext()) {state = 67; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("ouCode", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var32_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_67() throws Exception {
                state = 64;
                if( var32_filter_elements_nodename != null ) { var32_filter_elements_nodename.close(); var32_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_69() throws Exception {
                state = 71;
                if (!var33_filter_elements_nodename.moveNext()) {state = 70; return false; }
                var34_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C056", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var33_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_70() throws Exception {
                state = 76;
                if( var33_filter_elements_nodename != null ) { var33_filter_elements_nodename.close(); var33_filter_elements_nodename = null; }
                var36_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("FTX", closure.var6_cur)).enumerator();
                return false;
            }
            private boolean moveNext_71() throws Exception {
                state = 73;
                if (!var34_filter_elements_nodename.moveNext()) {state = 72; return false; }
                var35_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3412", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var34_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_72() throws Exception {
                state = 69;
                if( var34_filter_elements_nodename != null ) { var34_filter_elements_nodename.close(); var34_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_73() throws Exception {
                state = 73;
                if (!var35_filter_elements_nodename.moveNext()) {state = 74; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("ouName", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var35_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_74() throws Exception {
                state = 71;
                if( var35_filter_elements_nodename != null ) { var35_filter_elements_nodename.close(); var35_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_76() throws Exception {
                state = 78;
                if (!var36_filter_elements_nodename.moveNext()) {state = 77; return false; }
                var37_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C108", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var36_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_77() throws Exception {
                state = 0;
                if( var36_filter_elements_nodename != null ) { var36_filter_elements_nodename.close(); var36_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_78() throws Exception {
                state = 80;
                if (!var37_filter_elements_nodename.moveNext()) {state = 79; return false; }
                var38_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F4440", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var37_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_79() throws Exception {
                state = 76;
                if( var37_filter_elements_nodename != null ) { var37_filter_elements_nodename.close(); var37_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_80() throws Exception {
                state = 80;
                if (!var38_filter_elements_nodename.moveNext()) {state = 81; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("illnessRemark", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var38_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_81() throws Exception {
                state = 78;
                if( var38_filter_elements_nodename != null ) { var38_filter_elements_nodename.close(); var38_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                    if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                    if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                    if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                    if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                    if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                    if( var17_filter_elements_nodename != null ) { var17_filter_elements_nodename.close(); var17_filter_elements_nodename = null; }
                    if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                    if( var19_filter_elements_nodename != null ) { var19_filter_elements_nodename.close(); var19_filter_elements_nodename = null; }
                    if( var18_filter_elements_nodename != null ) { var18_filter_elements_nodename.close(); var18_filter_elements_nodename = null; }
                    if( var20_filter_elements_nodename != null ) { var20_filter_elements_nodename.close(); var20_filter_elements_nodename = null; }
                    if( var21_filter_elements_nodename != null ) { var21_filter_elements_nodename.close(); var21_filter_elements_nodename = null; }
                    if( var23_filter_elements_nodename != null ) { var23_filter_elements_nodename.close(); var23_filter_elements_nodename = null; }
                    if( var22_filter_elements_nodename != null ) { var22_filter_elements_nodename.close(); var22_filter_elements_nodename = null; }
                    if( var25_filter_elements_nodename != null ) { var25_filter_elements_nodename.close(); var25_filter_elements_nodename = null; }
                    if( var24_filter_elements_nodename != null ) { var24_filter_elements_nodename.close(); var24_filter_elements_nodename = null; }
                    if( var27_filter_elements_nodename != null ) { var27_filter_elements_nodename.close(); var27_filter_elements_nodename = null; }
                    if( var26_filter_elements_nodename != null ) { var26_filter_elements_nodename.close(); var26_filter_elements_nodename = null; }
                    if( var29_filter_elements_nodename != null ) { var29_filter_elements_nodename.close(); var29_filter_elements_nodename = null; }
                    if( var28_filter_elements_nodename != null ) { var28_filter_elements_nodename.close(); var28_filter_elements_nodename = null; }
                    if( var32_filter_elements_nodename != null ) { var32_filter_elements_nodename.close(); var32_filter_elements_nodename = null; }
                    if( var31_filter_elements_nodename != null ) { var31_filter_elements_nodename.close(); var31_filter_elements_nodename = null; }
                    if( var30_filter_elements_nodename != null ) { var30_filter_elements_nodename.close(); var30_filter_elements_nodename = null; }
                    if( var35_filter_elements_nodename != null ) { var35_filter_elements_nodename.close(); var35_filter_elements_nodename = null; }
                    if( var34_filter_elements_nodename != null ) { var34_filter_elements_nodename.close(); var34_filter_elements_nodename = null; }
                    if( var33_filter_elements_nodename != null ) { var33_filter_elements_nodename.close(); var33_filter_elements_nodename = null; }
                    if( var38_filter_elements_nodename != null ) { var38_filter_elements_nodename.close(); var38_filter_elements_nodename = null; }
                    if( var37_filter_elements_nodename != null ) { var37_filter_elements_nodename.close(); var37_filter_elements_nodename = null; }
                    if( var36_filter_elements_nodename != null ) { var36_filter_elements_nodename.close(); var36_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq4_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IEnumerable var1_filter_elements_nodename;

        public seq4_join(org.assimbly.edifactcommon.mapforce.IEnumerable var1_filter_elements_nodename)
        {
            this.var1_filter_elements_nodename = var1_filter_elements_nodename;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq4_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
            IEnumerator var11_filter_elements_nodename;
            IEnumerator var10_filter_elements_nodename;
            IEnumerator var12_filter_elements_nodename;
            IEnumerator var14_filter_elements_nodename;
            IEnumerator var13_filter_elements_nodename;
            IEnumerator var15_filter_elements_nodename;
            IEnumerator var16_filter_elements_nodename;
            IEnumerator var17_filter_elements_nodename;
            IEnumerator var18_filter_elements_nodename;
            IEnumerator var19_filter_elements_nodename;
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
                        case 4:	if (moveNext_4()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 7:	if (moveNext_7()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 10:	if (moveNext_10()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 13:	if (moveNext_13()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 16:	if (moveNext_16()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 19:	if (moveNext_19()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 25:	if (moveNext_25()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 27:	if (moveNext_27()) return true; break;
                        case 28:	if (moveNext_28()) return true; break;
                        case 30:	if (moveNext_30()) return true; break;
                        case 31:	if (moveNext_31()) return true; break;
                        case 32:	if (moveNext_32()) return true; break;
                        case 33:	if (moveNext_33()) return true; break;
                        case 35:	if (moveNext_35()) return true; break;
                        case 36:	if (moveNext_36()) return true; break;
                        case 37:	if (moveNext_37()) return true; break;
                        case 38:	if (moveNext_38()) return true; break;
                        case 40:	if (moveNext_40()) return true; break;
                        case 41:	if (moveNext_41()) return true; break;
                        case 42:	if (moveNext_42()) return true; break;
                        case 43:	if (moveNext_43()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 4;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                var3_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C058", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_3() throws Exception {
                state = 9;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_4() throws Exception {
                state = 6;
                if (!var3_filter_elements_nodename.moveNext()) {state = 5; return false; }
                var4_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3124", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 2;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_6() throws Exception {
                state = 6;
                if (!var4_filter_elements_nodename.moveNext()) {state = 7; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("name", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_7() throws Exception {
                state = 4;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 10; return false; }
                var6_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C059", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_10() throws Exception {
                state = 16;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 13;
                if (!var6_filter_elements_nodename.moveNext()) {state = 12; return false; }
                var7_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3042_1", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_12() throws Exception {
                state = 9;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_13() throws Exception {
                state = 13;
                if (!var7_filter_elements_nodename.moveNext()) {state = 14; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("street", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_14() throws Exception {
                state = 11;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_16() throws Exception {
                state = 18;
                if (!var8_filter_elements_nodename.moveNext()) {state = 17; return false; }
                var9_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C059", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 23;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                var11_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if (!var9_filter_elements_nodename.moveNext()) {state = 19; return false; }
                var10_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3042_2", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_19() throws Exception {
                state = 16;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var10_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("streetNumber", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 18;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 25;
                if (!var11_filter_elements_nodename.moveNext()) {state = 24; return false; }
                var12_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C059", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_24() throws Exception {
                state = 30;
                if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                var14_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_25() throws Exception {
                state = 27;
                if (!var12_filter_elements_nodename.moveNext()) {state = 26; return false; }
                var13_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3042_3", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var12_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 23;
                if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_27() throws Exception {
                state = 27;
                if (!var13_filter_elements_nodename.moveNext()) {state = 28; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("streetNumberAdd", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var13_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_28() throws Exception {
                state = 25;
                if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_30() throws Exception {
                state = 32;
                if (!var14_filter_elements_nodename.moveNext()) {state = 31; return false; }
                var15_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3164", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var14_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_31() throws Exception {
                state = 35;
                if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                var16_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_32() throws Exception {
                state = 32;
                if (!var15_filter_elements_nodename.moveNext()) {state = 33; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("place", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var15_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_33() throws Exception {
                state = 30;
                if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_35() throws Exception {
                state = 37;
                if (!var16_filter_elements_nodename.moveNext()) {state = 36; return false; }
                var17_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3251", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var16_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_36() throws Exception {
                state = 40;
                if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                var18_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_37() throws Exception {
                state = 37;
                if (!var17_filter_elements_nodename.moveNext()) {state = 38; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("postalCode", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var17_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_38() throws Exception {
                state = 35;
                if( var17_filter_elements_nodename != null ) { var17_filter_elements_nodename.close(); var17_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_40() throws Exception {
                state = 42;
                if (!var18_filter_elements_nodename.moveNext()) {state = 41; return false; }
                var19_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3207", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var18_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_41() throws Exception {
                state = 0;
                if( var18_filter_elements_nodename != null ) { var18_filter_elements_nodename.close(); var18_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_42() throws Exception {
                state = 42;
                if (!var19_filter_elements_nodename.moveNext()) {state = 43; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("countryCode", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var19_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_43() throws Exception {
                state = 40;
                if( var19_filter_elements_nodename != null ) { var19_filter_elements_nodename.close(); var19_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                    if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                    if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                    if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                    if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                    if( var17_filter_elements_nodename != null ) { var17_filter_elements_nodename.close(); var17_filter_elements_nodename = null; }
                    if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                    if( var19_filter_elements_nodename != null ) { var19_filter_elements_nodename.close(); var19_filter_elements_nodename = null; }
                    if( var18_filter_elements_nodename != null ) { var18_filter_elements_nodename.close(); var18_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq5_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IEnumerable var1_filter_elements_nodename;

        public seq5_join(org.assimbly.edifactcommon.mapforce.IEnumerable var1_filter_elements_nodename)
        {
            this.var1_filter_elements_nodename = var1_filter_elements_nodename;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq5_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
            IEnumerator var11_filter_elements_nodename;
            IEnumerator var10_filter_elements_nodename;
            IEnumerator var12_filter_elements_nodename;
            IEnumerator var14_filter_elements_nodename;
            IEnumerator var13_filter_elements_nodename;
            IEnumerator var15_filter_elements_nodename;
            IEnumerator var16_filter_elements_nodename;
            IEnumerator var17_filter_elements_nodename;
            IEnumerator var18_filter_elements_nodename;
            IEnumerator var19_filter_elements_nodename;
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
                        case 4:	if (moveNext_4()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 7:	if (moveNext_7()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 10:	if (moveNext_10()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 13:	if (moveNext_13()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 16:	if (moveNext_16()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 19:	if (moveNext_19()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 25:	if (moveNext_25()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 27:	if (moveNext_27()) return true; break;
                        case 28:	if (moveNext_28()) return true; break;
                        case 30:	if (moveNext_30()) return true; break;
                        case 31:	if (moveNext_31()) return true; break;
                        case 32:	if (moveNext_32()) return true; break;
                        case 33:	if (moveNext_33()) return true; break;
                        case 35:	if (moveNext_35()) return true; break;
                        case 36:	if (moveNext_36()) return true; break;
                        case 37:	if (moveNext_37()) return true; break;
                        case 38:	if (moveNext_38()) return true; break;
                        case 40:	if (moveNext_40()) return true; break;
                        case 41:	if (moveNext_41()) return true; break;
                        case 42:	if (moveNext_42()) return true; break;
                        case 43:	if (moveNext_43()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 4;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                var3_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C058", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_3() throws Exception {
                state = 9;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_4() throws Exception {
                state = 6;
                if (!var3_filter_elements_nodename.moveNext()) {state = 5; return false; }
                var4_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3124", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 2;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_6() throws Exception {
                state = 6;
                if (!var4_filter_elements_nodename.moveNext()) {state = 7; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("name", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_7() throws Exception {
                state = 4;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 10; return false; }
                var6_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C059", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_10() throws Exception {
                state = 16;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 13;
                if (!var6_filter_elements_nodename.moveNext()) {state = 12; return false; }
                var7_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3042_1", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_12() throws Exception {
                state = 9;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_13() throws Exception {
                state = 13;
                if (!var7_filter_elements_nodename.moveNext()) {state = 14; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("street", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_14() throws Exception {
                state = 11;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_16() throws Exception {
                state = 18;
                if (!var8_filter_elements_nodename.moveNext()) {state = 17; return false; }
                var9_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C059", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 23;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                var11_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if (!var9_filter_elements_nodename.moveNext()) {state = 19; return false; }
                var10_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3042_2", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_19() throws Exception {
                state = 16;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var10_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("streetNumber", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 18;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 25;
                if (!var11_filter_elements_nodename.moveNext()) {state = 24; return false; }
                var12_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C059", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_24() throws Exception {
                state = 30;
                if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                var14_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_25() throws Exception {
                state = 27;
                if (!var12_filter_elements_nodename.moveNext()) {state = 26; return false; }
                var13_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3042_3", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var12_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 23;
                if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_27() throws Exception {
                state = 27;
                if (!var13_filter_elements_nodename.moveNext()) {state = 28; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("streetNumberAdd", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var13_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_28() throws Exception {
                state = 25;
                if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_30() throws Exception {
                state = 32;
                if (!var14_filter_elements_nodename.moveNext()) {state = 31; return false; }
                var15_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3164", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var14_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_31() throws Exception {
                state = 35;
                if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                var16_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_32() throws Exception {
                state = 32;
                if (!var15_filter_elements_nodename.moveNext()) {state = 33; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("place", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var15_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_33() throws Exception {
                state = 30;
                if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_35() throws Exception {
                state = 37;
                if (!var16_filter_elements_nodename.moveNext()) {state = 36; return false; }
                var17_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3251", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var16_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_36() throws Exception {
                state = 40;
                if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                var18_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_37() throws Exception {
                state = 37;
                if (!var17_filter_elements_nodename.moveNext()) {state = 38; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("postalCode", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var17_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_38() throws Exception {
                state = 35;
                if( var17_filter_elements_nodename != null ) { var17_filter_elements_nodename.close(); var17_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_40() throws Exception {
                state = 42;
                if (!var18_filter_elements_nodename.moveNext()) {state = 41; return false; }
                var19_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3207", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var18_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_41() throws Exception {
                state = 0;
                if( var18_filter_elements_nodename != null ) { var18_filter_elements_nodename.close(); var18_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_42() throws Exception {
                state = 42;
                if (!var19_filter_elements_nodename.moveNext()) {state = 43; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("countryCode", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var19_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_43() throws Exception {
                state = 40;
                if( var19_filter_elements_nodename != null ) { var19_filter_elements_nodename.close(); var19_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                    if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                    if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                    if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                    if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                    if( var17_filter_elements_nodename != null ) { var17_filter_elements_nodename.close(); var17_filter_elements_nodename = null; }
                    if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                    if( var19_filter_elements_nodename != null ) { var19_filter_elements_nodename.close(); var19_filter_elements_nodename = null; }
                    if( var18_filter_elements_nodename != null ) { var18_filter_elements_nodename.close(); var18_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq6_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IEnumerable var1_filter_elements_nodename;

        public seq6_join(org.assimbly.edifactcommon.mapforce.IEnumerable var1_filter_elements_nodename)
        {
            this.var1_filter_elements_nodename = var1_filter_elements_nodename;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq6_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var10_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
            IEnumerator var11_filter_elements_nodename;
            IEnumerator var13_filter_elements_nodename;
            IEnumerator var12_filter_elements_nodename;
            IEnumerator var14_filter_elements_nodename;
            IEnumerator var16_filter_elements_nodename;
            IEnumerator var15_filter_elements_nodename;
            IEnumerator var17_filter_elements_nodename;
            IEnumerator var18_filter_elements_nodename;
            IEnumerator var19_filter_elements_nodename;
            IEnumerator var20_filter_elements_nodename;
            IEnumerator var21_filter_elements_nodename;
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
                        case 4:	if (moveNext_4()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 7:	if (moveNext_7()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 10:	if (moveNext_10()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 16:	if (moveNext_16()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 19:	if (moveNext_19()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 22:	if (moveNext_22()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 25:	if (moveNext_25()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 28:	if (moveNext_28()) return true; break;
                        case 29:	if (moveNext_29()) return true; break;
                        case 30:	if (moveNext_30()) return true; break;
                        case 31:	if (moveNext_31()) return true; break;
                        case 32:	if (moveNext_32()) return true; break;
                        case 33:	if (moveNext_33()) return true; break;
                        case 35:	if (moveNext_35()) return true; break;
                        case 36:	if (moveNext_36()) return true; break;
                        case 37:	if (moveNext_37()) return true; break;
                        case 38:	if (moveNext_38()) return true; break;
                        case 40:	if (moveNext_40()) return true; break;
                        case 41:	if (moveNext_41()) return true; break;
                        case 42:	if (moveNext_42()) return true; break;
                        case 43:	if (moveNext_43()) return true; break;
                        case 45:	if (moveNext_45()) return true; break;
                        case 46:	if (moveNext_46()) return true; break;
                        case 47:	if (moveNext_47()) return true; break;
                        case 48:	if (moveNext_48()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 4;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                var3_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C082", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_3() throws Exception {
                state = 7;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_4() throws Exception {
                state = 4;
                if (!var3_filter_elements_nodename.moveNext()) {state = 5; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("companyCode", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString((org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("F3039", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_5() throws Exception {
                state = 2;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_7() throws Exception {
                state = 9;
                if (!var4_filter_elements_nodename.moveNext()) {state = 8; return false; }
                var5_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C058", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 14;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 10; return false; }
                var6_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3124", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_10() throws Exception {
                state = 7;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var6_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("name", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 9;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 16;
                if (!var7_filter_elements_nodename.moveNext()) {state = 15; return false; }
                var8_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C059", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_15() throws Exception {
                state = 21;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                var10_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_16() throws Exception {
                state = 18;
                if (!var8_filter_elements_nodename.moveNext()) {state = 17; return false; }
                var9_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3042_1", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 14;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_18() throws Exception {
                state = 18;
                if (!var9_filter_elements_nodename.moveNext()) {state = 19; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("street", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_19() throws Exception {
                state = 16;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if (!var10_filter_elements_nodename.moveNext()) {state = 22; return false; }
                var11_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C059", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_22() throws Exception {
                state = 28;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                var13_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 25;
                if (!var11_filter_elements_nodename.moveNext()) {state = 24; return false; }
                var12_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3042_2", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_24() throws Exception {
                state = 21;
                if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_25() throws Exception {
                state = 25;
                if (!var12_filter_elements_nodename.moveNext()) {state = 26; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("streetNumber", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var12_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_26() throws Exception {
                state = 23;
                if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_28() throws Exception {
                state = 30;
                if (!var13_filter_elements_nodename.moveNext()) {state = 29; return false; }
                var14_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C059", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var13_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 35;
                if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                var16_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_30() throws Exception {
                state = 32;
                if (!var14_filter_elements_nodename.moveNext()) {state = 31; return false; }
                var15_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3042_3", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var14_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_31() throws Exception {
                state = 28;
                if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_32() throws Exception {
                state = 32;
                if (!var15_filter_elements_nodename.moveNext()) {state = 33; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("streetNumberAdd", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var15_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_33() throws Exception {
                state = 30;
                if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_35() throws Exception {
                state = 37;
                if (!var16_filter_elements_nodename.moveNext()) {state = 36; return false; }
                var17_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3164", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var16_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_36() throws Exception {
                state = 40;
                if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                var18_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_37() throws Exception {
                state = 37;
                if (!var17_filter_elements_nodename.moveNext()) {state = 38; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("place", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var17_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_38() throws Exception {
                state = 35;
                if( var17_filter_elements_nodename != null ) { var17_filter_elements_nodename.close(); var17_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_40() throws Exception {
                state = 42;
                if (!var18_filter_elements_nodename.moveNext()) {state = 41; return false; }
                var19_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3251", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var18_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_41() throws Exception {
                state = 45;
                if( var18_filter_elements_nodename != null ) { var18_filter_elements_nodename.close(); var18_filter_elements_nodename = null; }
                var20_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_42() throws Exception {
                state = 42;
                if (!var19_filter_elements_nodename.moveNext()) {state = 43; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("postalCode", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var19_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_43() throws Exception {
                state = 40;
                if( var19_filter_elements_nodename != null ) { var19_filter_elements_nodename.close(); var19_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_45() throws Exception {
                state = 47;
                if (!var20_filter_elements_nodename.moveNext()) {state = 46; return false; }
                var21_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3207", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("NAD", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var20_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_46() throws Exception {
                state = 0;
                if( var20_filter_elements_nodename != null ) { var20_filter_elements_nodename.close(); var20_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_47() throws Exception {
                state = 47;
                if (!var21_filter_elements_nodename.moveNext()) {state = 48; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("countryCode", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var21_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_48() throws Exception {
                state = 45;
                if( var21_filter_elements_nodename != null ) { var21_filter_elements_nodename.close(); var21_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                    if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                    if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                    if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                    if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                    if( var17_filter_elements_nodename != null ) { var17_filter_elements_nodename.close(); var17_filter_elements_nodename = null; }
                    if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                    if( var19_filter_elements_nodename != null ) { var19_filter_elements_nodename.close(); var19_filter_elements_nodename = null; }
                    if( var18_filter_elements_nodename != null ) { var18_filter_elements_nodename.close(); var18_filter_elements_nodename = null; }
                    if( var21_filter_elements_nodename != null ) { var21_filter_elements_nodename.close(); var21_filter_elements_nodename = null; }
                    if( var20_filter_elements_nodename != null ) { var20_filter_elements_nodename.close(); var20_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq7_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IEnumerable var1_filter_elements_nodename;
        org.assimbly.edifactcommon.mapforce.IMFNode var2_cur;
        org.assimbly.edifactcommon.mapforce.IEnumerable var3_filter_elements_nodename;

        public seq7_join(org.assimbly.edifactcommon.mapforce.IEnumerable var1_filter_elements_nodename, org.assimbly.edifactcommon.mapforce.IMFNode var2_cur, org.assimbly.edifactcommon.mapforce.IEnumerable var3_filter_elements_nodename)
        {
            this.var1_filter_elements_nodename = var1_filter_elements_nodename;
            this.var2_cur = var2_cur;
            this.var3_filter_elements_nodename = var3_filter_elements_nodename;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq7_join closure;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var10_filter_elements_nodename;
            IEnumerator var12_filter_elements_nodename;
            IEnumerator var11_filter_elements_nodename;
            IEnumerator var13_filter_elements_nodename;
            IEnumerator var15_filter_elements_nodename;
            IEnumerator var14_filter_elements_nodename;
            IEnumerator var16_filter_elements_nodename;
            IEnumerator var18_filter_elements_nodename;
            IEnumerator var17_filter_elements_nodename;
            IEnumerator var19_filter_elements_nodename;
            IEnumerator var21_filter_elements_nodename;
            IEnumerator var20_filter_elements_nodename;
            IEnumerator var22_filter_elements_nodename;
            IEnumerator var23_filter_elements_nodename;
            IEnumerator var24_filter_elements_nodename;
            IEnumerator var25_filter_elements_nodename;
            IEnumerator var26_filter_elements_nodename;
            IEnumerator var27_filter_elements_nodename;
            IEnumerator var28_filter_elements_nodename;
            IEnumerator var29_filter_elements_nodename;
            IEnumerator var30_filter_elements_nodename;
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
                        case 4:	if (moveNext_4()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 7:	if (moveNext_7()) return true; break;
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 10:	if (moveNext_10()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                        case 16:	if (moveNext_16()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 19:	if (moveNext_19()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 22:	if (moveNext_22()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 25:	if (moveNext_25()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 28:	if (moveNext_28()) return true; break;
                        case 29:	if (moveNext_29()) return true; break;
                        case 30:	if (moveNext_30()) return true; break;
                        case 31:	if (moveNext_31()) return true; break;
                        case 32:	if (moveNext_32()) return true; break;
                        case 33:	if (moveNext_33()) return true; break;
                        case 35:	if (moveNext_35()) return true; break;
                        case 36:	if (moveNext_36()) return true; break;
                        case 37:	if (moveNext_37()) return true; break;
                        case 38:	if (moveNext_38()) return true; break;
                        case 39:	if (moveNext_39()) return true; break;
                        case 40:	if (moveNext_40()) return true; break;
                        case 42:	if (moveNext_42()) return true; break;
                        case 43:	if (moveNext_43()) return true; break;
                        case 44:	if (moveNext_44()) return true; break;
                        case 45:	if (moveNext_45()) return true; break;
                        case 47:	if (moveNext_47()) return true; break;
                        case 48:	if (moveNext_48()) return true; break;
                        case 49:	if (moveNext_49()) return true; break;
                        case 50:	if (moveNext_50()) return true; break;
                        case 52:	if (moveNext_52()) return true; break;
                        case 53:	if (moveNext_53()) return true; break;
                        case 54:	if (moveNext_54()) return true; break;
                        case 55:	if (moveNext_55()) return true; break;
                        case 57:	if (moveNext_57()) return true; break;
                        case 58:	if (moveNext_58()) return true; break;
                        case 59:	if (moveNext_59()) return true; break;
                        case 60:	if (moveNext_60()) return true; break;
                        case 62:	if (moveNext_62()) return true; break;
                        case 63:	if (moveNext_63()) return true; break;
                        case 64:	if (moveNext_64()) return true; break;
                        case 65:	if (moveNext_65()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var4_filter_elements_nodename = (closure.var3_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 4;
                if (!var4_filter_elements_nodename.moveNext()) {state = 3; return false; }
                var5_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C082", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("PNA", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_3() throws Exception {
                state = 7;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (closure.var3_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_4() throws Exception {
                state = 4;
                if (!var5_filter_elements_nodename.moveNext()) {state = 5; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("empNumber", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString((org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("F3039", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_5() throws Exception {
                state = 2;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_7() throws Exception {
                state = 9;
                if (!var6_filter_elements_nodename.moveNext()) {state = 8; return false; }
                var7_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C816_1", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("PNA", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 14;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var9_filter_elements_nodename = (closure.var3_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if (!var7_filter_elements_nodename.moveNext()) {state = 10; return false; }
                var8_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3398", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_10() throws Exception {
                state = 7;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var8_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("lastname", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 9;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 16;
                if (!var9_filter_elements_nodename.moveNext()) {state = 15; return false; }
                var10_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C816_2", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("PNA", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_15() throws Exception {
                state = 21;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                var12_filter_elements_nodename = (closure.var3_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_16() throws Exception {
                state = 18;
                if (!var10_filter_elements_nodename.moveNext()) {state = 17; return false; }
                var11_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3398", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 14;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_18() throws Exception {
                state = 18;
                if (!var11_filter_elements_nodename.moveNext()) {state = 19; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("prefix", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_19() throws Exception {
                state = 16;
                if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if (!var12_filter_elements_nodename.moveNext()) {state = 22; return false; }
                var13_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C816_3", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("PNA", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var12_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_22() throws Exception {
                state = 28;
                if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                var15_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 25;
                if (!var13_filter_elements_nodename.moveNext()) {state = 24; return false; }
                var14_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3398", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var13_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_24() throws Exception {
                state = 21;
                if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_25() throws Exception {
                state = 25;
                if (!var14_filter_elements_nodename.moveNext()) {state = 26; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("initials", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var14_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_26() throws Exception {
                state = 23;
                if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_28() throws Exception {
                state = 30;
                if (!var15_filter_elements_nodename.moveNext()) {state = 29; return false; }
                var16_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C816_1", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("PNA", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var15_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 35;
                if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                var18_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_30() throws Exception {
                state = 32;
                if (!var16_filter_elements_nodename.moveNext()) {state = 31; return false; }
                var17_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3398", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var16_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_31() throws Exception {
                state = 28;
                if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_32() throws Exception {
                state = 32;
                if (!var17_filter_elements_nodename.moveNext()) {state = 33; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("partnerName", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var17_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_33() throws Exception {
                state = 30;
                if( var17_filter_elements_nodename != null ) { var17_filter_elements_nodename.close(); var17_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_35() throws Exception {
                state = 37;
                if (!var18_filter_elements_nodename.moveNext()) {state = 36; return false; }
                var19_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C816_2", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("PNA", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var18_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_36() throws Exception {
                state = 42;
                if( var18_filter_elements_nodename != null ) { var18_filter_elements_nodename.close(); var18_filter_elements_nodename = null; }
                var21_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("DTM01", closure.var2_cur)).enumerator();
                return false;
            }
            private boolean moveNext_37() throws Exception {
                state = 39;
                if (!var19_filter_elements_nodename.moveNext()) {state = 38; return false; }
                var20_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3398", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var19_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_38() throws Exception {
                state = 35;
                if( var19_filter_elements_nodename != null ) { var19_filter_elements_nodename.close(); var19_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_39() throws Exception {
                state = 39;
                if (!var20_filter_elements_nodename.moveNext()) {state = 40; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("prefixPartner", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var20_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_40() throws Exception {
                state = 37;
                if( var20_filter_elements_nodename != null ) { var20_filter_elements_nodename.close(); var20_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_42() throws Exception {
                state = 44;
                if (!var21_filter_elements_nodename.moveNext()) {state = 43; return false; }
                var22_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F2380", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("C507", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("DTM", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var21_filter_elements_nodename.current())))))))).enumerator();
                return false;
            }
            private boolean moveNext_43() throws Exception {
                state = 47;
                if( var21_filter_elements_nodename != null ) { var21_filter_elements_nodename.close(); var21_filter_elements_nodename = null; }
                var23_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("PDI", closure.var2_cur)).enumerator();
                return false;
            }
            private boolean moveNext_44() throws Exception {
                state = 44;
                if (!var22_filter_elements_nodename.moveNext()) {state = 45; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("birthdate", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var22_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_45() throws Exception {
                state = 42;
                if( var22_filter_elements_nodename != null ) { var22_filter_elements_nodename.close(); var22_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_47() throws Exception {
                state = 49;
                if (!var23_filter_elements_nodename.moveNext()) {state = 48; return false; }
                var24_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3499", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var23_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_48() throws Exception {
                state = 52;
                if( var23_filter_elements_nodename != null ) { var23_filter_elements_nodename.close(); var23_filter_elements_nodename = null; }
                var25_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("DTM02", closure.var2_cur)).enumerator();
                return false;
            }
            private boolean moveNext_49() throws Exception {
                state = 49;
                if (!var24_filter_elements_nodename.moveNext()) {state = 50; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("gender", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var24_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_50() throws Exception {
                state = 47;
                if( var24_filter_elements_nodename != null ) { var24_filter_elements_nodename.close(); var24_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_52() throws Exception {
                state = 54;
                if (!var25_filter_elements_nodename.moveNext()) {state = 53; return false; }
                var26_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F2380", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("C507", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("DTM", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var25_filter_elements_nodename.current())))))))).enumerator();
                return false;
            }
            private boolean moveNext_53() throws Exception {
                state = 57;
                if( var25_filter_elements_nodename != null ) { var25_filter_elements_nodename.close(); var25_filter_elements_nodename = null; }
                var27_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("DTM03", closure.var2_cur)).enumerator();
                return false;
            }
            private boolean moveNext_54() throws Exception {
                state = 54;
                if (!var26_filter_elements_nodename.moveNext()) {state = 55; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("hoursPerWeek", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var26_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_55() throws Exception {
                state = 52;
                if( var26_filter_elements_nodename != null ) { var26_filter_elements_nodename.close(); var26_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_57() throws Exception {
                state = 59;
                if (!var27_filter_elements_nodename.moveNext()) {state = 58; return false; }
                var28_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F2380", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("C507", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("DTM", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var27_filter_elements_nodename.current())))))))).enumerator();
                return false;
            }
            private boolean moveNext_58() throws Exception {
                state = 62;
                if( var27_filter_elements_nodename != null ) { var27_filter_elements_nodename.close(); var27_filter_elements_nodename = null; }
                var29_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("DTM04", closure.var2_cur)).enumerator();
                return false;
            }
            private boolean moveNext_59() throws Exception {
                state = 59;
                if (!var28_filter_elements_nodename.moveNext()) {state = 60; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("employementStartDate", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var28_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_60() throws Exception {
                state = 57;
                if( var28_filter_elements_nodename != null ) { var28_filter_elements_nodename.close(); var28_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_62() throws Exception {
                state = 64;
                if (!var29_filter_elements_nodename.moveNext()) {state = 63; return false; }
                var30_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F2380", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("C507", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("DTM", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var29_filter_elements_nodename.current())))))))).enumerator();
                return false;
            }
            private boolean moveNext_63() throws Exception {
                state = 0;
                if( var29_filter_elements_nodename != null ) { var29_filter_elements_nodename.close(); var29_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_64() throws Exception {
                state = 64;
                if (!var30_filter_elements_nodename.moveNext()) {state = 65; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("employementEndDate", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var30_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_65() throws Exception {
                state = 62;
                if( var30_filter_elements_nodename != null ) { var30_filter_elements_nodename.close(); var30_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                    if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                    if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                    if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                    if( var17_filter_elements_nodename != null ) { var17_filter_elements_nodename.close(); var17_filter_elements_nodename = null; }
                    if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                    if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                    if( var20_filter_elements_nodename != null ) { var20_filter_elements_nodename.close(); var20_filter_elements_nodename = null; }
                    if( var19_filter_elements_nodename != null ) { var19_filter_elements_nodename.close(); var19_filter_elements_nodename = null; }
                    if( var18_filter_elements_nodename != null ) { var18_filter_elements_nodename.close(); var18_filter_elements_nodename = null; }
                    if( var22_filter_elements_nodename != null ) { var22_filter_elements_nodename.close(); var22_filter_elements_nodename = null; }
                    if( var21_filter_elements_nodename != null ) { var21_filter_elements_nodename.close(); var21_filter_elements_nodename = null; }
                    if( var24_filter_elements_nodename != null ) { var24_filter_elements_nodename.close(); var24_filter_elements_nodename = null; }
                    if( var23_filter_elements_nodename != null ) { var23_filter_elements_nodename.close(); var23_filter_elements_nodename = null; }
                    if( var26_filter_elements_nodename != null ) { var26_filter_elements_nodename.close(); var26_filter_elements_nodename = null; }
                    if( var25_filter_elements_nodename != null ) { var25_filter_elements_nodename.close(); var25_filter_elements_nodename = null; }
                    if( var28_filter_elements_nodename != null ) { var28_filter_elements_nodename.close(); var28_filter_elements_nodename = null; }
                    if( var27_filter_elements_nodename != null ) { var27_filter_elements_nodename.close(); var27_filter_elements_nodename = null; }
                    if( var30_filter_elements_nodename != null ) { var30_filter_elements_nodename.close(); var30_filter_elements_nodename = null; }
                    if( var29_filter_elements_nodename != null ) { var29_filter_elements_nodename.close(); var29_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq8_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IEnumerable var1_filter_elements_nodename;

        public seq8_join(org.assimbly.edifactcommon.mapforce.IEnumerable var1_filter_elements_nodename)
        {
            this.var1_filter_elements_nodename = var1_filter_elements_nodename;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq8_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
            IEnumerator var11_filter_elements_nodename;
            IEnumerator var10_filter_elements_nodename;
            IEnumerator var12_filter_elements_nodename;
            IEnumerator var13_filter_elements_nodename;
            IEnumerator var14_filter_elements_nodename;
            IEnumerator var15_filter_elements_nodename;
            IEnumerator var16_filter_elements_nodename;
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
                        case 4:	if (moveNext_4()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 7:	if (moveNext_7()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 10:	if (moveNext_10()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 13:	if (moveNext_13()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 16:	if (moveNext_16()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 19:	if (moveNext_19()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 25:	if (moveNext_25()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 28:	if (moveNext_28()) return true; break;
                        case 29:	if (moveNext_29()) return true; break;
                        case 30:	if (moveNext_30()) return true; break;
                        case 31:	if (moveNext_31()) return true; break;
                        case 33:	if (moveNext_33()) return true; break;
                        case 34:	if (moveNext_34()) return true; break;
                        case 35:	if (moveNext_35()) return true; break;
                        case 36:	if (moveNext_36()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 4;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                var3_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C090", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("ADR", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_3() throws Exception {
                state = 9;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_4() throws Exception {
                state = 6;
                if (!var3_filter_elements_nodename.moveNext()) {state = 5; return false; }
                var4_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3286_1", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 2;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_6() throws Exception {
                state = 6;
                if (!var4_filter_elements_nodename.moveNext()) {state = 7; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("street", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_7() throws Exception {
                state = 4;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 10; return false; }
                var6_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C090", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("ADR", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_10() throws Exception {
                state = 16;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 13;
                if (!var6_filter_elements_nodename.moveNext()) {state = 12; return false; }
                var7_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3286_2", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_12() throws Exception {
                state = 9;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_13() throws Exception {
                state = 13;
                if (!var7_filter_elements_nodename.moveNext()) {state = 14; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("streetNumber", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_14() throws Exception {
                state = 11;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_16() throws Exception {
                state = 18;
                if (!var8_filter_elements_nodename.moveNext()) {state = 17; return false; }
                var9_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C090", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("ADR", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 23;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                var11_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if (!var9_filter_elements_nodename.moveNext()) {state = 19; return false; }
                var10_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3286_3", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_19() throws Exception {
                state = 16;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var10_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("streetNumberAdd", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 18;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 25;
                if (!var11_filter_elements_nodename.moveNext()) {state = 24; return false; }
                var12_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3164", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("ADR", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_24() throws Exception {
                state = 28;
                if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                var13_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_25() throws Exception {
                state = 25;
                if (!var12_filter_elements_nodename.moveNext()) {state = 26; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("place", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var12_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_26() throws Exception {
                state = 23;
                if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_28() throws Exception {
                state = 30;
                if (!var13_filter_elements_nodename.moveNext()) {state = 29; return false; }
                var14_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3251", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("ADR", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var13_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 33;
                if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                var15_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_30() throws Exception {
                state = 30;
                if (!var14_filter_elements_nodename.moveNext()) {state = 31; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("postalCode", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var14_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_31() throws Exception {
                state = 28;
                if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_33() throws Exception {
                state = 35;
                if (!var15_filter_elements_nodename.moveNext()) {state = 34; return false; }
                var16_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3207", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("ADR", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var15_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_34() throws Exception {
                state = 0;
                if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_35() throws Exception {
                state = 35;
                if (!var16_filter_elements_nodename.moveNext()) {state = 36; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("countryCode", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var16_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_36() throws Exception {
                state = 33;
                if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                    if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                    if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                    if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                    if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                    if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq9_join implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IEnumerable var1_filter_elements_nodename;

        public seq9_join(org.assimbly.edifactcommon.mapforce.IEnumerable var1_filter_elements_nodename)
        {
            this.var1_filter_elements_nodename = var1_filter_elements_nodename;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq9_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
            IEnumerator var11_filter_elements_nodename;
            IEnumerator var10_filter_elements_nodename;
            IEnumerator var12_filter_elements_nodename;
            IEnumerator var13_filter_elements_nodename;
            IEnumerator var14_filter_elements_nodename;
            IEnumerator var15_filter_elements_nodename;
            IEnumerator var16_filter_elements_nodename;
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
                        case 4:	if (moveNext_4()) return true; break;
                        case 5:	if (moveNext_5()) return true; break;
                        case 6:	if (moveNext_6()) return true; break;
                        case 7:	if (moveNext_7()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                        case 10:	if (moveNext_10()) return true; break;
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                        case 13:	if (moveNext_13()) return true; break;
                        case 14:	if (moveNext_14()) return true; break;
                        case 16:	if (moveNext_16()) return true; break;
                        case 17:	if (moveNext_17()) return true; break;
                        case 18:	if (moveNext_18()) return true; break;
                        case 19:	if (moveNext_19()) return true; break;
                        case 20:	if (moveNext_20()) return true; break;
                        case 21:	if (moveNext_21()) return true; break;
                        case 23:	if (moveNext_23()) return true; break;
                        case 24:	if (moveNext_24()) return true; break;
                        case 25:	if (moveNext_25()) return true; break;
                        case 26:	if (moveNext_26()) return true; break;
                        case 28:	if (moveNext_28()) return true; break;
                        case 29:	if (moveNext_29()) return true; break;
                        case 30:	if (moveNext_30()) return true; break;
                        case 31:	if (moveNext_31()) return true; break;
                        case 33:	if (moveNext_33()) return true; break;
                        case 34:	if (moveNext_34()) return true; break;
                        case 35:	if (moveNext_35()) return true; break;
                        case 36:	if (moveNext_36()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 4;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                var3_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C090", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("ADR", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_3() throws Exception {
                state = 9;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_4() throws Exception {
                state = 6;
                if (!var3_filter_elements_nodename.moveNext()) {state = 5; return false; }
                var4_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3286_1", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 2;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_6() throws Exception {
                state = 6;
                if (!var4_filter_elements_nodename.moveNext()) {state = 7; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("street", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_7() throws Exception {
                state = 4;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 10; return false; }
                var6_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C090", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("ADR", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_10() throws Exception {
                state = 16;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 13;
                if (!var6_filter_elements_nodename.moveNext()) {state = 12; return false; }
                var7_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3286_2", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_12() throws Exception {
                state = 9;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_13() throws Exception {
                state = 13;
                if (!var7_filter_elements_nodename.moveNext()) {state = 14; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("streetNumber", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_14() throws Exception {
                state = 11;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_16() throws Exception {
                state = 18;
                if (!var8_filter_elements_nodename.moveNext()) {state = 17; return false; }
                var9_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("C090", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("ADR", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 23;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                var11_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if (!var9_filter_elements_nodename.moveNext()) {state = 19; return false; }
                var10_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3286_3", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_19() throws Exception {
                state = 16;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var10_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("streetNumberAdd", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 18;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 25;
                if (!var11_filter_elements_nodename.moveNext()) {state = 24; return false; }
                var12_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3164", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("ADR", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_24() throws Exception {
                state = 28;
                if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                var13_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_25() throws Exception {
                state = 25;
                if (!var12_filter_elements_nodename.moveNext()) {state = 26; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("place", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var12_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_26() throws Exception {
                state = 23;
                if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_28() throws Exception {
                state = 30;
                if (!var13_filter_elements_nodename.moveNext()) {state = 29; return false; }
                var14_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3251", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("ADR", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var13_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 33;
                if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                var15_filter_elements_nodename = (closure.var1_filter_elements_nodename).enumerator();
                return false;
            }
            private boolean moveNext_30() throws Exception {
                state = 30;
                if (!var14_filter_elements_nodename.moveNext()) {state = 31; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("postalCode", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var14_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_31() throws Exception {
                state = 28;
                if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_33() throws Exception {
                state = 35;
                if (!var15_filter_elements_nodename.moveNext()) {state = 34; return false; }
                var16_filter_elements_nodename = (org.assimbly.edifactcommon.functions.Core.filterElements("F3207", (org.assimbly.edifactcommon.mapforce.IMFNode)org.assimbly.edifactcommon.functions.Core.first(org.assimbly.edifactcommon.functions.Core.filterElements("ADR", ((org.assimbly.edifactcommon.mapforce.IMFNode)(var15_filter_elements_nodename.current())))))).enumerator();
                return false;
            }
            private boolean moveNext_34() throws Exception {
                state = 0;
                if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_35() throws Exception {
                state = 35;
                if (!var16_filter_elements_nodename.moveNext()) {state = 36; return false; }
                current = org.assimbly.edifactcommon.functions.Core.createElement(org.assimbly.edifactcommon.functions.Core.createQName("countryCode", ""), org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var16_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_36() throws Exception {
                state = 33;
                if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                    if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                    if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                    if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                    if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                    if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class Outer implements IEnumerable
    {
        org.assimbly.edifactcommon.mapforce.IMFNode var1_VRZUIM_Instance;

        public Outer(org.assimbly.edifactcommon.mapforce.IMFNode var1_VRZUIM_Instance)
        {
            this.var1_VRZUIM_Instance = var1_VRZUIM_Instance;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            Outer closure;
            IEnumerator var2_box;
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
                var2_box = ((new main(closure.var1_VRZUIM_Instance))).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_box.moveNext()) {state = 3; return false; }
                current = var2_box.current();
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_box != null ) { var2_box.close(); var2_box = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_box != null ) { var2_box.close(); var2_box = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }



    // instances
    protected org.assimbly.edifactcommon.text.ITextNode varVRZUIMInstance;

    public void run(String VRZUIMSourceFilename, String Medewerker2TargetFilename) throws Exception {
        // open source streams
        writeTrace("Loading " + VRZUIMSourceFilename + "...\n");
        org.assimbly.edifactcommon.io.FileInput VRZUIMSource = new org.assimbly.edifactcommon.io.FileInput(VRZUIMSourceFilename);
        // open target stream
        org.assimbly.edifactcommon.io.FileOutput Medewerker2Target = new org.assimbly.edifactcommon.io.FileOutput(Medewerker2TargetFilename);

        // run

        run(VRZUIMSource, Medewerker2Target);

        // close source streams
        VRZUIMSource.close();
        // close target stream
        writeTrace("Saving " + Medewerker2TargetFilename + "...\n");
        Medewerker2Target.close();
    }


    // main entry point

    public void run(org.assimbly.edifactcommon.io.Input VRZUIMSource, org.assimbly.edifactcommon.io.Output Medewerker2Target) throws Exception {
        // Open the source(s)
        writeTrace("Parsing Text...\n");
        VRZUIM_1941Envelope VRZUIMDocument = new VRZUIM_1941Envelope();
        VRZUIMDocument.setEncoding( "ISO-8859-1", false, false );
        VRZUIMDocument.parse(VRZUIMSource);
        varVRZUIMInstance = VRZUIMDocument.getGenerator();

        if (runDoesCloseAll)
            VRZUIMSource.close();

        // Create the target
        org.w3c.dom.Document Medewerker2Doc = (Medewerker2Target.getType() == org.assimbly.edifactcommon.io.Output.IO_DOM) ? Medewerker2Target.getDocument() : XmlTreeOperations.createDocument();

        // Execute mapping

        main mapping = new main(new org.assimbly.edifactcommon.text.TextDocumentAsMFNodeAdapter(varVRZUIMInstance, VRZUIMSource.getFilename()));

        org.assimbly.edifactcommon.xml.MFDOMWriter.write(mapping, Medewerker2Doc);
        // Close the target
        XmlTreeOperations.saveDocument(Medewerker2Doc, Medewerker2Target, "UTF-8", false, false, true, false);


        if (runDoesCloseAll)
        {
            VRZUIMSource.close();
            Medewerker2Target.close();
        }
    }



}
