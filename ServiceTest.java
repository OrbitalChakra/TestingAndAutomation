package Contacts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ServiceTest {
	ContactService service = new ContactService();
	@Test
	void testServiceCreateContact() {
		
		service.CreateContact("Richard", "Pangelinan", "5105551301", "123 Fake St");
		contacts contact = service.getContact("1");
		assertTrue(contact.getfirstName().equals("Richard"));
	}
	@Test 
	void testServiceCreateLongFirstName(){
		assertThrows(IllegalArgumentException.class, () -> {
			service.CreateContact("Apu", "Nahasapeemapetilon", "5105551301", "123 Fake St");
		});
	}
	@Test 
	void testServiceCreateNullFirstName(){
		assertThrows(IllegalArgumentException.class, () -> {
			service.CreateContact(null, "Pangelinan", "5105551301", "123 Fake St");
		});
	}
	void testServiceCreateLongLastName(){
		assertThrows(IllegalArgumentException.class, () -> {
			service.CreateContact("Bartholomew", "Simpson", "5105551301", "123 Fake St");
		});
	}
	@Test 
	void testServiceCreateNullLastName(){
		assertThrows(IllegalArgumentException.class, () -> {
			service.CreateContact("Richard", null, "5105551301", "123 Fake St");
		});
	}
	@Test 
	void testServiceCreateLongNumber() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.CreateContact("Richard", "Pangelinan", "15105551301", "123 Fake St");
		});
	}
	@Test
	void testServiceCreateShortNumber() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.CreateContact("Richard", "Pangelinan", "5551301", "123 Fake St");
		});
	}
	@Test 
	void testServiceCreateNullNumber(){
		assertThrows(IllegalArgumentException.class, () -> {
			service.CreateContact("Richard", "Pangelinan", null, "123 Fake St");
		});
	}
	@Test
	void testServiceCreateLongAddress() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.CreateContact("Richard", "Pangelinan", "15105551301", "557894 Big Brothers and Big Sisters of NYC Way");
		});
	}
	@Test 
	void testServiceCreateNullAddress(){
		assertThrows(IllegalArgumentException.class, () -> {
			service.CreateContact("Richard", "Pangelinan", "5105551301", null);
		});
	}
	@Test 
	void testServiceDeleteContact() {
		contacts newContact = service.CreateContact("Richie", "Pangelinan", "5105551301", "123 Fake St");
		contacts value = service.getContact("1");
		System.out.println(value.getId());
		assertTrue(service.DeleteContact(value.getId()));
	}
	@Test 
	void testServiceUpdateContactFirstName(){
		contacts newContact = service.CreateContact("Richie", "Pangelinan", "5105551301", "123 Fake St");
		service.UpdatefirstName("1", "Richard");
		assertTrue(service.getContact("1").getfirstName().equals("Richard"));
	}
	@Test 
	void testServiceUpdateContactLastName(){
		contacts newContact = service.CreateContact("Richie", "Pangelinan", "5105551301", "123 Fake St");
		service.UpdateLastName("1", "Richardson");
		assertTrue(service.getContact("1").getlastName().equals("Richardson"));
	}
	@Test 
	void testServiceUpdateContactNumber(){
		contacts newContact = service.CreateContact("Richie", "Pangelinan", "5105551301", "123 Fake St");
		service.UpdateNumber("1", "4155551301");;
		assertTrue(service.getContact("1").getPhoneNum().equals("4155551301"));
	}
	@Test 
	void testServiceUpdateContactAddress(){
		contacts newContact = service.CreateContact("Richie", "Pangelinan", "5105551301", "123 Fake St");
		service.UpdateAddress("1", "123 High St");
		assertTrue(service.getContact("1").getAddress().equals("123 High St"));
	}
	@Test 
	void testServiceUpdateFailedFirstNameLong() {
		contacts newContact = service.CreateContact("Richie", "Pangelinan", "5105551301", "123 Fake St");
		assertThrows(IllegalArgumentException.class, () ->{
			service.UpdatefirstName("1", "Bartholomew");
		});
	}
	@Test
	void testServiceUpdateFailedLastNameLong() {
		contacts newContact = service.CreateContact("Richie", "Pangelinan", "5105551301", "123 Fake St");
		assertThrows(IllegalArgumentException.class, () ->{
			service.UpdateLastName("1", "Nahasapeemapetilon");
		});
	}
	@Test
	void testServiceUpdateFailedPhoneNumLong() {
		contacts newContact = service.CreateContact("Richie", "Pangelinan", "5105551301", "123 Fake St");
		assertThrows(IllegalArgumentException.class, () ->{
			service.UpdateNumber("1", "15105551301");
		});
	}
	@Test
	void testServiceUpdateFailedPhoneNumShort() {
		contacts newContact = service.CreateContact("Richie", "Pangelinan", "5105551301", "123 Fake St");
		assertThrows(IllegalArgumentException.class, () ->{
			service.UpdateNumber("1", "5551301");
		});
	}
	@Test
	void testServiceUpdateFailedAddressLong() {
		contacts newContact = service.CreateContact("Richie", "Pangelinan", "5105551301", "123 Fake St");
		assertThrows(IllegalArgumentException.class, () ->{
			service.UpdateAddress("1", "557894 Big Brothers and Big Sisters of NYC Way");
		});
	}
	@Test 
	void testServiceIDisUnique() {
		contacts newContact1 = service.CreateContact("Richie", "Pangelinan", "5105551301", "123 Fake St");
		contacts newContact2 = service.CreateContact("Taylor", "Swift", "6465555555", "New York, NY 10027");
		assertTrue(newContact1.getId()!=newContact2.getId());
				
	}
	@Test
	void testServiceUpdateFailedFirstNameNull() {
		service.CreateContact("Richie", "Pangelinan", "5105551301", "123 Fake St");
		assertThrows(IllegalArgumentException.class, () -> {
			service.UpdatefirstName("1", null);
		});
		
	}
	@Test
	void testServiceUpdateFailedLastNameNull() {
		service.CreateContact("Richie", "Pangelinan", "5105551301", "123 Fake St");
		assertThrows(IllegalArgumentException.class, () -> {
			service.UpdateLastName("1", null);
		});
		
	}
	
	@Test
	void testServiceUpdateFailedPhoneNumberNull() {
		service.CreateContact("Richie", "Pangelinan", "5105551301", "123 Fake St");
		assertThrows(IllegalArgumentException.class, () -> {
			service.UpdateNumber("1", null);
		});
		
	}
	@Test
	void testServiceUpdateFailedAddressNull() {
		service.CreateContact("Richie", "Pangelinan", "5105551301", "123 Fake St");
		assertThrows(IllegalArgumentException.class, () -> {
			service.UpdateAddress("1", null);
		});
		
	}
	
}
