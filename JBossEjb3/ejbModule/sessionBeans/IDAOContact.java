package sessionBeans;
import javax.ejb.Remote;

@Remote
public interface IDAOContact {
	public String coucouContact(String nomContact);
	public void addContact(String fname, String lname, String email);
	public String addContact(	String firstName, 
			String lastName,
			String email,
			String street,
			String city,
			String zip,
			String country,
			String phoneKind,
			String phoneNumber
		 );
	public String findContactNameById(long id);
}