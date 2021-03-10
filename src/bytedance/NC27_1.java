package bytedance;

import java.util.ArrayList;
import java.util.LinkedList;

public class NC27_1 {
    /**
     * https://www.nowcoder.com/practice/c333d551eb6243e0b4d92e37a06fbfc9?tpId=117&tqId=37731&companyId=665&rp=1&ru=%2Fcompany%2Fhome%2Fcode%2F665&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
     * @param arr
     * @return
     */
    public ArrayList<ArrayList<Integer>> subsets1(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        for (int i = 0; i < Math.pow(2, arr.length); i++) {
            result.add(addNum(arr, i));
        }
        return result;
    }

    private ArrayList<Integer> addNum(int[] arr, int i) {
        ArrayList<Integer> result = new ArrayList<>();
        int index = 1;
        int num = 0;
        while (index <= i) {
            if ((index & i) == index) {
                result.add(arr[num]);
            }
            num++;
            index <<= 1;
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> subsets(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        LinkedList<Integer> list = new LinkedList<>();
        generateSubSets(arr, 0, list, result);
        return result;
    }

    private void generateSubSets(int[] arr, int start, LinkedList<Integer> list, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < arr.length; i++) {
            list.addLast(arr[i]);
            generateSubSets(arr, i + 1, list, result);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> subsets = new NC27_1().subsets(new int[]{1, 2, 3});
        System.out.println("fasdf");
    }
}
