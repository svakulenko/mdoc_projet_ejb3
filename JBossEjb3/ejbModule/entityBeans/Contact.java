package entityBeans;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Contact")
@Inheritance(strategy=InheritanceType.JOINED)	
public class Contact
{
	
	private String firstName;
	private String lastName;
	private long contactId;
	private String email;
	private Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>();
	private Set<ContactGroup> contactGroups = new HashSet<ContactGroup>();
	private Address address;
//	
//	public Contact(String firstName, String lastName, String email)
//	{
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//	}
//	// default constructer
//	public Contact()
//	{
//		this("", "", "");
//	}
//	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL )
	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	@ManyToMany(mappedBy = "contacts", cascade = CascadeType.PERSIST)
	public Set<ContactGroup> getContactGroups() {
		return contactGroups;
	}
	public void setContactGroups(Set<ContactGroup> contactGroups) {
		this.contactGroups = contactGroups;
	}
	@OneToOne (cascade = CascadeType.ALL)
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}
