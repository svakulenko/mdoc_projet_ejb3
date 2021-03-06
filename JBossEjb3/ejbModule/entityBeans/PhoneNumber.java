package entityBeans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class PhoneNumber {
	long phoneId;
	String phoneKind;
	String phoneNumber;
	Contact contact;

	public PhoneNumber() {
	}

	public PhoneNumber(String phoneKind, String phoneNumber) {
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}

	@ManyToOne
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneKind() {
		return phoneKind;
	}

	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
