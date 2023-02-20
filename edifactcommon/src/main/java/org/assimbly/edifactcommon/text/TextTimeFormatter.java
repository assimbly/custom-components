// TextTimeFormatter.java
// This file contains generated code and will be overwritten when you rerun code generation.

package org.assimbly.edifactcommon.text;

import org.assimbly.edifactcommon.types.DateTime;

public class TextTimeFormatter extends TextFormatter
{
	public String format(DateTime dt)
	{
		return dt.toTimeString("0.0######");
	}
}
