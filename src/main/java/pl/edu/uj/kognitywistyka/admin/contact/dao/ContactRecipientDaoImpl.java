package pl.edu.uj.kognitywistyka.admin.contact.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pl.edu.uj.kognitywistyka.admin.contact.model.ContactRecipient;

public class ContactRecipientDaoImpl extends HibernateDaoSupport  
implements ContactRecipientDao {
	
	@SuppressWarnings("unchecked")
	public List<ContactRecipient> findAllContactRecipients() {
		HibernateTemplate ht = getHibernateTemplate();
		ht.setMaxResults(10);
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

	public void removeContactRecipient(long contactRecipientId) {
		Query query = getSession().createQuery("delete ContactRecipient where contactRecipientId = :contactRecipientId");
		query.setParameter("contactRecipientId", contactRecipientId);
		query.executeUpdate();
	}
}
