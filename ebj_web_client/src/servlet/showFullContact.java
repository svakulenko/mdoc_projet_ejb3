package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class showFullContact
 */
public class showFullContact extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showFullContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("showFullContact::doGet");
		String id = request.getParameter("id"); 
		String dbOutput = daoContact.searchContactSimple(id);		
//		dbOutput += "<p></p>";
//		dbOutput += daoEntreprise.getAllEntreprise();
		
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
		System.out.println("showFullContact::doPost");
	}

}
