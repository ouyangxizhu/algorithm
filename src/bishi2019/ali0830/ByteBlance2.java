package bishi2019.ali0830;

import java.util.Scanner;

public class ByteBlance2 {
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String getIndexAndLongest(String users, int k) {
        char[] chars = users.toCharArray();
        int n = chars.length;
        int[] a = new int[chars.length];//男的周围女的个数
        int max = 0;
        int maxNum =0;
        int count = 0;
        int maxBoyNum = 0;
        for (int i = 0; i < chars.length; i++) {
            count = 0;
            if (!isGril(chars, i)) {
                int j = (i - 1 + n)%n;
                while (j >= 0 && isGril(chars, j)) {
                    a[i]++;
                    j = (j - 1 + n)%n;
                }
                j = (i + 1)%n;
                while (isGril(chars, j)) {
                    a[i]++;
                    j = (j + 1)%n;
                }
                if (a[i] > max) {
                    max = a[i];
                    maxNum = i;
                }
                j = (i + 1)%n;
                while (count <= k) {
                    if (isGril(chars, j)) {
                        count++;
                    }
                    j = (j + 1)%n;
                }
                int num = (j + n - i - 1)%n;
                maxBoyNum = Math.max(num - k, maxBoyNum);
            }
        }
        return maxNum + " " + maxBoyNum;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        int k = 0;
        try {
            _users = in.nextLine();
            k = Integer.valueOf(in.nextLine());
        } catch (Exception e) {
            _users = null;
        }

        res = getIndexAndLongest(_users, k);
        System.out.println(res);
    }

    static boolean isGril(char[] chars, int index) {
        if (chars[index] == 'g') {
            return true;
        } else {
            return false;
        }
    }
}
