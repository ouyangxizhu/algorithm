package niuke.chengxuyuandaimamianshi;

import java.util.Scanner;

public class Zuo_001 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        int K = s.nextInt();

        int[][] array = new int[N][M];
        for (int i = 0;i < N;i++) {
            for (int j = 0;j < M;j++) {
                array[i][j] = s.nextInt();
            }
        }
        int row = 0,col = M - 1;
        while (row < N && col >= 0) {
            if (K == array[row][col]) {
                System.out.println("Yes");
                return;
            }
            if (K > array[row][col]) {
                row++;
            }else
                col--;
        }
        System.out.println("No");

    }
}
