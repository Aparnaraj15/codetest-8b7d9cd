package testcases;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import com.aparna.jdvu.*;;

public class IsTenSubstringsTest {

	IsTenSubstrings ten = new IsTenSubstrings();
	 // Only characters
	/**
	 * test case for testing character input
	 */
	@Test
		public void testOnlyCharacter() {
			String s = "abcdefghij";
			assertEquals(false,IsTenSubstrings.isFriendly(s));
		}	
	/**
	 * test case for testing numbers
	 */
	// Only numbers
	@Test
	public void testOnlyNumber() {
		String s = "111110111101";
		assertEquals(true,IsTenSubstrings.isFriendly(s));
	}
	/**
	 * test case for testing characters
	 */
	// Only special characters
	@Test
	public void testSpecialCharacter() {
		String s = "!@#$%^&*()";
		assertEquals(false,IsTenSubstrings.isFriendly(s));
	}
	/**
	 * test cases for testing alpha numerics
	 */
	// Only alphanumeric
	@Test
	public void testAlphaNumeric() {
		String s = "abghd757dd";
		assertEquals(false,IsTenSubstrings.isFriendly(s));
	}
	/**
	 * test case for Special characters + Number
	 */
	//Only  Special characters + Number
	@Test
	public void testSpecialCharactersPlusNumber() {
		String s = "658%865@";
		assertEquals(false,IsTenSubstrings.isFriendly(s));
	}
	/**
	 * test case for zero
	 */
	// Only zero
	@Test
	public void testOnlyZero() {
		String s = "0";
		assertEquals(false,IsTenSubstrings.isFriendly(s));
	}
	/**
	 * test case for empty string
	 */
	// Empty String
	@Test
	public void testEmptyString() {
		String s = " ";
		assertEquals(false,IsTenSubstrings.isFriendly(s));
	}
	/**
	 * test case for null
	 */
	// Null
	@Test
	public void testNull() {
		String s = "null";
		assertEquals(false,IsTenSubstrings.isFriendly(s));
	}
	/**
	 * test case for valid number
	 */
	// 10Friendly Number
	@Test
	public void testFriendly() {
		String s = "3523014";
		assertEquals(true,IsTenSubstrings.isFriendly(s));
	}
	/**
	 * test for non friendly number
	 */
	// Non Friendly Number
	@Test
	public void testNonFriendly(){
		String s = "123";
		assertEquals(false,IsTenSubstrings.isFriendly(s));
	}
	/**
	 * test for non friendly number
	 */
	// Same Non Friendly Number
	@Test 
	public void testSameNonFriendly(){
		String s = "55755";
		assertEquals(false,IsTenSubstrings.isFriendly(s));
	}
	/**
	 * test for Different Non Friendly Number
	 */
	// Different Non Friendly Number
	@Test 
	public void testDifferentNonFriendly(){
		String s = "5678443";
		assertEquals(false,IsTenSubstrings.isFriendly(s));
	}
	/**
	 * test for first hundred and fifty numbers
	 */
	// First Hundred and Fifty Numbers
	public void testFirstHundredFifty(){
		int[] computation = new int[]{19,28,37,46,55,64,73,82,91,109,118,127,136,145};
		ArrayList<Integer> results = IsTenSubstrings.getFriends(150);
		for(int i = 0; i < computation.length; i++){
			int result = results.get(i);
			assertEquals(computation[i],result);
		}
		assertEquals(computation.length,results.size());
	}
}
