package servlet;

import generator.website.T_AddContactFull;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ServerUtils;
import daoInterface.IDAOContact;
import daoInterface.IDAOEntreprise;

/**
 * Servlet implementation class removeEntreprise
 */
public class RemoveEntreprise extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveEntreprise() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String id 		 = request.getParameter("id");
		System.out.println(id);
		daoContact.deleteContact(new Long(id));
		RequestDispatcher rd = null;
		rd = getServletContext().getRequestDispatcher("/ShowAllContact");
		rd.forward(request, response);
		
		
//		String reqUrl =  request.getRequestURL().toString();
//		System.out.println("RemoveContact::doPost reqUrl='" + reqUrl + "'");
//		System.out.println("request.getContextPath()" + request.getContextPath());
//		
//		//Integer id = Integer.parseInt(request.getParameter("contactID"));
//		//String id 		 = request.getParameter("id");
//		String firstName = request.getParameter("firstname");
//		String lastName = request.getParameter("lastname");
//		String email    = request.getParameter("email");
//		String street = request.getParameter("street");	
//		String city = request.getParameter("city");
//		String zip = request.getParameter("zip");
//		String country = request.getParameter("country");
//		String phoneKind = request.getParameter("phonekind");
//		String phoneNumber = request.getParameter("phonenumber");
//		String numSiret = request.getParameter("numsiret");
//		
//		String[] groups = request.getParameterValues("group");
//		String group = groups[0];
//		ServerUtils.showParameters(firstName, lastName, email, street, city, zip, country, phoneKind, phoneNumber, numSiret, group);
//		
//		//TODO
////		IDAOContact daoContact = null;
//		IDAOEntreprise daoEntreprise = null;
////		ApplicationContext  ac =	WebApplicationContextUtils.getWebApplicationContext(getServletContext());
////		IDAOContact daoContact = (IDAOContact) ac.getBean("daoContactProperty");
////		IDAOEntreprise daoEntreprise = (IDAOEntreprise) ac.getBean("daoEntrepriseProperty");
//		
//		
//		String dbOutput = null;
//
////		if (reqUrl.matches(".*/ContactCriteria")){
////			System.out.println(".*/ContactCriteria");
////			dbOutput = daoContact.deleteContact(0, firstName, lastName, email, street, city, zip, country, phoneKind, phoneNumber, numSiret);
////		}
////		else if (reqUrl.matches(".*/EntrepriseCriteria")){
////			System.out.println(".*/EntrepriseCriteria");
//			dbOutput = daoEntreprise.deleteEntreprise(0, firstName, lastName, email, street, city, zip, country, phoneKind, phoneNumber, numSiret);
////		}
////		else
////			System.out.println("no of if/else of criteria, warning");
//		 
//		      PrintWriter out = response.getWriter() ;
//		      out.println (getHeader(null));
//		      out.println (getBody("Remove Contact"));
//		      out.println (dbOutput);
//		      String[] inputFormsID = {"removeEntreprise","removeContact"};
//		      out.println (new T_AddContactFull().generate(inputFormsID));
//		      out.println (getFooter());
//
////
////		String responseUrl = "/" + "removeContact.jsp" + ServerUtils.getNewParameter("dbOutputRaw", dbOutput);
////		System.out.println("::doPost responseUrl=" + responseUrl);
////
////		response.sendRedirect(request.getContextPath() + responseUrl); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
