package pl.edu.uj.kognitywistyka.admin.publication.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

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
		return ht.find("from Tag order by date desc");
	}



}
