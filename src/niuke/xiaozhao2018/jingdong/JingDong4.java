package niuke.xiaozhao2018.jingdong;


import java.util.Scanner;

/**
 * 题目描述
 东东从京京那里了解到有一个无限长的数字序列: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, ...(数字k在该序列中正好出现k次)。东东想知道这个数字序列的第n项是多少,你能帮帮他么
 输入描述:
 输入包括一个整数n(1 ≤ n ≤ 10^18)
 输出描述:
 输出一个整数,即数字序列的第n项
 示例1
 输入

 复制
 169
 输出

 复制
 18
 * Created by ouyangxizhu on 2019/3/20.
 */
public class JingDong4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        //根据等差数列求值，有两个不等式，选那个可以确定轴的位置的
        //n(n- 1)/2 + 1 <= l <=n(n + 1)/2
        //右边的不等式可以确定中轴线在负半轴，只需要将n向上取整就行
        long ans = (long) Math.ceil((Math.sqrt(8 * l) - 1)/2);
        System.out.println(ans);
    }

   
}
