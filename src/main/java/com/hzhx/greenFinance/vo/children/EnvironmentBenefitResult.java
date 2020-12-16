package com.hzhx.greenFinance.vo.children;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
//XML文件中的根标识
@XmlRootElement(name = "environmentBenefitResult")
//控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "energy", "co2", "cod", "nh", "so2", "nox" , "h2o" , "fineParticle" , "voc" , "nitrogen" , "phosphorus" })
public class EnvironmentBenefitResult {
	private BigDecimal energy;
	private BigDecimal co2;
	private BigDecimal cod;
	private BigDecimal nh;
	private BigDecimal so2;
	private BigDecimal nox;
	private BigDecimal h2o;
	private BigDecimal fineParticle;
	private BigDecimal voc;
	private BigDecimal nitrogen;
	private BigDecimal phosphorus;
	public BigDecimal getEnergy() {
		return energy;
	}
	public void setEnergy(String energy) {
		energy = StringUtils.isBlank(energy)?"0":energy.replace(",","");
		this.energy = BigDecimal.valueOf(Double.valueOf(energy));
	}
	public BigDecimal getCo2() {
		return co2;
	}
	public void setCo2(String co2) {
		co2 = StringUtils.isBlank(co2)?"0":co2.replace(",","");
		this.co2 = BigDecimal.valueOf(Double.valueOf(co2));
	}
	public BigDecimal getCod() {
		return cod;
	}
	public void setCod(String cod) {
		cod = StringUtils.isBlank(cod)?"0":cod.replace(",","");
		this.cod = BigDecimal.valueOf(Double.valueOf(cod));
	}
	public BigDecimal getNh() {
		return nh;
	}
	public void setNh(String nh) {
		nh = StringUtils.isBlank(nh)?"0":nh.replace(",","");
		this.nh = BigDecimal.valueOf(Double.valueOf(nh));
	}
	public BigDecimal getSo2() {
		return so2;
	}
	public void setSo2(String so2) {
		so2 = StringUtils.isBlank(so2)?"0":so2.replace(",","");
		this.so2 = BigDecimal.valueOf(Double.valueOf(so2));
	}
	public BigDecimal getNox() {
		return nox;
	}
	public void setNox(String nox) {
		nox = StringUtils.isBlank(nox)?"0":nox.replace(",","");
		this.nox = BigDecimal.valueOf(Double.valueOf(nox));
	}
	public BigDecimal getH2o() {
		return h2o;
	}
	public void setH2o(String h2o) {
		h2o = StringUtils.isBlank(h2o)?"0":h2o.replace(",","");
		this.h2o = BigDecimal.valueOf(Double.valueOf(h2o));
	}
	public BigDecimal getFineParticle() {
		return fineParticle;
	}
	public void setFineParticle(String fineParticle) {
		fineParticle = StringUtils.isBlank(fineParticle)?"0":fineParticle.replace(",","");
		this.fineParticle = BigDecimal.valueOf(Double.valueOf(fineParticle));
	}
	public BigDecimal getVoc() {
		return voc;
	}
	public void setVoc(String voc) {
		voc = StringUtils.isBlank(voc)?"0":voc.replace(",","");
		this.voc = BigDecimal.valueOf(Double.valueOf(voc));
	}
	public BigDecimal getNitrogen() {
		return nitrogen;
	}
	public void setNitrogen(String nitrogen) {
		nitrogen = StringUtils.isBlank(nitrogen)?"0":nitrogen.replace(",","");
		this.nitrogen = BigDecimal.valueOf(Double.valueOf(nitrogen));
	}
	public BigDecimal getPhosphorus() {
		return phosphorus;
	}
	public void setPhosphorus(String phosphorus) {
		phosphorus = StringUtils.isBlank(phosphorus)?"0":phosphorus.replace(",","");
		this.phosphorus = BigDecimal.valueOf(Double.valueOf(phosphorus));
	}
	
}
