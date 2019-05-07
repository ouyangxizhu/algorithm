package bishi2019.pinduoduo1;


import java.math.BigInteger;
import java.util.*;

/**
 * 去除字符串中的相连的重复字符（去除之后相连的重复字符也可以继续删除）
 * 求删除次数
 *
 * fqweeqe
 1
 rgghhjjry
 4
 aaabbbcccaa
 4
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Pinduoduo1 {
    /**
     * 这个也可以
     * @param args
     */

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int sum = 0;

        while(true){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++){
                if(i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i) ){
                    i++;
                    sum++;
                }else{
                    sb.append(s.charAt(i));
                }
            }
            if(s.length() == sb.toString().length())
                break;
            s = sb.toString();
        }
        System.out.println(sum);


    }
    public static void fun(){

        Scanner scan=new Scanner(System.in);
        String str=scan.next();
        int s=0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++) {
            Character ch=str.charAt(i);
            if(!st.empty()&&st.peek().equals(ch)) {
                st.pop();
                s++;
            }else {
                st.add(ch);
            }
        }
        System.out.println(s);
    }
}
