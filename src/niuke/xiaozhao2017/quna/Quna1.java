package niuke.xiaozhao2017.quna;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目描述
Please create a function to extract the filename extension from the given path,
return the extracted filename extension or null if none.
输入描述:
输入数据为一个文件路径
输出描述:
对于每个测试实例，要求输出对应的filename extension
示例1
输入
复制
Abc/file.txt
输出
复制
txt
 * @author changzhen.zhang
 *
 */
public class Quna1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		ArrayList<Character> arr = new ArrayList<Character>();
		int m = str.length() - 1;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == '.') {
				break;
			}
			arr.add(str.charAt(i));
			m = i;
		}
		if (m == 0) {
			System.out.println("null");
			return;
		}
		for (int j = arr.size() - 1; j >= 0; j--) {
			System.out.print(arr.get(j));
		}
	}
	

	/**
     *author: itmyhome
     */ 
    public static void main1(String[] args) { 
        Scanner cin =new Scanner(System.in);
        String fileName = cin.nextLine();
          
        if(!fileName.contains(".")){
             System.out.println("null");
        }else{
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1); 
            System.out.println(suffix);
        }
           
    } 

}
