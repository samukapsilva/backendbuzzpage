//package br.com.buzzpage.ga;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.joda.time.LocalDate;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
//
//import br.com.buzzpage.business.AnalyticsReportIntegrationBusiness;
//import br.com.buzzpage.dao.ConteudoColaboradorDao;
//import br.com.buzzpage.dao.ConteudoDaoTest;
//import br.com.buzzpage.dao.MetricaTextoDao;
//import br.com.buzzpage.dao.MetricaTextoDaoTest;
//import br.com.buzzpage.dao.PaginaDao;
//import br.com.buzzpage.entity.MetricaTexto;
//import br.com.buzzpage.entity.Texto;
//import br.com.buzzpage.util.GoogleAnalyticsReport;
//import br.com.buzzpage.vo.GoogleAnalyticsVO;
//
//@ContextConfiguration({ "/test-applicationContext.xml" })
//public class AnalyticsIntegrationMetricaDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
//
//	@Autowired
//	private MetricaTextoDao metricaTextoDao;
//	@Autowired
//	private ConteudoColaboradorDao conteudoColaboradorDao;
//	@Autowired
//	private PaginaDao paginaDao;
//	@Autowired
//	private GoogleAnalyticsReport analyticsReport;
//	@Mock
//	private MetricaTextoDao metricaTextoDaoMock = null;
//	@Mock
//	private ConteudoColaboradorDao conteudoColaboradorDaoMock = null;
//	@Mock
//	private GoogleAnalyticsReport analyticsReportMock = null;
//
//	private Texto texto;
//
//	@Before
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//		texto = ConteudoDaoTest.create(conteudoColaboradorDao, paginaDao);
//
//		analyticsReport.setStartDate("2016-05-15");
//		analyticsReport.setEndDate("2016-07-16");
//		analyticsReport.setPageSize(1000);
//		analyticsReport.setSlug(texto.getSlug());
//	}
//
//	@Test
//	public void testCreateMetricaByAnalyticsReportIntegration() {
//		List<GoogleAnalyticsVO> reportList = analyticsReport.getReport();
//		for (GoogleAnalyticsVO googleAnalyticsVO : reportList) {
//			MetricaTexto metricaTexto = new MetricaTexto();
//			metricaTexto.setTexto(texto);
//			metricaTexto.setAverageTime(googleAnalyticsVO.getAverageTime());
//			metricaTexto.setUniquePageViews(googleAnalyticsVO.getUniquePageViews());
//			metricaTexto.setDataMetrica(googleAnalyticsVO.getDate().toDate());
//
//			MetricaTextoDaoTest.create(metricaTexto, metricaTextoDao, conteudoColaboradorDao, paginaDao);
//		}
//
//		List<MetricaTexto> metricaTextoList = metricaTextoDao.findAll();
//		assertFalse(metricaTextoList.isEmpty());
//		assertEquals(reportList.size(), metricaTextoList.size());
//	}
//
//	@Test
//	public void testAnalyticsCreateMetricaBusiness() {
//		GoogleAnalyticsVO googleAnalyticsVO = createAnalyticsVO();
//
//		Texto textoRetorno = prepareMockAnalytics(googleAnalyticsVO);
//		Mockito.when(metricaTextoDaoMock.findMetricaTextoByTextoEData(textoRetorno.getIdTexto(),
//				googleAnalyticsVO.getDate())).thenReturn(null);
//
//		callAnalyticsReportIntegrationBusiness();
//
//		verifyMockAnalytics();
//		Mockito.verify(metricaTextoDaoMock, Mockito.atLeastOnce()).create(Mockito.any(MetricaTexto.class));
//	}
//
//	@Test
//	public void testAnalyticsUpdateMetricaBusiness() {
//		GoogleAnalyticsVO googleAnalyticsVO = createAnalyticsVO();
//
//		Texto textoRetorno = prepareMockAnalytics(googleAnalyticsVO);
//		MetricaTexto metricaTexto = new MetricaTexto();
//		metricaTexto.setIdMetricaTexto(1L);
//		Mockito.when(metricaTextoDaoMock.findMetricaTextoByTextoEData(textoRetorno.getIdTexto(),
//				googleAnalyticsVO.getDate())).thenReturn(metricaTexto);
//
//		callAnalyticsReportIntegrationBusiness();
//
//		verifyMockAnalytics();
//		Mockito.verify(metricaTextoDaoMock, Mockito.atLeastOnce()).update(Mockito.any(MetricaTexto.class));
//	}
//
//	private void verifyMockAnalytics() {
//		Mockito.verify(analyticsReportMock, Mockito.times(1)).getReport();
//		Mockito.verify(conteudoColaboradorDaoMock, Mockito.atLeastOnce()).findBySlug(Mockito.anyString());
//		Mockito.verify(metricaTextoDaoMock, Mockito.atLeastOnce()).findMetricaTextoByTextoEData(Mockito.any(Long.class),
//				Mockito.any(LocalDate.class));
//	}
//
//	private void callAnalyticsReportIntegrationBusiness() {
//		AnalyticsReportIntegrationBusiness analyticsBusiness = new AnalyticsReportIntegrationBusiness();
//		analyticsBusiness.setAnalyticsReport(analyticsReportMock);
//		analyticsBusiness.setMetricaTextoDao(metricaTextoDaoMock);
//		analyticsBusiness.setConteudoColaboradorDao(conteudoColaboradorDaoMock);
//		analyticsBusiness.run();
//	}
//
//	private Texto prepareMockAnalytics(GoogleAnalyticsVO googleAnalyticsVO) {
//		List<GoogleAnalyticsVO> reportReturn = new ArrayList<>();
//		reportReturn.add(googleAnalyticsVO);
//
//		Mockito.when(analyticsReportMock.getReport()).thenReturn(reportReturn);
//		Texto textoRetorno = new Texto();
//		Mockito.when(conteudoColaboradorDaoMock.findBySlug(Mockito.anyString())).thenReturn(textoRetorno);
//		return textoRetorno;
//	}
//
//	private GoogleAnalyticsVO createAnalyticsVO() {
//		GoogleAnalyticsVO googleAnalyticsVO = new GoogleAnalyticsVO();
//		googleAnalyticsVO.setPagePath("/Post/index/academia");
//		googleAnalyticsVO.setUniquePageViews(10);
//		googleAnalyticsVO.setAverageTime(30);
//		googleAnalyticsVO.setDate(LocalDate.now());
//		return googleAnalyticsVO;
//	}
//
// }
