package pl.edu.uj.kognitywistyka.admin.aboutproject.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.AboutProject;

public interface AboutProjectDao {
	void addAboutDescription(AboutProject aboutProject);

	List<AboutProject> findAllAboutDescriptions();

	AboutProject findLatestAboutDescription();
}
