#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest.serviceutil;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

public class PasswordEncryption {
	private static final String ALGORITM_ENCRYPT = "SHA-512";
	private static ConfigurablePasswordEncryptor encryptor;

	public static String encrypt(String password) {
		configureEncryptor();

		return encryptor.encryptPassword(password);
	}

	public static boolean checkPassword(String inputPassword,
			String encryptedPassword) {
		configureEncryptor();
		return encryptor.checkPassword(inputPassword, encryptedPassword);
	}

	private static void configureEncryptor() {
		if (encryptor == null) {
			encryptor = new ConfigurablePasswordEncryptor();
			encryptor.setAlgorithm(ALGORITM_ENCRYPT);
		}
	}
}
