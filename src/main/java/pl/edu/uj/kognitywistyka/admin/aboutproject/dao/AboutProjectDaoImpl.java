package pl.edu.uj.kognitywistyka.admin.aboutproject.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.AboutProject;

public class AboutProjectDaoImpl extends HibernateDaoSupport 
	implements AboutProjectDao {

	public void addAboutDescription(AboutProject aboutProject) {
		getHibernateTemplate().save(aboutProject);
	}

	@SuppressWarnings("unchecked")
	public List<AboutProject> findAllAboutDescriptions() {
		return getHibernateTemplate().find("from AboutProject order by Data desc");
	}

	public AboutProject findLatestAboutDescription() {
		return findAllAboutDescriptions().get(0);
	}

}
