package pl.edu.uj.kognitywistyka.admin.aboutproject.model;

public class Link implements java.io.Serializable{
	
	private static final long serialVersionUID = 6417225711933545255L;
	
	private long linkId;
	private String name;
	private String url;
	private String description;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}