package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Employee;

public interface EmployeeBo {
	void addEmployee(Employee employee);

	List<Employee> findAllEmployees();

}
