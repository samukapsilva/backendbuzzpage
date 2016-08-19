package br.com.buzzpage.dao;

import java.util.List;

import br.com.buzzpage.entity.ExtratoFinanceiro;

public interface ExtratoFinanceiroDao {

	ExtratoFinanceiro create(ExtratoFinanceiro t);

	void delete(Object id);

	ExtratoFinanceiro find(Object id);

	ExtratoFinanceiro update(ExtratoFinanceiro t);

	List<ExtratoFinanceiro> findAll();

	List<ExtratoFinanceiro> findPorIdPessoa(Long idPessoa);

}