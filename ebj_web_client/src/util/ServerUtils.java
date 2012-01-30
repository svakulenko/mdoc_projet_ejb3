package util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;




public class ServerUtils {
	private static boolean hasContact = false;
	private ServerUtils() {
	}

	static public String getNewParameter(String name, String value) {
		return ("?" + name + "=" + value);
	}
	static public void showParameters(
			String firstName
			, String lastName
			, String email
			, String street
			, String city
			, String zip
			, String country
			, String phoneKind
			, String phoneNumber
			, String numSiret
			){
		
		System.out.println("firstname="+ firstName);
		System.out.println("lastname="+ lastName);
		System.out.println("email="+ email);
		System.out.println("street="+ street);
		System.out.println("city="+ city);
		System.out.println("zip="+ zip);
		System.out.println("country="+ country);
		System.out.println("phonekind="+ phoneKind);
		System.out.println("phonenumber="+ phoneNumber);
		System.out.println("numSiret="+ numSiret);
	}    

}
