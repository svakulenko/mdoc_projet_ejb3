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






/**
 * Servlet implementation class SContactClearTable
 */
public class ClearTable extends BaseServlet {
	private static final long serialVersionUID = 1L;
	@EJB(name = "DAOContactBean")
	private IDAOContact daoContact;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClearTable() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SContactClearTable::doGet");
		
//		//TODO
//		IDAOContact daoContact = null;
//
//		
//
		String dbOutput = daoContact.clearTable();
		
	      PrintWriter out = response.getWriter() ;

	      
	      out.println (getHeader(null));
	      out.println (getBody("Clear Tables"));
	      out.println (dbOutput);
	         
	      out.println (getFooter());
	      
//		String responseUrl = "/" + "accueil.jsp" + ServerUtils.getNewParameter("dbOutput", dbOutput);
////		System.out.println("output=" + responseUrl);
//		RequestDispatcher rd = getServletContext().getRequestDispatcher( responseUrl );
//		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
