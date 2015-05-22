package com.threetier.strings;

import java.io.ByteArrayInputStream;


public class StringDemo {

	public static void main(String[] args) {

		String s1 = "ritesh";
		String s2 = "rit";
		String s3 = "esh";

		String s31 = new String("esh");

		// String s4 = "rit" + s31.intern();

		String s4 = "rit" + s3;
		
		String s5 = new String("RITESH");
		String s6 = new String("ritesh");

		// System.out.println(isPalindrome("ritesh"));

		System.out.println(s1 == s4.intern());
		
		ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(null);
		
		System.out.println(arrayInputStream);

	}

	public static boolean isPalindrome(String str) {
		return isPalindrome(str, 0, str.length() - 1);
	}

	public static boolean isPalindrome(String str, int low, int high) {

		if (high <= low) {
			return true;
		} else if (str.charAt(low) != str.charAt(high)) {
			return false;
		} else
			return isPalindrome(str, low + 1, high - 1);
	}
}
