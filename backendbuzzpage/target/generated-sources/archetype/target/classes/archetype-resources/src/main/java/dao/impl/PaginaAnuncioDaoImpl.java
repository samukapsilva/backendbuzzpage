#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ${package}.dao.PaginaAnuncioDAO;
import ${package}.entity.PaginaAnuncio;
import ${package}.entity.PedidoAnuncio;

public class PaginaAnuncioDaoImpl extends GenericDaoImpl<PaginaAnuncio> implements PaginaAnuncioDAO {

	private static final String QUERY_LOCAIS_ANUNCIO = "From PaginaAnuncio pa where pa.idAnunciante = :idAnunciante";
	private static final String QUERY_PAGINAS_ANUNCIANTE = "From PaginaAnuncio pa where pa.idAnunciante = :idAnunciante";

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	@Override
	public List<PaginaAnuncio> buscarLocais(Long idAnuncio) {
		Query query = this.entityManager.createQuery(QUERY_LOCAIS_ANUNCIO);
		query.setParameter("idAnuncio", idAnuncio);
		List<PaginaAnuncio> locais = query.getResultList();
		return locais;
	}
	
	@Override
	public List<PaginaAnuncio> findPaginasAnunciante(Long idAnunciante) {
		Query query = this.entityManager.createQuery(QUERY_PAGINAS_ANUNCIANTE);
		query.setParameter("idAnunciante", idAnunciante);
		List<PaginaAnuncio> paginasAnuncio = query.getResultList();
		return paginasAnuncio;
	}
	
}
