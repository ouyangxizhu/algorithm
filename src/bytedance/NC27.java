package bytedance;

public class NC27 {
    /**
     * 一看到两个字符串的“最值”问题，一般想到二维dp。
     * 很自然地想到把str1前i个字符和str2前j个字符最长公共子串的长度作为dp[i][j]，
     * 但由于子串定义必须是原字符串连续的序列，这样定义无法找到递推关系，
     * 因此需要加限定条件——以str1[i-1]和str2[j-1]结尾的最长公共子串长度。
     * 另外如果找不到这样的子串，应该return "-1"而不是返回空串
     *
     * 最后一个字符，如果相等，是除了最后一个字符串的最大长度+1，否则为0
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return "-1";
        }
        // dp[i][j] str1前i个字符和str2前j个字符（以其为尾字符）的最长公共子串长度
        //定义成XXX.length() + 1 好处理边界条件
        //默认就是0 ，因此不用初始化边界条件
        int max = 0;
        int end = 0;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length() ; i++) {
            for (int j = 1; j <= str2.length() ; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    end = j - 1;
                }
            }
        }
        if (max == 0) {
            return "-1";
        }
        return str2.substring(end + 1 - max, end + 1);
    }

    public static void main(String[] args) {
        String a = "012345";
        System.out.println(a.substring(0, 3));
    }
}
