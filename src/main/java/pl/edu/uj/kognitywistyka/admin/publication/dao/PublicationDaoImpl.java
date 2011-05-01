package pl.edu.uj.kognitywistyka.admin.publication.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.admin.publication.model.Publication;

public class PublicationDaoImpl extends HibernateDaoSupport implements PublicationDao {

	public void addPublication(Publication publication) {
		getHibernateTemplate().save(publication);

	}

	@SuppressWarnings("unchecked")
	public List<Publication> findAllPublication() {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(3);
		return ht.find("from Publication order by date desc");
	}

	public Publication getPublication(long id) {
		return (Publication) getHibernateTemplate().get(Publication.class, id);
	}

	public void updatePublication(Publication publication) {
		getHibernateTemplate().update(publication);

	}

	public void removePublication(Publication publication) {
		getHibernateTemplate().delete(publication);

	}

	
}
