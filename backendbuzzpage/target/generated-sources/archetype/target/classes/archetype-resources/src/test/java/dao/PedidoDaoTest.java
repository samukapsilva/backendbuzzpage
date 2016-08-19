#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.util.Date;

import org.springframework.test.context.ContextConfiguration;

import ${package}.entity.Pedido;

@ContextConfiguration({ "/test-applicationContext.xml" })
public class PedidoDaoTest {

	public static Pedido create(PedidoDao dao) {
		Pedido pedido = new Pedido();
		pedido.setId(999L);
		pedido.setCodIugu("algo");
		pedido.setCodRede("rede 1");
		pedido.setDataPedido(new Date());
		pedido.setDataPgto(new Date());
		pedido.setFlagPgtoPedido(true);
		byte z = 111;
		pedido.setIdMeioPgto(z);
		pedido.setQtdeCotas(4);
		pedido.setValorPedido(34.4);

		return dao.create(pedido);
	}

}
