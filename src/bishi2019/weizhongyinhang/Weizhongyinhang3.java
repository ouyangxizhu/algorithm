package bishi2019.weizhongyinhang;

import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/11.
 */
public class Weizhongyinhang3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int j = 0;
            while (m != 1){
                j++;
                if (m == 1){
                    break;
                }else{
                    if ((m & 1) == 1){
                        m = 3 * m + 1;
                    }else{
                        m = m/2;
                    }
                }

            }
            if(m == 1){
                System.out.println(j);
            }else
                System.out.println(-1);

        }
    }
}
