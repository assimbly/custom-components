package org.assimbly.edifactcommon.functions;

import java.util.HashMap;

public class RuntimeContext 
{
	protected static class AutoNumberStateEntry
	{
		public long current;
		public String restartOnChange;
		public AutoNumberStateEntry(long current, String restartOnChange) 
		{ 
			this.current = current; 
			this.restartOnChange=restartOnChange;
		}
	}
	
	private HashMap<String, AutoNumberStateEntry> autoNumberStateMap = null;
	public HashMap<String, AutoNumberStateEntry> getAutoNumberStateMap()
	{ 
		if (autoNumberStateMap == null) 
			autoNumberStateMap = new HashMap<String, AutoNumberStateEntry>(); 
		return autoNumberStateMap; 
	}
	
	public static void dispose(RuntimeContext context)
	{ 
		if (context.autoNumberStateMap != null) 
			context.autoNumberStateMap.clear(); 
	}
	
    public static RuntimeContext construct()
	{ 
		return new RuntimeContext();
	}
	
    private RuntimeContext() {}
}
