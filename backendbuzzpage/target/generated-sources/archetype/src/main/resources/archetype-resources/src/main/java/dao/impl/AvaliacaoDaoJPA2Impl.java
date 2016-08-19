#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import ${package}.dao.AvaliacaoDao;
import ${package}.entity.Avaliacao;

public class AvaliacaoDaoJPA2Impl extends GenericDaoImpl<Avaliacao> implements AvaliacaoDao {

	private static final String QUERY_AVALIACAO_CONTEUDO_ORDER_DESC = "FROM Avaliacao a where a.idConteudo = :idTexto order by a.id desc";

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	public Avaliacao findUltimaPorConteudo(Long idConteudo) {

		Avaliacao avaliacao = null;

		Query query = this.entityManager.createQuery(QUERY_AVALIACAO_CONTEUDO_ORDER_DESC);
		query.setParameter("idTexto", idConteudo);
		query.setMaxResults(1);
		List<Avaliacao> result = query.getResultList();

		if (result != null && result.size() > 0) {
			avaliacao = result.get(0);
		}

		return avaliacao;

	}

	public Avaliacao salvar(Avaliacao avaliacao) {

		try {
			return create(avaliacao);

		} catch (PersistenceException e) {
			e.printStackTrace();
		}

		return null;
	}

}
