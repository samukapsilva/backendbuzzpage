package br.com.buzzpage.business.service;

import java.util.List;

import br.com.buzzpage.vo.ComentarioVO;

public interface ComentarioService {

	ComentarioVO salvarComentario(ComentarioVO comentarioVO);

	void atualizarComentario(ComentarioVO comentarioVO);

	boolean deletarComentario(Long idComentario, Long idPessoa);

	List<ComentarioVO> buscarComentariosColaborador(Long idColaborador, Long idConteudo);

	ComentarioVO buscarComentarioColaborador(Long idComentario, Long idColaborador);

}