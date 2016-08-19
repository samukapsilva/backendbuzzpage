package br.com.buzzpage.business.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.buzzpage.business.service.AnuncianteService;
import br.com.buzzpage.dao.AnuncianteDao;
import br.com.buzzpage.dao.PaginaDao;
import br.com.buzzpage.dao.PedidoDao;
import br.com.buzzpage.dao.PessoaDao;
import br.com.buzzpage.dao.RegiaoDAO;
import br.com.buzzpage.entity.Anunciante;
import br.com.buzzpage.entity.Pedido;
import br.com.buzzpage.entity.PedidoAnuncio;
import br.com.buzzpage.entity.Pessoa;
import br.com.buzzpage.rest.serviceutil.Constants;
import br.com.buzzpage.rest.serviceutil.PasswordEncryption;
import br.com.buzzpage.util.StringUtil;
import br.com.buzzpage.vo.AnuncianteVO;
import br.com.buzzpage.vo.LoginVo;
import br.com.buzzpage.vo.PedidoAnuncioVO;
import br.com.buzzpage.vo.PedidoVo;

public class AnuncianteServiceImpl implements AnuncianteService {

	@Autowired
	AnuncianteDao anuncianteDao;
	@Autowired
	PessoaDao pessoaDAO;
	@Autowired
	PaginaDao paginaDao;
	@Autowired
	RegiaoDAO regiaoDao;
	@Autowired
	PedidoDao pedidoDao;

	@Override
	public AnuncianteVO salvarAnunciante(AnuncianteVO anuncianteVO) {

		Anunciante anunciante = null;

		if (anuncianteVO.getIdAnunciante() != null
				&& anuncianteVO.getIdAnunciante() > 0) {

			anunciante = anuncianteDao.find(anuncianteVO.getIdAnunciante());
			anunciante = copyVOToEntity(anuncianteVO, anunciante);
			anunciante = anuncianteDao.create(anunciante);

		} else {

			anunciante = new Anunciante();
			anunciante = copyVOToEntity(anuncianteVO, anunciante);
			anunciante = anuncianteDao.update(anunciante);

		}

		anuncianteVO.setIdAnunciante(anunciante.getIdAnunciante());

		return anuncianteVO;

	}

	@Override
	public void deletarAnunciante(AnuncianteVO anuncianteVO) {

		Anunciante anunciante = null;

		if (anuncianteVO.getIdAnunciante() != null
				&& anuncianteVO.getIdAnunciante() > 0) {

			anunciante = anuncianteDao.find(anuncianteVO.getIdAnunciante());

			anuncianteDao.delete(anunciante);
		}

	}

	@Override
	public AnuncianteVO find(Long id) {
		return copyEntityToVO(anuncianteDao.find(id));
	}

	AnuncianteVO copyEntityToVO(Anunciante anunciante) {

		if (anunciante == null || anunciante.getIdAnunciante() == null) {
			return new AnuncianteVO();
		}

		AnuncianteVO anuncianteVO = new AnuncianteVO();
		anuncianteVO.setIdAnunciante(anunciante.getIdAnunciante());
		anuncianteVO.setLogin(anunciante.getLogin());
		anuncianteVO.setDataCadastro(StringUtil.dateToString(
				anunciante.getDataCadastro(),
				Constants.FORMATO_DATA_SEM_SEPARADOR));
		anuncianteVO.setBairro(anunciante.getBairro());
		anuncianteVO.setCep(anunciante.getCep());
		anuncianteVO.setCidade(anunciante.getCidade());
		anuncianteVO.setEndereco(anunciante.getEndereco());
		anuncianteVO.setEstado(anunciante.getEstado());
		anuncianteVO.setNome(anunciante.getNome());
		anuncianteVO.setNumero(anunciante.getNumero());
		anuncianteVO.setNumeroDoc(anunciante.getNumeroDoc());
		anuncianteVO.setTipoDoc(anunciante.getTipoDoc());
		anuncianteVO.setTipoPessoa(anunciante.getTipoPessoa());
		anuncianteVO.setDddFone(anunciante.getDddFone());
		anuncianteVO.setNumeroFone(anunciante.getNumeroFone());
		anuncianteVO.setEmail(anunciante.getEmail());

		anuncianteVO.setNomeFantasia(anunciante.getNomeFantasia());
		anuncianteVO.setNomeContato(anunciante.getNomeContato());
		anuncianteVO.setSite(anunciante.getSite());
		anuncianteVO.setComplemento(anunciante.getComplemento());

		return anuncianteVO;
	}

	AnuncianteVO copyEntityToAnuncianteVO(Anunciante anunciante) {
		if (anunciante == null || anunciante.getIdAnunciante() == null) {
			return new AnuncianteVO();
		}

		List<PedidoVo> pedidosVO = new ArrayList<PedidoVo>();

		AnuncianteVO anuncianteVO = new AnuncianteVO();
		anuncianteVO.setIdAnunciante(anunciante.getIdAnunciante());
		anuncianteVO.setLogin(anunciante.getLogin());
		anuncianteVO.setDataCadastro(StringUtil.dateToString(
				anunciante.getDataCadastro(), Constants.FORMATO_DATA_BR));
		anuncianteVO.setBairro(anunciante.getBairro());
		anuncianteVO.setCep(anunciante.getCep());
		anuncianteVO.setCidade(anunciante.getCidade());
		anuncianteVO.setEndereco(anunciante.getEndereco());
		anuncianteVO.setEstado(anunciante.getEstado());
		anuncianteVO.setNome(anunciante.getNome());
		anuncianteVO.setNumero(anunciante.getNumero());
		anuncianteVO.setNumeroDoc(anunciante.getNumeroDoc());
		anuncianteVO.setTipoDoc(anunciante.getTipoDoc());
		anuncianteVO.setTipoPessoa(anunciante.getTipoPessoa());
		anuncianteVO.setEmail(anunciante.getEmail());

		return anuncianteVO;
	}

