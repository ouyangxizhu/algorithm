package qiuzhao2019.zjitiaodong;

import java.util.*;

public class ZiJieTiaoDong4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] str = new String[n-1];
        for(int i=0;i<n-1;i++){
            str[i] = sc.nextLine();
        }
        if(n<=1){
            System.out.println(0+" "+0+" "+0);
        }
        else if(n==2){
            System.out.println(0+" "+1+""+0);
        } else{
            int[] len =new int[n];
            int len1=0;
            int len2=0;
            int len3=0;
            for(int i=0;i<n;i++){
                len[i]=n-1-i;
                if((i+1)%3==0){
                    len3 =len3+len[i]*(i+1);
                }else  if((i+1)%3==1){
                    len1=len1+len[i]*(i+1);

                }else {
                    len2=len2+len[i]*(i+1);
                }
            }
            System.out.println(len3+" "+len1+" "+len2);
        }
    }
}
