package servlet;

import java.io.IOException;

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
public class ClearTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		//TODO
		IDAOContact daoContact = null;
//		ApplicationContext  ac =	WebApplicationContextUtils.getWebApplicationContext(getServletContext());
//		IDAOContact daoContact = (IDAOContact) ac.getBean("daoContactProperty");
		
		//DAOContact daoContact = new DAOContact();
		String dbOutput = daoContact.clearTable();
		String responseUrl = "/" + "accueil.jsp" + ServerUtils.getNewParameter("dbOutput", dbOutput);
		System.out.println("output=" + responseUrl);
		RequestDispatcher rd = getServletContext().getRequestDispatcher( responseUrl );
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
