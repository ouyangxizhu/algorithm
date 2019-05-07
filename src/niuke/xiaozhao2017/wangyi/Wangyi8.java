package niuke.xiaozhao2017.wangyi;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，其中有一些位置（不超过 10 个）看不清了，但是牛牛记得这个数列顺序对的数量是 k，顺序对是指满足 i < j 且 A[i] < A[j] 的对数，请帮助牛牛计算出，符合这个要求的合法排列的数目。
输入描述:
每个输入包含一个测试用例。每个测试用例的第一行包含两个整数 n 和 k（1 <= n <= 100, 0 <= k <= 1000000000），接下来的 1 行，包含 n 个数字表示排列 A，其中等于0的项表示看不清的位置（不超过 10 个）。
输出描述:
输出一行表示合法的排列数目。
示例1
输入
复制
5 5
4 0 0 2 0
输出
复制
2
 * @author changzhen.zhang
 *
 */
public class Wangyi8 {
	public static void main(String[] args) {
		int res = 0;
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		boolean[] flag = new boolean[n + 1];//标记哪些已经存在
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			if (a[i] != 0 ) {
				flag[a[i]] = true;
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();//统计不存在的数字
		for (int i = 1; i <= n; i++) {
			if (!flag[i]) {
				list.add(i);
			}
		}
		//perm用来存模糊数字的全排列
		ArrayList<ArrayList<Integer>> perm = new ArrayList<ArrayList<Integer>>();
		 //计算perm
        calperm(perm, list, 0);

    	//统计已有的排列的顺序对
        int cv = 0;
        for(int i=0;i<n;i++){
            if(a[i]!= 0){
                for(int j=i+1;j<n;j++){
                    if(a[j] != 0 && a[i] < a[j])
                        cv++;
                }
            }
        }
        

    	//计算每个模糊数字排列的顺序对，如果与k相等，则结果res加一
        for(ArrayList<Integer> tmp : perm){
            int val = cv;
            int[] tmpA = Arrays.copyOf(a, n);
            val += calvalue(tmp, tmpA);
            if(val == k)
                res++;
        }
         
        System.out.println(res);
	        
	}

	//计算排列的顺序对
    public static int calvalue(List<Integer> list, int[] A){
        int val = 0;
        int j = 0;
        for(int i=0;i<A.length;i++){
            if(A[i] == 0){
                A[i] = list.get(j++);
                for(int k = 0;k<i;k++){
                    if(A[k]!=0 && A[k]<A[i])
                        val++;
                }
                for(int k=i+1;k<A.length;k++){
                    if(A[k]!=0 && A[k]>A[i])
                        val++;
                }
            }
        }
        return val;
    }

	private static void calperm(ArrayList<ArrayList<Integer>> perm, ArrayList<Integer> list, int n) {
		if (n == list.size()) {
			perm.add(new ArrayList<>(list));
		}
		for (int i = n; i < list.size(); i++) {
			Collections.swap(list, i, n);
            calperm(perm, list, n+1);
            Collections.swap(list, i, n);
		}
	}
	
}
