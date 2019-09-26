package bishi2019.pinduoduo3;

import java.util.*;

public class Main {
	public static <T> void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(";");
        int num = Integer.valueOf(split[1]);

        int[] a = new int[split.length - 1];
        ArrayList<Integer> danshu = new ArrayList<>();
        ArrayList<Integer> shuangshu = new ArrayList<>();

        for (int i = 0; i < split.length - 1; i++) {
            if (i != split.length - 2) {
                a[i] = Integer.valueOf(split[i]);
            } else {
                String substring = split[i].substring(0, split[i].length() - 1);
                a[i] = Integer.valueOf(substring);
            }
        }
        for (int m : a) {

        }

        System.out.println(1);
    }

}
