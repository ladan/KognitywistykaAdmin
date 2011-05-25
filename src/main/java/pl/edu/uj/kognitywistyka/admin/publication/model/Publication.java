package pl.edu.uj.kognitywistyka.admin.publication.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Publication implements Serializable {

	private static final long serialVersionUID = -2954967692725423866L;

	private long publicationId;
	private String title;
	private Date date;
	private String description;
	private String fileName;
	private String author;
	private Set<Tag> tags = new HashSet<Tag>(0);

	private SimpleDateFormat shortDateFormatter = new SimpleDateFormat(
			"dd-MM-yyyy");

	public void setPublicationId(long publicationId) {
		this.publicationId = publicationId;
	}

	public long getPublicationId() {
		return publicationId;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getShortDate() {
		return shortDateFormatter.format(date);
	}

	public Set<Tag> getTags() {
		return tags;
	}
	
	public List<Tag> getTagsAsList() {
		return new ArrayList<Tag>(tags);
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}



}
