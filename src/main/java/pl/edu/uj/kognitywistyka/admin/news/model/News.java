package pl.edu.uj.kognitywistyka.admin.news.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import pl.edu.uj.kognitywistyka.admin.gallery.model.Gallery;

public class News  implements java.io.Serializable {
	
	private static final long serialVersionUID = 5775487534886853918L;
	
	private long newsId;
	private String title;
	private Date date;
	private String content;
	private Gallery gallery;

	private SimpleDateFormat shortDateFormatter = new SimpleDateFormat("dd-MM-yyyy");
	
	public long getNewsId() {
		return newsId;
	}
	public void setNewsId(long newsId) {
		this.newsId = newsId;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Gallery getGallery() {
		return gallery;
	}
	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}
	
	public String getShortDate() {
		return shortDateFormatter.format(date);
	}
	
}