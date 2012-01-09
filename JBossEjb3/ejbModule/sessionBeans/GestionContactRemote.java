package sessionBeans;
import javax.ejb.Remote;

@Remote
public interface GestionContactRemote {

	public String coucouContact(String nomContact);
	public void addContact(String fname, String lname, String email);
	public String findContactNameById(long id);
}