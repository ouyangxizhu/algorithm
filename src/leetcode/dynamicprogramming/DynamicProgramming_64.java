package dynamicprogramming;
/*
 *给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class DynamicProgramming_64 {
	public int minPathSum(int[][] grid) {
		int [][] mins = new int [grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i==0&j==0) {
					mins[i][j]= grid[i][j];
				}else if (i==0&&j>0) {
					mins[i][j]= mins[i][j-1]+grid[i][j];
				}else if (j==0&i>0) {
					mins[i][j]= mins[i-1][j]+grid[i][j];
				}else{
					
					mins[i][j]=Math.min(mins[i-1][j]+grid[i][j], mins[i][j-1]+grid[i][j]);
				}
			}
		}
		return mins [grid.length-1][grid[0].length-1];
        
    }
}
