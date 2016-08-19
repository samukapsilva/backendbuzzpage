#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import ${package}.entity.Curtida;

/**
 * Interface com os servicos de curtida.
 * 
 * @author Samuel.Pereira
 * @see
 */
public interface CurtidaDAO {

	Curtida salvarCurtida(Curtida curtida);

	void atualizarStatusCurtida(Curtida curtida);

	Curtida update(Curtida curtida);
}
