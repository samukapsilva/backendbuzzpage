#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.util.List;

import ${package}.entity.ExtratoFinanceiro;

public interface ExtratoFinanceiroDao {

	ExtratoFinanceiro create(ExtratoFinanceiro t);

	void delete(Object id);

	ExtratoFinanceiro find(Object id);

	ExtratoFinanceiro update(ExtratoFinanceiro t);

	List<ExtratoFinanceiro> findAll();

	List<ExtratoFinanceiro> findPorIdPessoa(Long idPessoa);

}