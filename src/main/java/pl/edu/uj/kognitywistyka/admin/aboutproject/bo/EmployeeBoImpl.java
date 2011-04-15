package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.dao.EmployeeDao;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Employee;

public class EmployeeBoImpl implements EmployeeBo, Serializable {
	private static final long serialVersionUID = 1621947279851464888L;

	EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);

	}

	public List<Employee> findAllEmployees() {
		return employeeDao.findAllEmployees();
	}

	public void removeEmployee(Employee employee) {
		employeeDao.removeEmployee(employee);
		
		if(employee.getPhoto() != null) {
			removeEmployeeImg(employee.getPhoto());
		}
	}

	private void removeEmployeeImg(String photo) {
		if(!photo.isEmpty()) {
			File photoFile = new File(photo);
			if(photoFile.exists())
				photoFile.delete();
		}
	}

	public void removeEmployee(long employeeId) {
		for (Employee employee : findAllEmployees()) {
			if(employee.getEmployeeId() == employeeId)
				removeEmployee(employee);
		}
	}

}
