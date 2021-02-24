package bytedance;

public class NC48 {
    /**
     * @param A      int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] >= arr[left]) {
                if (arr[mid] >= target && arr[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] <= target && arr[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
