#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ${package}.business.service.CurtidaService;
import ${package}.rest.serviceutil.Constants;
import ${package}.vo.CurtidaVO;
import ${package}.vo.StatusVo;

@Component
@Path("/curtidaColaborador")
public class CurtidaRestService {

	@Autowired
	private CurtidaService curtidaService;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public StatusVo criarCurtida(CurtidaVO curtidaVO) {

		StatusVo status = new StatusVo();

		CurtidaVO curtida = curtidaService.salvarCurtida(curtidaVO);
		boolean result = (curtida != null && curtida.getIdCurtida() != null);

		if (result) {
			status.setChave(Constants.UM);
			status.setIdCadastrado(curtidaVO.getIdCurtida());
			status.setValor(Constants.CHAVE_OK);
		} else {
			status.setChave(Constants.ZERO);
			status.setValor(Constants.CHAVE_ERRO);
		}

		return status;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	public Response AtualizarCurtida(CurtidaVO curtidaVO) {

		String message;
		int status;

		if (curtidaVO != null) {
			curtidaService.atualizarStatusCurtida(curtidaVO);
			status = 200; // OK
			message = "Status Curtida alterado com sucesso.";
		} else if (objetoPodeSerCriado(curtidaVO)) {
			curtidaService.salvarCurtida(curtidaVO);
			status = 201; // Created
			message = "Status curtida criada.";
		} else {
			status = 406; // Not acceptable
			message = "Permiss�o negada";
		}

		return Response.status(status).entity(message).build();
	}

	private boolean objetoPodeSerCriado(CurtidaVO comentarioVO) {
		return true;
	}

}
