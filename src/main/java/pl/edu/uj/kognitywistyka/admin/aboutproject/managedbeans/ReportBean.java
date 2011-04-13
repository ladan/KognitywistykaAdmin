package pl.edu.uj.kognitywistyka.admin.aboutproject.managedbeans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.admin.aboutproject.bo.ReportBo;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Report;

@ManagedBean
@RequestScoped
public class ReportBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private long reportId;
	private String title;
	private Date date;
	private String content;
	
	// Dependency injection
	@ManagedProperty(name="reportBo", value="#{reportBo}")
	ReportBo reportBo;
	@ManagedProperty(name="reportBunchBean", value="#{reportBunchBean}")
	ReportBunchBean reportBunchBean;
	
	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
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

	public void setReportBo(ReportBo reportBo) {
		this.reportBo = reportBo;
	}
	
	public void setReportBunchBean(ReportBunchBean reportBunchBean) {
		this.reportBunchBean = reportBunchBean;
	}
	
	public String addReport() {
		Report report = new Report();
		report.setTitle(title);
		report.setDate(date);
		report.setContent(content);
		
		reportBo.addReport(report);
		
		resetView();
		return "";
	}
	
	public String removeReport(long reportId) {
		reportBo.removeReport(reportId);
		
		resetView();
		return "";
	}

	private void resetView() {
		setContent("");
		setDate(null);
		setTitle("");
		reportBunchBean.setAllReports(null);
	}
}
