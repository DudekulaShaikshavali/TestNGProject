package com.pack;

public class Primenumber {
public static void main(String[] args) {
	int number=4;
	boolean isPrime=false;
	
	for(int i=2;i<number/2; i++) {
		if(number % i==0) {
			isPrime=true;
			break;
		}
	}
	
	if(!isPrime) {
		System.out.println("the number is prime: " +number);
	}else {
		System.out.println("the number is  not prime: " +number);
	}
	
	
}
}
