package Contacts;

public class contacts {
	private String id;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String address;
	public contacts(String id, String firstName, String lastName, String phoneNum, String address) {
		if (id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid id");
		}
		if (firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if (lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		if (phoneNum == null || phoneNum.length()!= 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		if (address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.address = address;
		
	}
	public String getId() {
		return this.id;
	}
	public String getfirstName() {
		return this.firstName;
	}
	public String getlastName() {
		return this.lastName;
	}
	public String getPhoneNum() {
		return this.phoneNum;
	}
	public String getAddress() {
		return this.address;
	}
	public void setFirstName(String name) {
		if (name == null || name.length()>10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		this.firstName = name;
	}
	public void setLastName(String name) {
		if (name == null || name.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.lastName = name;
	}
	public void setNumber(String num) {
		if (num == null || num.length()!= 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		this.phoneNum = num;
	}
	public void setAddress(String address) {
		if (address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.address = address;
	}
}


