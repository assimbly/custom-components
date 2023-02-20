// XmlGYearFormatter.java
// This file contains generated code and will be overwritten when you rerun code generation.

package world.dovetail.edifactcommon.xml;

import world.dovetail.edifactcommon.CoreTypes;
import world.dovetail.edifactcommon.types.CalendarBase;
import world.dovetail.edifactcommon.types.DateTime;

class XmlGYearFormatter extends XmlFormatter
{
	public String format(DateTime dt)
	{
		String result = "";
		int year = dt.getYear();
		if (year < 0)
		{
			result += '-';
			year = -year;
		}

		result += CoreTypes.formatNumber(year, 4);
		if (dt.hasTimezone() != CalendarBase.TZ_MISSING)
			result += CoreTypes.formatTimezone(dt.getTimezoneOffset());
		return result;
	}
}
