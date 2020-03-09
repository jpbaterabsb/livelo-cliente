package com.livelo.client.core.validation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

public abstract class Assert {

	/*
	 * IsTrue and IsFalse
	 */

	public static void isTrue(boolean condition, MessageCode messageCode, Object... messageParams) {
		if (!condition)
			throw new BusinessException(messageCode, messageParams);
	}

	public static void isFalse(boolean condition, MessageCode messageCode, Object... messageParams) {
		if (condition)
			throw new BusinessException(messageCode, messageParams);
	}

	/*
	 * IsNull and IsNotNull
	 */

	public static void isNull(Object value, MessageCode messageCode, Object... messageParams) {
		if (value != null)
			throw new BusinessException(messageCode, messageParams);
	}

	public static void isNotNull(Object value, MessageCode messageCode, Object... messageParams) {
		if (value == null)
			throw new BusinessException(messageCode, messageParams);
	}

	/*
	 * IsEmpty
	 */

	public static void isEmpty(String value, MessageCode messageCode, Object... messageParams) {
		if (value != null && value.trim().length() > 0)
			throw new BusinessException(messageCode, messageParams);
	}

	public static void isEmpty(Collection<?> value, MessageCode messageCode, Object... messageParams) {
		if (value != null && !value.isEmpty())
			throw new BusinessException(messageCode, messageParams);
	}

	public static void isEmpty(Map<?, ?> value, MessageCode messageCode, Object... messageParams) {
		if (value != null && !value.isEmpty())
			throw new BusinessException(messageCode, messageParams);
	}

	public static <T> void isEmpty(T[] value, MessageCode messageCode, Object... messageParams) {
		if (value != null && value.length > 0)
			throw new BusinessException(messageCode, messageParams);
	}

	/*
	 * IsNotEmpty
	 */

	public static void isNotEmpty(String value, MessageCode messageCode, Object... messageParams) {
		if (value == null || value.trim().length() == 0)
			throw new BusinessException(messageCode, messageParams);
	}

	public static void isNotEmpty(Collection<?> value, MessageCode messageCode, Object... messageParams) {
		isNotNull(value, messageCode, messageParams);
		if (value.isEmpty())
			throw new BusinessException(messageCode, messageParams);
	}

	public static void isNotEmpty(Map<?, ?> value, MessageCode messageCode, Object... messageParams) {
		isNotNull(value, messageCode, messageParams);
		if (value.isEmpty())
			throw new BusinessException(messageCode, messageParams);
	}

	public static <T> void isNotEmpty(T[] value, MessageCode messageCode, Object... messageParams) {
		isNotNull(value, messageCode, messageParams);
		if (value.length == 0)
			throw new BusinessException(messageCode, messageParams);
	}

	/*
	 * IsAfter
	 */

	public static void isAfter(LocalDateTime first, LocalDateTime other, MessageCode messageCode, Object... messageParams){
		isNotNull(first,messageCode,messageParams);
		isNotNull(other,messageCode,messageParams);
		if (!first.isAfter(other)){
			throw new BusinessException(messageCode,messageParams);
		}
	}

	public static void isAfter(LocalDate first, LocalDate other, MessageCode messageCode, Object... messageParams){
		isNotNull(first,messageCode,messageParams);
		isNotNull(other,messageCode,messageParams);
		if (!first.isAfter(other)){
			throw new BusinessException(messageCode,messageParams);
		}
	}

	public static void isAfterOrEquals(LocalDateTime first, LocalDateTime other, MessageCode messageCode, Object... messageParams){
		isNotNull(first,messageCode,messageParams);
		isNotNull(other,messageCode,messageParams);
		if (!first.isAfter(other) && !first.equals(other)){
			throw new BusinessException(messageCode,messageParams);
		}
	}

	public static void isAfterOrEquals(LocalDate first, LocalDate other, MessageCode messageCode, Object... messageParams){
		isNotNull(first,messageCode,messageParams);
		isNotNull(other,messageCode,messageParams);
		if (!first.isAfter(other) && !first.equals(other)){
			throw new BusinessException(messageCode,messageParams);
		}
	}


}
