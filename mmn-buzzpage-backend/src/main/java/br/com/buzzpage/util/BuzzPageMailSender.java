package br.com.buzzpage.util;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.github.sendgrid.SendGrid;

import br.com.buzzpage.entity.Pessoa;
import br.com.buzzpage.rest.serviceutil.Constants;
import br.com.buzzpage.rest.serviceutil.TemplateConstants;
import br.com.buzzpage.vo.MailVO;
import br.com.buzzpage.vo.StatusVo;

public class BuzzPageMailSender {

	private static final String NOREPLY_MAXTRACASH_COM_BR = "noreply@injete.com";
	private static final String ERRO_MULTIPLOS_DESTINATARIOS = "Imposs�vel mandar esse email para mais de um usu�rio";
	private static final String TIPO_SENHA = "tipoSenha";
	private static final String SENHA = "senha";
	private static final String USUARIO = "usuario";
	private static final String NOME = "nome";

	private static VelocityContext context = new VelocityContext();
	static final Logger logger = Logger.getLogger(BuzzPageMailSender.class.getName());

	public static void main(String[] args) {

		MailVO mailVO = new MailVO();
		mailVO.setAssuntoEmail("Teste");
		mailVO.setEmailDestinatario("alexhparreira@gmail.com");
		mailVO.setHtmlEmail(TemplateConstants.TEMPLATE_MSG_BOAS_VINDAS);
		//
		Map<String, String> parametros = new HashMap<String, String>();
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Reginaldo Pereira");
		pessoa.setEmail("alexhparreira@gmail.com");
		pessoa.setSenha("brazil12");
		parametros.put("html", "<hr><br>Teste html enviado<br/>Teste<b> testando</b> novo");

		// sendMailEsqueciSenha(pessoa, Constants.TIPO_SENHA_ACESSO, "fkjsal");
		//

		sendMailGeneric(pessoa, parametros, TemplateConstants.TEMPLATE_EMAIL_MSG_DIRECAO, "Novo Cadastro BuzzPage");
		// sendMailGeneric(pessoa , parametros,
		// TemplateConstants.TEMPLATE_MSG_BOAS_VINDAS,
		// Constants.MSG_BOAS_VINDAS_MASCULINO);

	}

	public static StatusVo sendMail(MailVO mailVO, Map<String, String> parametros) {
		StatusVo status = new StatusVo();

		SendGrid sendgrid = new SendGrid(Constants.EMAIL_USER, Constants.PASSWORD_EMAIL_USER);

		sendgrid.addTo("alexlinkjur@gmail.com");
		sendgrid.setFrom("alexhparreira@gmail.com");
		sendgrid.setSubject("Email do Java");

		String html = getHtml(mailVO, parametros);

		sendgrid.setHtml(html);
		sendgrid.send();

		return status;
	}

	public static void sendMailAlert(String mensagem, String titulo, String destinatario) {

		SendGrid sendgrid = new SendGrid(Constants.EMAIL_USER, Constants.PASSWORD_EMAIL_USER);

		sendgrid.addTo(destinatario);
		sendgrid.setFrom(NOREPLY_MAXTRACASH_COM_BR);
		sendgrid.setSubject(titulo);

		sendgrid.setText(mensagem);
		sendgrid.send();

	}

