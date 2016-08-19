#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ${package}.business.service.PedidoService;
import ${package}.dao.PedidoDao;
import ${package}.dao.PessoaDao;
import ${package}.entity.Pedido;
import ${package}.entity.Pessoa;
import ${package}.rest.serviceutil.Constants;
import ${package}.util.StringUtil;
import ${package}.vo.BoletoVO;
import ${package}.vo.ItemPedidoVO;
import ${package}.vo.PedidoVo;

public class PedidoServiceImpl implements PedidoService {

	@Autowired
	PessoaDao pessoaDao;

	@Autowired
	PedidoDao pedidoDao;

	@Transactional(noRollbackFor = PersistenceException.class)
	public Pedido cadastrarPedido(PedidoVo pedidoVo) {
		// TODO Auto-generated method stub

		Pedido pedido = null;

		if (pedidoVo.getIdPedido() != null && pedidoVo.getIdPedido() > 0) {
			pedido = pedidoDao.find(pedidoVo.getIdPedido());
		} else {
			pedido = new Pedido();
		}

		pedido = copyVoToEntity(pedidoVo, pedido);

		pedidoDao.create(pedido);

		return pedido;

	}

	private Pedido copyVoToEntity(PedidoVo pedidoVo, Pedido pedido) {

		if (pedidoVo.getCodIugu() != null) {
			pedido.setCodIugu(pedidoVo.getCodIugu());
		}

		if (pedidoVo.getCodRede() != null) {
			pedido.setCodRede(pedidoVo.getCodRede());
		}

		if (pedido.getId() != null) {
			pedido.setDataPedido(new Date());
		}

		if (pedidoVo.getFlagPgtoPedido() != null) {
			pedido.setFlagPgtoPedido(pedidoVo.getFlagPgtoPedido());
		}

		if (pedidoVo.getIdMeioPgto() != null) {
			pedido.setIdMeioPgto(pedidoVo.getIdMeioPgto());
		}

		if (pedidoVo.getQtdeCotas() != null) {
			pedido.setValorPedido(pedidoVo.getQtdeCotas() * Constants.VALOR_COTA);
		}

		if (pedidoVo.getIdPessoa() != null && pedidoVo.getIdPessoa() > 0) {

			Pessoa pessoa = pessoaDao.find(pedidoVo.getIdPessoa());
			pedido.setPessoa(pessoa);

		}
		if (pedidoVo.getQtdeCotas() != null && pedidoVo.getQtdeCotas() > 0) {
			pedido.setQtdeCotas(pedidoVo.getQtdeCotas());
		}
		return pedido;
	}

	private PedidoVo copyEntityToVo(PedidoVo pedidoVo, Pedido pedido) {

		pedidoVo.setCodIugu(pedido.getCodIugu());
		pedidoVo.setCodRede(pedido.getCodRede());
		pedidoVo.setDataPedido(StringUtil.dateToString(pedido.getDataPedido(), Constants.FORMATO_DATA_BR));
		pedidoVo.setFlagPgtoPedido(pedido.getFlagPgtoPedido());
		pedidoVo.setIdMeioPgto(pedido.getIdMeioPgto());
		pedidoVo.setQtdeCotas(pedidoVo.getQtdeCotas());
		pedidoVo.setValorPedido(pedido.getQtdeCotas() * Constants.VALOR_COTA);

		Pessoa pessoa = pessoaDao.findByIdPedido(pedido.getId());

		if (pessoa != null) {
			pedidoVo.setIdPessoa(pessoa.getIdPessoa());
			pedidoVo.setNomePessoa(pessoa.getNome());
			pedidoVo.setCep(pedidoVo.getCep());
			pedidoVo.setCpf(pessoa.getNumeroDocumento());
			pedidoVo.setCidade(pessoa.getCidade());
			pedidoVo.setEstado(pessoa.getEstado());
			pedidoVo.setEndereco(pessoa.getEndereco());
		}

		return pedidoVo;
	}

	public BoletoVO findById(Long id) {

		BoletoVO boleto = new BoletoVO();

		PedidoVo pedidoVo = new PedidoVo();

		Pedido pedido = pedidoDao.find(id);

		if (pedido == null || pedido.getId() == null || pedido.getId() == 0) {

			return boleto;

		}

		Pessoa pessoa = pessoaDao.findByIdPedido(pedido.getId());

		if (pessoa != null) {
			boleto.setCep(pessoa.getCep());
			boleto.setCidade(pessoa.getCidade());
			boleto.setComplemento(pessoa.getComplemento());
			boleto.setCpf_cnpj(pessoa.getNumeroDocumento());
			boleto.setCpfSacado(pessoa.getNumeroDocumento());
			boleto.setDdd(pessoa.getDddFoneFixo());
			boleto.setEmail(pessoa.getEmail());
			boleto.setEndereco(pessoa.getEndereco());
			boleto.setEstado(pessoa.getEstado());
			boleto.setFone(pessoa.getFoneFixo());
		}

		boleto.setDataEmissao(StringUtil.dateToString(new Date(), Constants.FORMATO_DATA_BR));
		Date dataValidade = new Date();
		boleto.setDataValidade(StringUtil.dateToString(StringUtil.addDays(dataValidade, 3), Constants.FORMATO_DATA_BR));

		boleto.setInstrucoes("");
		List<ItemPedidoVO> itens = new ArrayList<ItemPedidoVO>();

		Long idProduto = 1L;
		Double valorTotal = pedido.getQtdeCotas() * Constants.VALOR_COTA;
		ItemPedidoVO item = new ItemPedidoVO(idProduto, "Cotas BuzzPage", "Sociedade em Conta de Participa��o",
				pedido.getQtdeCotas(), Constants.VALOR_COTA, valorTotal);
		itens.add(item);
		boleto.setItens(itens);
		boleto.setMensagem("");
		boleto.setNossoNumero(String.valueOf(pedido.getId()));
		boleto.setNumero(pessoa.getNumero());
		boleto.setPais("Brasil");
		boleto.setSacado(pessoa.getNome());
		boleto.setTipoPedido(1L);
		boleto.setValorBoleto(pedido.getValorPedido());

		return boleto;
	}
	
}