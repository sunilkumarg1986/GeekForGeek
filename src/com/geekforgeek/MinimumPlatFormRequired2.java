package com.geekforgeek;

import java.util.Arrays;

/*
 * Minimum Number of Platforms Required for a Railway/Bus Station
 * Given the arrival and departure times of all trains that reach a railway station, 
 * the task is to find the minimum number of platforms required for the railway station so that no 
 * train waits. We are given two arrays that represent 
 * the arrival and departure times of trains that stop.
 */

public class MinimumPlatFormRequired2 {

	public static void main(String[] args) {

		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		int n = 6;
		System.out.println(findPlatform(arr, dep, n));
	}

	public static int findPlatform(int arr[], int dep[], int n) {

		int i = 1;
		int j = 0;
		int count = 1;
		int result = 1;

		Arrays.sort(arr);
		Arrays.sort(dep);

		while (i < n && j < n) {

			if ( arr[i]<=dep[j])  {
				i++;
				count++;

			}else if ( arr[i]>=dep[j])  {
				j++;
				count--;
				
			}
			result = Math.max(result, count);
		}
		return result;
	}

}
