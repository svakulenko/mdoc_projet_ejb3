package servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/*import org.springframework.context.*;
import org.springframework.web.context.support.WebApplicationContextUtils;*/


import util.ServerUtils;

import daoInterface.*;
//import domain.PhoneNumber;
import sessionBeans.*;

/**
 * Servlet implementation class SContactAddContact
 */
public class AddContact extends HttpServlet 
{
	@EJB(name = "ContactBean")
	private GestionContactRemote myBean;
	
	private static final long serialVersionUID = 1L;
	public static final String ENTREPRISE = "entreprise";
	public static final String CONTACT = "contact";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContact() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("AddContact::doPost Adding contact info into database....");
		System.out.println("AddContact::doPost Adding contact info into database....#2");
		System.out.println("myBean=" + myBean);
		String res = myBean.coucouContact("Mon Premier Client EJB3");
		System.out.println("AddContact::doPost Adding contact info into database....#2.5 res=" + res);
		System.out.println("AddContact::doPost Adding contact info into database....#3");
		
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastname");
		String email    = request.getParameter("email");
		String street = request.getParameter("street");	
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");
		String phoneKind = request.getParameter("phonekind");
		String phoneNumber = request.getParameter("phoneNumber");
		
		IDAOContact daoContact = null;
		
		//TODO
//		ApplicationContext  appCtx =	
//		WebApplicationContextUtils.getWebApplicationContext(getServletContext());			
//		IDAOCon 
		
		// CHECK EJB 
    	//Context context;
		try {
//			context = new InitialContext();
//
//        
//    	//here, we use the name of the bean i.e. mappedName and not the class name
//    	GestionContactRemote beanRemote = (GestionContactRemote)
//        context.lookup("ContactBean");
//        System.out.println(beanRemote.coucouContact("Mon Premier Client EJB3"));
//      
//         GestionContactRemote beanRemote2 = (GestionContactRemote)
//         context.lookup("ContactBeanEntity");
//         
//         System.out.println(beanRemote2.coucouContact("Mon Premier Client EJB3"));
//         //add a contact to the DB
//         beanRemote2.addContact("Edmon", "Dantès", "Dantes@montecristo.com");
//         //Check that the Contact was added to the DB
//         System.out.println("le nom du contact ajouté dans la base de données: "+ beanRemote2.findContactNameById(1));
		} catch (Exception e) {
			System.out.println("exception");
			e.printStackTrace();
		}
		//
		
		//need to set responseUrl
		RequestDispatcher rd = getServletContext().getRequestDispatcher( "/addContact.jsp" );
		rd.forward(request, response);
	}

}
