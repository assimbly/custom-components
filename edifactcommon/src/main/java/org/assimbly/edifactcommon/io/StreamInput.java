// StreamInput.java
// This file contains generated code and will be overwritten when you rerun code generation.package com.altova.io;

package org.assimbly.edifactcommon.io;

import java.io.InputStream;

public class StreamInput extends Input
{
	private final InputStream stream;
	
	public StreamInput (InputStream stream)
	{
		super(Input.IO_STREAM);
		this.stream = stream;
	}

	@Override
	public InputStream getStream() {return stream;}

	@Override
	public void close() throws Exception {stream.close();}

	public static StreamInput createInput(String u) throws Exception
	{
		if (u.trim().indexOf(':') > 1)
		{
			java.net.URI uri = java.net.URI.create(u);
			java.net.URL url = uri.toURL();
			
			if ("file".equals(url.getProtocol()))
				return new FileInput(url.getPath());
			return new UrlInput(u);
		}
			
		return new FileInput(u);
	}
}
