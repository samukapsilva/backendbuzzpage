#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ${package}.dao.AnuncianteDao;
import ${package}.entity.Anunciante;
import ${package}.vo.LoginVo;

/**
 * Data Access Object que representa o Anunciante
 * 
 * @author Fernando Pires
 */
public class AnuncianteDaoJPA2Impl extends GenericDaoImpl<Anunciante> implements
		AnuncianteDao {

	private static final String QUERY_ANUNCIANTES_INDICADOS = "select  from Anunciante a  where a.idPessoa = :idPessoa";
	private static final String PESSOA_POR_EMAIL_OU_LOGIN = "FROM Anunciante a where a.email = :email or a.login= :login";
	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	
	/**
	 * Metodo responsavel por realizar a busca de anunciantes pelo id da pessoa
	 * 
	 * @param Long
	 *            idPessoa
	 * @return List<Anunciante>
	 */
	@Override
	public List<Anunciante> buscarAnunciantes(Long idPessoa) {
		Query query = this.entityManager
				.createQuery(QUERY_ANUNCIANTES_INDICADOS);
		query.setParameter("idPessoa", idPessoa);
		List<Anunciante> anuncios = query.getResultList();
		return anuncios;
	}

	/**
	 * Metodo responsavel por realizar a autentica��o do usuario
	 * 
	 * @param loginVo
	 * @return Anunciante
	 */
	public Anunciante findByEmailOrLogin(LoginVo loginVo) {
		Anunciante anunciante = null;

		Query query = this.entityManager.createQuery(PESSOA_POR_EMAIL_OU_LOGIN);
		query.setParameter("email", loginVo.getUsuario());
		query.setParameter("login", loginVo.getUsuario());

		List<Anunciante> result = query.getResultList();

		if (result != null && result.size() > 0) {

			anunciante = result.get(0);
		}

		return anunciante;
	}
}