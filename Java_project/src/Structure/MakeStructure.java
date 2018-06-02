package Structure;

//�ڷᱸ�� Ʈ�� ����
public class MakeStructure{
	int height;
	String name;	
	String list[];
	String fixList[];
	MakeStructure next[] = new MakeStructure[4];
	public MakeStructure(String[] list) {
		this.list = list;
		height = tabcount(list[0]);
		name = list[0].trim();
		if (list.length > 1) {
			fixList = new String[list.length-1];
			for(int i = 0; i < list.length-1; i++) {
				fixList[i] = list[i + 1];
			}
			MoveNext();
		}
	}
	
	public void MoveNext() {
		if (fixList.length > 0) {
			int num = fixList.length;
			
			for(int i = 0, j = 0; i < num; i++) {
				int nextHeight = tabcount(fixList[i]);
				if(nextHeight == height + 1) {
					next[j] = new MakeStructure(fixList);
					fixList = next[j].FixedList();
					j++;													//���߿� next[4]�Ѿ�� ���� �����޽��� ��� ��� �־ �� ��
				}
				else if (nextHeight <= height)
					break;
			}
		}
	}
	
	public String[] FixedList() {
		return fixList;
	}
	
	public int tabcount(String str) {
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '\t')
				count++;
		}
		return count;
	}
}
