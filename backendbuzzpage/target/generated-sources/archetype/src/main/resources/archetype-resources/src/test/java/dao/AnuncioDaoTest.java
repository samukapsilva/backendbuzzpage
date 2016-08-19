#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
//package ${package}.dao;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.joda.time.LocalDate;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
//
//import ${package}.entity.Anuncio;
//import ${package}.entity.Pagina;
//import ${package}.entity.Regiao;
//
//@ContextConfiguration({ "/test-applicationContext.xml" })
//public class AnuncioDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
//
//	@Autowired
//	private RegiaoDAO regiaoDao;
//	@Autowired
//	private PaginaDao paginaDao;
//	@Autowired
//	private AnuncioDAO anuncioDao;
//
//	private Anuncio anuncio;
//	private Regiao regiaoNorte;
//
//	public static Anuncio create(Anuncio anuncio, PaginaDao paginaDao, RegiaoDAO regiaoDao, AnuncioDAO anuncioDao) {
//		if (anuncio == null) {
//			anuncio = new Anuncio();
//			anuncio.setDataInicio(LocalDate.now().minusDays(30).toDate());
//			anuncio.setDataFinal(LocalDate.now().toDate());
//
//			Pagina paginaAcademia = PaginaDaoTest.create(paginaDao, "academia");
//			Pagina paginaCulinaria = PaginaDaoTest.create(paginaDao, "culinaria");
//			List<Pagina> paginas = new ArrayList<>();
//			paginas.add(paginaAcademia);
//			paginas.add(paginaCulinaria);
//			anuncio.setPaginas(paginas);
//
//			Regiao regiaoNorte = new Regiao();
//			regiaoNorte.setDescricao("Regiao norte");
//			regiaoNorte = regiaoDao.create(regiaoNorte);
//			List<Regiao> regioes = new ArrayList<>();
//			regioes.add(regiaoNorte);
//			anuncio.setRegioes(regioes);
//		}
//		return anuncioDao.salvarAnuncio(anuncio);
//	}
//
//	@Before
//	public void setUp() {
//		anuncio = AnuncioDaoTest.create(null, paginaDao, regiaoDao, anuncioDao);
//		regiaoNorte = anuncio.getRegioes().get(0);
//	}
//
//	@Test
//	public void testCreate() {
//		assertNotNull("Id do anuncio nulo", anuncio.getIdAnuncio());
//		List<Regiao> regioes = anuncio.getRegioes();
//		assertFalse(regioes.isEmpty());
//		Regiao regiao = regioes.get(0);
//		Assert.assertNotNull(regiao.getIdRegiao());
//		Assert.assertEquals("Regiao norte", regiao.getDescricao());
//		List<Pagina> paginas = anuncio.getPaginas();
//		assertFalse(paginas.isEmpty());
//		Pagina pagina = paginas.get(0);
//		Assert.assertNotNull(pagina.getIdPagina());
//		Assert.assertEquals("academia", pagina.getSlug());
//	}
//
//	@Test
//	public void testFindAnunciosByRegiaoEData() {
//		Date dataInicio = LocalDate.now().minusDays(29).toDate();
//		Date dataFim = LocalDate.now().minusDays(2).toDate();
//		List<Pagina> paginas = anuncioDao.buscarPaginasPorRegiaoEPeriodo(regiaoNorte.getIdRegiao(), dataInicio,
//				dataFim);
//		assertFalse("As paginas resultantes da busca nao foram encontadas.", paginas.isEmpty());
//		assertEquals("Esperava encontrar duas paginas", 2, paginas.size());
//	}
//
// }
