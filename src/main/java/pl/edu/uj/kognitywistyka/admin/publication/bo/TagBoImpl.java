package pl.edu.uj.kognitywistyka.admin.publication.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.admin.publication.dao.TagDao;
import pl.edu.uj.kognitywistyka.admin.publication.model.Tag;

public class TagBoImpl implements Serializable, TagBo {

	private static final long serialVersionUID = 1L;
	TagDao tagDao;

	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}

	public void addTag(Tag tag) {
		tagDao.addTag(tag);
	}

	public void removeTag(Tag tag) {
		tagDao.removeTag(tag);
	}

	public Tag getTag(long tagId) {
		return tagDao.getTag(tagId);
	}

	public List<Tag> getAllTags() {
		return tagDao.findAllTags();
	}

	public List<Tag> getTagsForPublication(long publicationId) {
		return tagDao.getTagsForPublication(publicationId);
	}

}
