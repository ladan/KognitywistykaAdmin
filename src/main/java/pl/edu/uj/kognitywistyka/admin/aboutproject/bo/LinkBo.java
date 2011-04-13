package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Link;

public interface LinkBo {
	void addLink(Link link);
	void updateLink(Link link);
	void removeLink(Link link);
	void removeLink(long linkId);
	List<Link> findAllLinks();
}
