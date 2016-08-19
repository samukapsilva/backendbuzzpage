#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import java.util.List;

import ${package}.vo.AnuncianteVO;
import ${package}.vo.AnuncioVO;
import ${package}.vo.LoginVo;

public interface AnuncianteService {

	AnuncianteVO salvarAnunciante(AnuncianteVO anuncianteVO);

	void deletarAnunciante(AnuncianteVO anunciante);

	List<AnuncianteVO> buscarAnunciantes(Long idPessoa);

	AnuncianteVO efetuarLogin(LoginVo loginVo);

	AnuncianteVO find(Long id);

	void atualizarAnunciante(Long idAnunciante);
}
