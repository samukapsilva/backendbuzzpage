package br.com.buzzpage.business.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import br.com.buzzpage.entity.Pessoa;
import br.com.buzzpage.vo.DadosGrid;
import br.com.buzzpage.vo.LoginVo;
import br.com.buzzpage.vo.PessoaVo;
import br.com.buzzpage.vo.ProfileVo;

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
