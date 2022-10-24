package Contacts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class contactsTest {
	@Test
	void testcontacts() {
		contacts contactsClass = new contacts("1234", "Richard", "Pangelinan", "5105551301", "123 Fake St");
		assertTrue(contactsClass.getfirstName().equals("Richard"));				
	}
	@Test
	void testCreateContactFailedIDLong() {
		assertThrows(IllegalArgumentException.class,() -> {
			contacts contactsClass = new contacts("12345678901", "Richard", "Pangelinan", "5105551301", "123 Fake St");
		});
		
	}
}