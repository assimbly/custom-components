// XmlDateFormatter.java
// This file contains generated code and will be overwritten when you rerun code generation.

package world.dovetail.edifactcommon.xml;

import world.dovetail.edifactcommon.types.DateTime;

public class XmlDateFormatter extends XmlFormatter
{
	public String format(DateTime dt)
	{
		return dt.toDateString(true);
	}
}
