package pl.edu.uj.kognitywistyka.admin.publication.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Publication implements Serializable{

	private static final long serialVersionUID = -2954967692725423866L;
	private long publicationId;
	private String title;
	private Date date;
	private String description;
	private String fileName;
	private SimpleDateFormat shortDateFormatter = new SimpleDateFormat("dd-MM-yyyy");
	
	
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getShortDate() {
		return shortDateFormatter.format(date);
	}
	

	
}
