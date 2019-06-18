package high.mathmath;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最大数
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

示例 1:

输入: [10,2]
输出: 210
示例 2:

输入: [3,30,34,5,9]
输出: 9534330
说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * @author ouyangxizhu
 *
 */
public class First{
	public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                if((s1+s2).compareTo(s2+s1)>0){
                    return -1;
                }else if((s1+s2).compareTo(s2+s1)<0){
                    return 1;
                }else if((s1+s2).compareTo(s2+s1)==0){
                    return 0;
                }
                return 0;
            }
        });
        StringBuilder res = new StringBuilder();
        for(String i:strNums){
            res.append(i);
        }
        if(res.charAt(0)=='0'){
            return "0";
        }
        return res.toString();
    }


}
