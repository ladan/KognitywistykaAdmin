package pl.edu.uj.kognitywistyka.admin.aboutproject.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Employee;


public class EmployeeDaoImpl extends HibernateDaoSupport 
	implements EmployeeDao{

	public void addEmployee(Employee employee) {
		getHibernateTemplate().save(employee);
		
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		return getHibernateTemplate().find("from Employee order by lastName asc");
	}

	public void removeEmployee(Employee employee) {
		getHibernateTemplate().delete(employee);
		
	}

	public void updateEmployee(Employee employee) {
		getHibernateTemplate().update(employee);
		
	}
	
}