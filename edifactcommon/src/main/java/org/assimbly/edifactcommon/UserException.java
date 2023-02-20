package org.assimbly.edifactcommon;

public class UserException extends RuntimeException 
{
	protected String	message;
	protected org.w3c.dom.Node node;

	public UserException(String text) 
	{
		message = text;
		node = null;
	}

	public UserException(org.w3c.dom.Node n) 
	{
		message = null;
		node = n;
	}

	public UserException(String text, org.w3c.dom.Node n) 
	{
		message = text;
		node = n;
	}

	public String getMessage() {
		return message;
	}

	public org.w3c.dom.Node getNode() {
		return node;
	}
}
