#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ${package}.business.service.RegiaoService;
import ${package}.dao.RegiaoDAO;
import ${package}.entity.Regiao;
import ${package}.vo.RegiaoVO;

public class RegiaoServiceImpl implements RegiaoService {

	@Autowired
	RegiaoDAO regiaoDAO;

	@Override
	public List<RegiaoVO> buscarRegioes() {
		List<RegiaoVO> listaRegioesRetorno = new ArrayList<RegiaoVO>();
		List<Regiao> listaRegioes = regiaoDAO.buscarRegioes();
		if (listaRegioes != null) {
			for (Regiao reg : listaRegioes) {
				RegiaoVO regVO = converterEntityToVo(reg);
				listaRegioesRetorno.add(regVO);
			}
		}
		return listaRegioesRetorno;
	}

	/**
	 * Metodo responsavel por converter uma Entity Regiao no Value Object
	 * RegiaoVO;
	 * 
	 * @param Regiao
	 *            regiao
	 * @return RegiaoVO regiaoVO
	 */
	public RegiaoVO converterEntityToVo(Regiao regiao) {
		RegiaoVO regiaoVO = new RegiaoVO();
		regiaoVO.setIdRegiao(regiao.getIdRegiao());
		regiaoVO.setDescricao(regiao.getDescricao());
		return regiaoVO;
	}

}
