package com.mypack.constants;

public enum ErrorCodeEnum {

	GENERIC_EXCEPTION("10000", "Unable to process your request, please try again later."),
	PAYMENT_NOT_FOUND("10001", "Payment Not found with provided id."),
	INVALID_CREDENTIALS("10003", "You provide invalid email or password please retry again.");


	private final String errorCode;

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	private final String errorMessage;

	ErrorCodeEnum(String errorCode, String errorMessage) {

		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
