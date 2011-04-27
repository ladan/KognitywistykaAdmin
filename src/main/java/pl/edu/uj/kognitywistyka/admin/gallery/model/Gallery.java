package pl.edu.uj.kognitywistyka.admin.gallery.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gallery implements java.io.Serializable{

	private static final long serialVersionUID = -6299611150663205988L;

	private long galleryId;
	private String title;
	private Date date;
	private List<Photo> photos = new ArrayList<Photo>();

	private SimpleDateFormat shortDateFormatter = new SimpleDateFormat("dd-MM-yyyy");

	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public long getGalleryId() {
		return galleryId;
	}

	public void setGalleryId(long id) {
		galleryId = id;
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

	public String getShortDate() {
		return shortDateFormatter.format(date);
	}

}
