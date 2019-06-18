package midmid.sortsort;
/**
 *  颜色分类
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
进阶：

一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
你能想出一个仅使用常数空间的一趟扫描算法吗？
 * @author ouyangxizhu
 *
 */
public class First {
	/**
	 * 关键思路是这样的：扫描一次，用 i 表示当前位置，用 left 表示左边最后一个为 0 的下一个位置，用 right 表示右边最后一个为 2 的上一个位置。
	 * 每当遍历到一个位置时，判断当前值是多少，如果为 0，则直接与 left 交换，然后 left++。
	 * 如果为 2，则与 right 交换，然后 right-- 和 i--（因为不确定交换过来的是什么数，所以要重复判断当前位置）。
	 * i 最多取到第 right 个元素。
	 * 作者：Little丶Jerry
链接：https://www.jianshu.com/p/ea9de4ef1ee0
來源：简书
简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
	 */
	public void sortColors(int[] nums) {

        int left = 0;

        int right = nums.length - 1;

        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
            } else if (nums[i] == 2) {
                swap(nums, right, i);
                right--;
                //i-- 是因为交换了之后还要重复判断交换过来的数是什么
                i--;
            }
        }
    }

    private void swap(int[] nums, int start, int i) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }



}
