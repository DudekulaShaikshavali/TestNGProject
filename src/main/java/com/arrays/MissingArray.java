package com.arrays;

public class MissingArray {
	public static void main(String[] args) {
		int a[]= {0,2,3,4,5};
		int sum=0;
		int n=a.length + 1;
		int sumall=(n*(n+1))/2;
		for(int i=0;i<a.length;i++) {
			sum +=a[i];
		}
		int miss=sumall-sum;
		System.out.println(miss);
	}

}
