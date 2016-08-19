#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import ${package}.business.service.ConteudoColaboradorService;
import ${package}.dao.AvaliacaoDao;
import ${package}.dao.ConteudoColaboradorDao;
import ${package}.dao.PaginaDao;
import ${package}.dao.PessoaDao;
import ${package}.entity.Pagina;
import ${package}.entity.Pessoa;
import ${package}.entity.Texto;
import ${package}.rest.serviceutil.Constants;
import ${package}.util.StringUtil;
import ${package}.vo.AlterarPublicacaoVo;
import ${package}.vo.DadosGrid;
import ${package}.vo.DestaquesPaginaVo;
import ${package}.vo.GridRevisaoVo;
import ${package}.vo.GridTextosVo;
import ${package}.vo.ResultadoPesquisaPaginasVO;
import ${package}.vo.TextoVo;

public class ConteudoColaboradorServiceImpl implements
		ConteudoColaboradorService {

	private static final String HTTP_WWW_BUZZPAGE_COM_BR_USER_IMAGES = "http://www.buzzpage.com.br/user_images/";

	private static final String PATH_USER_IMAGE = "user_images/";

	private static final String PUBLICADO = "publicado";

	private static final String FORMATO_YYYY_MM_DD = "yyyy/MM/dd/";

	private static final String DESTAQUE_DEFAULT_JPG = "destaque_default.jpg";

	private static final String AVATAR_FEM = "no_prof_fem.gif";

	private static final String AVATAR_MASCULINO = "no_prof_masc.gif";

	private static final String NAO_PUBLICADO = "n�o publicado";

	@Autowired
	ConteudoColaboradorDao conteudoDao;

	@Autowired
	PaginaDao paginaDao;

	@Autowired
	PessoaDao pessoaDao;

	@Autowired
	AvaliacaoDao avaliacaoDao;

	public Texto salvarConteudo(TextoVo textoVo) {

		Texto texto = new Texto();

		if (textoVo.getIdTexto() != null && textoVo.getIdTexto() > 0) {
			texto = conteudoDao.find(textoVo.getIdTexto());
		}

		texto = convertVoToEntity(textoVo, texto);

		if (textoVo.getIdTexto() != null && textoVo.getIdTexto() > 0) {
			texto = conteudoDao.update(texto);
		} else {
			texto.setFlagPublicado(true);
			texto = conteudoDao.salvarConteudo(texto);
		}

		return texto;
	}

	private List<Texto> getTextosRevisor(Long idColaborador) {
		// TODO Auto-generated method stub
		return conteudoDao.findTextosRevisor(idColaborador);
	}

	public List<Texto> getTextosColaborador(Long idColaborador) {
		// TODO Auto-generated method stub
		return conteudoDao.findTextosColaborador(idColaborador);
	}

	public Texto getConteudoById(Long id) {
		return conteudoDao.find(id);
	}

	public void updateConteudo(TextoVo podcast) {
		// TODO Auto-generated method stub

	}

	public boolean deletarConteudoColaboradorPorId(Long idTexto, Long idPessoa) {
		// TODO Auto-generated method stub

		Texto texto = conteudoDao.findTextoPessoa(idTexto, idPessoa);

		if (texto == null) {
			return false;
		}

		conteudoDao.delete(texto.getIdTexto());

		return true;
	}

	public List<Texto> findAll() {
		// TODO Auto-generated method stub
		return conteudoDao.findAll();
	}

	public List<TextoVo> listarTextosColaborador(Long idColaborador) {
		//
		List<TextoVo> lista = new ArrayList<TextoVo>();

		List<Texto> textos = getTextosColaborador(idColaborador);

		if (textos != null) {
			for (Texto texto : textos) {

				TextoVo txtVo = converterEntityToVo(texto, false);
				lista.add(txtVo);

			}
		}

		return lista;
	}

	public DadosGrid montarGridRevisor(Long idColaborador) {

		List<Texto> textos = getTextosRevisor(idColaborador);
		return populaGrid(textos);
	}

	public DadosGrid populaGrid(List<Texto> textos) {
		DadosGrid dados = new DadosGrid();

	
		List<TextoVo> lista = new ArrayList<TextoVo>();

		if (textos != null) {
			for (Texto texto : textos) {

				TextoVo txtVo = converterEntityToVo(texto, true);
				lista.add(txtVo);

			}
		}

		GridRevisaoVo[] data = new GridRevisaoVo[lista.size()];

		int i = 0;

		for (TextoVo txtVo : lista) {
			GridRevisaoVo grid = new GridRevisaoVo();
			grid.setTitulo(txtVo.getTitulo());
			grid.setPagina(txtVo.getTituloPagina());
			grid.setIdAutor(txtVo.getIdRedatorPrincipal());
			grid.setAutor(txtVo.getNomeRedator());
			grid.setSlug(txtVo.getSlug());

			if (txtVo.getFlagPublicado() != null && txtVo.getFlagPublicado()) {
				grid.setFlagPublicado(1);
				grid.setStatus(PUBLICADO);
			} else {
				grid.setFlagPublicado(0);
				grid.setStatus(NAO_PUBLICADO);
			}

			grid.setId(txtVo.getIdTexto());

			data[i] = grid;

			i++;
		}

		dados.setData(data);
		dados.setDraw(1);
		dados.setRecordsFiltered(lista.size());
		dados.setRecordsTotal(lista.size());

		return dados;
	}

	public DadosGrid montarGridConteudos(Long idColaborador) {
		//

		DadosGrid dados = new DadosGrid();

		List<TextoVo> lista = new ArrayList<TextoVo>();

		List<Texto> textos = getTextosColaborador(idColaborador);

		if (textos != null) {
			for (Texto texto : textos) {

				TextoVo txtVo = converterEntityToVo(texto, false);
				lista.add(txtVo);

			}
		}

		GridTextosVo[] data = new GridTextosVo[lista.size()];

		int i = 0;

		for (TextoVo txtVo : lista) {
			GridTextosVo grid = new GridTextosVo();
			grid.setTitulo(txtVo.getTitulo());
			grid.setPagina(txtVo.getTituloPagina());
			grid.setStatus(PUBLICADO);
			grid.setId(txtVo.getIdTexto());
			grid.setSlug(txtVo.getSlug());

			data[i] = grid;

			i++;
		}

		dados.setData(data);
		dados.setDraw(1);
		dados.setRecordsFiltered(lista.size());
		dados.setRecordsTotal(lista.size());

		return dados;
	}

	public Texto convertVoToEntity(TextoVo textoVo, Texto texto) {

		texto.setStatusLiberadoPublicar(textoVo.getStatusLiberadoPublicar());
		texto.setStatusPublicacao(textoVo.getStatusLiberadoPublicar());

		Pagina pagina = paginaDao.find(textoVo.getIdPagina());
		texto.setPagina(pagina);

		if (textoVo.getIdRedatorPrincipal() != null
				&& textoVo.getIdRedatorPrincipal() > 0) {
			Pessoa pessoa = pessoaDao.find(textoVo.getIdRedatorPrincipal());
			texto.setPessoa(pessoa);
		}

		texto.setPalavraChave(textoVo.getPalavra());
		texto.setSinonimos(textoVo.getSinonimos());
		texto.setTitulo(textoVo.getTitulo());
		texto.setResumo(textoVo.getResumo());
		texto.setTexto(textoVo.getTexto());
		texto.setDataCadastro(new Date());

		if (textoVo.getSlug() != null && textoVo.getSlug().length() > 3) {
			texto.setSlug(textoVo.getSlug());
		} else {
			texto.setSlug(StringUtil.criarSlug(texto.getTitulo()));
		}

		if (textoVo.getFlagPublicado() != null) {
			texto.setFlagPublicado(textoVo.getFlagPublicado());
		}

		if (textoVo.getFotoDestaque() != null
				&& textoVo.getFotoDestaque().length() > 5) {

		
			// StringBuilder sb = new
			// StringBuilder(StringUtil.dateToString(data,FORMATO_YYYY_MM_DD));
			StringBuilder sb = new StringBuilder();
			sb.append(textoVo.getFotoDestaque());

			texto.setFotoDestaque(sb.toString());
		}

		return texto;

	}

	private TextoVo converterEntityToVo(Texto texto, boolean loadNomeAutor) {

		if (texto == null || texto.getIdTexto() == null) {
			return new TextoVo();
		}

		TextoVo textoVo = new TextoVo();

		textoVo.setSlug(texto.getSlug());

		if (texto.getFlagPublicado() != null) {
			textoVo.setFlagPublicado(texto.getFlagPublicado());
		}

		textoVo.setStatusLiberadoPublicar(texto.getStatusLiberadoPublicar());
		Short statusPublicacao = 0;
		textoVo.setStatusPublicacao(statusPublicacao);

		Pagina pagina = paginaDao.findByTexto(texto.getIdTexto());

		if (loadNomeAutor) {

			Pessoa autor = pessoaDao.findByTexto(texto.getIdTexto());
			if (autor != null) {
				textoVo.setIdRedatorPrincipal(autor.getIdPessoa());
				textoVo.setNomeRedator(autor.getNome());
				textoVo.setIdRedatorPrincipal(autor.getIdPessoa());
				textoVo.setResumoRedator(autor.getSobreMim());
				textoVo.setUsuario(autor.getUsuario());

				if (autor.getFotoPerfil() != null) {
					textoVo.setFotoRedator(autor.getFotoPerfil());
				} else {

					if (autor.getIdSexo().longValue() == Constants.ID_MASCULINO) {
						textoVo.setFotoRedator(AVATAR_MASCULINO);
					} else {
						textoVo.setFotoRedator(AVATAR_FEM);
					}
				}

			}
		}

		if (pagina != null) {
			textoVo.setIdPagina(pagina.getIdPagina());
			textoVo.setTituloPagina(pagina.getTitulo());
			textoVo.setSlugPagina(pagina.getSlug());
		}

		textoVo.setIdTexto(texto.getIdTexto());

		textoVo.setPalavra(texto.getPalavraChave());
		textoVo.setSinonimos(texto.getSinonimos());
		textoVo.setTitulo(texto.getTitulo());
		textoVo.setResumo(StringUtil.getResumoPost(texto, 260).trim());

		if (texto.getTexto() != null && texto.getTexto().length() > 1) {
			String retiraLixoWord = StringUtil.retiraLixoWord(texto.getTexto());
			String textoPathCorreto = StringUtils.replace(retiraLixoWord,
					PATH_USER_IMAGE, HTTP_WWW_BUZZPAGE_COM_BR_USER_IMAGES);
			textoVo.setTexto(textoPathCorreto);
		}

		if (texto.getFotoDestaque() != null) {
			textoVo.setFotoDestaque(texto.getFotoDestaque());
		}

		if (texto.getDataCadastro() != null) {
			textoVo.setDataPost(StringUtil.dateToString(
					texto.getDataCadastro(), Constants.FORMATO_DATA_BR));
		}

		if (pagina != null) {
			textoVo.setTituloPagina(pagina.getTitulo());
		}

		return textoVo;
	}

	private TextoVo converterConteudoPalavraChaveToVo(Texto texto) {

		if (texto == null || texto.getIdTexto() == null) {
			return new TextoVo();
		}

		TextoVo textoVo = new TextoVo();

		textoVo.setSlug(texto.getSlug());
		textoVo.setResumo(texto.getResumo());
		textoVo.setTitulo(texto.getTitulo());
		textoVo.setTexto(texto.getTexto());
		textoVo.setIdTexto(texto.getIdTexto());
		textoVo.setFotoDestaque(texto.getFotoDestaque());

		return textoVo;
	}

	public static void main(String[] args) {

	}

	public TextoVo getConteudoVoById(Long id) {
		return converterEntityToVo(getConteudoById(id), false);
	}

	public List<TextoVo> listarTextos() {
		List<TextoVo> lista = new ArrayList<TextoVo>();

		List<Texto> textos = findAll();

		if (textos != null) {
			for (Texto texto : textos) {

				TextoVo txtVo = converterEntityToVo(texto, false);
				lista.add(txtVo);

			}
		}

		return lista;
	}

	public DestaquesPaginaVo findDestaquePagina(String slug) {

		TextoVo txt = new TextoVo();
		List<TextoVo> blogs = new ArrayList<TextoVo>();

		DestaquesPaginaVo destaque = new DestaquesPaginaVo();

		Pagina pagina = paginaDao.findBySlug(slug);

		// Long idUltimoDestaque = 0L;

		if (pagina != null) {

			destaque.setKeyword(pagina.getPalavraChave());
			destaque.setMetaDescription(pagina.getResumo());
			destaque.setTituloPagina(pagina.getTitulo());

			List<Texto> postsPagina = conteudoDao.findListaPostsPagina(pagina
					.getIdPagina());

			if (postsPagina == null || postsPagina.size() == 0) {

				destaque.setDestaquePrincipal(txt);
				destaque.setDestaquesBlog(blogs);

				return destaque;
			}

			if (postsPagina != null && postsPagina.size() > 0) {

				POSTS: for (Texto post : postsPagina) {

					TextoVo txtVo = converterEntityToVo(post, true);

					if (txtVo.getResumo() == null
							|| txtVo.getResumo().length() < 5) {
						continue POSTS;
					}

					blogs.add(txtVo);

				}

				// List<Long> chavesDestaques = new ArrayList<Long>();

				/*
				 * for(Texto t:postsPagina){
				 * 
				 * 
				 * if(t.getFotoDestaque()!=null &&
				 * t.getFotoDestaque().length()>4){
				 * //chavesDestaques.add(t.getIdTexto()); }
				 * 
				 * }
				 */

				/*
				 * if(chavesDestaques.size()>1){ Collections.shuffle (
				 * chavesDestaques ) ; }
				 */

				// idUltimoDestaque = chavesDestaques.get(0);

			}

			destaque.setDestaquePrincipal(new TextoVo());
			destaque.setDestaquesBlog(blogs);

		}

		return destaque;

	}

	public TextoVo findPostBySlug(String slug) {

		Texto texto = conteudoDao.findBySlug(slug);

		return converterEntityToVo(texto, true);
	}

	public Boolean setSlug() {

		List<Texto> textos = conteudoDao.findAll();

		for (Texto texto : textos) {

			if (texto.getTitulo() != null && texto.getTitulo().length() > 0) {
				texto.setSlug(StringUtil.criarSlug(texto.getTitulo()));
				conteudoDao.update(texto);
			}

		}

		List<Pagina> paginas = paginaDao.findAll();

		for (Pagina pagina : paginas) {

			if (pagina.getTitulo() != null && pagina.getTitulo().length() > 0) {
				pagina.setSlug(StringUtil.criarSlug(pagina.getTitulo()));
				paginaDao.update(pagina);
			}

		}

		return true;
	}

	public Pessoa alterarStatusPublicacao(AlterarPublicacaoVo publicacao) {
		Texto texto = conteudoDao.find(publicacao.getIdTexto());
		texto.setFlagPublicado(publicacao.getFlag());
		conteudoDao.update(texto);

		return pessoaDao.findByTexto(texto.getIdTexto());
	}

	public Texto findById(Long idTexto) {
		return conteudoDao.find(idTexto);
	}

	public DadosGrid montarGridAdmin() {
		List<Texto> textos = conteudoDao.findAll();
		return populaGrid(textos);
	}

	@Override
	public List<TextoVo> findTextoPorPalavraChave(String palavraChave,
			Integer qtdeRegistros, Integer offSet) {

		List<Texto> textos = conteudoDao.findTextoPorPalavraChave(palavraChave,
				qtdeRegistros, offSet);
		List<TextoVo> textosVo = new ArrayList<TextoVo>();

		for (Texto texto : textos) {
			TextoVo txtVo = new TextoVo();
			txtVo = converterEntityToVo(texto, true);
			textosVo.add(txtVo);
		}

		return textosVo;
	}

	@Override
	/**
	 * Metodo responsavel por retornar os ultimos posts de acordo com o
	 * parametro passado.
	 * 
	 * @param Long
	 *            pageSize
	 * @return List<TextoVo>
	 */
	public List<TextoVo> buscaUltimosPosts(Integer maxResults, Integer offSet) {
		List<TextoVo> listaUltimosPostsVO = new ArrayList<TextoVo>();
		List<Texto> listaUltimosPosts = conteudoDao.buscaUltimosPosts(
				maxResults, offSet);
		for (Texto post : listaUltimosPosts) {
			TextoVo txt = new TextoVo();
			txt = converterEntityToVo(post, true);
			listaUltimosPostsVO.add(txt);
		}
		return listaUltimosPostsVO;
	}

	/**
	 * Metodo responsavel por retornar os ultimos posts de acordo.
	 * 
	 * @param Long pageSize
	 * @return List<PessoaVo>
	 */	
	@Override
	public ResultadoPesquisaPaginasVO paginasPostsAutoresPorPalavraChave(String palavraChave) {
		
		return null;
	}

	@Override
	public ResultadoPesquisaPaginasVO findTextoPorIdPagina(Long idPagina, Integer qtdeRegistros, Integer offSet) {
		ResultadoPesquisaPaginasVO resultado = new ResultadoPesquisaPaginasVO();
		List<TextoVo> textosRetorno = new ArrayList<TextoVo>();
		
		List<Texto> textosPagina = conteudoDao.findTextoPorIdPagina(idPagina, qtdeRegistros, offSet);
			for(Texto t : textosPagina){
				TextoVo vo = new TextoVo();
				vo = converterConteudoPalavraChaveToVo(t);
				textosRetorno.add(vo);
			}
		
			resultado.setPosts(textosRetorno);
		return resultado;
	}
}
