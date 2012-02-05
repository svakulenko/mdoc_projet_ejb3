package servlet;

import generator.website.T_AddContactFull;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;*/

import util.ServerUtils;

import daoInterface.IDAOContact;
import daoInterface.IDAOEntreprise;

/**
 * Servlet implementation class AddEntreprise
 */
public class AddEntreprise extends BaseServlet 
{
	@EJB(name = "DAOEntrepriseBean")
	private IDAOEntreprise daoEntreprise;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEntreprise() {
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
		// TODO Auto-generated method stub
	
		System.out.println("Adding entreprise info into database....");
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
		String group = request.getParameter("group");
		
		//TODO
		String dbOutput = daoEntreprise.addEntreprise(firstName, 
				lastName, 
				email, 
				street, 
				city, 
				zip, 
				country, 
				phoneKind, 
				phoneNumber,
				new Long(numSiret),
				group
		);
		
	      PrintWriter out = response.getWriter() ;
	      out.println (getHeader(null));
	      out.println (getBody("Add Contact"));
	      
	      out.println (dbOutput); //add dynamic content (response from daoContact)
	      String[] inputFormsID = {"AddEntreprise","AddContact"};
	      out.println (new T_AddContactFull().generate(inputFormsID)); // add dynamic content
	      
	      out.println (getFooter()); //add footer
	      
		
//		String responseUrl = "/addContact.jsp" + ServerUtils.getNewParameter("dbOutput", dbOutput);
//		System.out.println("::doPost responseUrl=" + responseUrl);
//
//		RequestDispatcher rd = getServletContext().getRequestDispatcher( responseUrl );
//		rd.forward(request, response);
	}

}
