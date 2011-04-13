package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Report;

public interface ReportBo {
	void addReport(Report report);
	void removeReport(Report report);
	void removeReport(long reportId);
	void updateReport(Report report);
	List<Report> findAllReports();
}
