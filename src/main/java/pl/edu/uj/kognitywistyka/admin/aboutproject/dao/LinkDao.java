package pl.edu.uj.kognitywistyka.admin.aboutproject.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Link;

public interface LinkDao {
	void addLink(Link link);
	void removeLink(Link link);
	void updateLink(Link link);
	List<Link> findAllLinks();
	Link getLink(long id);
}
