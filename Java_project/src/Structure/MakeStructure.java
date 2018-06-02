package Structure;

//�ڷᱸ�� Ʈ�� ����
public class MakeStructure{
	int height;
	public String name;	
	String list[];
	String fixList[];
	public MakeStructure next[] = new MakeStructure[4];		//�ϳ��� ��忡 �ٴ� �ٸ� ������ �ִ� ����
	public MakeStructure(String[] list) {
		this.list = list;									//\n�� �������� split�� ���ڿ��� �޴´�.
		height = tabcount(list[0]);							//���� �ڷ��� ����(=\t����) ����
		name = list[0].trim();
		if (list.length > 1) {								//fixList�� list�� �迭���� �� ĭ�� ������ ��� ��(ex) fixList[0] == List[1];
			fixList = new String[list.length-1];			//list.length�� 1�� �Ǹ� fixList�� ���̰� 0�� �ǹǷ� �̸� �������ش�.
			for(int i = 0; i < list.length-1; i++) {
				fixList[i] = list[i + 1];
			}
			MoveNext();
		}
	}
	//���� ��尡 �ִٸ� ���� ��带 �����Ų��.
	public void MoveNext() {
		if (fixList.length > 0) {
			int num = fixList.length;
			int nextHeight;
			
			for(int i = 0, j = 0; i < num; i++) {
				
				if(fixList == null)		//fixList�� null�� ���� ������ ���ڿ� List�� ���� �ٴٶ� 38��° �ڵ�ó��  null�� �����ϴ� ���ۿ� ����. ��  �� ����
					break;
				nextHeight = tabcount(fixList[0]);	
			//���� ����� height�� ���� ����� height���� 1��ŭ ���� ��쿡�� next�� ���� ��� ����. �׷��� ���� ��� for�� break.
				if(nextHeight == height + 1) {
					next[j] = new MakeStructure(fixList);
					if (next[j].fixList == null) {		//List ���ڿ��� ������ �ٴٶ��� ��� fixList�� ���� �������� �����Ƿ�  fixList�� null�� �ȴ�.
						fixList = null;
					}
					else {								//List ���ڿ��� ������ �ƴ� ��� ���� ����� next���� ���� fixList�� �޾ƿ´�.
						fixList = new String[next[j].ReturnFixList().length];
						fixList = next[j].ReturnFixList();
					}
					j++;													//���߿� next[4]�Ѿ�� ���� �����޽��� ��� ��� �־ �� ��
				}
				else if (nextHeight <= height)		//���� ����� height�� ���� ���� ���ų� ���� ��庸�� ���� ��� for�� break
					break;
			}
		}
	}
	
	//���� List�� �����Ѵ�.
	public String[] ReturnList() {
		return list;
	}
	//���� FixList�� �����Ѵ�.
	public String[] ReturnFixList() {
		return fixList;
	}
	//\t�� ������ �����Ѵ�.
	public int tabcount(String str) {
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '\t')
				count++;
		}
		return count;
	}
}
