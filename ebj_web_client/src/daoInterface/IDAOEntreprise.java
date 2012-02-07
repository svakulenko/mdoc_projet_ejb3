package daoInterface;

import java.util.Set;

import javax.ejb.Local;
import javax.servlet.ServletContext;


@Local
public interface IDAOEntreprise 
{
	
	public String addEntreprise(	String firstName, 
			String lastName,
			String email,
			String street,
			String city,
			String zip,
			String country,
			String phoneKind,
			String phoneNumber,
			String siretNumber,
			String group
		 );
	public String searchEntreprise(long id);
	public String deleteEntreprise(long id);
	public String getAllEntreprise();
	
	public String searchEntreprise(long id,
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
	public String deleteEntreprise(long id,
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
	public String searchContactSimple(String id );
	public String getUpdateForm(long id);
	public String getUpdateForm2(String id);
	public String updateEntreprise(long id, String firstName, String lastName,
			String email, String street, String city, String zip,
			String country, String phoneKind, String phoneNumber, String numSiret) ;
}
