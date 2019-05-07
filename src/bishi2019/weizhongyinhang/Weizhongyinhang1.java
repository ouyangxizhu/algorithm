package bishi2019.weizhongyinhang;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/11.
 */
public class Weizhongyinhang1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        int num = n;
        for (int i = 1; i <= num - 1; i++){
            pre = (pre + m - 1)%n;
            n--;
            int rem = list.remove(pre);
            sb.append(rem + " ");
        }
        System.out.println(sb.toString().trim());
        System.out.println(list.get(0));
    }
}
