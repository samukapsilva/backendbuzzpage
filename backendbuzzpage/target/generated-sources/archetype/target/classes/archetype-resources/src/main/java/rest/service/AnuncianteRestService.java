#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.PersistenceException;
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

import ${package}.business.service.AnuncianteService;
import ${package}.rest.serviceutil.Constants;
import ${package}.vo.AnuncianteVO;
import ${package}.vo.LoginVo;
import ${package}.vo.StatusVo;

@Component
@Path("/cadastroAnunciante")
public class AnuncianteRestService {

	@Autowired
	private AnuncianteService anuncianteService;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	/**
	 * Metodo responsavel por persistir um anunciante.
	 * 
	 * @param anuncianteVO
	 * @return String
	 */
	public StatusVo criarAnunciante(AnuncianteVO anuncianteVO) {

		StatusVo status = new StatusVo();
		AnuncianteVO anuncianteVoRetorno = anuncianteService.salvarAnunciante(anuncianteVO);
		boolean result = (anuncianteVoRetorno != null && anuncianteVoRetorno.getIdAnunciante() != null);

		if (result) {
			status.setChave(Constants.CHAVE_OK);
			status.setIdCadastrado(anuncianteVoRetorno.getIdAnunciante());
		} else {
			status.setChave(Constants.CHAVE_ERRO);
			status.setIdCadastrado(0L);
		}
		
		return status;

	}

	@GET
	@Path("buscaAnunciantes/{idPessoa}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Transactional
	public List<AnuncianteVO> buscaAnunciantes(@PathParam("idPessoa") Long idPessoa)
			throws JsonGenerationException, JsonMappingException, IOException {
		List<AnuncianteVO> anunciantes = anuncianteService
				.buscarAnunciantes(idPessoa);
		return anunciantes;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public Response AtualizarAnunciante(AnuncianteVO anuncianteVO) {

		String message;
		int status;

		if (anuncianteVO.getIdAnunciante() != null) {
			anuncianteService.atualizarAnunciante(anuncianteVO.getIdAnunciante());
			status = 200; // OK
			message = "Anunciante alterado com sucesso.";
		} else if (objetoPodeSerCriado(anuncianteVO)) {
			anuncianteService.salvarAnunciante(anuncianteVO);
			status = 201; // Created
			message = "Anunciante adicionado";
		} else {
			status = 406; // Not acceptable
			message = "Permiss�o negada";
		}

		return Response.status(status).entity(message).build();
	}

	private boolean objetoPodeSerCriado(AnuncianteVO anuncianteVO) {
		return true;
	}

	/************************************ DELETE ************************************/
	@DELETE
	@Path("{idAnunciante}/{idAnuncio}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo apagarAnunciante(@PathParam("idAnuncio") Long idAnunciante, @PathParam("idPessoa") Long idPessoa) {

		StatusVo status = new StatusVo();

		AnuncianteVO anunciante = new AnuncianteVO();
		anunciante.setIdAnunciante(idAnunciante);
		anunciante.setIdAnunciante(idPessoa);

		anuncianteService.deletarAnunciante(anunciante);

		return status;
	}

	@POST
	@Path("loginAnunciante")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional(noRollbackFor = PersistenceException.class)
	public Response login(LoginVo loginVo) {
		AnuncianteVO anuncianteVO = anuncianteService.efetuarLogin(loginVo);
		if (anuncianteVO == null) {
			anuncianteVO = new AnuncianteVO();
			anuncianteVO.setIdAnunciante(0L);
			anuncianteVO.setNome(Constants.CHAVE_REGISTRO_INEXISTENTE);
		}
		return Response.status(200).entity(anuncianteVO).build();
	}
}
