package org.assimbly.edifactstandards.xml.transformer;

import org.assimbly.edifactstandards.xml.envelope.IFTSTAD96AEnvelope;

import org.assimbly.edifactcommon.mapforce.IEnumerable;
import org.assimbly.edifactcommon.mapforce.IEnumerator;
import org.assimbly.edifactcommon.xml.XmlTreeOperations;
import java.util.*;

public class IFTSTAD96ATransformer extends org.assimbly.edifactcommon.TraceProvider
{
	private boolean runDoesCloseAll = true;
	public void setCloseObjectsAfterRun(boolean c) {runDoesCloseAll = c;}
	public boolean getCloseObjectsAfterRun() {return runDoesCloseAll;}

	
	static class main implements IEnumerable
	{
		org.assimbly.edifactcommon.mapforce.IMFNode var1_IFTSTA_D96A_Instance;
	
		public main(org.assimbly.edifactcommon.mapforce.IMFNode var1_IFTSTA_D96A_Instance)
		{
			this.var1_IFTSTA_D96A_Instance = var1_IFTSTA_D96A_Instance;
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
				var2_Envelope = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("Envelope", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_IFTSTA_D96A_Instance)).enumerator();
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
				var2_Interchange = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("Interchange", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_UNB = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNB", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_Group = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("Group", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_UNZ = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNZ", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_8() throws Exception {
				state = 8;				
				if (!var4_UNZ.moveNext()) {state = 9; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("UNZ", (new seq100_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_UNZ.current())))));
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
				var2_F0020 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0020", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0026 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0026", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F0029 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0029", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F0031 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0031", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var6_F0032 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0032", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var7_F0035 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0035", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var8_S001 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S001", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var9_S002 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S002", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var10_S003 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S003", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var11_S004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S004", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var12_S005 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S005", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_F0001 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0001", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0002 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0002", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F0080 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0080", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F0133 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0133", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var6_F0076 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0076", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_F0004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0004", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0007 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0007", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F0008 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0008", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F0042 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0042", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_F0010 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0010", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0007 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0007", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F0014 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0014", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F0046 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0046", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_F0017 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0017", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0019 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0019", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_F0022 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0022", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0025 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0025", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var3_Message_IFTSTA;
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
				var2_UNG = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNG", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_Message_IFTSTA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("Message_IFTSTA", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_Message_IFTSTA.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("Message_IFTSTA", (new seq14_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_Message_IFTSTA.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_6() throws Exception {
				state = 8;				
				if( var3_Message_IFTSTA != null ) { var3_Message_IFTSTA.close(); var3_Message_IFTSTA = null; }
				var4_UNE = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNE", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_8() throws Exception {
				state = 8;				
				if (!var4_UNE.moveNext()) {state = 9; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("UNE", (new seq99_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_UNE.current())))));
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
				if( var3_Message_IFTSTA != null ) { var3_Message_IFTSTA.close(); var3_Message_IFTSTA = null; }
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
				var2_F0038 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0038", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0048 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0048", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F0051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0051", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F0058 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0058", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var6_S006 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S006", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var7_S007 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S007", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var8_S004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S004", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var9_S008 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S008", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_F0040 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0040", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0007 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0007", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_F0044 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0044", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0007 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0007", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_F0052 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0052", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0054 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0054", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F0057 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0057", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var5_TSR;
			IEnumerator var6_SG1;
			IEnumerator var7_SG3;
			IEnumerator var8_LOC;
			IEnumerator var9_FTX;
			IEnumerator var10_CNT;
			IEnumerator var11_SG4;
			IEnumerator var12_UNT;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_UNH = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNH", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_BGM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("BGM", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_TSR = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TSR", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_11() throws Exception {
				state = 11;				
				if (!var5_TSR.moveNext()) {state = 12; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("TSR", (new seq25_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_TSR.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_12() throws Exception {
				state = 14;				
				if( var5_TSR != null ) { var5_TSR.close(); var5_TSR = null; }
				var6_SG1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG1", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_14() throws Exception {
				state = 14;				
				if (!var6_SG1.moveNext()) {state = 15; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("SG1", (new seq30_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_SG1.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_15() throws Exception {
				state = 17;				
				if( var6_SG1 != null ) { var6_SG1.close(); var6_SG1 = null; }
				var7_SG3 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG3", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_17() throws Exception {
				state = 17;				
				if (!var7_SG3.moveNext()) {state = 18; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("SG3", (new seq41_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_SG3.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_18() throws Exception {
				state = 20;				
				if( var7_SG3 != null ) { var7_SG3.close(); var7_SG3 = null; }
				var8_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_20() throws Exception {
				state = 20;				
				if (!var8_LOC.moveNext()) {state = 21; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq44_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_LOC.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_21() throws Exception {
				state = 23;				
				if( var8_LOC != null ) { var8_LOC.close(); var8_LOC = null; }
				var9_FTX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FTX", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_23() throws Exception {
				state = 23;				
				if (!var9_FTX.moveNext()) {state = 24; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("FTX", (new seq48_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_FTX.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_24() throws Exception {
				state = 26;				
				if( var9_FTX != null ) { var9_FTX.close(); var9_FTX = null; }
				var10_CNT = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CNT", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_26() throws Exception {
				state = 26;				
				if (!var10_CNT.moveNext()) {state = 27; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("CNT", (new seq51_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_CNT.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_27() throws Exception {
				state = 29;				
				if( var10_CNT != null ) { var10_CNT.close(); var10_CNT = null; }
				var11_SG4 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG4", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_29() throws Exception {
				state = 29;				
				if (!var11_SG4.moveNext()) {state = 30; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("SG4", (new seq53_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_SG4.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_30() throws Exception {
				state = 32;				
				if( var11_SG4 != null ) { var11_SG4.close(); var11_SG4 = null; }
				var12_UNT = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("UNT", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_32() throws Exception {
				state = 32;				
				if (!var12_UNT.moveNext()) {state = 33; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("UNT", (new seq98_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var12_UNT.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_33() throws Exception {
				state = 0;				
				if( var12_UNT != null ) { var12_UNT.close(); var12_UNT = null; }
				return false;
			}

			
			public void close()
			{
				try
				{
				if( var2_UNH != null ) { var2_UNH.close(); var2_UNH = null; }
				if( var3_BGM != null ) { var3_BGM.close(); var3_BGM = null; }
				if( var4_DTM != null ) { var4_DTM.close(); var4_DTM = null; }
				if( var5_TSR != null ) { var5_TSR.close(); var5_TSR = null; }
				if( var6_SG1 != null ) { var6_SG1.close(); var6_SG1 = null; }
				if( var7_SG3 != null ) { var7_SG3.close(); var7_SG3 = null; }
				if( var8_LOC != null ) { var8_LOC.close(); var8_LOC = null; }
				if( var9_FTX != null ) { var9_FTX.close(); var9_FTX = null; }
				if( var10_CNT != null ) { var10_CNT.close(); var10_CNT = null; }
				if( var11_SG4 != null ) { var11_SG4.close(); var11_SG4 = null; }
				if( var12_UNT != null ) { var12_UNT.close(); var12_UNT = null; }
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
				var2_F0062 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0062", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0068 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0068", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_S009 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S009", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_S010 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S010", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var6_S016 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S016", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var7_S017 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S017", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var8_S018 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("S018", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_F0065 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0065", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0052 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0052", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F0054 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0054", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F0051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0051", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var6_F0057 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0057", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var7_F0110 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0110", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var8_F0113 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0113", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_F0070 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0070", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0073 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0073", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_F0115 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0115", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0116 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0116", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F0118 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0118", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F0051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0051", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_F0121 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0121", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0122 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0122", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F0124 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0124", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F0051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0051", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_F0127 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0127", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0128 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0128", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F0130 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0130", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F0051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0051", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_F1004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1004", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1225 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1225", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F4343 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4343", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_C002 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C002", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_F1001 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1001", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F1000 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1000", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_C507 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C507", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var2_F2005 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F2005", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F2380 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F2380", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F2379 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F2379", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_C536;
			IEnumerator var3_C233;
			IEnumerator var4_C537;
			IEnumerator var5_C703;
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
				var2_C536 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C536", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_C536.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C536", (new seq26_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C536.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_C536 != null ) { var2_C536.close(); var2_C536 = null; }
				var3_C233 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C233", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_C233.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C233", (new seq27_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C233.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_6() throws Exception {
				state = 8;				
				if( var3_C233 != null ) { var3_C233.close(); var3_C233 = null; }
				var4_C537 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C537", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_8() throws Exception {
				state = 8;				
				if (!var4_C537.moveNext()) {state = 9; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C537", (new seq28_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C537.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_9() throws Exception {
				state = 11;				
				if( var4_C537 != null ) { var4_C537.close(); var4_C537 = null; }
				var5_C703 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C703", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_11() throws Exception {
				state = 11;				
				if (!var5_C703.moveNext()) {state = 12; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C703", (new seq29_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C703.current())))));
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
			IEnumerator var2_F4065;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F4065 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4065", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F7273_1;
			IEnumerator var3_F1131_1;
			IEnumerator var4_F3055_1;
			IEnumerator var5_F7273_2;
			IEnumerator var6_F1131_2;
			IEnumerator var7_F3055_2;
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
				var2_F7273_1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7273_1", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131_1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131_1", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055_1 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055_1", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F7273_2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7273_2", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var6_F1131_2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131_2", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var7_F3055_2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055_2", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F4219;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F4219 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4219", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F7085;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
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
				var2_F7085 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7085", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_NAD;
			IEnumerator var3_SG2;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_NAD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("NAD", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_NAD.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("NAD", (new seq31_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_NAD.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_NAD != null ) { var2_NAD.close(); var2_NAD = null; }
				var3_SG2 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG2", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_SG2.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("SG2", (new seq36_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_SG2.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_6() throws Exception {
				state = 0;				
				if( var3_SG2 != null ) { var3_SG2.close(); var3_SG2 = null; }
				return false;
			}

			
			public void close()
			{
				try
				{
				if( var2_NAD != null ) { var2_NAD.close(); var2_NAD = null; }
				if( var3_SG2 != null ) { var3_SG2.close(); var3_SG2 = null; }
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
			IEnumerator var2_F3035;
			IEnumerator var3_F3164;
			IEnumerator var4_F3229;
			IEnumerator var5_F3251;
			IEnumerator var6_F3207;
			IEnumerator var7_C082;
			IEnumerator var8_C058;
			IEnumerator var9_C080;
			IEnumerator var10_C059;
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
				var2_F3035 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3035", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F3164 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3164", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3229 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3229", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F3251 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3251", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var6_F3207 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3207", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var7_C082 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C082", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_17() throws Exception {
				state = 17;				
				if (!var7_C082.moveNext()) {state = 18; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C082", (new seq32_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_C082.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_18() throws Exception {
				state = 20;				
				if( var7_C082 != null ) { var7_C082.close(); var7_C082 = null; }
				var8_C058 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C058", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_20() throws Exception {
				state = 20;				
				if (!var8_C058.moveNext()) {state = 21; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C058", (new seq33_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_C058.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_21() throws Exception {
				state = 23;				
				if( var8_C058 != null ) { var8_C058.close(); var8_C058 = null; }
				var9_C080 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C080", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_23() throws Exception {
				state = 23;				
				if (!var9_C080.moveNext()) {state = 24; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C080", (new seq34_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_C080.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_24() throws Exception {
				state = 26;				
				if( var9_C080 != null ) { var9_C080.close(); var9_C080 = null; }
				var10_C059 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C059", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_26() throws Exception {
				state = 26;				
				if (!var10_C059.moveNext()) {state = 27; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C059", (new seq35_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_C059.current())))));
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
			IEnumerator var2_F3039;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
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
				var2_F3039 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3039", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
	static class seq33_map implements IEnumerable
	{
		org.assimbly.edifactcommon.mapforce.IMFNode var1_current;
	
		public seq33_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
		{
			this.var1_current = var1_current;
		}

		public IEnumerator enumerator() {return new Enumerator(this);}
		
		public static class Enumerator implements IEnumerator
		{
			int pos = 0;
			int state = 1;
			Object current;
			seq33_map closure;
			IEnumerator var2_F3124;
			public Enumerator(seq33_map closure) 
			{
				this.closure = closure;
			}
			
			public Object current() {return current;}
			
			public int position() {return pos;}
			
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
				var2_F3124 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3124", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F3036;
			IEnumerator var3_F3045;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F3036 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3036", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F3045 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3045", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
	static class seq35_map implements IEnumerable
	{
		org.assimbly.edifactcommon.mapforce.IMFNode var1_current;
	
		public seq35_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
		{
			this.var1_current = var1_current;
		}

		public IEnumerator enumerator() {return new Enumerator(this);}
		
		public static class Enumerator implements IEnumerator
		{
			int pos = 0;
			int state = 1;
			Object current;
			seq35_map closure;
			IEnumerator var2_F3042;
			public Enumerator(seq35_map closure) 
			{
				this.closure = closure;
			}
			
			public Object current() {return current;}
			
			public int position() {return pos;}
			
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
				var2_F3042 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3042", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_CTA;
			IEnumerator var3_COM;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_CTA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CTA", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_CTA.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("CTA", (new seq37_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_CTA.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_CTA != null ) { var2_CTA.close(); var2_CTA = null; }
				var3_COM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("COM", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_COM.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("COM", (new seq39_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_COM.current())))));
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
			IEnumerator var2_F3139;
			IEnumerator var3_C056;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F3139 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3139", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_C056 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C056", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_C056.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C056", (new seq38_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C056.current())))));
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
			IEnumerator var2_F3413;
			IEnumerator var3_F3412;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F3413 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3413", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F3412 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3412", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_C076;
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
				var2_C076 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C076", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_C076.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C076", (new seq40_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C076.current())))));
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
			IEnumerator var2_F3148;
			IEnumerator var3_F3155;
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
				var2_F3148 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3148", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F3155 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3155", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
	static class seq41_join implements IEnumerable
	{
		org.assimbly.edifactcommon.mapforce.IMFNode var1_current;
	
		public seq41_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
		{
			this.var1_current = var1_current;
		}

		public IEnumerator enumerator() {return new Enumerator(this);}
		
		public static class Enumerator implements IEnumerator
		{
			int pos = 0;
			int state = 1;
			Object current;
			seq41_join closure;
			IEnumerator var2_RFF;
			IEnumerator var3_DTM;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_RFF = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RFF", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_RFF.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("RFF", (new seq42_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_RFF.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_RFF != null ) { var2_RFF.close(); var2_RFF = null; }
				var3_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_C506;
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
				var2_C506 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C506", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_C506.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C506", (new seq43_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C506.current())))));
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
			IEnumerator var2_F1153;
			IEnumerator var3_F1154;
			IEnumerator var4_F1156;
			IEnumerator var5_F4000;
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
				var2_F1153 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1153", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1154 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1154", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F1156 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1156", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F4000 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4000", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F3227;
			IEnumerator var3_F5479;
			IEnumerator var4_C517;
			IEnumerator var5_C519;
			IEnumerator var6_C553;
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
				var2_F3227 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3227", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F5479 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F5479", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_C517 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C517", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_8() throws Exception {
				state = 8;				
				if (!var4_C517.moveNext()) {state = 9; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C517", (new seq45_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C517.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_9() throws Exception {
				state = 11;				
				if( var4_C517 != null ) { var4_C517.close(); var4_C517 = null; }
				var5_C519 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C519", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_11() throws Exception {
				state = 11;				
				if (!var5_C519.moveNext()) {state = 12; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C519", (new seq46_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C519.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_12() throws Exception {
				state = 14;				
				if( var5_C519 != null ) { var5_C519.close(); var5_C519 = null; }
				var6_C553 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C553", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_14() throws Exception {
				state = 14;				
				if (!var6_C553.moveNext()) {state = 15; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C553", (new seq47_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C553.current())))));
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
			IEnumerator var2_F3225;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
			IEnumerator var5_F3224;
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
				var2_F3225 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3225", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F3224 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3224", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F3223;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
			IEnumerator var5_F3222;
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
				var2_F3223 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3223", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F3222 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3222", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F3233;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
			IEnumerator var5_F3232;
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
					case 11:	if (moveNext_11()) return true; break;
					case 12:	if (moveNext_12()) return true; break;
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F3233 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3233", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F3232 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3232", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F4451;
			IEnumerator var3_F4453;
			IEnumerator var4_F3453;
			IEnumerator var5_C107;
			IEnumerator var6_C108;
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
				var2_F4451 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4451", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F4453 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4453", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3453 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3453", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_C107 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C107", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_11() throws Exception {
				state = 11;				
				if (!var5_C107.moveNext()) {state = 12; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C107", (new seq49_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C107.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_12() throws Exception {
				state = 14;				
				if( var5_C107 != null ) { var5_C107.close(); var5_C107 = null; }
				var6_C108 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C108", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_14() throws Exception {
				state = 14;				
				if (!var6_C108.moveNext()) {state = 15; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C108", (new seq50_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C108.current())))));
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
			IEnumerator var2_F4441;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F4441 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4441", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
	static class seq50_map implements IEnumerable
	{
		org.assimbly.edifactcommon.mapforce.IMFNode var1_current;
	
		public seq50_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
		{
			this.var1_current = var1_current;
		}

		public IEnumerator enumerator() {return new Enumerator(this);}
		
		public static class Enumerator implements IEnumerator
		{
			int pos = 0;
			int state = 1;
			Object current;
			seq50_map closure;
			IEnumerator var2_F4440;
			public Enumerator(seq50_map closure) 
			{
				this.closure = closure;
			}
			
			public Object current() {return current;}
			
			public int position() {return pos;}
			
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
				var2_F4440 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4440", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
	static class seq51_map implements IEnumerable
	{
		org.assimbly.edifactcommon.mapforce.IMFNode var1_current;
	
		public seq51_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
		{
			this.var1_current = var1_current;
		}

		public IEnumerator enumerator() {return new Enumerator(this);}
		
		public static class Enumerator implements IEnumerator
		{
			int pos = 0;
			int state = 1;
			Object current;
			seq51_map closure;
			IEnumerator var2_C270;
			public Enumerator(seq51_map closure) 
			{
				this.closure = closure;
			}
			
			public Object current() {return current;}
			
			public int position() {return pos;}
			
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
				var2_C270 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C270", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_C270.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C270", (new seq52_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C270.current())))));
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
			IEnumerator var2_F6069;
			IEnumerator var3_F6066;
			IEnumerator var4_F6411;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F6069 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6069", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F6066 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6066", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_CNI;
			IEnumerator var3_LOC;
			IEnumerator var4_CNT;
			IEnumerator var5_SG5;
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
					case 11:	if (moveNext_11()) return true; break;
					case 12:	if (moveNext_12()) return true; break;
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_CNI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CNI", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_CNI.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("CNI", (new seq54_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_CNI.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_CNI != null ) { var2_CNI.close(); var2_CNI = null; }
				var3_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_LOC.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq44_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_LOC.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_6() throws Exception {
				state = 8;				
				if( var3_LOC != null ) { var3_LOC.close(); var3_LOC = null; }
				var4_CNT = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("CNT", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_8() throws Exception {
				state = 8;				
				if (!var4_CNT.moveNext()) {state = 9; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("CNT", (new seq51_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_CNT.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_9() throws Exception {
				state = 11;				
				if( var4_CNT != null ) { var4_CNT.close(); var4_CNT = null; }
				var5_SG5 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG5", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_11() throws Exception {
				state = 11;				
				if (!var5_SG5.moveNext()) {state = 12; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("SG5", (new seq56_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_SG5.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_12() throws Exception {
				state = 0;				
				if( var5_SG5 != null ) { var5_SG5.close(); var5_SG5 = null; }
				return false;
			}

			
			public void close()
			{
				try
				{
				if( var2_CNI != null ) { var2_CNI.close(); var2_CNI = null; }
				if( var3_LOC != null ) { var3_LOC.close(); var3_LOC = null; }
				if( var4_CNT != null ) { var4_CNT.close(); var4_CNT = null; }
				if( var5_SG5 != null ) { var5_SG5.close(); var5_SG5 = null; }
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
			IEnumerator var2_F1490;
			IEnumerator var3_F1312;
			IEnumerator var4_C503;
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
				var2_F1490 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1490", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_F1490.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("F1490", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F1490.current())))))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_F1490 != null ) { var2_F1490.close(); var2_F1490 = null; }
				var3_F1312 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1312", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_F1312.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("F1312", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.decimalToString(org.assimbly.edifactcommon.CoreTypes.parseDecimal(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_F1312.current())))))));
				pos++;
				return true;
			}
			private boolean moveNext_6() throws Exception {
				state = 8;				
				if( var3_F1312 != null ) { var3_F1312.close(); var3_F1312 = null; }
				var4_C503 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C503", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_8() throws Exception {
				state = 8;				
				if (!var4_C503.moveNext()) {state = 9; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C503", (new seq55_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C503.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_9() throws Exception {
				state = 0;				
				if( var4_C503 != null ) { var4_C503.close(); var4_C503 = null; }
				return false;
			}

			
			public void close()
			{
				try
				{
				if( var2_F1490 != null ) { var2_F1490.close(); var2_F1490 = null; }
				if( var3_F1312 != null ) { var3_F1312.close(); var3_F1312 = null; }
				if( var4_C503 != null ) { var4_C503.close(); var4_C503 = null; }
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
			IEnumerator var2_F1004;
			IEnumerator var3_F1373;
			IEnumerator var4_F1366;
			IEnumerator var5_F3453;
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
				var2_F1004 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1004", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1373 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1373", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F1366 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1366", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F3453 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3453", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_STS;
			IEnumerator var3_RFF;
			IEnumerator var4_DTM;
			IEnumerator var5_DOC;
			IEnumerator var6_FTX;
			IEnumerator var7_NAD;
			IEnumerator var8_LOC;
			IEnumerator var9_PCI;
			IEnumerator var10_SG6;
			IEnumerator var11_SG7;
			IEnumerator var12_SG9;
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
				var2_STS = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("STS", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_STS.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("STS", (new seq57_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_STS.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_STS != null ) { var2_STS.close(); var2_STS = null; }
				var3_RFF = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RFF", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_RFF.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("RFF", (new seq42_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_RFF.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_6() throws Exception {
				state = 8;				
				if( var3_RFF != null ) { var3_RFF.close(); var3_RFF = null; }
				var4_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_DOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DOC", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_11() throws Exception {
				state = 11;				
				if (!var5_DOC.moveNext()) {state = 12; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("DOC", (new seq61_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_DOC.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_12() throws Exception {
				state = 14;				
				if( var5_DOC != null ) { var5_DOC.close(); var5_DOC = null; }
				var6_FTX = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("FTX", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_14() throws Exception {
				state = 14;				
				if (!var6_FTX.moveNext()) {state = 15; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("FTX", (new seq48_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_FTX.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_15() throws Exception {
				state = 17;				
				if( var6_FTX != null ) { var6_FTX.close(); var6_FTX = null; }
				var7_NAD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("NAD", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_17() throws Exception {
				state = 17;				
				if (!var7_NAD.moveNext()) {state = 18; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("NAD", (new seq31_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_NAD.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_18() throws Exception {
				state = 20;				
				if( var7_NAD != null ) { var7_NAD.close(); var7_NAD = null; }
				var8_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_20() throws Exception {
				state = 20;				
				if (!var8_LOC.moveNext()) {state = 21; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq44_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_LOC.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_21() throws Exception {
				state = 23;				
				if( var8_LOC != null ) { var8_LOC.close(); var8_LOC = null; }
				var9_PCI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PCI", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_23() throws Exception {
				state = 23;				
				if (!var9_PCI.moveNext()) {state = 24; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("PCI", (new seq62_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_PCI.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_24() throws Exception {
				state = 26;				
				if( var9_PCI != null ) { var9_PCI.close(); var9_PCI = null; }
				var10_SG6 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG6", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_26() throws Exception {
				state = 26;				
				if (!var10_SG6.moveNext()) {state = 27; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("SG6", (new seq65_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_SG6.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_27() throws Exception {
				state = 29;				
				if( var10_SG6 != null ) { var10_SG6.close(); var10_SG6 = null; }
				var11_SG7 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG7", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_29() throws Exception {
				state = 29;				
				if (!var11_SG7.moveNext()) {state = 30; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("SG7", (new seq72_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var11_SG7.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_30() throws Exception {
				state = 32;				
				if( var11_SG7 != null ) { var11_SG7.close(); var11_SG7 = null; }
				var12_SG9 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG9", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_32() throws Exception {
				state = 32;				
				if (!var12_SG9.moveNext()) {state = 33; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("SG9", (new seq85_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var12_SG9.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_33() throws Exception {
				state = 0;				
				if( var12_SG9 != null ) { var12_SG9.close(); var12_SG9 = null; }
				return false;
			}

			
			public void close()
			{
				try
				{
				if( var2_STS != null ) { var2_STS.close(); var2_STS = null; }
				if( var3_RFF != null ) { var3_RFF.close(); var3_RFF = null; }
				if( var4_DTM != null ) { var4_DTM.close(); var4_DTM = null; }
				if( var5_DOC != null ) { var5_DOC.close(); var5_DOC = null; }
				if( var6_FTX != null ) { var6_FTX.close(); var6_FTX = null; }
				if( var7_NAD != null ) { var7_NAD.close(); var7_NAD = null; }
				if( var8_LOC != null ) { var8_LOC.close(); var8_LOC = null; }
				if( var9_PCI != null ) { var9_PCI.close(); var9_PCI = null; }
				if( var10_SG6 != null ) { var10_SG6.close(); var10_SG6 = null; }
				if( var11_SG7 != null ) { var11_SG7.close(); var11_SG7 = null; }
				if( var12_SG9 != null ) { var12_SG9.close(); var12_SG9 = null; }
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
			IEnumerator var2_C601;
			IEnumerator var3_C555;
			IEnumerator var4_C556;
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
				var2_C601 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C601", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_C601.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C601", (new seq58_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C601.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_C601 != null ) { var2_C601.close(); var2_C601 = null; }
				var3_C555 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C555", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_C555.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C555", (new seq59_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C555.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_6() throws Exception {
				state = 8;				
				if( var3_C555 != null ) { var3_C555.close(); var3_C555 = null; }
				var4_C556 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C556", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_8() throws Exception {
				state = 8;				
				if (!var4_C556.moveNext()) {state = 9; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C556", (new seq60_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C556.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_9() throws Exception {
				state = 0;				
				if( var4_C556 != null ) { var4_C556.close(); var4_C556 = null; }
				return false;
			}

			
			public void close()
			{
				try
				{
				if( var2_C601 != null ) { var2_C601.close(); var2_C601 = null; }
				if( var3_C555 != null ) { var3_C555.close(); var3_C555 = null; }
				if( var4_C556 != null ) { var4_C556.close(); var4_C556 = null; }
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
			IEnumerator var2_F9015;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F9015 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F9015", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_F9015.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("F9015", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F9015.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_F9015 != null ) { var2_F9015.close(); var2_F9015 = null; }
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				if( var2_F9015 != null ) { var2_F9015.close(); var2_F9015 = null; }
				if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
				if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
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
			IEnumerator var2_F9011;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
			IEnumerator var5_F9010;
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
				var2_F9011 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F9011", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_F9011.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("F9011", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F9011.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_F9011 != null ) { var2_F9011.close(); var2_F9011 = null; }
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F9010 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F9010", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_11() throws Exception {
				state = 11;				
				if (!var5_F9010.moveNext()) {state = 12; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("F9010", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F9010.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_12() throws Exception {
				state = 0;				
				if( var5_F9010 != null ) { var5_F9010.close(); var5_F9010 = null; }
				return false;
			}

			
			public void close()
			{
				try
				{
				if( var2_F9011 != null ) { var2_F9011.close(); var2_F9011 = null; }
				if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
				if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
				if( var5_F9010 != null ) { var5_F9010.close(); var5_F9010 = null; }
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
			IEnumerator var2_F9013;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
			IEnumerator var5_F9012;
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
				var2_F9013 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F9013", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_F9013.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("F9013", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_F9013.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_F9013 != null ) { var2_F9013.close(); var2_F9013 = null; }
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F9012 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F9012", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_11() throws Exception {
				state = 11;				
				if (!var5_F9012.moveNext()) {state = 12; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("F9012", org.assimbly.edifactcommon.functions.Core.box(org.assimbly.edifactcommon.CoreTypes.nodeToString(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_F9012.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_12() throws Exception {
				state = 0;				
				if( var5_F9012 != null ) { var5_F9012.close(); var5_F9012 = null; }
				return false;
			}

			
			public void close()
			{
				try
				{
				if( var2_F9013 != null ) { var2_F9013.close(); var2_F9013 = null; }
				if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
				if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
				if( var5_F9012 != null ) { var5_F9012.close(); var5_F9012 = null; }
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
			IEnumerator var2_F3153;
			IEnumerator var3_F1220;
			IEnumerator var4_F1218;
			IEnumerator var5_C002;
			IEnumerator var6_C503;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F3153 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3153", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1220 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1220", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F1218 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1218", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_C002 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C002", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var6_C503 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C503", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_14() throws Exception {
				state = 14;				
				if (!var6_C503.moveNext()) {state = 15; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C503", (new seq55_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C503.current())))));
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
			IEnumerator var2_F4233;
			IEnumerator var3_F8275;
			IEnumerator var4_C210;
			IEnumerator var5_C827;
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
				var2_F4233 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4233", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F8275 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8275", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_C210 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C210", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_8() throws Exception {
				state = 8;				
				if (!var4_C210.moveNext()) {state = 9; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C210", (new seq63_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C210.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_9() throws Exception {
				state = 11;				
				if( var4_C210 != null ) { var4_C210.close(); var4_C210 = null; }
				var5_C827 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C827", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_11() throws Exception {
				state = 11;				
				if (!var5_C827.moveNext()) {state = 12; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C827", (new seq64_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C827.current())))));
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
			IEnumerator var2_F7102;
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
				var2_F7102 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7102", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F7511;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
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
					case 8:	if (moveNext_8()) return true; break;
					case 9:	if (moveNext_9()) return true; break;
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F7511 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7511", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_TDT;
			IEnumerator var3_RFF;
			IEnumerator var4_LOC;
			IEnumerator var5_DTM;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_TDT = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("TDT", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_TDT.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("TDT", (new seq66_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_TDT.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_TDT != null ) { var2_TDT.close(); var2_TDT = null; }
				var3_RFF = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("RFF", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_RFF.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("RFF", (new seq42_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_RFF.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_6() throws Exception {
				state = 8;				
				if( var3_RFF != null ) { var3_RFF.close(); var3_RFF = null; }
				var4_LOC = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("LOC", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_8() throws Exception {
				state = 8;				
				if (!var4_LOC.moveNext()) {state = 9; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("LOC", (new seq44_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_LOC.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_9() throws Exception {
				state = 11;				
				if( var4_LOC != null ) { var4_LOC.close(); var4_LOC = null; }
				var5_DTM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DTM", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				if( var2_TDT != null ) { var2_TDT.close(); var2_TDT = null; }
				if( var3_RFF != null ) { var3_RFF.close(); var3_RFF = null; }
				if( var4_LOC != null ) { var4_LOC.close(); var4_LOC = null; }
				if( var5_DTM != null ) { var5_DTM.close(); var5_DTM = null; }
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
			IEnumerator var2_F8051;
			IEnumerator var3_F8028;
			IEnumerator var4_F8101;
			IEnumerator var5_F8281;
			IEnumerator var6_C220;
			IEnumerator var7_C228;
			IEnumerator var8_C040;
			IEnumerator var9_C401;
			IEnumerator var10_C222;
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
				var2_F8051 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8051", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F8028 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8028", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F8101 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8101", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F8281 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8281", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var6_C220 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C220", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_14() throws Exception {
				state = 14;				
				if (!var6_C220.moveNext()) {state = 15; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C220", (new seq67_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C220.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_15() throws Exception {
				state = 17;				
				if( var6_C220 != null ) { var6_C220.close(); var6_C220 = null; }
				var7_C228 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C228", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_17() throws Exception {
				state = 17;				
				if (!var7_C228.moveNext()) {state = 18; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C228", (new seq68_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_C228.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_18() throws Exception {
				state = 20;				
				if( var7_C228 != null ) { var7_C228.close(); var7_C228 = null; }
				var8_C040 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C040", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_20() throws Exception {
				state = 20;				
				if (!var8_C040.moveNext()) {state = 21; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C040", (new seq69_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var8_C040.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_21() throws Exception {
				state = 23;				
				if( var8_C040 != null ) { var8_C040.close(); var8_C040 = null; }
				var9_C401 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C401", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_23() throws Exception {
				state = 23;				
				if (!var9_C401.moveNext()) {state = 24; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C401", (new seq70_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var9_C401.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_24() throws Exception {
				state = 26;				
				if( var9_C401 != null ) { var9_C401.close(); var9_C401 = null; }
				var10_C222 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C222", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_26() throws Exception {
				state = 26;				
				if (!var10_C222.moveNext()) {state = 27; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C222", (new seq71_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var10_C222.current())))));
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
			IEnumerator var2_F8067;
			IEnumerator var3_F8066;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F8067 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8067", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F8066 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8066", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F8179;
			IEnumerator var3_F8178;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F8179 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8179", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F8178 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8178", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F3127;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
			IEnumerator var5_F3128;
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
				var2_F3127 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3127", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F3128 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3128", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F8457;
			IEnumerator var3_F8459;
			IEnumerator var4_F7130;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F8457 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8457", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F8459 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8459", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F7130 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7130", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F8213;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
			IEnumerator var5_F8212;
			IEnumerator var6_F8453;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F8213 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8213", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F8212 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8212", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var6_F8453 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8453", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_EQD;
			IEnumerator var3_MEA;
			IEnumerator var4_DIM;
			IEnumerator var5_SEL;
			IEnumerator var6_SG8;
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
				var2_EQD = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("EQD", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_EQD.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("EQD", (new seq73_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_EQD.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_EQD != null ) { var2_EQD.close(); var2_EQD = null; }
				var3_MEA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MEA", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_MEA.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("MEA", (new seq76_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_MEA.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_6() throws Exception {
				state = 8;				
				if( var3_MEA != null ) { var3_MEA.close(); var3_MEA = null; }
				var4_DIM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DIM", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_8() throws Exception {
				state = 8;				
				if (!var4_DIM.moveNext()) {state = 9; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("DIM", (new seq79_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_DIM.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_9() throws Exception {
				state = 11;				
				if( var4_DIM != null ) { var4_DIM.close(); var4_DIM = null; }
				var5_SEL = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SEL", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_11() throws Exception {
				state = 11;				
				if (!var5_SEL.moveNext()) {state = 12; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("SEL", (new seq81_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_SEL.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_12() throws Exception {
				state = 14;				
				if( var5_SEL != null ) { var5_SEL.close(); var5_SEL = null; }
				var6_SG8 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG8", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_14() throws Exception {
				state = 14;				
				if (!var6_SG8.moveNext()) {state = 15; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("SG8", (new seq83_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_SG8.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_15() throws Exception {
				state = 0;				
				if( var6_SG8 != null ) { var6_SG8.close(); var6_SG8 = null; }
				return false;
			}

			
			public void close()
			{
				try
				{
				if( var2_EQD != null ) { var2_EQD.close(); var2_EQD = null; }
				if( var3_MEA != null ) { var3_MEA.close(); var3_MEA = null; }
				if( var4_DIM != null ) { var4_DIM.close(); var4_DIM = null; }
				if( var5_SEL != null ) { var5_SEL.close(); var5_SEL = null; }
				if( var6_SG8 != null ) { var6_SG8.close(); var6_SG8 = null; }
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
			IEnumerator var2_F8053;
			IEnumerator var3_F8077;
			IEnumerator var4_F8249;
			IEnumerator var5_F8169;
			IEnumerator var6_C237;
			IEnumerator var7_C224;
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
				var2_F8053 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8053", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F8077 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8077", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F8249 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8249", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F8169 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8169", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var6_C237 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C237", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_14() throws Exception {
				state = 14;				
				if (!var6_C237.moveNext()) {state = 15; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C237", (new seq74_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_C237.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_15() throws Exception {
				state = 17;				
				if( var6_C237 != null ) { var6_C237.close(); var6_C237 = null; }
				var7_C224 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C224", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_17() throws Exception {
				state = 17;				
				if (!var7_C224.moveNext()) {state = 18; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C224", (new seq75_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var7_C224.current())))));
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
			IEnumerator var2_F8260;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
			IEnumerator var5_F3207;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F8260 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8260", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F3207 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3207", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F8155;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
			IEnumerator var5_F8154;
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
				var2_F8155 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8155", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F8154 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8154", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F6311;
			IEnumerator var3_F7383;
			IEnumerator var4_C502;
			IEnumerator var5_C174;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F6311 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6311", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F7383 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7383", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_C502 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C502", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_8() throws Exception {
				state = 8;				
				if (!var4_C502.moveNext()) {state = 9; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C502", (new seq77_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C502.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_9() throws Exception {
				state = 11;				
				if( var4_C502 != null ) { var4_C502.close(); var4_C502 = null; }
				var5_C174 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C174", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_11() throws Exception {
				state = 11;				
				if (!var5_C174.moveNext()) {state = 12; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C174", (new seq78_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_C174.current())))));
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
			IEnumerator var2_F6313;
			IEnumerator var3_F6321;
			IEnumerator var4_F6155;
			IEnumerator var5_F6154;
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
				var2_F6313 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6313", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F6321 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6321", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F6155 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6155", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F6154 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6154", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F6411;
			IEnumerator var3_F6314;
			IEnumerator var4_F6162;
			IEnumerator var5_F6152;
			IEnumerator var6_F6432;
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
				var2_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F6314 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6314", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F6162 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6162", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F6152 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6152", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var6_F6432 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6432", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F6145;
			IEnumerator var3_C211;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F6145 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6145", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_C211 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C211", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_C211.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C211", (new seq80_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C211.current())))));
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
			IEnumerator var2_F6411;
			IEnumerator var3_F6168;
			IEnumerator var4_F6140;
			IEnumerator var5_F6008;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F6411 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6411", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F6168 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6168", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F6140 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6140", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F6008 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6008", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F9308;
			IEnumerator var3_F4517;
			IEnumerator var4_C215;
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
					case 8:	if (moveNext_8()) return true; break;
					case 9:	if (moveNext_9()) return true; break;
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F9308 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F9308", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F4517 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4517", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_C215 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C215", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_8() throws Exception {
				state = 8;				
				if (!var4_C215.moveNext()) {state = 9; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C215", (new seq82_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_C215.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_9() throws Exception {
				state = 0;				
				if( var4_C215 != null ) { var4_C215.close(); var4_C215 = null; }
				return false;
			}

			
			public void close()
			{
				try
				{
				if( var2_F9308 != null ) { var2_F9308.close(); var2_F9308 = null; }
				if( var3_F4517 != null ) { var3_F4517.close(); var3_F4517 = null; }
				if( var4_C215 != null ) { var4_C215.close(); var4_C215 = null; }
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
			IEnumerator var2_F9303;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
			IEnumerator var5_F9302;
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
					case 11:	if (moveNext_11()) return true; break;
					case 12:	if (moveNext_12()) return true; break;
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F9303 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F9303", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F9302 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F9302", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_EQA;
			IEnumerator var3_SEL;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_EQA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("EQA", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_EQA.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("EQA", (new seq84_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_EQA.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_EQA != null ) { var2_EQA.close(); var2_EQA = null; }
				var3_SEL = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SEL", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_SEL.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("SEL", (new seq81_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_SEL.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_6() throws Exception {
				state = 0;				
				if( var3_SEL != null ) { var3_SEL.close(); var3_SEL = null; }
				return false;
			}

			
			public void close()
			{
				try
				{
				if( var2_EQA != null ) { var2_EQA.close(); var2_EQA = null; }
				if( var3_SEL != null ) { var3_SEL.close(); var3_SEL = null; }
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
			IEnumerator var2_F8053;
			IEnumerator var3_C237;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F8053 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F8053", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_C237 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C237", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_C237.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C237", (new seq74_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C237.current())))));
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
			IEnumerator var2_GID;
			IEnumerator var3_HAN;
			IEnumerator var4_SG10;
			IEnumerator var5_SG11;
			IEnumerator var6_SG12;
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
				var2_GID = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("GID", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_GID.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("GID", (new seq86_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_GID.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_GID != null ) { var2_GID.close(); var2_GID = null; }
				var3_HAN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("HAN", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_HAN.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("HAN", (new seq88_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_HAN.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_6() throws Exception {
				state = 8;				
				if( var3_HAN != null ) { var3_HAN.close(); var3_HAN = null; }
				var4_SG10 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG10", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_8() throws Exception {
				state = 8;				
				if (!var4_SG10.moveNext()) {state = 9; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("SG10", (new seq91_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var4_SG10.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_9() throws Exception {
				state = 11;				
				if( var4_SG10 != null ) { var4_SG10.close(); var4_SG10 = null; }
				var5_SG11 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG11", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_11() throws Exception {
				state = 11;				
				if (!var5_SG11.moveNext()) {state = 12; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("SG11", (new seq94_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var5_SG11.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_12() throws Exception {
				state = 14;				
				if( var5_SG11 != null ) { var5_SG11.close(); var5_SG11 = null; }
				var6_SG12 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("SG12", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_14() throws Exception {
				state = 14;				
				if (!var6_SG12.moveNext()) {state = 15; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("SG12", (new seq95_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var6_SG12.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_15() throws Exception {
				state = 0;				
				if( var6_SG12 != null ) { var6_SG12.close(); var6_SG12 = null; }
				return false;
			}

			
			public void close()
			{
				try
				{
				if( var2_GID != null ) { var2_GID.close(); var2_GID = null; }
				if( var3_HAN != null ) { var3_HAN.close(); var3_HAN = null; }
				if( var4_SG10 != null ) { var4_SG10.close(); var4_SG10 = null; }
				if( var5_SG11 != null ) { var5_SG11.close(); var5_SG11 = null; }
				if( var6_SG12 != null ) { var6_SG12.close(); var6_SG12 = null; }
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
			IEnumerator var2_F1496;
			IEnumerator var3_C213;
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
				var2_F1496 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1496", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_C213 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C213", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_C213.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C213", (new seq87_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C213.current())))));
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
			IEnumerator var2_F7224;
			IEnumerator var3_F7065;
			IEnumerator var4_F1131;
			IEnumerator var5_F3055;
			IEnumerator var6_F7064;
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
					case 14:	if (moveNext_14()) return true; break;
					case 15:	if (moveNext_15()) return true; break;
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F7224 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7224", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F7065 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7065", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var6_F7064 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7064", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				state = 0;				
				if( var6_F7064 != null ) { var6_F7064.close(); var6_F7064 = null; }
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
			IEnumerator var2_C524;
			IEnumerator var3_C218;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_C524 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C524", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_C524.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C524", (new seq89_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C524.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_C524 != null ) { var2_C524.close(); var2_C524 = null; }
				var3_C218 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C218", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_C218.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C218", (new seq90_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C218.current())))));
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
			IEnumerator var2_F4079;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
			IEnumerator var5_F4078;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F4079 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4079", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var5_F4078 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F4078", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F7419;
			IEnumerator var3_F1131;
			IEnumerator var4_F3055;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F7419 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7419", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F1131 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F1131", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var4_F3055 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F3055", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				if( var2_F7419 != null ) { var2_F7419.close(); var2_F7419 = null; }
				if( var3_F1131 != null ) { var3_F1131.close(); var3_F1131 = null; }
				if( var4_F3055 != null ) { var4_F3055.close(); var4_F3055 = null; }
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
			IEnumerator var2_MEA;
			IEnumerator var3_EQN;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_MEA = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("MEA", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_MEA.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("MEA", (new seq76_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_MEA.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_MEA != null ) { var2_MEA.close(); var2_MEA = null; }
				var3_EQN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("EQN", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_EQN.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("EQN", (new seq92_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_EQN.current())))));
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
	static class seq92_map implements IEnumerable
	{
		org.assimbly.edifactcommon.mapforce.IMFNode var1_current;
	
		public seq92_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
		{
			this.var1_current = var1_current;
		}

		public IEnumerator enumerator() {return new Enumerator(this);}
		
		public static class Enumerator implements IEnumerator
		{
			int pos = 0;
			int state = 1;
			Object current;
			seq92_map closure;
			IEnumerator var2_C523;
			public Enumerator(seq92_map closure) 
			{
				this.closure = closure;
			}
			
			public Object current() {return current;}
			
			public int position() {return pos;}
			
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
				var2_C523 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C523", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_C523.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C523", (new seq93_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_C523.current())))));
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
			IEnumerator var2_F6350;
			IEnumerator var3_F6353;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F6350 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6350", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F6353 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F6353", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_DIM;
			IEnumerator var3_EQN;
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
				var2_DIM = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("DIM", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_DIM.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("DIM", (new seq79_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_DIM.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_DIM != null ) { var2_DIM.close(); var2_DIM = null; }
				var3_EQN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("EQN", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_EQN.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("EQN", (new seq92_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_EQN.current())))));
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
	static class seq95_join implements IEnumerable
	{
		org.assimbly.edifactcommon.mapforce.IMFNode var1_current;
	
		public seq95_join(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
		{
			this.var1_current = var1_current;
		}

		public IEnumerator enumerator() {return new Enumerator(this);}
		
		public static class Enumerator implements IEnumerator
		{
			int pos = 0;
			int state = 1;
			Object current;
			seq95_join closure;
			IEnumerator var2_PCI;
			IEnumerator var3_GIN;
			public Enumerator(seq95_join closure) 
			{
				this.closure = closure;
			}
			
			public Object current() {return current;}
			
			public int position() {return pos;}
			
			public boolean moveNext() throws Exception
			{
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
				var2_PCI = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("PCI", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_2() throws Exception {
				state = 2;				
				if (!var2_PCI.moveNext()) {state = 3; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("PCI", (new seq62_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var2_PCI.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_3() throws Exception {
				state = 5;				
				if( var2_PCI != null ) { var2_PCI.close(); var2_PCI = null; }
				var3_GIN = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("GIN", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_GIN.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("GIN", (new seq96_join(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_GIN.current())))));
				pos++;
				return true;
			}
			private boolean moveNext_6() throws Exception {
				state = 0;				
				if( var3_GIN != null ) { var3_GIN.close(); var3_GIN = null; }
				return false;
			}

			
			public void close()
			{
				try
				{
				if( var2_PCI != null ) { var2_PCI.close(); var2_PCI = null; }
				if( var3_GIN != null ) { var3_GIN.close(); var3_GIN = null; }
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
			IEnumerator var2_F7405;
			IEnumerator var3_C208;
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
				var2_F7405 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7405", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_C208 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("C208", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
				return false;
			}
			private boolean moveNext_5() throws Exception {
				state = 5;				
				if (!var3_C208.moveNext()) {state = 6; return false; }
				current = org.assimbly.edifactcommon.functions.Core.createElement("C208", (new seq97_map(((org.assimbly.edifactcommon.mapforce.IMFNode)(var3_C208.current())))));
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
	static class seq97_map implements IEnumerable
	{
		org.assimbly.edifactcommon.mapforce.IMFNode var1_current;
	
		public seq97_map(org.assimbly.edifactcommon.mapforce.IMFNode var1_current)
		{
			this.var1_current = var1_current;
		}

		public IEnumerator enumerator() {return new Enumerator(this);}
		
		public static class Enumerator implements IEnumerator
		{
			int pos = 0;
			int state = 1;
			Object current;
			seq97_map closure;
			IEnumerator var2_F7402;
			public Enumerator(seq97_map closure) 
			{
				this.closure = closure;
			}
			
			public Object current() {return current;}
			
			public int position() {return pos;}
			
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
				var2_F7402 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F7402", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F0074;
			IEnumerator var3_F0062;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F0074 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0074", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0062 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0062", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F0060;
			IEnumerator var3_F0048;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F0060 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0060", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0048 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0048", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
			IEnumerator var2_F0036;
			IEnumerator var3_F0020;
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
 					}
				}
				return false;
			}

			private boolean moveNext_1() throws Exception {
				state = 2;				
				var2_F0036 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0036", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
				var3_F0020 = (org.assimbly.edifactcommon.functions.Core.filterElements(org.assimbly.edifactcommon.functions.Core.createQName("F0020", "http://www.blujaysolutions.com/2021/IFTSTA"), closure.var1_current)).enumerator();
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
		org.assimbly.edifactcommon.mapforce.IMFNode var1_IFTSTA_D96A_Instance;
	
		public Outer(org.assimbly.edifactcommon.mapforce.IMFNode var1_IFTSTA_D96A_Instance)
		{
			this.var1_IFTSTA_D96A_Instance = var1_IFTSTA_D96A_Instance;
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
				var2_map = ((new main(closure.var1_IFTSTA_D96A_Instance))).enumerator();
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
	protected org.w3c.dom.Node varIFTSTA_D96A2Instance;

	public void run(String IFTSTA_D96A2SourceFilename, String IFTSTATargetFilename) throws Exception {
		// open source streams
		writeTrace("Loading " + IFTSTA_D96A2SourceFilename + "...\n");
		org.assimbly.edifactcommon.io.FileInput IFTSTA_D96A2Source = new org.assimbly.edifactcommon.io.FileInput(IFTSTA_D96A2SourceFilename);
		// open target stream
		org.assimbly.edifactcommon.io.FileOutput IFTSTATarget = new org.assimbly.edifactcommon.io.FileOutput(IFTSTATargetFilename);

		// run
	
		run(IFTSTA_D96A2Source, IFTSTATarget);

		// close source streams
		IFTSTA_D96A2Source.close();
		// close target stream
		writeTrace("Saving " + IFTSTATargetFilename + "...\n");
		IFTSTATarget.close();
	}


	// main entry point

	public void run(org.assimbly.edifactcommon.io.Input IFTSTA_D96A2Source, org.assimbly.edifactcommon.io.Output IFTSTATarget) throws Exception {
		// Open the source(s)
		org.w3c.dom.Document doc_IFTSTA_D96A2 = XmlTreeOperations.loadDocument(IFTSTA_D96A2Source);
		varIFTSTA_D96A2Instance = doc_IFTSTA_D96A2;
		if (runDoesCloseAll)
			IFTSTA_D96A2Source.close();

		// Create the target
		org.assimbly.edifactstandards.xml.envelope.IFTSTAD96AEnvelope IFTSTATargetDoc = new org.assimbly.edifactstandards.xml.envelope.IFTSTAD96AEnvelope();
		org.assimbly.edifactcommon.text.ITextNode IFTSTATargetObject = IFTSTATargetDoc.getGenerator();

		// Execute mapping

		main mapping = new main(new org.assimbly.edifactcommon.xml.DOMDocumentAsMFNodeAdapter(varIFTSTA_D96A2Instance, IFTSTA_D96A2Source.getFilename()));

		org.assimbly.edifactcommon.text.MFTextWriter.write(mapping, IFTSTATargetObject);
		// Close the target
		IFTSTATargetDoc.setEncoding( "UTF-8", false, false );
		IFTSTATargetDoc.save(IFTSTATarget);

		
		if (runDoesCloseAll)
		{
			IFTSTA_D96A2Source.close();
			IFTSTATarget.close();
		}
	}



}
