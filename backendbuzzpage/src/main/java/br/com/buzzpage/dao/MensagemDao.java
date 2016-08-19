package br.com.buzzpage.dao;

import java.util.List;

import br.com.buzzpage.entity.Mensagem;

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
