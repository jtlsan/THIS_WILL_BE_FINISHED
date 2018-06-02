package Structure;

import java.util.StringTokenizer;
//문자열을 \n을 기준으로 나누어서 str[]배열에 저장하여 이 문자열 배열을 리턴해준다.
public class SplitByEnter {
	String list;
	public SplitByEnter(String list) {
		this.list = list;
	}
	
	public String[] Split() {
		StringTokenizer st = new StringTokenizer(list, "\n");
		String str[] = new String[st.countTokens()];
		int Tokencount = st.countTokens();
				for (int i = 0; i < Tokencount; i++) {		
					str[i] = st.nextToken();
				}
		return str;
	}
}