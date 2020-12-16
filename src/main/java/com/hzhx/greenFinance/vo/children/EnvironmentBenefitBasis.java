package com.hzhx.greenFinance.vo.children;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name = "environmentBenefitBasis")  
@XmlType(propOrder = { "environmentBenefitScene" }) 
public class EnvironmentBenefitBasis {
	@XmlElementWrapper(name = "environmentBenefitScenes")
	private List<EnvironmentBenefitScene> environmentBenefitScene;

	public List<EnvironmentBenefitScene> getEnvironmentBenefitScene() {
		return environmentBenefitScene;
	}

	public void setEnvironmentBenefitScene(List<EnvironmentBenefitScene> environmentBenefitScene) {
		this.environmentBenefitScene = environmentBenefitScene;
	}
	
}
