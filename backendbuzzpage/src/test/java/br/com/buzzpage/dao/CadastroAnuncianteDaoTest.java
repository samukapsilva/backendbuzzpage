/*
 * package br.com.buzzpage.dao;
 * 
 * import static org.junit.Assert.assertNotNull;
 * 
 * import java.util.Date;
 * 
 * import org.joda.time.LocalDate; import org.junit.After; import
 * org.junit.Before; import org.junit.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.test.context.ContextConfiguration; import
 * org.springframework.test.context.junit4.
 * AbstractTransactionalJUnit4SpringContextTests;
 * 
 * import br.com.buzzpage.entity.Anunciante; import
 * br.com.buzzpage.entity.Pagina; import br.com.buzzpage.entity.Pedido; import
 * br.com.buzzpage.entity.Texto;
 * 
 * @ContextConfiguration({ "/test-applicationContext.xml" }) public class
 * CadastroAnuncianteDaoTest extends
 * AbstractTransactionalJUnit4SpringContextTests {
 * 
 * private static final Date DATE_NOW = new Date();
 * 
 * @Autowired private AnuncianteDao anuncianteDao;
 * 
 * @Autowired private PedidoDao pedidoDao;
 * 
 * @Autowired private PaginaDao paginaDao;
 * 
 * private Anunciante anunciante;
 * 
 * private Pedido pedido;
 * 
 * public static Anunciante create(Anunciante anunciante, AnuncianteDao
 * anuncianteDao, PedidoDao pedidoDao) { if (anunciante == null) { Anunciante
 * anunciante = ConteudoDaoTest.create(anuncianteDao, pedidoDao);
 * 
 * anunciante = new Anunciante();
 * 
 * }
 * 
 * return anuncianteDao.create(anunciante); }
 * 
 * @Before public void setUp() { metricaTexto =
 * CadastroAnuncianteDaoTest.create(null, metricaTextoDao,
 * conteudoColaboradorDao, paginaDao); }
 * 
 * @After public void tearDown() {
 * metricaTextoDao.delete(metricaTexto.getIdAnunciante()); }
 * 
 * @Test public void testCreate() { assertNotNull("Id da metrica texto nulo",
 * metricaTexto.getIdAnunciante()); Texto texto = metricaTexto.getTexto();
 * assertNotNull("Id do texto nulo", texto.getIdTexto()); Pagina pagina =
 * texto.getPagina(); assertNotNull("Id da pagina", pagina.getIdPagina()); }
 * 
 * @Test public void testFindAnuncianteByTextoEData() { Anunciante
 * metricaTextoRetorno = (Anunciante) metricaTextoDao
 * .findAnuncianteByTextoEData(metricaTexto.getTexto().getIdTexto(),
 * LocalDate.fromDateFields(DATE_NOW)); assertNotNull(metricaTextoRetorno); }
 * 
 * }
 */