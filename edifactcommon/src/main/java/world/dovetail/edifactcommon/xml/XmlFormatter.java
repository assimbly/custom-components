// XmlFormatter.java
// This file contains generated code and will be overwritten when you rerun code generation.

package world.dovetail.edifactcommon.xml;

import world.dovetail.edifactcommon.Base64;
import world.dovetail.edifactcommon.CoreTypes;
import world.dovetail.edifactcommon.typeinfo.ValueFormatter;
import world.dovetail.edifactcommon.types.DateTime;
import world.dovetail.edifactcommon.types.Duration;

import java.math.BigDecimal;
import java.math.BigInteger;

public class XmlFormatter implements ValueFormatter
{
	public String format(DateTime v)
	{
		return CoreTypes.castToString(v);
	}
	
	public String format(Duration v)
	{
		return CoreTypes.castToString(v);
	}
	
	public String format(long v)
	{
		return CoreTypes.castToString(v);
	}
	
	public String format(double v)
	{
		return CoreTypes.castToString(v);
	}
	
	public String format(BigInteger v)
	{
		return CoreTypes.castToString(v);
	}
	
	public String format(BigDecimal v)
	{
		return CoreTypes.castToString(v);
	}
	
	public String format(String v)
	{
		return CoreTypes.castToString(v);
	}
	
	public String format(byte[] v)
	{
		if( v == null ) return "";
		String sResult = Base64.encode( v);
		return sResult.replaceAll( "\r", "" );
	}
	
	public String format(boolean v)
	{
		return CoreTypes.castToString(v);
	}
	
	public byte[] parseBinary(String v)
	{
		if( v == null ) return null;
		String newvalue = v.replaceAll("\\s{2,}", "").trim();	// collapse whitespace
		if( newvalue.length() == 0 ) return new byte[0];
		try {
			return Base64.decode( newvalue);
		}
		catch ( java.io.IOException e ) {
			return null;
		}
	}
}
