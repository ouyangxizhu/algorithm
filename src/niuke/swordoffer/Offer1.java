package niuke.swordoffer;

/**
 * Created by ouyangxizhu on 2019/4/25.
 */
public class Offer1 {
    public static void main(String[] args){
        int[] a = {2,2,3,3,5,5,4,6};
        int[] b = new int[1];
        int[] c = new int[1];
        FindNumsAppearOnce(a, b, c);
    }
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int len = array.length;
        int index = 0;
        int sum = 0;
        for(int i = 0; i < len; i ++){
            sum ^= array[i];
        }
        for(index = 0; index < 32; index++){
            if((sum & (1 << index)) != 0)
                break;
        }
        for(int i = 0; i < len; i ++){
            if((array[i] & (1 << index)) != 0){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
