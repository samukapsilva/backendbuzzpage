#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ${package}.dao.ExtratoFinanceiroDao;
import ${package}.entity.ExtratoFinanceiro;

public class ExtratoFinanceiroDaoJPA2Impl extends GenericDaoImpl<ExtratoFinanceiro> implements ExtratoFinanceiroDao {

	private static final String QUERY_EXTRATO_FINANCEIRO_POR_ID_PESSOA = "FROM ExtratoFinanceiro e where e.pessoa.idPessoa = :idPessoa";

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	@Override
	public List<ExtratoFinanceiro> findPorIdPessoa(Long idPessoa) {
		Query query = this.entityManager.createQuery(QUERY_EXTRATO_FINANCEIRO_POR_ID_PESSOA);
		query.setParameter("idPessoa", idPessoa);

		List<ExtratoFinanceiro> result = query.getResultList();

		return result;
	}

}
