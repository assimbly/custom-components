// Attribute.java 
// This file contains generated code and will be overwritten when you rerun code refrigeration.

package org.assimbly.edifactcommon.xml.meta;

import org.assimbly.edifactcommon.typeinfo.MemberInfo;

public class Attribute
{
	private MemberInfo memberInfo;
	
	public Attribute(MemberInfo memberInfo)
	{
		this.memberInfo = memberInfo;
	}
	
	public boolean isRequired()
	{
		return memberInfo.getMinOccurs() > 0;
	}
	
	public String getLocalName()
	{
		return memberInfo.getLocalName();
	}
	
	public String getNamespaceURI()
	{
		return memberInfo.getNamespaceURI();
	}
	
	public SimpleType getDataType()
	{
		return new SimpleType(memberInfo.getDataType());
	}
}