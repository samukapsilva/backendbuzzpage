package br.com.buzzpage.dao;

import java.util.List;

import br.com.buzzpage.entity.ClickAnuncio;

public interface ClickAnuncioDao {

	ClickAnuncio create(ClickAnuncio t);

	void delete(ClickAnuncio id);

	ClickAnuncio update(ClickAnuncio t);

	List<ClickAnuncio> findAll();

	public Long buscarClicksAnuncio(Long idAnuncio);
}
