#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.util.List;

import ${package}.entity.Anunciante;
import ${package}.vo.LoginVo;

public interface AnuncianteDao {

	Anunciante create(Anunciante t);

	void delete(Object id);

	Anunciante find(Object id);

	Anunciante update(Anunciante t);

	List<Anunciante> buscarAnunciantes(Long idPessoa);

	
	Anunciante findByEmailOrLogin(LoginVo loginVo);

}