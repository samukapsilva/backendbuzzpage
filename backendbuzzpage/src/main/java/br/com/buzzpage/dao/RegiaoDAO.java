package br.com.buzzpage.dao;

import java.util.List;

import br.com.buzzpage.entity.Regiao;

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
