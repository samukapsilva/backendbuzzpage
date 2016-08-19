//package br.com.buzzpage.ga;
//
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.joda.time.LocalDate;
//import org.joda.time.format.DateTimeFormat;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
//
//import br.com.buzzpage.util.GoogleAnalyticsReport;
//import br.com.buzzpage.vo.GoogleAnalyticsVO;
//
//@ContextConfiguration({ "/test-applicationContext.xml" })
//public class CoreGASampleTest extends AbstractJUnit4SpringContextTests {
//
//	private static final Logger LOGGER = Logger.getLogger(CoreGASampleTest.class);
//
//	private static final Integer PAGE_SIZE = 10000;
//	@Autowired
//	private GoogleAnalyticsReport googleAnalyticsReport;
//
//	@Before
//	public void setUp() throws Exception {
//		googleAnalyticsReport.setPageSize(PAGE_SIZE);
//		googleAnalyticsReport
//				.setStartDate(LocalDate.now().minusMonths(6).toString(DateTimeFormat.forPattern("yyyy-MM-dd")));
//		googleAnalyticsReport
//				.setEndDate(LocalDate.now().minusDays(1).toString(DateTimeFormat.forPattern("yyyy-MM-dd")));
//	}
//
//	@Test
//	public void testGASample() throws Exception {
//		List<GoogleAnalyticsVO> reportList = googleAnalyticsReport.getReport();
//		Assert.assertTrue(PAGE_SIZE > Integer.valueOf(reportList.size()));
//		for (GoogleAnalyticsVO googleAnalyticsVO : reportList) {
//			LOGGER.info(googleAnalyticsVO.toString());
//		}
//		LOGGER.info("Quantidade de registros: ".concat(String.valueOf(reportList.size())));
//	}
//
// }
