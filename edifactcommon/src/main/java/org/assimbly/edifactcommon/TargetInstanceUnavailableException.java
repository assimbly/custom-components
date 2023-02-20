package org.assimbly.edifactcommon;


public class TargetInstanceUnavailableException extends RuntimeException
{

	public TargetInstanceUnavailableException(String text)
	{
		super(text);
	}

	public TargetInstanceUnavailableException(String text, Throwable other)
	{
		super(text, other);
	}

}
