package br.com.buzzpage.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

public class BuzzPageErrorHelper {

	private static final Map<Class<? extends RuntimeException>, String> MAP_CAUSE_ERROR_CODE = new HashMap<>();
	private static final String ERROR_NOT_MAPPED = "001";
	private static final String ERROR_ENTITY_EXISTS = "100";
	private static final String ERROR_ILLEGAL_ARGUMENT = "101";
	private static final String ERROR_TRANSACTION_REQUIRED = "102";
	private static final String ERROR_PERSISTENCE = "103";

	static {
		MAP_CAUSE_ERROR_CODE.put(EntityExistsException.class, ERROR_ENTITY_EXISTS);
		MAP_CAUSE_ERROR_CODE.put(IllegalArgumentException.class, ERROR_ILLEGAL_ARGUMENT);
		MAP_CAUSE_ERROR_CODE.put(TransactionRequiredException.class, ERROR_TRANSACTION_REQUIRED);
		MAP_CAUSE_ERROR_CODE.put(PersistenceException.class, ERROR_PERSISTENCE);
	}

	private BuzzPageErrorHelper() {

	}

	public static String translateErrorMessage(Properties errors, Throwable cause) {
		if (cause.getClass().equals(RuntimeException.class)) {
			cause = cause.getCause();
		}
		String errorCode = MAP_CAUSE_ERROR_CODE.get(cause.getClass());
		if (errorCode == null) {
			errorCode = ERROR_NOT_MAPPED;
		}
		StringBuilder sbErrorCodeAndMessage = new StringBuilder();
		sbErrorCodeAndMessage.append(errorCode);
		sbErrorCodeAndMessage.append(" - ");
		sbErrorCodeAndMessage.append(errors.getProperty(errorCode));
		return sbErrorCodeAndMessage.toString();
	}

}
