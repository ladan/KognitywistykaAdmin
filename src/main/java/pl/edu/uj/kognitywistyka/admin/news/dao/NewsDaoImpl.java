package pl.edu.uj.kognitywistyka.admin.news.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.admin.news.model.News;

public class NewsDaoImpl extends HibernateDaoSupport implements NewsDao {

	public void addNews(News news) {
		getHibernateTemplate().save(news);
		
	}

	@SuppressWarnings("unchecked")
	public List<News> findAllNews() {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(3);
		return ht.find("from News order by date desc");
	}

	public News getNews(News news) {
		return (News) getHibernateTemplate().get(News.class, news.getNewsId());
	}

	public void updateNews(News news) {
		getHibernateTemplate().update(news);
		
	}

}
