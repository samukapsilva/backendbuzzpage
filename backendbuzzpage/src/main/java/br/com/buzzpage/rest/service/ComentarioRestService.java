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

import br.com.buzzpage.business.service.ComentarioService;
import br.com.buzzpage.rest.serviceutil.Constants;
import br.com.buzzpage.vo.ComentarioVO;
import br.com.buzzpage.vo.StatusVo;

@Component
@Path("/comentarioColaborador")
public class ComentarioRestService {

	@Autowired
	private ComentarioService comentarioService;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo criarComentario(ComentarioVO comentarioVO) {

		StatusVo status = new StatusVo();

		ComentarioVO comentario = comentarioService.salvarComentario(comentarioVO);
		boolean result = (comentario != null && comentario.getIdComentario() != null);

		if (result) {
			status.setChave(Constants.UM);
			status.setIdCadastrado(comentario.getIdComentario());
			status.setValor(Constants.CHAVE_OK);
		} else {
			status.setChave(Constants.ZERO);
			status.setValor(Constants.CHAVE_ERRO);
		}

		return status;
	}

	@GET
	@Path("buscaComentario/{idComentario}/{idPessoa}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Transactional
	public ComentarioVO buscaComentario(@PathParam("idComentario") Long idComentario,
			@PathParam("idPessoa") Long idPessoa) throws JsonGenerationException, JsonMappingException, IOException {

		ComentarioVO comentario = comentarioService.buscarComentarioColaborador(idComentario, idPessoa);

		return comentario;
	}

	@GET
	@Path("buscaComentarios/{idConteudo}/{idPessoa}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Transactional
	public List<ComentarioVO> buscaComentarios(@PathParam("idConteudo") Long idConteudo,
			@PathParam("idPessoa") Long idPessoa) throws JsonGenerationException, JsonMappingException, IOException {

		List<ComentarioVO> comentarios = comentarioService.buscarComentariosColaborador(idConteudo, idPessoa);

		return comentarios;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public Response AtualizarComentario(ComentarioVO comentarioVO) {

		String message;
		int status;

		if (comentarioVO.getIdComentario() != null) {
			comentarioService.atualizarComentario(comentarioVO);
			status = 200; // OK
			message = "Comentario alterado com sucesso.";
		} else if (objetoPodeSerCriado(comentarioVO)) {
			comentarioService.salvarComentario(comentarioVO);
			status = 201; // Created
			message = "Comentario adicionado";
		} else {
			status = 406; // Not acceptable
			message = "Permiss�o negada";
		}

		return Response.status(status).entity(message).build();
	}

	private boolean objetoPodeSerCriado(ComentarioVO comentarioVO) {
		return true;
	}

	/************************************ DELETE ************************************/
	@DELETE
	@Path("{id}/{idPessoa}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo apagarComentario(@PathParam("id") Long id, @PathParam("idPessoa") Long idPessoa) {

		StatusVo status = new StatusVo();

		if (comentarioService.deletarComentario(id, idPessoa)) {
			status.setValor(Constants.UM);
			status.setChave(Constants.CHAVE_OK);
		} else {
			status.setValor(Constants.ZERO);
			status.setChave(Constants.CHAVE_ERRO);
		}

		return status;
	}

}
