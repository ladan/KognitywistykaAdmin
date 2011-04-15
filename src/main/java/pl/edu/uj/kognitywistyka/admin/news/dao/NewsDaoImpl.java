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

	public News getNews(long id) {
		return (News) getHibernateTemplate().get(News.class, id);
	}

	public void updateNews(News news) {
		getHibernateTemplate().update(news);

	}

	public void removeNews(News news) {
		// TODO Ładan do roboty :P

	}

}
