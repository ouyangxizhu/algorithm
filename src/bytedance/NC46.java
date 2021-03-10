package bytedance;

import java.util.ArrayList;
import java.util.Arrays;

public class NC46 {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        Arrays.sort(arr);
        int left = 0;
        int right = 0;
        int sum = arr[0];
        while (left <= right && right < arr.length) {
            if (sum == target) {
                result.add(generateList(arr, left, right));
                sum -= arr[left];
                if (left == right) {
                    left++;
                    right++;
                    if (left < arr.length) {
                        sum += arr[left];
                    }
                    while (left < arr.length && arr[left] == arr[left - 1]) {
                        left++;
                        right++;
                    }
                } else {
                    left++;
                }
            } else if (sum < target) {
                right++;
                if (right < arr.length) {
                    sum += arr[right];
                }
            } else {
                sum -= arr[left];
                left++;
            }
        }
        return result;
    }

    private ArrayList<Integer> generateList(int[] arr, int left, int right) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2};
        ArrayList<ArrayList<Integer>> arrayLists = new NC46().combinationSum2(nums, 2);
        System.out.println("fasf");
    }
}
