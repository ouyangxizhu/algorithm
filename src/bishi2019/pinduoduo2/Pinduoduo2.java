package bishi2019.pinduoduo2;


import java.util.Scanner;

/**
 *
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Pinduoduo2 {
    /**
     *
     * @param args
     */

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] a = new int[26];
        for(String s2 : s1){
            if(s2.length() == 1){
                a[s2.charAt(0) - 'A']++;
                a[s2.charAt(0) - 'A']++;
            }
            a[s2.charAt(0) - 'A']++;
            a[s2.charAt(s2.length() - 1) - 'A']++;
        }
        for(int m : a){
            if ((m & 1) == 1){
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);

    }
}
