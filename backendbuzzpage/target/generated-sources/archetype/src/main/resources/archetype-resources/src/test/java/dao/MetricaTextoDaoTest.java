#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ${package}.entity.MetricaTexto;
import ${package}.entity.Pagina;
import ${package}.entity.Texto;

@ContextConfiguration({ "/test-applicationContext.xml" })
public class MetricaTextoDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	private static final Date DATE_NOW = new Date();
	@Autowired
	private MetricaTextoDao metricaTextoDao;
	@Autowired
	private ConteudoColaboradorDao conteudoColaboradorDao;
	@Autowired
	private PaginaDao paginaDao;

	private MetricaTexto metricaTexto;

	public static MetricaTexto create(MetricaTexto metricaTexto, MetricaTextoDao metricaTextoDao,
			ConteudoColaboradorDao conteudoColaboradorDao, PaginaDao paginaDao) {
		if (metricaTexto == null) {
			Texto texto = ConteudoDaoTest.create(conteudoColaboradorDao, paginaDao);

			metricaTexto = new MetricaTexto();
			metricaTexto.setTexto(texto);
			metricaTexto.setAverageTime(120);
			metricaTexto.setDataMetrica(DATE_NOW);
			metricaTexto.setUniquePageViews(500);
		}

		return metricaTextoDao.create(metricaTexto);
	}

	@Before
	public void setUp() {
		metricaTexto = MetricaTextoDaoTest.create(null, metricaTextoDao, conteudoColaboradorDao, paginaDao);
	}

	@After
	public void tearDown() {
		metricaTextoDao.delete(metricaTexto.getIdMetricaTexto());
	}

	@Test
	public void testCreate() {
		assertNotNull("Id da metrica texto nulo", metricaTexto.getIdMetricaTexto());
		Texto texto = metricaTexto.getTexto();
		assertNotNull("Id do texto nulo", texto.getIdTexto());
		Pagina pagina = texto.getPagina();
		assertNotNull("Id da pagina", pagina.getIdPagina());
	}

	@Test
	public void testFindMetricaTextoByTextoEData() {
		MetricaTexto metricaTextoRetorno = (MetricaTexto) metricaTextoDao
				.findMetricaTextoByTextoEData(metricaTexto.getTexto().getIdTexto(), LocalDate.fromDateFields(DATE_NOW));
		assertNotNull(metricaTextoRetorno);
	}

}
