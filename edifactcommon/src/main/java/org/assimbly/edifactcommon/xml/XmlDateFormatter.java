// XmlDateFormatter.java
// This file contains generated code and will be overwritten when you rerun code generation.

package org.assimbly.edifactcommon.xml;

import org.assimbly.edifactcommon.types.DateTime;

public class XmlDateFormatter extends XmlFormatter
{
	public String format(DateTime dt)
	{
		return dt.toDateString(true);
	}
}
