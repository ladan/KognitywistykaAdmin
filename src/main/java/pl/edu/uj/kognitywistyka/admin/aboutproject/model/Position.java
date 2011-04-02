package pl.edu.uj.kognitywistyka.admin.aboutproject.model;

import java.util.HashSet;
import java.util.Set;

public class Position {
	private long positionId;
	private String name;
	private Set<Employee> employees = new HashSet<Employee>();

	public long getPositionId() {
		return positionId;
	}

	public void setPositionId(long postionId) {
		this.positionId = postionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

}