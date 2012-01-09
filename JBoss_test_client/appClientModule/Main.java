import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import sessionBeans.GestionContactRemote;


public class Main {
	public static void main(String[] args) {
	    try {
	        //Use of JNDI in order to identify and to communicate
	    	//with the remote beans
	    	Context context = new InitialContext();
	        
	    	//here, we use the name of the bean i.e. mappedName and not the class name
	    	GestionContactRemote beanRemote = (GestionContactRemote)
	        context.lookup("ContactBean");
	        System.out.println(beanRemote.coucouContact("Mon Premier Client EJB3"));
	      
	         GestionContactRemote beanRemote2 = (GestionContactRemote)
	         context.lookup("ContactBeanEntity");
	         System.out.println(beanRemote2.coucouContact("Mon Premier Client EJB3"));
	         //add a contact to the DB
	         beanRemote2.addContact("Edmon", "Dantès", "Dantes@montecristo.com");
	         //Check that the Contact was added to the DB
	         System.out.println("le nom du contact ajouté dans la base de données: "+ beanRemote2.findContactNameById(1));
	    
	    } catch (NamingException e) {
	         e.printStackTrace();
	      }
	}
}