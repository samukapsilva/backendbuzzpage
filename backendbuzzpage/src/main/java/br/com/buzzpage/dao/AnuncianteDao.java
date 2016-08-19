package br.com.buzzpage.dao;

import java.util.List;

import br.com.buzzpage.entity.Anunciante;
import br.com.buzzpage.vo.LoginVo;

public interface AnuncianteDao {

	Anunciante create(Anunciante t);

	void delete(Object id);

	Anunciante find(Object id);

	Anunciante update(Anunciante t);

	List<Anunciante> buscarAnunciantes(Long idPessoa);

	
	Anunciante findByEmailOrLogin(LoginVo loginVo);

}