package bishi2019.liyejingdong;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        System.out.println(fun());
        new ArrayList<>();
    }

    private static int fun() {
        int i = 10;
        int m = 0;
        try {
            i = i/m;
            return --i;
        } catch (Exception e) {
            --i;
            return i--;
        } finally {
            --i;
            return i--;
        }
    }
}
