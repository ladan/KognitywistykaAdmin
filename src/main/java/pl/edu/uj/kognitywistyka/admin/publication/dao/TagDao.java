package pl.edu.uj.kognitywistyka.admin.publication.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.publication.model.Tag;

public interface TagDao {
	void addTag(Tag tag);

	void removeTag(Tag tag);

	Tag getTag(long tagId);

	List<Tag> findAllTags();
	
	List<Tag> getTagsForPublication(long publicationId);
	
}
