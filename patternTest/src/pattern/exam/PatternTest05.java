package pattern.exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest05 {
	public static void main(String[] args) {
		//String str = "tomato jaava tomato prog potato";
		//String str = "aaaaa aaabc iiiii iiibc aiabc";
		String str = "adsf111 a1 b5 b55 aaa5 qa5 5a";
		//String patternStr = "(tom|pot)ato";
		//String patternStr = "(a|i){3}bc";
		String patternStr = "([a-z][0-9])";//()사용했기 때문에 앞한글자는 영문 뒤한글자는 숫자 순서
		equalsPattern(str, patternStr);
	}
	public static void equalsPattern(String str, String patternStr) {
		//1. 패턴을 인식
		Pattern pattern = Pattern.compile(patternStr);
		//2. 패턴을 적용하여 문자열을 관리
		Matcher m = pattern.matcher(str);
		/*System.out.println(m.find());
		System.out.println(m.start());
		System.out.println(m.end());
		System.out.println(m.group());*/
		
		while(m.find()) {
			System.out.println(m.group());
			System.out.println(m.start()+":"+(m.end()-1));
		}
	}
}
