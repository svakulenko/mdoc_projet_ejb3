package entityBeans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address 
{
	private long addressId;
	private String street;
	private String city;
	private String zip;
	private String country;
	
	public Address()
	{}
	public Address(String street, String city, String zip, String country)
	{
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
}
