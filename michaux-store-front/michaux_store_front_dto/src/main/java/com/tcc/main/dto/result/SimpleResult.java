package com.tcc.main.dto.result;

/**
 * @Description 结果
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月31日 下午2:43:36
 */
public class SimpleResult {

	/**
	 * 返回的信息
	 */
	private String message;
	
	/**
	 * 返回的状态码
	 */
	private Integer code;
	
	/**
	 * 返回的数据
	 */
	private Object value;
	
	/**
	 * 操作是否成功
	 */
	private boolean success;
	
	public SimpleResult(){}

	public SimpleResult(String message, Integer code, Object value, boolean success) {
		super();
		this.message = message;
		this.code = code;
		this.value = value;
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
