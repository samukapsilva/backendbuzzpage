#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.util.List;

import ${package}.entity.Avaliacao;

/**
 * 
 * @author Alexandre Parreira
 * @see
 */
public interface AvaliacaoDao {

	Avaliacao create(Avaliacao t);

	void delete(Object id);

	Avaliacao find(Object id);

	Avaliacao update(Avaliacao t);

	List<Avaliacao> findAll();

	Avaliacao findUltimaPorConteudo(Long idConteudo);

	Avaliacao salvar(Avaliacao avaliacao);

}
