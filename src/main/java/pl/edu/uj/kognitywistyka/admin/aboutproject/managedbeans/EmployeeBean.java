package pl.edu.uj.kognitywistyka.admin.aboutproject.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.admin.aboutproject.bo.EmployeeBo;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Employee;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Position;

@ManagedBean
@RequestScoped
public class EmployeeBean implements Serializable {
	private static final long serialVersionUID = 4241366958741596166L;

	// Dependency injection via Spring
	@ManagedProperty(name="employeeBo", value="#{employeeBo}")
	EmployeeBo employeeBo;
	@ManagedProperty(name="positionListBean", value="#{positionListBean}")
	PositionListBean positionListBean;
	
	private String name;
	private String surname;
	private String title;
	private String description;
	private Position position;
	private long positionId;
	private String photo;

	public void setPositionListBean(PositionListBean positionListBean) {
		this.positionListBean = positionListBean;
	}
	
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

	public void setEmployeeBo(EmployeeBo employeeBo) {
		this.employeeBo = employeeBo;
	}

	public List<Employee> getAllEmployees() {
		return employeeBo.findAllEmployees();
	}
	

	public void setPositionId(long positionId) {
		this.positionId = positionId;
	}

	public long getPositionId() {
		return positionId;
	}
	
	public String addEmployee() {
		Employee employee = new Employee();
		employee.setFirstName(name);
		employee.setLastName(surname);
		employee.setDescription(description);
		employee.setPosition(getRightPosition());
		employee.setTitle(title);
		//Nie dodajemy zdjęcia - bedzie można zrobić to później
		
		employeeBo.addEmployee(employee);
		
		clearForm();
		return "";
	}

	private Position getRightPosition() {
		for (Position position : positionListBean.getAllPositions()) {
			if(position.getPositionId() == positionId) return position;
		}
		return null;
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
