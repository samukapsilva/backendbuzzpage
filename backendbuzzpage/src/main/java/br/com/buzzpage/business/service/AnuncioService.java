package br.com.buzzpage.business.service;

import java.util.List;

import br.com.buzzpage.vo.AnuncioVO;
import br.com.buzzpage.vo.DadosGrid;

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
