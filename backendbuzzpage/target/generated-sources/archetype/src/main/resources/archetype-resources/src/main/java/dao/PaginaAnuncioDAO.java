#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.util.List;

import ${package}.entity.PaginaAnuncio;

/**
 * Interface com os servicos de paginaAnuncio.
 * 
 * @author Samuel.Pereira
 * @see
 */
public interface PaginaAnuncioDAO {

	PaginaAnuncio create(PaginaAnuncio t);
	
	PaginaAnuncio find(Object id);
	
	List<PaginaAnuncio> buscarLocais(Long idAnuncio);
	
	List<PaginaAnuncio> findPaginasAnunciante(Long idAnunciante);
}
