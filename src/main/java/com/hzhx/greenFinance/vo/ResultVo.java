package com.hzhx.greenFinance.vo;


/**
 * 固定返回格式
 * @author hzhx
 *
 */
public class ResultVo {

    /**
     * 错误码
     */
    private String code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 具体的内容
     */
    private Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
