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
import entityBeans.ContactGroup;
import entityBeans.Entreprise;
import entityBeans.PhoneNumber;

@Stateless(mappedName="DAOEntrepriseBean")
public class DAOEntreprise implements IDAOEntreprise {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public String addEntreprise(String firstName, String lastName,
			String email, String street, String city, String zip,
			String country, String phoneKind, String phoneNumber,
			long siretNumber,String group) {
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

	@Override
	public String searchEntreprise(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEntreprise(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
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
            rvalue = ServerUtils.opNoRecods;
        else
            rvalue = ServerUtils.generateEntrepriseTable(l, "Entreprise table");

		return rvalue;
	}

	@Override
	public String searchEntreprise(long id, String firstName, String lastName,
			String email, String street, String city, String zip,
			String country, String phoneKind, String phoneNumber,
			String numSiret) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEntreprise(long id, String firstName, String lastName,
			String email, String street, String city, String zip,
			String country, String phoneKind, String phoneNumber,
			String numSiret) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
