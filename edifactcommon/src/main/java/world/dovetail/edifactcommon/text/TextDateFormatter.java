// TextDateFormatter.java
// This file contains generated code and will be overwritten when you rerun code generation.

package world.dovetail.edifactcommon.text;

import world.dovetail.edifactcommon.types.DateTime;

public class TextDateFormatter extends TextFormatter
{
	public String format(DateTime dt)
	{
		return dt.toDateString(true);
	}
}
