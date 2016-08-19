#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ${package}.dao.VoucherDAO;
import ${package}.entity.Voucher;

public class VoucherDaoJPA2Impl extends GenericDaoImpl<Voucher> implements VoucherDAO {

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

 

}