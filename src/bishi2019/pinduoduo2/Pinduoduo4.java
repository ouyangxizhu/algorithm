package bishi2019.pinduoduo2;


import java.util.*;

/**
 *
 * Created by ouyangxizhu on 2019/4/2.
 */
public class Pinduoduo4 {
    /**
     * 这个也可以
     * @param args
     */

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] sp1 = s1.split(" ");
        String[] sp2 = s2.split(" ");
        int[] a = new int[sp1.length];//长度
        int[] b = new int[sp2.length];//重量
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < sp1.length; i++) {
            a[i] = Integer.valueOf(sp1[i]);
        }
        for (int i = 0; i < sp2.length; i++) {
            b[i] = Integer.valueOf(sp2[i]);
            if(b[i] > treeMap.getOrDefault(a[i], 0)){
                treeMap.put(a[i], b[i]);
            }
        }
        List<Integer> list = new ArrayList<>(treeMap.keySet());
        int[] aa = new int[1];
        helper(list,treeMap, 0, aa, 0, 0);
        System.out.println(aa[0] + 1);

    }
    public static void helper(List<Integer> list, TreeMap<Integer, Integer> treeMap, int sum, int[] a,  int index, int length){
        if (index == list.size()) return;
        if(sum > 7 * treeMap.get(list.get(index))) return;
        if(a[0] < length) a[0] = length;
        for (int i = index; i < list.size(); i++) {
            helper(list,treeMap, sum + treeMap.get(list.get(i)), a, i + 1, length + 1);
        }
    }

}
