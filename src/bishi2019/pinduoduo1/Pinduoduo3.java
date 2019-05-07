package bishi2019.pinduoduo1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定n条线段和一个数字k，一个先如果同时属于至少k条线段，则判定这个点符合标准。
 * 现在要找出所有符合标准的点组成的最少的线段
 *
 * 输入
 * 第一行输入n和k， 1 <= k <=n <= 10000,
 * 之后n行每行2个数字left，right，分别代表这条线段的两个端点坐标
 * 1 <= left <=right<= 19999.
 * 每行的多个输入用空格分隔。
 *
 * 输出
 *第一行输出结果线段数x
 * 之后每行按照从左到右的顺序输出第x条线段的左右端点坐标
 * 坐标间用空格分隔。
 *
 * 输入

 3 2
 0 5
 -3 2
 3 8

 输出

 2
 0 2
 3 5

 注意和另一个测试用例的区别

 输入

 3 2
 0 5
 -3 3
 3 8

 输出

 1
 0 5
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Pinduoduo3 {
    /**
     *乘2 是为了分开结果中相邻的区间，
     * 比如测试样例中的0，2和3，5，如果不乘2两个区间就会并在一起变成0，5
     *
     *
     * 还有一个思路是不用点，用单位区间，比如用i表示单位区间i-1，i，
     * 测试样例中的0，5表示为1，5；-3，2表示为-2，2，然后在输出时将其转化回来。
     * @param args
     */
    public static void main(String args[]) {

        Scanner scan=new Scanner(System.in);
        int n,k;
        int []arr=new int[20000];
        n=scan.nextInt();
        k=scan.nextInt();
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) {
            int x=scan.nextInt();
            int y=scan.nextInt();
            x=x*2;
            y=y*2;
            for(int j=x;j<=y;j++)
                arr[j]+=1;
        }

        int t1=0,t2=0;
        ArrayList<Integer> arr1=new ArrayList<Integer>();
        ArrayList<Integer> arr2=new ArrayList<Integer>();
        for(int i=0;i<20000;i++)
        {
            if(arr[i]>=k) {
                //System.out.println(i);
                arr[i]=k;
                if(i==0||arr[i-1]!=k) {
                    t1=i;
                }
            }
            else if(i>0&&arr[i-1]==k) {
                t2=i-1;
                arr1.add(t1);
                arr2.add(t2);
            }
        }

        System.out.println(arr1.size());
        for(int i=0;i<arr1.size();i++) {
            System.out.println(arr1.get(i)/2+" "+arr2.get(i)/2);
        }

    }
}
