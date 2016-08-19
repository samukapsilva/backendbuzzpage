#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ${package}.business.service.AnuncioService;
import ${package}.dao.AnuncianteDao;
import ${package}.dao.AnuncioDAO;
import ${package}.dao.PaginaAnuncioDAO;
import ${package}.dao.PaginaDao;
import ${package}.dao.PessoaDao;
import ${package}.dao.RegiaoDAO;
import ${package}.entity.Anuncio;
import ${package}.entity.Pagina;
import ${package}.entity.PaginaAnuncio;
import ${package}.entity.Pessoa;
import ${package}.rest.serviceutil.Constants;
import ${package}.util.StringUtil;
import ${package}.vo.AnuncioVO;
import ${package}.vo.DadosGrid;
import ${package}.vo.GridAnunciosVo;
import ${package}.vo.LocalVO;
import ${package}.vo.PaginaVo;

public class AnuncioServiceImpl implements AnuncioService {

	@Autowired
	AnuncioDAO anuncioDao;
	@Autowired
	PessoaDao pessoaDAO;
	@Autowired
	PaginaDao paginaDao;
	@Autowired
	RegiaoDAO regiaoDao;
	@Autowired
	PaginaAnuncioDAO paginaAnuncioDao;
	@Autowired
	AnuncianteDao anuncianteDao;

	@Override
	public AnuncioVO salvarAnuncio(AnuncioVO anuncioVO) {
		Anuncio anuncio = new Anuncio();
		anuncio = copyVOToEntity(anuncio, anuncioVO);
		anuncio = anuncioDao.salvarAnuncio(anuncio);

		List<LocalVO> locais = anuncioVO.getLocais();

		for (LocalVO local : locais) {
			PaginaAnuncio pa = new PaginaAnuncio();
			// configuracao dos ids de paginas e regiao
			pa.setPagina(paginaDao.find(local.getIdPagina()));
			pa.setRegiao(regiaoDao.find(local.getIdRegiao()));

			pa.setAnuncio(anuncio);
			// configuracao dos banners
			pa.setBanner1(local.getBanner1());

			if (local.getBanner2() != null) {
				pa.getBanner2();
			}
			if (local.getBanner3() != null) {
				pa.getBanner3();
			}
			if (local.getBanner4() != null) {
				pa.getBanner4();
			}
			if (local.getBanner5() != null) {
				pa.getBanner5();
			}

			// configuracao dos links dos banners
			pa.setLink1(local.getLink1());

			if (local.getLink2() != null) {
				pa.getLink2();
			}
			if (local.getLink3() != null) {
				pa.getLink3();
			}
			if (local.getLink4() != null) {
				pa.getLink4();
			}
			if (local.getLink5() != null) {
				pa.getLink5();
			}
			paginaAnuncioDao.create(pa);
		}

		anuncioVO.setIdEmpresa(anuncio.getIdAnuncio());

		return anuncioVO;
	}

	@Override
	public void delete(AnuncioVO anuncioVO) {
		Anuncio anuncio = new Anuncio();
		anuncio = copyVOToEntity(anuncio, anuncioVO);
		anuncioDao.delete(anuncio);
	}

	@Override
	public List<AnuncioVO> buscarAnunciosAnunciante(Long idAnunciante) {
		List<AnuncioVO> listaRetornoVO = new ArrayList<AnuncioVO>();

		List<Anuncio> listaRetorno = anuncioDao.buscarAnunciosAnunciante(idAnunciante);
		for (Anuncio an : listaRetorno) {
			AnuncioVO anuncioVO = new AnuncioVO();
			List<LocalVO> locaisRetorno = new ArrayList<LocalVO>();
			List<PaginaAnuncio> listaLocais = paginaAnuncioDao.buscarLocais(an.getAnunciante().getIdAnunciante());
			for (PaginaAnuncio p : listaLocais) {
				LocalVO local = new LocalVO();
				// configuracao dos ids de paginas e regiao
				local.setIdRegiao(p.getRegiao().getIdRegiao());
				local.setIdPagina(p.getPagina().getIdPagina());
				// configuracao dos banners
				local.setBanner1(p.getBanner1());
				local.setBanner2(p.getBanner2());
				local.setBanner3(p.getBanner3());
				local.setBanner4(p.getBanner4());
				local.setBanner5(p.getBanner5());
				// configuracao dos links
				local.setLink1(p.getLink1());
				local.setLink2(p.getLink2());
				local.setLink3(p.getLink3());
				local.setLink4(p.getLink4());
				local.setLink5(p.getLink5());

				locaisRetorno.add(local);
			}
			anuncioVO = copyEntityToVO(an);
			anuncioVO.setLocais(locaisRetorno);
			listaRetornoVO.add(anuncioVO);
		}
		return listaRetornoVO;
	}

	public AnuncioVO buscarAnuncioAnunciante(Long idAnunciante, Long idAnuncio) {

		Anuncio anuncio = anuncioDao.buscarAnuncioAnunciante(idAnunciante, idAnuncio);
		List<PaginaAnuncio> listaLocais = paginaAnuncioDao.buscarLocais(anuncio.getAnunciante().getIdAnunciante());

		for (PaginaAnuncio local : listaLocais) {
			PaginaAnuncio pa = new PaginaAnuncio();
			pa.setAnuncio(anuncio);
			pa.setBanner1(local.getBanner1());
			pa.setRegiao(regiaoDao.find(local.getRegiao().getIdRegiao()));
			pa.setPagina(paginaDao.find(local.getPagina().getIdPagina()));
			paginaAnuncioDao.create(pa);
		}
		return copyEntityToVO(anuncio);
	}

