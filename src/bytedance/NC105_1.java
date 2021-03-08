package bytedance;

public class NC105_1 {
    /**
     * 请实现有重复数字的升序数组的二分查找
     * 给定一个 元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
     *
     * 从左到右，查找到第1个为4的，下标为2，返回2
     *
     * https://www.nowcoder.com/practice/4f470d1d3b734f8aaf2afb014185b395?tpId=117&tqId=37829&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 如果目标值存在返回下标，否则返回 -1
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search (int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
//                if ((mid > 0 && nums[mid - 1] < target) || mid == 0) {
//                    return mid;
//                } else {
//                    right = mid - 1;
//                }
                while(mid != 0 &&(nums[mid-1] == nums[mid])){
                    mid--;
                }
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
