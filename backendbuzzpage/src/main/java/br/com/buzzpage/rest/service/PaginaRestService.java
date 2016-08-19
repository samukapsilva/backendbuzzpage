package br.com.buzzpage.rest.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
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
import br.com.buzzpage.business.service.PaginaService;
import br.com.buzzpage.entity.Pagina;
import br.com.buzzpage.entity.Pessoa;
import br.com.buzzpage.entity.Texto;
import br.com.buzzpage.exception.BuzzPageException;
import br.com.buzzpage.rest.serviceutil.Constants;
import br.com.buzzpage.rest.serviceutil.TemplateConstants;
import br.com.buzzpage.util.BuzzPageMailSender;
import br.com.buzzpage.util.StringUtil;
import br.com.buzzpage.vo.AlterarPublicacaoVo;
import br.com.buzzpage.vo.CategoriaVo;
import br.com.buzzpage.vo.DadosGrid;
import br.com.buzzpage.vo.GridPaginaVo;
import br.com.buzzpage.vo.PaginaVo;
import br.com.buzzpage.vo.StatusVo;

/**
 * 
 * Service class that handles REST requests
 * 
 * @author amacoder
 * 
 * 
 * 
 */
@Component
@Path("/paginas")
public class PaginaRestService {

	@Autowired
	private PaginaService paginaService;

	@Autowired
	private ConteudoColaboradorService conteudoService;

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
	public List<PaginaVo> getPaginas() throws JsonGenerationException,
			JsonMappingException, IOException {

		List<PaginaVo> paginas = paginaService.findPaginasOficiais();

		return paginas;
	}

	@GET
	@Path("paginasPessoais/{idPessoa}")
	@Produces({ MediaType.APPLICATION_JSON })
	public DadosGrid getPaginasPessoais(@PathParam("idPessoa") Long idPessoa)
			throws JsonGenerationException, JsonMappingException, IOException {

		List<PaginaVo> paginas = null;

		if (idPessoa.longValue() == 0) {

			paginas = paginaService.findPaginasPublicadasVo();

		} else {

			paginas = paginaService.findPaginasPessoaisPublicadas(idPessoa);
		}

		DadosGrid retorno = new DadosGrid();

		// GridTextosVo[] data = new GridTextosVo[lista.size()];
		GridPaginaVo[] data = new GridPaginaVo[paginas.size()];

		int i = 0;
		for (PaginaVo vo : paginas) {
			GridPaginaVo grid = new GridPaginaVo();
			grid.setCategoria(vo.getCategoria());
			grid.setId(vo.getIdPagina());
			grid.setTipo(vo.getTipo());
			grid.setTitulo(vo.getTitulo());
			grid.setSlug(vo.getSlug());

			if (vo.getFlagPublicado() != null && vo.getFlagPublicado()) {
				grid.setFlagPublicado(1);
			} else {
				grid.setFlagPublicado(0);
			}

			data[i] = grid;

			i++;
		}
		retorno.setDraw(1);
		retorno.setRecordsFiltered(paginas.size());
		retorno.setRecordsTotal(paginas.size());
		retorno.setData(data);

		return retorno;
	}

	@GET
	@Path("gridPaginasPessoais/{idPessoa}")
	@Produces({ MediaType.APPLICATION_JSON })
	public DadosGrid gridPaginasPessoais(@PathParam("idPessoa") Long idPessoa)
			throws JsonGenerationException, JsonMappingException, IOException {

		List<PaginaVo> paginas = null;

		if (idPessoa.longValue() == 0) {

			paginas = paginaService.gridPaginasAdmin();

		} else {

			paginas = paginaService.gridPaginasPessoais(idPessoa);
		}

		DadosGrid retorno = new DadosGrid();

		// GridTextosVo[] data = new GridTextosVo[lista.size()];
		GridPaginaVo[] data = new GridPaginaVo[paginas.size()];

		int i = 0;
		for (PaginaVo vo : paginas) {

			GridPaginaVo grid = new GridPaginaVo();
			grid.setCategoria(vo.getCategoria());
			grid.setId(vo.getIdPagina());
			grid.setTipo(vo.getTipo());
			grid.setTitulo(vo.getTitulo());

			if (vo.getFlagPublicado()) {
				grid.setFlagPublicado(1);
			} else {
				grid.setFlagPublicado(0);
			}

			data[i] = grid;

			i++;
		}
		retorno.setDraw(1);
		retorno.setRecordsFiltered(paginas.size());
		retorno.setRecordsTotal(paginas.size());
		retorno.setData(data);

		return retorno;
	}

