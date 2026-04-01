// Input.java
// This file contains generated code and will be overwritten when you rerun code generation.package com.altova.io;

package org.assimbly.edifactcommon.io;

public class Input 
{
	public static final byte IO_READER = 0;
	public static final byte IO_STREAM = 1;
	public static final byte IO_DOM = 2;
	
	private final byte type;
	
	public Input(byte type)
	{
		this.type = type;
	}
	public byte getType() {return type;}
	public java.io.Reader getReader() {return null;}
	public java.io.InputStream getStream() {return null;} 
	public org.w3c.dom.Document getDocument() {return null;}
	public void close() throws Exception { /* not used */ }
	public String getFilename() {return "";}
}
