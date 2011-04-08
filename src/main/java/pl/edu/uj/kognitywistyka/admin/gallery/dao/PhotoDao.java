package pl.edu.uj.kognitywistyka.admin.gallery.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.gallery.model.Photo;

public interface PhotoDao {

	void addPhoto(Photo photo);
	void removePhoto(Photo photo);
	List<Photo> findAllPhotos();
	
}
