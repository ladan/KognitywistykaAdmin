package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.util.List;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Employee;

public interface EmployeeBo {
	void addEmployee(Employee employee);
	void addEmployee(Employee employee, UploadedFile uploadedFile);
	void removeEmployee(Employee employee);
	void removeEmployee(long employeeId);
	List<Employee> findAllEmployees();

}
