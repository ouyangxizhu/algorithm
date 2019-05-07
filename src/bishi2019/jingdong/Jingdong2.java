package bishi2019.jingdong;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/13.
 */
public class Jingdong2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }
        String t = sc.nextLine();
        int sum = 0;
        Arrays.sort(strs, (o1, o2) -> o1.length() - o2.length());
        for (int i = 0; i < n; i++) {
            String s = strs[i];
            while (t.contains(s)){
                sum++;
                t = t.replaceFirst(s, " ");
            }
        }
        System.out.println(sum);
    }
}
