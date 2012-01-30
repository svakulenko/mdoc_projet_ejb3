package entityBeans;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.commons.collections.map.HashedMap;

//@Entity
public class ContactGroup 
{
	private int contactGpoupId;
	private String groupName;
	private Set<Contact> contacts = new HashSet<Contact>();
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getContactGpoupId() {
		return contactGpoupId;
	}
	public void setContactGpoupId(int contactGpoupId) {
		this.contactGpoupId = contactGpoupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
//	@ManyToMany(mappedBy = "contactGroups")
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	
	
	
	
	
	
}
