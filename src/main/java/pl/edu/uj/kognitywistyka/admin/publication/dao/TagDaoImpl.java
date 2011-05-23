package pl.edu.uj.kognitywistyka.admin.publication.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.admin.publication.model.Publication;
import pl.edu.uj.kognitywistyka.admin.publication.model.Tag;

public class TagDaoImpl extends HibernateDaoSupport implements TagDao {

	public void addTag(Tag tag) {
		getHibernateTemplate().save(tag);
	}

	public void removeTag(Tag tag) {
		getHibernateTemplate().delete(tag);
	}

	public Tag getTag(long tagId) {
		return (Tag) getHibernateTemplate().get(Tag.class, tagId);
	}

	@SuppressWarnings("unchecked")
	public List<Tag> findAllTags() {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(3);
		return ht.find("from Tag ");
	}

	@SuppressWarnings("unchecked")
	public List<Tag> getTagsForPublication(long publicationId) {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(10);
		List<Tag> lista = ht.find("from Tag ");
		List<Tag> result = new ArrayList<Tag>(0);
		
		etykieta:
		for(Tag i :lista)
		{
			for(Publication j : i.getPublications())
			{
				if(j.getPublicationId() == publicationId)
				{
					result.add(i);
					continue etykieta;
				}
			}
		}
		
	//	String hql = "select distinct a from Tag a " + "join a.Publication t "
		//		+ "where t.PUBLICATION_ID is :publicationId";
		//Query query = getSession().createQuery(hql);
		//query.setParameter("publicationId", publicationId);

		return result;
	}

}
