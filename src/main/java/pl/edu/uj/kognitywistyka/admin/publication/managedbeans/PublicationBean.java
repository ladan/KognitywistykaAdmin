package pl.edu.uj.kognitywistyka.admin.publication.managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import pl.edu.uj.kognitywistyka.admin.publication.bo.PublicationBo;
import pl.edu.uj.kognitywistyka.admin.publication.bo.TagBo;
import pl.edu.uj.kognitywistyka.admin.publication.model.Publication;

@ManagedBean
@RequestScoped
public class PublicationBean implements Serializable {
	private static final long serialVersionUID = -5384767149041960776L;

	private long publicationId;
	private String title;
	private Date date;
	private String description;
	private UploadedFile uploadedDocument;
	private String author;
	private String tags;

	@ManagedProperty(name = "publicationBo", value = "#{publicationBo}")
	PublicationBo publicationBo;

	@ManagedProperty(name = "publicationBunchBean", value = "#{publicationBunchBean}")
	PublicationBunchBean publicationBunchBean;

	@ManagedProperty(name = "tagBo", value = "#{tagBo}")
	TagBo tagBo;

	public void setPublicationBunchBean(
			PublicationBunchBean publicationBunchBean) {
		this.publicationBunchBean = publicationBunchBean;
	}

	public void setTagBo(TagBo tagBo) {
		this.tagBo = tagBo;
	}

	public void setPublicationBo(PublicationBo publicationBo) {
		this.publicationBo = publicationBo;
	}

	@PostConstruct
	@SuppressWarnings("unused")
	private void init() {
		Map<String, String> requestMap = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String publicationId = requestMap.get("publicationid");
		if (publicationId != null && !publicationId.isEmpty())
			preinitializeBean(new Long(publicationId));
	}

	private void preinitializeBean(long publicationId) {
		Publication publication = publicationBo.getPublication(publicationId);
		if (publication != null) {
			this.publicationId = publication.getPublicationId();
			this.author = publication.getAuthor();
			this.date = publication.getDate();
			this.tags = publication.getTagsAsString();
			this.title = publication.getTitle();
			this.description = publication.getDescription();
		}
	}

	public long getPublicationId() {
		return publicationId;
	}

	public void setPublicationId(long publicationId) {
		this.publicationId = publicationId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public UploadedFile getUploadedDocument() {
		return uploadedDocument;
	}

	public void setUploadedDocument(UploadedFile uploadedDocument) {
		this.uploadedDocument = uploadedDocument;
	}

	public String addPublication() {
		Publication publication = new Publication();
		publication.setTitle(title);
		publication.setDate(date);
		publication.setAuthor(author);
		publication.setDescription(description);

		publicationBo.addPublication(publication, uploadedDocument, tags);

		resetView();
		return "";
	}
	
	public String removePublication(long publicationId) {
		publicationBo.removePublication(publicationId);
		resetView();
		return "";
	}

	public String removePublication(Publication publication) {
		publicationBo.removePublication(publication);
		resetView();
		return "";
	}
	private void resetView() {
		setDate(null);
		setTitle("");
		setAuthor("");
		setDescription("");
		publicationBunchBean.setAllPublications(null);
	}

}
