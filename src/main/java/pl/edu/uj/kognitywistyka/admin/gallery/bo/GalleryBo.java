package pl.edu.uj.kognitywistyka.admin.gallery.bo;

import java.util.List;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import pl.edu.uj.kognitywistyka.admin.gallery.model.Gallery;
import pl.edu.uj.kognitywistyka.admin.gallery.model.Photo;

public interface GalleryBo {

	void addGallery(Gallery gallery);

	Gallery getGallery(long galleryId);

	void removeGallery(long galleryId);
	
	void addPhoto(long galleryId, UploadedFile uploadedPhoto);
	
	void removePhoto(long galleryId, Photo photoID);

	List<Gallery> findAllGalleries();
}
