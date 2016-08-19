#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest.service;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

import ${package}.business.service.PedidoAnuncioService;
import ${package}.vo.BoletoVO;
import ${package}.vo.PedidoAnuncioVO;

@Component
@Path("/cadastroAnunciante")
public class PedidoAnuncioRestService {

	@Autowired
	private PedidoAnuncioService pedidoAnuncioService;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	/**
	 * Metodo responsavel por persistir um anunciante.
	 * 
	 * @param pedidoAnuncioVO
	 * @return String
	 */
	public Response saveUpdatePedidoAnuncio(PedidoAnuncioVO pedidoAnuncioVO) {
		String message;
		int status;

		if (pedidoAnuncioVO.getIdPedidoAnuncio() != null) {
			pedidoAnuncioService.cadastrarPedidoAnuncio(pedidoAnuncioVO);
			status = 200; // OK
			message = "Podcast has been updated";
		} else if (objetoPodeSerCriado(pedidoAnuncioVO)) {
			pedidoAnuncioService.cadastrarPedidoAnuncio(pedidoAnuncioVO);
			status = 201; // Created
			message = "Conteudo adicionado";
		} else {
			status = 406; // Not acceptable
			message = "Permiss�o negada";
		}

		return Response.status(status).entity(message).build();
	}

	@GET
	@Path("pedidosAnunciante/{idAnunciante}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Transactional
	public BoletoVO buscaPedidosAnunciante(@PathParam("idAnunciante") Long idAnunciante)
			throws JsonGenerationException, JsonMappingException, IOException {
		BoletoVO boleto = pedidoAnuncioService.findById(idAnunciante);
		return boleto;
	}

	private boolean objetoPodeSerCriado(PedidoAnuncioVO pedidoAnuncioVO) {
		return true;
	}
	
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BoletoVO findById(@PathParam("id") Long id)
			throws JsonGenerationException, JsonMappingException, IOException {

		BoletoVO boleto = pedidoAnuncioService.findById(id);

		return boleto;

	}


}