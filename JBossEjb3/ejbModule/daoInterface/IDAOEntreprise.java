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
			long siretNumber,
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
}
