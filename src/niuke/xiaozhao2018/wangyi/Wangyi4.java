package niuke.xiaozhao2018.wangyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目描述
小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
1、将a_i放入b序列的末尾
2、逆置b序列
小易需要你计算输出操作n次之后的b序列。
输入描述:
输入包括两行,第一行包括一个整数n(2 ≤ n ≤ 2*10^5),即序列的长度。
第二行包括n个整数a_i(1 ≤ a_i ≤ 10^9),即序列a中的每个整数,以空格分割。
输出描述:
在一行中输出操作n次之后的b序列,以空格分割,行末无空格。
示例1
输入

复制
4
1 2 3 4
输出

复制
4 2 1 3
 * @author ouyangxizhu
 *
 */
public class Wangyi4 {
	public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] array = new int [n];
        for(int i = 0;i < n;i++){
            array[i] = scanner.nextInt();
        }
        if(n == 1){
            System.out.println(array[0]);
        }
        if(n % 2 == 0){
            for(int i = n-1;i >= 0;i -= 2){
                System.out.print(array[i] + " ");
            }
            for(int i = 0;i < n - 2;i += 2){
                System.out.print(array[i] + " ");
                 
            }
            System.out.print(array[n-2]);
        }
        else { //n % 2 == 1
            for(int i = n-1;i >= 0;i -= 2){
                System.out.print(array[i] + " ");
            }
            for(int i = 1;i < n - 2;i += 2){
                System.out.print(array[i] + " ");
            }
            System.out.print(array[n-2]);
        }
    }
}
