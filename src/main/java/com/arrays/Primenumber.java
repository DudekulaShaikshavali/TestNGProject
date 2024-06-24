package com.arrays;

public class Primenumber {

	public static void main(String[] args) {
		int num=15;
		int count=0;
		for(int i=1;i<num/2;i++) {
			if(num%i==0) {
			count ++;	
			}
		}
		if(count == 0 && num != 0) {
			System.out.println(num+ ":the number is prime");
		}else {
			System.out.println(num+ ":the number is  not prime");
		}

	}

}
