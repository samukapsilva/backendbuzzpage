package br.com.buzzpage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.buzzpage.dao.PedidoAnuncioDao;
import br.com.buzzpage.entity.PedidoAnuncio;

/**
 * Data Access Object que representa o PedidoAnuncioDao
 * 
 * @author Samuel Pereira
 */
public class PedidoAnuncioDaoJPA2Impl extends GenericDaoImpl<PedidoAnuncio> implements PedidoAnuncioDao {

	private static final String QUERY_PEDIDOS_ANUNCIANTE = "FROM PedidoAnuncio pa where pa.idPessoa = :idAnunciante";

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	@Override
	public List<PedidoAnuncio> findPedidosAnunciante(Long idAnunciante) {
		Query query = this.entityManager.createQuery(QUERY_PEDIDOS_ANUNCIANTE);
		query.setParameter("idAnunciante", idAnunciante);
		List<PedidoAnuncio> pedidosAnuncio = query.getResultList();
		return pedidosAnuncio;
	}

}