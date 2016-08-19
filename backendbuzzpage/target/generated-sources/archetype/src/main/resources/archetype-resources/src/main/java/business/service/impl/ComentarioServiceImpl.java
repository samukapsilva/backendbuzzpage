#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ${package}.business.service.ComentarioService;
import ${package}.dao.AvaliacaoDao;
import ${package}.dao.ComentarioDAO;
import ${package}.dao.PaginaDao;
import ${package}.dao.PessoaDao;
import ${package}.entity.Comentario;
import ${package}.rest.serviceutil.Constants;
import ${package}.util.StringUtil;
import ${package}.vo.ComentarioVO;

public class ComentarioServiceImpl implements ComentarioService {

	@Autowired
	ComentarioDAO comentarioDao;

	@Autowired
	PaginaDao paginaDao;

	@Autowired
	PessoaDao pessoaDao;

	@Autowired
	AvaliacaoDao avaliacaoDao;

	/**
	 * Metodo responsavel por gravar um comentario.
	 * 
	 * @param comentarioVO
	 * @return comentario
	 */
	public ComentarioVO salvarComentario(ComentarioVO comentarioVO) {
		Comentario comentario = new Comentario();
		if (comentarioVO.getIdComentario() != null && comentarioVO.getIdComentario() > 0) {
			comentario = comentarioDao.find(comentarioVO.getIdComentario());
		}

		comentario = convertVoToEntity(comentarioVO, comentario);

		if (comentarioVO.getIdComentario() != null && comentarioVO.getIdComentario() > 0) {
			comentario = comentarioDao.update(comentario);
		} else {
			comentario = comentarioDao.salvarComentario(comentario);
		}
		return converterEntityToVo(comentario);
	}

	/**
	 * Metodo responsavel por transformar um objeto VO em Entity.
	 * 
	 * @param comentarioVO
	 * @param comentario
	 * @return comentario
	 */
	public Comentario convertVoToEntity(ComentarioVO comentarioVO, Comentario comentario) {
		comentario.setIdComentario(comentarioVO.getIdComentario());
		comentario.setTextoComentario(comentarioVO.getTextoComentario());
		comentario.setDataComentario(new Date());

		return comentario;
	}

	/**
	 * Metodo responsavel por transformar um objeto Entity em VO.
	 * 
	 * @param comentario
	 * @return comentarioVO
	 */
	private ComentarioVO converterEntityToVo(Comentario comentario) {
		if (comentario == null || comentario.getIdComentario() == null) {
			return new ComentarioVO();
		}
		ComentarioVO comentarioVO = new ComentarioVO();
		if (comentario.getStatusComentario() != null) {
			comentarioVO.setStatusComentario(comentario.getStatusComentario());
		}
		comentarioVO.setIdComentario(comentario.getIdComentario());

		if (comentario.getTextoComentario() != null && comentario.getTextoComentario().length() > 1) {
			comentarioVO.setTextoComentario(StringUtil.retiraLixoWord(comentario.getTextoComentario()));
		}
		if (comentario.getDataComentario() != null) {
			comentarioVO.setDataComentario(
					StringUtil.dateToString(comentario.getDataComentario(), Constants.FORMATO_DATA_BR));
		}
		return comentarioVO;
	}

	/**
	 * Metodo responsavel por listar todos os comentarios.
	 * 
	 * @return List<ComentarioVO> lista.
	 */
	public List<ComentarioVO> buscarComentariosColaborador(Long idColaborador, Long idConteudo) {
		List<ComentarioVO> lista = new ArrayList<ComentarioVO>();
		List<Comentario> comentarios = comentarioDao.buscarComentariosColaborador(idColaborador, idConteudo);
		if (comentarios != null) {
			for (Comentario comentario : comentarios) {
				ComentarioVO cmtVO = converterEntityToVo(comentario);
				lista.add(cmtVO);
			}
		}
		return lista;
	}

	@Override
	/**
	 * Metodo responsavel por atualizar um comentario.
	 * 
	 * @param ComentarioVO
	 *            comentarioVO.
	 */
	public void atualizarComentario(ComentarioVO comentarioVO) {
		Comentario comentario = comentarioDao.buscarComentarioColaborador(comentarioVO.getIdComentario(),
				comentarioVO.getIdPessoa());
		comentario = convertVoToEntity(comentarioVO, comentario);
		comentario = comentarioDao.update(comentario);
	}

	/**
	 * Metodo responsavel por deletar um comentario.
	 * 
	 * @param idComentario
	 * @param idPessoa
	 * @return boolean
	 * @Override
	 */
	public boolean deletarComentario(Long idComentario, Long idPessoa) {
		Comentario comentario = comentarioDao.buscarComentarioColaborador(idComentario, idPessoa);
		if (comentario == null) {
			return Boolean.FALSE;
		}
		comentarioDao.delete(comentario);
		return Boolean.TRUE;
	}

	@Override
	public ComentarioVO buscarComentarioColaborador(Long idComentario, Long idColaborador) {
		ComentarioVO comentarioVO = new ComentarioVO();
		Comentario comentario = comentarioDao.buscarComentarioColaborador(idComentario, idColaborador);
		if (comentario != null) {
			comentarioVO = converterEntityToVo(comentario);
		}
		return comentarioVO;
	}

}
