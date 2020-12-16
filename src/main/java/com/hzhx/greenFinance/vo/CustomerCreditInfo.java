package com.hzhx.greenFinance.vo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.hzhx.greenFinance.vo.children.Credit;
import com.hzhx.greenFinance.vo.children.EnterpriseInfo;

/**
 * 客户绿色信用证信息
 * 
 * @author hzhx
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "customer")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = { "customerNo", "customerTypeCd", "enterpriseInfo", "credit" })
public class CustomerCreditInfo implements Serializable {  
    private static final long serialVersionUID = 1L;
	private String customerNo;
	private String customerTypeCd;
	private EnterpriseInfo enterpriseInfo;
	@XmlElementWrapper(name = "credits")
	private List<Credit> credit;
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
	public EnterpriseInfo getEnterpriseInfo() {
		return enterpriseInfo;
	}
	public void setEnterpriseInfo(EnterpriseInfo enterpriseInfo) {
		this.enterpriseInfo = enterpriseInfo;
	}
	public List<Credit> getCredit() {
		return credit;
	}
	public void setCredit(List<Credit> credit) {
		this.credit = credit;
	}

}
