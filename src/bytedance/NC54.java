package bytedance;

import java.util.ArrayList;
import java.util.Arrays;

public class NC54 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (num == null || num.length < 3) {
            return result;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (num[i] > 0) {
                break;
            }
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (0 == sum) {
                    ArrayList<Integer> arr = new ArrayList<>(3);
                    arr.add(num[i]);
                    arr.add(num[left]);
                    arr.add(num[right]);
                    result.add(arr);
                    while (left < right && num[left] == num[left + 1]) {
                        left++;
                    }
                    while (left < right && num[right] == num[right - 1]) {
                        right--;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
