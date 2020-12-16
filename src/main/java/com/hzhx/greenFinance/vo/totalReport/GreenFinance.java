package com.hzhx.greenFinance.vo.totalReport;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.apache.commons.lang.StringUtils;

@XmlAccessorType(XmlAccessType.FIELD)
public class GreenFinance {
	private String indexCode;
	private BigDecimal greenBalance;
	private BigDecimal passBalance;
	private BigDecimal followBalance;
	private BigDecimal subBalance;
	private BigDecimal doubtfulBalance;
	private BigDecimal lossBalance;
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
	private BigDecimal bondBalance;
	private BigDecimal billBalance;
	private BigDecimal creditBalance;

	public String getIndexCode() {
		return indexCode;
	}

	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}

	public BigDecimal getGreenBalance() {
		return greenBalance;
	}

	public void setGreenBalance(String greenBalance) {
		greenBalance = StringUtils.isBlank(greenBalance) ? "0" : greenBalance.replace(",", "");
		this.greenBalance = BigDecimal.valueOf(Double.valueOf(greenBalance));
	}

	public BigDecimal getPassBalance() {
		return passBalance;
	}

	public void setPassBalance(String passBalance) {
		passBalance = StringUtils.isBlank(passBalance) ? "0" : passBalance.replace(",", "");
		this.passBalance = BigDecimal.valueOf(Double.valueOf(passBalance));
	}

	public BigDecimal getFollowBalance() {
		return followBalance;
	}

	public void setFollowBalance(String followBalance) {
		followBalance = StringUtils.isBlank(followBalance) ? "0" : followBalance.replace(",", "");
		this.followBalance = BigDecimal.valueOf(Double.valueOf(followBalance));
	}

	public BigDecimal getSubBalance() {
		return subBalance;
	}

	public void setSubBalance(String subBalance) {
		subBalance = StringUtils.isBlank(subBalance) ? "0" : subBalance.replace(",", "");
		this.subBalance = BigDecimal.valueOf(Double.valueOf(subBalance));
	}

	public BigDecimal getDoubtfulBalance() {
		return doubtfulBalance;
	}

	public void setDoubtfulBalance(String doubtfulBalance) {
		doubtfulBalance = StringUtils.isBlank(doubtfulBalance) ? "0" : doubtfulBalance.replace(",", "");
		this.doubtfulBalance = BigDecimal.valueOf(Double.valueOf(doubtfulBalance));
	}

	public BigDecimal getLossBalance() {
		return lossBalance;
	}

	public void setLossBalance(String lossBalance) {
		lossBalance = StringUtils.isBlank(lossBalance) ? "0" : lossBalance.replace(",", "");
		this.lossBalance = BigDecimal.valueOf(Double.valueOf(lossBalance));
	}

	public BigDecimal getEnergy() {
		return energy;
	}

	public void setEnergy(String energy) {
		energy = StringUtils.isBlank(energy) ? "0" : energy.replace(",", "");
		this.energy = BigDecimal.valueOf(Double.valueOf(energy));
	}

	public BigDecimal getCo2() {
		return co2;
	}

	public void setCo2(String co2) {
		co2 = StringUtils.isBlank(co2) ? "0" : co2.replace(",", "");
		this.co2 = BigDecimal.valueOf(Double.valueOf(co2));
	}

	public BigDecimal getCod() {
		return cod;
	}

	public void setCod(String cod) {
		cod = StringUtils.isBlank(cod) ? "0" : cod.replace(",", "");
		this.cod = BigDecimal.valueOf(Double.valueOf(cod));
	}

	public BigDecimal getNh() {
		return nh;
	}

	public void setNh(String nh) {
		nh = StringUtils.isBlank(nh) ? "0" : nh.replace(",", "");
		this.nh = BigDecimal.valueOf(Double.valueOf(nh));
	}

	public BigDecimal getSo2() {
		return so2;
	}

	public void setSo2(String so2) {
		so2 = StringUtils.isBlank(so2) ? "0" : so2.replace(",", "");
		this.so2 = BigDecimal.valueOf(Double.valueOf(so2));
	}

	public BigDecimal getNox() {
		return nox;
	}

	public void setNox(String nox) {
		nox = StringUtils.isBlank(nox) ? "0" : nox.replace(",", "");
		this.nox = BigDecimal.valueOf(Double.valueOf(nox));
	}

	public BigDecimal getH2o() {
		return h2o;
	}

	public void setH2o(String h2o) {
		h2o = StringUtils.isBlank(h2o) ? "0" : h2o.replace(",", "");
		this.h2o = BigDecimal.valueOf(Double.valueOf(h2o));
	}

	public BigDecimal getFineParticle() {
		return fineParticle;
	}

	public void setFineParticle(String fineParticle) {
		fineParticle = StringUtils.isBlank(fineParticle) ? "0" : fineParticle.replace(",", "");
		this.fineParticle = BigDecimal.valueOf(Double.valueOf(fineParticle));
	}

	public BigDecimal getVoc() {
		return voc;
	}

	public void setVoc(String voc) {
		voc = StringUtils.isBlank(voc) ? "0" : voc.replace(",", "");
		this.voc = BigDecimal.valueOf(Double.valueOf(voc));
	}

	public BigDecimal getNitrogen() {
		return nitrogen;
	}

	public void setNitrogen(String nitrogen) {
		nitrogen = StringUtils.isBlank(nitrogen) ? "0" : nitrogen.replace(",", "");
		this.nitrogen = BigDecimal.valueOf(Double.valueOf(nitrogen));
	}

	public BigDecimal getPhosphorus() {
		return phosphorus;
	}

	public void setPhosphorus(String phosphorus) {
		phosphorus = StringUtils.isBlank(phosphorus) ? "0" : phosphorus.replace(",", "");
		this.phosphorus = BigDecimal.valueOf(Double.valueOf(phosphorus));
	}

	public BigDecimal getBondBalance() {
		return bondBalance;
	}

	public void setBondBalance(String bondBalance) {
		bondBalance = StringUtils.isBlank(bondBalance) ? "0" : bondBalance.replace(",", "");
		this.bondBalance = BigDecimal.valueOf(Double.valueOf(bondBalance));
	}

	public BigDecimal getBillBalance() {
		return billBalance;
	}

	public void setBillBalance(String billBalance) {
		billBalance = StringUtils.isBlank(billBalance) ? "0" : billBalance.replace(",", "");
		this.billBalance = BigDecimal.valueOf(Double.valueOf(billBalance));
	}

	public BigDecimal getCreditBalance() {
		return creditBalance;
	}

	public void setCreditBalance(String creditBalance) {
		creditBalance = StringUtils.isBlank(creditBalance) ? "0" : creditBalance.replace(",", "");
		this.creditBalance = BigDecimal.valueOf(Double.valueOf(creditBalance));
	}

}
