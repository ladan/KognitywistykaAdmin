package pl.edu.uj.kognitywistyka.admin.publication.dao;

import java.util.List;
import java.util.Set;

import pl.edu.uj.kognitywistyka.admin.publication.model.Publication;
import pl.edu.uj.kognitywistyka.admin.publication.model.Tag;

public interface PublicationDao {

	void addPublication(Publication publication);

	List<Publication> findAllPublication();

	Publication getPublication(long id);

	void updatePublication(Publication publication);

	void removePublication(Publication publication);
	
	void removePublication(long publicationId);
	
	void addPublicationWithTags(Publication publication, Set<Tag> tags);

}
