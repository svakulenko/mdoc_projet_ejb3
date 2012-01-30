package sessionBeans;
import javax.ejb.Remote;

@Remote
public interface IDAOContact {
	public String clearTable();
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
	public String updateContact(long id,
			String firstName, 
			String lastName,
			String email,
			String street,
			String city,
			String zip,
			String country,
			String phoneKind,
			String phoneNumber
		 );
	public String searchContactSimple(String id );
	public String searchContact(long id,
			String firstName, 
			String lastName,
			String email,
			String street,
			String city,
			String zip,
			String country,
			String phoneKind,
			String phoneNumber,
			String numSiret
		 );
	public String deleteContact(long id,
			String firstName, 
			String lastName,
			String email,
			String street,
			String city,
			String zip,
			String country,
			String phoneKind,
			String phoneNumber,
			String numSiret
		 );
	public String deleteContact(long id);
	public String getAllContacts();
}