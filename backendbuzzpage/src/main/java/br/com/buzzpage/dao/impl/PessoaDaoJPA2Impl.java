package br.com.buzzpage.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.buzzpage.dao.PessoaDao;
import br.com.buzzpage.entity.Pessoa;
import br.com.buzzpage.vo.LoginVo;

public class PessoaDaoJPA2Impl extends GenericDaoImpl<Pessoa> implements PessoaDao {

	private static final String PESSOA_POR_EMAIL = "FROM Pessoa p where p.email = :email";
	private static final String PESSOA_POR_EMAIL_OU_LOGIN = "FROM Pessoa p where p.email = :email or p.usuario = :usuario";
	private static final String QUERY_AUTOR_DO_TEXTO = "select  t.pessoa from Texto t where t.idTexto = :idTexto";
	private static final String QUERY_AVALIADOR = "select  a.revisor from Avaliacao a where a.id = :idAvaliacao";
	private static final String QUERY_REMETENTE = "select  m.remetente from Mensagem m where m.id = :idMensagem";
	private static final String QUERY_DESTINATARIO = "select  m.destinatario from Mensagem m where m.id = :idMensagem";
	private static final String QUERY_REVISOR_TEXTO = "select t.revisor from Texto t where t.idTexto = :idConteudo";
	private static final String QUERY_AUTOR_DA_PAGINA = "select  p.pessoa from Pagina p where p.idPagina = :idPagina";
	private static final String PESSOA_POR_LOGIN = "FROM Pessoa p where  p.usuario = :usuario";

	private static final String QUERY_DONO_PEDIDO = "select  p.pessoa from Pedido p where p.id = :idPedido";

	private static final String QUERY_DONO_PEDIDO_ANUNCIO = "select  p.pessoa from PedidoAnuncio p where p.id = :idPedido";

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	public Pessoa findByEmail(String email) {

		Pessoa pessoa = null;

		Query query = this.entityManager.createQuery(PESSOA_POR_EMAIL);
		query.setParameter("email", email);

		List<Pessoa> result = query.getResultList();

		if (result != null && result.size() > 0) {

			pessoa = result.get(0);
		}

		return pessoa;
	}

	public Pessoa findByEmailOrLogin(LoginVo loginVo) {

		Pessoa pessoa = null;

		Query query = this.entityManager.createQuery(PESSOA_POR_EMAIL_OU_LOGIN);
		query.setParameter("email", loginVo.getUsuario());
		query.setParameter("usuario", loginVo.getUsuario());

		List<Pessoa> result = query.getResultList();

		if (result != null && result.size() > 0) {

			pessoa = result.get(0);
		}

		return pessoa;
	}

	public Pessoa findByTexto(Long idTexto) {

		Pessoa pessoa = null;
		Query query = this.entityManager.createQuery(QUERY_AUTOR_DO_TEXTO);
		query.setParameter("idTexto", idTexto);

		List<Pessoa> result = query.getResultList();

		if (result != null && result.size() > 0) {
			pessoa = result.get(0);
		}

		return pessoa;
	}

	public Pessoa findByAvaliacao(Long idAvaliacao) {
		Pessoa pessoa = null;
		Query query = this.entityManager.createQuery(QUERY_AVALIADOR); // private
																		// static
																		// final
																		// String
																		// QUERY_AVALIADOR
																		// =
																		// "select
																		// a.revisor
																		// from
																		// Avaliacao
																		// a
																		// where
																		// a.id
																		// =
																		// :idAvaliacao";
		query.setParameter("idAvaliacao", idAvaliacao);

		List<Pessoa> result = query.getResultList();

		if (result != null && result.size() > 0) {
			pessoa = result.get(0);
		}

		return pessoa;
	}

	public Pessoa findDestinatarioByMensagem(Long idMensagem) {
		Pessoa pessoa = null;
		Query query = this.entityManager.createQuery(QUERY_DESTINATARIO);
		query.setParameter("idMensagem", idMensagem);

		List<Pessoa> result = query.getResultList();

		if (result != null && result.size() > 0) {
			pessoa = result.get(0);
		}

		return pessoa;
	}

	public Pessoa findRemetenteByMensagem(Long idMensagem) {

		Pessoa pessoa = null;
		Query query = this.entityManager.createQuery(QUERY_REMETENTE);
		query.setParameter("idMensagem", idMensagem);

		List<Pessoa> result = query.getResultList();

		if (result != null && result.size() > 0) {
			pessoa = result.get(0);
		}

		return pessoa;
	}

	public Pessoa findRevisorTexto(Long idConteudo) {

		Pessoa pessoa = null;
		Query query = this.entityManager.createQuery(QUERY_REVISOR_TEXTO);
		query.setParameter("idConteudo", idConteudo);

		List<Pessoa> result = query.getResultList();

		if (result != null && result.size() > 0) {
			pessoa = result.get(0);
		}

		return pessoa;
	}

	public Pessoa findAutorPagina(Long idPagina) {

		Pessoa pessoa = null;
		Query query = this.entityManager.createQuery(QUERY_AUTOR_DA_PAGINA);
		query.setParameter("idPagina", idPagina);

		List<Pessoa> result = query.getResultList();

		if (result != null && result.size() > 0) {
			pessoa = result.get(0);
		}

		return pessoa;
	}

	public Pessoa findByUsuario(String userName) {

		Pessoa pessoa = null;
		Query query = this.entityManager.createQuery(PESSOA_POR_LOGIN);
		query.setParameter("usuario", userName);
		List<Pessoa> result = query.getResultList();

		if (result != null && result.size() > 0) {
			pessoa = result.get(0);
		}

		return pessoa;

	}

	public Pessoa findByIdPedido(Long idPedido) {
		Pessoa pessoa = null;
		Query query = this.entityManager.createQuery(QUERY_DONO_PEDIDO);
		query.setParameter("idPedido", idPedido);

		List<Pessoa> result = query.getResultList();

		if (result != null && result.size() > 0) {
			pessoa = result.get(0);
		}

		return pessoa;
	}

	public Pessoa findByIdPedidoAnuncio(Long idPedido) {
		Pessoa pessoa = null;
		Query query = this.entityManager.createQuery(QUERY_DONO_PEDIDO_ANUNCIO);
		query.setParameter("idPedido", idPedido);

		List<Pessoa> result = query.getResultList();

		if (result != null && result.size() > 0) {
			pessoa = result.get(0);
		}

		return pessoa;
	}

	@Override
	public List<Pessoa> listarOrdenadoPorNome() {
		// TODO Auto-generated method stub
		return null;
	}

}
