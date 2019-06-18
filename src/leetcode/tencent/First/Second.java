package tencenttencent;

import java.util.Scanner;

public class Second {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();//q个问题
        int[] arr = new int[2*q];
        for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
        for (int i = 0; i < arr.length; i++) {
			if ((i & 1) == 1) {
				System.out.println(betweenLength(arr[i - 1], arr[i], arr));
			}
		}
    }

	public static int betweenLength(int i, int j, int[] arr) {
		if ((i & 1) == 0) {
			if ((j & 1) == 0) {
				return (j - (j - i)/2);
			}else {
				return - (j - i + 1)/2;
			}
			
 		}else {
 			if ((j & 1) == 1) {
				return (- j + (j - i)/2);
			}else {
				return (j - i + 1)/2;
			}
	
 		}
	}

}
