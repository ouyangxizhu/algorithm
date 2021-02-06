package bytedance;

import java.util.HashMap;

public class NC41 {
    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        if (arr == null) {
            return 0;
        }
        if (arr.length < 2) {
            return arr.length;
        }
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < arr.length; end++) {
            if (map.containsKey(arr[end])) {
                start = Math.max(start, map.get(arr[end]) + 1);
            }
            result = Math.max(result, end - start + 1);
            map.put(arr[end], end);

        }
        return result;
    }
}
