package telran.util;
//IlyaL HW31  
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//V.R. OK

class MyArrayTest {
	int INITIAL_VALUE = 0;
	int DEFAULT_VALUE = 5;
	int ARRAY_LENGTH = 10;
	MyArray myArray;

	@BeforeEach
	void setUp() throws Exception {
		myArray = new MyArray(ARRAY_LENGTH);
	}

	@Test
	void testMyArray() {
		MyArray newArray = new MyArray(ARRAY_LENGTH);
		assertEquals(INITIAL_VALUE, newArray.getValueAt(0));
		assertEquals(INITIAL_VALUE, newArray.getValueAt(ARRAY_LENGTH-1));
	}

	@Test
	void testSetValue() {
		assertEquals(INITIAL_VALUE, myArray.getValueAt(ARRAY_LENGTH-1));
		myArray.setValue(DEFAULT_VALUE);
		assertEquals(DEFAULT_VALUE, myArray.getValueAt(0));
		assertEquals(DEFAULT_VALUE, myArray.getValueAt(ARRAY_LENGTH-1));
	}

	@Test
	void testGetValueAt() {
		myArray.setValueAt(0, 999);
		assertEquals(999, myArray.getValueAt(0));
		assertEquals(INITIAL_VALUE, myArray.getValueAt(ARRAY_LENGTH-1));
		boolean exception = false;
		int index = ARRAY_LENGTH;
		try {
			myArray.getValueAt(index);
		} catch(ArrayIndexOutOfBoundsException ex) {
			exception = true;
		}
		assertTrue(exception);
	}

	@Test
	void testSetValueAt() {
		myArray.setValueAt(0, 777);
		assertEquals(777, myArray.getValueAt(0));
		assertEquals(INITIAL_VALUE, myArray.getValueAt(ARRAY_LENGTH-1));
		boolean exception = false;
		int index = ARRAY_LENGTH;
		try {
			myArray.setValueAt(100, index);
		} catch(ArrayIndexOutOfBoundsException ex) {
			exception = true;
		}
		assertTrue(exception);
	}

}
