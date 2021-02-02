package leetcode.all;

import org.omg.CORBA.INTERNAL;

public class Leetcode_0012 {
    public String intToRoman(int num) {
        final int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] romens = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            int tempNum = nums[i];
            while (tempNum <= num) {
                num -= tempNum;
                stringBuilder.append(romens[i]);
            }
        }
        return stringBuilder.toString();

    }
}
