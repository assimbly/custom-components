package org.assimbly.edifactcommon;


public class SourceInstanceUnavailableException extends RuntimeException {

	public SourceInstanceUnavailableException(String text)
	{
		super(text);
	}

	public SourceInstanceUnavailableException(String text, Throwable other)
	{
		super(text, other);
	}

}
