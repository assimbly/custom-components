// XmlGMonthDayFormatter.java
// This file contains generated code and will be overwritten when you rerun code generation.

package world.dovetail.edifactcommon.xml;

import world.dovetail.edifactcommon.CoreTypes;
import world.dovetail.edifactcommon.types.CalendarBase;
import world.dovetail.edifactcommon.types.DateTime;

class XmlGMonthDayFormatter extends XmlFormatter
{
	public String format(DateTime dt)
	{
		String result = "--";
		int month = dt.getMonth();
		int day = dt.getDay();
		result += CoreTypes.formatNumber(month, 2);
		result += '-';
		result += CoreTypes.formatNumber(day, 2);
		if (dt.hasTimezone() != CalendarBase.TZ_MISSING)
			result += CoreTypes.formatTimezone(dt.getTimezoneOffset());
		return result;
	}
}
