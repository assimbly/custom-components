package org.assimbly.edifactcommon;


public class AltovaException extends RuntimeException {
	protected Exception	innerException;
	protected String	message;

	public AltovaException(String text) {
		innerException = null;
		message = text;
	}

	public AltovaException(Exception other) {
		innerException = other;
		message = other.getMessage();
	}

	public String getMessage() {
		return message;
	}

	public Exception getInnerException() {
		return innerException;
	}
}
