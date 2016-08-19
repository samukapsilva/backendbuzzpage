package br.com.buzzpage.rest.service;

import java.io.IOException;

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

import br.com.buzzpage.business.service.ClickAnuncioService;
import br.com.buzzpage.vo.ClickAnuncioVO;
import br.com.buzzpage.vo.StatusVo;

@Component
@Path("/clickAnuncio")
public class ClickAnuncioRestService {

	@Autowired
	private ClickAnuncioService clickAnuncioService;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	/**
	 * Metodo responsavel por persistir um anuncio.
	 * 
	 * @param anuncioVO
	 * @return
	 */
	public String criarClickAnuncio(ClickAnuncioVO clickAnuncioVO) {
		ClickAnuncioVO clickAnuncioVoRetorno = clickAnuncioService.salvarClickAnuncio(clickAnuncioVO);
		boolean result = (clickAnuncioVoRetorno != null && clickAnuncioVoRetorno.getIdClickAnuncio() != null);
		return result ? "OK" : "ERRO";
	}

	@GET
	@Path("clicksAnuncio/{idClickAnunciante}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Transactional
	public Long buscarClicksAnuncio(@PathParam("idClickAnunciante") Long idClickAnuncio)
			throws JsonGenerationException, JsonMappingException, IOException {
		Long clicksAnuncio = clickAnuncioService.buscarClicksAnuncio(idClickAnuncio);
		return clicksAnuncio;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public Response AtualizarClicksAnuncio(ClickAnuncioVO clickAnuncioVO) {

		String message;
		int status;

		if (clickAnuncioVO.getIdClickAnuncio() != null) {
			clickAnuncioService.update(clickAnuncioVO);
			status = 200; // OK
			message = "Anuncio alterado com sucesso.";
		} else if (objetoPodeSerCriado(clickAnuncioVO)) {
			clickAnuncioService.salvarClickAnuncio(clickAnuncioVO);
			status = 201; // Created
			message = "Anuncio adicionado";
		} else {
			status = 406; // Not acceptable
			message = "Permissão negada";
		}

		return Response.status(status).entity(message).build();
	}

	private boolean objetoPodeSerCriado(ClickAnuncioVO clickAnuncioVO) {
		return true;
	}

	/************************************ DELETE ************************************/
	@DELETE
	@Path("{idClickAnuncio}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo apagarClickAnuncio(@PathParam("idClickAnuncio") Long idClickAnuncio) {

		StatusVo status = new StatusVo();

		ClickAnuncioVO clickAnuncio = new ClickAnuncioVO();
		clickAnuncio.setIdClickAnuncio(idClickAnuncio);
		clickAnuncioService.delete(clickAnuncio);
		return status;
	}

}
