package pl.edu.uj.kognitywistyka.admin.publication.bo;

import java.io.Serializable;

import pl.edu.uj.kognitywistyka.admin.publication.dao.PublicationDao;

public class PublicationBoImpl implements PublicationBo, Serializable {
	private static final long serialVersionUID = 1L;
	PublicationDao publicationDao;

	public void setPublicationDao(PublicationDao publicationDao) {
		this.publicationDao = publicationDao;
	}
}
