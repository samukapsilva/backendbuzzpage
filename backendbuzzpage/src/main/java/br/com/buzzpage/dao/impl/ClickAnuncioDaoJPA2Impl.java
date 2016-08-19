package br.com.buzzpage.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.buzzpage.dao.ClickAnuncioDao;
import br.com.buzzpage.entity.ClickAnuncio;

/**
 * Classe responsavel por implementar o ClickAnuncioDao.
 * 
 * @author Samuel.Pereira
 */
public class ClickAnuncioDaoJPA2Impl extends GenericDaoImpl<ClickAnuncio> implements ClickAnuncioDao {

	private static final String QUERY_CLICK_ANUNCIO_POR_ID_ANUNCIO = "FROM ClickAnuncio c where c.idBanner = :idAnuncio";

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	@Override
	public Long buscarClicksAnuncio(Long idAnuncio) {
		Query query = this.entityManager.createQuery(QUERY_CLICK_ANUNCIO_POR_ID_ANUNCIO);
		query.setParameter("idAnuncio", idAnuncio);
		Long qtdeClicksAnuncio = (Long) query.getSingleResult();
		return qtdeClicksAnuncio;
	}

	@Override
	public void delete(ClickAnuncio id) {
		delete(id);
	}

	@Override
	public ClickAnuncio update(ClickAnuncio clickAnuncio) {
		return update(clickAnuncio);
	}

	public ClickAnuncio salvarClickAnuncio(ClickAnuncio clickAnuncio) {
		return create(clickAnuncio);
	}
}