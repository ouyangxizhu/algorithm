package primary.treetree;
/**
 * ����һ�����������ҳ��������ȡ�

�����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����

˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣

ʾ����
���������� [3,9,20,null,null,15,7]��

    3
   / \
  9  20
    /  \
   15   7
�������������� 3 ��
 * @author ouyangxizhu
 *���������������Ǿ���ڵ�·�����ĳһ��Ҷ�ڵ����ȡ� 
����������ȵ��ڶ������ĸ߶ȣ�Ҳ�͵��ڸ��ڵ�ĸ߶ȡ����ڵ�ĸ߶�Ϊ���������ĸ߶Ƚϴ���+1�� 
�ɴ�˼����õݹ���⣬��ʵҲ���Ǻ���������������㷨��
 */
public class First {
	public int maxDepth(TreeNode root) {
        if (root == null) {
			return 0; 
		}
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left>right)?left+1:right+1;
    }
}
