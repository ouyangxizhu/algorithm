package bytedance;

public class NC57 {
    /**
     *
     * @param x int整型
     * @return int整型
     */
    public int reverse (int x) {
        int ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) {
            return 0;
        }
        return ans;
    }
}
