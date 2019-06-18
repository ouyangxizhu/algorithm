package tencenttencent;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int [] a = {0,1,2,3};
		int[] copyOfRange = Arrays.copyOfRange(a, 0, 1);
		System.out.println(copyOfRange.length);
	}

}
