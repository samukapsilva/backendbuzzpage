package br.com.buzzpage.business.service;

import br.com.buzzpage.entity.Avaliacao;
import br.com.buzzpage.vo.AvaliacaoVo;

public interface AvaliacaoService {

	AvaliacaoVo getAvaliacaoVoById(Long id);

	AvaliacaoVo getUltimaPorConteudo(Long idConteudo);

	Avaliacao cadastrarAvaliacao(AvaliacaoVo avaliacaoVo);

}
