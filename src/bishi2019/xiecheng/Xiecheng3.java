package bishi2019.xiecheng;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Xiecheng3 {
    public static void main(String args[]) {
        HashMap<String, Integer> hashMap1 = new HashMap<>();//存原始的
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(" ");
        int n = Integer.valueOf(split[0]);
        Integer flag = 0;
        for (int i = 1; i < split.length; i++) {
            String s1 = split[i];
            if (hashMap1.containsKey(s1)){
                hashMap1.put(s1, hashMap1.get(s1) + 1);
                flag = hashMap1.get(s1);
            }else {
                hashMap1.put(s1, 1);
                flag = 1;
            }
            String[] split1 = s1.split("/");
            if (split1.length <= 2){

                for (int j = 1; j < split1.length; j++){
                    System.out.print("1");
                }
                
            }else{
                System.out.print("1");
                for (int j = 2; j < split1.length - 1; j++){
                    System.out.print("" + flag);
                }
                System.out.print("1");
            }
            if(i != split.length - 1)
                System.out.print(" ");
            
        }
        System.out.println();

    }
}
