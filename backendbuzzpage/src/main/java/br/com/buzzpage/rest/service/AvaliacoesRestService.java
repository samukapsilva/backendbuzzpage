package br.com.buzzpage.rest.service;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.buzzpage.business.service.AvaliacaoService;
import br.com.buzzpage.entity.Avaliacao;
import br.com.buzzpage.rest.serviceutil.Constants;
import br.com.buzzpage.vo.AvaliacaoVo;
import br.com.buzzpage.vo.StatusVo;

@Component
@Path("/avaliacoes")
public class AvaliacoesRestService {

	@Autowired
	private AvaliacaoService avaliacaoService;

	/**
	 * Adds a new resource (pessoa) from the given json format (at least title
	 * and feed elements are required at the DB level)
	 * 
	 * @param pessoaVo
	 * @return
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo cadastrarAvaliacao(AvaliacaoVo avaliacaoVo) {

		StatusVo status = new StatusVo();

		Avaliacao avaliacao = avaliacaoService.cadastrarAvaliacao(avaliacaoVo);

		boolean result = (avaliacao != null && avaliacao.getId() != null);

		if (result) {
			status.setChave(Constants.UM);
			status.setIdCadastrado(new Long(avaliacao.getId()));
			status.setValor(Constants.CHAVE_OK);
		} else {
			status.setChave(Constants.ZERO);
			status.setValor(Constants.CHAVE_ERRO);
		}

		return status;

	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Transactional
	public AvaliacaoVo buscaPorId(@PathParam("id") Long id)
			throws JsonGenerationException, JsonMappingException, IOException {

		AvaliacaoVo avaliacaoVo = avaliacaoService.getAvaliacaoVoById(id);
		return avaliacaoVo;

		// return Response.status(200).entity(pessoaVo).build();
	}

	@GET
	@Path("buscaUltima/{idConteudo}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON })
	@Transactional
	public AvaliacaoVo buscaUltimaPorConteudo(@PathParam("idConteudo") Long idConteudo)
			throws JsonGenerationException, JsonMappingException, IOException {

		AvaliacaoVo avaliacaoVo = avaliacaoService.getUltimaPorConteudo(idConteudo);

		return avaliacaoVo;
	}

}
