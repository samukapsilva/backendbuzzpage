package br.com.buzzpage.rest.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.buzzpage.entity.Pessoa;
import br.com.buzzpage.rest.serviceutil.TemplateConstants;
import br.com.buzzpage.util.BuzzPageMailSender;
import br.com.buzzpage.vo.FormContatoVo;
import br.com.buzzpage.vo.StatusVo;

/**
 * 
 * Service class that handles REST Conteudo requests
 * 
 * @author Alexandre Parreira
 * 
 */
@Component
@Path("/emailService")
public class EmailRestService {

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo enviarEmail(FormContatoVo contatoVo) {

		Map<String, String> parametros = new HashMap<String, String>();

		Pessoa reginaldo = new Pessoa();
		reginaldo.setNome("BuzzPage");
		reginaldo.setEmail("contato@descubranet.com.br");

		reginaldo.setSenha("brazil12");

		StringBuilder html = new StringBuilder("Contato BuzzPage: <br/><br/>");

		html.append("Tipo de Contato: ").append(contatoVo.getTipoContato()).append("<br/>");
		html.append("Nome: ").append(contatoVo.getNome()).append("<br/>");
		html.append("Email: ").append(contatoVo.getEmail()).append("<br/>");
		html.append("Telefone: ").append(contatoVo.getTelefone()).append("<br/>");
		html.append("Cidade: ").append(contatoVo.getCidade()).append("<br/>");
		html.append("Estado: ").append(contatoVo.getEstado()).append("<br/>");
		html.append("Assunto: ").append(contatoVo.getAssunto()).append("<br/>");
		html.append("Mensagem: ").append(contatoVo.getMensagem()).append("<br/>");

		parametros.put("html", html.toString());

		BuzzPageMailSender.sendMailGeneric(reginaldo, parametros, TemplateConstants.TEMPLATE_EMAIL_MSG_DIRECAO,
				"Contato Site");

		StatusVo status = new StatusVo();

		return status;

	}

}
