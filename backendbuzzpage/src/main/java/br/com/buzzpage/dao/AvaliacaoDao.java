package br.com.buzzpage.dao;

import java.util.List;

import br.com.buzzpage.entity.Avaliacao;

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
