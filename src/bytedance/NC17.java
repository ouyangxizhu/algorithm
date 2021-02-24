package bytedance;

public class NC17 {
    public int getLongestPalindrome1(String arr, int n) {
        if (arr == null) {
            return 0;
        }
        if (n <= 1) {
            return n;
        }
        char[] chars = arr.toCharArray();
        int max = 0;
        for (int i = 0; i < arr.length() - 1; i++) {
            max = Math.max(max, Math.max(getLongestPalindrome(chars, i, i), getLongestPalindrome(chars, i, i + 1)));
        }
        return max;
    }

    public int getLongestPalindrome(char[] arr, int left, int right) {
        while (left >= 0 && right < arr.length) {
            if (arr[left] != arr[right]) {
                break;
            } else {
                left--;
                right++;
            }
        }
        return right - left + 1 - 2;
    }

    public int getLongestPalindrome(String arr, int n) {
        if (arr == null) {
            return 0;
        }
        if (n <= 1) {
            return n;
        }
        char[] chars = arr.toCharArray();
        //dp[i][j] 表示以i开始，j结束的字符串是不是会文字串
        boolean[][] dp = new boolean[n][n];
        int max = 1;
        for (int i = 0; i < arr.length(); i++) {
            dp[i][i] = true;
            for (int j = i - 1; j >= 0; j--) {
                if (j == i - 1) {
                    dp[j][i] = chars[i] == chars[j];
                } else {
                    if (dp[j + 1][i - 1] && chars[j] == chars[i]) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = false;
                    }
                }
                if (dp[j][i]) {
                    max = Math.max(max, i - j + 1);
                }
            }
        }
        return max;
    }
}
