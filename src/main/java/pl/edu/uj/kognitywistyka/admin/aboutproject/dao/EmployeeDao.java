package pl.edu.uj.kognitywistyka.admin.aboutproject.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Employee;

public interface EmployeeDao {
	void addEmployee(Employee employee);

	List<Employee> findAllEmployees();

}
