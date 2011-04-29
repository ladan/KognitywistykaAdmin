package pl.edu.uj.kognitywistyka.admin.contact.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pl.edu.uj.kognitywistyka.admin.contact.bo.ContactRecipientBo;
import pl.edu.uj.kognitywistyka.admin.contact.model.ContactRecipient;

@ManagedBean
@RequestScoped
public class ContactRecipientBunchBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<ContactRecipient> allContactRecipient;
	
	@ManagedProperty(name = "contactRecipientBo", value="#{contactRecipientBo}")
	ContactRecipientBo contactRecipientBo;

	public void setContactRecipientBo(ContactRecipientBo contactRecipientBo) {
		this.contactRecipientBo = contactRecipientBo;
	}
	
	public void setAllContactRecipient(List<ContactRecipient> allContactRecipient) {
		this.allContactRecipient = allContactRecipient;
	}
	
	public List<ContactRecipient> getAllContactRecipient() {
		if (allContactRecipient == null)
			allContactRecipient = contactRecipientBo.findAllContactRecipient();
		return allContactRecipient;
	}

}
