package servletMenus;



import generator.website.T_addContact;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.BaseServlet;

/**
 * Servlet implementation class menuSearchPage
 */
public class menuSearchPage extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menuSearchPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("menuSearchPage::doGet");
	      PrintWriter out = response.getWriter() ;

	      
	      out.println (getHeader(null));
	      out.println (getBody("Search Contact"));
	      
	      
	      String[] inputFormsID = {"SearchEntreprise","SearchContact"};
	      
	      String addContactMenuStr = new T_addContact().generate(inputFormsID);
	      out.println (addContactMenuStr);
	      
	      
	      
	      out.println (getFooter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("menuSearchPage::doPost");
	}

}
