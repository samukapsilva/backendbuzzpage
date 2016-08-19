#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest.service;

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

import ${package}.business.service.AnuncioService;
import ${package}.rest.serviceutil.Constants;
import ${package}.vo.AnuncianteVO;
import ${package}.vo.AnuncioVO;
import ${package}.vo.DadosGrid;
import ${package}.vo.StatusVo;

@Component
@Path("/anuncios")
public class AnuncioRestService {

	@Autowired
	private AnuncioService anuncioService;

	/**
	 * Metodo responsavel por persistir um anuncio.
	 * 
	 * @param anuncioVO
	 * @return
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo criarAnuncio(AnuncioVO anuncioVO) {

		StatusVo status =  new StatusVo();
		
		 AnuncioVO anuncioVoRetorno = anuncioService.salvarAnuncio(anuncioVO);
		
		if(anuncioVoRetorno.getIdAnuncio()!=null){
			status.setChave("OK");
			status.setIdCadastrado(anuncioVoRetorno.getIdAnuncio());
		} else {
			status.setChave("ERRO");
			status.setIdCadastrado(0L);
		} 
		return status;
	}

	@GET
	@Path("buscaAnuncioAnunciante/{idAnunciante}/{idAnuncio}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Transactional
	public AnuncioVO buscaAnuncioAnunciante(
			@PathParam("idAnunciante") Long idAnunciante,
			@PathParam("idAnuncio") Long idAnuncio)
			throws JsonGenerationException, JsonMappingException, IOException {
		AnuncioVO anuncios = anuncioService.buscarAnuncioAnunciante(idAnunciante, idAnuncio);
		return anuncios;
	}

	@GET
	@Path("buscaAnunciosAnunciante/{idAnunciante}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Transactional
	public List<AnuncioVO> buscaAnunciosAnunciante(@PathParam("idAnunciante") Long idAnunciante)
			throws JsonGenerationException, JsonMappingException, IOException {
		List<AnuncioVO> anuncios = anuncioService.buscarAnunciosAnunciante(idAnunciante);
		return anuncios;
	}
	
	
	@GET
	@Path("gridAnuncios/{idAnunciante}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Transactional
	public DadosGrid gridAnunciosAnunciante(
			@PathParam("idAnunciante") Long idAnunciante)
			throws JsonGenerationException, JsonMappingException, IOException {

		DadosGrid retorno = anuncioService.montarGridAnuncios(idAnunciante);

		return retorno;
	}
	
	

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public Response AtualizarAnuncio(AnuncioVO anuncioVO) {

		String message;
		int status;

		if (anuncioVO.getIdAnuncio() != null) {
			anuncioService.update(anuncioVO);
			status = 200; // OK
			message = "Anuncio alterado com sucesso.";
		} else if (objetoPodeSerCriado(anuncioVO)) {
			anuncioService.salvarAnuncio(anuncioVO);
			status = 201; // Created
			message = "Anuncio adicionado";
		} else {
			status = 406; // Not acceptable
			message = "Permiss�o negada";
		}

		return Response.status(status).entity(message).build();
	}

	private boolean objetoPodeSerCriado(AnuncioVO anuncioVO) {
		return true;
	}

	/************************************ DELETE ************************************/
	@DELETE
	@Path("{idAnuncio}/{idPessoa}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo apagarAnuncio(@PathParam("idAnuncio") Long idAnuncio,
			@PathParam("idAnunciante") Long idAnunciante) {

		StatusVo status = new StatusVo();		
		
		if(anuncioService.deleteAnuncioDeAnunciante(idAnuncio,idAnunciante)){
			status.setValor(Constants.UM);
			status.setChave(Constants.CHAVE_OK);

		} else {

			status.setValor(Constants.ZERO);
			status.setChave(Constants.CHAVE_ERRO);
		}

		return status;
	}
}