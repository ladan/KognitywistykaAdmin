package pl.edu.uj.kognitywistyka.admin.aboutproject.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AboutProject implements java.io.Serializable {
	
	private static final long serialVersionUID = -7861350928516109979L;

	private long aboutProjectId;
	private String description;
	private Date date;
	
	private SimpleDateFormat shortDateFormatter = new SimpleDateFormat("dd-mm-yyyy");
	
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

	public SimpleDateFormat getShortDateFormatter() {
		return shortDateFormatter;
	}
	
	

}