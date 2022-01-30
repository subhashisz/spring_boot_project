package com.myapp.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PalindromeTest {

	@Test
	public void whenEmptyString_thenAccept() {
		Palindrome palindromeTester = new Palindrome();
		assertTrue(palindromeTester.isPalindrome(""));
	}

	@Test
	public void whenPalindrom_thenAccept() {
		Palindrome palindromeTester = new Palindrome();
		assertTrue(palindromeTester.isPalindrome("noon"));
	}

	@Test
	public void whenNearPalindrom_thanReject() {
		Palindrome palindromeTester = new Palindrome();
		assertFalse(palindromeTester.isPalindrome("neon"));
	}

}
