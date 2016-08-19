#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.util.List;

import ${package}.entity.Regiao;

/**
 * Interface com os servicos de comentario.
 * 
 * @author Samuel.Pereira
 * @see
 */
public interface RegiaoDAO {

	Regiao create(Regiao t);

	public List<Regiao> buscarRegioes();

	Regiao find(Object id);
}
