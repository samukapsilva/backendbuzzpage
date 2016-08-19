#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ${package}.dao.RegiaoDAO;
import ${package}.entity.Regiao;

/**
 * Classe responsavel por servir de exemplo para a criacao de DAO.
 * 
 * @author Samuel.Pereira
 *
 */
public class RegiaoDaoJPA2Impl extends GenericDaoImpl<Regiao> implements RegiaoDAO {

	private static final String QUERY_BUSCAR_REGIOES = "from Regiao order by descricao";

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	@Override
	public List<Regiao> buscarRegioes() {
		Query query = this.entityManager.createQuery(QUERY_BUSCAR_REGIOES);
		List<Regiao> result = query.getResultList();
		return result;
	}

}