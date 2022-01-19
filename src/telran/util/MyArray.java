package telran.util;
import java.util.HashMap;
//IlyaL HW31

// V.R. OK

//all methods should be written with complexity O[1]
public class MyArray {

	private int defaultValue;
	private int length;
	private HashMap<Integer, Integer> numbers = new HashMap<>();
	/**
	 * creates MyArray object with a given length
	 * all elements are set in 0
	 * @param length
	 */
	public MyArray(int length) {
	
		this.length = length;
		defaultValue = 0;
	}
	/**
	 * sets a given value in all array's elements
	 * @param value
	 */  void setValue(int value) {
		
		defaultValue = value;
		numbers = new HashMap<>();
	}
	/**
	 * 
	 * @param index
	 * returns value at a given index value
	 * throws ArrayIndexOutOfBoundsException in the case of wrong index
	 */
	public int getValueAt(int index) {
		
		if(index >= length || index<0) 	throw new ArrayIndexOutOfBoundsException();
		return numbers.getOrDefault(index, defaultValue);
	}
	/**
	 * sets a given value at a given index
	 * @param index
	 * @param value
	 * throws ArrayIndexOutOfBoundsException in the case of wrong index
	 */
	public void setValueAt(int index, int value) {
		
		if(index >= length || index<0) throw new ArrayIndexOutOfBoundsException();
		numbers.put(index, value);
	}
}
