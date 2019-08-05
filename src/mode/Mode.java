package mode;

import sun.font.FontRunIterator;

public class Mode {
    public static void main(String[] args) {
        int[][] dp = new int[12][23];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = 0;
            }
        }

    }
}
