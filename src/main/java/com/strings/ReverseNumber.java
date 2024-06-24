package com.strings;

public class ReverseNumber {
	public static void main(String[] args) {
		
		int num=984;	
		int reverse=0;
//		int origin=num;
		
		while(num!=0) {
			int remain= num % 10;
			reverse=reverse * 10 + remain;
			num = num / 10;
		}
		System.out.println(reverse);
		
//		if(origin == reverse) {
//			System.out.println(origin + ":the number is palindrome");
//		}else {
//			System.out.println(origin + ":the number is not palindrome");
//		}
	}

}
