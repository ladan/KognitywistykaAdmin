package pl.edu.uj.kognitywistyka.admin.news.managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import pl.edu.uj.kognitywistyka.admin.gallery.model.Gallery;
import pl.edu.uj.kognitywistyka.admin.news.bo.NewsBo;
import pl.edu.uj.kognitywistyka.admin.news.model.News;

@ManagedBean
@RequestScoped
public class NewsBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private long newsId;
	private String title;
	private Date date;
	private String content;
	private Gallery gallery;

	// Dependency injection
	@ManagedProperty(name = "newsBo", value = "#{newsBo}")
	private NewsBo newsBo;
	@ManagedProperty(name = "newsBunchBean", value = "#{newsBunchBean}")
	private NewsBunchBean newsBunchBean;
	
	@PostConstruct
	@SuppressWarnings("unused")
	private void init() {
		Map<String, String> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String newsId = requestMap.get("newsid");
		if(newsId != null)
			preinitializeBean(new Long(newsId));
	}
	
	private void preinitializeBean(long linkId) {
		News news = newsBo.getNews(linkId);
		if(news != null) {
			this.newsId = news.getNewsId();
			this.title = news.getTitle();
			this.date = news.getDate();
			this.gallery = news.getGallery();
			this.content = news.getContent();
		}
	}

	public void setNewsBo(NewsBo newsBo) {
		this.newsBo = newsBo;
	}

	public void setNewsBunchBean(NewsBunchBean newsBunchBean) {
		this.newsBunchBean = newsBunchBean;
	}

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
	
	public String addNews() {
		News news = new News();
		news.setTitle(title);
		news.setContent(content);
		news.setDate(new Date());
		if(gallery != null)
			news.setGallery(gallery);

		newsBo.addNews(news);
		resetView();

		return "";
	}

	public String removeNews(long newsId) {
		newsBo.removeNews(newsId);

		resetView();
		return "";
	}

	public String updateNews() {
		News news = new News();
		news.setNewsId(newsId);
		news.setTitle(title);
		news.setContent(content);
		news.setDate(new Date());
		news.setGallery(gallery);
		
		System.out.println(newsId + " " + title);
		
		newsBo.updateNews(news);

		resetView();
		return "success";
	}

	private void resetView() {
		setNewsId(0);
		setTitle("");
		setContent("");
		setGallery(null);

		newsBunchBean.setAllNews(null);
	}

}
