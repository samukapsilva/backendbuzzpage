#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import java.util.List;

import ${package}.vo.BoletoVO;
import ${package}.vo.PedidoAnuncioVO;

public interface PedidoAnuncioService {

	PedidoAnuncioVO cadastrarPedidoAnuncio(PedidoAnuncioVO pedidoAnuncioVO);

	List<PedidoAnuncioVO> findPedidosAnunciante(Long idAnunciante);

	public BoletoVO findById(Long id);

}
