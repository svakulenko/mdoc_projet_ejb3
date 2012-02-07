package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entityBeans.ContactSimple;

@Stateless(mappedName="ContactBeanEntity")
public class GestionContactBeanEntity implements GestionContactRemote {

	 @PersistenceContext
	   EntityManager em;
	 
	public String coucouContact(String nomContact) {
		return "Hello, "+nomContact;
	}

	  public void addContact(String fname, String lname, String email) {
	      ContactSimple contact=new ContactSimple();
	      contact.setFirstName(fname);
	      contact.setLastName(lname);
	      contact.setEmail(email);
		  em.persist(contact);
	   }


	   public String findContactNameById(long id) {
	      ContactSimple contact=em.find(ContactSimple.class, id);
	      return contact.getLastName() +", "+contact.getFirstName();
	   }
	
}
