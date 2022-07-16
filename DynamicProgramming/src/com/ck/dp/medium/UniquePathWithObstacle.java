package com.ck.dp.medium;

public class UniquePathWithObstacle {

	public static void main(String[] args) {
		int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePathsWithObstacles(grid));
	}
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return fetchUniquePaths(obstacleGrid,0,0,new int[obstacleGrid.length][obstacleGrid[0].length]);
    }
    
    public static int fetchUniquePaths(int[][] arr, int r, int c, int[][] memo){
        if(r>=arr.length || c>=arr[0].length || arr[r][c]==1){
            return 0;
        }
        if(r==arr.length-1 && c==arr[0].length-1){
            return 1;
        }
        if(memo[r][c]!=0){
            return memo[r][c];
        }
        int res = fetchUniquePaths(arr, r, c+1, memo);
        memo[r][c] += res;
        res = fetchUniquePaths(arr, r+1, c, memo);
        memo[r][c] += res;
        
        return memo[r][c];
    }

}
