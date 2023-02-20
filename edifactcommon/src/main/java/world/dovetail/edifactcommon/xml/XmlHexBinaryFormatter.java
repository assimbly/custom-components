// XmlHexBinaryFormatter.java
// This file contains generated code and will be overwritten when you rerun code generation.

package world.dovetail.edifactcommon.xml;

import world.dovetail.edifactcommon.HexBinary;

public class XmlHexBinaryFormatter extends XmlFormatter
{
	public String format(byte[] v)
	{
		return HexBinary.encode(v);
	}

	public byte[] parseBinary(String s)
	{
		return HexBinary.decode(s);
	}
}