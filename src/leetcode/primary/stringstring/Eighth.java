package primary.stringstring;
/**
 * ����������һ���������У��������е�������˳����б������õ���һ��������ǰ�������£�

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 ������  "one 1"  ("һ��һ") , �� 11��
11 ������ "two 1s" ("����һ"��, �� 21��
21 ������ "one 2",  "one 1" ��"һ����" ,  "һ��һ") , �� 1211��

����һ�������� n��1 �� n �� 30��������������еĵ� n �

ע�⣺����˳�򽫱�ʾΪһ���ַ�����

 

ʾ�� 1:

����: 1
���: "1"
ʾ�� 2:

����: 4
���: "1211"
 * @author ouyangxizhu
 *
 */
public class Eighth {
	public String countAndSay(int n) {
        if(n==1){
            return (1+"");
        }
        String s = countAndSay(n-1);
        char[] ch = s.toCharArray();
        int count = 1;//��¼�ظ����ֵ�����
        char chh= ch[0];//��¼��ǰ����
        StringBuffer sb = new StringBuffer();
        for(int i=1; i<ch.length; i++){
            if (ch[i]==chh) {
				count++;
			}else {
				sb.append(count);
				sb.append(chh);
				chh = ch[i];
				count = 1;
			}
        }
        sb.append(count);
		sb.append(chh);
        return sb.toString();
    }
}
