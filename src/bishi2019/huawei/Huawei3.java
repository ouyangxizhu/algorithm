package bishi2019.huawei;

import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/10.
 */
public class Huawei3 {
    static int sum = 0;
    static int num = 10 * 10* 10* 10* 10* 10* 10* 10* 10;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] a = new int[n][m];
        for (int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                a[i][j] = sc.nextInt();
            }
        }
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        count(a, n, m, x1, y1, x2, y2);
        System.out.println(sum);
    }

    private static void count(int[][] a, int n, int m, int x1, int y1, int x2, int y2) {

        if (x1 == x2 && y1 == y2){
            sum++;
            sum = sum%num;
            return;
        }
        if(a[x1][y1] >= a[x2][y2])
            return;
        if(x1 + 1 < n && a[x1 + 1][y1] > a[x1][y1]){

            count(a, n, m, x1 + 1, y1, x2, y2);
        }
        if(x1 - 1 >= 0 && a[x1 - 1][y1] > a[x1][y1]){

            count(a, n, m, x1 - 1, y1, x2, y2);
        }
        if(y1 + 1 < m && a[x1][y1 + 1] > a[x1][y1]){

            count(a, n, m, x1, y1 + 1, x2, y2);
        }
        if(y1 - 1 >= 0 && a[x1][y1 - 1] > a[x1][y1]){
            count(a, n, m, x1, y1 - 1, x2, y2);
        }
    }
}
