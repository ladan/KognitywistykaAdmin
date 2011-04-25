package pl.edu.uj.kognitywistyka.admin.gallery.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.admin.gallery.bo.GalleryBo;
import pl.edu.uj.kognitywistyka.admin.gallery.model.Gallery;

@ManagedBean
@RequestScoped
public class GalleryBunchBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Gallery> allGalleries;
	
	@ManagedProperty(name="galleryBo", value="#{galleryBo}")
	private GalleryBo galleryBo;
	
	public void setGalleryBo(GalleryBo galleryBo) {
		this.galleryBo = galleryBo;
	}
	
	public List<Gallery> getAllGalleries() {
		if(allGalleries == null)
			allGalleries = galleryBo.findAllGalleries();
		return allGalleries;
	}	
	public void setAllGalleries(List<Gallery> allGalleries) {
		this.allGalleries = allGalleries;
	}
}
