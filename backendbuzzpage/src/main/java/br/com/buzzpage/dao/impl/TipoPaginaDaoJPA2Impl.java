package br.com.buzzpage.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.buzzpage.dao.TipoPaginaDao;
import br.com.buzzpage.entity.TipoPagina;

public class TipoPaginaDaoJPA2Impl extends GenericDaoImpl<TipoPagina> implements TipoPaginaDao {

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

}
