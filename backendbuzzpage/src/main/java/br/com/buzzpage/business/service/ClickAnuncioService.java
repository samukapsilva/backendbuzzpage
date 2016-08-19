package br.com.buzzpage.business.service;

import br.com.buzzpage.vo.ClickAnuncioVO;

public interface ClickAnuncioService {

	public ClickAnuncioVO salvarClickAnuncio(ClickAnuncioVO clickAnuncioVO);

	void delete(ClickAnuncioVO id);

	ClickAnuncioVO update(ClickAnuncioVO t);

	public Long buscarClicksAnuncio(Long idAnuncio);
}
