package com.pack;

public class EvenOrOdd {
	public static boolean isEven(int number) {
		return number % 2 ==0;
	}
	public static boolean isOdd(int number) {
		return number % 2 != 0;
	}
	public static void main(String[] args) {
		int a=13;
		if(isEven(a))
		System.out.println("the number is even: " +a);
		else
			System.out.println("the number is odd: " + a);
	}

}
