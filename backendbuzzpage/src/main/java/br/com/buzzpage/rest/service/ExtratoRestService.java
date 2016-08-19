package br.com.buzzpage.rest.service;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.buzzpage.business.service.ExtratoFinanceiroService;
import br.com.buzzpage.business.service.PaginaService;
import br.com.buzzpage.vo.ExtratoFinanceiroVO;
import br.com.buzzpage.vo.PaginaVo;

/**
 * 
 * Service class that handles REST requests
 * 
 * @author amacoder
 * 
 */
@Component
@Path("/extrato")
public class ExtratoRestService {

	@Autowired
	private PaginaService paginaService;

	@Autowired
	private ExtratoFinanceiroService extratoFinanceiroService;

	@GET
	@Path("extratoPessoal/{idPessoa}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public List<ExtratoFinanceiroVO> extratoPessoal(@PathParam("idPessoa") Long idPessoa)
			throws JsonGenerationException, JsonMappingException, IOException {
		return extratoFinanceiroService.buscarExtratoFinanceiro(idPessoa);
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

}
