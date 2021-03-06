package br.com.buzzpage.dao;

import java.util.List;

import br.com.buzzpage.entity.Pessoa;
import br.com.buzzpage.vo.LoginVo;

/**
 * 
 * @author Alexandre Parreira
 * @see
 */
public interface PessoaDao {

	Pessoa create(Pessoa t);

	void delete(Object id);

	Pessoa find(Object id);

	Pessoa update(Pessoa t);

	List<Pessoa> findAll();

	Pessoa findByEmail(String email);

	Pessoa findByEmailOrLogin(LoginVo loginVo);

	Pessoa findByTexto(Long idTexto);

	Pessoa findByAvaliacao(Long id);

	Pessoa findDestinatarioByMensagem(Long id);

	Pessoa findRemetenteByMensagem(Long id);

	Pessoa findRevisorTexto(Long idConteudo);

	Pessoa findAutorPagina(Long idPagina);

	Pessoa findByIdPedido(Long idPedido);

	Pessoa findByUsuario(String userName);

	List<Pessoa> listarOrdenadoPorNome();

}
