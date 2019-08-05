package leetcode.hot_100;

public class Hot_647 {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += count(s, i, i);
            res += count(s, i, i + 1);
        }
        return res;
    }

    private int count(String s, int start, int end) {
        int num = 0;
        while(start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)){
            num++;
        }
        return num;
    }
}
