package niuke.xiaozhao2018.zhaoshangyinhang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述
在卡中心隐藏了很多美食，作为一名资深吃货，楼主告诉你需要去品尝n道美味才能达成“卡中心小小美食家”的成就。这些菜品被标号为 0 到 n-1 。正所谓美食家不是一口吃成个胖子的，每道美味的品尝顺序也是有讲究的，比如西餐的上菜顺序：头盘，汤，副菜，主菜，蔬菜类菜肴，甜品，咖啡或茶。有一些美味需要“前置菜肴”，比如如果你要吃菜品0，你需要先吃菜品1，我们用一个范式来表示这些规则：[0 1]。接下来给你菜品的总数量n和m个“前置菜肴”的范式，请编程输出你为了品尝完所有美味所安排的进餐顺序。可能会有多个正确的顺序，你只要输出一种就可以了。如果不可能品尝完所有美味，返回None。
输入描述:
输入的第一行为以空格分隔的两个正整数，第一个表示原始美味总数n，第二个表示前置菜肴范式总数m。
其后m行每行均为一个以空格分隔的范式说明，第一列为待吃菜肴的标号，第二列为前置菜肴的标号。
输出描述:
对每组测试数据，单独输出一行答案，菜肴标号之间用英文逗号分隔。
示例1
输入

复制
4 4
1 0
2 0
3 1
3 2
输出

复制
只需输出以下任一种结果即可
0,1,2,3
或
0,2,1,3

 * @author ouyangxizhu
 *
 */
public class ZhaoShangYinHang7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		if(n==0 || m==0 || k<=0 || k>n) {
            System.out.println(0);
            return;
       } 
		
	}	

}
