package leetcode.hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hot_39 {
    List<List<Integer>> res = new ArrayList<>();
    //Java递归回溯，这里把集合中的数字作升序排列排除重复情况
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int sum = 0;
        addElement(candidates, new ArrayList<>(), sum, target, candidates.length - 1);
        return res;

    }
    private void addElement(int[] cand, List<Integer> list, int sum, int target,int index){
        if(sum > target)
            return;
        if(sum == target){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = index; i >= 0; i--){
            list.add(cand[i]);
            addElement(cand, list, sum + cand[i], target, i);
            list.remove(list.size() - 1);
        }

    }
}
