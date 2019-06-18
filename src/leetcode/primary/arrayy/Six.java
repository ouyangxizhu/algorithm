package primary.arrayy;
/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
 * @author ouyangxizhu
 *
 */
public class Six {
	 public int[] plusOne(int[] digits) {
		 int n = digits.length;
         for(int i = n-1; i >= 0; i --) {
             // 非9加1
             if(digits[i] < 9) {
                 // 如果是前一位需要进位的话那么前一位置为0,就在后一位(也就是此时的当前位+1)
                 digits[i]++;
                 // 直接把改变之后的数组返回(因为当前位不是9就不需要进位了,前面该进的位都已经进了所以直接把数组返回就行了)
                 return digits;
             }
             // 缝9进0
             digits[i] = 0;
         }
         // 全部为9,则需要数组扩充1位
         /**
          * 如果位数全部都是9的话,那么遍历原来=数组上的所有的数,都是让数组上的所有的数变成0
          * 也就是说明上面的if代码里面的内柔都是没有走的,就需要进行数组扩容
          */
         int[] result = new int[n+1];
         result[0] = 1;
         return result;

	        
	 }
	 public static void main(String[] args) {
		 int [] arr = {9};
		 int [] ans=new Six().plusOne(arr);
		 for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		 
	}
}
