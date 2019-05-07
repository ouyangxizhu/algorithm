package bishi2019.duxiaoman;

import java.util.Scanner;

/**
 *
 * 题目描述：
 有一天，小A和小B玩了一个神奇的游戏，游戏开始时，桌面上有a0个不同盒子和b0个不同的物品，每个回合，两个人可以选择增加一个新的盒子或者一个新的物品(所有物品和盒子都不同)，记当前桌子上的盒子数量为a，物品数量为b，当把b个物品放入a个盒子的方案数不小于n时，游戏结束，此时最后一位操作者判负。

 给出a0，b0，n，如果小A先手，两个人都采用最优策略，谁能获胜，如果A获胜输出“A”，如果B获胜，输出“B”，如果是平局，输出“A&B”。

 输入
 输入第一行是一个数据组数T(T<=10)。

 接下来T行，每行描述一个测试数据，包含三个整数a0,b0,n(1<=a0<=10000,1<=b0<=30,2<=n<=10^9)。分别表示桌子上初始的盒子数，球数和n值。

 输出
 对于每个测试数据，输出一行，仅包含一个字符串，即“A”，“B”或“A&B”。


 样例输入
 3
 2 2 10
 3 1 4
 1 4 10
 样例输出
 B
 A
 A&B
 * Created by ouyangxizhu on 2019/4/19.
 */
public class Duxiaoman1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            if (a == 1){
                System.out.println("A&B");
                continue;
            }
            for (int j = 0; j < n; j++){
                if (po(a, b) >= n){
                    if ((j & 1) == 1){
                        System.out.println("B");
                        break;
                    }else{
                        System.out.println("A");
                        break;
                    }

                }else{
                    if (po(a + 1, b) <= n && po(a, b + 1) <= n){
                        b++;
                    }else{
                        a++;
                    }
                }

            }

        }
    }

    private static long po(int a, int b) {
        long sum = a;
        for (int i = 0; i < b; i ++){
            sum = sum * a;
        }
        return sum;
    }

}
