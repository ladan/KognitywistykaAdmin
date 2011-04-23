package pl.edu.uj.kognitywistyka.admin.contact.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.admin.aboutproject.model.Report;
import pl.edu.uj.kognitywistyka.admin.contact.model.ContactRecipient;

public class ContactRecipientDaoImpl extends HibernateDaoSupport  
implements ContactRecipientDao {
	
	@SuppressWarnings("unchecked")
	public List<ContactRecipient> findAllContactRecipients() {
		return getHibernateTemplate().find("from ContactRecipient order by lastName asc");
	}

	public void addContactRecipient(ContactRecipient contactRecipient) {
		getHibernateTemplate().save(contactRecipient);
		
	}

	public void removeContactRecipient(ContactRecipient contactRecipient) {
		getHibernateTemplate().delete(contactRecipient);
		
	}

	public void updateContactRecipient(ContactRecipient contactRecipient) {
		getHibernateTemplate().update(contactRecipient);
		
	}

	public ContactRecipient getContactRecipient(long contactRecipientId) {
		return (ContactRecipient) getHibernateTemplate().get(ContactRecipient.class, contactRecipientId);
	}
}
