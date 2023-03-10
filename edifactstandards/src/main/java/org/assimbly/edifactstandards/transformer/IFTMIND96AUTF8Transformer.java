package org.assimbly.edifactstandards.transformer;

import org.assimbly.edifactcommon.CoreTypes;
import org.assimbly.edifactcommon.TraceProvider;

import org.assimbly.edifactcommon.functions.Core;
import org.assimbly.edifactcommon.io.FileInput;
import org.assimbly.edifactcommon.io.FileOutput;
import org.assimbly.edifactcommon.io.Input;
import org.assimbly.edifactcommon.io.Output;
import org.assimbly.edifactcommon.mapforce.*;
import org.assimbly.edifactcommon.xml.*;
import org.assimbly.edifactcommon.text.*;
import org.assimbly.edifactstandards.envelope.IFTMIND96AUTF8Envelope;

public class IFTMIND96AUTF8Transformer extends TraceProvider
{
    private boolean runDoesCloseAll = true;
    public void setCloseObjectsAfterRun(boolean c) {runDoesCloseAll = c;}
    public boolean getCloseObjectsAfterRun() {return runDoesCloseAll;}


    static class main implements IEnumerable
    {
        IMFNode var1_IFTMIN_Instance;

        public main(IMFNode var1_IFTMIN_Instance)
        {
            this.var1_IFTMIN_Instance = var1_IFTMIN_Instance;
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
                current = Core.createElement(Core.createQName("Envelope", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq1_join(closure.var1_IFTMIN_Instance)));
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
        IMFNode var1_IFTMIN_Instance;

        public seq1_join(IMFNode var1_IFTMIN_Instance)
        {
            this.var1_IFTMIN_Instance = var1_IFTMIN_Instance;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                current = Core.createAttribute(Core.createQName("xsi:schemaLocation", "http://www.w3.org/2001/XMLSchema-instance"), Core.box("http://www.blujaysolutions.com/2017/IFTMIN file:///C:/Users/jss/Documents/seacon/germany_interfaces/develop/iftmin_D96A/IFTMIN_D96A.xsd"));
                pos++;
                return true;
            }
            private boolean moveNext_2() throws Exception {
                state = 3;
                var2_filter_elements_nodename = (Core.filterElements("Envelope", closure.var1_IFTMIN_Instance)).enumerator();
                return false;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if (!var2_filter_elements_nodename.moveNext()) {state = 4; return false; }
                var3_filter_elements_nodename = (Core.filterElements("Interchange", ((IMFNode)(var2_filter_elements_nodename.current())))).enumerator();
                return false;
            }
            private boolean moveNext_4() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("Interchange", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq2_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 3;
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
    static class seq2_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq2_join(IMFNode var1_cur)
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
            IEnumerator var4_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("UNB", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("UNB", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq3_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("UNZ", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("UNZ", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq9_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("Group", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("Group", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq10_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq3_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq3_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq3_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
            IEnumerator var10_filter_elements_nodename;
            IEnumerator var11_filter_elements_nodename;
            IEnumerator var12_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F0020", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0020", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0026", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0026", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F0029", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F0029", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F0031", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F0031", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("F0032", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("F0032", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("F0035", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("F0035", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var7_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (Core.filterElements("S001", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = Core.createElement(Core.createQName("S001", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq4_join(((IMFNode)(var8_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                var9_filter_elements_nodename = (Core.filterElements("S002", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_filter_elements_nodename.moveNext()) {state = 24; return false; }
                current = Core.createElement(Core.createQName("S002", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq5_join(((IMFNode)(var9_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                var10_filter_elements_nodename = (Core.filterElements("S003", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_filter_elements_nodename.moveNext()) {state = 27; return false; }
                current = Core.createElement(Core.createQName("S003", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq6_join(((IMFNode)(var10_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 29;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                var11_filter_elements_nodename = (Core.filterElements("S004", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 29;
                if (!var11_filter_elements_nodename.moveNext()) {state = 30; return false; }
                current = Core.createElement(Core.createQName("S004", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq7_join(((IMFNode)(var11_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_30() throws Exception {
                state = 32;
                if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                var12_filter_elements_nodename = (Core.filterElements("S005", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_32() throws Exception {
                state = 32;
                if (!var12_filter_elements_nodename.moveNext()) {state = 33; return false; }
                current = Core.createElement(Core.createQName("S005", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq8_join(((IMFNode)(var12_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_33() throws Exception {
                state = 0;
                if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                    if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                    if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq4_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq4_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
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
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F0001", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0001", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0002", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0002", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F0080", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F0080", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F0133", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F0133", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("F0076", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("F0076", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq5_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq5_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
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
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F0004", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0004", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0007", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0007", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F0008", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F0008", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F0042", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F0042", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq6_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq6_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
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
                var2_filter_elements_nodename = (Core.filterElements("F0010", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0010", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0007", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0007", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F0014", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F0014", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F0046", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F0046", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq7_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq7_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq7_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F0017", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0017", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0019", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0019", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq8_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq8_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
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
                var2_filter_elements_nodename = (Core.filterElements("F0022", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0022", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0025", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0025", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq9_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq9_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F0036", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0036", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0020", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0020", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq10_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq10_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq10_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("UNG", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("UNG", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq11_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("UNE", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("UNE", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq15_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("Message_IFTMIN", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("Message_IFTMIN", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq16_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq11_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq11_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq11_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F0038", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0038", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0048", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0048", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F0051", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F0051", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F0058", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F0058", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("S006", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("S006", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq12_join(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("S007", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("S007", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq13_join(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (Core.filterElements("S004", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = Core.createElement(Core.createQName("S004", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq7_join(((IMFNode)(var8_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                var9_filter_elements_nodename = (Core.filterElements("S008", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_filter_elements_nodename.moveNext()) {state = 24; return false; }
                current = Core.createElement(Core.createQName("S008", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq14_join(((IMFNode)(var9_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 0;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq12_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq12_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq12_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F0040", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0040", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0007", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0007", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq13_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq13_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq13_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F0044", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0044", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0007", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0007", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq14_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq14_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq14_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F0052", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0052", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0054", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0054", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F0057", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F0057", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq15_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq15_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq15_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F0060", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0060", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0048", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0048", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq16_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq16_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq16_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("UNH", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("UNH", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq17_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("BGM", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("BGM", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq23_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("CTA", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("CTA", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq25_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("COM", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("COM", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq27_map(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("DTM", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("DTM", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq29_map(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("TSR", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("TSR", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq31_join(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (Core.filterElements("CUX", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = Core.createElement(Core.createQName("CUX", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq36_join(((IMFNode)(var8_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                var9_filter_elements_nodename = (Core.filterElements("MOA", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_filter_elements_nodename.moveNext()) {state = 24; return false; }
                current = Core.createElement(Core.createQName("MOA", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq38_map(((IMFNode)(var9_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                var10_filter_elements_nodename = (Core.filterElements("FTX", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_filter_elements_nodename.moveNext()) {state = 27; return false; }
                current = Core.createElement(Core.createQName("FTX", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq40_join(((IMFNode)(var10_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 29;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                var11_filter_elements_nodename = (Core.filterElements("CNT", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 29;
                if (!var11_filter_elements_nodename.moveNext()) {state = 30; return false; }
                current = Core.createElement(Core.createQName("CNT", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq43_map(((IMFNode)(var11_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_30() throws Exception {
                state = 32;
                if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                var12_filter_elements_nodename = (Core.filterElements("DOC", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_32() throws Exception {
                state = 32;
                if (!var12_filter_elements_nodename.moveNext()) {state = 33; return false; }
                current = Core.createElement(Core.createQName("DOC", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq45_join(((IMFNode)(var12_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_33() throws Exception {
                state = 35;
                if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                var13_filter_elements_nodename = (Core.filterElements("UNT", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_35() throws Exception {
                state = 35;
                if (!var13_filter_elements_nodename.moveNext()) {state = 36; return false; }
                current = Core.createElement(Core.createQName("UNT", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq47_join(((IMFNode)(var13_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_36() throws Exception {
                state = 38;
                if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                var14_filter_elements_nodename = (Core.filterElements("SG1", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_38() throws Exception {
                state = 38;
                if (!var14_filter_elements_nodename.moveNext()) {state = 39; return false; }
                current = Core.createElement(Core.createQName("SG1", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq48_join(((IMFNode)(var14_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_39() throws Exception {
                state = 41;
                if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                var15_filter_elements_nodename = (Core.filterElements("SG2", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_41() throws Exception {
                state = 41;
                if (!var15_filter_elements_nodename.moveNext()) {state = 42; return false; }
                current = Core.createElement(Core.createQName("SG2", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq53_join(((IMFNode)(var15_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_42() throws Exception {
                state = 44;
                if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                var16_filter_elements_nodename = (Core.filterElements("SG3", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_44() throws Exception {
                state = 44;
                if (!var16_filter_elements_nodename.moveNext()) {state = 45; return false; }
                current = Core.createElement(Core.createQName("SG3", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq56_join(((IMFNode)(var16_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_45() throws Exception {
                state = 47;
                if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                var17_filter_elements_nodename = (Core.filterElements("SG4", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_47() throws Exception {
                state = 47;
                if (!var17_filter_elements_nodename.moveNext()) {state = 48; return false; }
                current = Core.createElement(Core.createQName("SG4", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq59_join(((IMFNode)(var17_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_48() throws Exception {
                state = 50;
                if( var17_filter_elements_nodename != null ) { var17_filter_elements_nodename.close(); var17_filter_elements_nodename = null; }
                var18_filter_elements_nodename = (Core.filterElements("SG6", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_50() throws Exception {
                state = 50;
                if (!var18_filter_elements_nodename.moveNext()) {state = 51; return false; }
                current = Core.createElement(Core.createQName("SG6", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq65_join(((IMFNode)(var18_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_51() throws Exception {
                state = 53;
                if( var18_filter_elements_nodename != null ) { var18_filter_elements_nodename.close(); var18_filter_elements_nodename = null; }
                var19_filter_elements_nodename = (Core.filterElements("SG7", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_53() throws Exception {
                state = 53;
                if (!var19_filter_elements_nodename.moveNext()) {state = 54; return false; }
                current = Core.createElement(Core.createQName("SG7", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq69_join(((IMFNode)(var19_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_54() throws Exception {
                state = 56;
                if( var19_filter_elements_nodename != null ) { var19_filter_elements_nodename.close(); var19_filter_elements_nodename = null; }
                var20_filter_elements_nodename = (Core.filterElements("SG8", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_56() throws Exception {
                state = 56;
                if (!var20_filter_elements_nodename.moveNext()) {state = 57; return false; }
                current = Core.createElement(Core.createQName("SG8", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq83_join(((IMFNode)(var20_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_57() throws Exception {
                state = 59;
                if( var20_filter_elements_nodename != null ) { var20_filter_elements_nodename.close(); var20_filter_elements_nodename = null; }
                var21_filter_elements_nodename = (Core.filterElements("SG11", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_59() throws Exception {
                state = 59;
                if (!var21_filter_elements_nodename.moveNext()) {state = 60; return false; }
                current = Core.createElement(Core.createQName("SG11", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq90_join(((IMFNode)(var21_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_60() throws Exception {
                state = 62;
                if( var21_filter_elements_nodename != null ) { var21_filter_elements_nodename.close(); var21_filter_elements_nodename = null; }
                var22_filter_elements_nodename = (Core.filterElements("SG18", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_62() throws Exception {
                state = 62;
                if (!var22_filter_elements_nodename.moveNext()) {state = 63; return false; }
                current = Core.createElement(Core.createQName("SG18", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq100_join(((IMFNode)(var22_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_63() throws Exception {
                state = 65;
                if( var22_filter_elements_nodename != null ) { var22_filter_elements_nodename.close(); var22_filter_elements_nodename = null; }
                var23_filter_elements_nodename = (Core.filterElements("SG37", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_65() throws Exception {
                state = 65;
                if (!var23_filter_elements_nodename.moveNext()) {state = 66; return false; }
                current = Core.createElement(Core.createQName("SG37", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq143_join(((IMFNode)(var23_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_66() throws Exception {
                state = 0;
                if( var23_filter_elements_nodename != null ) { var23_filter_elements_nodename.close(); var23_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                    if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                    if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                    if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                    if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                    if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                    if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                    if( var17_filter_elements_nodename != null ) { var17_filter_elements_nodename.close(); var17_filter_elements_nodename = null; }
                    if( var18_filter_elements_nodename != null ) { var18_filter_elements_nodename.close(); var18_filter_elements_nodename = null; }
                    if( var19_filter_elements_nodename != null ) { var19_filter_elements_nodename.close(); var19_filter_elements_nodename = null; }
                    if( var20_filter_elements_nodename != null ) { var20_filter_elements_nodename.close(); var20_filter_elements_nodename = null; }
                    if( var21_filter_elements_nodename != null ) { var21_filter_elements_nodename.close(); var21_filter_elements_nodename = null; }
                    if( var22_filter_elements_nodename != null ) { var22_filter_elements_nodename.close(); var22_filter_elements_nodename = null; }
                    if( var23_filter_elements_nodename != null ) { var23_filter_elements_nodename.close(); var23_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq17_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq17_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq17_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F0062", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0062", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0068", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0068", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("S009", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("S009", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq18_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("S010", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("S010", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq19_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("S016", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("S016", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq20_join(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("S017", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("S017", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq21_join(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (Core.filterElements("S018", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = Core.createElement(Core.createQName("S018", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq22_join(((IMFNode)(var8_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 0;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq18_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq18_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq18_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F0065", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0065", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0052", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0052", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F0054", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F0054", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F0051", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F0051", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("F0057", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("F0057", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("F0110", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("F0110", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (Core.filterElements("F0113", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = Core.createElement(Core.createQName("F0113", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var8_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 0;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq19_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq19_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq19_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F0070", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0070", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0073", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0073", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq20_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq20_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq20_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F0115", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0115", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0116", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0116", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F0118", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F0118", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F0051", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F0051", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq21_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq21_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq21_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F0121", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0121", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0122", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0122", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F0124", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F0124", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F0051", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F0051", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq22_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq22_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq22_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F0127", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0127", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0128", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0128", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F0130", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F0130", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F0051", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F0051", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq23_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq23_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq23_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F1004", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F1004", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1225", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1225", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F4343", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F4343", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("C002", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("C002", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq24_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq24_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq24_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq24_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F1001", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F1001", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F1000", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F1000", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq25_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq25_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq25_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F3139", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F3139", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("C056", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("C056", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq26_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq26_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq26_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq26_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F3413", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F3413", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F3412", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F3412", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq27_map implements IEnumerable
    {
        IMFNode var1_cur;

        public seq27_map(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq27_map closure;
            IEnumerator var2_filter_elements_nodename;
            public Enumerator(seq27_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

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
                var2_filter_elements_nodename = (Core.filterElements("C076", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("C076", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq28_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq28_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq28_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq28_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F3148", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F3148", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F3155", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F3155", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq29_map implements IEnumerable
    {
        IMFNode var1_cur;

        public seq29_map(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq29_map closure;
            IEnumerator var2_filter_elements_nodename;
            public Enumerator(seq29_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

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
                var2_filter_elements_nodename = (Core.filterElements("C507", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("C507", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq30_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq30_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq30_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq30_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F2005", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F2005", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F2380", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F2380", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F2379", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F2379", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq31_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq31_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq31_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("C536", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("C536", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq32_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("C233", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("C233", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq33_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("C537", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("C537", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq34_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("C703", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("C703", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq35_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq32_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq32_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq32_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F4065", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F4065", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq33_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq33_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq33_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F7273_1", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F7273_1", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131_1", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131_1", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055_1", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055_1", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F7273_2", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F7273_2", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("F1131_2", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("F1131_2", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("F3055_2", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("F3055_2", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq34_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq34_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq34_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F4219", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F4219", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq35_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq35_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq35_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F7085", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F7085", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq36_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq36_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq36_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F5402", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F5402", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F6341", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F6341", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("C504", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("C504", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq37_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq37_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq37_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq37_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F6347", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F6347", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F6345", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F6345", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F6343", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F6343", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F6348", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F6348", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq38_map implements IEnumerable
    {
        IMFNode var1_cur;

        public seq38_map(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq38_map closure;
            IEnumerator var2_filter_elements_nodename;
            public Enumerator(seq38_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

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
                var2_filter_elements_nodename = (Core.filterElements("C516", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("C516", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq39_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq39_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq39_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq39_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F5025", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F5025", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F5004", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F5004", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F6345", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F6345", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F6343", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F6343", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("F4405", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("F4405", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq40_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq40_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq40_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F4451", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F4451", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F4453", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F4453", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3453", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3453", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("C107", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("C107", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq41_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("C108", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("C108", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq42_map(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq41_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq41_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq41_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            public Enumerator(seq41_join closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

            public boolean moveNext() throws Exception
            {
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
                var2_filter_elements_nodename = (Core.filterElements("F4441", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F4441", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq42_map implements IEnumerable
    {
        IMFNode var1_cur;

        public seq42_map(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq42_map closure;
            IEnumerator var2_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F4440", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F4440", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq43_map implements IEnumerable
    {
        IMFNode var1_cur;

        public seq43_map(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq43_map closure;
            IEnumerator var2_filter_elements_nodename;
            public Enumerator(seq43_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

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
                var2_filter_elements_nodename = (Core.filterElements("C270", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("C270", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq44_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq44_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq44_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq44_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F6069", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F6069", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F6066", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F6066", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F6411", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F6411", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq45_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq45_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq45_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F3153", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F3153", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1220", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1220", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F1218", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F1218", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("C002", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("C002", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq24_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("C503", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("C503", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq46_join(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq46_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq46_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq46_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F1004", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F1004", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1373", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1373", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F1366", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F1366", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F3453", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F3453", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq47_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq47_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq47_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F0074", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F0074", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F0062", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F0062", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq48_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq48_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq48_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("LOC", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("LOC", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq49_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("DTM", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("DTM", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq29_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq49_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq49_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq49_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
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
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F3227", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F3227", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F5479", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F5479", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("C517", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("C517", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq50_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("C519", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("C519", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq51_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("C553", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("C553", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq52_join(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq50_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq50_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq50_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F3225", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F3225", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F3224", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F3224", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq51_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq51_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq51_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F3223", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F3223", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F3222", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F3222", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq52_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq52_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq52_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F3233", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F3233", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F3232", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F3232", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq53_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq53_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq53_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("TOD", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("TOD", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq54_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("LOC", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("LOC", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq49_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq54_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq54_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq54_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F4055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F4055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F4215", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F4215", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("C100", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("C100", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq55_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq55_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq55_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq55_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F4053", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F4053", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F4052", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F4052", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq56_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq56_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq56_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("RFF", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("RFF", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq57_map(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("DTM", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("DTM", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq29_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq57_map implements IEnumerable
    {
        IMFNode var1_cur;

        public seq57_map(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq57_map closure;
            IEnumerator var2_filter_elements_nodename;
            public Enumerator(seq57_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

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
                var2_filter_elements_nodename = (Core.filterElements("C506", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("C506", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq58_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq58_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq58_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq58_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F1153", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F1153", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1154", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1154", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F1156", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F1156", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F4000", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F4000", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq59_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq59_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq59_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("GOR", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("GOR", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq60_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("DTM", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("DTM", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq29_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("LOC", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("LOC", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq49_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("SEL", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("SEL", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq62_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("FTX", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("FTX", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq40_join(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("SG5", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("SG5", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq64_join(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq60_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq60_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq60_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F8323", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8323", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("C232", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("C232", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq61_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq61_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq61_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq61_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F9415", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F9415", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F9411", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F9411", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F9417", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F9417", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F9353", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F9353", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq62_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq62_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq62_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F9308", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F9308", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F4517", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F4517", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("C215", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("C215", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq63_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq63_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq63_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq63_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F9303", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F9303", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F9302", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F9302", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq64_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq64_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq64_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("DOC", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("DOC", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq45_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("DTM", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("DTM", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq29_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq65_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq65_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq65_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("CPI", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("CPI", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq66_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("RFF", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("RFF", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq57_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("CUX", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("CUX", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq36_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("LOC", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("LOC", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq49_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("MOA", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("MOA", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq38_map(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq66_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq66_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq66_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F4237", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F4237", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("C229", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("C229", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq67_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("C231", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("C231", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq68_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq67_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq67_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq67_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F5237", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F5237", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq68_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq68_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq68_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F4215", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F4215", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq69_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq69_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq69_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
            IEnumerator var10_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("TCC", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("TCC", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq70_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("LOC", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("LOC", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq49_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("FTX", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("FTX", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq40_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("CUX", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("CUX", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq36_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("PRI", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("PRI", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq75_join(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("EQN", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("EQN", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq77_map(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (Core.filterElements("PCD", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = Core.createElement(Core.createQName("PCD", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq79_map(((IMFNode)(var8_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                var9_filter_elements_nodename = (Core.filterElements("MOA", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_filter_elements_nodename.moveNext()) {state = 24; return false; }
                current = Core.createElement(Core.createQName("MOA", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq38_map(((IMFNode)(var9_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                var10_filter_elements_nodename = (Core.filterElements("QTY", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_filter_elements_nodename.moveNext()) {state = 27; return false; }
                current = Core.createElement(Core.createQName("QTY", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq81_map(((IMFNode)(var10_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 0;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq70_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq70_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq70_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("C200", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("C200", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq71_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("C203", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("C203", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq72_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("C528", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("C528", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq73_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("C554", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("C554", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq74_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq71_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq71_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq71_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F8023", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8023", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F8022", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F8022", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("F4237", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("F4237", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("F7140", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("F7140", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq72_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq72_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq72_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
            IEnumerator var10_filter_elements_nodename;
            IEnumerator var11_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F5243", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F5243", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131_1", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131_1", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055_1", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055_1", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F5242", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F5242", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("F5275_1", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("F5275_1", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("F1131_2", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("F1131_2", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (Core.filterElements("F3055_2", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = Core.createElement(Core.createQName("F3055_2", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var8_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                var9_filter_elements_nodename = (Core.filterElements("F5275_2", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_filter_elements_nodename.moveNext()) {state = 24; return false; }
                current = Core.createElement(Core.createQName("F5275_2", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var9_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                var10_filter_elements_nodename = (Core.filterElements("F1131_3", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_filter_elements_nodename.moveNext()) {state = 27; return false; }
                current = Core.createElement(Core.createQName("F1131_3", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var10_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 29;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                var11_filter_elements_nodename = (Core.filterElements("F3055_3", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 29;
                if (!var11_filter_elements_nodename.moveNext()) {state = 30; return false; }
                current = Core.createElement(Core.createQName("F3055_3", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var11_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_30() throws Exception {
                state = 0;
                if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                    if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq73_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq73_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq73_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F7357", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F7357", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq74_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq74_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq74_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F5243", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F5243", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq75_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq75_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq75_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F5213", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F5213", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("C509", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("C509", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq76_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq76_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq76_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq76_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F5125", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F5125", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F5118", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F5118", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F5375", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F5375", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F5387", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F5387", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("F5284", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("F5284", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var6_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("F6411", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("F6411", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq77_map implements IEnumerable
    {
        IMFNode var1_cur;

        public seq77_map(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq77_map closure;
            IEnumerator var2_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("C523", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("C523", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq78_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq78_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq78_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq78_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F6350", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F6350", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F6353", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F6353", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq79_map implements IEnumerable
    {
        IMFNode var1_cur;

        public seq79_map(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq79_map closure;
            IEnumerator var2_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("C501", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("C501", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq80_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq80_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq80_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq80_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F5245", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F5245", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F5482", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F5482", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F5249", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F5249", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq81_map implements IEnumerable
    {
        IMFNode var1_cur;

        public seq81_map(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq81_map closure;
            IEnumerator var2_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("C186", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("C186", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq82_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq82_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq82_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq82_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F6063", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F6063", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F6060", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F6060", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F6411", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F6411", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq83_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq83_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq83_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("TDT", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("TDT", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq84_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("DTM", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("DTM", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq29_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("TSR", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("TSR", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq31_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("SG9", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("SG9", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq48_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("SG10", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("SG10", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq56_join(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq84_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq84_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq84_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
            IEnumerator var10_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F8051", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8051", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F8028", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F8028", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F8101", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F8101", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F8281", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F8281", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("C220", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("C220", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq85_join(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("C228", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("C228", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq86_join(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (Core.filterElements("C040", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = Core.createElement(Core.createQName("C040", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq87_join(((IMFNode)(var8_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                var9_filter_elements_nodename = (Core.filterElements("C401", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_filter_elements_nodename.moveNext()) {state = 24; return false; }
                current = Core.createElement(Core.createQName("C401", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq88_join(((IMFNode)(var9_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                var10_filter_elements_nodename = (Core.filterElements("C222", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_filter_elements_nodename.moveNext()) {state = 27; return false; }
                current = Core.createElement(Core.createQName("C222", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq89_join(((IMFNode)(var10_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 0;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq85_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq85_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq85_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F8067", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8067", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F8066", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F8066", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq86_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq86_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq86_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F8179", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8179", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F8178", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F8178", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq87_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq87_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq87_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F3127", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F3127", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F3128", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F3128", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq88_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq88_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq88_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F8457", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8457", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F8459", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F8459", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F7130", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F7130", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq89_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq89_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq89_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F8213", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8213", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F8212", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F8212", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("F8453", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("F8453", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq90_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq90_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq90_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
            IEnumerator var10_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("NAD", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("NAD", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq91_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("LOC", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("LOC", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq49_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("MOA", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("MOA", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq38_map(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("SG12", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("SG12", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq96_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("SG13", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("SG13", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq64_join(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("SG14", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("SG14", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq97_join(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (Core.filterElements("SG15", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = Core.createElement(Core.createQName("SG15", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq56_join(((IMFNode)(var8_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                var9_filter_elements_nodename = (Core.filterElements("SG16", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_filter_elements_nodename.moveNext()) {state = 24; return false; }
                current = Core.createElement(Core.createQName("SG16", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq65_join(((IMFNode)(var9_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                var10_filter_elements_nodename = (Core.filterElements("SG17", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_filter_elements_nodename.moveNext()) {state = 27; return false; }
                current = Core.createElement(Core.createQName("SG17", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq98_join(((IMFNode)(var10_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 0;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq91_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq91_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq91_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
            IEnumerator var10_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F3035", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F3035", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F3164", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F3164", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3229", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3229", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F3251", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F3251", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("F3207", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("F3207", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("C082", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("C082", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq92_join(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (Core.filterElements("C058", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = Core.createElement(Core.createQName("C058", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq93_map(((IMFNode)(var8_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                var9_filter_elements_nodename = (Core.filterElements("C080", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_filter_elements_nodename.moveNext()) {state = 24; return false; }
                current = Core.createElement(Core.createQName("C080", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq94_join(((IMFNode)(var9_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                var10_filter_elements_nodename = (Core.filterElements("C059", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_filter_elements_nodename.moveNext()) {state = 27; return false; }
                current = Core.createElement(Core.createQName("C059", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq95_map(((IMFNode)(var10_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 0;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq92_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq92_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq92_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F3039", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F3039", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq93_map implements IEnumerable
    {
        IMFNode var1_cur;

        public seq93_map(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq93_map closure;
            IEnumerator var2_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F3124", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F3124", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq94_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq94_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq94_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F3036", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F3036", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F3045", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F3045", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq95_map implements IEnumerable
    {
        IMFNode var1_cur;

        public seq95_map(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq95_map closure;
            IEnumerator var2_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F3042", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F3042", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq96_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq96_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq96_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("CTA", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("CTA", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq25_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("COM", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("COM", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq27_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq97_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq97_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq97_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("TCC", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("TCC", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq70_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("PRI", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("PRI", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq75_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("EQN", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("EQN", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq77_map(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("PCD", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("PCD", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq79_map(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("MOA", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("MOA", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq38_map(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("QTY", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("QTY", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq81_map(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq98_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq98_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq98_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("TSR", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("TSR", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq31_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("RFF", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("RFF", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq57_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("LOC", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("LOC", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq49_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("TPL", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("TPL", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq99_map(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("FTX", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("FTX", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq40_join(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq99_map implements IEnumerable
    {
        IMFNode var1_cur;

        public seq99_map(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq99_map closure;
            IEnumerator var2_filter_elements_nodename;
            public Enumerator(seq99_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

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
                var2_filter_elements_nodename = (Core.filterElements("C222", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("C222", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq89_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq100_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq100_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq100_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("GID", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("GID", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq101_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("HAN", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("HAN", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq103_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("TMP", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("TMP", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq106_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("RNG", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("RNG", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq108_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("TMD", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("TMD", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq110_join(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("LOC", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("LOC", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq49_join(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (Core.filterElements("MOA", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = Core.createElement(Core.createQName("MOA", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq38_map(((IMFNode)(var8_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                var9_filter_elements_nodename = (Core.filterElements("PIA", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_filter_elements_nodename.moveNext()) {state = 24; return false; }
                current = Core.createElement(Core.createQName("PIA", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq112_join(((IMFNode)(var9_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                var10_filter_elements_nodename = (Core.filterElements("FTX", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_filter_elements_nodename.moveNext()) {state = 27; return false; }
                current = Core.createElement(Core.createQName("FTX", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq40_join(((IMFNode)(var10_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 29;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                var11_filter_elements_nodename = (Core.filterElements("GDS", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 29;
                if (!var11_filter_elements_nodename.moveNext()) {state = 30; return false; }
                current = Core.createElement(Core.createQName("GDS", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq114_map(((IMFNode)(var11_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_30() throws Exception {
                state = 32;
                if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                var12_filter_elements_nodename = (Core.filterElements("SG19", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_32() throws Exception {
                state = 32;
                if (!var12_filter_elements_nodename.moveNext()) {state = 33; return false; }
                current = Core.createElement(Core.createQName("SG19", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq115_join(((IMFNode)(var12_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_33() throws Exception {
                state = 35;
                if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                var13_filter_elements_nodename = (Core.filterElements("SG20", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_35() throws Exception {
                state = 35;
                if (!var13_filter_elements_nodename.moveNext()) {state = 36; return false; }
                current = Core.createElement(Core.createQName("SG20", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq116_join(((IMFNode)(var13_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_36() throws Exception {
                state = 38;
                if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                var14_filter_elements_nodename = (Core.filterElements("SG21", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_38() throws Exception {
                state = 38;
                if (!var14_filter_elements_nodename.moveNext()) {state = 39; return false; }
                current = Core.createElement(Core.createQName("SG21", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq120_join(((IMFNode)(var14_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_39() throws Exception {
                state = 41;
                if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                var15_filter_elements_nodename = (Core.filterElements("SG22", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_41() throws Exception {
                state = 41;
                if (!var15_filter_elements_nodename.moveNext()) {state = 42; return false; }
                current = Core.createElement(Core.createQName("SG22", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq56_join(((IMFNode)(var15_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_42() throws Exception {
                state = 44;
                if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                var16_filter_elements_nodename = (Core.filterElements("SG23", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_44() throws Exception {
                state = 44;
                if (!var16_filter_elements_nodename.moveNext()) {state = 45; return false; }
                current = Core.createElement(Core.createQName("SG23", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq123_join(((IMFNode)(var16_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_45() throws Exception {
                state = 47;
                if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                var17_filter_elements_nodename = (Core.filterElements("SG24", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_47() throws Exception {
                state = 47;
                if (!var17_filter_elements_nodename.moveNext()) {state = 48; return false; }
                current = Core.createElement(Core.createQName("SG24", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq64_join(((IMFNode)(var17_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_48() throws Exception {
                state = 50;
                if( var17_filter_elements_nodename != null ) { var17_filter_elements_nodename.close(); var17_filter_elements_nodename = null; }
                var18_filter_elements_nodename = (Core.filterElements("SG25", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_50() throws Exception {
                state = 50;
                if (!var18_filter_elements_nodename.moveNext()) {state = 51; return false; }
                current = Core.createElement(Core.createQName("SG25", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq129_join(((IMFNode)(var18_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_51() throws Exception {
                state = 53;
                if( var18_filter_elements_nodename != null ) { var18_filter_elements_nodename.close(); var18_filter_elements_nodename = null; }
                var19_filter_elements_nodename = (Core.filterElements("SG27", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_53() throws Exception {
                state = 53;
                if (!var19_filter_elements_nodename.moveNext()) {state = 54; return false; }
                current = Core.createElement(Core.createQName("SG27", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq130_join(((IMFNode)(var19_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_54() throws Exception {
                state = 56;
                if( var19_filter_elements_nodename != null ) { var19_filter_elements_nodename.close(); var19_filter_elements_nodename = null; }
                var20_filter_elements_nodename = (Core.filterElements("SG29", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_56() throws Exception {
                state = 56;
                if (!var20_filter_elements_nodename.moveNext()) {state = 57; return false; }
                current = Core.createElement(Core.createQName("SG29", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq131_join(((IMFNode)(var20_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_57() throws Exception {
                state = 59;
                if( var20_filter_elements_nodename != null ) { var20_filter_elements_nodename.close(); var20_filter_elements_nodename = null; }
                var21_filter_elements_nodename = (Core.filterElements("SG31", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_59() throws Exception {
                state = 59;
                if (!var21_filter_elements_nodename.moveNext()) {state = 60; return false; }
                current = Core.createElement(Core.createQName("SG31", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq134_join(((IMFNode)(var21_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_60() throws Exception {
                state = 62;
                if( var21_filter_elements_nodename != null ) { var21_filter_elements_nodename.close(); var21_filter_elements_nodename = null; }
                var22_filter_elements_nodename = (Core.filterElements("SG32", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_62() throws Exception {
                state = 62;
                if (!var22_filter_elements_nodename.moveNext()) {state = 63; return false; }
                current = Core.createElement(Core.createQName("SG32", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq135_join(((IMFNode)(var22_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_63() throws Exception {
                state = 0;
                if( var22_filter_elements_nodename != null ) { var22_filter_elements_nodename.close(); var22_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                    if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                    if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                    if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                    if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                    if( var15_filter_elements_nodename != null ) { var15_filter_elements_nodename.close(); var15_filter_elements_nodename = null; }
                    if( var16_filter_elements_nodename != null ) { var16_filter_elements_nodename.close(); var16_filter_elements_nodename = null; }
                    if( var17_filter_elements_nodename != null ) { var17_filter_elements_nodename.close(); var17_filter_elements_nodename = null; }
                    if( var18_filter_elements_nodename != null ) { var18_filter_elements_nodename.close(); var18_filter_elements_nodename = null; }
                    if( var19_filter_elements_nodename != null ) { var19_filter_elements_nodename.close(); var19_filter_elements_nodename = null; }
                    if( var20_filter_elements_nodename != null ) { var20_filter_elements_nodename.close(); var20_filter_elements_nodename = null; }
                    if( var21_filter_elements_nodename != null ) { var21_filter_elements_nodename.close(); var21_filter_elements_nodename = null; }
                    if( var22_filter_elements_nodename != null ) { var22_filter_elements_nodename.close(); var22_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq101_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq101_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq101_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F1496", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F1496", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("C213", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("C213", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq102_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq102_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq102_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq102_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
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
                        case 14:	if (moveNext_14()) return true; break;
                        case 15:	if (moveNext_15()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F7224", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F7224", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F7065", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F7065", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("F7064", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("F7064", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq103_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq103_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq103_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("C524", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("C524", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq104_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("C218", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("C218", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq105_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq104_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq104_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq104_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F4079", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F4079", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F4078", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F4078", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq105_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq105_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq105_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F7419", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F7419", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq106_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq106_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq106_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F6245", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F6245", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("C239", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("C239", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq107_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq107_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq107_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq107_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F6246", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F6246", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F6411", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F6411", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq108_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq108_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq108_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F6167", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F6167", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("C280", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("C280", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq109_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq109_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq109_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq109_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F6411", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F6411", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F6162", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F6162", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F6152", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F6152", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq110_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq110_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq110_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F8332", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8332", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F8341", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F8341", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("C219", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("C219", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq111_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq111_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq111_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq111_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F8335", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8335", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F8334", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F8334", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq112_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq112_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq112_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F4347", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F4347", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("C212", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("C212", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq113_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq113_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq113_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq113_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F7140", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F7140", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F7143", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F7143", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq114_map implements IEnumerable
    {
        IMFNode var1_cur;

        public seq114_map(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq114_map closure;
            IEnumerator var2_filter_elements_nodename;
            public Enumerator(seq114_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

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
                var2_filter_elements_nodename = (Core.filterElements("C703", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("C703", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq35_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq115_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq115_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq115_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("NAD", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("NAD", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq91_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("DTM", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("DTM", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq29_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq116_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq116_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq116_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("MEA", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("MEA", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq117_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("EQN", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("EQN", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq77_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq117_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq117_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq117_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F6311", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F6311", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F7383", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F7383", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("C502", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("C502", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq118_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("C174", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("C174", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq119_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq118_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq118_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq118_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F6313", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F6313", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F6321", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F6321", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F6155", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F6155", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F6154", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F6154", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq119_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq119_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq119_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F6411", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F6411", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F6314", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F6314", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F6162", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F6162", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F6152", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F6152", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("F6432", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("F6432", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var6_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq120_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq120_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq120_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("DIM", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("DIM", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq121_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("EQN", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("EQN", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq77_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq121_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq121_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq121_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F6145", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F6145", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("C211", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("C211", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq122_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq122_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq122_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq122_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F6411", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F6411", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F6168", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F6168", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F6140", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F6140", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F6008", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F6008", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq123_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq123_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq123_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("PCI", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("PCI", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq124_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("RFF", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("RFF", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq57_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("DTM", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("DTM", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq29_map(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("GIN", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("GIN", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq127_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq124_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq124_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq124_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F4233", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F4233", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F8275", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F8275", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("C210", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("C210", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq125_map(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("C827", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("C827", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq126_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq125_map implements IEnumerable
    {
        IMFNode var1_cur;

        public seq125_map(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq125_map closure;
            IEnumerator var2_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F7102", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F7102", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq126_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq126_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq126_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F7511", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F7511", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq127_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq127_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq127_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F7405", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F7405", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("C208", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("C208", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq128_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq128_map implements IEnumerable
    {
        IMFNode var1_cur;

        public seq128_map(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq128_map closure;
            IEnumerator var2_filter_elements_nodename;
            public Enumerator(seq128_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

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
                var2_filter_elements_nodename = (Core.filterElements("F7402", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F7402", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq129_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq129_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq129_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("GOR", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("GOR", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq60_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("DTM", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("DTM", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq29_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("LOC", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("LOC", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq49_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("SEL", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("SEL", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq62_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("FTX", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("FTX", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq40_join(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("SG26", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("SG26", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq64_join(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq130_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq130_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq130_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("TPL", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("TPL", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq99_map(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("SG28", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("SG28", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq116_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq131_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq131_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq131_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("SGP", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("SGP", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq132_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("SG30", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("SG30", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq116_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq132_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq132_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq132_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F7224", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F7224", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("C237", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("C237", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq133_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq133_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq133_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq133_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F8260", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8260", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F3207", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F3207", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq134_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq134_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq134_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("TCC", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("TCC", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq70_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("CUX", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("CUX", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq36_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("PRI", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("PRI", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq75_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("EQN", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("EQN", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq77_map(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("PCD", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("PCD", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq79_map(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("MOA", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("MOA", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq38_map(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (Core.filterElements("QTY", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = Core.createElement(Core.createQName("QTY", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq81_map(((IMFNode)(var8_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                var9_filter_elements_nodename = (Core.filterElements("LOC", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_filter_elements_nodename.moveNext()) {state = 24; return false; }
                current = Core.createElement(Core.createQName("LOC", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq49_join(((IMFNode)(var9_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 0;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq135_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq135_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq135_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("DGS", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("DGS", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq136_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("FTX", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("FTX", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq40_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("SG33", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("SG33", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq96_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("SG34", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("SG34", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq116_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("SG35", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("SG35", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq142_join(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 0;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq136_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq136_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq136_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
            IEnumerator var10_filter_elements_nodename;
            IEnumerator var11_filter_elements_nodename;
            IEnumerator var12_filter_elements_nodename;
            IEnumerator var13_filter_elements_nodename;
            IEnumerator var14_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F8273", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8273", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F8339", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F8339", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F8364", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F8364", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F8410", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F8410", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("F8126", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("F8126", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("F8255", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("F8255", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (Core.filterElements("F8325", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = Core.createElement(Core.createQName("F8325", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var8_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                var9_filter_elements_nodename = (Core.filterElements("F8211", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_filter_elements_nodename.moveNext()) {state = 24; return false; }
                current = Core.createElement(Core.createQName("F8211", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var9_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                var10_filter_elements_nodename = (Core.filterElements("C205", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_filter_elements_nodename.moveNext()) {state = 27; return false; }
                current = Core.createElement(Core.createQName("C205", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq137_join(((IMFNode)(var10_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 29;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                var11_filter_elements_nodename = (Core.filterElements("C234", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 29;
                if (!var11_filter_elements_nodename.moveNext()) {state = 30; return false; }
                current = Core.createElement(Core.createQName("C234", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq138_join(((IMFNode)(var11_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_30() throws Exception {
                state = 32;
                if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                var12_filter_elements_nodename = (Core.filterElements("C223", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_32() throws Exception {
                state = 32;
                if (!var12_filter_elements_nodename.moveNext()) {state = 33; return false; }
                current = Core.createElement(Core.createQName("C223", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq139_join(((IMFNode)(var12_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_33() throws Exception {
                state = 35;
                if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                var13_filter_elements_nodename = (Core.filterElements("C235", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_35() throws Exception {
                state = 35;
                if (!var13_filter_elements_nodename.moveNext()) {state = 36; return false; }
                current = Core.createElement(Core.createQName("C235", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq140_join(((IMFNode)(var13_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_36() throws Exception {
                state = 38;
                if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                var14_filter_elements_nodename = (Core.filterElements("C236", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_38() throws Exception {
                state = 38;
                if (!var14_filter_elements_nodename.moveNext()) {state = 39; return false; }
                current = Core.createElement(Core.createQName("C236", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq141_map(((IMFNode)(var14_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_39() throws Exception {
                state = 0;
                if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                    if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                    if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                    if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                    if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq137_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq137_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq137_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                        case 8:	if (moveNext_8()) return true; break;
                        case 9:	if (moveNext_9()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F8351", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8351", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F8078", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F8078", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F8092", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F8092", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq138_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq138_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq138_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F7124", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F7124", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F7088", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F7088", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq139_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq139_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq139_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F7106", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F7106", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.decimalToString(CoreTypes.parseDecimal(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F6411", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F6411", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq140_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq140_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq140_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F8158", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8158", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F8186", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F8186", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq141_map implements IEnumerable
    {
        IMFNode var1_cur;

        public seq141_map(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq141_map closure;
            IEnumerator var2_filter_elements_nodename;
            public Enumerator(seq141_map closure)
            {
                this.closure = closure;
            }

            public Object current() {return current;}

            public int position() {return pos;}

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
                var2_filter_elements_nodename = (Core.filterElements("F8246", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8246", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 0;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq142_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq142_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq142_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("SGP", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("SGP", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq132_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("SG36", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("SG36", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq116_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq143_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq143_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq143_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
            IEnumerator var8_filter_elements_nodename;
            IEnumerator var9_filter_elements_nodename;
            IEnumerator var10_filter_elements_nodename;
            IEnumerator var11_filter_elements_nodename;
            IEnumerator var12_filter_elements_nodename;
            IEnumerator var13_filter_elements_nodename;
            IEnumerator var14_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("EQD", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("EQD", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq144_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("EQN", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("EQN", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq77_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("TMD", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("TMD", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq110_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("MEA", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("MEA", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq117_join(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("DIM", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("DIM", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq121_join(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("SEL", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("SEL", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq62_join(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 20;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                var8_filter_elements_nodename = (Core.filterElements("TPL", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_20() throws Exception {
                state = 20;
                if (!var8_filter_elements_nodename.moveNext()) {state = 21; return false; }
                current = Core.createElement(Core.createQName("TPL", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq99_map(((IMFNode)(var8_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_21() throws Exception {
                state = 23;
                if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                var9_filter_elements_nodename = (Core.filterElements("HAN", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_23() throws Exception {
                state = 23;
                if (!var9_filter_elements_nodename.moveNext()) {state = 24; return false; }
                current = Core.createElement(Core.createQName("HAN", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq103_join(((IMFNode)(var9_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_24() throws Exception {
                state = 26;
                if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                var10_filter_elements_nodename = (Core.filterElements("TMP", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_26() throws Exception {
                state = 26;
                if (!var10_filter_elements_nodename.moveNext()) {state = 27; return false; }
                current = Core.createElement(Core.createQName("TMP", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq106_join(((IMFNode)(var10_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_27() throws Exception {
                state = 29;
                if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                var11_filter_elements_nodename = (Core.filterElements("FTX", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_29() throws Exception {
                state = 29;
                if (!var11_filter_elements_nodename.moveNext()) {state = 30; return false; }
                current = Core.createElement(Core.createQName("FTX", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq40_join(((IMFNode)(var11_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_30() throws Exception {
                state = 32;
                if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                var12_filter_elements_nodename = (Core.filterElements("SG38", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_32() throws Exception {
                state = 32;
                if (!var12_filter_elements_nodename.moveNext()) {state = 33; return false; }
                current = Core.createElement(Core.createQName("SG38", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq97_join(((IMFNode)(var12_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_33() throws Exception {
                state = 35;
                if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                var13_filter_elements_nodename = (Core.filterElements("SG39", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_35() throws Exception {
                state = 35;
                if (!var13_filter_elements_nodename.moveNext()) {state = 36; return false; }
                current = Core.createElement(Core.createQName("SG39", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq146_join(((IMFNode)(var13_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_36() throws Exception {
                state = 38;
                if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                var14_filter_elements_nodename = (Core.filterElements("SG41", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_38() throws Exception {
                state = 38;
                if (!var14_filter_elements_nodename.moveNext()) {state = 39; return false; }
                current = Core.createElement(Core.createQName("SG41", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq147_join(((IMFNode)(var14_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_39() throws Exception {
                state = 0;
                if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                    if( var8_filter_elements_nodename != null ) { var8_filter_elements_nodename.close(); var8_filter_elements_nodename = null; }
                    if( var9_filter_elements_nodename != null ) { var9_filter_elements_nodename.close(); var9_filter_elements_nodename = null; }
                    if( var10_filter_elements_nodename != null ) { var10_filter_elements_nodename.close(); var10_filter_elements_nodename = null; }
                    if( var11_filter_elements_nodename != null ) { var11_filter_elements_nodename.close(); var11_filter_elements_nodename = null; }
                    if( var12_filter_elements_nodename != null ) { var12_filter_elements_nodename.close(); var12_filter_elements_nodename = null; }
                    if( var13_filter_elements_nodename != null ) { var13_filter_elements_nodename.close(); var13_filter_elements_nodename = null; }
                    if( var14_filter_elements_nodename != null ) { var14_filter_elements_nodename.close(); var14_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq144_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq144_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq144_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
            IEnumerator var6_filter_elements_nodename;
            IEnumerator var7_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F8053", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8053", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F8077", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F8077", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F8249", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F8249", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F8169", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F8169", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 14;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                var6_filter_elements_nodename = (Core.filterElements("C237", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_14() throws Exception {
                state = 14;
                if (!var6_filter_elements_nodename.moveNext()) {state = 15; return false; }
                current = Core.createElement(Core.createQName("C237", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq133_join(((IMFNode)(var6_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_15() throws Exception {
                state = 17;
                if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                var7_filter_elements_nodename = (Core.filterElements("C224", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_17() throws Exception {
                state = 17;
                if (!var7_filter_elements_nodename.moveNext()) {state = 18; return false; }
                current = Core.createElement(Core.createQName("C224", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq145_join(((IMFNode)(var7_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_18() throws Exception {
                state = 0;
                if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                    if( var6_filter_elements_nodename != null ) { var6_filter_elements_nodename.close(); var6_filter_elements_nodename = null; }
                    if( var7_filter_elements_nodename != null ) { var7_filter_elements_nodename.close(); var7_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq145_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq145_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq145_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
            IEnumerator var5_filter_elements_nodename;
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
                        case 11:	if (moveNext_11()) return true; break;
                        case 12:	if (moveNext_12()) return true; break;
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("F8155", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8155", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("F1131", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("F1131", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("F3055", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("F3055", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 11;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                var5_filter_elements_nodename = (Core.filterElements("F8154", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_11() throws Exception {
                state = 11;
                if (!var5_filter_elements_nodename.moveNext()) {state = 12; return false; }
                current = Core.createElement(Core.createQName("F8154", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var5_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_12() throws Exception {
                state = 0;
                if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                    if( var5_filter_elements_nodename != null ) { var5_filter_elements_nodename.close(); var5_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq146_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq146_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq146_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
            IEnumerator var4_filter_elements_nodename;
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
                    }
                }
                return false;
            }

            private boolean moveNext_1() throws Exception {
                state = 2;
                var2_filter_elements_nodename = (Core.filterElements("NAD", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("NAD", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq91_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("DTM", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("DTM", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq29_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 8;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                var4_filter_elements_nodename = (Core.filterElements("SG40", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_8() throws Exception {
                state = 8;
                if (!var4_filter_elements_nodename.moveNext()) {state = 9; return false; }
                current = Core.createElement(Core.createQName("SG40", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq96_join(((IMFNode)(var4_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_9() throws Exception {
                state = 0;
                if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                    if( var4_filter_elements_nodename != null ) { var4_filter_elements_nodename.close(); var4_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq147_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq147_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq147_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("EQA", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("EQA", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq148_join(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("EQN", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("EQN", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq77_map(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class seq148_join implements IEnumerable
    {
        IMFNode var1_cur;

        public seq148_join(IMFNode var1_cur)
        {
            this.var1_cur = var1_cur;
        }

        public IEnumerator enumerator() {return new Enumerator(this);}

        public static class Enumerator implements IEnumerator
        {
            int pos = 0;
            int state = 1;
            Object current;
            seq148_join closure;
            IEnumerator var2_filter_elements_nodename;
            IEnumerator var3_filter_elements_nodename;
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
                var2_filter_elements_nodename = (Core.filterElements("F8053", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_2() throws Exception {
                state = 2;
                if (!var2_filter_elements_nodename.moveNext()) {state = 3; return false; }
                current = Core.createElement(Core.createQName("F8053", "http://www.blujaysolutions.com/2017/IFTMIN"), Core.box(CoreTypes.nodeToString(((IMFNode)(var2_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_3() throws Exception {
                state = 5;
                if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                var3_filter_elements_nodename = (Core.filterElements("C237", closure.var1_cur)).enumerator();
                return false;
            }
            private boolean moveNext_5() throws Exception {
                state = 5;
                if (!var3_filter_elements_nodename.moveNext()) {state = 6; return false; }
                current = Core.createElement(Core.createQName("C237", "http://www.blujaysolutions.com/2017/IFTMIN"), (new seq133_join(((IMFNode)(var3_filter_elements_nodename.current())))));
                pos++;
                return true;
            }
            private boolean moveNext_6() throws Exception {
                state = 0;
                if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                return false;
            }


            public void close()
            {
                try
                {
                    if( var2_filter_elements_nodename != null ) { var2_filter_elements_nodename.close(); var2_filter_elements_nodename = null; }
                    if( var3_filter_elements_nodename != null ) { var3_filter_elements_nodename.close(); var3_filter_elements_nodename = null; }
                }
                catch (Exception e)
                {
                }
            }
        }

    }
    static class Outer implements IEnumerable
    {
        IMFNode var1_IFTMIN_Instance;

        public Outer(IMFNode var1_IFTMIN_Instance)
        {
            this.var1_IFTMIN_Instance = var1_IFTMIN_Instance;
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
                var2_box = ((new main(closure.var1_IFTMIN_Instance))).enumerator();
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
    protected ITextNode varIFTMINInstance;

    public void run(String IFTMINSourceFilename, String IFTMIN_D96A2TargetFilename) throws Exception {
        // open source streams
        writeTrace("Loading " + IFTMINSourceFilename + "...\n");
        FileInput IFTMINSource = new FileInput(IFTMINSourceFilename);
        // open target stream
        FileOutput IFTMIN_D96A2Target = new FileOutput(IFTMIN_D96A2TargetFilename);

        // run

        run(IFTMINSource, IFTMIN_D96A2Target);

        // close source streams
        IFTMINSource.close();
        // close target stream
        writeTrace("Saving " + IFTMIN_D96A2TargetFilename + "...\n");
        IFTMIN_D96A2Target.close();
    }


    // main entry point

    public void run(Input IFTMINSource, Output IFTMIN_D96A2Target) throws Exception {
        // Open the source(s)
        writeTrace("Parsing Text...\n");
        IFTMIND96AUTF8Envelope IFTMINDocument = new IFTMIND96AUTF8Envelope();
        IFTMINDocument.setEncoding( "UTF-8", false, false );
        IFTMINDocument.parse(IFTMINSource);
        varIFTMINInstance = IFTMINDocument.getGenerator();

        if (runDoesCloseAll)
            IFTMINSource.close();

        // Create the target
        org.w3c.dom.Document IFTMIN_D96A2Doc = (IFTMIN_D96A2Target.getType() == Output.IO_DOM) ? IFTMIN_D96A2Target.getDocument() : XmlTreeOperations.createDocument();

        // Execute mapping

        main mapping = new main(new TextDocumentAsMFNodeAdapter(varIFTMINInstance, IFTMINSource.getFilename()));

        MFDOMWriter.write(mapping, IFTMIN_D96A2Doc);
        // Close the target
        XmlTreeOperations.saveDocument(IFTMIN_D96A2Doc, IFTMIN_D96A2Target, "UTF-8", false, false, true, false);


        if (runDoesCloseAll)
        {
            IFTMINSource.close();
            IFTMIN_D96A2Target.close();
        }
    }
}
