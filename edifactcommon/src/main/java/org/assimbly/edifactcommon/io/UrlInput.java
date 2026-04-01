// UrlInput.java
// This file contains generated code and will be overwritten when you rerun code generation.package com.altova.io;

package org.assimbly.edifactcommon.io;

public class UrlInput extends StreamInput 
{
	String url;
	UrlInput(String url) throws Exception
	{
		java.net.URI uri = java.net.URI.create(url);
		java.net.URL urlObject = uri.toURL();

		super(urlObject.openStream());
		this.url = url;
	}

	@Override
	public String getFilename() {return url;}

	@Override
	public void close() throws Exception {getStream().close();}
}