	private PedidoAnuncioVO copyEntityToPedidoVo(PedidoAnuncio pedido) {
		PedidoAnuncioVO pedidoVo = new PedidoAnuncioVO();
		pedidoVo.setIdPedidoAnuncio(null);
		return pedidoVo;
	}

	Anunciante copyVOToEntity(AnuncianteVO anuncianteVO, Anunciante anunciante) {

		if (anuncianteVO == null) {
			return new Anunciante();
		}

		if (anuncianteVO.getIdAnunciante() == null
				|| anuncianteVO.getIdAnunciante() == 0) {
			anunciante.setDataCadastro(new Date());
		}

		if (anuncianteVO.getLogin() != null) {
			anunciante.setLogin(anuncianteVO.getLogin());
		}

		if (anuncianteVO.getSenha() != null) {
			anunciante.setSenha(PasswordEncryption.encrypt(anuncianteVO
					.getSenha()));
		}

		if (anuncianteVO.getBairro() != null) {
			anunciante.setBairro(anuncianteVO.getBairro());
		}

		if (anuncianteVO.getCep() != null) {
			anunciante.setCep(anuncianteVO.getCep());
		}

		if (anuncianteVO.getCidade() != null) {
			anunciante.setCidade(anuncianteVO.getCidade());
		}

		if (anuncianteVO.getEndereco() != null) {
			anunciante.setEndereco(anuncianteVO.getEndereco());
		}

		if (anuncianteVO.getEstado() != null) {
			anunciante.setEstado(anuncianteVO.getEstado());
		}

		if (anuncianteVO.getNome() != null) {
			anunciante.setNome(anuncianteVO.getNome());
		}

		if (anuncianteVO.getNumero() != null) {
			anunciante.setNumero(anuncianteVO.getNumero());
		}

		if (anuncianteVO.getNumeroDoc() != null) {
			anunciante.setNumeroDoc(anuncianteVO.getNumeroDoc());
		}

		if (anuncianteVO.getTipoDoc() != null) {
			anunciante.setTipoDoc(anuncianteVO.getTipoDoc());
		}

		if (anuncianteVO.getDddFone() != null) {
			anunciante.setDddFone(anuncianteVO.getDddFone());
		}

		if (anuncianteVO.getNumeroFone() != null) {
			anunciante.setNumeroFone(anuncianteVO.getNumeroFone());
		}

		if (anuncianteVO.getComplemento() != null) {
			anunciante.setComplemento(anuncianteVO.getComplemento());
		}

		if (anuncianteVO.getEmail() != null) {
			anunciante.setEmail(anuncianteVO.getEmail());
		}

		if (anuncianteVO.getIdPessoa() != null
				&& anuncianteVO.getIdPessoa() > 0) {

			Pessoa pessoa = pessoaDAO.find(anuncianteVO.getIdPessoa());
			anunciante.setPessoa(pessoa);

		}

		if (anuncianteVO.getTipoPessoa() != null) {
			anunciante.setTipoPessoa(anuncianteVO.getTipoPessoa());
		}

		if (anuncianteVO.getNomeContato() != null) {
			anunciante.setNomeContato(anuncianteVO.getNomeContato());
		}

		if (anuncianteVO.getNomeFantasia() != null) {
			anunciante.setNomeFantasia(anuncianteVO.getNomeFantasia());
		}

		if (anuncianteVO.getSite() != null) {
			anunciante.setSite(anuncianteVO.getSite());
		}

		return anunciante;
	}

	public Pedido copyPedidoVoToEntity(PedidoVo pedidoVo) {
		Pedido pedido = new Pedido();
		pedido.setId(pedidoVo.getIdPedido());
		return pedido;
	}

	@Override
	public List<AnuncianteVO> buscarAnunciantes(Long idPessoa) {
		List<Anunciante> anunciantes = new ArrayList<Anunciante>();
		List<AnuncianteVO> anunciantesVo = new ArrayList<AnuncianteVO>();
		anunciantes = anuncianteDao.buscarAnunciantes(idPessoa);
		for (Anunciante a : anunciantes) {
			AnuncianteVO aVo = new AnuncianteVO();
			aVo = copyEntityToVO(a);
			anunciantesVo.add(aVo);
		}
		return anunciantesVo;
	}

	/**
	 * Metodo responsavel por realizar a autenticacao de um usuario.
	 * 
	 * @param LoginVO
	 * @return AnuncianteVO
	 */
	public AnuncianteVO efetuarLogin(LoginVo loginVo) {

		AnuncianteVO anuncianteVO = null;
		Anunciante anunciante = anuncianteDao.findByEmailOrLogin(loginVo);

		if (anunciante != null) {
			if (PasswordEncryption.checkPassword(loginVo.getSenha(),
					anunciante.getSenha())) {
				anuncianteVO = copyEntityToAnuncianteVO(anunciante);
			}
		}

		return anuncianteVO;
	}

	@Override
	public void atualizarAnunciante(Long idAnunciante) {
		Anunciante anunciante = new Anunciante();
		anuncianteDao.update(anunciante);
		
	}
}
