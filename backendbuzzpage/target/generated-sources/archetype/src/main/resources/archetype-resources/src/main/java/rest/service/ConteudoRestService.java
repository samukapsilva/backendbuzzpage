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

import ${package}.business.service.AvaliacaoService;
import ${package}.business.service.ConteudoColaboradorService;
import ${package}.entity.Texto;
import ${package}.rest.serviceutil.Constants;
import ${package}.vo.DadosGrid;
import ${package}.vo.DestaquesPaginaVo;
import ${package}.vo.ResultadoPesquisaPaginasVO;
import ${package}.vo.StatusVo;
import ${package}.vo.TextoVo;

/**
 * 
 * Service class that handles REST Conteudo requests
 * 
 * @author Alexandre Parreira
 * 
 */
@Component
@Path("/conteudocolaborador")
public class ConteudoRestService {

	private static final String FOI_CRIADO_UM_NOVO_CONTEUDO = "Foi criado um novo conte�do";

	@Autowired
	private ConteudoColaboradorService conteudoService;

	@Autowired
	private AvaliacaoService avaliacaoService;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo criarConteudo(TextoVo textoVo) {

		StatusVo status = new StatusVo();

		Texto texto = conteudoService.salvarConteudo(textoVo);
		boolean result = (texto != null && texto.getIdTexto() != null);

		if (result) {
			status.setChave(Constants.UM);
			status.setIdCadastrado(texto.getIdTexto());
			status.setValor(Constants.CHAVE_OK);
		} else {
			status.setChave(Constants.ZERO);
			status.setValor(Constants.CHAVE_ERRO);
		}

		return status;

	}

