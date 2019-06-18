package moni;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
        	a[i] = sc.nextInt();
		}
        for (int i = 0; i < n; i++) {
        	b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int indexa = n - 1;
        int indexb = n - 1;
        int counta = 0;
        int countb = 0;
        for (int i = 2 * n -1; i >= 0; i--) {
			if ((i & 1) == 1) {
				if (indexa >= 0 && indexb >= 0) {
					
					if (a[indexa] > b[indexb]) {
						counta += a[indexa];
						indexa --;
					}else {
						indexb --;
					}
				}else if (indexa >= 0) {
					
					counta += a[indexa];
					indexa --;
						
				}else {
						indexb --;
				}
			}else {
				if (indexa >= 0 && indexb >= 0) {
					
					if (a[indexa] > b[indexb]) {
						indexa --;
					}else {
						countb += b[indexb];
						indexb --;
					}
				}else if (indexa >= 0) {
					
					indexa --;
						
				}else {
					countb += b[indexb];
					indexb --;
				}
			}
		}
   
        sc.close();
        System.out.println(counta - countb);
    }

}
