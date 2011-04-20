package pl.edu.uj.kognitywistyka.admin.news.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.admin.news.dao.NewsDao;
import pl.edu.uj.kognitywistyka.admin.news.model.News;

public class NewsBoImpl implements NewsBo, Serializable {
	private static final long serialVersionUID = 1L;
	NewsDao newsDao;

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	public void addNews(News news) {
		newsDao.addNews(news);

	}

	public void updateNews(News news) {
		newsDao.updateNews(news);

	}

	public void removeNews(News news) {
		newsDao.removeNews(news);

	}

	public void removeNews(long newsId) {
		for (News news : findAllNews()) {
			if(news.getNewsId() == newsId)
				removeNews(news);
		}

	}

	public List<News> findAllNews() {
		return newsDao.findAllNews();
	}

	@Override
	public News getNews(long newsId) {
		return newsDao.getNews(newsId);
	}

}
