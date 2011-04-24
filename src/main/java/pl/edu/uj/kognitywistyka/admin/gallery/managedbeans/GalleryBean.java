package pl.edu.uj.kognitywistyka.admin.gallery.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import pl.edu.uj.kognitywistyka.admin.gallery.bo.GalleryBo;
import pl.edu.uj.kognitywistyka.admin.gallery.model.Gallery;
import pl.edu.uj.kognitywistyka.admin.gallery.model.Photo;

@ManagedBean
@RequestScoped
public class GalleryBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private long galleryId;
	private String title;
	private Date date;
	private List<Photo> photos = new ArrayList<Photo>();
	private UploadedFile uploadedFile;

	@ManagedProperty(name = "galleryBo", value = "#{galleryBo}")
	GalleryBo galleryBo;
	@ManagedProperty(name = "galleryBunchBean", value = "#{galleryBunchBean}")
	GalleryBunchBean galleryBunchBean;
	
	public void setGalleryBo(GalleryBo galleryBo) {
		this.galleryBo = galleryBo;
	}

	public void setGalleryBunchBean(GalleryBunchBean galleryBunchBean) {
		this.galleryBunchBean = galleryBunchBean;
	}
	
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

	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
	public String addGallery() {
		Gallery gallery = new Gallery();
		gallery.setTitle(title);
		gallery.setDate(date);
		
		galleryBo.addGallery(gallery);
		
		resetView();
		return "";
	}

	public String addPhoto(UploadedFile uploadedFile) {
		galleryBo.addPhoto(galleryId, uploadedFile);
		resetView();
		return "";
	}

	public String removePhoto(Photo photo) {
		if(photos.contains(photo))
			galleryBo.removePhoto(galleryId, photo);
		resetView();
		return "";
	}
	
	public String removeGallery(long galleryId) {
		galleryBo.removeGallery(galleryId);
		resetView();
		return "";
	}	
	public String removeGallery(Gallery gallery) {
		galleryBo.removeGallery(gallery.getGalleryId());
		resetView();
		return "";
	}

	private void resetView() {
		setDate(null);
		setTitle("");
		galleryBunchBean.setAllGalleries(null);
	}

}
