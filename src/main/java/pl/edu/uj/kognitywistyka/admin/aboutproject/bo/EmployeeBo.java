package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Employee;

public interface EmployeeBo {
	void addEmployee(Employee employee);
	void removeEmployee(Employee employee);
	void removeEmployee(long employeeId);
	List<Employee> findAllEmployees();

}
