package qiuzhao2019.zhaohang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ZhaoHang1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int[] res = new int[s1.length()];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        int index = 0;
        while (s1.length() != 0) {
            int in = s1.indexOf('L');
            if (in >= 0) {
                index += + in;
                list.add(index);
            }
            index++;
            int n = s1.length();
            s1 = s1.substring(in + 1, n);
        }

        Arrays.fill(res, 1);
        int end = list.get(list.size() - 1);
        int preIndex = list.size() - 2;
        while (preIndex >= 0) {
            int pre = list.get(preIndex);
            if (end == pre + 1) {
                res[end - 1] += res[end];
                res[end] = 0;
                end = pre;
            } else {
                res[end - 1] = 0;
                res[end] --;
                for (int i = pre + 1; i <= end; i++) {
                    if (((end - i) & 1) == 1) {
                        res[end - 1]++;
                    } else {
                        res[end]++;
                    }
                    if (i < end - 1) {
                        res[i] = 0;
                    }
                }
                end = pre;
            }
            preIndex--;
        }
        for (int i = 0; i < res.length - 1; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println(res[res.length - 1]);
    }
}
