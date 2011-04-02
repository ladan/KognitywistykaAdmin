package pl.edu.uj.kognitywistyka.admin.aboutproject.model;

import java.util.Date;

public class Report{
	private long reportId;
	private String title;
	private Date date;
	private String content;
	
	public long getReportId() {
		return reportId;
	}
	public void setReportId(long raportId) {
		this.reportId = raportId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}