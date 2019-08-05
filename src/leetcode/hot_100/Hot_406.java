package leetcode.hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Hot_406 {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0 || people[0].length == 0) return people;
        //按照身高降序 K升序排序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] a : people) {
            list.add(a[1], a);
        }
        return list.toArray(new int[list.size()][]);
    }
}
