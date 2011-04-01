package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.AboutProject;

public interface AboutProjectBo{
	void addAboutProject(AboutProject aboutProject);

	List<AboutProject> findAllAboutProjects();

	AboutProject findLatestAboutProject();
}
