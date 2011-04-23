package pl.edu.uj.kognitywistyka.admin.contact.model;

import java.io.Serializable;

public class ContactRecipient implements Serializable{

	private static final long serialVersionUID = 8968042987648627842L;
	private long contactRecipientId;
	private String firstName;
	private String lastName;
	private String email;
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
	
	
}
