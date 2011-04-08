package pl.edu.uj.kognitywistyka.admin.gallery.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.admin.gallery.model.Gallery;

public class GalleryDaoImpl extends HibernateDaoSupport implements GalleryDao{

	public void addGallery(Gallery gallery) {
		getHibernateTemplate().save(gallery);
		
	}

	public void removeGallery(Gallery gallery) {
		getHibernateTemplate().delete(gallery);
	}

	@SuppressWarnings("unchecked")
	public List<Gallery> findAllGalleries() {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(8);
		return ht.find("from Gallery order by date desc");
	}

}
