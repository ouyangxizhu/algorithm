package bishi2019.meituan;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/**
 * Created by ouyangxizhu on 2019/4/23.
 */
public class MeiTuan1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> treeMap1 = new TreeMap<>();
        TreeMap<Integer, Integer> treeMap2 = new TreeMap<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                int tmp = a[i][j];
                if(((i + j) & 1) == 1){
                    if (treeMap1.containsKey(tmp)){
                        treeMap1.put(tmp, treeMap1.get(tmp) + 1);
                    }else{
                        treeMap1.put(tmp, 1);
                    }
                }else{
                    if (treeMap2.containsKey(tmp)){
                        treeMap2.put(tmp, treeMap2.get(tmp) + 1);
                    }else{
                        treeMap2.put(tmp, 1);
                    }
                }
            }
        }

        int max1key1 = 0;
        int max1key2 = 0;
        int max2key1 = 0;
        int max2key2 = 0;
        int sum1 = 0;
        int sum2 = 0;
        int max1 = 0;
        int max11 = 0;
        int max2 = 0;
        int max22 = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap1.entrySet()){
            int maxtmp1 = entry.getValue();
            sum1 += maxtmp1;
            if (maxtmp1 > max1){
                
                max11 = max1;
                max1 = maxtmp1;
                max1key2 = max1key1;
                max1key1 = entry.getKey();
            }

        }
        for (Map.Entry<Integer, Integer> entry : treeMap2.entrySet()){
            int maxtmp2 = entry.getValue();
            sum2 += maxtmp2;
            if (maxtmp2 > max2){
                max22 = max2;
                max2 = maxtmp2;
                max2key2 = max2key1;
                max2key1 = entry.getKey();
            }

        }
        int res;
        if(max1key1 == max2key1){
            int res1 = Math.max(0, sum1 - max11);
            int res2 = Math.max(0, sum2 - max2);
            int res3 = Math.max(0, sum1 - max1);
            int res4 = Math.max(0, sum2 - max22);
            res = Math.min(res1 + res2, res3 + res4);
        }else{
            int res5 =Math.max(0,  sum1 - max1);
            int res6 = Math.max(0, sum2 - max2);
            res = res5 + res6;
        }

        System.out.println(res);
    }
}
