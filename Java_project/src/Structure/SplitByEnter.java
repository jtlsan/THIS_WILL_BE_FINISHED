package Structure;

import java.util.StringTokenizer;
//���ڿ��� \n�� �������� ����� str[]�迭�� �����Ͽ� �� ���ڿ� �迭�� �������ش�.
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