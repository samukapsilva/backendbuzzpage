#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.util.List;

import ${package}.entity.ClickAnuncio;

public interface ClickAnuncioDao {

	ClickAnuncio create(ClickAnuncio t);

	void delete(ClickAnuncio id);

	ClickAnuncio update(ClickAnuncio t);

	List<ClickAnuncio> findAll();

	public Long buscarClicksAnuncio(Long idAnuncio);
}
