package br.com.buzzpage.dao;

import java.util.List;

import br.com.buzzpage.entity.Pedido;

/**
 * 
 * @author Alexandre Parreira
 * @see
 */
public interface PedidoDao {

	Pedido create(Pedido t);

	void delete(Object id);

	Pedido find(Object id);

	List<Pedido> findAll();

}
