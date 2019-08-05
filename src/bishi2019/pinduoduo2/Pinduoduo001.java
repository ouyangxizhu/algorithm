package bishi2019.pinduoduo2;


import niuke.xiaozhao2017.souhu.Souhu1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 *可以先确定第一个
 * 再扫描确定第二个
 * 或者在首尾各加一个元素用来处理边界
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Pinduoduo001 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] sp1 = s1.split(" ");
        String[] sp2 = s2.split(" ");
        int[] a = new int[sp1.length];
        int[] b = new int[sp2.length];
        for (int i = 0; i < sp1.length; i++) {
            a[i] = Integer.valueOf(sp1[i]);
        }
        for (int i = 0; i < sp2.length; i++) {
            b[i] = Integer.valueOf(sp2[i]);
        }
        if (a.length <= 1){
            System.out.println("NO");
            return;
        }
        Arrays.sort(b);

        int index = a.length - 1;
        int pre = a.length - 1;

        for (int i = a.length - 2; i >= 0; i--) {
            if(a[i] >= a[pre]){
                index = i;
                break;
            }else{
                pre = i;
            }
        }
        int in = b.length;
        for (int i = b.length - 1; i >=0; i--) {
            if((index + 1 < a.length && index - 1 >= 0 && b[i] < a[index + 1] && b[i] > a[index - 1]) ){
                in = i;
                a[index] = b[in];
                break;
            }
            if (index +2 < a.length && b[i] < a[index + 2] && b[i] > a[index]){
                in = i;
                a[index + 1] = b[in];
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (in == b.length){
            System.out.println("NO");
            return;
        }else{
            for (int m : a){
                sb.append(m).append(" ");
            }
        }
        System.out.println(sb.toString().trim());

    }
}
