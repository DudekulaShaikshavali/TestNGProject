package com.strings;

public class UniqueString {
public static void main(String[] args) {
	String s="apple tree";
	for(int i=0;i<s.length();i++) {
		char c=s.charAt(i);
		int start=s.indexOf(c);
		int last=s.lastIndexOf(c);
		if(start == last) {
			System.out.println(c);
		}
	}
}
}
