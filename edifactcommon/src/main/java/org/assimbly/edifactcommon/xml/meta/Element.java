// Element.java 
// This file contains generated code and will be overwritten when you rerun code generation.

package org.assimbly.edifactcommon.xml.meta;

import org.assimbly.edifactcommon.typeinfo.MemberInfo;

public class Element
{
	MemberInfo memberInfo;

	public Element(MemberInfo info)
	{
		this.memberInfo = info;
	}

	public int getMinOccurs()
	{
		return memberInfo.getMinOccurs();
	}

	public int getMaxOccurs()
	{
		return memberInfo.getMaxOccurs();
	}

	public String getLocalName()
	{
		return memberInfo.getLocalName();
	}

	public String getNamespaceURI()
	{
		return memberInfo.getNamespaceURI();
	}

	public ComplexType getDataType()
	{
		return new ComplexType(memberInfo.getDataType());
	}
}