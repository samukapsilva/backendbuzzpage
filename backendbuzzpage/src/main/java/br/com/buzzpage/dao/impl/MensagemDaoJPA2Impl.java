package br.com.buzzpage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.buzzpage.dao.MensagemDao;
import br.com.buzzpage.entity.Mensagem;

public class MensagemDaoJPA2Impl extends GenericDaoImpl<Mensagem> implements MensagemDao {

	private static final String QUERY_MENSAGEM_DESTINATARIO = "FROM Mensagem m where m.id = :idMensagem and m.remetente.idPessoa = :idPessoa";
	private static final String QUERY_MENSAGEM_PESSOA_CONTEUDO = "FROM Mensagem m where textoVinculado.idTexto = :idConteudo "
			+ "and (m.remetente.idPessoa = :remetente or m.destinatario.idPessoa = :destinatario)";

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	public Mensagem findByRemetenteEIdMensagem(Long id, Long idPessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Mensagem> findMensagensDaPessoaPorConteudo(Long idPessoa, Long idConteudo) {

		Query query = this.entityManager.createQuery(QUERY_MENSAGEM_PESSOA_CONTEUDO);
		query.setParameter("idConteudo", idConteudo);
		query.setParameter("remetente", idPessoa);
		query.setParameter("destinatario", idPessoa);

		List<Mensagem> result = query.getResultList();

		return result;
	}

}
