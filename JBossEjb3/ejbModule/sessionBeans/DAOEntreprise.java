package sessionBeans;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import util.ServerUtils;

import daoInterface.IDAOEntreprise;
import entityBeans.Address;
import entityBeans.Contact;
import entityBeans.ContactGroup;
import entityBeans.Entreprise;
import entityBeans.PhoneNumber;

@Stateless(mappedName="DAOEntrepriseBean")
public class DAOEntreprise implements IDAOEntreprise {
	
	@PersistenceContext
	EntityManager em;


	public String addEntreprise(String firstName, String lastName,
			String email, String street, String city, String zip,
			String country, String phoneKind, String phoneNumber,
			String siretNumber,String group) {
		// TODO Auto-generated method stub
		Entreprise entreprise = new Entreprise();
		entreprise.setFirstName(firstName);
		entreprise.setLastName(lastName);
		entreprise.setEmail(email);
		entreprise.setNumSiret(siretNumber);
		
		Address address = new Address();
		address.setStreet(street);
		address.setCity(city);
		address.setZip(zip);
		address.setCountry(country);
		entreprise.setAddress(address); // Uni birectionnel
		
		PhoneNumber phone = new PhoneNumber();
		phone.setPhoneKind(phoneKind);
		phone.setPhoneNumber(phoneNumber);
		entreprise.getPhoneNumbers().add(phone);
		phone.setContact(entreprise);
		
		String request = "from ContactGroup contactGroup";
		Query query = em.createQuery(request);
		List<ContactGroup> l = query.getResultList();
		Iterator<ContactGroup> ite = l.iterator();
		ContactGroup contactGroup = null;
		String rvalue = null;
		while (ite.hasNext()) {
			contactGroup = ite.next();
			if (contactGroup.getGroupName().equals(group)) {
				entreprise.getContactGroups().add(contactGroup);
				contactGroup.getContacts().add(entreprise);
				em.persist(entreprise);
				rvalue = ServerUtils.opFait;
				return rvalue;
			}
		}
		
		// If new contact Group
		contactGroup = new ContactGroup();
		contactGroup.setGroupName(group);
		entreprise.getContactGroups().add(contactGroup);
		contactGroup.getContacts().add(entreprise);
		
		em.persist(entreprise);
		rvalue = ServerUtils.opFait;
		return rvalue;
	}


