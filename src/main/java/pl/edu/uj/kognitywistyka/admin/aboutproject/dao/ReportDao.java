package pl.edu.uj.kognitywistyka.admin.aboutproject.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Report;

public interface ReportDao {
	void addReport(Report report);
	void removeReport(Report report);
	void updateReport(Report report);
	List<Report> findAllReports();
	public Report getReport(long id);
}
