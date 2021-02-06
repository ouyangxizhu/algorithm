package bytedance;

public class NC105 {
    /**
     * https://www.nowcoder.com/practice/7bc4a1c7c371425d9faa9d1b511fe193?tpId=117&tqId=37829&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_ (int n, int v, int[] a) {
        if (a == null || a.length == 0) {
            return 1;
        }
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (a[mid] >= v) {
                if (mid == 0 || a[mid - 1] < v) {
                    return mid + 1;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n + 1;
    }
}
