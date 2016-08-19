#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * package ${package}.dao;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.junit.Assert.assertFalse; import static org.junit.Assert.assertNotNull;
 * 
 * import java.util.Date; import java.util.List;
 * 
 * import org.joda.time.LocalDate; import org.junit.Assert; import
 * org.junit.Before; import org.junit.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.test.context.ContextConfiguration; import
 * org.springframework
 * .test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
 * 
 * import ${package}.entity.Anunciante; //*import
 * ${package}.entity.Pagina; import ${package}.entity.Regiao;
 * 
 * @ContextConfiguration({ "/test-applicationContext.xml" }) public class
 * AnuncianteDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
 * 
 * @Autowired private AnuncianteDao anuncianteDao;
 * 
 * public static Anunciante create(Anunciante anunciante, PedidoDao pedidoDao) {
 * if (anunciante == null) { anunciante = new Anunciante();
 * 
 * anunciante.setNome("Zé do Banner"); anunciante.setDataCadastro(new Date());
 * anunciante.setBairro("Cabrobró do Norte"); anunciante.setCep("06420340");
 * anunciante.setCidade("Paraíba"); anunciante.setEndereco("rua gregorio");
 * anunciante.setEstado("Campina Grande"); anunciante.setNumero(345L);
 * anunciante.setNumeroDoc("44563984438"); anunciante.setTipoDoc("Cpf");
 * anunciante.setTipoPessoa("Pessoa Boa de venda");
 * 
 * } }
 * 
 * @Before public void setUp() { anuncio = AnuncianteDaoTest.create(null,
 * paginaDao, regiaoDao, anuncioDao); regiaoNorte = anuncio.getRegioes().get(0);
 * }
 * 
 * @Test public void testCreate() { assertNotNull("Id do anuncio nulo",
 * anuncio.getIdAnunciante()); List<Regiao> regioes = anuncio.getRegioes();
 * assertFalse(regioes.isEmpty()); Regiao regiao = regioes.get(0);
 * Assert.assertNotNull(regiao.getIdRegiao()); Assert.assertEquals(
 * "Regiao norte", regiao.getDescricao()); List<Pagina> paginas =
 * anuncio.getPaginas(); assertFalse(paginas.isEmpty()); Pagina pagina =
 * paginas.get(0); Assert.assertNotNull(pagina.getIdPagina());
 * Assert.assertEquals("academia", pagina.getSlug()); }
 * 
 * @Test public void testFindAnunciantesByRegiaoEData() { Date dataInicio =
 * LocalDate.now().minusDays(29).toDate(); Date dataFim =
 * LocalDate.now().minusDays(2).toDate(); List<Pagina> paginas =
 * anuncioDao.buscarPaginasPorRegiaoEPeriodo(regiaoNorte.getIdRegiao(),
 * dataInicio, dataFim); assertFalse(
 * "As paginas resultantes da busca nao foram encontadas.", paginas.isEmpty());
 * assertEquals("Esperava encontrar duas paginas", 2, paginas.size()); }
 * 
 * }
 */