package com.hzhx.greenFinance.renHangVo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "personal")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "personalNo", "personalName", "documentType", "documentNumber", "gender", "educationDegree",
		"dateOfBirth", "personalIndustryCd", "personalTypeCd", "personalMajorBusiness" })
public class Personal {
	private String personalNo;
	private String personalName;
	private String documentType;
	private String documentNumber;
	private String gender;
	private String educationDegree;
	private String dateOfBirth;
	private String personalIndustryCd;
	private String personalTypeCd;
	private String personalMajorBusiness;
	public String getPersonalNo() {
		return personalNo;
	}
	public void setPersonalNo(String personalNo) {
		this.personalNo = personalNo;
	}
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPersonalIndustryCd() {
		return personalIndustryCd;
	}
	public void setPersonalIndustryCd(String personalIndustryCd) {
		this.personalIndustryCd = personalIndustryCd;
	}
	public String getPersonalTypeCd() {
		return personalTypeCd;
	}
	public void setPersonalTypeCd(String personalTypeCd) {
		this.personalTypeCd = personalTypeCd;
	}
	public String getPersonalMajorBusiness() {
		return personalMajorBusiness;
	}
	public void setPersonalMajorBusiness(String personalMajorBusiness) {
		this.personalMajorBusiness = personalMajorBusiness;
	}
	
}