	public String searchEntreprise(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	public String deleteEntreprise(long id) {
		// TODO Auto-generated method stub
		String req = "from Entreprise entreprise where id = " + id;

		// em.createQuery("DELETE FROM Contact")
		// .executeUpdate();

		StringBuffer requeteContact = new StringBuffer();
		requeteContact.append("FROM Entreprise entreprise")
						.append(" WHERE entreprise.id = " + id);

		Query queryContact = em.createQuery(requeteContact.toString());
		Entreprise entreprise = (Entreprise) queryContact.getResultList().get(0);
		Query queryCg = em.createQuery("select cg from ContactGroup cg JOIN FETCH cg.contacts c where c.contactId = :id");
		queryCg.setParameter("id", id);
		List<ContactGroup> cgList = queryCg.getResultList();
		for (ContactGroup cg : cgList)
		{
			Query q = em
			        .createNativeQuery( "DELETE FROM ContactGroup_Contact " +
			        					"WHERE contacts_contactId = :cid and contactGroups_contactGpoupId = :gid");
			        q.setParameter("gid", cg.getContactGpoupId());
			        q.setParameter("cid", entreprise.getContactId());
			        q.executeUpdate();       
		}
		 em.remove(entreprise);
		return ServerUtils.opTableRemoved;

	}

	public String getUpdateForm2(String id)
	{
		System.out.println("DAOEntreprise::getUpdateForm2");
		StringBuffer requeteS = new StringBuffer();
		requeteS.append("from Contact entreprise")
				.append(" left join entreprise.address as address")
				.append(" left join entreprise.phoneNumbers as phoneNumber")
				.append(" left join entreprise.contactGroups as contactGroup")
				.append(" WHERE entreprise.contactId = :id");
		
		Long idInt = new Long(id);

		Query query = em.createQuery(requeteS.toString());
		query.setParameter("id", idInt);

		List<Object[]> l = query.getResultList();
		System.out.println("reslt size=" + l.size());

		String rvalue = null;
		if (l.size() == 1){
			Contact c = (Contact) l.get(0)[0];
//			if (!(c instanceof Entreprise)){
				Address a = (Address) l.get(0)[1];
				PhoneNumber p = (PhoneNumber)l.get(0)[2];
				ContactGroup cg = (ContactGroup)l.get(0)[3];
				rvalue = ServerUtils.generateUpdateForm(c, a, p, cg, "UpdateEntreprise");
//			}
		}
		else{
			rvalue = ServerUtils.opNoRecodsContact;
		}

		return rvalue;
	}
	
	public String getUpdateForm(long id)
	{
		System.out.println("DAOEntreprise::getUpdateForm");
		StringBuffer requeteS = new StringBuffer();
		requeteS.append("from Contact entreprise")
				.append(" left join entreprise.address as address")
				.append(" left join entreprise.phoneNumbers as phoneNumber")
				.append(" left join entreprise.contactGroups as contactGroup")
				.append(" WHERE entreprise.contactId = :id");
		
		Long idInt = new Long(id);

		Query query = em.createQuery(requeteS.toString());
		query.setParameter("id", idInt);

		List<Object[]> l = query.getResultList();
		System.out.println("reslt size=" + l.size());

		String rvalue = null;
		if (l.size() == 1){
			Contact c = (Contact) l.get(0)[0];
//			if (!(c instanceof Entreprise)){
				Address a = (Address) l.get(0)[1];
				PhoneNumber p = (PhoneNumber)l.get(0)[2];
				ContactGroup cg = (ContactGroup)l.get(0)[3];
				rvalue = ServerUtils.generateUpdateForm(c, a, p, cg, "UpdateEntreprise");
//			}
		}
		else{
			rvalue = ServerUtils.opNoRecodsContact;
		}

		return rvalue;
	}
	
	

	public String getAllEntreprise() {
		// TODO Auto-generated method stub
		StringBuffer requeteS = new StringBuffer();
		requeteS.append("from Entreprise entreprise")
				.append(" left join entreprise.address as address")
				.append(" left join entreprise.phoneNumbers as phoneNumber")
				.append(" left join entreprise.contactGroups as contactGroup")
				;

		Query query = em.createQuery(requeteS.toString());
       
		List l = query.getResultList();
		System.out.println("reslt size=" + l.size());

		String rvalue = null;
        if (l.size() == 0)
            rvalue = ServerUtils.opNoRecodsEntreprise;
        else
            rvalue = ServerUtils.generateEntrepriseTable(l, "Entreprise table");

		return rvalue;
	}


	public String searchEntreprise(long id, String firstName, String lastName,
			String email, String street, String city, String zip,
			String country, String phoneKind, String phoneNumber,
			String group, String numSiret) {
	String rvalue = null;
		
		String s_q = "from Entreprise entreprise "
				+ " left join entreprise.address as address"
				+ " left join entreprise.phoneNumbers as phoneNumber"
				+ " left join entreprise.contactGroups as contactGroup"
				+ " WHERE entreprise.firstName LIKE :firstName"
				+ " AND entreprise.lastName LIKE :lastName"
				+ " AND entreprise.email LIKE :email"
				+ " AND address.street LIKE :street"
				+ " AND address.city LIKE :city"
				+ " AND address.zip LIKE :zip"
				+ " AND address.country LIKE :country"
				+ " AND phonenumber.phoneKind LIKE :phoneKind"
				+ " AND phonenumber.phoneNumber LIKE :phoneNumber"
				+ " AND contactgroup.groupName LIKE :groupName"
				+ " AND entreprise.numSiret LIKE :numSiret"
				;
		
		

		//Long sir = new Long(numSiret);
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
		q.setParameter("groupName", group + "%");
		
		q.setParameter("numSiret", numSiret + "%" );

		
				
		

		List l  = q.getResultList();
		
		System.out.println("list size=" + l.size());
		if (l.size() != 0)
			rvalue = ServerUtils.generateEntrepriseTable(l, "Contact table");
		else
			rvalue = ServerUtils.opNoRecodsEntreprise;

		return rvalue;
	}


	public String deleteEntreprise(long id, String firstName, String lastName,
			String email, String street, String city, String zip,
			String country, String phoneKind, String phoneNumber,
			String numSiret) {
		// TODO Auto-generated method stub
		return null;
	}


	public String searchContactSimple(String id) {
		StringBuffer requeteS = new StringBuffer();
		requeteS.append("from Entreprise entreprise")
				.append(" left join entreprise.address as address")
				.append(" left join entreprise.phoneNumbers as phoneNumber")
				.append(" left join entreprise.contactGroups as contactGroup")
				.append(" WHERE entreprise.contactId = :id");
		
		Long idInt = new Long(id);

		Query query = em.createQuery(requeteS.toString());
		query.setParameter("id", idInt);

		List<Object[]> l = query.getResultList();
		System.out.println("reslt size=" + l.size());

		String rvalue = null;
		if (l.size() == 1){
			Entreprise c = (Entreprise) l.get(0)[0];
			if (c != null){
				Address a = (Address) l.get(0)[1];
				PhoneNumber p = (PhoneNumber)l.get(0)[2];
				ContactGroup cg = (ContactGroup)l.get(0)[3];
				rvalue = ServerUtils.generateFullContactRow(c, a, p, cg);
			}
		}
		else{
			rvalue = ServerUtils.opNoRecodsEntreprise;
		}

		return rvalue;
	}
	


	public String updateEntreprise(long id, String firstName, String lastName,
			String email, String street, String city, String zip,
			String country, String phoneKind, String phoneNumber, String numSiret) {
		// TODO Auto-generated method stub
		String rvalue = null;
		StringBuffer requeteS = new StringBuffer();
		requeteS.append("from Entreprise entreprise")
		.append(" left join entreprise.address as address")
		.append(" left join entreprise.phoneNumbers as phoneNumber")
		.append(" left join entreprise.contactGroups as contactGroup")
		.append(" WHERE entreprise.contactId = :id");
		
		
		Query query = em.createQuery(requeteS.toString());
		query.setParameter("id", id);
		List<Object[]> l = query.getResultList();
		if (l.size() == 0)
		{
			rvalue = "Contact dont exist!";
			return rvalue;
		}
		Entreprise contact = (Entreprise) l.get(0)[0];	
		Address address = (Address) l.get(0)[1];
		PhoneNumber phone = (PhoneNumber) l.get(0)[2];
		
		if (contact.getNumSiret() != null)
			contact.setNumSiret(numSiret);
		
		if (firstName != null)
			contact.setFirstName(firstName);
		if (lastName != null)
			contact.setLastName(lastName);
		if (email != null)
			contact.setEmail(email);

		
		if (street != null)
			address.setStreet(street);
		if (city != null)
			address.setCity(city);
		if (zip != null)
			address.setZip(zip);
		if (country != null)
			address.setCountry(country);
		contact.setAddress(address); // Uni birectionnel

		
		if (phoneKind != null)
			phone.setPhoneKind(phoneKind);
		if (phoneNumber != null)
			phone.setPhoneNumber(phoneNumber);
		
//		ContactGroup cg = (ContactGroup)l.get(0)[3];
//		if ()
		em.merge(contact);
		rvalue = ServerUtils.opFait;
		return rvalue;
	}

}
