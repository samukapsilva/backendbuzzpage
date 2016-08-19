package br.com.buzzpage.dao;

import java.util.List;

import br.com.buzzpage.entity.TipoPagina;

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
