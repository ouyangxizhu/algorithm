package bishi2019.pinduoduo3;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

public class Main5 {
	public static <T> void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(";");
        int num = Integer.valueOf(split[1]);

        ArrayList<Integer> danshu = new ArrayList<>();
        ArrayList<Integer> shuangshu = new ArrayList<>();

        String[] split1 = split[0].split(",");

        for (int i = 0; i < split1.length; i++) {
            int tmp = Integer.valueOf(split1[i]);
            if ((tmp & 1) == 1) {
                danshu.add(tmp);
            } else {
                shuangshu.add(tmp);
            }
        }
        Collections.sort(shuangshu);
        Collections.reverse(shuangshu);

        if (num <= shuangshu.size()) {
            for (int i = 0; i < num; i++) {
                if (i == num - 1) {
                    System.out.print(shuangshu.get(i));
                }else
                    System.out.print(shuangshu.get(i) + ",");
            }
        } else {
            for (int temp : shuangshu) {
                System.out.print(temp + ",");
            }
            Collections.sort(danshu);
            Collections.reverse(danshu);

            for (int i = 0; i < num - shuangshu.size(); i++) {
                if (i == num - shuangshu.size() - 1) {
                    System.out.print(danshu.get(i));
                }else
                    System.out.print(danshu.get(i) + ",");
            }
        }
        System.out.println();

    }

}
