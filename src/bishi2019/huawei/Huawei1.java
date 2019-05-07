package bishi2019.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/10.
 */
public class Huawei1 {
    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(" ");
        for(int i = 1; i < split.length; i++){
            String s = split[i];
            while (s.length() > 8){
                list.add(s.substring(0, 8));
                s = s.substring(8, s.length());
            }
            if (s.length() != 0){
                int m = s.length();
                for (int j = 0; j < 8 - m; j++ ){
                    s = s + "0";
                }
                list.add(s);
            }
        }
        Collections.sort(list);
        if(list.size() == 1)
            System.out.println(list.get(0));
        else{
            for (int k = 0; k < list.size() - 1; k ++){
                System.out.print(list.get(k) + " ");
            }
            System.out.println(list.get(list.size() - 1));
        }


    }
}
