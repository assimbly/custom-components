// XmlIntegerFormatter.java
// This file contains generated code and will be overwritten when you rerun code generation.

package world.dovetail.edifactcommon.xml;

import world.dovetail.edifactcommon.CoreTypes;

class XmlIntegerFormatter extends XmlFormatter
{
	public String format(double v)
	{
		return CoreTypes.castToString((long) v);
	}
}
