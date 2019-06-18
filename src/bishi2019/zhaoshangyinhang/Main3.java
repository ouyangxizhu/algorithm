package zhaoshangyinhang;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Stack<BigInteger> stack = new Stack<BigInteger>();
		if (arr[0] < 0) {
			flag = false;
		}
		stack.add(BigInteger.valueOf(arr[0]));
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < 0) {
				if (!flag) {
					stack.add(stack.pop().add(BigInteger.valueOf(arr[i])));
				}else {
					stack.add(stack.pop().add(BigInteger.valueOf(-arr[i])));
				}
			}else {
				if (flag) {
					stack.add(stack.pop().add(BigInteger.valueOf(arr[i])));
				}else {
					stack.add(stack.pop().negate().add(BigInteger.valueOf(arr[i])));
				}
			}
			if (stack.peek().compareTo(BigInteger.valueOf(0)) == 1) {
				flag = true;
			}else {
				flag = false;
			}
		}
		
		long sum = 0;
		if (arr[0] >= 0) {
			sum = -arr[0];
			for (int i = 1; i < arr.length; i++) {
				sum += arr[i];
			}
			System.out.println(sum);
			return;
		}
		if (arr[n - 1] <= 0) {
			sum = arr[n - 1];
			for (int i = 0; i < arr.length - 1; i++) {
				sum -= arr[i];
			}
			System.out.println(sum);
			return;
		}
		System.out.println(stack.peek().abs());
		
		
	}

}
