package br.com.buzzpage.business.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.buzzpage.business.service.PedidoAnuncioService;
import br.com.buzzpage.dao.AnuncianteDao;
import br.com.buzzpage.dao.PaginaAnuncioDAO;
import br.com.buzzpage.dao.PedidoAnuncioDao;
import br.com.buzzpage.dao.PessoaDao;
import br.com.buzzpage.entity.Anunciante;
import br.com.buzzpage.entity.PaginaAnuncio;
import br.com.buzzpage.entity.PedidoAnuncio;
import br.com.buzzpage.rest.serviceutil.Constants;
import br.com.buzzpage.util.StringUtil;
import br.com.buzzpage.vo.BoletoVO;
import br.com.buzzpage.vo.ItemPedidoVO;
import br.com.buzzpage.vo.PedidoAnuncioVO;

public class PedidoAnuncioServiceImpl implements PedidoAnuncioService {

	@Autowired
	PedidoAnuncioDao pedidoAnuncioDao;
	@Autowired
	PessoaDao pessoaDao;
	@Autowired
	AnuncianteDao anuncianteDao;
	@Autowired
	PaginaAnuncioDAO paginaAnuncioDao;

	public List<PedidoAnuncioVO> findPedidosAnunciante(Long idAnunciante) {
		List<PedidoAnuncio> pedidosAnuncio = pedidoAnuncioDao.findPedidosAnunciante(idAnunciante);
		List<PedidoAnuncioVO> pedidosAnuncioVO = new ArrayList<PedidoAnuncioVO>();
			for(PedidoAnuncio p :pedidosAnuncio){
				PedidoAnuncioVO pAVO = new PedidoAnuncioVO();
				pAVO = copyEntityToVO(p);
			}
		return pedidosAnuncioVO;
	}

	@Override
	public PedidoAnuncioVO cadastrarPedidoAnuncio(PedidoAnuncioVO pedidoAnuncioVO) {
		return null;
	}

	private PedidoAnuncioVO copyEntityToVO(PedidoAnuncio pedidoAnuncio) {
		
		return null;
	}

	public BoletoVO findById(Long id) {

		BoletoVO boleto = new BoletoVO();

		
		PedidoAnuncio pedido = pedidoAnuncioDao.find(id);

		if (pedido == null || pedido.getIdPedidoAnuncio() == null || pedido.getIdPedidoAnuncio() == 0) {

			return boleto;

		}

		List<ItemPedidoVO> itens = new ArrayList<ItemPedidoVO>();
		
		Anunciante anunciante = anuncianteDao.find(pedido.getIdPedidoAnuncio());
		
		List<PaginaAnuncio> paginasAnuncio =  paginaAnuncioDao.findPaginasAnunciante(anunciante.getIdAnunciante());

			for(PaginaAnuncio p : paginasAnuncio){
				ItemPedidoVO item = new ItemPedidoVO();
				item.setIdProduto(p.getPagina().getIdPagina());
				item.setNomeProduto(p.getPagina().getTitulo());
				item.setResumoProduto(p.getPagina().getTitulo());
				item.setQtdeProduto(1);
				item.setPrecoUnitario(p.getValor());
				item.setValorTotal(p.getValor());
				
				itens.add(item);
				
			}
		
		
		if (anunciante != null) {
			boleto.setCep(anunciante.getCep());
			boleto.setCidade(anunciante.getCidade());
			boleto.setComplemento(anunciante.getComplemento());
			boleto.setCpf_cnpj(anunciante.getNumeroDoc());
			boleto.setCpfSacado(anunciante.getNumeroDoc());
			boleto.setDdd(anunciante.getDddFone());
			boleto.setEmail(anunciante.getEmail());
			boleto.setEndereco(anunciante.getEndereco());
			boleto.setEstado(anunciante.getEstado());

		}

		boleto.setDataEmissao(StringUtil.dateToString(new Date(), Constants.FORMATO_DATA_BR));
		Date dataValidade = new Date();
		boleto.setDataValidade(StringUtil.dateToString(StringUtil.addDays(dataValidade, 3), Constants.FORMATO_DATA_BR));

		boleto.setInstrucoes("");
		

		Long idProduto = 1L;
		Double valorTotal = 1 * Constants.VALOR_COTA; // TODO: tirar dúvida com
														// alexandre
		ItemPedidoVO item = new ItemPedidoVO(idProduto, "Cotas BuzzPage", "Sociedade em Conta de Participaï¿½ï¿½o", 1,
				Constants.VALOR_COTA, valorTotal);
		// TODO:tirar dúvida com alexandre
		itens.add(item);
		boleto.setItens(itens);
		boleto.setMensagem("");
		boleto.setNossoNumero(String.valueOf(pedido.getIdPedidoAnuncio()));
		boleto.setNumero(pedido.getIdPedidoAnuncio() + "");
		boleto.setPais("Brasil");
		boleto.setSacado(anunciante.getNome());
		boleto.setTipoPedido(1L);
		boleto.setValorBoleto(pedido.getValorPedido());

		return boleto;
	}

}
