package com.strings;

public class ReverseString {
	public static void main(String[] args) {
		String s="abcd";
	
		for(int i=s.length()-1;i>=0;i--){
		char c=s.charAt(i);
		System.out.println(c);
		}
		
	}
}
