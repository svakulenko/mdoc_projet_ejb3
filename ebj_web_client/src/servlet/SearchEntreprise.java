package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ServerUtils;
import daoInterface.IDAOEntreprise;

/**
 * Servlet implementation class SearchEntreprise
 */
public class SearchEntreprise extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEntreprise() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reqUrl =  request.getRequestURL().toString();
		System.out.println("SearchContact::doPost reqUrl='" + reqUrl + "'");
		System.out.println("request.getContextPath()" + request.getContextPath());
		

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email    = request.getParameter("email");
		String street = request.getParameter("street");	
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");
		String phoneKind = request.getParameter("phonekind");
		String phoneNumber = request.getParameter("phonenumber");
		String numSiret = request.getParameter("numsiret");
		String[] groups = request.getParameterValues("group");
		String group = groups[0];
		
		ServerUtils.showParameters(firstName, lastName, email, street, city, zip, country, phoneKind, phoneNumber, numSiret, group);
        String dbOutput = daoEntreprise.searchEntreprise(0, firstName, lastName, email, street, city, zip, country, phoneKind, phoneNumber, group, numSiret);
		System.out.println("SearchEntreprise::doPost dbOutput=" + dbOutput);
		 
		

	 

	      
	      PrintWriter out = response.getWriter() ;

	      
	      out.println (getHeader(null));
	      out.println (getBody("Search Entreprise"));
	      out.println (dbOutput);
	         
	      out.println (getFooter());
	      
	}

}
