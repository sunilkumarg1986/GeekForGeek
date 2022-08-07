package com.geekforgeek;

import java.util.Arrays;

/*
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of 
 * S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, 
there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class CoinChangeDP8 {

	public static void main(String[] args) {

		int arr[] = {2, 5, 3, 6} ;//{ 1, 2, 3 };
		int m = arr.length;
		int n = 10; //4;

		System.out.println(countWays(arr, m, n));
	}

	public static long countWays(int[] arr, int m, int n) {

		long []table = new long[n+1];
		
		//fill table with 0
		Arrays.fill(table, 0);
		
		// Base case (If given value is 0)
		table[0]=1;
		
		// Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
		for(int i=0;i<m;i++) {
			for(int j=arr[i];j<=n;j++) {
				table[j]+=table[j-arr[i]];
			}
		}


		// count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
		return table[n];

	}

}
