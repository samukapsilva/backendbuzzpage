#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.util.List;

import ${package}.entity.TipoLancamento;

public interface TipoLancamentoDao {

	TipoLancamento create(TipoLancamento tipo);

	void delete(Object id);

	TipoLancamento find(Object id);

	TipoLancamento update(TipoLancamento t);

	List<TipoLancamento> findAll();

}
