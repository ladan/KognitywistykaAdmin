package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.dao.LinkDao;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Link;

public class LinkBoImpl implements Serializable, LinkBo {

	private static final long serialVersionUID = 1L;
	LinkDao linkDao;
	
	public void setLinkDao(LinkDao linkDao) {
		this.linkDao = linkDao;
	}

	@Override
	public void addLink(Link link) {
		linkDao.addLink(link);
	}

	@Override
	public void updateLink(Link link) {
		linkDao.addLink(link);
	}

	@Override
	public void removeLink(Link link) {
		linkDao.removeLink(link);
	}

	@Override
	public void removeLink(long linkId) {
		for (Link link : findAllLinks()) {
			if(link.getLinkId() == linkId)
				removeLink(link);
		}
	}

	@Override
	public List<Link> findAllLinks() {
		return linkDao.findAllLinks();
	}
}
