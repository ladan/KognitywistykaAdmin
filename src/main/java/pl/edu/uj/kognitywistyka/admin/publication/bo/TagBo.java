package pl.edu.uj.kognitywistyka.admin.publication.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.publication.model.Tag;

public interface TagBo {
	void addTag(Tag tag);

	void removeTag(Tag tag);

	Tag getTag(long tagId);
	
	List<Tag> getTagsForPublication(long publicationId);
	
	List<Tag> getAllTags();
}
