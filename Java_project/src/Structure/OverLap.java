package Structure;
import javax.swing.*;
public class OverLap {
	MakeStructure strct;
	JPanel mapPanel;
	
	public OverLap(MakeStructure strct, JPanel mapPanel) {
		this.strct = strct;
		this.mapPanel = mapPanel;
	}
	
	public OverLap(MakeStructure strct) {
		this.strct = strct;
	}
	
	public void setPanel() {
		OverLap way[] = new OverLap[4];
		for (int i = 0; i < strct.next.length; i++) {
			if (strct.next[i] == null)
				break;
			way[i] = new OverLap(strct.next[i]);
		}
		int x = way[2].BeginCoordinate('x');
		int y = way[2].EndCoordinate('y');
		mapPanel.setSize(x, y);
		mapPanel.revalidate();
				
	}
	void VerticalOverLap() {
		for(int i = 0; i < 2; i++) {
			if(strct.next[i] != null)
				new OverLap(strct.next[i]).VerticalOverLap();
			
			if (strct.next[i + 1] == null || strct.next[i].next[0] == null || strct.next[i+1].next[0] == null)
				continue;
			
			int gap = (strct.next[i].next[lastNode(strct.next[i])].y + strct.next[i].next[lastNode(strct.next[i])].height) - strct.next[i + 1].next[0].y;

			if(gap > 0) {
				switch(i) {
				case 0:					
					strct.next[i].y -= gap + 20;
					for(int l = 0; l <= lastNode(strct.next[i]); l++) {
						strct.next[i].next[l].y -= gap + 20;							

					}						
					break;
				case 1:
					strct.next[i + 1].y += gap + 20;
					for(int l = 0; l <= lastNode(strct.next[i + 1]); l++) {
						strct.next[i + 1].next[l].y += gap + 20;							
					}
					break;
				}
			}
		}
	}
	
	void HorizontalOverLap() {
		for(int i = 0; i < 2; i++) {
			if(strct.next[i] != null)
				new OverLap(strct.next[i]).HorizontalOverLap();
			
			if (strct.next[i + 1] == null || strct.next[i].next[0] == null || strct.next[i+1].next[0] == null)
				continue;
			
			int gap = (strct.next[i].next[lastNode(strct.next[i])].x + strct.next[i].next[lastNode(strct.next[i])].width) - strct.next[i + 1].next[0].x;
			
			if(gap > 0) {
				switch(i) {
				case 0:					
					strct.next[i].x -= gap + 20;
					for(int l = 0; l <= lastNode(strct.next[i]); l++) {
						strct.next[i].next[l].x -= gap + 20;							
						
					}						
					break;
				case 1:
					strct.next[i + 1].x += gap + 20;
					for(int l = 0; l <= lastNode(strct.next[i + 1]); l++) {
						strct.next[i + 1].next[l].x += gap + 20;							
					}
					break;
				}
			}
		}
	}
	
	int BeginCoordinate(char way) {
		MakeStructure tmp = this.strct;
		
		
		while(tmp.next[0] != null)
			tmp = tmp.next[0];		
		switch(way) {
		case 'x':
			return tmp.x;
		case 'y':
			return tmp.y;
		default:
			return 0;
		}
	}
	
	int EndCoordinate(char way) {
		MakeStructure tmp = strct;
		
		while(tmp.next[0] != null)
			tmp = tmp.next[lastNode(tmp)];
		
		switch(way) {
		case 'x':
			return tmp.x;
		case 'y':
			return tmp.y;
		default:
			return 0;
		}
	}
	
	void Fix_X(int x, MakeStructure structure, char sign) {
		MakeStructure tmp = structure;
		if (sign == '+')
			tmp.x += x;
		else
			tmp.x -= x;
		for(int i = 0; i < 4; i++) {
			if (tmp.next[i] == null)
				break;
			Fix_X(x, tmp.next[i], sign);
		}
	}
	
	void Fix_Y(int y, MakeStructure structure, char sign) {
		MakeStructure tmp = structure;
		if (sign == '+')
			tmp.y += y;
		else
			tmp.y -= y;
		for(int i = 0; i < 4; i++) {
			if (tmp.next[i] == null)
				break;
			Fix_Y(y, tmp.next[i], sign);
		}
	}
	
	
	public void OverallOverLap() {		//templete에서 실행할 거임. new OverLap(strct).OverallOverLap();
		int gapX = 0;
		int gapY = 0;
		OverLap way[] = new OverLap[4];
		for (int i = 0; i < strct.next.length; i++) {
			if (strct.next[i] == null)
				break;
			way[i] = new OverLap(strct.next[i]);
		}
		for(int i = 0; i < way.length; i++) {
			if(way[i] == null)
				break;
			gapX = 0;
			gapY = 0;
			
			switch(i) {
			case 0:
				if (strct.next[i+1] == null)
					break;	
				gapX = way[i].BeginCoordinate('x') - way[i + 1].BeginCoordinate('x');	//**********8height가 1일때의 노드와 height가 3일때의 노드가 비교됨		//나아아중에해결할것. 일단은 ㄱㅊ
				gapY = way[i + 1].BeginCoordinate('y') - way[i].BeginCoordinate('y');	
				if (gapX > 0)
					Fix_X(gapX + 70, strct.next[i], '-');
				if (gapY > 0)
					Fix_Y(gapY + 40, strct.next[i + 1], '-');
				break;
			case 1:
				if (strct.next[i+1] == null)
					break;
				gapX = way[i].EndCoordinate('x') - way[i + 1].BeginCoordinate('x');
				gapY = way[i].EndCoordinate('y') - way[i + 1].BeginCoordinate('y');
				if (gapX > 0)
					Fix_X(gapX + 70, strct.next[i + 1], '+');
				if (gapY > 0)
					Fix_Y(gapY + 40, strct.next[i], '-');
				
				break;
			case 2:
				if (strct.next[i+1] == null)
					break;
				gapX = way[i + 1].EndCoordinate('x') - way[i].EndCoordinate('x');
				gapY = way[i].EndCoordinate('y') - way[i + 1].EndCoordinate('y');
				if (gapX > 0)
					Fix_X(gapX + 70, strct.next[i], '+');
				if (gapY > 0)
					Fix_Y(gapY + 40, strct.next[i + 1], '+');
				break;
			case 3:
				gapX = way[0].EndCoordinate('x') - way[i].EndCoordinate('x');
				gapY = way[0].EndCoordinate('y') - way[i].EndCoordinate('y');
				if (gapX > 0)
					Fix_X(gapX + 70, strct.next[0], '-');
				if (gapY > 0)
					Fix_Y(gapY + 40, strct.next[i], '+');
				break;
			}
		}
	}


	
	int lastNode(MakeStructure structure) {
		int lastNum = 0;
		for(int i = 0; i < 4; i++) {
			if (structure.next[i] == null)
				break;
			lastNum = i;
		}
		return lastNum;
	}
	
	
}

