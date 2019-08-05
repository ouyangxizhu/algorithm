package leetcode.hot_100;

import niuke.xiaozhao2017.souhu.Souhu1;

public class Hot_416 {
    //典型的0/1背包问题，在n个物品中选出一定物品，填满sum/2的背包。 使用一维数组记录转移状态
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        //奇数直接返回
        if((sum & 1) == 1)
            return false;
        boolean[] res = new boolean[sum/2 + 1];
        res[0] = true;
        if(nums[0] <= sum/2)
            res[nums[0]] = true;
        for (int i = 1; i < nums.length; i++){
            //j 从大到小遍历，否则会重复放一个物品（一个物品放两次）
            for (int j = sum/2-nums[i]; j >= 0; j--){
                if (res[j] == true){
                    res[j + nums[i]] = true;
                }
            }
            if (res[sum/2] == true){
                return true;
            }

        }
        return false;

    }
    //典型的0/1背包问题，在n个物品中选出一定物品，填满sum/2的背包。 使用二维数组记录转移状态
    public boolean canPartition1(int[] nums) {
        //计算出数组总和
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += nums[i];
        }
        //如果数组元素总和为奇数，直接返回false
        if (sum % 2 != 0){
            return false;
        }

        boolean[][] states = new boolean[n][sum/2 + 1];
        //对第一行元素特殊处理
        states[0][0] = true;
        if(nums[0] <= sum/2)
            states[0][nums[0]] = true;
        //数组最后一列为1，表示满足条件
        if (states[0][sum/2] == true){
            return true;
        }

        for (int i = 1; i < n; i++){   //考虑n个数组元素
            //第i个数组元素不放入
            for (int j = 0; j <= sum/2; j++){
                if (states[i-1][j] == true){    //数组上一行的同一列为true
                    states[i][j] = true;
                }
            }

            //第i个数组元素放入
            for (int j = 0; j <= sum/2 - nums[i]; j++){
                if (states[i-1][j] == true){
                    //数组本行的列+num[i]元素为true
                    states[i][j + nums[i]] = true;
                }
            }

            //数组最后一列为1，表示满足条件
            if (states[i][sum/2] == true){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Hot_416().canPartition(new int[]{1,2,5}));
    }
}
