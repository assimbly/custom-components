// WriterOutput.java
// This file contains generated code and will be overwritten when you rerun code generation.

package org.assimbly.edifactcommon.io;

import java.io.Writer;

public class WriterOutput extends Output
{
	private final Writer writer;
	
	public WriterOutput(Writer writer)
	{
		super(Output.IO_WRITER);
		this.writer = writer;
	}

	@Override
	public Writer getWriter() {return writer;}
}
