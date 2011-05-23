package pl.edu.uj.kognitywistyka.admin.publication.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.admin.publication.bo.PublicationBo;
import pl.edu.uj.kognitywistyka.admin.publication.model.Publication;


@ManagedBean
@RequestScoped
public class PublicationBunchBean {
	
	private static final long serialVersionUID = 1L;
	private List<Publication> allPublications;
	
	@ManagedProperty(name="publicationBo", value="#{publicationBo}")
	private PublicationBo publicationBo;
	
	public void setPublicationBo(PublicationBo publicationBo) {
		this.publicationBo = publicationBo;
	}
	
	public List<Publication> getAllPublications() {
		if(allPublications == null)
			allPublications = publicationBo.findAlPublications();
		return allPublications;
	}	
	public void setAllPublications(List<Publication> allPublications) {
		this.allPublications = allPublications;
	}

}
