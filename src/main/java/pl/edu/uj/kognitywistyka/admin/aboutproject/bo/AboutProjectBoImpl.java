package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.dao.AboutProjectDao;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.AboutProject;

public class AboutProjectBoImpl implements AboutProjectBo, Serializable {

	private static final long serialVersionUID = 7538869973656457774L;
	
	AboutProjectDao aboutProjectDao;
	
	public void setAboutProjectDao(AboutProjectDao aboutProjectDao) {
		this.aboutProjectDao = aboutProjectDao;
	}
	
	public void addAboutDescription(AboutProject aboutProject) {
		//Datę zapisujemy tutaj, bo w przypadku opisu "O projekcie" ma ona znaczenie tylko
		//przy sortowaniu względem czasu
		aboutProject.setDate(new Date());
		aboutProjectDao.addAboutDescription(aboutProject);
	}

	public List<AboutProject> findAllAboutDescriptions() {
		return aboutProjectDao.findAllAboutDescriptions();
	}

	public AboutProject findLatestAboutDescription() {
		return aboutProjectDao.findLatestAboutDescription();
	}

}
