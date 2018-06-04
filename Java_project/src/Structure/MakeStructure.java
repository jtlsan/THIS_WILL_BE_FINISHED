package Structure;

import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;

//�ڷᱸ�� Ʈ�� ����
public class MakeStructure{
	int treeHeight;
	public int x, y, width, height;					//600 x 500
	public String name;	
	String list[];
	String fixList[];
	public MakeStructure next[] = new MakeStructure[4];		//�ϳ��� ��忡 �ٴ� �ٸ� ������ �ִ� ����
											
	public MakeStructure(String[] list) {
		this.list = list;									//\n�� �������� split�� ���ڿ��� �޴´�.
		treeHeight = tabcount(list[0]);							//���� �ڷ��� ����(=\t����) ����
		name = list[0].trim();
		width = 50;
		height = 20;
		
		
		if (list.length > 1) {								//fixList�� list�� �迭���� �� ĭ�� ������ ��� ��(ex) fixList[0] == List[1];
			fixList = new String[list.length-1];			//list.length�� 1�� �Ǹ� fixList�� ���̰� 0�� �ǹǷ� �̸� �������ش�.
			for(int i = 0; i < list.length-1; i++) {
				fixList[i] = list[i + 1];
			}
			MoveNext();
		}
		
		if (treeHeight == 0) {
			x = 275;				//****************scrollpane ������ ���� ������ ��ǥ�� ��������� �����ϰ� ���ľ� �� �� ����
			y = 240;
			SetDrawInfo(next);
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
				if(nextHeight == treeHeight + 1) {
					next[j] = new MakeStructure(fixList);
					//���� �߾����ĵ� ����� x y �� �Ѱ��ٱ�?����������
					if (next[j].fixList == null) {		//List ���ڿ��� ������ �ٴٶ��� ��� fixList�� ���� �������� �����Ƿ�  fixList�� null�� �ȴ�.
						fixList = null;
					}
					else {								//List ���ڿ��� ������ �ƴ� ��� ���� ����� next���� ���� fixList�� �޾ƿ´�.
						fixList = new String[next[j].ReturnFixList().length];
						fixList = next[j].ReturnFixList();
					}
					j++;													//���߿� next[4]�Ѿ�� ���� �����޽��� ��� ��� �־ �� ��
				}
				else if (nextHeight <= treeHeight)		//���� ����� height�� ���� ���� ���ų� ���� ��庸�� ���� ��� for�� break
					break;
			}
			
			
		}
	}
	public void SetDrawInfo(MakeStructure[] strct) {	//SetDrawInfo(next);
		MakeStructure tmp[] = strct;
		for(int i = 0; i < 4; i++) {		//************1. root�� �ƴ� Ʈ������ 4��° ������� �����Ϸ��� �� �� ����ǥ��
			if (tmp[i] == null) {
				break;
			}
			switch (i) {					//************2. �� Ʈ�� height �Ѱ�.(node ����)����
			case 0 :
				tmp[i].x = x - 90;
				tmp[i].y = y - 80;
				break;
			case 1 :
				tmp[i].x = x + 90;
				tmp[i].y = y - 80;
				break;
			case 2 :
				tmp[i].x = x - 90;
				tmp[i].y = y + 80;
				break;
			case 3 :
				tmp[i].x = x + 90;
				tmp[i].y = y + 80;
				break;
			}
			if (tmp[i].next[0] != null)
				tmp[i].SetDrawInfo(tmp[i].next);
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
