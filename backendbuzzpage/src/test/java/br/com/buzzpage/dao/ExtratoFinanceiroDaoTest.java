package br.com.buzzpage.dao;

import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import br.com.buzzpage.entity.Anunciante;
import br.com.buzzpage.entity.ExtratoFinanceiro;
import br.com.buzzpage.entity.Pessoa;
import br.com.buzzpage.entity.Texto;
import br.com.buzzpage.entity.TipoLancamento;

@ContextConfiguration({ "/test-applicationContext.xml" })
public class ExtratoFinanceiroDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private AnuncianteDao anuncianteDao;
	@Autowired
	private ConteudoColaboradorDao conteudoColaboradorDao;
	@Autowired
	private PessoaDao pessoaDao;
	@Autowired
	private TipoLancamentoDao tipoLancamentoDao;
	@Autowired
	private ExtratoFinanceiroDao extratoFinanceiroDao;

	private ExtratoFinanceiro extratoFinanceiro;
	private Anunciante anunciante;
	private Texto texto;
	private Pessoa pessoa;
	private TipoLancamento tipoLancamento;

	public ExtratoFinanceiro create() {
		if (extratoFinanceiro == null) {
			extratoFinanceiro = new ExtratoFinanceiro();
			extratoFinanceiro.setData(LocalDate.now().toDate());
			extratoFinanceiro.setFlagDebito('0');

			anunciante = new Anunciante();
			anunciante.setNome("Google AdSense");
			anunciante = anuncianteDao.create(anunciante);
			extratoFinanceiro.setAnunciante(anunciante);

			texto = new Texto();
			texto.setTitulo("Academia");
			texto = conteudoColaboradorDao.create(texto);
			extratoFinanceiro.setTexto(texto);

			pessoa = new Pessoa();
			pessoa.setNome("Henrique");
			pessoa.setAceiteTermos(true);
			pessoa.setPublicarAutoria(false);
			pessoa.setPublicarRedes(true);
			pessoa.setPublicarSite(true);
			pessoa = pessoaDao.create(pessoa);
			extratoFinanceiro.setPessoa(pessoa);

			tipoLancamento = new TipoLancamento();
			tipoLancamento.setId(2L);
			tipoLancamento.setDescricao("Pedido de Saque");
			tipoLancamento = tipoLancamentoDao.create(tipoLancamento);
			extratoFinanceiro.setTipoLancamento(tipoLancamento);

		}
		return extratoFinanceiroDao.create(extratoFinanceiro);
	}

	@Before
	public void setUp() {
		create();
	}

	@Test
	public void testCreate() {
		List<ExtratoFinanceiro> extratos = extratoFinanceiroDao.findAll();
		Assert.assertFalse("A lista de extratos nao deveria vir vazia. ", extratos.isEmpty());
	}

	@Test
	public void testFindExtratoPorIdPessoa() {
		List<ExtratoFinanceiro> extratos = extratoFinanceiroDao.findPorIdPessoa(pessoa.getIdPessoa());
		Assert.assertEquals("O extraro nao e igual ao esperado", extratos.get(0).getIdExtrato(),
				extratoFinanceiro.getIdExtrato());
		;
	}

}
