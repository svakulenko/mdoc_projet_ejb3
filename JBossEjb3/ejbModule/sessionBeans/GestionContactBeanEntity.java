package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entityBeans.Contact;

@Stateless(mappedName="ContactBeanEntity")
public class GestionContactBeanEntity implements GestionContactRemote {

	 @PersistenceContext
	   EntityManager em;
	 
	public String coucouContact(String nomContact) {
		return "Hello, "+nomContact;
	}
	@Override
	  public void addContact(String fname, String lname, String email) {
	      Contact contact=new Contact();
	      contact.setFirstName(fname);
	      contact.setLastName(lname);
	      contact.setEmail(email);
		  em.persist(contact);
	   }

	@Override
	   public String findContactNameById(long id) {
	      Contact contact=em.find(Contact.class, id);
	      return contact.getLastName() +", "+contact.getFirstName();
	   }
	
}
