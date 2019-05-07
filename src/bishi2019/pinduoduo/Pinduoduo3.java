package bishi2019.pinduoduo;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Pinduoduo3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String strm = sc.nextLine();
        int d = Integer.valueOf(strm);
        String substring = str.substring(1, str.length() - 1);
        String[] split = substring.split(", ");
        int[] a = new int[split.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.valueOf(split[i]);
        }
        int sum = 0;
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1;i++){
            for (int j = i + 1; j < a.length; j++){
                if (a[j] - a[i] <= d){
                    sum ++;
                }else {
                    break;
                }
            }
        }
        int len = a.length;
        int res = len * (len - 1)/ 2;
        double mm = Double.valueOf(sum);
        System.out.println(String.format("%.6f", mm/res));
        
    }
}
