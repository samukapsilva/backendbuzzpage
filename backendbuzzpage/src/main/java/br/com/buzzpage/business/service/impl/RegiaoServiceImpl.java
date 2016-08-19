package br.com.buzzpage.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.buzzpage.business.service.RegiaoService;
import br.com.buzzpage.dao.RegiaoDAO;
import br.com.buzzpage.entity.Regiao;
import br.com.buzzpage.vo.RegiaoVO;

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
