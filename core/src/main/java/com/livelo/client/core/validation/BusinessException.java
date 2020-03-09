package com.livelo.client.core.validation;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BusinessException extends RuntimeException {

	private MessageCode messageCode;

	private Object[] params;

	public BusinessException(MessageCode messageCode, Object... params) {
		this(null, messageCode, params);
	}

	public BusinessException(Throwable cause, MessageCode messageCode, Object... params) {
		super(messageCode.code(), cause);
		this.messageCode = messageCode;
		this.params = params;
	}

	public static void throwNew(MessageCode messageCode, Object... params) {
		throw new BusinessException(messageCode, params);
	}

}
