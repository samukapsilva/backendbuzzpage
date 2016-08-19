#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ${package}.dao.PedidoDao;
import ${package}.entity.Pedido;

public class PedidoDaoJPA2Impl extends GenericDaoImpl<Pedido> implements PedidoDao {

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

}
