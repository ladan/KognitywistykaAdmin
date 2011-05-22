package pl.edu.uj.kognitywistyka.admin.publication.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.admin.publication.dao.PublicationDao;
import pl.edu.uj.kognitywistyka.admin.publication.model.Publication;

public class PublicationBoImpl implements PublicationBo, Serializable {
	private static final long serialVersionUID = 1L;
	PublicationDao publicationDao;

	public void setPublicationDao(PublicationDao publicationDao) {
		this.publicationDao = publicationDao;
	}

	public void addPublication(Publication publication) {
		// TODO Auto-generated method stub
		
	}

	public void updatePublication(Publication publication) {
		// TODO Auto-generated method stub
		
	}

	public void removePublication(Publication publication) {
		// TODO Auto-generated method stub
		
	}

	public void removePublication(long publicationId) {
		// TODO Auto-generated method stub
		
	}

	public List<Publication> findAlPublications() {
		// TODO Auto-generated method stub
		return null;
	}

	public Publication getPublication(long publicationId) {
		// TODO Auto-generated method stub
		return null;
	}
}
