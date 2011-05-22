package pl.edu.uj.kognitywistyka.admin.publication.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.publication.model.Publication;

public interface PublicationBo {
	void addPublication(Publication publication);

	void updatePublication(Publication publication);

	void removePublication(Publication publication);

	void removePublication(long publicationId);

	List<Publication> findAlPublications();

	Publication getPublication(long publicationId);
}
