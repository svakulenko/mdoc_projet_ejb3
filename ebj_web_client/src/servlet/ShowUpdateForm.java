package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowUpdateForm
 */
public class ShowUpdateForm extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUpdateForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		System.out.println("Updating contact " +  id + "....");
		String dbOutput = "";
		if (type.equals("c"))
			dbOutput = daoContact.getUpdateForm(new Integer(id));
		else 
			dbOutput = daoEntreprise.getUpdateForm(new Integer(id));
		PrintWriter out = response.getWriter() ;

	      
	      out.println (getHeader(null));
	      out.println (getBody("Show Update Form"));
	      out.println (dbOutput);
	         
	      out.println (getFooter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
