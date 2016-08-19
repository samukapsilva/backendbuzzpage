#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ${package}.dao.TipoPaginaDao;
import ${package}.entity.TipoPagina;

public class TipoPaginaDaoJPA2Impl extends GenericDaoImpl<TipoPagina> implements TipoPaginaDao {

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

}
