package br.com.buzzpage.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.buzzpage.dao.PedidoDao;
import br.com.buzzpage.entity.Pedido;

public class PedidoDaoJPA2Impl extends GenericDaoImpl<Pedido> implements PedidoDao {

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

}
