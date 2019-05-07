package niuke.xiaozhao2018.aiqiyi;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *题目描述
 牛牛和羊羊都很喜欢青草。今天他们决定玩青草游戏。
 最初有一个装有n份青草的箱子,牛牛和羊羊依次进行,牛牛先开始。
 在每个回合中,每个玩家必须吃一些箱子中的青草,所吃的青草份数必须是4的x次幂,比如1,4,16,64等等。
 不能在箱子中吃到有效份数青草的玩家落败。假定牛牛和羊羊都是按照最佳方法进行游戏,请输出胜利者的名字。
 输入描述:
 输入包括t+1行。
 第一行包括一个整数t(1 ≤ t ≤ 100),表示情况数.
 接下来t行每行一个n(1 ≤ n ≤ 10^9),表示青草份数
 输出描述:
 对于每一个n,如果牛牛胜利输出"niu",如果羊羊胜利输出"yang"。
 示例1
 输入

 复制
 3
 1
 2
 3
 输出

 复制
 niu
 yang
 niu
 * @author ouyangxizhu
 *
 */
public class AiQiYi15 {
	/**
	 * 
	 * @param args
	 */

	public static void main(String []args){
		Scanner in=new Scanner(System.in);
		String s1=in.next(),s2,a="",b="";
		int k1=in.nextInt(),k2,i;
		s2=in.next();k2=in.nextInt();
		for(i=0;i<k1;i++) a+=s1;
		for(i=0;i<k2;i++) b+=s2;
		BigInteger x=new BigInteger(a),y=new BigInteger(b);
		System.out.printf("%s",x.compareTo(y)>0?"Greater":x.compareTo(y)<0?"Less":"Equal");
	}

}
