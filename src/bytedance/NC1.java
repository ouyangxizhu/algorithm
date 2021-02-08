package bytedance;

public class NC1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        int left, right;
        int num;
        for (left = s.length() - 1, right = t.length() - 1; left >= 0 && right >= 0; left--, right--) {
            num = s.charAt(left)- '0' + t.charAt(right) - '0' + flag;
            sb.append(num % 10);
            flag = num/10;
        }
        while (right >= 0) {
            num = t.charAt(right) - '0' + flag;
            sb.append(num % 10);
            flag = num/10;
            right--;
        }

        while (left >= 0) {
            num = s.charAt(left) - '0' + flag;
            sb.append(num % 10);
            flag = num/10;
            left--;
        }
        if (flag != 0) {
            sb.append(flag);
        }
        return sb.reverse().toString();
    }
}
