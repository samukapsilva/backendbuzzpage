package br.com.buzzpage.dao;

import java.util.Date;
import java.util.List;

import br.com.buzzpage.entity.Anuncio;
import br.com.buzzpage.entity.Pagina;

public interface AnuncioDAO {

	Anuncio salvarAnuncio(Anuncio anuncio);

	void delete(Anuncio anuncio);

	public Anuncio buscarAnuncioAnunciante(Long idAnunciante, Long idAnuncio);
	
	public List<Anuncio> buscarAnunciosAnunciante(Long idAnunciante);

	Anuncio update(Anuncio anuncio);

	Anuncio find(Object id);

	List<Pagina> buscarPaginasPorRegiaoEPeriodo(Long idRegiao, Date dataInicio, Date dataFinal);

}