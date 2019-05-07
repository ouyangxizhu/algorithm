package niuke.xiaozhao2018.jingdong;


import java.util.Scanner;

/**
 * 题目描述
 给定一个字符串s, 请计算输出含有连续两个s作为子串的最短字符串。 注意两个s可能有重叠部分。例如,"ababa"含有两个"aba".
 输入描述:
 输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 50),s中每个字符都是小写字母.
 输出描述:
 输出一个字符串,即含有连续两个s作为子串的最短字符串。
 示例1
 输入
 abracadabra

 输出
 abracadabracadabra
 * Created by ouyangxizhu on 2019/3/20.
 */
public class JingDong1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int i;
        for (i = str.length() - 1; i > 0; i--){
            if (str.endsWith(str.substring(0, i))){
                break;
            }
        }
        System.out.println(str + str.substring(i));

    }
}
