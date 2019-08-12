package dynamicprogramming;

/*
 *������������ word1 �� word2��������� word1 ת���� word2 ��ʹ�õ����ٲ����� ��

����Զ�һ�����ʽ����������ֲ�����

����һ���ַ�
ɾ��һ���ַ�
�滻һ���ַ�
ʾ�� 1:

����: word1 = "horse", word2 = "ros"
���: 3
����: 
horse -> rorse (�� 'h' �滻Ϊ 'r')
rorse -> rose (ɾ�� 'r')
rose -> ros (ɾ�� 'e')
ʾ�� 2:

����: word1 = "intention", word2 = "execution"
���: 5
����: 
intention -> inention (ɾ�� 't')
inention -> enention (�� 'i' �滻Ϊ 'e')
enention -> exention (�� 'n' �滻Ϊ 'x')
exention -> exection (�� 'n' �滻Ϊ 'c')
exection -> execution (���� 'u')
 */
public class Leetcode_0091 {
	 public int minDistance(String word1, String word2) {
		  //dp[i][j]��ʾ��һ������ǰi���ַ��仯�ɵڶ������ʵ�ǰj���ַ�����Ҫ����С�༭����
		   int[][] dp=new int[word1.length()+1][word2.length()+1];
		   char [] ch1 = word1.toCharArray();
		   char [] ch2 = word2.toCharArray();
		   
		   dp[0][0]=0;
		   for(int i=0;i<=word1.length();i++){
	            for(int j=0;j<=word2.length();j++){
	                if(i==0){
	                    dp[i][j]=j;   //��� i=0 ����Ҫ����j���ַ�
	                }else if(j==0){
	                    dp[i][j]=i;    //���j=0����Ҫɾ��i���ַ�
	                }else if(ch1[i-1]==ch2[j-1]){   //����ַ���ͬ�����任����������ַ�֮ǰ�Ĳ���
	                    dp[i][j]=dp[i-1][j-1];
	                }else{                          //���� �ʹӲ��룬ɾ�����޸���ѡ����С�� �� 1 
	                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
	                }
	            }
	        }

		return dp[word1.length()][word2.length()]; 
	
	 }
	 public static void main(String[] args) {
		
		String word1="mart";
		String word2="karma";
	    System.out.println(new dynamicprogramming.Leetcode_0091().minDistance(word1,word2));
	}

        
}
