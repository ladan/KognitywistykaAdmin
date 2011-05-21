package pl.edu.uj.kognitywistyka.admin.gallery.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.gallery.model.Gallery;

public interface GalleryBo {

	void addGallery(Gallery gallery);

	Gallery getGallery(long galleryId);

	void removeGallery(long galleryId);
	
	List<Gallery> findAllGalleries();
	
}
