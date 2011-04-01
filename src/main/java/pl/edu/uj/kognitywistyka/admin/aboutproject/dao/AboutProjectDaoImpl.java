package pl.edu.uj.kognitywistyka.admin.aboutproject.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.AboutProject;

public class AboutProjectDaoImpl extends HibernateDaoSupport implements
		AboutProjectDao {

	public void addAboutProject(AboutProject aboutProject) {
		getHibernateTemplate().save(aboutProject);
	}

	@SuppressWarnings("unchecked")
	public List<AboutProject> findAllAboutProjects() {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(3);
		return getHibernateTemplate().find("from AboutProject order by Data desc");
	}

	public AboutProject findLatestAboutProject() {
		return findAllAboutProjects().get(0);
	}

}
