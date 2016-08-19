#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.vo;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
public class MailVO {

	private String nomeDestinatario;
	private String emailDestinatario;
	private String htmlEmail;
	private String assuntoEmail;
	private String templateEmail;

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getEmailDestinatario() {
		return emailDestinatario;
	}

	public void setEmailDestinatario(String emailDestinatario) {
		this.emailDestinatario = emailDestinatario;
	}

	public String getHtmlEmail() {
		return htmlEmail;
	}

	public void setHtmlEmail(String htmlEmail) {
		this.htmlEmail = htmlEmail;
	}

	public String getAssuntoEmail() {
		return assuntoEmail;
	}

	public void setAssuntoEmail(String assuntoEmail) {
		this.assuntoEmail = assuntoEmail;
	}

	public String getTemplateEmail() {
		return templateEmail;
	}

	public void setTemplateEmail(String templateEmail) {
		this.templateEmail = templateEmail;
	}

}
