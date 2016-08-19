#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuzzPageException extends RuntimeException {
	private static final long serialVersionUID = -2102338681941803149L;

	@Autowired
	private Properties errors;

	private String message;

	public BuzzPageException() {
		super();
	}

	public void generateException(Throwable cause, Logger log) {
		this.message = BuzzPageErrorHelper.translateErrorMessage(errors, cause);
		StringBuilder sbMessage = new StringBuilder();
		sbMessage.append(message);
		appendCause(cause, sbMessage);
		log.error(sbMessage.toString());
		throw this;
	}

	private void appendCause(Throwable cause, StringBuilder sb) {
		if (cause.getMessage() != null) {
			sb.append(" - ");
			sb.append(cause.getMessage());
			if (cause.getCause() != null) {
				appendCause(cause.getCause(), sb);
			}
		}
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	public void setErrors(Properties errors) {
		this.errors = errors;
	}

}
