package niuke.xiaozhao2017.wangyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 题目描述
牛牛和 15 个朋友来玩打土豪分田地的游戏，牛牛决定让你来分田地，地主的田地可以看成是一个矩形，每个位置有一个价值。分割田地的方法是横竖各切三刀，分成 16 份，作为领导干部，牛牛总是会选择其中总价值最小的一份田地， 作为牛牛最好的朋友，你希望牛牛取得的田地的价值和尽可能大，你知道这个值最大可以是多少吗？
输入描述:
每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 75），表示田地的大小，接下来的 n 行，每行包含 m 个 0-9 之间的数字，表示每块位置的价值。
输出描述:
输出一行表示牛牛所能取得的最大的价值。
示例1
输入
复制
4 4
3332
3233
3332
2323
输出
复制
2
 * @author changzhen.zhang
 *
 */
public class Wangyi4 {
	
	/**
    *本题的暴力方法是一刀一个循环，这样总共六个循环，然后遍历，获取每个块的价值，这样就变成O(n^8);
    *所以要优化，第一个优化的位置是如何避免每次遍历获取方块的价值，可以通过一个二维数组sum简化。
    *sum[i][j]表示土地（0，0）到（i,j）所有小方块的价值的和。利用几何知识，
    *我们知道（startX,startY）到（stopX, stopY）区间的价值为 sum[stopX][stopY] - sum[stopX][startY] - sum[startX][stopY] + sum[startX][startY]
    *这样处理后，获取矩形中价值的速度优化为O(1);
    *第二个优化就是横切。我们的目的是使得16块中价值最小的模块价值尽可能大，如果横切使用三个循环，就没有考虑到价值从小到大的序列。
    *我们从价值小到大去切（当前的价值为curValue），如果这样每切一刀，四个方块，都能满足价值大于curValue,那么这一刀就有效，然后去找下一到，如果到最后，超过了四刀，
    *则，这是一次有效的切割。但是这不一定是最小的，我们要找到，第一个不成立的，它的前面哪一个就是成立的最大的最小值。此时的复杂度为O(n^5);
    *但是我要要注意到价值从和最小到最大，一一遍历是很慢的，所以我们要使用二分去优化，把遍历价值这个复杂度降为O(logN),
    *最终我们获得了O(N^4logN)的方法。
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrInput = br.readLine().trim().split(" ");
        int n = Integer.parseInt(arrInput[0]);
        int m = Integer.parseInt(arrInput[1]);
        if (n<4 || m <4) {//要满足可以横竖各切三刀
            throw new IllegalStateException();
        }
        int[][] sum = new int[n+1][m+1];
        int start = Integer.MAX_VALUE;//记录最小值
        for (int i=1; i<=n; i++) {//输入数据，sum是左上角（0，0）到右下角（i，j）表示的矩阵的所有元素之和。这也是动态规划的关键，如果不这样存数据，那么求每个矩阵的值就要遍历，耗费很多时间
            char[] arrChar = br.readLine().trim().toCharArray();
            for (int j=1; j<=m; j++) {
                int valueInput = arrChar[j-1] - '0';
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + valueInput;
                if (valueInput < start) {
                    start = valueInput;
                }
            }
        }
        int stop = sum[n][m];
        int maxMin = start;
        while (start <= stop) {
            int middle = (start + stop) / 2;
            if (Wangyi4.isValid(middle, sum)) {
                maxMin = middle;
                start = middle + 1;
            } else {
                stop = middle -1;
            }
        }
        System.out.println(maxMin);
    }
    public static boolean isValid(int judgeValue, int[][] sum) {
        int maxRow = sum.length - 1;
        int maxCol = sum[0].length - 1;
        for (int i=1; i<=maxCol-3; i++) {//竖切第一刀
            for(int j=i+1; j<=maxCol-2; j++) {//竖切第二刀
                for (int k=j+1; k<=maxCol-1; k++) {//竖切第三刀
                    int cnt = 0;//记录横切的第几刀
                    int lastRow = 0;//记录横切的上一刀的位置
                    for (int row=1; row<=maxRow; row++) {//横切
                        int s1 = Wangyi4.SumOfSubMatrix(lastRow, 0, row, i, sum);
                        int s2 = Wangyi4.SumOfSubMatrix(lastRow, i, row, j, sum);
                        int s3 = Wangyi4.SumOfSubMatrix(lastRow, j, row, k, sum);
                        int s4 = Wangyi4.SumOfSubMatrix(lastRow, k, row, maxCol, sum);
                        if (s1>=judgeValue && s2>=judgeValue && s3>=judgeValue && s4>=judgeValue) {//满足条件就记录这一刀为有效
                            cnt++;
                            lastRow = row;
                        }
                    }
                    if (cnt>=4) {//大于四刀，说明这样切是可以的
                        return true;
                    }
                }
            }
        }
        return false;
    }
    /**
    *求子矩阵的元素和
    *包含右下角，不包含左上角
    */
    public static int SumOfSubMatrix(int startX, int startY, int stopX, int stopY, int[][] sum) {
        int sumVal = sum[stopX][stopY] - sum[stopX][startY] - sum[startX][stopY] + sum[startX][startY];
        return sumVal;
    }
}
