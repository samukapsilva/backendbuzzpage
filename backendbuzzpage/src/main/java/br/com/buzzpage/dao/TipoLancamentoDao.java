package br.com.buzzpage.dao;

import java.util.List;

import br.com.buzzpage.entity.TipoLancamento;

public interface TipoLancamentoDao {

	TipoLancamento create(TipoLancamento tipo);

	void delete(Object id);

	TipoLancamento find(Object id);

	TipoLancamento update(TipoLancamento t);

	List<TipoLancamento> findAll();

}
