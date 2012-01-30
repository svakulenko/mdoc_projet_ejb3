package servlet;

import java.io.IOException;

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
 * Servlet implementation class SContactShowAll
 */
public class ShowAllContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB(name = "DAOContactBean")
	private IDAOContact daoContact;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllContact() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SContactShowAll::doGet");
		
		//TODO

//		ApplicationContext  ac =	WebApplicationContextUtils.getWebApplicationContext(getServletContext());
//		IDAOContact daoContact = (IDAOContact) ac.getBean("daoContactProperty");
		
		//DAOContact daoContact = new DAOContact();
		String dbOutput = daoContact.getAllContacts();
		IDAOEntreprise daoEntreprise = null;
		//TODO
		//IDAOEntreprise daoEntreprise = (IDAOEntreprise) ac.getBean("daoEntrepriseProperty");
		//dbOutput += "<p></p>";
		//dbOutput += daoEntreprise.getAllEntreprise();
		
		String responseUrl = "/" + "accueil.jsp" + ServerUtils.getNewParameter("dbOutputRaw", dbOutput);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher( responseUrl );
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SContactShowAll::doPost");
	}

}
