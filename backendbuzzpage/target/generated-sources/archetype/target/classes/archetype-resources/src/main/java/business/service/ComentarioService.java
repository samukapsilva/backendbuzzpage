#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import java.util.List;

import ${package}.vo.ComentarioVO;

public interface ComentarioService {

	ComentarioVO salvarComentario(ComentarioVO comentarioVO);

	void atualizarComentario(ComentarioVO comentarioVO);

	boolean deletarComentario(Long idComentario, Long idPessoa);

	List<ComentarioVO> buscarComentariosColaborador(Long idColaborador, Long idConteudo);

	ComentarioVO buscarComentarioColaborador(Long idComentario, Long idColaborador);

}