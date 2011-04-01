package pl.edu.uj.kognitywistyka.admin.aboutproject.model;

import java.util.Date;

public class AboutProject {
	private long aboutProjectId;
	private String description;
	private Date date;

	public long getAboutProjectId() {
		return aboutProjectId;
	}

	public void setAboutProjectId(long aboutProjectId) {
		this.aboutProjectId = aboutProjectId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}