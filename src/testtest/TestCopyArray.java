package testtest;

import java.util.Arrays;

/**
 * Created by ouyangxizhu on 2019/3/22.
 */
public class TestCopyArray {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,8,9,2,5,4,3,1};
        int[] arr = Arrays.copyOf(a, a.length);
        Arrays.sort(arr);
        for (int i = 0; i < a.length; i ++){
            System.out.print(a[i] + ",");
        }
        System.out.println();
        for (int i = 0; i < a.length; i ++){
            System.out.print(arr[i] + ",");
        }


    }
}
