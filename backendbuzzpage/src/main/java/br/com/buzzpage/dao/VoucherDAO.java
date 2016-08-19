package br.com.buzzpage.dao;

import java.util.List;

import br.com.buzzpage.entity.Pedido;
import br.com.buzzpage.entity.Voucher;

/**
 * Interface com os servicos de comentario.
 * 
 * @author Samuel.Pereira
 * @see
 */
public interface VoucherDAO {
	
	Voucher create(Voucher t);

	void delete(Object id);

	Voucher find(Object id);

	List<Voucher> findAll();

	 
}
