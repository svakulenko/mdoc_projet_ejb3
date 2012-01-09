package sessionBeans;

import javax.ejb.Stateless;


@Stateless(mappedName="ContactBean")
public class GestionContactBean implements GestionContactRemote {

	public String coucouContact(String nomContact) {
		return "Coucou, "+nomContact;
	}

	@Override
	public void addContact(String fname, String lname, String email) {
		
		
	}

	@Override
	public String findContactNameById(long id) {
		return "";
	}
}
