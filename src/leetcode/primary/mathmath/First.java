package primary.mathmath;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SNIHostName;

/**
 * дһ����������� 1 �� n ���ֵ��ַ�����ʾ��

1. ��� n ��3�ı����������Fizz����

2. ��� n ��5�ı����������Buzz����

3.��� n ͬʱ��3��5�ı�������� ��FizzBuzz����

ʾ����

n = 15,

����:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
 * @author ouyangxizhu
 *
 */
public class First {
	public List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			list.add(isThirdOrFi(n));
		}
		return list;
	        
	}
	public static String isThirdOrFi(int n) {
		StringBuffer sb = new StringBuffer();
		if (n%3==0&&n%5==0) {
			sb.append("FizzBuzz");
		}else if (n%3==0) {
			sb.append("Fizz");
		}else if (n%5==0) {
			sb.append("Buzz");
		}else {
			sb.append(n+"");
			
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(new First().fizzBuzz(3));
	}

}