package leetcode.dynamicProgramme;

public class Leetcode_746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length <= 1)
            return 0;
        if(cost.length == 2)
            return Math.min(cost[0], cost[1]);
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < cost.length; i++){
            dp[i] = Math.min(dp[i - 1], dp[i - 2])  + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
    public static void main(String[] args){
        int[] cost = {0, 0, 1, 1};
        System.out.println(new Leetcode_746().minCostClimbingStairs(cost));
    
    }
}
