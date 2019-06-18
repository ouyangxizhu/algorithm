package primary.mathmath;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SNIHostName;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示。

1. 如果 n 是3的倍数，输出“Fizz”；

2. 如果 n 是5的倍数，输出“Buzz”；

3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。

示例：

n = 15,

返回:
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