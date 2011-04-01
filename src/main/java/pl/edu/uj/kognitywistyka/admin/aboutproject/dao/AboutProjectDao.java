package pl.edu.uj.kognitywistyka.admin.aboutproject.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.AboutProject;

public interface AboutProjectDao {
	void addAboutProject(AboutProject aboutProject);

	List<AboutProject> findAllAboutProjects();

	AboutProject findLatestAboutProject();
}
