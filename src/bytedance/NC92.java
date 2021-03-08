package bytedance;

public class NC92 {
    /**
     * longest common subsequence
     *
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return "-1";
        }
        //dp[i][j]表示以s1长度为i, s2长度为j 最长公共子序列
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j],  dp[i][j + 1]);
                }
            }
        }
        if (dp[s1.length()][s2.length()] == 0) {
            return "-1";
        } else {
            StringBuilder sb = new StringBuilder();
            int i = s1.length();
            int j = s2.length();
            //这里其实处理了i=0,j=0的，对应公式0的反推场景
            while (i > 0 && j > 0) {
                //反推公式中不相等的场景
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    //该值一定是被选取到的，根据之前的公式，知道两条字符串的下标都前进一位
                    sb.append(s1.charAt(i - 1));
                    i--;
                    j--;
                    //对应公式中不相等的反推场景
                } else {
                    //找大的那个方向，此处是左边大于上面，则该处的结果是来自左边
                    if (dp[i][j - 1] > dp[i - 1][j]) {
                        j--;
                    } else {
                        //这里可以区分相等的情况，用于处理多个答案
                        i--;
                    }
                }
            }
            return sb.reverse().toString();
        }
    }

    public static void main(String[] args) {
        new NC92().LCS("1A2C3D4B56", "B1D23CA45B6A");
    }
}
