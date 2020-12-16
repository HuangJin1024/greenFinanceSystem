package com.hzhx.greenFinance.vo.children;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 个人信息
 * @author hzhx
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
//XML文件中的根标识
@XmlRootElement(name = "individualInfo")
//控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {   
        "individualName",   
        "documentType",   
        "documentNumber",   
        "gender",   
        "educationDegree",   
        "birthday",   
        "industryCd",   
        "careerTypeCd",   
        "career",   
        "majorBusiness",   
        "isFarmer"
}) 
public class IndividualInfo {
	private String individualName;
	private String documentType;
	private String documentNumber;
	private String gender;
	private String educationDegree;
	private String birthday;
	private String industryCd;
	private String careerTypeCd;
	private String career;
	private String majorBusiness;
	private String isFarmer;
	public String getIndividualName() {
		return individualName;
	}
	public void setIndividualName(String individualName) {
		this.individualName = individualName;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEducationDegree() {
		return educationDegree;
	}
	public void setEducationDegree(String educationDegree) {
		this.educationDegree = educationDegree;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIndustryCd() {
		return industryCd;
	}
	public void setIndustryCd(String industryCd) {
		this.industryCd = industryCd;
	}
	public String getCareerTypeCd() {
		return careerTypeCd;
	}
	public void setCareerTypeCd(String careerTypeCd) {
		this.careerTypeCd = careerTypeCd;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getMajorBusiness() {
		return majorBusiness;
	}
	public void setMajorBusiness(String majorBusiness) {
		this.majorBusiness = majorBusiness;
	}
	public String getIsFarmer() {
		return isFarmer;
	}
	public void setIsFarmer(String isFarmer) {
		this.isFarmer = isFarmer;
	}
	
}
