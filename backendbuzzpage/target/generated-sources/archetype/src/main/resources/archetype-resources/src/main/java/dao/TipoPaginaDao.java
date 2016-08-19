#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.util.List;

import ${package}.entity.TipoPagina;

/**
 * 
 * @author ama
 * @see <a href=
 *      "http://www.codingpedia.org/ama/spring-mybatis-integration-example/">http://www.codingpedia.org/ama/spring-mybatis-integration-example/</a>
 */
public interface TipoPaginaDao {

	TipoPagina create(TipoPagina tipo);

	void delete(Object id);

	TipoPagina find(Object id);

	TipoPagina update(TipoPagina t);

	List<TipoPagina> findAll();

}
