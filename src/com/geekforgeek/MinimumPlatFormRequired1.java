package com.geekforgeek;

/*
 * Minimum Number of Platforms Required for a Railway/Bus Station
 * Given the arrival and departure times of all trains that reach a railway station, 
 * the task is to find the minimum number of platforms required for the railway station so that no 
 * train waits. We are given two arrays that represent 
 * the arrival and departure times of trains that stop.
 */

public class MinimumPlatFormRequired1 {

	public static void main(String[] args) {

		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = 6;
        System.out.println(findPlatform(arr, dep, n));
	}
	
	public static int findPlatform(int arr[], int dep[], int n) {
		
		int count = 0;
		int result =1;
		
		for(int a=0;a<n;a++) {
			count = 1;
			for(int b=a+1;b<n;b++) {
				
				if(Math.max(arr[a], arr[b]) <= Math.min(dep[a], dep[b])) {
					count++;
					
				}
			}
			result = Math.max(result, count);
		}
		return result;
	}

}
