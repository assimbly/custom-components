// FileInput.java
// This file contains generated code and will be overwritten when you rerun code generation.package com.altova.io;

package org.assimbly.edifactcommon.io;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileInput extends StreamInput
{
	private final String fileName;
	public FileInput(String fileName) throws Exception
	{
		super(Files.newInputStream(Paths.get(fileName)));
		this.fileName = fileName;
	}

	@Override
	public String getFilename() {return fileName;}

	@Override
	public void close() throws Exception {getStream().close();}

}
