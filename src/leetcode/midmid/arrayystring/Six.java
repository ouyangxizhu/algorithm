package midmid.arrayystring;
/**
 * ��������Ԫ������
����һ��δ��������飬�ж�����������Ƿ���ڳ���Ϊ 3 �ĵ��������С�

��ѧ���ʽ����:

������������� i, j, k,  ������ 0 �� i < j < k �� n-1��
ʹ�� arr[i] < arr[j] < arr[k] ������ true ; ���򷵻� false ��
˵��: Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(n)���ռ临�Ӷ�Ϊ O(1) ��

ʾ�� 1:

����: [1,2,3,4,5]
���: true
ʾ�� 2:

����: [5,4,3,2,1]
���: false
 * @author ouyangxizhu
 *
 */
public class Six {
	/**
	 * ˼·�е����ƶ�̬�滮��˼�룬ά��һ����Ԫ��(first,second)����¼��i��Ԫ��֮ǰ�ġ���С��������Ԫ�����У��Ժ���Ԫ�ص�Ҫ�������[5,6,2,3,4]�����[5,6]Ϊ[2,3]��ʱֻҪ�����������3�Ϳ��ԣ�

��nums[i]С��firstʱ������first��ֵ
��nums[i]>first��nums[i]
--------------------- 
���ߣ�whd_Alive 
��Դ��CSDN 
ԭ�ģ�https://blog.csdn.net/whdAlive/article/details/80404875 
��Ȩ����������Ϊ����ԭ�����£�ת���븽�ϲ������ӣ�
	 * @param nums
	 * @return
	 */
	public boolean increasingTriplet(int[] nums) {
		int first = Integer.MAX_VALUE,second = Integer.MAX_VALUE;
        if(nums.length<3){
            return false;
        }
        for(int num:nums){
            if(first>num){
                first = num;
            }else if(first<num && num<second){
                second = num;
            }else if(num>second){
                return true;
            }
        }
        return false;

    }

}
