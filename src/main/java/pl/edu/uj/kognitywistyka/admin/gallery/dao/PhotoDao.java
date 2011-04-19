package pl.edu.uj.kognitywistyka.admin.gallery.dao;

import pl.edu.uj.kognitywistyka.admin.gallery.model.Photo;

public interface PhotoDao {

	void addPhoto(Photo photo);
	void removePhoto(Photo photo);
	Photo getPhoto(long id);
}
