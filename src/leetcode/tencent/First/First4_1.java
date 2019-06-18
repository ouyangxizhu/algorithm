package Tencent.First;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class First4_1 {
	 public int myAtoi(String str) {
	        Pattern p = Pattern.compile("(\\s+)?(-|\\+)?\\d+.*");
			Matcher m = p.matcher(str);
			// 整体满足上面的形式时就说明有可以转换的
			if (m.matches()) {
				int integer;
				// 找出可以转换的
				p = Pattern.compile("(-|\\+)?\\d+");
				m = p.matcher(str);
				if (m.find()) {
					try {
						// Integer.parseInt只能转换正常样式的 -24g这种不能转换
						integer = Integer.parseInt(m.group());
					} catch (Exception e) {
						if (m.group(1).equals("-")) {
							return Integer.MIN_VALUE;
						} else {
							return Integer.MAX_VALUE;
						}
					}
					// 转换成功就返回结果
					return integer;
				}

			}
			// 表示没有可以转换的
			return 0;
	    }

}
