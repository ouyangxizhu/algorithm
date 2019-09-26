package qiuzhao2019.b;

import java.util.ArrayList;
import java.util.Scanner;

public class BiliBIli3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split("  ");
        String pairDe = split[0];
        String de = split[1];
        String string = split[2];

        ArrayList<String> list = new ArrayList<>();
        String[] split1 = string.split(pairDe);
        for (String str : split1) {
            if (str.contains(de) && str.indexOf(de) != 0 && str.indexOf(de) != str.length() - 1 && str.indexOf(de) == str.lastIndexOf(de)) {
                list.add(str);
            }
        }
        System.out.println(list.size());
        for (String str : list) {
            String[] split2 = str.split(de);
            System.out.println(split2[0] + " " + split2[1]);
        }

    }

}
