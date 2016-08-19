#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ${package}.business.service.AvaliacaoService;
import ${package}.dao.AvaliacaoDao;
import ${package}.dao.ConteudoColaboradorDao;
import ${package}.dao.PessoaDao;
import ${package}.entity.Avaliacao;
import ${package}.entity.Texto;
import ${package}.vo.AvaliacaoVo;

public class AvaliacaoServiceImpl implements AvaliacaoService {

	@Autowired
	AvaliacaoDao avaliacaoDao;

	@Autowired
	PessoaDao pessoaDao;

	@Autowired
	ConteudoColaboradorDao conteudoDao;

	public AvaliacaoVo getAvaliacaoVoById(Long id) {

		Avaliacao avaliacao = avaliacaoDao.find(id);
		return copyPropertiesEntityToVo(new AvaliacaoVo(), avaliacao);
	}

	public AvaliacaoVo getUltimaPorConteudo(Long idConteudo) {
		Avaliacao avaliacao = avaliacaoDao.findUltimaPorConteudo(idConteudo);
		AvaliacaoVo avaliacaoVo = new AvaliacaoVo();

		avaliacaoVo = copyPropertiesEntityToVo(avaliacaoVo, avaliacao);

		return avaliacaoVo;

	}

	@Transactional
	public Avaliacao cadastrarAvaliacao(AvaliacaoVo avaliacaoVo) {

		Avaliacao avaliacao = copyPropertiesVoToEntity(avaliacaoVo, new Avaliacao());
		avaliacao = avaliacaoDao.salvar(avaliacao);

		boolean statusLiberadoPublicar = ((avaliacao.getErroPlagio() != null && !avaliacao.getErroPlagio())
				&& (avaliacao.getErrosGramaticais() != null && !avaliacao.getErrosGramaticais())
				&& (avaliacao.getErrosOrtograficos() != null && !avaliacao.getErrosOrtograficos()));

		Texto texto = conteudoDao.find(avaliacaoVo.getIdConteudo());
		texto.setStatusLiberadoPublicar(statusLiberadoPublicar);

		return avaliacao;

	}

	private Avaliacao copyPropertiesVoToEntity(AvaliacaoVo vo, Avaliacao entity) {

		entity.setCoesaoTextual(vo.getCoesaoTextual());
		entity.setComentDivisaoParagrafos(vo.getComentDivisaoParagrafos());
		entity.setComentQualidadeTitulo(vo.getComentQualidadeTitulo());
		entity.setDescErroPlagio(vo.getDescErroPlagio());
		entity.setDescErrosGramaticais(vo.getDescErrosGramaticais());
		entity.setDescErrosOrtograficos(vo.getDescErrosOrtograficos());
		entity.setDivisaoParagrafos(vo.getDivisaoParagrafos());
		entity.setErroPlagio(vo.getErroPlagio());
		entity.setErrosGramaticais(vo.getErrosGramaticais());
		entity.setErrosOrtograficos(vo.getErrosOrtograficos());
		entity.setEscaneabilidade(vo.getEscaneabilidade());
		entity.setEstruturaConteudo(vo.getEstruturaConteudo());
		entity.setGeralFrases(vo.getGeralFrases());

		entity.setDataRevisao(new Date());
		entity.setIdConteudo(vo.getIdConteudo());
		entity.setIdRevisor(vo.getIdRevisor());
		entity.setSugestRelacionamentoPalavra(vo.getSugestRelacionamentoPalavra());
		entity.setSugestGeralFrases(vo.getSugestGeralFrases());
		entity.setUsoSinonimos(vo.getUsoSinonimos());

		/*
		
			*/
		entity.setIdRevisor(vo.getIdRevisor());
		entity.setQualidadeIntroducao(vo.getQualidadeIntroducao());
		entity.setQualidadeTitulo(vo.getQualidadeTitulo());
		entity.setRelacionamentoPalavra(vo.getRelacionamentoPalavra());
		entity.setSugestCoesaoTextual(vo.getSugestCoesaoTextual());
		entity.setSugestEscaneabilidade(vo.getSugestEscaneabilidade());
		entity.setSugestEstruturaConteudo(vo.getSugestEstruturaConteudo());
		entity.setSugestGeralFrases(entity.getSugestGeralFrases());
		entity.setSugestQualidadeIntroducao(vo.getSugestQualidadeIntroducao());
		entity.setSugestUsoSinonimos(vo.getSugestUsoSinonimos());

		return entity;
	}

	private AvaliacaoVo copyPropertiesEntityToVo(AvaliacaoVo vo, Avaliacao entity) {

		if (entity == null) {
			return new AvaliacaoVo();
		}

		if (vo == null) {
			vo = new AvaliacaoVo();
		}

		vo.setCoesaoTextual(entity.getCoesaoTextual());
		vo.setComentDivisaoParagrafos(entity.getComentDivisaoParagrafos());
		vo.setComentQualidadeTitulo(entity.getComentQualidadeTitulo());
		vo.setDescErroPlagio(entity.getDescErroPlagio());
		vo.setDescErrosGramaticais(entity.getDescErrosGramaticais());
		vo.setDescErrosOrtograficos(entity.getDescErrosOrtograficos());
		vo.setDivisaoParagrafos(entity.getDivisaoParagrafos());
		vo.setErroPlagio(entity.getErroPlagio());
		vo.setErrosGramaticais(entity.getErrosGramaticais());
		vo.setErrosOrtograficos(entity.getErrosOrtograficos());
		vo.setEscaneabilidade(entity.getEscaneabilidade());
		vo.setEstruturaConteudo(entity.getEstruturaConteudo());
		vo.setGeralFrases(entity.getGeralFrases());

		vo.setId(entity.getId());

		vo.setIdRevisor(entity.getIdRevisor());

		vo.setQualidadeIntroducao(entity.getQualidadeIntroducao());
		vo.setQualidadeTitulo(entity.getQualidadeTitulo());
		vo.setRelacionamentoPalavra(entity.getRelacionamentoPalavra());
		vo.setSugestCoesaoTextual(entity.getSugestCoesaoTextual());
		vo.setSugestEscaneabilidade(entity.getSugestEscaneabilidade());
		vo.setSugestEstruturaConteudo(entity.getSugestEstruturaConteudo());
		vo.setSugestGeralFrases(entity.getSugestGeralFrases());
		vo.setSugestQualidadeIntroducao(entity.getSugestQualidadeIntroducao());
		vo.setSugestUsoSinonimos(entity.getSugestUsoSinonimos());
		vo.setUsoSinonimos(entity.getUsoSinonimos());
		vo.setSugestRelacionamentoPalavra(entity.getSugestRelacionamentoPalavra());

		/*
		 * Texto texto = conteudoDao.findByAvaliacao(entity.getId());
		 * vo.setIdConteudo(texto.getIdTexto());
		 */

		vo.setIdConteudo(entity.getIdConteudo());

		return vo;

	}

}
