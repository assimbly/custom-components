// StreamOutput.java
// This file contains generated code and will be overwritten when you rerun code generation.package com.altova.io;

package org.assimbly.edifactcommon.io;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class StreamOutput extends Output
{
	private OutputStream stream = null;
	protected String filename = null;
	
	public StreamOutput(OutputStream stream)
	{
		super(Output.IO_STREAM);
		this.stream = stream;
	}
	
	protected StreamOutput(String filename)
	{
		super(Output.IO_STREAM);
		this.filename = filename;
	}

	@Override
	public OutputStream getStream() throws Exception
	{
		if (stream == null)
			stream = Files.newOutputStream(Paths.get(filename), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

		return stream;
	}

	@Override
	public void close() throws Exception {stream.close();}
}
