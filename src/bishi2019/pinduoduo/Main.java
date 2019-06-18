package pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static <T> void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int s = 0;
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < a.length; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < b.length; i++){
        	b[i] = sc.nextInt();
        }
        
        Arrays.sort(a);
        Arrays.sort(b);
        int start = 0;
        int end = b.length - 1;
        int tmp = 0;
        while (start < end) {
        	tmp = b[start];
			b[start] = b[end];
			b[end] = tmp;
			start ++;
			end --;
		}
        
        for (int i = 0; i < b.length; i++) {
			s += a[i] * b[i];
		}
        System.out.println(s);
    }

}
