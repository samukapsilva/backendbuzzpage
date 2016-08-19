#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import ${package}.business.service.CurtidaService;
import ${package}.dao.AvaliacaoDao;
import ${package}.dao.CurtidaDAO;
import ${package}.dao.PessoaDao;
import ${package}.entity.Curtida;
import ${package}.vo.CurtidaVO;

public class CurtidaServiceImpl implements CurtidaService {

	@Autowired
	CurtidaDAO curtidaDAO;

	@Autowired
	PessoaDao pessoaDao;

	@Autowired
	AvaliacaoDao avaliacaoDao;

	/**
	 * Metodo responsavel por gravar um curtida.
	 * 
	 * @param curtidaVO
	 * @return
	 */
	public CurtidaVO salvarCurtida(CurtidaVO curtidaVO) {
		Curtida curtida = new Curtida();
		if (curtida.getIdCurtida() != null && curtida.getIdCurtida() > 0) {
			curtida = converterVoToEntity(curtidaVO, curtida);
			curtida = curtidaDAO.salvarCurtida(curtida);
		}
		CurtidaVO curtidaVORetorno = converterEntityToVo(curtida);
		return curtidaVORetorno;
	}

	/**
	 * Metodo responsavel por transformar um objeto VO em Entity.
	 * 
	 * @param comentarioVO
	 * @param curtida
	 * @return
	 */
	public Curtida converterVoToEntity(CurtidaVO curtidaVO, Curtida curtida) {
		curtida.setIdCurtida(curtidaVO.getIdCurtida());
		curtida.getConteudo().setIdTexto(curtidaVO.getIdConteudo());
		curtida.setDataCurtida(new Date());
		curtida.setStatusCurtida(curtidaVO.getStatusCurtida());
		return curtida;
	}

	/**
	 * Metodo responsavel por transformar um objeto Entity em VO.
	 * 
	 * @param curtida
	 * @return comentarioVO
	 */
	private CurtidaVO converterEntityToVo(Curtida curtida) {

		if (curtida == null || curtida.getIdCurtida() == null) {
			return new CurtidaVO();
		}
		CurtidaVO curtidaVO = new CurtidaVO();

		curtidaVO.setStatusCurtida(curtida.getStatusCurtida());
		curtidaVO.setIdCurtida(curtida.getIdCurtida());

		curtidaVO.setDataCurtida(curtida.getDataCurtida());
		curtidaVO.setIdPessoa(curtida.getPessoa().getIdPessoa());
		curtidaVO.setIdComentario(curtida.getComentario().getIdComentario());

		return curtidaVO;
	}

	@Override
	public void atualizarStatusCurtida(CurtidaVO curtidaVO) {
		curtidaDAO.atualizarStatusCurtida(converterVoToEntity(curtidaVO, new Curtida()));
	}

}