package br.com.buzzpage.business.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.buzzpage.business.service.ComentarioService;
import br.com.buzzpage.dao.AvaliacaoDao;
import br.com.buzzpage.dao.ComentarioDAO;
import br.com.buzzpage.dao.PaginaDao;
import br.com.buzzpage.dao.PessoaDao;
import br.com.buzzpage.entity.Comentario;
import br.com.buzzpage.rest.serviceutil.Constants;
import br.com.buzzpage.util.StringUtil;
import br.com.buzzpage.vo.ComentarioVO;

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
