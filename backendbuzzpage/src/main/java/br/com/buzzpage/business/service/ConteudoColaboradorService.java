package br.com.buzzpage.business.service;

import java.util.List;

import br.com.buzzpage.entity.Pessoa;
import br.com.buzzpage.entity.Texto;
import br.com.buzzpage.vo.AlterarPublicacaoVo;
import br.com.buzzpage.vo.DadosGrid;
import br.com.buzzpage.vo.DestaquesPaginaVo;
import br.com.buzzpage.vo.ResultadoPesquisaPaginasVO;
import br.com.buzzpage.vo.TextoVo;

public interface ConteudoColaboradorService {

	Texto salvarConteudo(TextoVo textoVo);

	List<Texto> getTextosColaborador(Long idColaborador);

	Texto getConteudoById(Long id);

	void updateConteudo(TextoVo podcast);

	boolean deletarConteudoColaboradorPorId(Long idTexto, Long idPessoa);

	List<Texto> findAll();

	List<TextoVo> listarTextosColaborador(Long idColaborador);

	TextoVo getConteudoVoById(Long id);

	List<TextoVo> listarTextos();

	DadosGrid montarGridConteudos(Long idColaborador);

	DadosGrid montarGridRevisor(Long idColaborador);

	DestaquesPaginaVo findDestaquePagina(String slug);

	TextoVo findPostBySlug(String slug);

	Boolean setSlug();

	Pessoa alterarStatusPublicacao(AlterarPublicacaoVo publicacao);

	Texto findById(Long idTexto);

	DadosGrid montarGridAdmin();

	List<TextoVo> findTextoPorPalavraChave(String palavraChave,
			Integer qtdeRegistros, Integer offSet);

	List<TextoVo> buscaUltimosPosts(Integer pageSize, Integer offSet);

	ResultadoPesquisaPaginasVO paginasPostsAutoresPorPalavraChave(String palavraChave);

	ResultadoPesquisaPaginasVO findTextoPorIdPagina(Long idPagina, Integer qtdeRegistros, Integer offSet);
}
