package pl.edu.uj.kognitywistyka.admin.publication.model;

import java.io.Serializable;
import java.util.List;

public class Tag implements Serializable{

	private static final long serialVersionUID = -2954967692725423866L;
	private long tagId;
	private String title;
	private List<Publication> publications;
	public long getTagId() {
		return tagId;
	}
	public void setTagId(long tagId) {
		this.tagId = tagId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Publication> getPublications() {
		return publications;
	}
	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	

	
}
