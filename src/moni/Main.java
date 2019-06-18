package moni;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        double res = 0;
        int sum1 = 0;
        int sum2 = 0;
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 3; i++) {
                int m = sc.nextInt();
                if (hashMap.containsKey(m)) {
                    hashMap.put(m, hashMap.get(m) + 1);
                } else {
                    hashMap.put(m, 1);
                }
                if (j == 0)
                    sum1 += m;
                else
                    sum2 += m;
            }
        }
        int m1 = hashMap.containsKey(1)? hashMap.get(1): 0;
        int m13 = hashMap.containsKey(13)? hashMap.get(13): 0;
        int sum = sum1 - sum2;

        if (sum > 12) {
            res = 1;
        } else if(sum == 12){
            res = 1 - (4 - m1)/48.0 * (4 - m13)/47.0;
        }else if(sum <= -12){
            res = 0;
        }else{
            res = 1 - (4 - m1)/48.0 * (4 - m13)/47.0;
        }

        sc.close();
    }

}
