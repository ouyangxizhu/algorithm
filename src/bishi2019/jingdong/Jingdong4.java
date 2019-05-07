package bishi2019.jingdong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by ouyangxizhu on 2019/4/13.
 */
public class Jingdong4 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        HashMap<String, Integer> strMap = new HashMap<>();
        ArrayList<HashSet<String>> li = new ArrayList<>();

        HashSet<String> hashSet = new HashSet<>();
        int index = 0;
        while (hashSet.size() != n - 1) {
            String[] sp = sc.nextLine().split(" ");
            hashSet.add(sp[0]);
            hashSet.add(sp[1]);
            if ("1".equals(sp[1])){
                HashSet<String> hashSet1 = new HashSet<>();
                hashSet1.add(sp[0]);
                strMap.put(sp[0], index++);
                li.add(hashSet1);

            } else {
                Integer in = strMap.get(sp[1]);
                HashSet<String> hash = li.get(in);
                hash.add(sp[0]);
                strMap.put(sp[0], in);
            }


        }
        int max = 0;
        for (HashSet h : li){
            max = Math.max(max, h.size());
        }

        System.out.println(max);

    }

}
