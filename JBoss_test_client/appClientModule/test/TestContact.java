package test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sessionBeans.IDAOContact;

public class TestContact {
	public static void main(String[] args) {
	    try {
	        //Use of JNDI in order to identify and to communicate
	    	//with the remote beans
	    	Context context = new InitialContext();
	        
	    	//here, we use the name of the bean i.e. mappedName and not the class name
	    	IDAOContact daoContact = (IDAOContact) context.lookup("DAOContactBean");
//	    	daoContact.addContact("Titi", "Toto", "Dantes@montecristo.com");
	    	daoContact.addContact("firstName", "lastName", "email", "street", "city", "zip", "country", "phoneKind", "phoneNumber");
	    	System.out.println("Done");	
	         
	    
	    } catch (NamingException e) {
	         e.printStackTrace();
	      }
	}
}
