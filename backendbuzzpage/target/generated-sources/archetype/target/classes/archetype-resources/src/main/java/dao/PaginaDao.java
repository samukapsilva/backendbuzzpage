#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.util.Date;
import java.util.List;

import ${package}.entity.Pagina;

/**
 * 
 * @author ama
 * @see <a href=
 *      "http://www.codingpedia.org/ama/spring-mybatis-integration-example/">
 *      http://www.codingpedia.org/ama/spring-mybatis-integration-example/</a>
 */
public interface PaginaDao {

	public List<Pagina> getPaginas();

	Pagina create(Pagina pagina);

	void delete(Object id);

	Pagina find(Object id);

	Pagina update(Pagina t);

	List<Pagina> findAll();

	public Pagina findByTexto(Long idTexto);

	public Pagina findBySlug(String slug);

	public List<Pagina> findPaginasPessoaisPublicadas(Long idPessoa);

	public List<Pagina> findPaginasPessoais(Long idPessoa);

	public List<Pagina> findPaginasOficiais();

	public List<Pagina> findPaginasPublicadas();

	public List<Pagina> listarPaginasOrdenadasPorNome();

	public List<Pagina> buscarPaginasPorDataRegiao(Long idRegiao, Date dataInicial, Date dataFinal);

}
