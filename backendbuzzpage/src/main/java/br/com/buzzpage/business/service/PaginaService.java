package br.com.buzzpage.business.service;

import java.util.Date;
import java.util.List;

import br.com.buzzpage.entity.Pagina;
import br.com.buzzpage.entity.Pessoa;
import br.com.buzzpage.vo.AlterarPublicacaoVo;
import br.com.buzzpage.vo.CategoriaVo;
import br.com.buzzpage.vo.PaginaVo;

public interface PaginaService {

	List<Pagina> findAll();

	Pagina findBySlug(String slug);

	Pagina criarPagina(PaginaVo paginaVo);

	List<CategoriaVo> findCategoriasByTipo(Long idTipo);

	List<PaginaVo> findPaginasPessoais(Long idPessoa);

	List<PaginaVo> findPaginasOficiais();

	PaginaVo findVoBySlug(String slug);

	PaginaVo findById(Long id);

	List<PaginaVo> findPaginasPublicadasVo();

	List<PaginaVo> gridPaginasAdmin();

	List<PaginaVo> gridPaginasPessoais(Long idPessoa);

	List<PaginaVo> findPaginasPessoaisPublicadas(Long idPessoa);

	Pessoa alterarStatusPublicacao(AlterarPublicacaoVo publicacao);

	List<PaginaVo> listaTodas();

	List<PaginaVo> buscarPaginasPorDataRegiao(Long idRegiao, Date dataInicial, Date dataFinal);

}
