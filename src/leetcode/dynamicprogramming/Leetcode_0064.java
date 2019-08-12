package dynamicprogramming;
/*
 *����һ�������Ǹ������� m x n �������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С��

˵����ÿ��ֻ�����»��������ƶ�һ����

ʾ��:

����:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
���: 7
����: ��Ϊ·�� 1��3��1��1��1 ���ܺ���С��
 */
public class Leetcode_0064 {
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