	@GET
	@Path("verificaExistenciaPagina/{slug}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Transactional
	public StatusVo verificaExistenciaPagina(@PathParam("slug") String slug)
			throws JsonGenerationException, JsonMappingException, IOException {

		StatusVo status = new StatusVo();

		Pagina pagina = paginaService.findBySlug(slug);

		if (pagina != null) {

			status.setStatus(true);
			status.setChave(Constants.CHAVE_OK);

		} else {
			status.setStatus(false);
			status.setChave(Constants.CHAVE_ERRO);
		}

		return status;

	}

	@GET
	@Path("getPaginaPorSlug/{slug}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Transactional
	public PaginaVo getPaginaPorSlug(@PathParam("slug") String slug)
			throws JsonGenerationException, JsonMappingException, IOException {

		PaginaVo pagina = paginaService.findVoBySlug(slug);

		return pagina;

	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response findById(@PathParam("id") Long id)
			throws JsonGenerationException, JsonMappingException, IOException {

		PaginaVo paginaVo = paginaService.findById(id);

		if (paginaVo != null) {

			return Response.status(200).entity(paginaVo)
					.header("Access-Control-Allow-Headers", "X-extra-header")
					.allow("OPTIONS").build();

		} else {
			return Response.status(404).entity("nao existe").build();
		}

	}

	@GET
	@Path("listarTodas")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<PaginaVo> listarTodas() throws JsonGenerationException,
			JsonMappingException, IOException {

		List<PaginaVo> lista = paginaService.listaTodas();

		return lista;

	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public Response updatePagina(PaginaVo paginaVo) {

		String message;
		int status;

		if (paginaVo.getIdPagina() != null) {

			// update
			status = 200; // OK
			message = "Podcast has been updated";
		} else if (objetoPodeSerCriado(paginaVo)) {
			status = 201; // Created
			message = "Conteudo adicionado";
		} else {
			status = 406; // Not acceptable
			message = "Permiss�o negada";
		}

		return Response.status(status).entity(message).build();
	}

	//

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@Path("alterarStatusPublicacao")
	public StatusVo alterarStatusPublicacao(AlterarPublicacaoVo publicacao) {

		StatusVo status = new StatusVo();
		Pessoa donoPublicacao = null;

		if (publicacao.getIdPagina() != null && publicacao.getIdPagina() > 0) {

			donoPublicacao = paginaService.alterarStatusPublicacao(publicacao);
			prepararEmail(publicacao, donoPublicacao);

		} else if (publicacao.getIdTexto() != null
				&& publicacao.getIdTexto() > 0) {

			donoPublicacao = conteudoService
					.alterarStatusPublicacao(publicacao);

			prepararEmail(publicacao, donoPublicacao);

			status.setChave(Constants.CHAVE_OK);
			status.setValor(Constants.CHAVE_OK);

		} else {

			status.setChave(Constants.CHAVE_ERRO);
			status.setValor(Constants.CHAVE_ERRO);

		}

		return status;
	}

	private void prepararEmail(AlterarPublicacaoVo publicacao, Pessoa pessoa) {

		PaginaVo pagina = null;
		Texto texto = null;
		String emailTitle = null;

		StringBuilder enunciado = new StringBuilder();
		String obs = null;

		if (publicacao.getIdPagina() != null && publicacao.getIdPagina() > 0) {
			pagina = paginaService.findById(publicacao.getIdPagina());
			enunciado.append("BuzzPage: ").append(pagina.getTitulo());

		} else if (publicacao.getIdTexto() != null
				&& publicacao.getIdTexto() > 0) {
			texto = conteudoService.findById(publicacao.getIdTexto());

			enunciado.append("Conteúdo: ").append(texto.getTitulo());
		}

		if (publicacao.getFlag()) {
			emailTitle = "Seu conteúdo foi liberado";
			obs = "Obrigado por produzir o seu conteúdo e se adequar aos termos de uso";
		} else {
			obs = "Você pode alterar o teor e solicitar o desbloqueio na sua área do BuzzPager";
			emailTitle = "Seu conteúdo foi bloqueado";
		}

		enviarAviso(pessoa, emailTitle, publicacao.getJustificativa(),
				enunciado.toString(), obs);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo criarPagina(PaginaVo paginaVo) {

		StatusVo status = new StatusVo();

		try {
			Pagina pagina = paginaService.criarPagina(paginaVo);
			status.setChave(Constants.UM);
			status.setIdCadastrado(pagina.getIdPagina());
			status.setValor(Constants.CHAVE_OK);
		} catch (BuzzPageException e) {
			status.setChave(Constants.ZERO);
			status.setBuzzPageException(e);
		}

		return status;
	}

	private boolean objetoPodeSerCriado(PaginaVo paginaVo) {
		// TODO Auto-generated method stub
		return true;
	}

	@GET
	@Path("getCategorias/{idTipo}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<CategoriaVo> getTiposPaginasPorCategoria(
			@PathParam("idTipo") Long idTipo) throws JsonGenerationException,
			JsonMappingException, IOException {

		List<CategoriaVo> categorias = new ArrayList<CategoriaVo>();

		categorias = paginaService.findCategoriasByTipo(idTipo);

		return categorias;
	}

	private void enviarAviso(Pessoa pessoa, String emailTitle,
			String justificativa, String enunciado, String obs) {

		Map<String, String> parametros = new HashMap<String, String>();

		parametros.put("justificativa", justificativa);
		parametros.put("nome", pessoa.getNome());
		parametros.put("enunciado", enunciado);
		parametros.put("obs", obs);
		parametros.put("titulo", emailTitle);

		BuzzPageMailSender.sendMailGeneric(pessoa, parametros,
				TemplateConstants.TEMPLATE_BLOQUEIO_DESBLOQUEIO_CONTEUDO,
				emailTitle);

		parametros.clear();
		parametros = new HashMap<String, String>();

	}

	@GET
	@Path("paginasDisponiveis/{idRegiao}/{dataInicial}/{dataFinal}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<PaginaVo> getPaginasDisponiveis(
			@PathParam("idRegiao") Long idRegiao,
			@PathParam("dataInicial") String dataInicial,
			@PathParam("dataFinal") String dataFinal)
			throws JsonGenerationException, JsonMappingException, IOException {

		Date dataInicioParam = null;
		Date dataFimParam = null;

		try {

			dataInicioParam = StringUtil.formataData(dataInicial,
					Constants.FORMATO_DATA_SEM_SEPARADOR_USA);
			dataFimParam = StringUtil.formataData(dataFinal,
					Constants.FORMATO_DATA_SEM_SEPARADOR_USA);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return paginaService.buscarPaginasPorDataRegiao(idRegiao,
				dataInicioParam, dataFimParam);
	}

}
