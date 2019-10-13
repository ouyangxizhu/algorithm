package leetcode.all;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_0763 {
    public List<Integer> partitionLabels(String str) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] last = new int[26];
        char[] chars = str.toCharArray();

        //记录每个字母最后出现的位置
        for (int i = 0; i < str.length(); i++) {
            last[chars[i] - 'a'] = i;
        }
        // preIndex表示上个区间的右端点
        // maxIndex表示当前遍历的字符最后出现位置的最大值
        int preIndex = -1, maxIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            int index = last[chars[i] - 'a'];
            // 更新区间的右端点, 向右延展
            maxIndex = Math.max(maxIndex, index);
            // 如果当前位置i等于当前所遍历的字符最后出现位置的最大值
            // 说明maxIndex即为区间的右端点
            if (i == maxIndex) {
                res.add(i - preIndex);
                preIndex = i;
            }
        }
        return res;

    }
}
