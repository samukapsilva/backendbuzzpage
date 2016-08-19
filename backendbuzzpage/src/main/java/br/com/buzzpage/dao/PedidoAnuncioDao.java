package br.com.buzzpage.dao;

import java.util.List;

import br.com.buzzpage.entity.PedidoAnuncio;

public interface PedidoAnuncioDao {

	List<PedidoAnuncio> findPedidosAnunciante(Long idAnunciante);

	PedidoAnuncio find(Object id);

}
