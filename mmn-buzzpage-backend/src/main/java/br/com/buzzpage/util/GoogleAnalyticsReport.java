package br.com.buzzpage.util;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.analyticsreporting.v4.AnalyticsReporting;
import com.google.api.services.analyticsreporting.v4.AnalyticsReportingScopes;
import com.google.api.services.analyticsreporting.v4.model.DateRange;
import com.google.api.services.analyticsreporting.v4.model.DateRangeValues;
import com.google.api.services.analyticsreporting.v4.model.Dimension;
import com.google.api.services.analyticsreporting.v4.model.DimensionFilter;
import com.google.api.services.analyticsreporting.v4.model.DimensionFilterClause;
import com.google.api.services.analyticsreporting.v4.model.GetReportsRequest;
import com.google.api.services.analyticsreporting.v4.model.GetReportsResponse;
import com.google.api.services.analyticsreporting.v4.model.Metric;
import com.google.api.services.analyticsreporting.v4.model.Report;
import com.google.api.services.analyticsreporting.v4.model.ReportRequest;
import com.google.api.services.analyticsreporting.v4.model.ReportRow;

import br.com.buzzpage.vo.GoogleAnalyticsVO;

/**
 * Query Google Analytics API
 * 
 * @author FernandoPires
 *
 */
@Component
public class GoogleAnalyticsReport {
	private static Logger LOGGER = Logger.getLogger(GoogleAnalyticsReport.class);

	private static final String POST_INDEX_PATH = "/Post/index/";
	private static final int INDEX_AVG_TIME_ON_PAGE = 1;
	private static final int INDEX_PAGE_VIEWS_VALUES = 0;
	private static final int INDEX_PAGE_VIEWS = 0;
	private static final int INDEX_DIMENSION_DATE = 1;
	private static final int INDEX_PAGE_PATH = 0;
	private static final String FAIL_TO_INITIALIZE_GA_REPORTING_MSG = "Fail to initialize GA reporting";
	private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

	private static final String KEY_FILE_NAME = "keyFileName";
	private static final String SERVICE_ACCOUNT_EMAIL = "serviceAccountEmail";
	private static final String VIEW_ID_DEFAULT = "viewIdDefault";
	private static final String APPLICATION_NAME_DEFAULT = "BuzzPage Analytics Reporting";

	private String applicationName;
	private String viewId;
	private String startDate;
	private String endDate;
	private Integer pageSize;
	private String slug;

	@Autowired
	private Properties analytics;

	public GoogleAnalyticsReport() {
	}

	public void setAnalytics(Properties analytics) {
		this.analytics = analytics;
	}

