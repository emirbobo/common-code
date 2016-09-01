package stringcustomreplace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用正则查找给定的字符串的子串，根据算法替换内容
 */
public class StringCustomeReplace {
	public static void main(String[] args) {
		StringCustomeReplace o = new StringCustomeReplace();
		o.execute();
	}


	Pattern pattern = Pattern.compile("\\s(t_[^\\s]+)",Pattern.CASE_INSENSITIVE);

	private void execute() {
		String strs[] = new String[]{
				"select t_user defd test cud T_o from t_p defd group bydfd T_dddd"
				,"select t_user defd test cud T_o from t_p defd group bydfd T_dddd by"
		};

		for(String str : strs)
		{
			Matcher matcher = pattern.matcher(str);
			StringBuilder sb = new StringBuilder();
			int start = 0;
			while(matcher.find()) {
				String found = matcher.group(1);
				log("Found : [" + found+ "]");
				if(matcher.start() > start)
					sb.append(str.substring(start,matcher.start()));
				sb.append(" Table:");
				sb.append(getReplacedValue(found));//定制替换
				start = matcher.end();
			}
			if(start < str.length())
				sb.append(str.substring(start));
			log("Result : [" + sb+ "]");
		}
	}

	private String getReplacedValue(String found) {
		return found+"_0";
	}

	private void log(String s) {
		System.out.println(s);
	}
}
