package bishi2019.xiecheng;



import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Xiecheng2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String sub = str.substring(1, str.length() - 1);
        String[] split = sub.split(",");
        String s = sc.nextLine();
        int n = Integer.valueOf(s);
        for (int i = 0; i < split.length/n; i++){
            swap(split, n, i);
            
        }
        System.out.print("[");
        for (int i = 0; i < split.length;i++){
            System.out.print(split[i]);
            if (i != split.length - 1){

                System.out.print(",");
            }
        }
        System.out.println("]");

    }

    private static void swap(String[] split, int n, int i) {
        int start = n * i;
        int end = n * (i + 1) - 1;
        while (start < end){
            String tmp = split[start];
            split[start] = split[end];
            split[end] = tmp;
            start ++;
            end --;
        }

    }
}
