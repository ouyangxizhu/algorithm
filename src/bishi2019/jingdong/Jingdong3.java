package bishi2019.jingdong;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/13.
 */
public class Jingdong3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> leftSet = new HashSet<>();
        HashSet<String> rightSet = new HashSet<>();
        hashSet.add(1 + "");
        String[] split = sc.nextLine().split(" ");
        hashSet.add(split[0]);
        hashSet.add(split[1]);
        leftSet.add(split[0]);
        leftSet.add(split[1]);

        int left = 1;
        int right = 0;
        while (hashSet.size() != n - 1){
            String[] sp = sc.nextLine().split(" ");
            hashSet.add(sp[0]);
            hashSet.add(sp[1]);
            if ((!"1".equals(sp[1])) && leftSet.contains(sp[1])){
                left ++;
                leftSet.add(sp[0]);
            }else{
                right++;
                rightSet.add(sp[0]);
            }


        }
        int num = left > right ? left : right;
        System.out.println(num);

    }

}
