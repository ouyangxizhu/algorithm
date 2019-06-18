package primary.stringstring;
/**
 * ����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��

˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���

ʾ�� 1:

����: "A man, a plan, a canal: Panama"
���: true
ʾ�� 2:

����: "race a car"
���: false
 * @author ouyangxizhu
 *
 */
public class Five {
	public boolean isPalindrome(String s) {

	    s = s.toLowerCase();

	    int startIndex = 0;
	    int endIndex = s.length() - 1;
	    while (startIndex < endIndex && startIndex < s.length() - 1) {
	        char pre = s.charAt(startIndex);
	        char aft = s.charAt(endIndex);
	        if (!((pre >= 'a' && pre <= 'z') || (pre >= '0' && pre <= '9'))) {
	            startIndex++;
	            continue;
	        }
	        if (!((aft >= 'a' && aft <= 'z') || (aft >= '0' && aft <= '9'))) {
	            endIndex--;
	            continue;
	        }

	        if (pre != aft) {
	            return false;
	        }
	        startIndex++;
	        endIndex--;
	    }

	    return true;
	}

	 public boolean isPalindrome1(String s) {
		 if (s.isEmpty()) {
			return true;
		}
		 int head = 0;
		 int tail = s.length()-1;
		 char chead,ctail;
		 while (head<=tail) {
			 chead = s.charAt(head);
			 ctail = s.charAt(tail);
			 if (!Character.isLetterOrDigit(chead)) {
				head++;
				continue;
			}else if (!Character.isLetterOrDigit(ctail)){
				tail++;
				continue;
			}else {
				if (Character.toLowerCase(chead)!=Character.toLowerCase(ctail)) {
					return false;
				}
			}
			 chead++;
			 ctail--;
			
		}
		 return true;
	        
	 }
}
