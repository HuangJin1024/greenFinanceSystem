package com.hzhx.greenFinance.vo.children;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "publicEnvironElement")  
@XmlType(propOrder = { "elementType","publicEnvironElement" })  
public class PublicEnvironElement {
	@XmlAttribute
	private String elementType;
	@XmlValue
	private String publicEnvironElement;

	public String getElementType() {
		return elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	public String getPublicEnvironElement() {
		return publicEnvironElement;
	}

	public void setPublicEnvironElement(String publicEnvironElement) {
		this.publicEnvironElement = publicEnvironElement;
	}
	
}
