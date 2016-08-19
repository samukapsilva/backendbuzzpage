package br.com.buzzpage.business.service;

import java.util.List;

import br.com.buzzpage.vo.ExtratoFinanceiroVO;

public interface ExtratoFinanceiroService {

	List<ExtratoFinanceiroVO> buscarExtratoFinanceiro(Long idPessoa);

}
