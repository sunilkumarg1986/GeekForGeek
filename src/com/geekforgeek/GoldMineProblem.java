package com.geekforgeek;

/*
 * Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons. 
 * Initially the miner is at first column but can be at any row. He can move only (right->,right up /,right down\) that is from a given cell, 
 * the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right. 
 * Find out maximum amount of gold he can collect. 
 * 
 * Gold Mine Problem
 */
public class GoldMineProblem {

	public static void main(String[] args) {
		 
		int gold[][] = { {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};
		
		
		int mat[][] = {{10, 33, 13, 15},
                {22, 21, 04, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}};
		
		int col = 4;
		int row = 4;
		
		System.out.println(getMaxGold(gold, col, row));
		System.out.println(getMaxGold(mat, col, row));

	}

	private static int getMaxGold(int[][] gold, int col, int row) {
		for(int c =col-2; c >=0;c--) {
			for(int r =0; r <row; r++) {
				
				int right = gold[r][c+1];  // can go right freely, for column wise movement is always straight or diagonally
				
				int right_up = r==0? 0:gold[r-1][c+1]; //right up means row-1 if row is starting point that is row ==0 then start with with row as 0 , for column wise movement is always straight or diagonally
				
				int right_down = r==row-1?0:gold[r+1][c+1]; //right down mean row +1 and if row-(total-1) is then start with row + 1 , for column wise movement is always straight or diagonally
				
				gold[r][c] = gold[r][c] + Math.max(right,Math.max(right_up, right_down)); // get the max from all 3.that is 2 diagonal and 1 straight and add up with current position
				
			}
		}
		
		int maxGold = gold[0][0];
		for(int i =0;i<row;i++) {
			maxGold = Math.max(maxGold, gold[i][0]); //get the max from all rows and 1st column that from 0 column and iterate rows
			
		}
		return maxGold;
	}

}
