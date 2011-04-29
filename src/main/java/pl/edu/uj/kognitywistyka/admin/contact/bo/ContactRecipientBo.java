package pl.edu.uj.kognitywistyka.admin.contact.bo;

import java.util.List;

import pl.edu.uj.kognitywistyka.admin.contact.model.ContactRecipient;

public interface ContactRecipientBo {
	void addRecipient(ContactRecipient contactRecipient);

	void removeRecipient(ContactRecipient contactRecipient);

	void removeRecipient(long contactRecipientId);

	ContactRecipient getContactRecipient(long contactRecipientId);

	List<ContactRecipient> findAllContactRecipient();

}
