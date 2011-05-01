package pl.edu.uj.kognitywistyka.admin.publication.dao;

import java.util.List;
import pl.edu.uj.kognitywistyka.admin.publication.model.Publication;

public interface PublicationDao {

	void addPublication(Publication publication);
	List<Publication> findAllPublication();
	Publication getPublication(long id);
	void updatePublication(Publication publication);
	void removePublication(Publication publication);
	
}
