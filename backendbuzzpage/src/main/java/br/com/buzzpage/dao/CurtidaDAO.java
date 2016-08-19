package br.com.buzzpage.dao;

import br.com.buzzpage.entity.Curtida;

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
