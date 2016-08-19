package br.com.buzzpage.business.service;

import br.com.buzzpage.vo.CurtidaVO;

/**
 * Interface de servicos para a funcionalidade curtida
 * 
 * @author Samuel.Pereira
 */
public interface CurtidaService {

	CurtidaVO salvarCurtida(CurtidaVO curtidaVO);

	void atualizarStatusCurtida(CurtidaVO curtidaVO);
}