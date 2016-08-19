package br.com.buzzpage.rest.service;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.buzzpage.business.service.ConteudoColaboradorService;
import br.com.buzzpage.business.service.MensagemService;
import br.com.buzzpage.entity.Mensagem;
import br.com.buzzpage.rest.serviceutil.Constants;
import br.com.buzzpage.vo.DadosGrid;
import br.com.buzzpage.vo.MensagemVo;
import br.com.buzzpage.vo.StatusVo;
import br.com.buzzpage.vo.TextoVo;

/**
 * 
 * Service class that handles REST Conteudo requests
 * 
 * @author Alexandre Parreira
 * 
 */
@Component
@Path("/mensagens")
public class MensagemRestService {

	@Autowired
	private ConteudoColaboradorService conteudoService;

	@Autowired
	private MensagemService mensagemService;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo criarMensagem(MensagemVo mensagemVo) {

		StatusVo status = new StatusVo();

		Mensagem mensagem = mensagemService.criarMensagem(mensagemVo);
		boolean result = (mensagem != null && mensagem.getId() != null);

		if (result) {
			status.setChave(Constants.UM);
			status.setIdCadastrado(mensagem.getId());
			status.setValor(Constants.CHAVE_OK);
		} else {
			status.setChave(Constants.ZERO);
			status.setValor(Constants.CHAVE_ERRO);
		}

		return status;

	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response findById(@PathParam("id") Long id)
			throws JsonGenerationException, JsonMappingException, IOException {

		MensagemVo mensagemVo = mensagemService.getMensagemVoById(id);

		if (mensagemVo != null) {
			return Response.status(200).entity(mensagemVo).header("Access-Control-Allow-Headers", "X-extra-header")
					.allow("OPTIONS").build();
		} else {
			return Response.status(404).entity("The podcast with the id " + id + " does not exist").build();
		}
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public Response updateMensagem(TextoVo textoVo) {

		String message;
		int status;

		if (textoVo.getIdTexto() != null) {
			conteudoService.updateConteudo(textoVo);
			status = 200; // OK
			message = "Podcast has been updated";
		} else if (objetoPodeSerCriado(textoVo)) {
			conteudoService.salvarConteudo(textoVo);
			status = 201; // Created
			message = "Conteudo adicionado";
		} else {
			status = 406; // Not acceptable
			message = "Permiss�o negada";
		}

		return Response.status(status).entity(message).build();
	}

	/************************************ READ ************************************/
	/**
	 * Returns all resources (podcasts) from the database
	 * 
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public List<TextoVo> getTextos() throws JsonGenerationException, JsonMappingException, IOException {
		List<TextoVo> textos = conteudoService.listarTextos();
		return textos;
	}

	private boolean objetoPodeSerCriado(TextoVo textoVo) {
		// TODO Auto-generated method stub
		return true;
	}

	@GET
	@Path("gridMensagens/{idColaborador}/{idConteudo}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Transactional
	public DadosGrid gridConteudosColaborador(@PathParam("idColaborador") Long idColaborador,
			@PathParam("idConteudo") Long idConteudo)
			throws JsonGenerationException, JsonMappingException, IOException {

		DadosGrid retorno = mensagemService.montarGridMensagens(idColaborador, idConteudo);

		return retorno;
	}

	/************************************ DELETE ************************************/
	@DELETE
	@Path("{id}/{idPessoa}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo deleteMensagens(@PathParam("id") Long id, @PathParam("idPessoa") Long idPessoa) {

		StatusVo status = new StatusVo();

		if (mensagemService.deletarMensagemRemetente(id, idPessoa)) {

			status.setValor(Constants.UM);
			status.setChave(Constants.CHAVE_OK);

		} else {

			status.setValor(Constants.ZERO);
			status.setChave(Constants.CHAVE_ERRO);
		}

		return status;
	}

}
