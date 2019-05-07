package leetcode.explorer;

/**
 * Created by ouyangxizhu on 2019/4/20.
 */
public class Explorer1 {
    public static void main(String[] args){
        int[] a = {7,1,5,3,6,4};
        System.out.println(maxProfit(a));

    }
    public static int maxProfit(int[] prices) {
        if (prices.length==1) {
            return 0;
        }
        int max = 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum+= prices[i]-prices[i-1];
            max = Math.max(max, sum);
            sum=Math.max(0, sum);
        }
        return max;
    }
}
