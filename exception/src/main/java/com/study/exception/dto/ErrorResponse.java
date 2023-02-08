package com.study.exception.dto;

import java.util.List;

public class ErrorResponse {

	String statusCode;
	StringBuffer requestUrl;
	String code;
	String message;
	String resultCode;
	
	List<Error> errorList;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public StringBuffer getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(StringBuffer stringBuffer) {
		this.requestUrl = stringBuffer;
	}

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

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public List<Error> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<Error> errorList) {
		this.errorList = errorList;
	}
	
	
}
