package Structure;

import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;

//�ڷᱸ�� Ʈ�� ����
public class MakeStructure{
	public int treeHeight;
	public int x, y, width, height;					//600 x 500
	public Color background;
	public String name;	
	String list[];
	String fixList[];
	Color nextColor;
	public MakeStructure next[] = new MakeStructure[4];		//�ϳ��� ��忡 �ٴ� �ٸ� ������ �ִ� ����
	public int r = 0, g = 0, b = 0;
	
	public MakeStructure(int treeHeight, int x, int y, int width, int height, int r, int g , int b, String name) {
		this.treeHeight = treeHeight;
		this.x = x;
		this.y = y;
		this.r = r;
		this.g = g;
		this.b = b;
		this.width = width;
		this.height = height;
		this.background = new Color(r, g, b);
		this.name = name;
	}
											
	public MakeStructure(String[] list, Color background) {
		this.list = list;									//\n�� �������� split�� ���ڿ��� �޴´�.
		treeHeight = tabcount(list[0]);							//���� �ڷ��� ����(=\t����) ����
		name = list[0].trim();
		width = 50;
		height = 20;
		int tmpR = 0, tmpG = 0, tmpB = 0;
		this.background = background;
		
		if(background == null) {
			while(r < 100 || g < 100 || b < 100) {		//����� �ʹ� ���ؼ� ���ڰ� �Ⱥ��̴� �� ����
				r = (int)(Math.random() * 255);
				g = (int)(Math.random() * 255);
				b = (int)(Math.random() * 255);
			}
			this.background = new Color(r, g, b);
			System.out.println("r : " + r+ "g : " + g + "b : " + b);
		}
		else {
			r = background.getRed();
			g = background.getGreen();
			b = background.getBlue();
		}
		
		while(tmpR < 100 || tmpG < 100 || tmpB < 100) {		//����� �ʹ� ���ؼ� ���ڰ� �Ⱥ��̴� �� ����
			tmpR = (int)(Math.random() * 256);
			tmpG = (int)(Math.random() * 256);
			tmpB = (int)(Math.random() * 256);
		}
		
		nextColor = new Color(tmpR, tmpG, tmpB);
		
		
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
			SetDrawInfo();
			FixOverLap();
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
					//System.out.println(name + "�� �� next��");
					next[j] = new MakeStructure(fixList, nextColor);
					//���� �߾����ĵ� ����� x y �� �Ѱ��ٱ�?����������
					if (next[j].fixList == null) {		//List ���ڿ��� ������ �ٴٶ��� ��� fixList�� ���� �������� �����Ƿ�  fixList�� null�� �ȴ�.
						fixList = null;
					}
					else {								//List ���ڿ��� ������ �ƴ� ��� ���� ����� next���� ���� fixList�� �޾ƿ´�.
						fixList = new String[next[j].ReturnFixList().length];
						fixList = next[j].ReturnFixList();
					}
					j++;
					//���߿� next[4]�Ѿ�� ���� �����޽��� ��� ��� �־ �� ��
				}
				else if (nextHeight <= treeHeight) {		//���� ����� height�� ���� ���� ���ų� ���� ��庸�� ���� ��� for�� break
					/*
					String tmp[] = fixList;
					fixList = new String[tmp.length-1];			
					for(int k = 0; k < tmp.length-1; k++) {
						fixList[k] = tmp[k + 1];
					}
					*/
					break;
				}
			}
			
			
		}
	}
	
	public void SetDrawInfo() {	//SetDrawInfo(next);
		MakeStructure tmp[] = next;
		for(int i = 0; i < 4; i++) {		//************1. root�� �ƴ� Ʈ������ 4��° ������� �����Ϸ��� �� �� ����ǥ��
			if (tmp[i] == null) {
				break;
			}
			
				switch (i) {					//************2. �� Ʈ�� height �Ѱ�.(node ����)����
				case 0 :
					tmp[i].x = x - 90;
					tmp[i].y = y;
					new DrawKit(tmp[i]).SetWest();
					break;
				case 1 :
					tmp[i].x = x;
					tmp[i].y = y - 60;
					new DrawKit(tmp[i]).SetNorth();
					break;
				case 2 :
					tmp[i].x = x + 90;
					tmp[i].y = y;
					new DrawKit(tmp[i]).SetEast();
					break;
				case 3 :
					tmp[i].x = x;
					tmp[i].y = y + 60;
					new DrawKit(tmp[i]).SetSouth();
					break;
				}
		}
			
			
	}
	
	
	
	
	void FixOverLap() {	//���� ����� child�� child�� ��ĥ ��� child�� child of child�� ��ġ ����.(�׳� child�� ���� ��ĥ ���� �����Ƿ�)
		MakeStructure tmp[] = next;
		for(int i = 0; i < 4; i++) {		//************1. root�� �ƴ� Ʈ������ 4��° ������� �����Ϸ��� �� �� ����ǥ��
			if (tmp[i] == null) {
				break;
			}
			
				switch (i) {					//************2. �� Ʈ�� height �Ѱ�.(node ����)����
				case 0 :					
					new OverLap(tmp[i]).VerticalOverLap();
					break;
				case 1 :
					new OverLap(tmp[i]).HorizontalOverLap();
					break;  
				case 2 :
					new OverLap(tmp[i]).VerticalOverLap();
					break;
				case 3 :
					new OverLap(tmp[i]).HorizontalOverLap();
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