	@Override
	public AnuncioVO update(AnuncioVO anuncioVO) {
		Anuncio anuncio = new Anuncio();
		copyVOToEntity(anuncio, anuncioVO);
		anuncio = anuncioDao.update(anuncio);
		return copyEntityToVO(anuncioDao.update(anuncio));
	}

	@Override
	public AnuncioVO find(AnuncioVO id) {
		return this.find(id);
	}

	AnuncioVO copyEntityToVO(Anuncio anuncio) {
		if (anuncio == null || anuncio.getIdAnuncio() == null) {
			return new AnuncioVO();
		}

		AnuncioVO anuncioVO = new AnuncioVO();
		anuncioVO.setIdAnuncio(anuncio.getIdAnuncio());
		anuncioVO.setDataInicio(StringUtil.dateToString(anuncio.getDataInicio(), Constants.FORMATO_DATA_BR));
		anuncioVO.setDataFinal(StringUtil.dateToString(anuncio.getDataFinal(), Constants.FORMATO_DATA_BR));
		anuncioVO.setIdEmpresa(anuncio.getAnunciante().getIdAnunciante());
		return anuncioVO;
	}

	/**
	 * Metodo responsavel por fazer bind de vo para entity.
	 * 
	 * @param anuncioVO
	 * @return Anuncio
	 */
	Anuncio copyVOToEntity(Anuncio anuncio, AnuncioVO anuncioVO) {

		try {
			if (anuncioVO.getDataInicio() != null) {
				anuncio.setDataInicio(
						StringUtil.formataData(anuncioVO.getDataInicio(), Constants.FORMATO_DATA_SEM_SEPARADOR_USA));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		anuncio.setDataCriacao(new Date());
		anuncio.setAnunciante(anuncianteDao.find(anuncioVO.getIdEmpresa()));
		return anuncio;
	}

	public Pagina copyPaginaVoToEntity(PaginaVo vo) {

		Pessoa pessoa = null;

		Pagina pagina = new Pagina();

		pagina.setCep(vo.getCep());
		pagina.setCidade(vo.getCidade());
		pagina.setEndereco(vo.getEndereco());
		pagina.setEstado(vo.getEstado());
		pagina.setFone(vo.getFone());
		pagina.setIdCategoriaPagina(vo.getIdCategoriaPagina());
		pagina.setIdTipoPagina(vo.getIdTipoPagina());
		pagina.setPalavraChave(vo.getPalavraChave());
		pagina.setResumo(vo.getResumo());
		pagina.setSite(vo.getSite());
		pagina.setSlug(vo.getSlug());
		pagina.setTitulo(vo.getTitulo());

		if (pagina.getIdPagina() != null && pagina.getIdPagina() > 0) {
			pagina.setFlagPublicado(vo.getFlagPublicado());
		} else {
			pagina.setFlagPublicado(true);
		}

		if (vo.getIdPessoa() != null && vo.getIdPessoa() > 0) {
			pessoa = pessoaDAO.find(vo.getIdPessoa());
			pagina.setPessoa(pessoa);
		}

		return pagina;
	}

	public PaginaVo copyEntityToPaginaVo(Pagina pagina) {
		PaginaVo vo = new PaginaVo();

		vo.setCep(pagina.getCep());
		vo.setCidade(pagina.getCidade());
		vo.setEndereco(pagina.getEndereco());
		vo.setEstado(pagina.getEstado());
		vo.setFone(pagina.getFone());
		vo.setIdCategoriaPagina(pagina.getIdCategoriaPagina());
		vo.setIdTipoPagina(pagina.getIdTipoPagina());
		vo.setPalavraChave(pagina.getPalavraChave());
		vo.setResumo(pagina.getResumo());
		vo.setSite(pagina.getSite());
		vo.setSlug(pagina.getSlug());
		vo.setTitulo(pagina.getTitulo());
		vo.setIdPagina(pagina.getIdPagina());
		vo.setFlagPublicado(pagina.getFlagPublicado());

		return vo;
	}

	@Override
	public boolean deleteAnuncioDeAnunciante(Long idAnuncio, Long idAnunciante) {
		// TODO Auto-generated method stub
		// buscar um anuncio peloidAnuncio e idAnunciante
		Anuncio anuncio = anuncioDao.find(idAnuncio);

		anuncioDao.delete(anuncio);

		return true;
	}

	@Override
	public DadosGrid montarGridAnuncios(Long idAnunciante) {
		//

		DadosGrid dados = new DadosGrid();

		List<AnuncioVO> lista = new ArrayList<AnuncioVO>();

		List<Anuncio> anuncios = anuncioDao.buscarAnunciosAnunciante(idAnunciante);

		if (anuncios != null) {
			for (Anuncio anuncio : anuncios) {

				AnuncioVO anVo = copyEntityToVO(anuncio);
				lista.add(anVo);

			}
		}

		GridAnunciosVo[] data = new GridAnunciosVo[lista.size()];

		int i = 0;

		for (AnuncioVO anVo : lista) {
			GridAnunciosVo grid = new GridAnunciosVo();
				grid.setId(anVo.getIdAnuncio());
				grid.setDataInicial(anVo.getDataInicio());
				grid.setDataFinal(anVo.getDataFinal());
				grid.setValor(anVo.getValor());

			data[i] = grid;

			i++;
		}

		dados.setData(data);
		dados.setDraw(1);
		dados.setRecordsFiltered(lista.size());
		dados.setRecordsTotal(lista.size());

		return dados;
	}

}
//samuel