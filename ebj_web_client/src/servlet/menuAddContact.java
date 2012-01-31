package servlet;

import generator.website.T_AddContactFull;
import generator.website.T_jspBody;
import generator.website.T_jspHeader;
import generator.website.T_jspfooter;
import generator.website.Template_addContact;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class menuAddContact
 */
public class menuAddContact extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menuAddContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("menuAddContact::doGet");
		
		
	      PrintWriter out = response.getWriter() ;

	      
	      out.println (getHeader(null));
	      out.println (getBody("Add Contact"));
	      
	      String[] inputFormsID = {"AddEntreprise","AddContact"};
	      String addContactMenuStr = new T_AddContactFull().generate(inputFormsID);
	      out.println (addContactMenuStr);
	      
	      
	      
	      out.println (getFooter());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("menuAddContact::doPost");
	}

}
