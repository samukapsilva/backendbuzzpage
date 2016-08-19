package br.com.buzzpage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.buzzpage.dao.CategoriaPaginaDao;
import br.com.buzzpage.entity.CategoriaPagina;

public class CategoriaPaginaDaoJPA2Impl extends GenericDaoImpl<CategoriaPagina> implements CategoriaPaginaDao {

	private static final String QUERY_CATEGORIAS_POR_TIPO = "FROM CategoriaPagina c where c.idTipoPagina = :idTipo";

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	public List<CategoriaPagina> findByTipo(Long idTipo) {

		Query query = this.entityManager.createQuery(QUERY_CATEGORIAS_POR_TIPO);
		query.setParameter("idTipo", idTipo);

		List<CategoriaPagina> result = query.getResultList();

		return result;
	}

}