	public List<GoogleAnalyticsVO> getReport() {
		try {
			AnalyticsReporting analyticsReporting = initializeAnalyticsReporting();
			GetReportsResponse reportPageViewsPagePathDateFilteredByPath = getReportPageViewsPagePathDateFilteredByPath(
					analyticsReporting);
			return processResponse(reportPageViewsPagePathDateFilteredByPath);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
			throw new RuntimeException(FAIL_TO_INITIALIZE_GA_REPORTING_MSG, e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(FAIL_TO_INITIALIZE_GA_REPORTING_MSG, e);
		}
	}

	/**
	 * Initializes and authorizes access to the API.
	 *
	 * @return The analytics reporting service object.
	 * @throws IOException
	 * @throws GeneralSecurityException
	 */
	private AnalyticsReporting initializeAnalyticsReporting() throws GeneralSecurityException, IOException {
		HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();

		GoogleCredential.Builder credentialBuilder = new GoogleCredential.Builder();
		credentialBuilder.setTransport(httpTransport);
		credentialBuilder.setJsonFactory(JSON_FACTORY);
		credentialBuilder.setServiceAccountId(analytics.getProperty(SERVICE_ACCOUNT_EMAIL));
		File keyFile = new File(analytics.getProperty(KEY_FILE_NAME));
		credentialBuilder.setServiceAccountPrivateKeyFromP12File(keyFile);
		credentialBuilder.setServiceAccountScopes(AnalyticsReportingScopes.all());
		GoogleCredential credential = credentialBuilder.build();

		AnalyticsReporting.Builder reportingBuilder = new AnalyticsReporting.Builder(httpTransport, JSON_FACTORY,
				credential);
		reportingBuilder.setApplicationName(applicationName != null ? applicationName : APPLICATION_NAME_DEFAULT);
		AnalyticsReporting analyticsReporting = reportingBuilder.build();

		return analyticsReporting;
	}

	/**
	 * Check the Analytics API V4 based on pageviews, pagePath and date.
	 *
	 * @param service
	 * @return GetReportResponse
	 * @throws IOException
	 */
	private GetReportsResponse getReportPageViewsPagePathDateFilteredByPath(AnalyticsReporting service)
			throws IOException {
		DateRange dateRange = new DateRange();
		dateRange.setStartDate(startDate);
		dateRange.setEndDate(endDate);

		Metric uniquePageViews = new Metric().setExpression("ga:uniquePageviews");
		Metric avgTimeOnPage = new Metric().setExpression("ga:avgTimeOnPage");

		Dimension pagePath = new Dimension().setName("ga:pagePath");
		Dimension date = new Dimension().setName("ga:date");

		DimensionFilter dimensionFilterPath = new DimensionFilter();
		dimensionFilterPath.setDimensionName("ga:pagePath");

		StringBuilder sbFilterPath = new StringBuilder();
		sbFilterPath.append(POST_INDEX_PATH);
		if (this.getSlug() != null) {
			sbFilterPath.append(this.getSlug());
		}

		dimensionFilterPath.setExpressions(Arrays.asList(sbFilterPath.toString()));

		DimensionFilterClause dimensionFilterPathClause = new DimensionFilterClause();
		dimensionFilterPathClause.setFilters(Arrays.asList(dimensionFilterPath));

		ReportRequest request = new ReportRequest();
		request.setViewId(viewId != null ? viewId : analytics.getProperty(VIEW_ID_DEFAULT));
		request.setDateRanges(Arrays.asList(dateRange));
		request.setDimensions(Arrays.asList(pagePath, date));
		request.setMetrics(Arrays.asList(uniquePageViews, avgTimeOnPage));
		request.setDimensionFilterClauses(Arrays.asList(dimensionFilterPathClause));
		request.setPageSize(pageSize);

		ArrayList<ReportRequest> requests = new ArrayList<ReportRequest>();
		requests.add(request);

		GetReportsRequest getReport = new GetReportsRequest();
		getReport.setReportRequests(requests);

		GetReportsResponse response = service.reports().batchGet(getReport).execute();

		return response;
	}

	/**
	 * Process Google Analytics response.
	 * 
	 * @param response
	 * @return {@link GoogleAnalyticsVO} list
	 */
	private List<GoogleAnalyticsVO> processResponse(GetReportsResponse response) {
		List<GoogleAnalyticsVO> googleAnalyticsVOList = new ArrayList<GoogleAnalyticsVO>();

		for (Report report : response.getReports()) {
			List<ReportRow> rows = report.getData().getRows();

			if (null != rows && !rows.isEmpty()) {
				for (ReportRow row : rows) {
					GoogleAnalyticsVO googleAnalyticsVO = new GoogleAnalyticsVO();
					List<String> dimensions = row.getDimensions();
					googleAnalyticsVO.setPagePath(dimensions.get(INDEX_PAGE_PATH));
					googleAnalyticsVO.setDate(LocalDate.parse(dimensions.get(INDEX_DIMENSION_DATE),
							DateTimeFormat.forPattern("yyyyMMdd")));

					List<DateRangeValues> metrics = row.getMetrics();
					if (null != metrics && !metrics.isEmpty()) {
						DateRangeValues values = metrics.get(INDEX_PAGE_VIEWS);
						googleAnalyticsVO
								.setUniquePageViews(Integer.valueOf(values.getValues().get(INDEX_PAGE_VIEWS_VALUES)));
						String avgTimeOnPageString = values.getValues().get(INDEX_AVG_TIME_ON_PAGE);
						Double avgTimeOnPageLong = Double.valueOf(avgTimeOnPageString);
						googleAnalyticsVO.setAverageTime(avgTimeOnPageLong.intValue());
					}
					googleAnalyticsVOList.add(googleAnalyticsVO);
				}
			}
		}

		return googleAnalyticsVOList;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getViewId() {
		return viewId;
	}

	public void setViewId(String viewId) {
		this.viewId = viewId;
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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

}
