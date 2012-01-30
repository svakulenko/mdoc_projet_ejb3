package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import entityBeans.Address;
import entityBeans.Contact;
import entityBeans.PhoneNumber;


@Stateless(mappedName="DAOContactBean")
public class DAOContact implements IDAOContact {
	
	 @PersistenceContext
	   EntityManager em;
	
	
	public String coucouContact(String nomContact) {
		return "Coucou, "+nomContact;
	}

	public void addContact(String fname, String lname, String email) {
		System.out.println("******************************************");
	      Contact contact=new Contact();
	      contact.setFirstName(fname);
	      contact.setLastName(lname);
	      contact.setEmail(email);
		  em.persist(contact);
	   }

	@Override
	public String findContactNameById(long id) {
		return "";
	}

	@Override
	public String addContact(String firstName, String lastName, String email,
			String street, String city, String zip, String country,
			String phoneKind, String phoneNumber) {
		System.out.println("Server side, 9 params");
		// TODO Auto-generated method stub
			Contact contact=new Contact();
	      contact.setFirstName(firstName);
	      contact.setLastName(lastName);
	      contact.setEmail(email);
	      
	    Address address = new Address();
	    address.setStreet(street);
	    address.setCity(city);
	    address.setZip(zip);
	    address.setCountry(country);
	    contact.setAddress(address); // Uni birectionnel
	    
	  PhoneNumber phone = new PhoneNumber();
	  phone.setPhoneKind(phoneKind);
	  phone.setPhoneNumber(phoneNumber);
	  contact.getPhoneNumbers().add(phone);
	  phone.setContact(contact);
	    
		  em.persist(contact);
		  em.persist(address);
		  em.persist(phone);
		  
		return "success";
	}
}



//Contact contact = new Contact();
//contact.setFirstName(firstName);
//contact.setLastName(lastName);
//contact.setEmail(email);
//
//Address address = new Address();
//address.setStreet(street);
//address.setCity(city);
//address.setZip(zip);
//address.setCountry(country);
//contact.setAddress(address); // Uni birectionnel
//
//PhoneNumber phone = new PhoneNumber();
//phone.setPhoneKind(phoneKind);
//phone.setPhoneNumber(phoneNumber);
//contact.getPhoneNumbers().add(phone);
//phone.setContact(contact);