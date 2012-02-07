package daoInterface;
import javax.ejb.Local;
import javax.ejb.Remote;

@Local
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
			String phoneNumber,
			String group
		 );

	public String addContact(String firstName,String lastName);

	// Used by Spring framework
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
			String group,
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
	//public String searchContact(long id);
	public String deleteContact(long id);
	public String updateContact(long id);
	public String getAllContacts();
	String findContactNameById(long id);
	public String clearTable();
	public String getUpdateForm(long id);
	
}

