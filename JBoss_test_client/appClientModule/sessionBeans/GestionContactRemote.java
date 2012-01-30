package sessionBeans;
import javax.ejb.Local;
import javax.ejb.Remote;

@Local
public interface GestionContactRemote {

	public String coucouContact(String nomContact);
	public void addContact(String fname, String lname, String email);
	public String findContactNameById(long id);
}