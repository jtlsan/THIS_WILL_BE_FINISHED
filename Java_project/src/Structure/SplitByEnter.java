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
		System.out.println("counttonkens : " + st.countTokens());
				for (int i = 0; i < 3; i++) {		//counttokens�� 3�϶��� �� 2�� �Ǵ� ���ΰ�????
					str[i] = st.nextToken();
					System.out.println("i : " + i);
				}
		for(int i = 0 ; i < str.length; i++) {
			System.out.println(str[i]);
		}
		return str;
	}
}