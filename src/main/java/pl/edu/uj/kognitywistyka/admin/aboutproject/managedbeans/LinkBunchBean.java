package pl.edu.uj.kognitywistyka.admin.aboutproject.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.admin.aboutproject.bo.LinkBo;
import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Link;

@ManagedBean
@RequestScoped
public class LinkBunchBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Link> allLinks;
	
	@ManagedProperty(name="linkBo", value="#{linkBo}")
	private LinkBo linkBo;

	public List<Link> getAllLinks() {
		if(allLinks == null)
			allLinks = linkBo.findAllLinks();
		return allLinks;
	}

	public void setAllLinks(List<Link> allLinks) {
		this.allLinks = allLinks;
	}

	public void setLinkBo(LinkBo linkBo) {
		this.linkBo = linkBo;
	}
	
}
