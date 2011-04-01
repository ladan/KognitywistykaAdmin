package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.dao.EmployeeDao;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Employee;

public class EmployeeBoImpl implements EmployeeBo, Serializable {
	private static final long serialVersionUID = 1621947279851464888L;

	EmployeeDao employeeDao;

	public void setPersonnelDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);

	}

	public List<Employee> findAllEmployees() {
		return employeeDao.findAllEmployees();
	}

}
