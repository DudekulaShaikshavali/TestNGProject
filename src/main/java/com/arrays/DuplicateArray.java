package com.arrays;

public class DuplicateArray {
	public static void main(String[] args) {
		int arr[]= {9,4,9,3,4,2,3,7,5,7,1};
	
		for(int i=0;i<arr.length;i++) {
		for(int j=0;j<i;j++) {
			if(arr[i] ==arr[j]) {
		
				System.out.println(arr[i]);
			
			}
		}
		}
	}

}
