package br.com.buzzpage.dao;

import java.util.List;

import br.com.buzzpage.entity.CategoriaPagina;

/**
 * 
 * @author ama
 * @see <a href=
 *      "http://www.codingpedia.org/ama/spring-mybatis-integration-example/">http://www.codingpedia.org/ama/spring-mybatis-integration-example/</a>
 */
public interface CategoriaPaginaDao {

	CategoriaPagina create(CategoriaPagina categoria);

	void delete(Object id);

	CategoriaPagina find(Object id);

	CategoriaPagina update(CategoriaPagina t);

	List<CategoriaPagina> findAll();

	public List<CategoriaPagina> findByTipo(Long idTipo);

}
