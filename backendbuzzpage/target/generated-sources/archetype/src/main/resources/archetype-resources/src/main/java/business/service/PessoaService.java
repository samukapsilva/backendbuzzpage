#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import ${package}.entity.Pessoa;
import ${package}.vo.DadosGrid;
import ${package}.vo.LoginVo;
import ${package}.vo.PessoaVo;
import ${package}.vo.ProfileVo;

public interface PessoaService {

	Pessoa salvarPessoa(PessoaVo pessoaVo) throws IllegalAccessException, InvocationTargetException;

	Pessoa getPessoaById(Long id);

	PessoaVo getPessoaVoById(Long id);

	Pessoa updatePessoa(PessoaVo pessoaVo) throws IllegalAccessException, InvocationTargetException;

	Pessoa getPessoaByEmail(String email);

	PessoaVo efetuarLogin(LoginVo loginVo);

	Pessoa resetarSenha(PessoaVo pessoaVo);

	PessoaVo findRevisor(Long idConteudo);

	ProfileVo getProfile(Long id);

	ProfileVo getProfile(String userName);

	Boolean setUsuariosNulos();

	List<PessoaVo> findAll();

	DadosGrid montaGridPessoas();

}
