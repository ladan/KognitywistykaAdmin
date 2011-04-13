package pl.edu.uj.kognitywistyka.admin.aboutproject.managedbeans;

import java.io.Serializable;
import java.net.URL;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.admin.aboutproject.bo.LinkBo;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Link;

@ManagedBean
@RequestScoped
public class LinkBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long linkId;
	private String name;
	private URL url;
	private String description;
	
	// Dependency injection
	@ManagedProperty(name="linkBo", value="#{linkBo}")
	private LinkBo linkBo;
	@ManagedProperty(name="linkBunchBean", value="#{linkBunchBean}")
	private LinkBunchBean linkBunchBean;
	
	public long getLinkId() {
		return linkId;
	}

	public void setLinkId(long linkId) {
		this.linkId = linkId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLinkBo(LinkBo linkBo) {
		this.linkBo = linkBo;
	}
	
	public void setLinkBunchBean(LinkBunchBean linkBunchBean) {
		this.linkBunchBean = linkBunchBean;
	}
	
	public String addLink() {
		Link link = new Link();
		link.setName(name);
		link.setUrl(url.toString());
		link.setDescription(description);
		
		linkBo.addLink(link);
		
		resetView();
		return "";
	}
	
	public String removeLink(long linkId) {
		linkBo.removeLink(linkId);
		
		resetView();
		return "";
	}

	private void resetView() {
		setName("");
		setUrl(null);
		setDescription("");
		
		linkBunchBean.setAllLinks(null);
	}
}
