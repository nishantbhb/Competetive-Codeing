package com.nishant.practice;

public class Solution {

	public static void main(String[] args) {
		String s = new String();
		System.out.println(s);
		s = "Hello";
		System.out.println(s);
		s.concat(" World");
		System.out.println(s);
		String s1 = " World";
		s.concat(new String(" World"));
		System.out.println(s);
		s.concat(s1);
		s += s1;
		System.out.println(s);
	}
}