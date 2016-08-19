#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ${package}.business.AnalyticsReportIntegrationBusiness;

@Component
public class GoogleAnalyticsRunner {

	private static final Logger LOGGER = Logger.getLogger(GoogleAnalyticsRunner.class);

	@Autowired
	private AnalyticsReportIntegrationBusiness analyticsReportIntegrationBusiness;

	@Scheduled(cron = "0 0 1 * * ?")
	@Transactional
	public void executeScheduledTask() {
		LOGGER.info("Start Job");
		analyticsReportIntegrationBusiness
				.setStartDate(LocalDate.now().minusMonths(3).toString(DateTimeFormat.forPattern("yyyy-MM-dd")));
		analyticsReportIntegrationBusiness
				.setEndDate(LocalDate.now().minusDays(1).toString(DateTimeFormat.forPattern("yyyy-MM-dd")));
		analyticsReportIntegrationBusiness.setPageSize(10000);
		analyticsReportIntegrationBusiness.run();
		LOGGER.info("End Job");
	}
}
