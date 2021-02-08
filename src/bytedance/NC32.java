package bytedance;

public class NC32 {
    /**
     *
     * @param x int整型
     * @return int整型
     */
    public int sqrt (int x) {
        if (x <= 0) {
            return 0;
        }
        long left = 1;
        long right = x;
        while (left <= right) {
            long mid = left + ((right - left) >>> 1);
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return (int)mid;
            }
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(new NC32().sqrt(1518991037));
    }
}
