package pl.edu.uj.kognitywistyka.admin.contact.dao;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.contact.model.ContactRecipient;

public interface ContactRecipientDao {
	List<ContactRecipient> findAllContactRecipients();
	void addContactRecipient(ContactRecipient contactRecipient);
	void removeContactRecipient(ContactRecipient contactRecipient);
	void updateContactRecipient(ContactRecipient contactRecipient);
	ContactRecipient getContactRecipient(long contactRecipientId); 
}
