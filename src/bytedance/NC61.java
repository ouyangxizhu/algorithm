package bytedance;

import jdk.nashorn.internal.ir.IfNode;
import util.IntArrUtil;

import java.util.Arrays;
import java.util.HashMap;

public class NC61 {
    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }

    public int[] twoSum1(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer value = map.get(target - numbers[i]);
            if (null != value) {
                return new int[]{value + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return null;
    }
}
