package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.io.Serializable;

import pl.edu.uj.kognitywistyka.admin.aboutproject.dao.ReportDao;

public class ReportBoImpl implements ReportBo, Serializable {

	ReportDao reportDao;
	
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
}
