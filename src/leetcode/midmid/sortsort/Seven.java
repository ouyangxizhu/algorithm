package midmid.sortsort;
/**
 * ������ת��������
���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��

( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )��

����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1 ��

����Լ��������в������ظ���Ԫ�ء�

����㷨ʱ�临�Ӷȱ����� O(log n) ����

ʾ�� 1:

����: nums = [4,5,6,7,0,1,2], target = 0
���: 4
ʾ�� 2:

����: nums = [4,5,6,7,0,1,2], target = 3
���: -1
 * @author ouyangxizhu
 *
 */
public class Seven {
	 public int search(int[] nums, int target) {
		//ʵ���Ͼ��������������У������Ƕ��ַ�
         //ֻ����ֻ�ڵ��������ж���
         if(nums.length==0){
             return -1;
         }
         int st = 0,end = nums.length-1;
         while(st <= end){
             int mid = st+(end-st)/2;
             if(nums[mid]==target){
                 return mid;
             }
             if(nums[mid]>=nums[st]){
                 if(nums[st]<=target&&target<nums[mid]){
                     end = mid-1;
                 }else{
                     st = mid+1;
                 }
             }else{
                 if(nums[mid]<target&&target<=nums[end]){
                     st = mid+1;
                 }else{

                     end = mid-1;
                 }
             }
         }
         return -1;

	        
	 }

}
