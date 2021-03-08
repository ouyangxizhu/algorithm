package bytedance;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class NC97 {
    /**
     * return topK string
     *
     * @param strings string字符串一维数组 strings
     * @param k       int整型 the k
     * @return string字符串二维数组
     */
    public String[][] topKstrings(String[] strings, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            Integer num = map.get(str);
            if (num == null) {
                map.put(str, 1);
            } else {
                map.put(str, num + 1);
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.getValue().compareTo(o2.getValue()) == 0 ? o1.getKey().compareTo(o2.getKey()) : o2.getValue() - o1.getValue());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            priorityQueue.add(entry);
        }
        String[][] result = new String[k][2];
        int index = 0;
        while (index < k && !priorityQueue.isEmpty()) {
            Map.Entry<String, Integer> entry = priorityQueue.poll();
            result[index][0] = entry.getKey();
            result[index++][1] = String.valueOf(entry.getValue());
        }
        return result;
    }

}
