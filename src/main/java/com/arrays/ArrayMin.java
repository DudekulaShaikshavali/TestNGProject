package com.arrays;

public class ArrayMin {
	public static void main(String[] args) {
		int arr[]= {5,6,7,3,4};
		int min=arr[0];
		int secmin=arr[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]< min) {
				secmin=min;
				min=arr[i];
				
			}
//			else if(arr[i]<secmin) {
//				secmin=arr[i];
//			}
			
		}
		System.out.println(min);
//		System.out.println(secmin);
		
	}

}
