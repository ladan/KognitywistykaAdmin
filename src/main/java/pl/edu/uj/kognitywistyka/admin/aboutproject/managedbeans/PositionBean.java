package pl.edu.uj.kognitywistyka.admin.aboutproject.managedbeans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Employee;

@ManagedBean
@ViewScoped
public class PositionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private Set<Employee> employees = new HashSet<Employee>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
