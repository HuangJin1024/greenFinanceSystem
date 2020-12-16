package com.hzhx.greenFinance.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hzhx.greenFinance.vo.children.EnterpriseInfo;
import com.hzhx.greenFinance.vo.children.Environment;
import com.hzhx.greenFinance.vo.children.IndividualInfo;

/**
 * 客户环境、安全信息
 * 
 * @author hzhx
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "customer")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "customerNo", "customerTypeCd", "individualInfo", "enterpriseInfo", "environment" })
public class CustomerEnvironmentInfo implements Serializable {  
    private static final long serialVersionUID = 1L;
	private String customerNo;
	private String customerTypeCd;
	private IndividualInfo individualInfo;
	private EnterpriseInfo enterpriseInfo;
	@XmlElementWrapper(name = "environments")
	private List<Environment> environment;
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getCustomerTypeCd() {
		return customerTypeCd;
	}
	public void setCustomerTypeCd(String customerTypeCd) {
		this.customerTypeCd = customerTypeCd;
	}
	public IndividualInfo getIndividualInfo() {
		return individualInfo;
	}
	public void setIndividualInfo(IndividualInfo individualInfo) {
		this.individualInfo = individualInfo;
	}
	
	public EnterpriseInfo getEnterpriseInfo() {
		return enterpriseInfo;
	}
	public void setEnterpriseInfo(EnterpriseInfo enterpriseInfo) {
		this.enterpriseInfo = enterpriseInfo;
	}
	public List<Environment> getEnvironment() {
		return environment;
	}
	public void setEnvironment(List<Environment> environment) {
		this.environment = environment;
	}
}
