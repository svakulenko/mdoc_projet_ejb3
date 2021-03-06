package servlet;

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
 * Servlet implementation class SContactShowAll
 */
public class ShowAllContact extends BaseServlet {
	private static final long serialVersionUID = 1L;
       


	
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
		

		String dbOutput = daoContact.getAllContacts();		
		dbOutput += "<p></p>";
		dbOutput += daoEntreprise.getAllEntreprise();
		
	      PrintWriter out = response.getWriter() ;

	      
	      out.println (getHeader(null));
	      out.println (getBody("Show Tables"));
	      out.println (dbOutput);
	         
	      out.println (getFooter());
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SContactShowAll::doPost");
	}

}
