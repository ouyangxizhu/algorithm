package bishi2019.wangyi;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Wangyi1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> list = new ArrayList<>();
        int i = 0,j = 0;
        for(; i < str.length(); i++){
            char ch = str.charAt(i);
            boolean flag = (ch <= 'Z' && ch >= 'A') || (ch <= 'z' && ch >= 'a') || (ch <= '9' && ch >= '0');
            if (!flag){
                list.add(str.substring(j, i));
                list.add(str.charAt(i) + "");
                if (i + 1 <= str.length()){
                    j = i + 1;
                }
            }

        }

       for (int k = list.size() - 1; k >= 0; k--){
           System.out.print(list.get(k));

       }

    }
}
