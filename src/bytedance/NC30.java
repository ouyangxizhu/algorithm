package bytedance;

public class NC30 {
    /**
     * return the min number
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int minNumberdisappered (int[] arr) {
        int num = 0;
        for (int a : arr) {
            if (a > 0) num ^= a; // 0 ^ 1 ^ 1 ^ 2 ^ 2 = 0, 0 ^ 1 ^ 2 ^ 2 = 1
        }
        for (int i = 1; i <= arr.length; ++i) {
            num ^= i; // 如果某个数不存在， num将不为0
        }
        return num == 0? arr.length + 1 : num;
    }
}
