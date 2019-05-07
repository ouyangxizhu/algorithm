package bishi2019.tencent;

import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/5.
 */
public class Tencent2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String str = sc.nextLine();

        while (str.contains("01")){
            str = str.replace("01", "");
        }
        while (str.contains("10")){
           str = str.replace("10", "");
        }
        System.out.println(str.length());

    }
}
