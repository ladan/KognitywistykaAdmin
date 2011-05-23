package pl.edu.uj.kognitywistyka.admin.publication.bo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import pl.edu.uj.kognitywistyka.admin.publication.dao.PublicationDao;
import pl.edu.uj.kognitywistyka.admin.publication.model.Publication;
import pl.edu.uj.kognitywistyka.admin.publication.model.Tag;
import pl.edu.uj.kognitywistyka.admin.util.PropertiesReader;

public class PublicationBoImpl implements PublicationBo, Serializable {
	private static final long serialVersionUID = 1L;
	PublicationDao publicationDao;

	public void setPublicationDao(PublicationDao publicationDao) {
		this.publicationDao = publicationDao;
	}

	public void addPublication(Publication publication,
			UploadedFile uploadedDocument, String tags) {
		
		publication.setFileName(serveDocument(uploadedDocument));
		
		Set<Tag> workingSet = new HashSet<Tag>(0);
		for(String i : tags.split(", "))
		{
			Tag tag = new Tag();
			tag.setTitle(i);
			workingSet.add(tag);
		}
		publicationDao.addPublication(publication);
		publicationDao.addTagsToPublication(workingSet, publication);
	}

	public void updatePublication(Publication publication) {
		publicationDao.updatePublication(publication);

	}

	public void removePublication(Publication publication) {
		publicationDao.removePublication(publication);

	}

	public void removePublication(long publicationId) {
		publicationDao.removePublication(publicationId);
	}

	public List<Publication> findAlPublications() {
		return publicationDao.findAllPublication();
	}

	public Publication getPublication(long publicationId) {
		return publicationDao.getPublication(publicationId);
	}

	private String serveDocument(UploadedFile uploadedDocument) {
		try {

			String filename = System.currentTimeMillis()
					+ uploadedDocument.getName();

			File destFile = new File(
					PropertiesReader.getPathToStoreFile()
							+ PropertiesReader
									.getPropertyOfGallery("pathToPublication")
							+ filename);

			FileOutputStream fop = new FileOutputStream(destFile);
			fop.write(uploadedDocument.getBytes());
			fop.flush();
			fop.close();

			return filename;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
