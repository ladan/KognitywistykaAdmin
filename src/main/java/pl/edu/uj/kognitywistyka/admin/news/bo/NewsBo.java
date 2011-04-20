package pl.edu.uj.kognitywistyka.admin.news.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.news.model.News;

public interface NewsBo {
	void addNews(News news);
	void updateNews(News news);
	void removeNews(News news);
	void removeNews(long newsId);
	List<News> findAllNews();
	News getNews(long newsId);
}
