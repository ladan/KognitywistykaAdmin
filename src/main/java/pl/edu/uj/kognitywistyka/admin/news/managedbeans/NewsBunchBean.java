package pl.edu.uj.kognitywistyka.admin.news.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.admin.news.bo.NewsBo;
import pl.edu.uj.kognitywistyka.admin.news.model.News;

@ManagedBean
@RequestScoped
public class NewsBunchBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<News> allNews;

	@ManagedProperty(name = "newsBo", value = "#{newsBo}")
	private NewsBo newsBo;

	public void setNewsBo(NewsBo newsBo) {
		this.newsBo = newsBo;
	}

	public void setAllNews(List<News> allNews) {
		this.allNews = allNews;
	}

	public List<News> getAllNews() {
		if (allNews == null)
			allNews = newsBo.findAllNews();
		return allNews;
	}

}
