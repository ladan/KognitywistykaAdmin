package pl.edu.uj.kognitywistyka.admin.gallery.bo;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import pl.edu.uj.kognitywistyka.admin.gallery.model.Photo;

public interface PhotoBo {
	
	void addPhoto(Photo photo, UploadedFile uploadedPhoto);

	void removePhoto(Photo photo);
	

}
