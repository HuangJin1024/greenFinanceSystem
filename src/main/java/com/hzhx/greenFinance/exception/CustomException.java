package com.hzhx.greenFinance.exception;


import com.hzhx.greenFinance.Enum.ResultEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * 自定义异常
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 状态码
     */
    private final String code;

    /**
     * 方法名称
     */
    private final String method;


    public String getCode() {
		return code;
	}

	public String getMethod() {
		return method;
	}

	/**
     * 自定义异常
     *
     * @param resultEnum 返回枚举对象
     * @param method     方法
     */
    public CustomException(ResultEnum resultEnum, String method) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
        this.method = method;
    }

    /**
     * @param code    状态码
     * @param message 错误信息
     * @param method  方法
     */
    public CustomException(String code, String message, String method) {
        super(message);
        this.code = code;
        this.method = method;
    }

}
