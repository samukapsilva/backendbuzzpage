#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ${package}.dao.AnuncioDAO;
import ${package}.entity.Anuncio;
import ${package}.entity.Pagina;

/**
 * Classe responsavel por implementar o DAO AnuncioDAO.
 * 
 * @author Samuel.Pereira
 */
public class AnuncioDaoJPA2Impl extends GenericDaoImpl<Anuncio> implements AnuncioDAO {

	private static final String QUERY_ANUNCIO_POR_ID_E_COLABORADOR = "FROM Anuncio a where a.idAnunciante = :idAnunciante and t.idAnuncio = :idAnuncio";
	private static final String QUERY_PAGINAS_DO_ANUNCIO_POR_REGIAO_E_PERIODO = "SELECT a.paginas FROM Anuncio a inner join a.regioes regiao where regiao.idRegiao = :idRegiao and a.dataInicio <= :dataInicio and a.dataFinal >= :dataFinal";
	private static final String QUERY_ANUNCIOS_ANUNCIANTE = "From Anuncio a where a.anunciante.idAnunciante = :idAnunciante";

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	/**
	 * Metodo responsavel por localizar um Anuncio.
	 * 
	 * @param idColaborador
	 * @return anuncio
	 */
	public Anuncio buscarAnuncioAnunciante(Long idAnunciante, Long idAnuncio) {
		Query query = this.entityManager.createQuery(QUERY_ANUNCIO_POR_ID_E_COLABORADOR);
		query.setParameter("idAnunciante", idAnunciante);
		query.setParameter("idAnuncio", idAnuncio);
		return (Anuncio) query.getResultList().get(0);
	}
	
	/**
	 * Metodo responsavel por localizar um Anuncio.
	 * 
	 * @param idColaborador
	 * @return anuncio
	 */
	public List<Anuncio> buscarAnunciosAnunciante(Long idAnunciante) {
		Query query = this.entityManager.createQuery(QUERY_ANUNCIOS_ANUNCIANTE);
		query.setParameter("idAnunciante", idAnunciante);
		List<Anuncio> anuncios = query.getResultList();
		return anuncios;
	}
	

	@Override
	public List<Pagina> buscarPaginasPorRegiaoEPeriodo(Long idRegiao, Date dataInicio, Date dataFinal) {
		Query query = this.entityManager.createQuery(QUERY_PAGINAS_DO_ANUNCIO_POR_REGIAO_E_PERIODO);
		query.setParameter("idRegiao", idRegiao);
		query.setParameter("dataInicio", dataInicio);
		query.setParameter("dataFinal", dataFinal);
		List<Pagina> paginas = query.getResultList();
		return paginas;
	}

	@Override
	public Anuncio update(Anuncio anuncio) {
		return update(anuncio);
	}

	public Anuncio salvarAnuncio(Anuncio anuncio) {
		return create(anuncio);
	}

	@Override
	public void delete(Anuncio anuncio) {
		delete(anuncio);
	}

}