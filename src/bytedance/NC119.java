package bytedance;

import util.IntListUtil;

import java.awt.image.SampleModel;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class NC119 {
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(k > input.length) return list;
        for(int i = 0; i < input.length; i++){
            q.add(input[i]);
        }

        for(int i = 0; i < k; i++){
            list.add(q.poll());
        }
        return list;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(null == input || input.length == 0 || k > input.length) return result;
        quick(input, 0, input.length - 1, k);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;
    }

    private void quick(int[] input, int left, int right, int k) {
        if (k <= 0 || right - left < 1 || right < 0 || left < 0 || left >= input.length - 1) {
            return;
        }
        int smallIndex = partition(input, left, right);
        if (smallIndex - left + 1 < k) {
            quick(input, left,smallIndex - 1, smallIndex - left);
            quick(input, smallIndex + 1,  right, k - (smallIndex - left + 1));
        } else {
            quick(input, left, smallIndex - 1, k);
        }
    }

    private int partition(int[] input, int left, int right) {
        if (left >= right) {
            return left;
        }
        int pivot = left + ((right - left)>>>1);
        swap(input, pivot, right);
        int result = left - 1;
        for (int i = left; i < right; i++) {
            if (input[i] < input[right]) {
                result++;
                swap(input, result, i);
            }
        }
        swap(input, ++result, right);
        return result;
    }

    public static void swap(int[] a, int left, int right) {
        if (left == right) {
            return;
        }
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }

    public static void main(String[] args) {
        int[] ints = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> result = new NC119().GetLeastNumbers_Solution(ints, 4);
        IntListUtil.printList(result);
    }
}
