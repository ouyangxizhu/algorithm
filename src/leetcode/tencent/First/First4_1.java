package Tencent.First;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class First4_1 {
	 public int myAtoi(String str) {
	        Pattern p = Pattern.compile("(\\s+)?(-|\\+)?\\d+.*");
			Matcher m = p.matcher(str);
			// ���������������ʽʱ��˵���п���ת����
			if (m.matches()) {
				int integer;
				// �ҳ�����ת����
				p = Pattern.compile("(-|\\+)?\\d+");
				m = p.matcher(str);
				if (m.find()) {
					try {
						// Integer.parseIntֻ��ת��������ʽ�� -24g���ֲ���ת��
						integer = Integer.parseInt(m.group());
					} catch (Exception e) {
						if (m.group(1).equals("-")) {
							return Integer.MIN_VALUE;
						} else {
							return Integer.MAX_VALUE;
						}
					}
					// ת���ɹ��ͷ��ؽ��
					return integer;
				}

			}
			// ��ʾû�п���ת����
			return 0;
	    }

}
