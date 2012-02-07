package servlet;

import generator.website.T_AddContactFull;
import generator.website.T_addContact;
import generator.website.T_jspBody;
import generator.website.T_jspHeader;
import generator.website.T_jspfooter;



import java.io.IOException;
import java.io.PrintWriter;

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
public class AddContact extends BaseServlet 
{

	

	
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
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email    = request.getParameter("email");
		

		String dbOutput = null;
		String inputFailedForm = checkInput(firstName, lastName, email,"skip");
		
		if (inputFailedForm == null){
			
		
		String street = request.getParameter("street");	
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");
		String phoneKind = request.getParameter("phonekind");
		String phoneNumber = request.getParameter("phonenumber");
		String[] groups = request.getParameterValues("group");
		String group = groups[0];
		System.out.println("AddContact::doPost group=" + group + ", phoneNumber=" + phoneNumber);
		dbOutput = daoContact.addContact(firstName, 
													lastName, 
													email, 
													street, 
													city, 
													zip, 
													country, 
													phoneKind, 
													phoneNumber,
													group);
			//daoContact.addContact("first", "last");
			
			//String responseUrl = "/addContact.jsp" + ServerUtils.getNewParameter("dbOutput", dbOutput);

			

		} else {
			dbOutput = "Please check input for '" + inputFailedForm + "'";
		}
		
	      PrintWriter out = response.getWriter() ;
	      out.println (getHeader(null));
	      out.println (getBody("Add Contact"));
	      out.println (dbOutput);
	      String[] inputFormsID = {"AddEntreprise","AddContact"};
	      out.println (new T_addContact().generate(inputFormsID));
	      out.println (getFooter());
		//
		
		//need to set responseUrl
//		RequestDispatcher rd = getServletContext().getRequestDispatcher( responseUrl );
//
//		rd.forward(request, response);
	}

}
