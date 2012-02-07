package servlet;

import generator.website.T_AddContactFull;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResetToDefault
 */
public class ResetToDefault extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetToDefault() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ResetToDefault::doGet ");
		
		System.out.println("reset tables ...");
		daoContact.clearTable();
		
		System.out.println("init tables with some values...");
		
		String dbOutput = null;
		{ // INIT CONTACT
		String[] fn = {"Lerroy", "Bill", "Joshua"};
		String[] ln = {"Willrou", "Gates", "Golden"};
		String[] em = {"willrou@gmail.com", "gates@gmail.com", "golden@gmail.com"};
		String[] st = {"15 republique","3 Nation", "69 rue de Jussieu"};
		String[] ct = {"Paris", "Bordeux", "Lille"};
		String[] zp = {"72000", "90000","38000"};
		String[] cn = {"France","France","France"};
		String[] pk = {"Nokia", "BlackBerry","Iphone"};
		String[] pn = {"00112233","44332211","55556666"};
		String[] gp = {"Work","Home","Work"};
		
		
		for (int i = 0; i < gp.length; i++) {
				dbOutput = daoContact.addContact(
					fn[i], 
					ln[i], 
					em[i], 
					st[i], 
					ct[i], 
					zp[i], 
					cn[i], 
					pk[i], 
					pn[i],
					gp[i]
					);
		}
		}
		
		dbOutput = null;
		{ // INIT ENTREPRISE
		String[] fn = {"Bruce", "Marta", "Bill"};
		String[] ln = {"Willis", "Stuart", "Clinton"};
		String[] em = {"bruce@gmail.com", "stuart@gmail.com", "clinton@gmail.com"};
		String[] st = {"30 hollywood","55 Scotland Yard", "44 whiteHouse"};
		String[] ct = {"Hollywood", "Dublin", "Wachington"};
		String[] zp = {"20000", "10000","05000"};
		String[] cn = {"USA","Scotland","USA"};
		String[] pk = {"Android", "Android","Android"};
		String[] pn = {"0000000","9999999","8888888"};
		String[] gp = {"Work","Work","Work"};
		String[] ns = {"2222","3333","4444"}; 
		
		
		for (int i = 0; i < gp.length; i++) {
				dbOutput = daoEntreprise.addEntreprise(
					fn[i], 
					ln[i], 
					em[i], 
					st[i], 
					ct[i], 
					zp[i], 
					cn[i], 
					pk[i], 
					pn[i],
					ns[i],
					gp[i]
					);
		}
		}
		
		
	

		dbOutput = daoContact.getAllContacts();		
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

	}
}
