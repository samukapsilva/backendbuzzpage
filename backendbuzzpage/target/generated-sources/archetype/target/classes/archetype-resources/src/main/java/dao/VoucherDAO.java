#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.util.List;

import ${package}.entity.Pedido;
import ${package}.entity.Voucher;

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
