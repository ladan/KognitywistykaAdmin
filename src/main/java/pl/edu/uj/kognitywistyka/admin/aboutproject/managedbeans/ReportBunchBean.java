package pl.edu.uj.kognitywistyka.admin.aboutproject.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.admin.aboutproject.bo.ReportBo;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Report;

@ManagedBean
@RequestScoped
public class ReportBunchBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Report> allReports;
	
	@ManagedProperty(name="reportBo", value="#{reportBo}")
	private ReportBo reportBo;

	public List<Report> getAllReports() {
		if(allReports == null)
			allReports = reportBo.findAllReports();
		return allReports;
	}
	
	public void setAllReports(List<Report> allReports) {
		this.allReports = allReports;
	}

	public void setReportBo(ReportBo reportBo) {
		this.reportBo = reportBo;
	}
	
}
