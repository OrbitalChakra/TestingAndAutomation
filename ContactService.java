package Contacts;
import java.util.HashMap;
public class ContactService{
	private HashMap<String, contacts> hm; 
	private static int idCounter = 0;
	
	public static String createID()
	{
	    return String.valueOf(idCounter+1);
	}
	public ContactService() {
		this.hm = new HashMap<String, contacts>();
	}
	public contacts CreateContact(String firstName, String lastName, String Num, String address) {
		String id = createID();
		contacts newContact = new contacts(id, firstName, lastName, Num, address);
		this.hm.put(id, newContact);
		return newContact;
	}
	public contacts getContact(String id) {
		contacts contact = this.hm.get(id);
		return contact;
	}
	public Boolean DeleteContact(String id) {
		contacts value = this.hm.get(id);
		return this.hm.remove(id, value);
	}
	public void UpdatefirstName(String id, String name) {
		contacts value = this.hm.get(id);
		value.setFirstName(name);
	}
	public void UpdateLastName(String id, String name) {
		contacts value = this.hm.get(id);
		value.setLastName(name);
	}
	public void UpdateNumber(String id, String phoneNum) {
		contacts value = this.hm.get(id);
		value.setNumber(phoneNum);
	}
	public void UpdateAddress(String id, String address) {
		contacts value = this.hm.get(id);
		value.setAddress(address);
	}
}