package br.com.buzzpage.rest.service;

import java.io.IOException;

import javax.persistence.PersistenceException;
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

import br.com.buzzpage.business.service.PedidoService;
import br.com.buzzpage.entity.Pedido;
import br.com.buzzpage.rest.serviceutil.Constants;
import br.com.buzzpage.vo.BoletoVO;
import br.com.buzzpage.vo.PedidoVo;
import br.com.buzzpage.vo.StatusVo;

@Component
@Path("/pedidos")
public class PedidosRestService {

	@Autowired
	private PedidoService pedidoService;

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
	@Transactional(noRollbackFor = PersistenceException.class)
	public StatusVo cadastrarPedidos(PedidoVo pedidoVo) {

		StatusVo status = new StatusVo();

		Pedido pedido = pedidoService.cadastrarPedido(pedidoVo);

		if (pedido != null && pedido.getId() > 0) {
			status.setIdCadastrado(pedido.getId());
			status.setChave(Constants.CHAVE_OK);
			status.setValor(Constants.CHAVE_OK);
		} else {
			status.setChave(Constants.CHAVE_ERRO);
			status.setIdCadastrado(0L);
		}

		return status;

	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public BoletoVO findById(@PathParam("id") Long id)
			throws JsonGenerationException, JsonMappingException, IOException {

		BoletoVO boleto = pedidoService.findById(id);

		return boleto;

	}

}
