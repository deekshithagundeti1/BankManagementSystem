package com.bms.customer.response;

/**
 * @author javacloudmc446
 *
 */
public class CustomResponse {

	private int httpStatus;
	private String message;
	private Object object;

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomResponse() {
		super();
	}

	public CustomResponse(int httpStatus, String message, Object object) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
		this.object = object;
	}

	

}
