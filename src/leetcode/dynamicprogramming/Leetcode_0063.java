package dynamicprogramming;
/*
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����

������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������

���ڿ������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·����
�����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��

˵����m �� n ��ֵ�������� 100��

ʾ�� 1:

����:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
���: 2
����:
3x3 ��������м���һ���ϰ��
�����Ͻǵ����½�һ���� 2 ����ͬ��·����
1. ���� -> ���� -> ���� -> ����
2. ���� -> ���� -> ���� -> ����
 */
public class Leetcode_0063 {
	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		 int [][] ways = new int [obstacleGrid.length][obstacleGrid[0].length];
		 for (int i = 0; i < ways.length; i++) {
			for (int j = 0; j < ways[0].length; j++) {
				if (obstacleGrid[i][j]==1) {
					ways[i][j]=0;
				}else if (i==0&j==0) {
					ways[i][j]=1;
				}else if (i==0&j>0) {
					ways[i][j]=ways[i][j-1];
				}else if (j==0&i>0) {
					ways[i][j]=ways[i-1][j];
				}else {
					ways[i][j]=ways[i][j-1]+ways[i-1][j];
				}
			}
		}
		 return ways[obstacleGrid.length-1][obstacleGrid[0].length-1];
	        
	 }
}
