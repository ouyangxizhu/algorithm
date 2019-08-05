package leetcode.hot_100;

public class Hot_581 {
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        int left = nums.length - 1;
        int right = 0;
        int max = nums[0];
        int min = nums[nums.length -1];
        //左-右，max记录经历过的最大值，找出最右边的比max小的值
        for (int i = 0; i < nums.length; i++) {

            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < max)
                right = i;
        }
        //右-左，min记录经历过的最小值，找出最左边的比min大的值
        for (int i = nums.length - 1; i >= 0 ; i--) {

            if(nums[i] < min)
                min = nums[i];
            if(nums[i] > min)
                left = i;

        }
        int res = right - left + 1 ;
        return res < 0 ? 0:res;
    }

    public static void main(String[] args) {
        System.out.println(new Hot_581().findUnsortedSubarray(new int[] {2,6,4,8,10,9,15}));
    }
}