	/************************************ READ ************************************/
	/**
	 * Retorna todos os Conte�dos (textos)de um colaborador
	 * 
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	@GET
	@Path("colaborador/{idColaborador}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Transactional
	public List<TextoVo> getTextosColaborador(
			@PathParam("idColaborador") Long idColaborador)
			throws JsonGenerationException, JsonMappingException, IOException {

		List<TextoVo> lista = conteudoService
				.listarTextosColaborador(idColaborador);
		return lista;
	}

	/************************************ READ ************************************/
	/**
	 * Retorna todos os Conte�dos (textos)de um colaborador
	 * 
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 */
	@GET
	@Path("destaques/{slug}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Transactional
	public DestaquesPaginaVo getDestaquePagina(@PathParam("slug") String slug)
			throws JsonGenerationException, JsonMappingException, IOException {

		DestaquesPaginaVo destaque = conteudoService.findDestaquePagina(slug);

		return destaque;
	}

	@GET
	@Path("buscaPost/{slug}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Transactional
	public TextoVo buscaPost(@PathParam("slug") String slug)
			throws JsonGenerationException, JsonMappingException, IOException {

		TextoVo textoVO = conteudoService.findPostBySlug(slug);

		return textoVO;
	}

	@GET
	@Path("gridConteudos/{idColaborador}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Transactional
	public DadosGrid gridConteudosColaborador(
			@PathParam("idColaborador") Long idColaborador)
			throws JsonGenerationException, JsonMappingException, IOException {

		DadosGrid retorno = conteudoService.montarGridConteudos(idColaborador);

		return retorno;
	}

	@GET
	@Path("gridRevisor/{idColaborador}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Transactional
	public DadosGrid gridRevisor(@PathParam("idColaborador") Long idColaborador)
			throws JsonGenerationException, JsonMappingException, IOException {

		DadosGrid retorno = conteudoService.montarGridRevisor(idColaborador);

		return retorno;
	}

	//
	@GET
	@Path("gridAdmin")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Transactional
	public DadosGrid gridAdmin() throws JsonGenerationException,
			JsonMappingException, IOException {

		DadosGrid retorno = conteudoService.montarGridAdmin();

		return retorno;
	}

	@GET
	@Path("setSlug")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo setSlug() throws JsonGenerationException,
			JsonMappingException, IOException {

		Boolean retorno = conteudoService.setSlug();

		StatusVo status = new StatusVo();
		status.setChave("OK");
		return status;
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response findById(@PathParam("id") Long id)
			throws JsonGenerationException, JsonMappingException, IOException {

		TextoVo textoVo = conteudoService.getConteudoVoById(id);

		if (textoVo != null) {
			return Response.status(200).entity(textoVo)
					.header("Access-Control-Allow-Headers", "X-extra-header")
					.allow("OPTIONS").build();
		} else {
			return Response
					.status(404)
					.entity("The podcast with the id " + id + " does not exist")
					.build();
		}
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public Response updateConteudoPorId(TextoVo textoVo) {

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
	public List<TextoVo> getTextos() throws JsonGenerationException,
			JsonMappingException, IOException {
		List<TextoVo> textos = conteudoService.listarTextos();
		return textos;
	}

	private boolean objetoPodeSerCriado(TextoVo textoVo) {
		// TODO Auto-generated method stub
		return true;
	}

	/************************************ DELETE ************************************/
	@DELETE
	@Path("{id}/{idPessoa}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo deleteTexto(@PathParam("id") Long id,
			@PathParam("idPessoa") Long idPessoa) {

		StatusVo status = new StatusVo();

		if (conteudoService.deletarConteudoColaboradorPorId(id, idPessoa)) {

			status.setValor(Constants.UM);
			status.setChave(Constants.CHAVE_OK);

		} else {

			status.setValor(Constants.ZERO);
			status.setChave(Constants.CHAVE_ERRO);
		}

		return status;
	}

	@GET
	@Path("ultimosPosts/{maxResult}/{offSet}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public List<TextoVo> buscaUltimosPosts(
			@PathParam("maxResult") Integer maxResult,
			@PathParam("offSet") Integer offSet)
			throws JsonGenerationException, JsonMappingException, IOException {
		return conteudoService.buscaUltimosPosts(maxResult, offSet);
	}

	/**
	 * Metodo responsavel por retornar os textos de acordo com a apalavra chave.
	 * 
	 * @param palavraChave
	 * @return List<TextoVo>
	 */
	@GET
	@Path("findTextoPorPalavraChave/{palavraChave}/{qtdeRegistros}/{offSet}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Transactional
	public List<TextoVo> findTextoPorPalavraChave(
			@PathParam("palavraChave") String palavraChave,
			@PathParam("qtdeRegistros") Integer qtdeRegistros,
			@PathParam("offSet") Integer offSet) {
		return conteudoService.findTextoPorPalavraChave(palavraChave,
				qtdeRegistros, offSet);
	}

	/**
	 * Metodo responsavel por retornar os textos, paginas e autores de acordo com a apalavra chave.
	 * 
	 * @param palavraChave
	 * @return List<TextoVo>
	 */
	@GET
	@Path("paginasPostsAutoresPorPalavraChave/{idPagina}/{qtdeRegistros}/{offSet}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Transactional
	public ResultadoPesquisaPaginasVO paginasPostsAutoresPorPalavraChave(
			@PathParam("idPagina") String idPagina,
			@PathParam("qtdeRegistros") Integer qtdeRegistros,
			@PathParam("offSet") Integer offSet
			) {
		return  null; //conteudoService.paginasPostsAutoresPorPalavraChave(idPagina,qtdeRegistros, offSet);
	}
	
	/**
	 * Metodo responsavel por retornar os textos de acordo com a apalavra chave.
	 * 
	 * @param palavraChave
	 * @return List<TextoVo>
	 */
	@GET
	@Path("findTextoPorIdPagina/{idPagina}/{qtdeRegistros}/{offSet}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Transactional
	public ResultadoPesquisaPaginasVO findTextoPorIdPagina(
			@PathParam("idPagina") Long idPagina,
			@PathParam("qtdeRegistros") Integer qtdeRegistros,
			@PathParam("offSet") Integer offSet) {
		return conteudoService.findTextoPorIdPagina(idPagina, qtdeRegistros, offSet);
	}

}
