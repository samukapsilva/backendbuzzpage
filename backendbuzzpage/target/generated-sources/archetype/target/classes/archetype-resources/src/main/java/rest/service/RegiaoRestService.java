#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest.service;

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

import ${package}.business.service.RegiaoService;
import ${package}.vo.RegiaoVO;

@Component
@Path("/regiao")
public class RegiaoRestService {

	@Autowired
	private RegiaoService regiaoService;

	/**
	 * Servi�o responsavel por retornar todas as regioes.
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 * @return List<Regiao>
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("regioes")
	public List<RegiaoVO> getRegioes() throws JsonGenerationException, JsonMappingException, IOException {
		List<RegiaoVO> regioes = regiaoService.buscarRegioes();
		return regioes;
	}

	/**
	 * Servi�o responsavel por retornar todas as regioes.
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonGenerationException
	 * @return List<Regiao>
	 */
	@GET
	@Path("getRegioesPorData/{data}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<RegiaoVO> getRegioesPorData(@PathParam("data") String data)
			throws JsonGenerationException, JsonMappingException, IOException {
		List<RegiaoVO> regioes = regiaoService.buscarRegioes();
		return regioes;
	}
}
