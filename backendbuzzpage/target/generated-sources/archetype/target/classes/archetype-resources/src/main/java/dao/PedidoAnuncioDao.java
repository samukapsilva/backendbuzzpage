#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.util.List;

import ${package}.entity.PedidoAnuncio;

public interface PedidoAnuncioDao {

	List<PedidoAnuncio> findPedidosAnunciante(Long idAnunciante);

	PedidoAnuncio find(Object id);

}
