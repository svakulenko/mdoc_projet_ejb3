package servletMenus;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.BaseServlet;

/**
 * Servlet implementation class menuShowUpdateFormEntreprise
 */
public class menuShowUpdateFormEntreprise extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menuShowUpdateFormEntreprise() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("menuShowUpdateFormEntreprise::doGet");
		String id = request.getParameter("id");
		System.out.println("id=" + id);
		long idL = Long.parseLong(id);
		System.out.println("id=" + idL);
		String dbOutput = daoEntreprise.getUpdateForm2(id);
//		
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
