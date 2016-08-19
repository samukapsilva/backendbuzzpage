package br.com.buzzpage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.buzzpage.dao.ComentarioDAO;
import br.com.buzzpage.entity.Comentario;

/**
 * Classe responsavel por servir de exemplo para a criacao de DAO.
 * 
 * @author Samuel.Pereira
 *
 */
public class ComentarioDaoJPA2Impl extends GenericDaoImpl<Comentario> implements ComentarioDAO {

	private static final String QUERY_COMENTARIOS_COLABORADOR = "FROM Comentario t where t.pessoa.idPessoa = :idColaborador and idConteudo =:idConteudo";
	private static final String QUERY_COMENTARIO_POR_ID_E_COLABORADOR = "FROM Comentario t where t.pessoa.idPessoa = :idColaborador and t.idComentario = :idComentario";

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	/**
	 * Metodo responsavel por localizar um comentario.
	 * 
	 * @param idColaborador
	 * @return comentarios
	 */
	public List<Comentario> buscarComentariosColaborador(Long idColaborador, Long idConteudo) {
		Query query = this.entityManager.createQuery(QUERY_COMENTARIOS_COLABORADOR);
		query.setParameter("idColaborador", idColaborador);
		List<Comentario> comentarios = query.getResultList();
		return comentarios;
	}

	@Override
	public Comentario buscarComentarioColaborador(Long idColaborador, Long idConteudo) {

		Query query = this.entityManager.createQuery(QUERY_COMENTARIO_POR_ID_E_COLABORADOR);
		query.setParameter("idColaborador", idColaborador);
		query.setParameter("idConteudo", idConteudo);
		Comentario comentario = (Comentario) query.getSingleResult();
		return comentario;
	}

	@Override
	public Comentario update(Comentario comentario) {
		return update(comentario);
	}

	public Comentario salvarComentario(Comentario Comentario) {
		return create(Comentario);
	}

	@Override
	public void delete(Comentario comentario) {
		delete(comentario);
	}
}