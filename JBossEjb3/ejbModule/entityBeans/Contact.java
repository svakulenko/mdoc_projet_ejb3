package entityBeans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
	  private long id;   
	  private String firstName;
	  private String lastName;
	  private String email;
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	  public long getId() {return id;}

	  public void setId(long l) {id = l;}
	  public String getEmail() {return email;}

	  public String getFirstName() {return firstName; }

	  public String getLastName() {return lastName; }

	  public void setEmail(String string) {email = string; }

	  public void setFirstName(String string) {firstName = string; }

	  public void setLastName(String string) {lastName = string; }
}