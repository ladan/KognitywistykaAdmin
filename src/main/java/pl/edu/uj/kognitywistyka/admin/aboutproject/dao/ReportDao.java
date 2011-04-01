package pl.edu.uj.kognitywistyka.admin.aboutproject.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Report;

public interface ReportDao {
	void addReport(Report report);

	List<Report> findAllReports();
}
