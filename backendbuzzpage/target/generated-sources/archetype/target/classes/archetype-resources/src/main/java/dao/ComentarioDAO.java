#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.util.List;

import ${package}.entity.Comentario;

/**
 * Interface com os servicos de comentario.
 * 
 * @author Samuel.Pereira
 * @see
 */
public interface ComentarioDAO {

	Comentario salvarComentario(Comentario Comentario);

	void delete(Comentario comentario);

	List<Comentario> buscarComentariosColaborador(Long idColaborador, Long idConteudo);

	Comentario buscarComentarioColaborador(Long idComentario, Long idPessoa);

	Comentario update(Comentario comentario);

	Comentario find(Object id);
}
