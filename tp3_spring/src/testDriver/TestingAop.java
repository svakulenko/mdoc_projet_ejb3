package testDriver;

//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;

import daoInterface.IDAOContact;
import daoInterface.IDAOEntreprise;

public class TestingAop {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		IDAOEntreprise daoEntreprise = null;
	    //ApplicationContext acx=new FileSystemXmlApplicationContext("WebContent/WEB-INF/applicationContext.xml");  
/*	    // ApplicationContext acx=new ClassPathXmlApplicationContext("com/kogent/beans.xml");   
//	    IMyBean dao = (IMyBean)acx.getBean("hello");
//	    dao.sayHello("1","2");
//	    IDAOContact dao = (IDAOContact)acx.getBean("daoContactProperty");
//	    dao.getAllContacts();
 * 
 * 
*/
//		IDAOEntreprise daoEntreprise = (IDAOEntreprise)acx.getBean("daoEntrepriseProperty");
	    daoEntreprise.getAllEntreprise();
	   
	}

}
