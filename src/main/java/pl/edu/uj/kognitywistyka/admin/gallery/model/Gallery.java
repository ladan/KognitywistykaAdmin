package pl.edu.uj.kognitywistyka.admin.gallery.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Gallery implements java.io.Serializable{
	
	private static final long serialVersionUID = -6299611150663205988L;
	
	private long galleryId;
	private String title;
	private Date date;
	private Set<Photo> photos = new HashSet<Photo>();
	
	
	public Set<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(Set<Photo> photos) {
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
	
	
	
}
