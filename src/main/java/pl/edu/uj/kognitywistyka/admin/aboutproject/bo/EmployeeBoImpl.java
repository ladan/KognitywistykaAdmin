package pl.edu.uj.kognitywistyka.admin.aboutproject.bo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import pl.edu.uj.kognitywistyka.admin.aboutproject.dao.EmployeeDao;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Employee;
import pl.edu.uj.kognitywistyka.admin.util.ImageConverter;
import pl.edu.uj.kognitywistyka.admin.util.PropertiesReader;

public class EmployeeBoImpl implements EmployeeBo, Serializable {
	private static final long serialVersionUID = 1621947279851464888L;

	EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);

	}

	public List<Employee> findAllEmployees() {
		return employeeDao.findAllEmployees();
	}

	public void removeEmployee(Employee employee) {
		employeeDao.removeEmployee(employee);

		if (employee.getPhoto() != null) {
			removeEmployeeImg(employee.getPhoto());
		}
	}

	private void removeEmployeeImg(String photo) {
		if (!photo.isEmpty()) {
			File photoFile = new File(photo);
			if (photoFile.exists())
				photoFile.delete();
		}
	}

	public void removeEmployee(long employeeId) {
		for (Employee employee : findAllEmployees()) {
			if (employee.getEmployeeId() == employeeId)
				removeEmployee(employee);
		}
	}

	public void addEmployee(Employee employee, UploadedFile uploadedFile) {
		employee.setPhoto(serveImage(uploadedFile));
		employeeDao.addEmployee(employee);
	}

	private String serveImage(UploadedFile uploadedFile) {
		try {

			String filename = System.currentTimeMillis()
					+ uploadedFile.getName();

			File destFile = new File(
					PropertiesReader.getPropertyOfFile("pathToEmployeeImg")
							+ filename);
			BufferedImage imageBuffer = ImageIO.read(uploadedFile
					.getInputStream());

			imageBuffer = ImageConverter.resize(imageBuffer, Integer
					.parseInt(PropertiesReader
							.getPropertyOfFile("heightOfEmployeeImg")), Integer
					.parseInt(PropertiesReader
							.getPropertyOfFile("widthOfEmployeeImg")));
			ImageIO.write(imageBuffer, ImageConverter.getFormat(filename)
					.toString(), destFile);

			return filename;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
