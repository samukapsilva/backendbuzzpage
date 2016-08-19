package br.com.buzzpage.dao;

import java.util.List;

import br.com.buzzpage.entity.Comentario;

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
