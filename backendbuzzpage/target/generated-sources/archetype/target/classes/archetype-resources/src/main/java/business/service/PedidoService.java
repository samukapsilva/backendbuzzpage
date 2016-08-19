#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import ${package}.entity.Pedido;
import ${package}.vo.BoletoVO;
import ${package}.vo.PedidoVo;

public interface PedidoService {

	Pedido cadastrarPedido(PedidoVo pedidoVo);

	BoletoVO findById(Long id);

}
