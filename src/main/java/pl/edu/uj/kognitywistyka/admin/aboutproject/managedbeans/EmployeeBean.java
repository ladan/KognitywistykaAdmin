package pl.edu.uj.kognitywistyka.admin.aboutproject.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import pl.edu.uj.kognitywistyka.admin.aboutproject.bo.EmployeeBo;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Employee;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Position;

@ManagedBean
@RequestScoped
public class EmployeeBean implements Serializable {
	private static final long serialVersionUID = 4241366958741596166L;

	// Dependency injection via Spring
	@ManagedProperty(name = "employeeBo", value = "#{employeeBo}")
	EmployeeBo employeeBo;
	@ManagedProperty(name = "positionBunchBean", value = "#{positionBunchBean}")
	PositionBunchBean positionBunchBean;

	private String name;
	private String surname;
	private String title;
	private String description;
	private Position position;
	private long positionId;
	private UploadedFile uploadedFile;

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Position getPosition() {
		return position;
	}

	public List<Employee> getAllEmployees() {
		return employeeBo.findAllEmployees();
	}

	public long getPositionId() {
		return positionId;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setPositionBunchBean(PositionBunchBean positionBunchBean) {
		this.positionBunchBean = positionBunchBean;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setEmployeeBo(EmployeeBo employeeBo) {
		this.employeeBo = employeeBo;
	}

	public void setPositionId(long positionId) {
		this.positionId = positionId;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public String addEmployee() {
		Employee employee = new Employee();
		employee.setFirstName(name);
		employee.setLastName(surname);
		employee.setDescription(description);
		employee.setPosition(getRightPosition());
		employee.setTitle(title);
		if (uploadedFile == null)
			employeeBo.addEmployee(employee);
		else
			employeeBo.addEmployee(employee, uploadedFile);

		resetView();
		return "";
	}

	private Position getRightPosition() {
		for (Position position : positionBunchBean.getAllPositions()) {
			if (position.getPositionId() == positionId)
				return position;
		}
		return null;
	}

	public String removeEmployee(long employeeId) {
		employeeBo.removeEmployee(employeeId);

		resetView();
		return "";
	}

	private void resetView() {
		setDescription("");
		setName("");
		setSurname("");
		setPosition(new Position());
		setTitle("");

		setUploadedFile(null);
		positionBunchBean.setAllPositions(null);
	}

}
