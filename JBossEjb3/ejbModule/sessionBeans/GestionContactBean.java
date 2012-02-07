package sessionBeans;

import javax.ejb.Stateless;


@Stateless(mappedName="ContactBean")
public class GestionContactBean implements GestionContactRemote {

	public String coucouContact(String nomContact) {
		return "Coucou, "+nomContact;
	}


	public void addContact(String fname, String lname, String email) {
		
		
	}


	public String findContactNameById(long id) {
		return "";
	}
}
