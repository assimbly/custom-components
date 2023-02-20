package org.assimbly.edifactcommon;


public abstract class TraceProvider {
	protected TraceTarget traceTarget = null;

	protected void writeTrace(String info) {
		if (traceTarget != null)
			traceTarget.writeTrace(info);
	}

	public void registerTraceTarget(TraceTarget newTraceTarget) {
		traceTarget = newTraceTarget;
	}

	public void unregisterTraceTarget() {
		traceTarget = null;
	}
}
