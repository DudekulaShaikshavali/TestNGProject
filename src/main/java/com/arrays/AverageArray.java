package com.arrays;

public class AverageArray {
public static void main(String[] args) {
	int arr[]= {8,9,7,6,4,5};
	int sum=0;
	int avg=0;
	for(int i=0;i<arr.length;i++) {
		sum += arr[i];
		avg=sum/arr.length;
	}
	System.out.println(sum);
	System.out.println(avg);
}
}
