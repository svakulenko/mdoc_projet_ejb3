package sessionBeans;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;

//import aspect.ContactAspect;

import util.ServerUtils;

import daoInterface.IDAOContact;

import entityBeans.Address;
import entityBeans.Contact;
import entityBeans.ContactGroup;
import entityBeans.PhoneNumber;

@Stateless(mappedName = "DAOContactBean")
public class DAOContact implements IDAOContact {

	@PersistenceContext
	EntityManager em;

	public String coucouContact(String nomContact) {
		return "Coucou, " + nomContact;
	}

	public void addContact(String fname, String lname, String email) {
		System.out.println("******************************************");
		Contact contact = new Contact();
		contact.setFirstName(fname);
		contact.setLastName(lname);
		contact.setEmail(email);
		em.persist(contact);
	}

	@Override
	public String findContactNameById(long id) {
		return "";
	}

	// @Interceptors(ContactAspect.class)
	@Override
	public String addContact(String firstName, String lastName, String email,
			String street, String city, String zip, String country,
			String phoneKind, String phoneNumber, String group) {
		System.out.println("Server side, 9 params");
		// TODO Auto-generated method stub
		Contact contact = new Contact();
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

		String request = "from ContactGroup contactGroup";
		Query query = em.createQuery(request);
		List<ContactGroup> l = query.getResultList();
		Iterator<ContactGroup> ite = l.iterator();
		ContactGroup contactGroup = null;
		String rvalue = null;
		while (ite.hasNext()) {
			contactGroup = ite.next();
			if (contactGroup.getGroupName().equals(group)) {
				contact.getContactGroups().add(contactGroup);
				contactGroup.getContacts().add(contact);
				em.persist(contact);
				rvalue = ServerUtils.opFait;
				return rvalue;
			}
		}

		// If new contact Group
		contactGroup = new ContactGroup();
		contactGroup.setGroupName(group);
		contact.getContactGroups().add(contactGroup);
		contactGroup.getContacts().add(contact);

		em.persist(contact);
		// em.persist(address);
		// em.persist(phone);
		// em.persist(contactGroup);

		return "success";
	}

	@Override
	public String addContact(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateContact(long id, String firstName, String lastName,
			String email, String street, String city, String zip,
			String country, String phoneKind, String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String searchContactSimple(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String searchContact(long id, String firstName, String lastName,
			String email, String street, String city, String zip,
			String country, String phoneKind, String phoneNumber,
			String numSiret) {
		
		String rvalue = null;
		
		String s_q = "from Contact contact "
				+ " left join contact.address as address"
				+ " left join contact.phoneNumbers as phoneNumber"
				+ " left join contact.contactGroups as contactGroup"
//				+  numSiret == null ? "" : " left join entreprise as Entreprise"
				+ " WHERE contact.firstName LIKE :firstName"
				+ " AND contact.lastName LIKE :lastName"
				+ " AND contact.email LIKE :email"
				+ " AND address.street LIKE :street"
				+ " AND address.city LIKE :city"
				+ " AND address.zip LIKE :zip"
				+ " AND address.country LIKE :country"
				+ " AND phonenumber.phoneKind LIKE :phoneKind"
				+ " AND phonenumber.phoneNumber LIKE :phoneNumber"
//				+ numSiret == null ? "" : " AND Entreprise.numSiret LIKE :numSiret"
				;
		;
		
		Query q = em.createQuery(s_q);
		q.setParameter("firstName", firstName + "%");
		q.setParameter("lastName", lastName + "%");
		q.setParameter("email", email + "%");
		q.setParameter("street", street + "%");
		q.setParameter("city", city + "%");
		q.setParameter("zip", zip + "%");
		q.setParameter("country", country + "%");
		q.setParameter("phoneKind", phoneKind + "%");
		q.setParameter("phoneNumber", phoneNumber + "%");
//		if (numSiret != null)
//			q.setParameter("numSiret", numSiret + "%");
		
				

		List l  = q.getResultList();
		
		System.out.println("list size=" + l.size());
		if (l.size() != 0)
			rvalue = ServerUtils.generateContactTable(l, "Contact table");
		else
			rvalue = ServerUtils.opNoRecods;

		return rvalue;
	}

	@Override
	public String deleteContact(long id, String firstName, String lastName,
			String email, String street, String city, String zip,
			String country, String phoneKind, String phoneNumber,
			String numSiret) {
		String rvalue = null;
		
		String s_q = "from Contact contact "
				+ " left join contact.address as address"
				+ " left join contact.phoneNumbers as phoneNumber"
				+ " left join contact.contactGroups as contactGroup"
//				+  numSiret == null ? "" : " left join entreprise as Entreprise"
				+ " WHERE contact.firstName LIKE :firstName"
				+ " AND contact.lastName LIKE :lastName"
				+ " AND contact.email LIKE :email"
				+ " AND address.street LIKE :street"
				+ " AND address.city LIKE :city"
				+ " AND address.zip LIKE :zip"
				+ " AND address.country LIKE :country"
				+ " AND phonenumber.phoneKind LIKE :phoneKind"
				+ " AND phonenumber.phoneNumber LIKE :phoneNumber"
				//+ numSiret == null ? "" : " AND Entreprise.numSiret LIKE :numSiret"
				;
		;
		
		Query q = em.createQuery(s_q);
		q.setParameter("firstName", firstName + "%");
		q.setParameter("lastName", lastName + "%");
		q.setParameter("email", email + "%");
		q.setParameter("street", street + "%");
		q.setParameter("city", city + "%");
		q.setParameter("zip", zip + "%");
		q.setParameter("country", country + "%");
		q.setParameter("phoneKind", phoneKind + "%");
		q.setParameter("phoneNumber", phoneNumber + "%");
//		if (numSiret != null)
//			q.setParameter("numSiret", numSiret + "%");
		
		

		List<Object[]> l = q.getResultList();

		for (Object[] objs: l){
			Contact c =   (Contact) objs[0];
			em.remove(c);
		}
		

		
		return ServerUtils.opTableRemoved;
	}

	@Override
	public String deleteContact(long id) {// clear all

		String req = "from Contact contact";

		// em.createQuery("DELETE FROM Contact")
		// .executeUpdate();

		Query query = em.createQuery(req);
		// em.remove(l.get(0));
		List<Contact> l = query.getResultList();
		for (Contact i : l) {
			em.remove(i);
		}

		return ServerUtils.opTableRemoved;

	}

	@SuppressWarnings("rawtypes")
	@Override
	public String getAllContacts() {
		StringBuffer requeteS = new StringBuffer();
		requeteS.append("from Contact contact")
				.append(" left join contact.address as address")
				.append(" left join contact.phoneNumbers as phoneNumber")
				.append(" left join contact.contactGroups as contactGroup");

		Query query = em.createQuery(requeteS.toString());

		List l = query.getResultList();
		System.out.println("reslt size=" + l.size());

		String rvalue = null;
		if (l.size() == 0)
			rvalue = ServerUtils.opNoRecods;
		else
			rvalue = ServerUtils.generateContactTable(l, "Contact table");

		return rvalue;
	}

	public String clearTable() {
		// TODO Auto-generated method stub
		String req = ("from Contact contact");

		Query query = em.createQuery(req);

		List<Contact> l = query.getResultList();
		for (Contact i : l) {
			em.remove(i);
		}

		req = "from ContactGroup group";
		query = em.createQuery(req);
		List<ContactGroup> listGroup = query.getResultList();

		for (ContactGroup i : listGroup) {
			i.setContacts(new HashSet<Contact>());
			em.persist(i);
		}
		return ServerUtils.opTableRemoved;
	}
}
