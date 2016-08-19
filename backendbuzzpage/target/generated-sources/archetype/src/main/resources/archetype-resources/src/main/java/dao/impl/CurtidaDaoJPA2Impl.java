#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ${package}.dao.CurtidaDAO;
import ${package}.entity.Curtida;

/**
 * Classe responsavel por servir de exemplo para a criacao de DAO.
 * 
 * @author Samuel.Pereira
 *
 */
public class CurtidaDaoJPA2Impl extends GenericDaoImpl<Curtida> implements CurtidaDAO {

	private static final String QUERY_ATUALIZAR_STATUS_CURTIDA = "update Curtida c set status_curtida=:statusCurtida where c.pessoa.idPessoa = :idColaborador and idCurtida =:idCurtida";

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	public Curtida salvarCurtida(Curtida curtida) {
		return create(curtida);
	}

	public Curtida update(Curtida curtida) {
		return update(curtida);
	}

	@Override
	public void atualizarStatusCurtida(Curtida curtida) {
		Query query = this.entityManager.createQuery(QUERY_ATUALIZAR_STATUS_CURTIDA);
		query.setParameter("statusCurtida", curtida.getStatusCurtida());
		query.setParameter("idColaborador", curtida.getPessoa().getIdPessoa());
		query.setParameter("idCurtida", curtida.getIdCurtida());
	}
}