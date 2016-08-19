package br.com.buzzpage.business;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.buzzpage.dao.ConteudoColaboradorDao;
import br.com.buzzpage.dao.MetricaTextoDao;
import br.com.buzzpage.entity.MetricaTexto;
import br.com.buzzpage.entity.Texto;
import br.com.buzzpage.util.GoogleAnalyticsReport;
import br.com.buzzpage.vo.GoogleAnalyticsVO;

@Component
public class AnalyticsReportIntegrationBusiness {

	private static final Logger LOGGER = Logger.getLogger(AnalyticsReportIntegrationBusiness.class);

	@Autowired
	private MetricaTextoDao metricaTextoDao;
	@Autowired
	private ConteudoColaboradorDao conteudoColaboradorDao;
	@Autowired
	private GoogleAnalyticsReport analyticsReport;
	private String startDate;
	private String endDate;
	private Integer pageSize;
	private List<GoogleAnalyticsVO> reportResult;

	public void run() {
		analyticsReport.setStartDate(this.getStartDate());
		analyticsReport.setEndDate(this.getEndDate());
		analyticsReport.setPageSize(this.getPageSize());
		this.reportResult = analyticsReport.getReport();

		for (GoogleAnalyticsVO googleAnalyticsVO : reportResult) {
			Texto postBySlug = conteudoColaboradorDao.findBySlug(googleAnalyticsVO.getSlug("/Post/index/"));
			if (postBySlug != null) {
				armazenarMetricaTexto(googleAnalyticsVO, postBySlug);
			}
		}
	}

	private void armazenarMetricaTexto(GoogleAnalyticsVO googleAnalyticsVO, Texto post) {
		MetricaTexto metricaTexto = (MetricaTexto) metricaTextoDao.findMetricaTextoByTextoEData(post.getIdTexto(),
				googleAnalyticsVO.getDate());
		if (metricaTexto == null) {
			metricaTexto = new MetricaTexto();
			metricaTexto.setTexto(post);
			metricaTexto.setDataMetrica(googleAnalyticsVO.getDate().toDate());
		}
		metricaTexto.setAverageTime(googleAnalyticsVO.getAverageTime());
		metricaTexto.setUniquePageViews(googleAnalyticsVO.getUniquePageViews());
		if (metricaTexto.getIdMetricaTexto() == null) {
			metricaTexto = metricaTextoDao.create(metricaTexto);
		} else {
			metricaTexto = metricaTextoDao.update(metricaTexto);
		}
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setMetricaTextoDao(MetricaTextoDao metricaTextoDao) {
		this.metricaTextoDao = metricaTextoDao;
	}

	public void setConteudoColaboradorDao(ConteudoColaboradorDao conteudoColaboradorDao) {
		this.conteudoColaboradorDao = conteudoColaboradorDao;
	}

	public void setAnalyticsReport(GoogleAnalyticsReport analyticsReport) {
		this.analyticsReport = analyticsReport;
	}

	public List<GoogleAnalyticsVO> getReportResult() {
		return this.reportResult;
	}

}
