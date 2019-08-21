package qiuzhao2019.interviewofmeituan;

//https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
public class MediumOfDoubleArray {
    /*
    时间复杂度：O(m+n)
    空间复杂度：O(m+n)

    归并排序全部
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;//新数组长度

        int[] nums = new int[len];
        int end1 = len1 - 1;
        int end2 = len2 - 1;//数组2的尾数
        int end = len - 1;
        while (end1 >= 0 && end2 >= 0) {
            if (nums1[end1] > nums2[end2]) {
                nums[end--] = nums1[end1--];
            } else {
                nums[end--] = nums2[end2--];
            }
        }
        while (end2 >= 0) {
            nums[end--] = nums2[end2--];
        }
        while (end1 >= 0) {
            nums[end--] = nums1[end1--];
        }
        if ((len & 1) != 1) {
            return (double) (nums[len / 2] + nums[len / 2 - 1]) / 2;
        } else {
            return (double) nums[len / 2];
        }
    }

    /*
    时间复杂度：O(m+n)。
    空间复杂度：O(1)。

    只排序前len / 2个数，这里只找到对应末尾的数就可以，不需要重新申请数组空间
     */

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int left = -1, right = -1;
        int index1 = 0, index2 = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;//这里存储了之前的值。
            if (index1 < len1 && (index2 >= len2 || nums1[index1] < nums2[index2])) {
                right = nums1[index1++];
            } else {
                right = nums2[index2++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

    /*
    时间复杂度： O(log(m+n)。
    空间复杂度：O(1)。

    递归。 每一次递归在两个数组中各选出前k/2个数(最小的k/2个数)，
    如果nums1数组选出的数<nums2数组选出的数,则可以排除nums1数组的前k/2个数，
    如果nums2数组选出的数<nums1数组选出的数,则可以排除nums2数组的前k/2个数，
    之后递归找前最小的k - k/2个数(下一次递归的较小的数组左边界为该数的位置+1。)。
     */
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) + getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    /*
    时间复杂度： O(log(min(m，n))。
    空间复杂度： O(1)。

    取长度小的数组作为驱动表，在中间位置进行切分，之后判断对应数组nums2[j - 1] 和 nums1[i]，nums1[i - 1] 和 nums2[j]的大小
    进行相对应的移动，理想情况为nums2[j - 1] <= nums1[i] && nums1[i - 1] <= nums2[j], 这里需要考虑某一个数组已经到边界的情况。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1); // 保证第一个数组的长度小，用小的作为条件，这里很精髓。
        }
        int left = 0, right = len1;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = (len1 + len2 + 1) / 2 - i;//根据中位数判断j的位置，这里将奇数和偶数合并了。
            if (j != 0 && i != len1 && nums2[j - 1] > nums1[i]) { // i 需要增大
                left = i + 1;
            } else if (i != 0 && j != len2 && nums1[i - 1] > nums2[j]) { // i 需要减小
                right = i - 1;
            } else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if (((len1 + len2) & 1) == 1) {// 奇数的话不需要考虑右半部分
                    return maxLeft;
                }

                int minRight = 0;
                if (i == len1) {
                    minRight = nums2[j];
                } else if (j == len2) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }
                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }

}
