#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import java.util.List;

import ${package}.vo.RegiaoVO;

public interface RegiaoService {

	public List<RegiaoVO> buscarRegioes();

}