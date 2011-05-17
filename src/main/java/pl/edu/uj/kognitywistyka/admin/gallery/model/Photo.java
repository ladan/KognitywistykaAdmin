package pl.edu.uj.kognitywistyka.admin.gallery.model;

public class Photo implements java.io.Serializable {

	private static final long serialVersionUID = 8302357814622197596L;

	private long photoId;
	private String photo;
	private long galleryId;

	public long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(long photoId) {
		this.photoId = photoId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public long getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(long galleryId) {
		this.galleryId = galleryId;
	}

}