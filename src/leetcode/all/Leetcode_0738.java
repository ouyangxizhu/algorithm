package leetcode.all;

public class Leetcode_0738 {
    public int monotoneIncreasingDigits(int N) {
        char[] res = (N + "").toCharArray();
        int p = 0;
        for (int i = 1; i < res.length; i++) {
            if (res[i] > res[i - 1]) {
                p = i;
            }
            if (res[i] < res[i - 1]) {
                break;
            }
        }
        if (p == res.length - 1) {
            return N;
        }
        for (int i = p + 1; i < res.length; i++) {
            res[i] = '0';
        }
        return Integer.valueOf(new String(res)) - 1;
    }

    public static void main(String[] args) {
        new Leetcode_0738().monotoneIncreasingDigits(1234);
    }
}
