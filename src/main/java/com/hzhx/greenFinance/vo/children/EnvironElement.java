package com.hzhx.greenFinance.vo.children;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "environElement")  
@XmlType(propOrder = { "elementType","environElement" }) 
public class EnvironElement {
	@XmlAttribute
	private String elementType;
	@XmlValue
	private String environElement;

	public String getElementType() {
		return elementType;
	}

	public void setElementType(String elementType) {
		this.elementType = elementType;
	}

	public String getEnvironElement() {
		return environElement;
	}

	public void setEnvironElement(String environElement) {
		this.environElement = environElement;
	}
	
}
