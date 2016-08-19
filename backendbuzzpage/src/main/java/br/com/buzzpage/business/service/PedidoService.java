package br.com.buzzpage.business.service;

import br.com.buzzpage.entity.Pedido;
import br.com.buzzpage.vo.BoletoVO;
import br.com.buzzpage.vo.PedidoVo;

public interface PedidoService {

	Pedido cadastrarPedido(PedidoVo pedidoVo);

	BoletoVO findById(Long id);

}
