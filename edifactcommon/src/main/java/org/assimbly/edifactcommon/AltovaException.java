package org.assimbly.edifactcommon;


public class AltovaException extends RuntimeException {
	protected final Exception innerException;
	protected final String message;

	public AltovaException(String text) {
		innerException = null;
		message = text;
	}

	public AltovaException(Exception other) {
		innerException = other;
		message = other.getMessage();
	}

	@Override
	public String getMessage() {
		return message;
	}

	public Exception getInnerException() {
		return innerException;
	}
}
