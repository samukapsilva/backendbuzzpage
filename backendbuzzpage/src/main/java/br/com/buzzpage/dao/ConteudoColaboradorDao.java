package br.com.buzzpage.dao;

import java.util.List;

import br.com.buzzpage.entity.Texto;
import br.com.buzzpage.vo.ResultadoPesquisaPaginasVO;

/**
 * 
 * @author Alexandre Parreira
 * @see
 */
public interface ConteudoColaboradorDao {

	Texto salvarConteudo(Texto texto);

	Texto create(Texto t);

	void delete(Object id);

	Texto find(Object id);

	Texto update(Texto t);

	List<Texto> findAll();

	List<Texto> findTextosColaborador(Long idColaborador);

	Texto findTextoPessoa(Long idTexto, Long idPessoa);

	List<Texto> findTextosRevisor(Long idColaborador);

	// Texto findByAvaliacao(Long id);

	Texto findByMensagem(Long id);

	Texto findUltimoConteudoPagina(Long idPagina);

	Texto findBySlug(String slug);

	List<Texto> findOutrosDestaques(Long idPagina, Long idUltimoDestaque);

	List<Texto> findListaPostsPagina(Long idPagina);

	List<Texto> findTextoPorPalavraChave(String plavraChave,
			Integer qtdeRegistros, Integer offSet);

	List<Texto> buscaUltimosPosts(Integer maxResult, Integer offSet);

	ResultadoPesquisaPaginasVO paginasPostsAutoresPorPalavraChave(String palavraChave);
	
	List<Texto> findTextoPorIdPagina(Long idPagina, Integer maxResults, Integer offSet);

}
