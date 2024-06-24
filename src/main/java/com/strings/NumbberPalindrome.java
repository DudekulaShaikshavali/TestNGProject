package com.strings;

public class NumbberPalindrome {
public static void main(String[] args) {
	int num=121,remain,reverse = 0;
	int number=num;
	while(num != 0) {
		remain=num % 10;
		reverse= reverse * 10 + remain;
		num = num / 10;
	}
	if(number == reverse) {
		System.out.println(number + ":the number is palindrome");
	}else {
		System.out.println(number + ":the number is not palindrome");
	}
}
}
