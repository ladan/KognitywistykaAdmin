package pl.edu.uj.kognitywistyka.admin.news.managedbeans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

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

	public String updateNews(News news) {
		newsBo.updateNews(news);

		resetView();
		return "";
	}

	private void resetView() {
		setTitle("");
		setContent("");
		setGallery(null);

		newsBunchBean.setAllNews(null);
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

}
