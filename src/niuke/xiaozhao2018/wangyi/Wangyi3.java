package niuke.xiaozhao2018.wangyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目描述
如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。例如: "1","10101","0101010"都是交错01串。
小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。小易需要你帮帮忙求出最长的这样的子串的长度是多少。
输入描述:
输入包括字符串s,s的长度length(1 ≤ length ≤ 50),字符串中只包含'0'和'1'
输出描述:
输出一个整数,表示最长的满足要求的子串长度。
示例1
输入

复制
111101111
输出

复制
3
 * @author ouyangxizhu
 *
 */
public class Wangyi3 {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        System.out.println(str.length() == 1 ? 1 : maxLength(str));
    }
    public static int maxLength(String str){
        int start = 0;
        int end = 0;
        int max = 1;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) != str.charAt(i - 1)){
                end = i;
            }else{
                start = i;
            }
            max = Math.max (max, end - start + 1);
        }
        return max;
    }

}
