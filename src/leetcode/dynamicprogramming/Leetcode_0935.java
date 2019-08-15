package leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode_0935 {
    final int MOD = 1_000_000_007;
    public int knightDialer(int N) {

        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        hashMap.put(0, Arrays.asList(4,6));
        hashMap.put(1, Arrays.asList(6,8));
        hashMap.put(2, Arrays.asList(7,9));
        hashMap.put(3, Arrays.asList(4,8));
        hashMap.put(4, Arrays.asList(3,9,0));
        hashMap.put(5, Arrays.asList());
        hashMap.put(6, Arrays.asList(1,7,0));
        hashMap.put(7, Arrays.asList(2,6));
        hashMap.put(8, Arrays.asList(1,3));
        hashMap.put(9, Arrays.asList(2,4));
        int[] a = new int[10];
        int res = 0;

        for (int i = 0; i < 10; i++) {
            a[i] = helper(N, 1, i, hashMap);
        }

        for (int i = 0; i < 10; i++) {
            res += a[i];
            res %= MOD;
        }
        return res;
    }

    private int helper( int n, int ans, int num, HashMap<Integer, List<Integer>> hashMap) {
        if (n == 1){
            return ans % MOD;
        }
        List<Integer> list = hashMap.get(num);
        if (list == null || list.size() == 0){
            return 0;
        }
        int tmp = 0;
        for (int i : list) {
            tmp += helper(n - 1, ans, i, hashMap);
        }
        ans = tmp % MOD;
        return ans;
    }

    public static void main(String[] args) {
        int k = new Leetcode_0935().knightDialer(3);
        System.out.println(k);
    }
}
