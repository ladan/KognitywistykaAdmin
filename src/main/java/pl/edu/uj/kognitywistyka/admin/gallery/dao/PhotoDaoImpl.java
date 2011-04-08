package pl.edu.uj.kognitywistyka.admin.gallery.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.admin.gallery.model.Photo;

public class PhotoDaoImpl extends HibernateDaoSupport implements PhotoDao {

	public void addPhoto(Photo photo) {
		getHibernateTemplate().save(photo);
		
	}

	public void removePhoto(Photo photo) {
		getHibernateTemplate().delete(photo);
		
	}

}
