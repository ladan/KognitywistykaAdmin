package pl.edu.uj.kognitywistyka.admin.aboutproject.model;

import java.sql.Date;

public class Report{
	private int reportId;
	private String title;
	private Date data;
	private String content;
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int raportId) {
		this.reportId = raportId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}