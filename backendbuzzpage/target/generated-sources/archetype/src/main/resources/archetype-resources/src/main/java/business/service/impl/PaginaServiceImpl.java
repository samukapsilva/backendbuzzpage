#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ${package}.business.service.PaginaService;
import ${package}.dao.CategoriaPaginaDao;
import ${package}.dao.ConteudoColaboradorDao;
import ${package}.dao.PaginaDao;
import ${package}.dao.PessoaDao;
import ${package}.dao.TipoPaginaDao;
import ${package}.entity.CategoriaPagina;
import ${package}.entity.Pagina;
import ${package}.entity.Pessoa;
import ${package}.entity.TipoPagina;
import ${package}.vo.AlterarPublicacaoVo;
import ${package}.vo.CategoriaVo;
import ${package}.vo.PaginaVo;

public class PaginaServiceImpl implements PaginaService {

	@Autowired
	private ConteudoColaboradorDao conteudoDao;

	@Autowired
	private PaginaDao paginaDao;

	@Autowired
	private PessoaDao pessoaDao;

	@Autowired
	private CategoriaPaginaDao categoriaDao;

	@Autowired
	private TipoPaginaDao tipoPaginaDao;

	public List<Pagina> findAll() {
		return paginaDao.findAll();
	}

	public Pagina findBySlug(String slug) {
		return paginaDao.findBySlug(slug);
	}

	public Pagina criarPagina(PaginaVo paginaVo) {
		// TODO Auto-generated method stub

		Pagina pagina = null;

		if (paginaVo.getIdPagina() != null && paginaVo.getIdPagina() > 0) {
			pagina = paginaDao.find(paginaVo.getIdPagina());

			if (pagina == null) {
				pagina = new Pagina();
			}
		} else {
			pagina = new Pagina();
		}

		pagina = copyVoToEntity(pagina, paginaVo);

		if (pagina.getIdPagina() != null && pagina.getIdPagina() > 0) {
			paginaDao.update(pagina);
		} else {
			paginaDao.create(pagina);
		}

		return pagina;
	}

	public PaginaVo copyEntityToVo(Pagina pagina) {
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

	public Pagina copyVoToEntity(Pagina pagina, PaginaVo vo) {

		Pessoa pessoa = null;

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
			pessoa = pessoaDao.find(vo.getIdPessoa());
			pagina.setPessoa(pessoa);
		}

		return pagina;
	}

	public List<CategoriaVo> findCategoriasByTipo(Long idTipo) {
		// TODO Auto-generated method stub

		List<CategoriaVo> lista = new ArrayList<CategoriaVo>();

		List<CategoriaPagina> categs = categoriaDao.findByTipo(idTipo);

		for (CategoriaPagina categ : categs) {

			CategoriaVo vo = new CategoriaVo();
			vo.setDescricao(categ.getDescricao());
			vo.setId(categ.getId());

			lista.add(vo);
		}

		return lista;
	}

	public List<PaginaVo> findPaginasPessoais(Long idPessoa) {
		// TODO Auto-generated method stub
		List<Pagina> pages = paginaDao.findPaginasPessoais(idPessoa);

		return listaVoFromPaginas(pages);
	}

	public List<PaginaVo> findPaginasOficiais() {

		List<PaginaVo> lista = new ArrayList<PaginaVo>();

		List<Pagina> pages = paginaDao.findPaginasOficiais();

		for (Pagina pag : pages) {
			PaginaVo vo = copyEntityToVo(pag);

			lista.add(vo);
		}

		return lista;
	}

	public PaginaVo findVoBySlug(String slug) {

		Pagina pagina = findBySlug(slug);

		PaginaVo vo = new PaginaVo();

		if (pagina != null) {
			vo = copyEntityToVo(pagina);
		}

		return vo;
	}

	public PaginaVo findById(Long id) {

		Pagina pagina = paginaDao.find(id);

		return copyEntityToVo(pagina);

	}

	public List<PaginaVo> findPaginasPublicadasVo() {

		List<PaginaVo> lista = new ArrayList<PaginaVo>();

		List<Pagina> pages = paginaDao.findPaginasPublicadas();

		for (Pagina pag : pages) {

			PaginaVo vo = copyEntityToVo(pag);

			lista.add(vo);
		}

		return lista;
	}

	public List<PaginaVo> gridPaginasAdmin() {

		List<PaginaVo> lista = new ArrayList<PaginaVo>();

		List<Pagina> pages = paginaDao.findAll();

		for (Pagina pag : pages) {

			PaginaVo vo = copyEntityToVo(pag);

			lista.add(vo);
		}

		return lista;
	}

	public List<PaginaVo> gridPaginasPessoais(Long idPessoa) {

		List<Pagina> pages = paginaDao.findPaginasPessoais(idPessoa);
		return listaVoFromPaginas(pages);
	}

	public List<PaginaVo> findPaginasPessoaisPublicadas(Long idPessoa) {
		// TODO Auto-generated method stub
		List<Pagina> pages = paginaDao.findPaginasPessoaisPublicadas(idPessoa);

		return listaVoFromPaginas(pages);
	}

	public List<PaginaVo> listaVoFromPaginas(List<Pagina> pages) {
		List<PaginaVo> paginasVo = new ArrayList<PaginaVo>();

		for (Pagina page : pages) {

			PaginaVo vo = new PaginaVo();
			vo.setIdPagina(page.getIdPagina());
			vo.setTitulo(page.getTitulo());
			vo.setSlug(page.getSlug());

			if (page.getIdCategoriaPagina() != null && page.getIdCategoriaPagina() > 0) {

				CategoriaPagina categoria = categoriaDao.find(page.getIdCategoriaPagina());

				if (categoria != null) {
					vo.setCategoria(categoria.getDescricao());
				}

			}

			if (page.getIdTipoPagina() != null && page.getIdTipoPagina() > 0) {

				TipoPagina tipo = tipoPaginaDao.find(page.getIdTipoPagina());
				if (tipo != null) {
					vo.setTipo(tipo.getDescricao());
				}

			}

			paginasVo.add(vo);

		}

		return paginasVo;
	}

	public Pessoa alterarStatusPublicacao(AlterarPublicacaoVo publicacao) {

		if (publicacao.getIdPagina() == null || publicacao.getIdPagina() == 0) {
			return null;
		}

		Pagina pagina = paginaDao.find(publicacao.getIdPagina());
		pagina.setFlagPublicado(publicacao.getFlag());
		paginaDao.update(pagina);

		Pessoa pessoa = pessoaDao.findAutorPagina(publicacao.getIdPagina());

		return pessoa;
	}

	public List<PaginaVo> listaTodas() {

		List<PaginaVo> paginasVo = new ArrayList<PaginaVo>();

		List<Pagina> paginas = paginaDao.listarPaginasOrdenadasPorNome();

		for (Pagina pagina : paginas) {
			PaginaVo paginaVo = new PaginaVo();
			paginaVo = copyEntityToVo(pagina);
			paginasVo.add(paginaVo);
		}

		return paginasVo;
	}

	@Override
	public List<PaginaVo> buscarPaginasPorDataRegiao(Long idRegiao, Date dataInicial, Date dataFinal) {

		List<PaginaVo> listaPaginasVO = new ArrayList<PaginaVo>();
		List<Pagina> listaPaginas = paginaDao.findAll();

		for (Pagina pagina : listaPaginas) {
			PaginaVo paginaVO = new PaginaVo();
			paginaVO = copyEntityToVo(pagina);
			listaPaginasVO.add(paginaVO);
		}
		return listaPaginasVO;
	}

}
