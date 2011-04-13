package pl.edu.uj.kognitywistyka.admin.aboutproject.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Link;


public class LinkDaoImpl extends HibernateDaoSupport
	implements LinkDao{

	
	public void addLink(Link link) {
		getHibernateTemplate().save(link);
		
	}

	@SuppressWarnings("unchecked")
	public List<Link> findAllLinks() {
		return getHibernateTemplate().find("from Link order by linkId asc");
	}

	
	public void removeLink(Link link) {
		getHibernateTemplate().delete(link);
		
	}


	public void updateLink(Link link) {
		getHibernateTemplate().update(link);
		
	}
	


}