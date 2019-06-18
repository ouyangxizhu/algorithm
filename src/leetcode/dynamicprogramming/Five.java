package dynamicprogramming;
/*
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

说明：m 和 n 的值均不超过 100。

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
 */
public class Five {
	public int uniquePaths(int m, int n) {
		int ans[][]= new int[m][n];
        ans[0][0] = 0;
        for(int i = 0;i<m;i++)//只有一行或者一列的时候，只有一种走法
            ans[i][0] = 1;
        for(int j = 0;j<n;j++)
            ans[0][j] = 1;
        for(int i = 1;i<m;i++)
            for(int j = 1;j<n;j++)
            {
                //每次只能从上面走下来或者从左边走到右边
                ans[i][j] = ans[i-1][j] + ans[i][j-1];
            }
        return ans[m-1][n-1];
    }
}


