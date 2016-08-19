#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import java.util.List;

import ${package}.vo.AnuncioVO;
import ${package}.vo.DadosGrid;

public interface AnuncioService {

	AnuncioVO salvarAnuncio(AnuncioVO anuncio);

	void delete(AnuncioVO anuncio);

	AnuncioVO buscarAnuncioAnunciante(Long idAnunciante, Long idAnuncio);
	
	public List<AnuncioVO> buscarAnunciosAnunciante(Long idAnunciante);

	AnuncioVO update(AnuncioVO anuncio);

	AnuncioVO find(AnuncioVO id);

	boolean deleteAnuncioDeAnunciante(Long idAnuncio, Long idAnunciante);

	DadosGrid montarGridAnuncios(Long idAnunciante);
}
