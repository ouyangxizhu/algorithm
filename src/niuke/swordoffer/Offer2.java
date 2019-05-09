package niuke.swordoffer;

/**
 * Created by ouyangxizhu on 2019/5/8.
 */
public class Offer2 {
    public int movingCount(int threshold, int rows, int cols){
        int[][] flag = new int[rows][cols];
        return helper(0, 0, rows, cols, flag, threshold);
    }
    public static int helper(int i, int j, int rows, int cols, int[][] flag, int threshold){
        if(i < 0 || i >= rows || j < 0 || j >= cols || num(i) + num(j) > threshold || flag[i][j] == 1)
            return 0;
        flag[i][j] = 1;
        return helper(i - 1, j, rows, cols, flag, threshold)
                + helper(i + 1, j, rows, cols, flag, threshold)
                + helper(i, j - 1, rows, cols, flag, threshold)
                + helper(i, j + 1, rows, cols, flag, threshold)
                + 1;
    }
    public static int num(int i){
        int sum = 0;
        while(i != 0){
            sum += (i % 10);
            i /=  10;
        }
        return sum;
    }
}
