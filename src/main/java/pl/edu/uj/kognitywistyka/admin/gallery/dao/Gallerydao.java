package pl.edu.uj.kognitywistyka.admin.gallery.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.gallery.model.Gallery;

public interface Gallerydao {
	void addGallery(Gallery gallery);
	void removeGallery(Gallery gallery);
	List<Gallery> findAllGalleries();
	
}
