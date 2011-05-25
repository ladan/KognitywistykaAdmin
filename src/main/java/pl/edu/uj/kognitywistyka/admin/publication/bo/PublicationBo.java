package pl.edu.uj.kognitywistyka.admin.publication.bo;

import java.util.List;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import pl.edu.uj.kognitywistyka.admin.publication.model.Publication;

public interface PublicationBo {
	void addPublication(Publication publication, UploadedFile uploadedDocument, String tags);

	void updatePublication(Publication publication, UploadedFile uploadedDocument, String tags);

	void removePublication(Publication publication);

	void removePublication(long publicationId);

	List<Publication> findAlPublications();

	Publication getPublication(long publicationId);
}
