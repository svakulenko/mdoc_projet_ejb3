package servlet;

import generator.website.T_jspBody;
import generator.website.T_jspHeader;
import generator.website.T_jspfooter;


import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoInterface.IDAOContact;
import daoInterface.IDAOEntreprise;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(name = "DAOContactBean")
	protected IDAOContact daoContact;
	
	@EJB(name = "DAOEntrepriseBean")
	protected IDAOEntreprise daoEntreprise;
	
	public String checkInput(String fn, String ln, String em, String ns){
		String rvalue = null;
		
		if (fn == null || fn.equals(""))
			rvalue = "First Name";
		else if (ln == null || ln.equals(""))
			rvalue = "Last Name";
		else if (em == null || em.equals(""))
			rvalue = "Email";
		else if ((ns == null || ns.equals("")) && !ns.equals("skip"))
			rvalue = "numSiret";
		
		return rvalue;
	}
	
	
	protected String getHeader(String header){
		
		return new T_jspHeader().generate(header);
	}
	protected String getFooter(){
		return new T_jspfooter().generate(null);
	}
	protected String getBody(String pageName){
		return new T_jspBody().generate(pageName);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaseServlet() {
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
	}

}
