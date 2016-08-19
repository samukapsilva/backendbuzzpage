#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.util.List;

import ${package}.entity.Mensagem;

/**
 * 
 * @author Alexandre Parreira
 * @see
 */
public interface MensagemDao {

	Mensagem create(Mensagem m);

	void delete(Object id);

	Mensagem find(Object id);

	Mensagem update(Mensagem m);

	List<Mensagem> findAll();

	Mensagem findByRemetenteEIdMensagem(Long id, Long idPessoa);

	List<Mensagem> findMensagensDaPessoaPorConteudo(Long idPessoa, Long idConteudo);

}
