package com.aparna.jdvu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Aparna R
 *
 */
public class IsTenSubstrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long starttime = System.currentTimeMillis();
		Scanner in = new Scanner(System.in);
		System.out.print("Input a number N= ");
		int n = in.nextInt();
		in.close();
		if(n < 0){
			System.out.println("That was not a positive number :(");
		}else{
		
		ArrayList<Integer> friends = getFriends(n);
		System.out.print("{");
		boolean first = true;
		for(int i : friends){
			if(first){
				System.out.print(i);
				first = false;
			}else
				System.out.print(", "+i);
		}
		System.out.print("}");
		}
	System.out.println("\nTime taken: "+ ((System.currentTimeMillis() - starttime)/1000) +" seconds");
	}
	/**
	 * @param n input integer
	 * @return valid integers
	 */
	public static ArrayList<Integer> getFriends(int n){
		ArrayList<Integer> f = new ArrayList<Integer>();
		for(int i = 0; i < n; i++){
			if(isFriendly(""+i))
			f.add(i);
		}
		return f;
	}
	
	/**
	 * @param s
	 * @return if the entered number is valid integer
	 */
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
	
	
	/**
	 * @param s
	 * @return if the integer is valid
	 */
	public static boolean isFriendly(String s){
		int lastIndex = 0; 
		for(int i = 0; i < s.length(); i++){
			int sum = 0;
			int j = 1;
			do{
				try{
					if(!isInteger(s.substring(i+j-1,i+j)))return false;
					//for testcases, function should return true or false
				sum += Integer.parseInt(s.substring(i+j-1,i+j));
				}catch(NumberFormatException e){
					e.printStackTrace();
				}
				if(sum < 10)
				j++;
			}while(sum < 10 && i + j <= s.length());
			
			if(sum == 10){
				if(i <= lastIndex){
					if(j >= lastIndex){
					lastIndex = i+j;
					continue; 
					}
				}else{
					return false;
				}
					
			}
		}
		if(lastIndex == s.length())
			return true;
		else
			return false;
	}
	
	
}
