package pl.edu.uj.kognitywistyka.admin.aboutproject.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.admin.aboutproject.bo.PersonnelBo;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Employee;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Position;

@ManagedBean
@RequestScoped
public class PersonnelBean implements Serializable {
	private static final long serialVersionUID = 4241366958741596166L;

	// Dependency injection via Spring
	@ManagedProperty(name="personnelBo", value="#{personnelBo}")
	PersonnelBo personnelBo;

	private String name;
	private String surname;
	private String title;
	private String description;
	private Position position;
	private String photo;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setPersonnelBo(PersonnelBo personnelBo) {
		this.personnelBo = personnelBo;
	}

	public List<Employee> getAllEmployees() {
		return personnelBo.findAllEmployees();
	}
	
	public String addEmployee() {
		Employee employee = new Employee();
		employee.setName(name);
		employee.setSurname(surname);
		employee.setDescription(description);
		employee.setPhoto(photo);
		employee.setPosition(position);
		employee.setTitle(title);
		
		personnelBo.addEmployee(employee);
		
		clearForm();
		return "";
	}

	private void clearForm() {
		setDescription("");
		setName("");
		setSurname("");
		setPhoto("");
		setPosition(new Position());
		setTitle("");
		
	}
	

}
