package bishi2019.duxiaoman;

import sun.print.SunMinMaxPage;

import java.util.Scanner;
import java.util.Stack;

/**
 * 商品交易
 时间限制：C/C++语言 1000MS；其他语言 3000MS
 内存限制：C/C++语言 65536KB；其他语言 589824KB
 题目描述：
 珐达采下个月要去鸥洲各国考察一趟，采购流通神秘石并从中搞点油水。

 珐达采会按顺序依次经过序号分别为1, 2, 3, …, n的鸥洲国家，在第i个国家神秘石的流通价格为Ai鸥。因为行程紧张，在每个国家的停留时间有限，所以他只能花费Ai鸥买入一块神秘石，或者卖出一块手中的神秘石获得Ai鸥，或者什么都不做，而且因为神秘石的保存需要极其先进的高级材料容器，其材料稀有且制作困难，珐达采只有一份容器，故无论何时珐达采手里最多只能拥有一块神秘石。

 珐达采想知道最终能从中获利最大多少鸥。因为交易需要手续费，所以珐达采还想知道在获利最大收益的同时，最少需要交易多少次。因为珐达采是大财阀，所以你可以认为他一开始金钱无限。

 输入
 第一行一个数n。（1≤n≤100000）

 第二行n个数，第i个数表示Ai。（1≤Ai≤1e9）

 输出
 共一行，两个数，分别代表最大收益和对应的最少交易次数。


 样例输入
 5
 9 7 10 1 5
 样例输出
 7 4

 提示
 在#2买入，#3卖出，#4买入，#5卖出，-7+10-1+5=7
 规则
 请尽量在全场考试结束10分钟前调试程序，否则由于密集排队提交，可能查询不到编译结果
 点击“调试”亦可保存代码
 编程题可以使用本地编译器，此页面不记录跳出次数
 * Created by ouyangxizhu on 2019/4/19.
 */
public class Duxiaoman2 {
    public static void main(String args[]) {
        Stack<Integer> s = new Stack();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        int shou = 0;
        for (int i = 0; i < n; i++) {

            int tmp = arr[i];
            while(!s.isEmpty()){
                if (i + 1 < n ){
                    if (arr[i + 1] <= arr[i]){
                        while (!s.isEmpty()){
                            if (arr[i] > s.peek() + 2 && tmp > s.peek()){
                                tmp = s.pop();
                                break;
                            }else{
                                break;
                            }
                        }
                        break;


                    }else{
                        break;
                    }


                }else{
                    while (!s.isEmpty()){
                        if (arr[i] > s.peek() + 2 && tmp > s.peek()){
                            tmp = s.pop();
                            break;
                        }else{
                            break;
                        }
                    }
                    break;
                }
            }
            if (tmp == arr[i]){
                s.add(arr[i]);
            }else{
                sum += (arr[i] - tmp);
                shou += 2;
            }

        }
        System.out.println(sum);
        System.out.println(shou);
    }

}
