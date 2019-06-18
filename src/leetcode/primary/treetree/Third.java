package primary.treetree;
/**
 * ����һ����������������Ƿ��Ǿ���ԳƵġ�

���磬������ [1,2,2,3,4,4,3] �ǶԳƵġ�

    1
   / \
  2   2
 / \ / \
3  4 4  3
����������� [1,2,2,null,3,null,3] ���Ǿ���ԳƵ�:

    1
   / \
  2   2
   \   \
   3    3
˵��:

�����������õݹ�͵������ַ������������⣬��ܼӷ֡�
 * @author ouyangxizhu
 *
 */
public class Third {
	public boolean isSymmetric(TreeNode root) {
        return isSymmetrical(root,root);
    }
	boolean isSymmetrical(TreeNode r1,TreeNode r2) {
        if (r1 == null&&r2 == null)
           return true;
        if (r1 == null||r2 == null)
           return false;
        return r1.val==r2.val&&isSymmetrical(r1.left,r2.right)&&isSymmetrical(r1.right,r2.left);
    }

}
