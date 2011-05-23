package pl.edu.uj.kognitywistyka.admin.publication.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Tag implements Serializable {

	private static final long serialVersionUID = -2954967692725423866L;
	private long tagId;
	private String title;
	private Set<Publication> publications = new HashSet<Publication>(0);

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

	public Set<Publication> getPublications() {
		return publications;
	}

	public void setPublications(Set<Publication> publications) {
		this.publications = publications;
	}

	@Override
	public String toString() {
		return title;
	}
	
	

}
