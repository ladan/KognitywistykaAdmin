package pl.edu.uj.kognitywistyka.admin.gallery.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
	private UploadedFile uploadedPhoto;
	
	@ManagedProperty(name = "galleryBo", value = "#{galleryBo}")
	private GalleryBo galleryBo;
	@ManagedProperty(name = "galleryBunchBean", value = "#{galleryBunchBean}")
	private GalleryBunchBean galleryBunchBean;

	@PostConstruct
	@SuppressWarnings("unused")
	private void init() {
		Map<String, String> requestMap = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String galleryId = requestMap.get("galleryid");
		if (galleryId != null && !galleryId.isEmpty())
			preinitializeBean(new Long(galleryId));
		
	}

	private void preinitializeBean(long galleryId) {
		Gallery gallery = galleryBo.getGallery(galleryId);
		if (gallery != null) {
			this.galleryId = gallery.getGalleryId();
			this.title = gallery.getTitle();
			this.date = gallery.getDate();
			this.photos = gallery.getPhotos();
		}
		
	}

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

	public void setUploadedPhoto(UploadedFile uploadedPhoto) {
		this.uploadedPhoto = uploadedPhoto;
	}
	
	public UploadedFile getUploadedPhoto() {
		return uploadedPhoto;
	}
	
	public String addGallery() {
		Gallery gallery = new Gallery();
		gallery.setTitle(title);
		gallery.setDate(date);

		galleryBo.addGallery(gallery);

		resetView();
		return "";
	
	}

	public String addPhoto() {
		galleryBo.addPhoto(galleryId, uploadedPhoto);
		resetView();
		return "";
	}

	public String removePhoto(Photo photo) {
		if (photos.contains(photo))
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
		setUploadedPhoto(null);
		galleryBunchBean.setAllGalleries(null);
	}

}
