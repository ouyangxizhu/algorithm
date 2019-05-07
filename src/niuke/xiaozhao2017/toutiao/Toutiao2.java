package niuke.xiaozhao2017.toutiao;

import java.util.Scanner;

/**
 * 题目描述
给定整数m以及n各数字A1,A2,..An，将数列A中所有元素两两异或，共能得到n(n-1)/2个结果，请求出这些结果中大于m的有多少个。
输入描述:
第一行包含两个整数n,m. 

第二行给出n个整数A1，A2，...，An。

数据范围

对于30%的数据，1 <= n, m <= 1000

对于100%的数据，1 <= n, m, Ai <= 10^5
输出描述:
输出仅包括一行，即所求的答案
示例1
输入
复制
3 10  
6 5 10
输出
复制
2
 * @author changzhen.zhang
 *
 */
public class Toutiao2 {
	/**
	 * 

直接计算肯定是超时的，所以这问题不能使用暴力破解，
考虑到从高位到地位，依次进行位运算，如果两个数异或结果在某高位为1，而m的对应位为0，则肯定任何这两位异或结果为1的都会比m大。
由此，考虑使用字典树（TrieTree）从高位到第位建立字典，再使用每个元素依次去字典中查对应高位异或为1， 而m为0的数的个数，相加在除以2既是最终的结果；
直接贴出代码如下，非原创，欢迎讨论；
补充：queryTrieTree在搜索的过程中，是从高位往低位搜索，
那么，如果有一个数与字典中的数异或结果的第k位大于m的第k位，那么该数与对应分支中所有的数异或结果都会大于m，
 否则，就要搜索在第k位异或相等的情况下，更低位的异或结果。queryTrieTree中四个分支的作用分别如下：
 
1. aDigit=1， mDigit=1时，字典中第k位为0，异或结果为1，需要继续搜索更低位，第k位为1，异或结果为0，小于mDigit，不用理会；
2. aDigit=0， mDigit=1时，字典中第k位为1，异或结果为1，需要继续搜索更低位，第k位为0，异或结果为0，小于mDigit，不用理会；
3. aDigit=1， mDigit=0时，字典中第k位为0，异或结果为1，与对应分支所有数异或，结果都会大于m，第k位为1，异或结果为0，递归获得结果；
4. aDigit=0， mDigit=0时，字典中第k位为1，异或结果为1，与对应分支所有数异或，结果都会大于m，第k位为0，异或结果为0，递归获得结果；
	 * @param args
	 */
	private static class TrieTree{
		TrieTree [] next = new TrieTree[2];
		int count = 1;
	}
	
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    int[] array = new int[n];
	    for (int i = 0; i < n; i++) {
	      array[i] = sc.nextInt();
	    }
	    sc.close();
	    System.out.println(solve(array, m));
	  }

	private static long solve(int[] array, int m) {
		long result = 0;
		TrieTree trieTree = builTrieTree(array);
		for (int i = 0; i < array.length; i++) {
			result += queryTrieTree(trieTree, array[i], m, 31);
		}
		return result/2;
	}
	private static long queryTrieTree(TrieTree trieTree, int a, int m, int index) {
		if (trieTree == null) {
			return 0;
		}
		TrieTree current = trieTree;
		for (int i = index; i >= 0; i--) {
			int aDigit = (a >> i) & 1;
			int mDigit = (m >> i) & 1;
			if(aDigit == 1 && mDigit == 1) {
                if(current.next[0] == null)
                    return 0;
                current = current.next[0];
            } else if (aDigit == 0 && mDigit == 1) {
                if(current.next[1] == null)
                    return 0;
                current = current.next[1];
            } else if (aDigit == 1 && mDigit == 0) {
                long p = queryTrieTree(current.next[1], a, m, i - 1);
                long q = current.next[0] == null ? 0 : current.next[0].count;
                return p + q;
            } else if (aDigit == 0 && mDigit == 0) {
                long p = queryTrieTree(current.next[0], a, m, i - 1);
                long q = current.next[1] == null ? 0 : current.next[1].count;
                return p + q;
            }
			
		}
		return 0;
		
	}
	private static TrieTree builTrieTree(int [] a) {
		TrieTree trieTree = new TrieTree();
		for (int i = 0; i < a.length; i++) {
			TrieTree curr = trieTree;
			for (int j = 31; j >= 0; j--) {
				int digit = (a[i] >> j ) & 1;
				if (curr.next[digit] == null) {
					curr.next[digit] = new TrieTree();
				}else {
					curr.next[digit].count++;
				}
				curr = curr.next[digit];
			}
		}
		return trieTree;
	}
}
