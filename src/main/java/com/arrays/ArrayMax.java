package com.arrays;

public class ArrayMax {
	public static void main(String[] args) {
		int a[]= {5,7,8,9,6};
		int max=a[0];
		int secmax=a[0];
		for(int i=0;i<a.length;i++) {
			if(a[i] > max) {
			secmax=max;
			max=a[i];
				
			}else if(a[i] > secmax) {
				secmax=a[i];
			}
		}
		System.out.println(max);
		System.out.println(secmax);
	}

}
