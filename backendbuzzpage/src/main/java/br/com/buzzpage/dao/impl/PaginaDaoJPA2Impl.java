package br.com.buzzpage.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.buzzpage.dao.PaginaDao;
import br.com.buzzpage.entity.Pagina;

public class PaginaDaoJPA2Impl extends GenericDaoImpl<Pagina> implements PaginaDao {

	private static final String QUERY_PAGINA_DO_TEXTO = "select  t.pagina from Texto t where t.idTexto = :idTexto";
	private static final String QUERY_PAGINA_POR_SLUG = "FROM Pagina p where p.slug = :slug and p.flagPublicado=true";
	private static final String QUERY_PAGINAS_PESSOAIS_PUBLICADAS = "FROM Pagina p where p.pessoa.idPessoa = :idPessoa and p.flagPublicado=true";
	private static final String QUERY_PAGINAS_OFICIAIS_PUBLICADAS = "FROM Pagina p where (p.pessoa.idPessoa is null or  p.pessoa.idPessoa=0) and p.flagPublicado=true";

	private static final String QUERY_PAGINAS_PESSOAIS = "FROM Pagina p where p.pessoa.idPessoa = :idPessoa";
	private static final String QUERY_PAGINAS_OFICIAIS = "FROM Pagina p where p.pessoa.idPessoa is null or  p.pessoa.idPessoa=0";

	private static final String QUERY_ALL_PAGINAS = "FROM Pagina p order by titulo";
	
	private static final String QUERY_PAGINAS_POR_REGIAO_E_DATA = "Select r FROM Regiao r inner join Anuncio";
	 

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	public List<Pagina> getPaginas() {

		Pagina pagina = null;
		Query query = this.entityManager.createQuery("FROM Pagina p order by p.titulo");

		List<Pagina> result = query.getResultList();

		return result;
	}

	public Pagina findByTexto(Long idTexto) {

		Pagina pagina = null;
		Query query = this.entityManager.createQuery(QUERY_PAGINA_DO_TEXTO); // "select
																				// t.pagina
																				// from
																				// Texto
																				// t
																				// where
																				// t.idTexto
																				// =
																				// :idTexto";
		query.setParameter("idTexto", idTexto);

		List<Pagina> result = query.getResultList();

		if (result != null && result.size() > 0) {
			pagina = result.get(0);
		}

		return pagina;
	}

	public Pagina findBySlug(String slug) {
		Pagina pagina = null;
		Query query = this.entityManager.createQuery(QUERY_PAGINA_POR_SLUG); // "select
																				// t.pagina
																				// from
																				// Texto
																				// t
																				// where
																				// t.idTexto
																				// =
																				// :idTexto";
		query.setParameter("slug", slug);

		List<Pagina> result = query.getResultList();

		if (result != null && result.size() > 0) {
			pagina = result.get(0);
		}

		return pagina;
	}

	public List<Pagina> findPaginasPublicadas() {
		Query query = this.entityManager.createQuery(QUERY_PAGINAS_OFICIAIS); // "select
																				// t.pagina
																				// from
																				// Texto
																				// t
																				// where
																				// t.idTexto
																				// =
																				// :idTexto";

		List<Pagina> result = query.getResultList();

		return result;
	}

	// PÁGINAS ONDE idPessoa=0 ou null e flagPublicada = true
	public List<Pagina> findPaginasOficiais() {
		// TODO Auto-generated method stub

		Query query = this.entityManager.createQuery(QUERY_PAGINAS_OFICIAIS_PUBLICADAS); // "select
																							// t.pagina
																							// from
																							// Texto
																							// t
																							// where
																							// t.idTexto
																							// =
																							// :idTexto";

		List<Pagina> result = query.getResultList();

		return result;

	}

	public List<Pagina> findPaginasPessoaisPublicadas(Long idPessoa) {
		Query query = this.entityManager.createQuery(QUERY_PAGINAS_PESSOAIS_PUBLICADAS); // "select
																							// t.pagina
																							// from
																							// Texto
																							// t
																							// where
																							// t.idTexto
																							// =
																							// :idTexto";
		query.setParameter("idPessoa", idPessoa);

		List<Pagina> result = query.getResultList();

		return result;
	}

	public List<Pagina> findPaginasPessoais(Long idPessoa) {
		// TODO Auto-generated method stub idPessoa

		Query query = this.entityManager.createQuery(QUERY_PAGINAS_PESSOAIS); // "select
																				// t.pagina
																				// from
																				// Texto
																				// t
																				// where
																				// t.idTexto
																				// =
																				// :idTexto";
		query.setParameter("idPessoa", idPessoa);

		List<Pagina> result = query.getResultList();

		return result;

	}

	public List<Pagina> listarPaginasOrdenadasPorNome() {

		Query query = this.entityManager.createQuery(QUERY_ALL_PAGINAS); // "select
																			// t.pagina
																			// from
																			// Texto
																			// t
																			// where
																			// t.idTexto
																			// =
																			// :idTexto";

		List<Pagina> result = query.getResultList();

		return result;
	}

	@Override
	public List<Pagina> buscarPaginasPorDataRegiao(Long idRegiao, Date dataInicial, Date dataFinal) {
		Query query = this.entityManager.createQuery(QUERY_PAGINAS_POR_REGIAO_E_DATA);
		List<Pagina> result = query.getResultList();
		return result;
	}

}
