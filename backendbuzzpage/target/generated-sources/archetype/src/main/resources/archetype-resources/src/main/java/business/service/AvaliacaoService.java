#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import ${package}.entity.Avaliacao;
import ${package}.vo.AvaliacaoVo;

public interface AvaliacaoService {

	AvaliacaoVo getAvaliacaoVoById(Long id);

	AvaliacaoVo getUltimaPorConteudo(Long idConteudo);

	Avaliacao cadastrarAvaliacao(AvaliacaoVo avaliacaoVo);

}
