package primary.stringstring;
/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
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
