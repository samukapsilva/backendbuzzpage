#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.util.List;

import ${package}.entity.Pedido;

/**
 * 
 * @author Alexandre Parreira
 * @see
 */
public interface PedidoDao {

	Pedido create(Pedido t);

	void delete(Object id);

	Pedido find(Object id);

	List<Pedido> findAll();

}
