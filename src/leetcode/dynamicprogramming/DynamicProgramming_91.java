package dynamicprogramming;

/*
 *给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
示例 1:

输入: word1 = "horse", word2 = "ros"
输出: 3
解释: 
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2:

输入: word1 = "intention", word2 = "execution"
输出: 5
解释: 
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
 */
public class DynamicProgramming_91 {
	 public int minDistance(String word1, String word2) {
		  //dp[i][j]表示第一个单词前i个字符变化成第二个单词的前j个字符所需要的最小编辑次数
		   int[][] dp=new int[word1.length()+1][word2.length()+1];
		   char [] ch1 = word1.toCharArray();
		   char [] ch2 = word2.toCharArray();
		   
		   dp[0][0]=0;
		   for(int i=0;i<=word1.length();i++){
	            for(int j=0;j<=word2.length();j++){
	                if(i==0){
	                    dp[i][j]=j;   //如果 i=0 则需要插入j个字符
	                }else if(j==0){
	                    dp[i][j]=i;    //如果j=0则需要删除i个字符
	                }else if(ch1[i-1]==ch2[j-1]){   //如果字符相同则不做变换，等于这个字符之前的步数
	                    dp[i][j]=dp[i-1][j-1];
	                }else{                          //否则 就从插入，删除，修改中选择最小的 加 1 
	                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
	                }
	            }
	        }

		return dp[word1.length()][word2.length()]; 
	
	 }
	 public static void main(String[] args) {
		
		String word1="mart";
		String word2="karma";
	    System.out.println(new DynamicProgramming_91().minDistance(word1,word2));
	}

        
}
