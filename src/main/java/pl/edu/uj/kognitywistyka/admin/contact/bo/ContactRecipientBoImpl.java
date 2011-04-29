package pl.edu.uj.kognitywistyka.admin.contact.bo;

import java.io.Serializable;
import java.util.List;

import pl.edu.uj.kognitywistyka.admin.contact.dao.ContactRecipientDao;
import pl.edu.uj.kognitywistyka.admin.contact.model.ContactRecipient;

public class ContactRecipientBoImpl implements ContactRecipientBo, Serializable {
	

	private static final long serialVersionUID = 1L;
	ContactRecipientDao contactRecipientDao;
	
	public void setContactRecipientDao(ContactRecipientDao contactRecipientDao) {
		this.contactRecipientDao = contactRecipientDao;
	}

	public void addRecipient(ContactRecipient contactRecipient) {
		contactRecipientDao.addContactRecipient(contactRecipient);
	}

	public void removeRecipient(ContactRecipient contactRecipient) {
		contactRecipientDao.removeContactRecipient(contactRecipient);
	}

	public void removeRecipient(long contactRecipientId) {
		contactRecipientDao.removeContactRecipient(contactRecipientId);
	}

	public List<ContactRecipient> findAllContactRecipient() {
		return contactRecipientDao.findAllContactRecipients();
	}

	public ContactRecipient getContactRecipient(long contactRecipientId) {
		return contactRecipientDao.getContactRecipient(contactRecipientId);
	}

}
