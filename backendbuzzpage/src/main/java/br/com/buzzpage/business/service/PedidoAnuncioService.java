package br.com.buzzpage.business.service;

import java.util.List;

import br.com.buzzpage.vo.BoletoVO;
import br.com.buzzpage.vo.PedidoAnuncioVO;

public interface PedidoAnuncioService {

	PedidoAnuncioVO cadastrarPedidoAnuncio(PedidoAnuncioVO pedidoAnuncioVO);

	List<PedidoAnuncioVO> findPedidosAnunciante(Long idAnunciante);

	public BoletoVO findById(Long id);

}
