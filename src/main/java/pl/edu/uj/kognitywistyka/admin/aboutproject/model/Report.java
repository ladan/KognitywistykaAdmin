package pl.edu.uj.kognitywistyka.admin.aboutproject.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Report implements java.io.Serializable{
	
	private static final long serialVersionUID = -7968128389684506623L;
	
	private long reportId;
	private String title;
	private Date date;
	private String content;
	
	private SimpleDateFormat shortDateFormatter = new SimpleDateFormat("dd-MM-yyyy");
	
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
	public String getShortDate() {
		return shortDateFormatter.format(date);
	}
}