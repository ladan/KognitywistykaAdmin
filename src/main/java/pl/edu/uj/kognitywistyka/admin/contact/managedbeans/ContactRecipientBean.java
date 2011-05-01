package pl.edu.uj.kognitywistyka.admin.contact.managedbeans;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import pl.edu.uj.kognitywistyka.admin.contact.bo.ContactRecipientBo;
import pl.edu.uj.kognitywistyka.admin.contact.model.ContactRecipient;

@ManagedBean
@RequestScoped
public class ContactRecipientBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private long contactRecipientId;
	private String firstName;
	private String lastName;
	private String email;

	@ManagedProperty(name = "contactRecipientBo", value = "#{contactRecipientBo}")
	ContactRecipientBo contactRecipientBo;

	@ManagedProperty(name = "contactRecipientBunchBean", value = "#{contactRecipientBunchBean")
	ContactRecipientBunchBean contactRecipientBunchBean;

	public void setContactRecipientBo(ContactRecipientBo contactRecipientBo) {
		this.contactRecipientBo = contactRecipientBo;
	}

	public void setContactRecipientBunchBean(
			ContactRecipientBunchBean contactRecipientBunchBean) {
		this.contactRecipientBunchBean = contactRecipientBunchBean;
	}

	@PostConstruct
	@SuppressWarnings("unused")
	private void init() {
		Map<String, String> requestMap = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String contactRecipientId = requestMap.get("contactRecipientId");
		if (contactRecipientId != null)
			preinitializeBean(new Long(contactRecipientId));
	}

	private void preinitializeBean(long contactRecipientId) {
		ContactRecipient contactRecipient = contactRecipientBo
				.getContactRecipient(contactRecipientId);
		if (contactRecipient != null) {
			this.contactRecipientId = contactRecipient.getContactRecipientId();
			this.firstName = contactRecipient.getFirstName();
			this.lastName = contactRecipient.getLastName();
			this.email = contactRecipient.getEmail();
		}
	}

	public long getContactRecipientId() {
		return contactRecipientId;
	}

	public void setContactRecipientId(long contactRecipientId) {
		this.contactRecipientId = contactRecipientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String addContactRecipient() {
		ContactRecipient contactRecipient = new ContactRecipient();
		contactRecipient.setFirstName(firstName);
		contactRecipient.setLastName(lastName);
		contactRecipient.setEmail(email);
		contactRecipientBo.addRecipient(contactRecipient);

		resetView();

		return "";

	}

	public String removeContractRecipient(long contractRecipientId) {
		contactRecipientBo.removeRecipient(contractRecipientId);

		resetView();
		return "";
	}

	private void resetView() {
		setContactRecipientId(0);
		setFirstName("");
		setLastName("");
		setEmail("");

		contactRecipientBunchBean.setAllContactRecipient(null);
	}

}
