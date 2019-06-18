package primary.treetree;

import static org.hamcrest.CoreMatchers.nullValue;

/**
 * ��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ�������������

�����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1��

ʾ��:

������������: [-10,-3,0,5,9],

һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������

      0
     / \
   -3   9
   /   /
 -10  5
 * @author ouyangxizhu
 *˼·:���ö��ַ�������ƽ��������������պ�Ϊ�����м�Ľڵ㣬���ڵ���������ĸ���������߲��ֵ��м�ڵ㣬
 *���ڵ���������������ұ߲��ֵ��м�ڵ㣻����ִ�н����ʾ�����������ͬ��������ƽ���������
 */
public class Five {
	public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);
        
    }
    public TreeNode sortedArrayToBST(int [] nums,int left,int right){
        if (left<=right) {
        	int mid = (left+right)/2;
			TreeNode root = new TreeNode(nums[mid]);
			root.left = sortedArrayToBST(nums,left,mid-1);
			root.right = sortedArrayToBST(nums,mid+1,right);
			return root;
		}else {
			return null;
		}
    }
}
