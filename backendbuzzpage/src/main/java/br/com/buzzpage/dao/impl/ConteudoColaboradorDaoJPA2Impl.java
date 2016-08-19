package br.com.buzzpage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.buzzpage.dao.ConteudoColaboradorDao;
import br.com.buzzpage.entity.Texto;
import br.com.buzzpage.vo.ResultadoPesquisaPaginasVO;

public class ConteudoColaboradorDaoJPA2Impl extends GenericDaoImpl<Texto>
		implements ConteudoColaboradorDao {

	private static final String QUERY_TEXTOS_COLABORADOR = "FROM Texto t where t.pessoa.idPessoa = :idColaborador";
	private static final String QUERY_TEXTOS_REVISOR = "FROM Texto t where t.revisor.idPessoa = :idColaborador";
	private static final String QUERY_TEXTO_POR_ID_E_COLABORADOR = "FROM Texto t where t.pessoa.idPessoa = :idColaborador and t.idTexto = :idTexto";
	private static final String QUERY_MENSAGEM = "select  m.textoVinculado from Mensagem m where m.id = :idMensagem";
	private static final String QUERY_POSTS_PAGINA = "FROM Texto t where t.pagina.idPagina = :idPagina order by t.idTexto desc";
	private static final String QUERY_TEXTO_BY_SLUG = "FROM Texto t where t.slug = :slug and flagPublicado=1";
	private static final String QUERY_OUTROS_DESTAQUES = "FROM Texto t where t.idTexto NOT IN ( :idDestaquePrincipal ) and t.pagina.idPagina = :idPagina";

	private static final String QUERY_POR_PALAVRA_CHAVE = "FROM Texto t where (t.titulo LIKE :titulo  or t.resumo LIKE :resumo or t.texto LIKE :texto) and  flagPublicado=1";

	private static final String QUERY_ULTIMOS_POSTS = "FROM Texto t where t.fotoDestaque is not NULL and t.fotoDestaque <> '' order by t.idTexto desc";
	
	private static final String QUERY_ULTIMOS_POSTS_ID_PAGINA = "FROM Texto t where t.pagina.idPagina = :idPagina and  t.fotoDestaque is not NULL and t.fotoDestaque <> '' order by t.idTexto desc";

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	public Texto salvarConteudo(Texto texto) {
		return create(texto);
	}

	public List<Texto> findTextosRevisor(Long idColaborador) {
		Query query = this.entityManager.createQuery(QUERY_TEXTOS_REVISOR);
		query.setParameter("idColaborador", idColaborador);

		List<Texto> result = query.getResultList();

		return result;
	}

	public List<Texto> findTextosColaborador(Long idColaborador) {

		Query query = this.entityManager.createQuery(QUERY_TEXTOS_COLABORADOR);
		query.setParameter("idColaborador", idColaborador);

		List<Texto> result = query.getResultList();

		return result;
	}

	public Texto findTextoPessoa(Long idTexto, Long idPessoa) {

		Texto texto = null;

		Query query = this.entityManager
				.createQuery(QUERY_TEXTO_POR_ID_E_COLABORADOR);
		query.setParameter("idColaborador", idPessoa);
		query.setParameter("idTexto", idTexto);

		List<Texto> result = query.getResultList();

		if (result != null && result.size() > 0) {
			texto = result.get(0);
		}

		return texto;
	}

	/*
	 * public Texto findByAvaliacao(Long idAvaliacao) {
	 * 
	 * 
	 * 
	 * Texto texto = null; Query query =
	 * this.entityManager.createQuery(QUERY_AVALIADOR); //
	 * query.setParameter("idAvaliacao", idAvaliacao);
	 * 
	 * List<Texto> result = query.getResultList();
	 * 
	 * if(result !=null && result.size()>0){ texto = result.get(0); }
	 * 
	 * return texto; }
	 */

	public Texto findByMensagem(Long id) {

		Texto texto = null;
		Query query = this.entityManager.createQuery(QUERY_MENSAGEM); //
		query.setParameter("idMensagem", id);

		List<Texto> result = query.getResultList();

		if (result != null && result.size() > 0) {
			texto = result.get(0);
		}

		return texto;
	}

	public Texto findUltimoConteudoPagina(Long idPagina) {

		Texto texto = null;
		Query query = this.entityManager.createQuery(QUERY_POSTS_PAGINA); //
		query.setParameter("idPagina", idPagina);
		query.setMaxResults(1);

		List<Texto> result = query.getResultList();

		if (result != null && result.size() > 0) {
			texto = result.get(0);
		}

		return texto;
	}

	public List<Texto> findListaPostsPagina(Long idPagina) {

		Texto texto = null;
		Query query = this.entityManager.createQuery(QUERY_POSTS_PAGINA); //
		query.setParameter("idPagina", idPagina);

		List<Texto> result = query.getResultList();

		return result;
	}

	public Texto findBySlug(String slug) {
		Texto texto = null;
		Query query = this.entityManager.createQuery(QUERY_TEXTO_BY_SLUG); //
		query.setParameter("slug", slug);

		List<Texto> result = query.getResultList();

		if (result != null && result.size() > 0) {
			texto = result.get(0);
		}

		return texto;
	}

	public List<Texto> findOutrosDestaques(Long idPagina,
			Long idDestaquePrincipal) {

		Query query = this.entityManager.createQuery(QUERY_OUTROS_DESTAQUES); //
		query.setParameter("idDestaquePrincipal", idDestaquePrincipal);
		query.setParameter("idPagina", idPagina);

		List<Texto> result = query.getResultList();

		return result;

	}

	@Override
	public List<Texto> findTextoPorPalavraChave(String palavraChave,
			Integer qtdeRegistros, Integer offSet) {

		Query query = this.entityManager.createQuery(QUERY_POR_PALAVRA_CHAVE); //
		query.setParameter("titulo", "%" + palavraChave + "%");
		query.setParameter("resumo", "%" + palavraChave + "%");
		query.setParameter("texto", "%" + palavraChave + "%");

		query.setFirstResult(offSet);
		query.setMaxResults(qtdeRegistros);

		List<Texto> result = query.getResultList();

		return result;
	}

	@Override
	/**
	 * Metodo responsavel por retornar os ultimos posts de acordo com o limite
	 * maximo de registros e limitador.
	 * 
	 * @param maxResults
	 * @param offSet
	 * @return List<Texto>
	 */
	public List<Texto> buscaUltimosPosts(Integer maxResults, Integer offSet) {
		Query query = this.entityManager.createQuery(QUERY_ULTIMOS_POSTS);
		query.setFirstResult(offSet);
		query.setMaxResults(maxResults);

		return query.getResultList();
	}

	/**
	 * Metodo responsavel por retornar os ultimos posts de acordo com o limite
	 * maximo de registros e limitador de acordo com o id da pagina passada.
	 * 
	 * @param maxResults
	 * @param offSet
	 * @return List<Texto>
	 */
	public List<Texto> findTextoPorIdPagina(Long idPagina, Integer maxResults, Integer offSet) {
		Query query = this.entityManager.createQuery(QUERY_ULTIMOS_POSTS_ID_PAGINA);
		query.setParameter("idPagina", idPagina);
		query.setFirstResult(offSet);
		query.setMaxResults(maxResults);

		return query.getResultList();
	}
	@Override
	public ResultadoPesquisaPaginasVO paginasPostsAutoresPorPalavraChave(String palavraChave) {
		return null;
	}

}
