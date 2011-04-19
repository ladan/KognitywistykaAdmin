package pl.edu.uj.kognitywistyka.admin.aboutproject.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Employee;

public interface EmployeeDao {
	void addEmployee(Employee employee);
	void removeEmployee(Employee employee);
	void updateEmployee(Employee employee);
	List<Employee> findAllEmployees();
	Employee getEmployee(long id);
}
