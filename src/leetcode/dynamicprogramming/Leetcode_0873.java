package leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Leetcode_0873 {
    //暴力
    public int lenLongestFibSubseq(int[] A) {
        int N = A.length;
        Set<Integer> S = new HashSet();
        for (int x: A) S.add(x);

        int ans = 0;
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j) {
                /* With the starting pair (A[i], A[j]),
                 * y represents the future expected value in
                 * the fibonacci subsequence, and x represents
                 * the most current value found. */
                int x = A[j], y = A[i] + A[j];
                int length = 2;
                while (S.contains(y)) {
                    // x, y -> y, x+y
                    int tmp = y;
                    y += x;
                    x = tmp;
                    ans = Math.max(ans, ++length);
                }
            }

        return ans >= 3 ? ans : 0;
    }

    //动态规划
    public int lenLongestFibSubseq1(int[] array) {
        if (array == null || array.length < 1)
            return 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            hashMap.put(array[i], i);
        }
        HashMap<Integer, Integer> resHashMap = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                int gap = hashMap.getOrDefault(array[i] - array[j], -1);
                if (gap >= 0 && gap < j) {
                    int num = resHashMap.getOrDefault(gap * array.length + j, 2) + 1;
                    resHashMap.put(j * array.length + i, num);
                    ans = Math.max(ans, num);
                }
            }
        }
        return ans;
    }
}
