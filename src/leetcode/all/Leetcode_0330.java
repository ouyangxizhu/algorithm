package leetcode.all;

public class Leetcode_0330 {
    /**
     * 下面是这个贪心算法的流程：
     *
     * 初始化区间 [1, miss) = [1, 1) = 空
     * 每当 n 没有被覆盖
     *  若当前元素 nums[i] 小于等于 miss
     *      将范围扩展到 [1, miss + nums[i])
     *      将 i 增加 1
     *  否则
     *      将 miss 添加到数组，将范围扩展到 [1, miss + miss)
     *      增加数字的计数
     * 返回增加数字的数目
     *
     * 时间复杂度 : O(m+logn)。在每次迭代中，我们或者增加 i ，或者将 miss 加倍。 i增加的总数为 m， miss 加倍的总数为 logn。
     *
     * 空间复杂度 : O(1)。 只需要三个变量：patches，i 和 miss。
     *
     * 链接：https://leetcode-cn.com/problems/patching-array/solution/an-yao-qiu-bu-qi-shu-zu-by-leetcode/
     *
     * @param nums
     * @param n
     * @return
     */
    public int minPatches(int[] nums, int n) {
        int patches = 0, i = 0;
        long miss = 1;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                patches++;
            }
        }
        return patches;

    }
}
