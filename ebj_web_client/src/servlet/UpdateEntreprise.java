package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateEntreprise
 */
public class UpdateEntreprise extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEntreprise() {
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
		
		System.out.println("UpdateEntreprise::doPost");
		
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email    = request.getParameter("email");
		String street = request.getParameter("street");	
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");
		String phoneKind = request.getParameter("phoneKind");
		String phoneNumber = request.getParameter("phoneNumber");
		String numSiret = request.getParameter("numSiret");
		System.out.println("id=" + id);
//		
//		String contactType = request.getParameter("typeBtn");
		
//		ApplicationContext  appCtx =	
//				WebApplicationContextUtils.getWebApplicationContext(getServletContext());		

	
//			daoContact = (IDAOContact) appCtx.getBean("daoContactProperty");
		 String dbOutput = daoEntreprise.updateEntreprise(Long.parseLong(id), firstName, lastName, email, street, city, zip, country, phoneKind, phoneNumber, numSiret);


			dbOutput += daoEntreprise.getUpdateForm(new Integer(id));
			PrintWriter out = response.getWriter() ;

		      
		      out.println (getHeader(null));
		      out.println (getBody("Show Update Form"));
		      out.println (dbOutput);
		         
		      out.println (getFooter());
	}

}
