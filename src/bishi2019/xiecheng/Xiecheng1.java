package bishi2019.xiecheng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * a,b,c,d
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Xiecheng1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < split.length; i++){
            if (hashSet.contains(split[i])){
                System.out.println("true");
                return;
            }else
                hashSet.add(split[i]);
        }
        System.out.println("false");



    }
}
