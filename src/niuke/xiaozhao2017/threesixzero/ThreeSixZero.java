package niuke.xiaozhao2017.threesixzero;

import java.util.Scanner;

/**
 * 题目描述
小B乘火车和朋友们一起在N市到M市之间旅行。她在路途中时睡时醒。当她醒来观看窗外的风景时，注意到每个火车站都有一种特别颜色的旗帜，但是她看到的旗帜仅仅是经过的一小部分。小B在乘车过程中有两次清醒的时间，她到达旅程终点时处于睡梦中。出站时，她和朋友们谈论着一路的见闻，朋友们觉得很有意思，他们把N到和M之间经过车站的旗帜颜色依次列出来，然后告诉你小B记得的旗帜颜色序列，让你判断小B究竟是从N和M之间哪些方向才能看到所说颜色的旗帜，还是根本就不可能看到？颜色用字母代表，相同的字母代表相同的颜色，不同的字母则表示不同的颜色。
输入描述:
输入中有多组测试数据，每组测试数据包含三行，第一行为一个由小写拉丁字母构成的非空字符串，长度不超过10^5，表示N到M之间车站的颜色。火车从M向N运行时，经过的车站相同，只是方向相反。第二行为小B在第一次睡醒时看到的颜色序列，第三行为小B在第二次睡醒时看到的颜色序列。两个序列都是小写的拉丁字母构成的字符串，长度不超过100个字母。每个序列的颜色顺序排列按小B看到的时间顺序排列。
输出描述:
对每组测试数据，在单独的行中输出小B的旅行方向。
  
forward - 由N到M方向； 

backward -由M到N方向  

both - 两种方向都有可能；  

invalid - 不可能看到这样的颜色序列；
示例1
输入
复制
atob 
a 
b 
aaacaaa 
aca 
aa
输出
复制
forward 
both
 * @author changzhen.zhang
 *
 */
public class ThreeSixZero {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			String char1 = sc.nextLine();
			String char2 = sc.nextLine();
			boolean forward = false;
	        boolean backward = false;
			if (str.matches(".*" + char1 + ".*" + char2 + ".*")) {
				forward = true;
			}
			str = new StringBuilder(str).reverse().toString();
			if (str.matches(".*" + char1 + ".*" + char2 + ".*")) {
				backward = true;
			}
	
			if (forward && backward) {
                System.out.println("both");
            }
            if (forward && !backward) {
                System.out.println("forward");
            }
            if (!forward && backward) {
                System.out.println("backward");
            }
            if (!forward && !backward) {
                System.out.println("invalid");
            }
		}
	}

}
