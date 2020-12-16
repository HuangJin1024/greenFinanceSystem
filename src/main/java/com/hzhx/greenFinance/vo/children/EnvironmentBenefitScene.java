package com.hzhx.greenFinance.vo.children;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "Computer")  
@XmlType(propOrder = { "sceneType", "environElement", "publicEnvironElement" }) 
public class EnvironmentBenefitScene {
	private String sceneType;
	@XmlElementWrapper(name = "environElements")
	private List<EnvironElement > environElement;
	private List<PublicEnvironElement> publicEnvironElement;
	public String getSceneType() {
		return sceneType;
	}
	public void setSceneType(String sceneType) {
		this.sceneType = sceneType;
	}
	public List<EnvironElement> getEnvironElement() {
		return environElement;
	}
	public void setEnvironElement(List<EnvironElement> environElement) {
		this.environElement = environElement;
	}
	public List<PublicEnvironElement> getPublicEnvironElement() {
		return publicEnvironElement;
	}
	public void setPublicEnvironElement(List<PublicEnvironElement> publicEnvironElement) {
		this.publicEnvironElement = publicEnvironElement;
	}
	
}
