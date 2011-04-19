package pl.edu.uj.kognitywistyka.admin.aboutproject.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Report;


public class ReportDaoImpl extends HibernateDaoSupport
	implements ReportDao{

	
	public void addReport(Report report) {
		getHibernateTemplate().save(report);
		
	}

	@SuppressWarnings("unchecked")
	public List<Report> findAllReports() {
		return getHibernateTemplate().find("from Report order by date desc");
	}

	public void removeReport(Report report) {
		getHibernateTemplate().delete(report);
		
	}

	@Override
	public void updateReport(Report report) {
		getHibernateTemplate().update(report);
		
	}
	
	public Report getReport(long id) {
		return (Report) getHibernateTemplate().get(Report.class, id);
	}

}