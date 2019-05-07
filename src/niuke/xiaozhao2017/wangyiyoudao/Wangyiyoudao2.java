package niuke.xiaozhao2017.wangyiyoudao;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 小明同学把1到n这n个数字按照一定的顺序放入了一个队列Q中。现在他对队列Q执行了如下程序：
 *
while(!Q.empty())              //队列不空，执行循环

{

    int x=Q.front();            //取出当前队头的值x

    Q.pop();                 //弹出当前队头

    Q.push(x);               //把x放入队尾

    x = Q.front();              //取出这时候队头的值

    printf("%d\n",x);          //输出x

    Q.pop();                 //弹出这时候的队头

}

做取出队头的值操作的时候，并不弹出当前队头。
小明同学发现，这段程序恰好按顺序输出了1,2,3,...,n。现在小明想让你构造出原始的队列，你能做到吗？[注：原题样例第三行5有错，应该为3，以下已修正] 
输入描述:
第一行一个整数T（T ≤ 100）表示数据组数，每组数据输入一个数n（1 ≤ n ≤ 100000），输入的所有n之和不超过200000。


输出描述:
对于每组数据，输出一行，表示原始的队列。数字之间用一个空格隔开，不要在行末输出多余的空格.
示例1
输入
4
1
2
3
10
输出
1
2 1
2 1 3
8 1 6 2 10 3 7 4 9 5
 * @author changzhen.zhang
 *
 */
public class Wangyiyoudao2 {
	/**
	 * 
每次读取一个数之后，算出他经过k次洗牌后的位置，只用一个长度为2n数组用来输出
根据当前数的位置，可以算出经过一次洗牌后的位置
如果当前数小于等于n（即在左手），则他下次出现的位置是 2*当前位置-1
如果当前位置大于n（即在右手）,则他下次出现的位置是 2*（当前位置 - n）
个人建议在线面试题的时候如果5分钟内没想到好方法建议就使用暴力方法，
毕竟测试用例不通过什么都没用
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		LinkedList<Integer> res;
		while (t-- > 0) {
			int n = sc.nextInt();
			res = func(n);
			for (int i = 0; i < n - 1; i++) {
				System.out.print(res.removeFirst() + " ");
			}
			System.out.println(res.removeFirst());
		}
	}

	private static LinkedList<Integer> func(int n) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		for (int i = n; i >= 1; i--) {
			linkedList.addFirst(i);
			linkedList.addFirst(linkedList.removeLast());
		}
		return linkedList;
	}

}
