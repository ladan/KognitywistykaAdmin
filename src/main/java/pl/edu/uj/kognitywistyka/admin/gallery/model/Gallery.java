package pl.edu.uj.kognitywistyka.admin.gallery.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gallery implements java.io.Serializable {

	private static final long serialVersionUID = -6299611150663205988L;

	private long galleryId;
	private String title;
	private Date date;

	private List<Photo> photos = new ArrayList<Photo>();

	private SimpleDateFormat shortDateFormatter = new SimpleDateFormat(
			"dd-MM-yyyy");

	public long getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(long galleryId) {
		this.galleryId = galleryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public void addPhoto(Photo photo) {
		photos.add(photo);
	}


	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public SimpleDateFormat getShortDateFormatter() {
		return shortDateFormatter;
	}

	public void setShortDateFormatter(SimpleDateFormat shortDateFormatter) {
		this.shortDateFormatter = shortDateFormatter;
	}

}
