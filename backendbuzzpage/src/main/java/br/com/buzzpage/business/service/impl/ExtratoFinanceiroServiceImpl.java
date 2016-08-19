package br.com.buzzpage.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.buzzpage.business.service.ExtratoFinanceiroService;
import br.com.buzzpage.dao.ExtratoFinanceiroDao;
import br.com.buzzpage.entity.ExtratoFinanceiro;
import br.com.buzzpage.rest.serviceutil.Constants;
import br.com.buzzpage.util.StringUtil;
import br.com.buzzpage.vo.ExtratoFinanceiroVO;

public class ExtratoFinanceiroServiceImpl implements ExtratoFinanceiroService {

	@Autowired
	ExtratoFinanceiroDao extratoFinanceiroDao;

	@Override
	public List<ExtratoFinanceiroVO> buscarExtratoFinanceiro(Long idPessoa) {
		List<ExtratoFinanceiroVO> listaRetornoVO = new ArrayList<ExtratoFinanceiroVO>();
		List<ExtratoFinanceiro> listaRetorno = extratoFinanceiroDao.findPorIdPessoa(idPessoa);
		for (ExtratoFinanceiro extrato : listaRetorno) {
			ExtratoFinanceiroVO extratoFinanceiroVO = new ExtratoFinanceiroVO();
			extratoFinanceiroVO = copyEntityToVO(extrato);
			listaRetornoVO.add(extratoFinanceiroVO);
		}
		return listaRetornoVO;

	}

	ExtratoFinanceiroVO copyEntityToVO(ExtratoFinanceiro extratoFinanceiro) {
		if (extratoFinanceiro == null || extratoFinanceiro.getIdExtrato() == null) {
			return new ExtratoFinanceiroVO();
		}

		ExtratoFinanceiroVO extratoFinanceiroVO = new ExtratoFinanceiroVO();
		extratoFinanceiroVO.setAnunciante(extratoFinanceiro.getAnunciante().getNome());
		extratoFinanceiroVO.setData(StringUtil.dateToString(extratoFinanceiro.getData(), Constants.FORMATO_DATA_BR));
		extratoFinanceiroVO.setPost(extratoFinanceiro.getTexto().getTitulo());
		extratoFinanceiroVO.setValor(String.valueOf(extratoFinanceiro.getValor()));

		return extratoFinanceiroVO;
	}

}
