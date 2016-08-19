#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import ${package}.vo.CurtidaVO;

/**
 * Interface de servicos para a funcionalidade curtida
 * 
 * @author Samuel.Pereira
 */
public interface CurtidaService {

	CurtidaVO salvarCurtida(CurtidaVO curtidaVO);

	void atualizarStatusCurtida(CurtidaVO curtidaVO);
}