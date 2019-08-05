package bishi2019.bytebalance;

import java.util.Scanner;

public class ByteBlance1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        while(t-- > 0){
            String s = sc.nextLine();
            String[] sp = s.split("-");
            int year = Integer.valueOf(sp[0]);
            int month = Integer.valueOf(sp[1]);
            int day = Integer.valueOf(sp[2]);
            if (month == 2 && day == 29){
                System.out.println(-1);
                continue;
            }
            else{
                int res = 0;
                if(month >= 3){
                    for (int i = year + 1; i <= year + 18; i++) {
                        if((i%4 == 0 && i%100!= 0)|| i%400 == 0){
                            res += 366;
                        }else{
                            res+= 365;
                        }
                    }
                }
                else if(month <= 2){
                    for (int i = year; i < year + 17; i++) {
                        if((i%4 == 0 && i%100!= 0)|| i%400 == 0){
                            res += 366;
                        }else{
                            res+= 365;
                        }
                    }
                }
                System.out.println(res);

            }
        }


    }
}
