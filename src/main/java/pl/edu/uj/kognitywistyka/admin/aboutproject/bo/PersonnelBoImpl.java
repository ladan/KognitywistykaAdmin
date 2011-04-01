package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.dao.PersonnelDao;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Employee;

public class PersonnelBoImpl implements PersonnelBo, Serializable {
	private static final long serialVersionUID = 1621947279851464888L;

	PersonnelDao personnelDao;

	public void setPersonnelDao(PersonnelDao personnelDao) {
		this.personnelDao = personnelDao;
	}

	public void addEmployee(Employee employee) {
		personnelDao.addEmployee(employee);

	}

	public List<Employee> findAllEmployees() {
		return personnelDao.findAllEmployees();
	}

}
