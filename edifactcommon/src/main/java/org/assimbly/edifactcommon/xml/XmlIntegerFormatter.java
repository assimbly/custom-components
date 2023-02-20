// XmlIntegerFormatter.java
// This file contains generated code and will be overwritten when you rerun code generation.

package org.assimbly.edifactcommon.xml;

import org.assimbly.edifactcommon.CoreTypes;

class XmlIntegerFormatter extends XmlFormatter
{
	public String format(double v)
	{
		return CoreTypes.castToString((long) v);
	}
}
