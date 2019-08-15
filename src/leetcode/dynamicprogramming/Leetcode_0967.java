package leetcode.dynamicprogramming;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode_0967 {
    Set<Integer> set;
    int n;
    int k;
    public int[] numsSameConsecDiff(int N, int K) {
        set = new HashSet<>();
        this.n = N;
        this.k = K;
        for (int i = 0; i < 10; i++) {
            helper(1, i);
        }
        int[] res = new int[set.size()];
        List<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < set.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private void helper(int m,int num) {
        if(m > 1 && num/10 == 0)
            return;
        if (m == n) {
            set.add(num);
            return;
        }
        int tail = num % 10;
        if(tail + k < 10)
            helper(m + 1, num * 10 + tail + k);
        if (tail - k >= 0)// 这可以加上k！=0的判断就不用set去重了。
            helper(m + 1, num * 10 + tail - k);

    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_0967().numsSameConsecDiff(3, 7));
    }
}
