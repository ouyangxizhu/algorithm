package leetcode.explorer;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

 例如，给定三角形：

 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

 说明：

 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * Created by ouyangxizhu on 2019/4/22.
 */
public class OneTwoZero {
    //二维数组
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        //加1 可以不用初始化第一层
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for(int i = triangle.size() - 1; i >= 0; i--){
            List<Integer> curTr = triangle.get(i);
            for(int j = 0; j < curTr.size(); j ++){
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + curTr.get(j);
            }
        }
        return dp[0][0];

    }
    public int minimumTotal1(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        //加1 可以不用初始化第一层
        int[] dp = new int[triangle.size() + 1];
        for(int i = triangle.size() - 1; i >= 0; i--){
            List<Integer> curTr = triangle.get(i);
            for(int j = 0; j < curTr.size(); j ++){
                dp[j] = Math.min(dp[j], dp[j + 1]) + curTr.get(j);
            }
        }
        return dp[0];

    }
    public static void main(String[] args){

    
    }
}
