// TextIntegerFormatter.java
// This file contains generated code and will be overwritten when you rerun code generation.

package org.assimbly.edifactcommon.text;

import org.assimbly.edifactcommon.CoreTypes;

class TextIntegerFormatter extends TextFormatter
{
	public String format(double v)
	{
		return CoreTypes.castToString((long) v);
	}
}
