package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.dao.ReportDao;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Report;

public class ReportBoImpl implements ReportBo, Serializable {

	private static final long serialVersionUID = 1L;
	ReportDao reportDao;
	
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}

	@Override
	public void addReport(Report report) {
		reportDao.addReport(report);
	}

	@Override
	public void removeReport(Report report) {
		reportDao.removeReport(report);
	}

	@Override
	public void removeReport(long reportId) {
		for (Report report : findAllReports()) {
			if(report.getReportId() == reportId)
				removeReport(report);
		}
	}

	@Override
	public void updateReport(Report report) {
		reportDao.updateReport(report);
	}

	@Override
	public List<Report> findAllReports() {
		return reportDao.findAllReports();
	}
}
