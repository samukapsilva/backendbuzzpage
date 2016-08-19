package br.com.buzzpage.vo;

import java.io.Serializable;

import org.joda.time.LocalDate;

/**
 * Value Object to GoogleAnalytics response
 * 
 * @author fernandopires
 *
 */
public class GoogleAnalyticsVO implements Serializable {
	private static final long serialVersionUID = -2710141330367002449L;

	private static final String SEPARATOR = ",";
	private String pagePath;
	private LocalDate date;
	private Integer uniquePageViews;
	private Integer averageTime;

	public String getSlug(String pagePath) {
		return this.getPagePath().replaceAll(pagePath, "");
	}

	public String getPagePath() {
		return pagePath;
	}

	public void setPagePath(String pagePath) {
		this.pagePath = pagePath;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate data) {
		this.date = data;
	}

	public Integer getUniquePageViews() {
		return uniquePageViews;
	}

	public void setUniquePageViews(Integer pageViews) {
		this.uniquePageViews = pageViews;
	}

	public Integer getAverageTime() {
		return averageTime;
	}

	public void setAverageTime(Integer averageTime) {
		this.averageTime = averageTime;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [pagePath=");
		sb.append(getPagePath());
		sb.append(SEPARATOR);
		sb.append(" date=");
		sb.append(getDate().toString());
		sb.append(SEPARATOR);
		sb.append(" uniquePageViews=");
		sb.append(getUniquePageViews());
		sb.append(SEPARATOR);
		sb.append(" averageTime=");
		sb.append(getAverageTime());
		sb.append("]");
		return sb.toString();
	}
}
