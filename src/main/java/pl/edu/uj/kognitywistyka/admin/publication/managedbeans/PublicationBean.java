package pl.edu.uj.kognitywistyka.admin.publication.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pl.edu.uj.kognitywistyka.admin.aboutproject.bo.EmployeeBo;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Employee;
import pl.edu.uj.kognitywistyka.admin.publication.bo.PublicationBo;

@ManagedBean
@SessionScoped
public class PublicationBean implements Serializable
{
	private static final long serialVersionUID = -5384767149041960776L;
	private String name;
	private String date;
	private String tags;
	private String description;
	
	@ManagedProperty(name="publicationBo", value="#{publicationBo}")
	PublicationBo publicationBo;
	
	@ManagedProperty(name="employeeBo", value="#{employeeBo}")
	EmployeeBo employeeBo;
	
	private List<Employee> allAuthors;
	
	public List<Employee> getAllAuthors()
	{
		if(allAuthors == null)
		{
			allAuthors = employeeBo.findAllEmployees();
		}
		return allAuthors;
	}
	
	public void setAllAuthors(List<Employee> authors)
	{
		this.allAuthors = authors;
	}
	
	public void setEmployeeBo(EmployeeBo employeeBo)
	{
		this.employeeBo = employeeBo;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setPublicationBo(PublicationBo publicationBo)
	{
		this.publicationBo = publicationBo;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public String getTags()
	{
		return tags;
	}
	
	public void setTags(String tags)
	{
		this.tags = tags;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
}

