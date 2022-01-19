package telran.util;
//IlyaL HW31
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

class MyArrayTest {
	int DEFULT_VALUE = 20;
	int ARRAY_LENGTH = 30;
	MyArray myArray;

	@BeforeEach
	void setUp() throws Exception {
		myArray = new MyArray(ARRAY_LENGTH);
	}

	@Test
	void testMyArray() {
		MyArray newArray = new MyArray(ARRAY_LENGTH);
		assertEquals(newArray.getValueAt(ARRAY_LENGTH-1), newArray.getValueAt(0));
		assertEquals(0, newArray.getValueAt(ARRAY_LENGTH-1));
	}

	@Test
	void testSetValue() {
		assertEquals(0, myArray.getValueAt(ARRAY_LENGTH-1));
		myArray.setValue(DEFULT_VALUE);
		assertEquals(myArray.getValueAt(ARRAY_LENGTH-1), myArray.getValueAt(0));
		assertEquals(DEFULT_VALUE, myArray.getValueAt(ARRAY_LENGTH-1));
	}

	@Test
	void testGetValueAt() {
		myArray.setValueAt(0, 12);
		assertEquals(12, myArray.getValueAt(0));
		assertEquals(0, myArray.getValueAt(1));
		boolean exception = false;
		int index = ARRAY_LENGTH;
		try {
			myArray.getValueAt(index);
		} catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("testGetValueAt "+ex.toString() + " index="+index);
			exception = true;
		}
		assertTrue(exception);
	}

	@Test
	void testSetValueAt() {
		myArray.setValueAt(0, 12);
		assertEquals(12, myArray.getValueAt(0));
		assertEquals(0, myArray.getValueAt(1));
		boolean exception = false;
		int index = -2;
		try {
			myArray.setValueAt(100, index);
		} catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("testSetValueAt "+ex.toString() + " index="+index);
			exception = true;
		}
		assertTrue(exception);
	}

}
