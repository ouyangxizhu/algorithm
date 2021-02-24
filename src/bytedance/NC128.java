package bytedance;

public class NC128 {
    /**
     * max water
     *
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater(int[] arr) {
        if (null == arr || arr.length < 2) {
            return 0;
        }
        int left = 0;
        int right = arr.length - 1;
        int height = Math.min(arr[left], arr[right]);
        long sum = 0;
        while (left < right) {
            if (arr[left] < arr[right]) {
                left++;
                if (arr[left] < height) {
                    sum += height - arr[left];
                } else {
                    height = Math.min(arr[left], arr[right]);
                }
            } else {
                right--;
                if (arr[right] < height) {
                    sum += height - arr[right];
                } else {
                    height = Math.min(arr[left], arr[right]);
                }
            }
        }
        return sum;
    }
}
