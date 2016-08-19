package br.com.buzzpage.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.buzzpage.dao.VoucherDAO;
import br.com.buzzpage.entity.Voucher;

public class VoucherDaoJPA2Impl extends GenericDaoImpl<Voucher> implements VoucherDAO {

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

 

}