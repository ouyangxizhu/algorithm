package bishi2019.pinduoduo;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Pinduoduo {
    static StringBuilder sb = new StringBuilder();
    static List<String> lista = new ArrayList<String>();
    static List<String> listb = new ArrayList<String>();
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++){
            arr[i] = sc.nextInt();

        }
        int[] mma = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < 10; i++){
            if (mma[i] != 0){
                sb.append(i);
                mma[i] --;
            }

        }
        int m = sc.nextInt();
        int n = sc.nextInt();
        int a = m > n ? n :m;
        int b = m > n ? m :n;
        String stra = sb.substring(0, a);
        String strb = sb.substring(a, a + b);
        long lona = Long.valueOf(stra);
        long lonb = Long.valueOf(strb);
        isMin("", a, arr);
        BigInteger res = BigInteger.valueOf(lona).multiply(BigInteger.valueOf(lonb));
        for (int i = 0; i< lista.size(); i++){
            BigInteger mm =  BigInteger.valueOf(Long.valueOf(lista.get(i))).multiply(BigInteger.valueOf(Long.valueOf(listb.get(i))));
            int com = mm.compareTo(res);
            if (com < 0){
                res = mm;
            }
        }
        System.out.println(res);

    }

    private static void isMin(String str, int lena, int[] arr) {
        if (lena < 0) return;
        int[] ar = Arrays.copyOf(arr, arr.length);

        if (lena == 0){
            lista.add(str);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++){
                if (ar[i] != 0)
                    sb.append(ar[i]);
            }
            return;
        }else {
            for (int i = 0; i < 10; i++){
                if (ar[i] != 0){
                    ar[i]--;
                    isMin(str + ar[i], lena - 1, Arrays.copyOf(ar, ar.length));
                    ar[i]++;
                    isMin(str, lena, Arrays.copyOf(ar, ar.length));
                }
            }
        }

    }
}
