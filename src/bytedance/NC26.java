package bytedance;

import java.util.ArrayList;

public class NC26 {
    /**
     *
     * @param n int整型
     * @return string字符串ArrayList
     */
    public ArrayList<String> generateParenthesis (int n) {
        ArrayList<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private void generate(ArrayList<String> result, String s, int left, int right, int n) {
        if (s.length() == (n << 1)) {
            result.add(s);
            return;
        }
        if (left < n) {
            generate(result, s + "(", left + 1, right, n);
        }
        if (right < left) {
            generate(result, s + ")", left, right + 1, n);
        }
    }
}
