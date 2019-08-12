package leetcode.fentangguo;

import java.util.HashSet;

public class Leetcode_575 {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            hashSet.add(candies[i]);
        }
        int size = hashSet.size();
        if (size >= candies.length/2){
            size = candies.length/2;
        }
        return size;
    }
}
