package pl.edu.uj.kognitywistyka.admin.publication.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.admin.publication.model.Publication;
import pl.edu.uj.kognitywistyka.admin.publication.model.Tag;

public class PublicationDaoImpl extends HibernateDaoSupport implements
		PublicationDao {

	public void addPublication(Publication publication) {
		getHibernateTemplate().save(publication);

	}

	@SuppressWarnings("unchecked")
	public List<Publication> findAllPublication() {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(8);
		return ht.find("from Publication order by date desc");
	}

	public Publication getPublication(long id) {
		return (Publication) getHibernateTemplate().get(Publication.class, id);
	}

	public void updatePublication(Publication publication) {
		//getHibernateTemplate().update(publication);
		removePublication(publication);
		addPublication(publication);

	}

	public void removePublication(Publication publication) {
		getHibernateTemplate().delete(publication.getPublicationId());

	}

	public void removePublication(long publicationId) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();

		// Piersze szukamy obiektu który chcemu usunąć
		/**
		 * List res =
		 * session.createQuery("from Publication e where e.id=?").setLong(0,
		 * publicationId).list(); if(res.isEmpty()) return;
		 * 
		 * Publication publication = (Publication) res.get(0);
		 * 
		 * for(Tag i : publication.getTags()) {
		 * if(i.getPublications().size()==1) session.delete(i); else {
		 * i.getPublications().remove(publication); session.save(i); } }
		 **/
		List res = session.createQuery("from Publication e where e.id=?")
				.setLong(0, publicationId).list();
		if (res.isEmpty())
			return;

		Publication publication = (Publication) res.get(0);

		List<Tag> listTag = new ArrayList<Tag>(0);
		for (Tag i : publication.getTags()) {
			if (i.getPublications().size() < 2)
				listTag.add(i);

		}

		publication.getTags().clear();
		session.update(publication);
		session.flush();

		/**
		 * for(Tag i : listTag) { i.getPublications().clear();
		 * session.update(i); } session.flush();
		 */
		for (Tag i : listTag) {
			session.delete(i);
		}
		session.flush();
		session.delete(publication);
		session.flush();
		res = session.createQuery("from Tag e where e.publications.size < 1").list();
		if(!res.isEmpty())
		{
			for(Object i : res)
				session.delete(i);
			session.flush();
		}

		tx.commit();
		session.close();

	}

	public void addPublicationWithTags(Publication publication, Set<Tag> tags) {

		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Set<Tag> newTags = new HashSet<Tag>(0);
		for (Tag i : tags) {
			List res = session.createQuery("from Tag e where e.title=?")
					.setString(0, i.getTitle()).list();

			if (!res.isEmpty()) {
				Tag j = (Tag) res.get(0);
				newTags.add(j);
			} else
				newTags.add(i);
		}
		publication.setTags(newTags);

		session.save(publication);

		tx.commit();
		session.close();

	}

}
