package pl.edu.uj.kognitywistyka.admin.publication.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Employee;
import pl.edu.uj.kognitywistyka.admin.publication.bo.PublicationBo;
import pl.edu.uj.kognitywistyka.admin.aboutproject.bo.EmployeeBo;

@ManagedBean
@SessionScoped
public class PublicationBean implements Serializable
{
	private static final long serialVersionUID = -5384767149041960776L;
	private String name;
	private String date;
	private String tags;
	private String description;
	private List<Employee> authors;
	
	@ManagedProperty(name="publicationBo", value="#{publicationBo}")
	PublicationBo publicationBo;
	
	@ManagedProperty(name="employeeBo", value="#{employeeBo}")
	EmployeeBo employeeBo;
	
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
	
	public List<Employee> getAuthors()
	{
		if(authors == null)
		{
			authors = employeeBo.findAllEmployees();
		}
		return authors;
	}
	
	public void setAuthors(List<Employee> authors)
	{
		this.authors = authors;
	}
}

