#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import ${package}.vo.ClickAnuncioVO;

public interface ClickAnuncioService {

	public ClickAnuncioVO salvarClickAnuncio(ClickAnuncioVO clickAnuncioVO);

	void delete(ClickAnuncioVO id);

	ClickAnuncioVO update(ClickAnuncioVO t);

	public Long buscarClicksAnuncio(Long idAnuncio);
}
