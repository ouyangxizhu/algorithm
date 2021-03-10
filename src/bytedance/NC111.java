package bytedance;

import java.util.ArrayList;
import java.util.Collections;

public class NC111 {
    /**
     * 最大数
     *
     * @param nums int整型一维数组
     * @return string字符串
     */
    public String solve(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "0";
        }
        ArrayList<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        Collections.sort(list, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (list.get(0).compareTo("0") == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder(); //结果字符串
        for(int i = 0;i < list.size();i ++){//将排序好后的字符串一次相加就是最终的结果
            res.append(list.get(i));
        }
        return res.toString();
    }
}
