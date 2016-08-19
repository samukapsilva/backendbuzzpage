#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;

import ${package}.entity.Texto;
import ${package}.rest.serviceutil.Constants;

public class StringUtil {
	private static final String STYLE = "</style>";
	private static final String REGEX_HTML_TAGS = "<(.|${symbol_escape}n)*?>";
	public static final String DD_MM_YYYY = "dd/MM/yyyy";

	public static final String DD_MM_YYYY_HORARIO = "dd/mm/yyyy HH:mm:ss";

	public static final String DATA_PT_HIFEN_SEPARADOR = "dd-MM-yyyy";
	private static final Random RANDOM = new SecureRandom();
	public static final int PASSWORD_LENGTH = 8;

	public static String html2text(String html) {

		if (html == null) {
			return null;
		}

		return html.replaceAll(REGEX_HTML_TAGS, "");
	}

	public static String dateToString(Date date, String formato) {
		if (date == null) {
			return null;
		}
		DateFormat df = new SimpleDateFormat(formato);
		String reportDate = df.format(date);
		return reportDate;
	}

	public static Date formataData(String data, String formato)
			throws ParseException {
		if ((data == null) || (data.equals(""))) {
			return null;
		}
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat(formato);
			date = formatter.parse(data);
		} catch (ParseException e) {
			throw e;
		}
		return date;
	}

	public static String generateRandomPassword() {
		String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789";

		String pw = "";
		for (int i = 0; i < 10; i++) {
			int index = (int) (RANDOM.nextDouble() * letters.length());
			pw = pw + letters.substring(index, index + 1);
		}
		return pw;
	}

	public static String generateRandomNumber() {
		String letters = "0123456789";

		String pw = "";
		for (int i = 0; i < 8; i++) {
			int index = (int) (RANDOM.nextDouble() * letters.length());
			pw = pw + letters.substring(index, index + 1);
		}
		return pw;
	}

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); // minus number would decrement the days
		return cal.getTime();
	}

	public static String removeZerosEsquerda(String numero) {

		return String.valueOf(Long.parseLong(numero));

	}

	public static String formatValorFinanceiro(double valor) {

		Currency currency = Currency.getInstance("BRL");
		DecimalFormat formato = new DecimalFormat("${symbol_pound},${symbol_pound}${symbol_pound}0.00");

		return formato.format(valor);

	}

	public static String inserirPonto(String numero) {
		if (numero == null || numero.length() < 3) {
			return numero;
		}
		return new StringBuilder(numero).insert(numero.length() - 2, ".")
				.toString();

	}

	public static String value = "Ca�apavalz��ndio �lt�a Concei��o Sodr� CONCEI��O SODR�";

	public static void main(String args[]) throws Exception {

		String word = "<img src='user_images/uploads/31413148232_1374498349242440_76530028_o.jpg'";

		String nova = StringUtils.replace(word, "user_images/",
				"http://www.buzzpage.com.br/user_images/");

		System.out.println(nova);

	}

	public static String criarSlug(String titulo) {

		if (titulo == null || titulo.length() == 0) {
			return titulo;
		}

		String novoTitulo = titulo.replaceAll("${symbol_escape}${symbol_escape}s+", " ").replace(",", "");
		novoTitulo = novoTitulo.replaceAll("${symbol_escape}${symbol_escape}s+", " ").replace(".", "");
		novoTitulo = novoTitulo.replaceAll("${symbol_escape}${symbol_escape}s+", " ").replace("!", "");

		novoTitulo = removeSpecialCaracters(novoTitulo).trim()
				.replaceAll(" +", " ").replace(" ", "-").toLowerCase();

		novoTitulo = novoTitulo.replace("|", "");
		novoTitulo = novoTitulo.replace("/", "");
		novoTitulo = novoTitulo.replace("/", "");
		novoTitulo = novoTitulo.replace("|", "");
		novoTitulo = novoTitulo.replace(")", "");
		novoTitulo = novoTitulo.replace("(", "");
		novoTitulo = novoTitulo.replace("{", "");
		novoTitulo = novoTitulo.replace("}", "");
		novoTitulo = novoTitulo.replace("?", "");
		novoTitulo = novoTitulo.replace("!", "");
		novoTitulo = novoTitulo.replace("%", "");
		novoTitulo = novoTitulo.replace("@", "");
		novoTitulo = novoTitulo.replace("+", "");
		novoTitulo = novoTitulo.replace("%", "");
		novoTitulo = novoTitulo.replace("=", "");
		novoTitulo = novoTitulo.replace("~", "");
		novoTitulo = novoTitulo.replace("^", "");
		novoTitulo = novoTitulo.replace(":", "");
		novoTitulo = novoTitulo.replace("<", "");
		novoTitulo = novoTitulo.replace(">", "");

		novoTitulo = novoTitulo.replace("----", "-");
		novoTitulo = novoTitulo.replace("---", "-");
		novoTitulo = novoTitulo.replace("--", "-");

		return novoTitulo;

	}

	public static long calcularMinutosEntreDatas(long dt1, long dt2) {
		long diferenca = dt2 - dt1;
		return diferenca / 1000 / 60;
	}

	public static String removeSpecialCaracters(String str) {
		String nfdNormalizedString = Normalizer.normalize(str,
				Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("${symbol_escape}${symbol_escape}p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}

	public static byte[] fileToByteArray(String fileLocation)
			throws IOException {

		File file = new File(fileLocation);

		byte[] fileInBytes = new byte[(int) file.length()];

		InputStream inputStream = null;
		try {

			inputStream = new FileInputStream(file);

			inputStream.read(fileInBytes);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			inputStream.close();
		}

		return fileInBytes;
	}

	public static int diferencaEmDias(Calendar c1, Calendar c2) {
		long m1 = c1.getTimeInMillis();
		long m2 = c2.getTimeInMillis();

		return (int) ((m2 - m1) / (24 * 60 * 60 * 1000) * 24 * 60);
	}

	// [B@1a46a171 [B@13110f31
	public static String generateTokenEmail() {
		String token = null;

		try {
			// Initialize SecureRandom
			// This is a lengthy operation, to be done only upon
			// initialization of the application
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");

			// generate a random number
			String randomNum = new Integer(prng.nextInt()).toString();

			// get its digest
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] result = sha.digest(randomNum.getBytes());

			token = hexEncode(result);
		} catch (NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}

		return token;
	}

	public static String getPrimeiroEUltimoNome(String nome) {

		if (nome == null) {
			return null;
		}

		String[] nomes = StringUtils.split(nome, Constants.ESPACO);

		StringBuilder nomeRetorno = new StringBuilder(nomes[0]);

		if (nomes.length > 1) {

			nomeRetorno.append(Constants.ESPACO);
			nomeRetorno.append(nomes[nomes.length - 1]);
		}

		return nomeRetorno.toString();
	}

	public static String hexEncode(byte[] aInput) {
		StringBuilder result = new StringBuilder();
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		for (int idx = 0; idx < aInput.length; ++idx) {
			byte b = aInput[idx];
			result.append(digits[(b & 0xf0) >> 4]);
			result.append(digits[b & 0x0f]);
		}
		return result.toString();
	}

	public static String getResumoPost(Texto texto, int cumprimentoResumo) {
		// TODO Auto-generated method stub
		// 250
		if (texto.getTexto() != null) {

			String txt = retiraLixoWord(texto.getTexto());
			txt = txt.replaceAll("${symbol_escape}${symbol_escape}<.*?>", "");
			txt = txt.replaceAll("${symbol_escape}${symbol_escape}<w:.*?>", "");

			int tamanho = txt.length();

			if (tamanho <= cumprimentoResumo) {
				return StringEscapeUtils.unescapeHtml4(txt);
			} else {
				return StringEscapeUtils.unescapeHtml4(txt.substring(0,
						cumprimentoResumo));
			}

		} else {
			if (texto.getResumo() != null) {
				return StringEscapeUtils.unescapeHtml4(texto.getResumo());
			} else {
				return Constants.ESPACO;
			}
		}

	}

	public static String retiraLixoWord(String texto) {

		if (!texto.contains(STYLE)) {
			return texto;
		}
		String limpa = StringUtils.substringAfterLast(texto, STYLE);

		return limpa;

	}

	public static String retiraTagsTinyMCE(String texto) {

		String nohtml = texto.replaceAll("${symbol_escape}${symbol_escape}<p.*?>", "");

		nohtml = nohtml.replaceAll("${symbol_escape}${symbol_escape}<span.*?>", "");
		nohtml = nohtml.replaceAll("${symbol_escape}${symbol_escape}<!--.*?>", "");

		nohtml = nohtml.replaceAll("</p>", "");

		nohtml = nohtml.replaceAll("</span>", "");

		return StringEscapeUtils.unescapeHtml4(nohtml).trim();
	}

}