	public static StatusVo sendMailToPessoaes(String templateName, List<Pessoa> consultores) {

		StatusVo status = new StatusVo();
		Template template = null;

		logger.info("Preparando p enviar o email: ");

		List<String> listaSucesso = new ArrayList<String>();
		List<String> listaFalha = new ArrayList<String>();

		Velocity.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
		try {
			Velocity.init();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (Pessoa consultor : consultores) {

			SendGrid sendgrid = null;
			sendgrid = new SendGrid(Constants.EMAIL_USER, Constants.PASSWORD_EMAIL_USER);

			if (consultor.getEmail() == null) {
				continue;
			}
			logger.info(consultor.getEmail());
			context.put(NOME, consultor.getNome());
			context.put(USUARIO, consultor.getUsuario());

			try {

				sendgrid.setFrom(Constants.EMAIL_NO_REPLY);
				sendgrid.setFromName(Constants.DOMINIO);

				// "runtime.log.logsystem.class",
				// "org.apache.velocity.runtime.log.NullLogSystem");
				StringWriter swOut = new StringWriter();
				Velocity.evaluate(context, swOut, "log tag name", templateName);

				sendgrid.addTo(consultor.getEmail());

				sendgrid.addToName(consultor.getNome());

				if (consultor.getIdSexo() != null && consultor.getIdSexo() == Constants.ID_FEMININO) {
					sendgrid.setSubject(Constants.MSG_BOAS_VINDAS_FEMININO);
				} else {
					sendgrid.setSubject(Constants.MSG_BOAS_VINDAS_MASCULINO);
				}

				sendgrid.setHtml(swOut.toString());

				sendgrid.send();

			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Exception caught: " + e.getMessage());
				listaFalha.add(consultor.getUsuario());

			}

		}

		status.setChave(Constants.CHAVE_OK);
		StringBuffer sb = new StringBuffer();
		sb.append("Emails enviados com sucesso: ");
		sb.append(listaSucesso.size());
		sb.append(Constants.ESPACO_HIFENS);
		sb.append(listaSucesso);
		sb.append("Emails com erro: ");
		sb.append(listaFalha.size());
		sb.append(Constants.ESPACO_HIFENS);
		sb.append(listaFalha);

		status.setMensagem(sb.toString());
		return status;

	}

	private static String getHtml(MailVO mailVO, Map<String, String> parametros) {

		return null;

	}

	public static void sendMailMaquinaVendas(Pessoa consultor, Map<String, String> parametros, String templateName,
			String emailTitle, String emailRemetente) {

		Velocity.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
		try {
			Velocity.init();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		SendGrid sendgrid = new SendGrid(Constants.EMAIL_USER, Constants.PASSWORD_EMAIL_USER);

		logger.info(consultor.getEmail());

		context.put(NOME, consultor.getNome());
		context.put(USUARIO, consultor.getUsuario());

		Iterator ite = parametros.entrySet().iterator();

		while (ite.hasNext()) {

			Map.Entry entry = (Map.Entry) ite.next();
			String key = (String) entry.getKey();

			context.put(key, parametros.get(key));
		}

		try {

			sendgrid.setFrom(Constants.EMAIL_NO_REPLY);
			sendgrid.setFromName(Constants.DOMINIO);

			StringWriter swOut = new StringWriter();
			Velocity.evaluate(context, swOut, "log tag name", templateName);

			sendgrid.addTo(consultor.getEmail());
			sendgrid.addToName(consultor.getNome());
			sendgrid.setSubject(emailTitle);
			sendgrid.setHtml(swOut.toString());
			sendgrid.send();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception caught: " + e.getMessage());

		}
	}

	public static void sendMailGeneric(Pessoa pessoa, Map<String, String> parametros, String templateName,
			String emailTitle) {

		Velocity.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
		try {
			Velocity.init();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		SendGrid sendgrid = new SendGrid(Constants.EMAIL_USER, Constants.PASSWORD_EMAIL_USER);

		logger.info(pessoa.getEmail());

		context.put(NOME, pessoa.getNome());
		context.put(USUARIO, pessoa.getUsuario());

		Iterator ite = parametros.entrySet().iterator();

		while (ite.hasNext()) {

			Map.Entry entry = (Map.Entry) ite.next();
			String key = (String) entry.getKey();

			context.put(key, parametros.get(key));
		}

		try {

			sendgrid.setFrom(Constants.EMAIL_NO_REPLY);
			sendgrid.setFromName(Constants.DOMINIO);

			StringWriter swOut = new StringWriter();
			Velocity.evaluate(context, swOut, "log tag name", templateName);

			sendgrid.addTo(pessoa.getEmail());
			sendgrid.addToName(pessoa.getNome());
			sendgrid.setSubject(emailTitle);
			sendgrid.setHtml(swOut.toString());
			sendgrid.send();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception caught: " + e.getMessage());

		}
	}

	public static void sendMailCorpoEmpresa(Pessoa pessoa, Map<String, String> parametros, String templateName,
			String emailTitle) {

		Velocity.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
		try {
			Velocity.init();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		SendGrid sendgrid = new SendGrid(Constants.EMAIL_USER, Constants.PASSWORD_EMAIL_USER);

		logger.info(pessoa.getEmail());

		Iterator ite = parametros.entrySet().iterator();

		while (ite.hasNext()) {

			Map.Entry entry = (Map.Entry) ite.next();
			String key = (String) entry.getKey();

			context.put(key, parametros.get(key));
		}

		try {

			sendgrid.setFrom(Constants.EMAIL_NO_REPLY);
			sendgrid.setFromName(Constants.DOMINIO);

			StringWriter swOut = new StringWriter();
			Velocity.evaluate(context, swOut, "log tag name", templateName);

			sendgrid.addTo(pessoa.getEmail());
			sendgrid.addToName(pessoa.getNome());
			sendgrid.setSubject(emailTitle);
			sendgrid.setHtml(swOut.toString());
			sendgrid.send();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception caught: " + e.getMessage());

		}
	}

	public static void sendMailParameters(Pessoa consultor, Map<String, String> parametros, String templateName,
			String emailTitle) {

		Velocity.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
		try {
			Velocity.init();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		SendGrid sendgrid = new SendGrid(Constants.EMAIL_USER, Constants.PASSWORD_EMAIL_USER);

		Iterator ite = parametros.entrySet().iterator();

		while (ite.hasNext()) {

			Map.Entry entry = (Map.Entry) ite.next();
			String key = (String) entry.getKey();

			context.put(key, parametros.get(key));
		}

		try {

			sendgrid.setFrom(Constants.EMAIL_NO_REPLY);
			sendgrid.setFromName(Constants.DOMINIO);

			StringWriter swOut = new StringWriter();
			Velocity.evaluate(context, swOut, "log tag name", templateName);

			sendgrid.addTo(consultor.getEmail());
			sendgrid.addToName(consultor.getNome());
			sendgrid.setSubject(emailTitle);
			sendgrid.setHtml(swOut.toString());
			sendgrid.send();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void sendMailEsqueciSenha(Pessoa pessoa, int tipoSenha, String randomPassword) {

		Velocity.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");

		try {
			Velocity.init();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		SendGrid sendgrid = new SendGrid(Constants.EMAIL_USER, Constants.PASSWORD_EMAIL_USER);

		logger.info(pessoa.getEmail());

		context.put(NOME, pessoa.getNome());
		// context.put(USUARIO, consultor.getUsuario());
		context.put(SENHA, randomPassword);

		if (tipoSenha == Constants.TIPO_SENHA_ACESSO) {
			context.put(TIPO_SENHA, Constants.SENHA_ACESSO);
		} else {
			context.put(TIPO_SENHA, Constants.SENHA_SEGURANCA);
		}

		try {

			sendgrid.setFrom(Constants.EMAIL_NO_REPLY);
			sendgrid.setFromName(Constants.DOMINIO);

			StringWriter swOut = new StringWriter();
			Velocity.evaluate(context, swOut, "log tag name", TemplateConstants.TEMPLATE_MENSAGEM_RECUPERAR_SENHA);

			sendgrid.addTo(pessoa.getEmail());
			sendgrid.addToName(pessoa.getNome());

			if (tipoSenha == Constants.TIPO_SENHA_ACESSO) {
				sendgrid.setSubject(Constants.TITULO_ALTERACAO_SENHA);
			} else {
				sendgrid.setSubject(Constants.TITULO_ALTERACAO_SENHA_SEGURANCA);

			}

			sendgrid.setHtml(swOut.toString());

			if (sendgrid.getToNames().size() == 1) {
				sendgrid.send();
			} else {
				throw new Exception(ERRO_MULTIPLOS_DESTINATARIOS);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception caught: " + e.getMessage());

		}
	}

	public static void sendMailTemplate(Pessoa consultor, String templateName, Map<String, String> parameters,
			String titulo) {

		Velocity.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
		try {
			Velocity.init();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		SendGrid sendgrid = new SendGrid(Constants.EMAIL_USER, Constants.PASSWORD_EMAIL_USER);

		logger.info(consultor.getEmail());

		context.put(NOME, consultor.getNome());
		context.put(USUARIO, consultor.getUsuario());

		Iterator ite = parameters.entrySet().iterator();

		while (ite.hasNext()) {

			Map.Entry entry = (Map.Entry) ite.next();
			String key = (String) entry.getKey();

			context.put(key, parameters.get(key));
		}

		try {

			sendgrid.setFrom(Constants.EMAIL_NO_REPLY);
			sendgrid.setFromName(Constants.DOMINIO);

			StringWriter swOut = new StringWriter();
			Velocity.evaluate(context, swOut, "log tag name", templateName);

			sendgrid.addTo(consultor.getEmail());
			sendgrid.addToName(consultor.getNome());
			sendgrid.setSubject(titulo);
			sendgrid.setHtml(swOut.toString());

			if (sendgrid.getToNames().size() == 1) {
				sendgrid.send();
			} else {
				throw new Exception(ERRO_MULTIPLOS_DESTINATARIOS);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exception caught: " + e.getMessage());

		}
	}

}