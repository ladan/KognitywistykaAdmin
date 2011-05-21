package pl.edu.uj.kognitywistyka.admin.gallery.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.admin.gallery.dao.GalleryDao;
import pl.edu.uj.kognitywistyka.admin.gallery.model.Gallery;

public class GalleryBoImpl implements Serializable, GalleryBo {
	private static final long serialVersionUID = 1L;
	GalleryDao galleryDao;

	public void setGalleryDao(GalleryDao galleryDao) {
		this.galleryDao = galleryDao;
	}

	public void addGallery(Gallery gallery) {
		galleryDao.addGallery(gallery);
	}

	public void removeGallery(Gallery gallery) {
		galleryDao.removeGallery(gallery);
	}

	public List<Gallery> findAllGalleries() {
		List<Gallery> galleries = galleryDao.findAllGalleries();

		return galleries;

	}

	public void removeGallery(long galleryId) {
		galleryDao.removeGallery(galleryDao.getGallery(galleryId));
	}

	public Gallery getGallery(long galleryId) {
		return galleryDao.getGallery(galleryId);
	}


}
