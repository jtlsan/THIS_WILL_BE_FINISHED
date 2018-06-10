package Structure;

import java.awt.Graphics;
public class DrawKit {
	MakeStructure strct;
	public DrawKit(MakeStructure strct) {
		this.strct = strct;
	}
	
	public void WestLine(Graphics g) {
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0;
		
		for (int i = 0; i < 3; i++) {
			if(strct.next[i] == null)
				break;
			
			switch(i) {
			case 0:
				x1= strct.x + (int)(strct.width / 2);
				y1 = strct.y;
				x3 = strct.next[i].x + strct.next[i].width;
				y3 = strct.next[i].y + (int)(strct.next[i].height / 2);
				/*x2 = x1;
				y2 = y3;
				g.drawLine(x1,  y1,  x2,  y2);
				g.drawLine(x2,  y2,  x3,  y3);*/
				g.drawLine(x1,  y1,  x3,  y3);
				break;
				
			case 1:
				x1 = strct.x;
				y1 = strct.y + (int)(strct.height /2 );
				x3 = strct.next[i].x + strct.next[i].width;
				y3 = strct.next[i].y + (int)(strct.next[i].height / 2);
				g.drawLine(x1,  y1,  x3,  y3);
				break;
				
			case 2:
				x1 = strct.x + (int)(strct.width / 2);
				y1 = strct.y + strct.height;
				x3 = strct.next[i].x + strct.next[i].width;
				y3 = strct.next[i].y + (int)(strct.next[i].height / 2);
				/*x2 = x1;
				y2 = y3;
				g.drawLine(x1,  y1,  x2,  y2);
				g.drawLine(x2,  y2,  x3 , y3);*/
				g.drawLine(x1,  y1,  x3,  y3);
				break;
			}
			
			if(strct.next[0] != null)
				new DrawKit(strct.next[i]).WestLine(g);
		}
	}
	public void NorthLine(Graphics g) {
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0;
		
		for (int i = 0; i < 3; i++) {
			if(strct.next[i] == null)
				break;
			
			switch(i) {
			case 0:
				x1= strct.x;
				y1 = strct.y + (int)(strct.height / 2);
				x3 = strct.next[i].x + (int)(strct.next[i].width / 2);
				y3 = strct.next[i].y + strct.next[i].height;
				/*x2 = x3;
				y2 = y1;
				g.drawLine(x1,  y1,  x2,  y2);
				g.drawLine(x2,  y2,  x3,  y3);*/
				g.drawLine(x1,  y1,  x3,  y3);
				break;
				
			case 1:
				x1 = strct.x + (int)(strct.width / 2);
				y1 = strct.y;
				x3 = strct.next[i].x + (int)(strct.next[i].width / 2);
				y3 = strct.next[i].y + strct.next[i].height;
				g.drawLine(x1,  y1,  x3,  y3);
				break;
				
			case 2:
				x1 = strct.x + strct.width;
				y1 = strct.y + (int)(strct.height / 2);
				x3 = strct.next[i].x + (int)(strct.next[i].width / 2);
				y3 = strct.next[i].y + strct.next[i].height;
				/*x2 = x3;
				y2 = y1;
				g.drawLine(x1,  y1,  x2,  y2);
				g.drawLine(x2,  y2,  x3 , y3);*/
				g.drawLine(x1,  y1,  x3,  y3);
				break;
			}
			
			if(strct.next[0] != null)
				new DrawKit(strct.next[i]).NorthLine(g);
		}
	}
	public void EastLine(Graphics g) {
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0;
		
		for (int i = 0; i < 3; i++) {
			if(strct.next[i] == null)
				break;
			
			switch(i) {
			case 0:
				x1= strct.x + (int)(strct.width / 2);
				y1 = strct.y;
				x3 = strct.next[i].x;
				y3 = strct.next[i].y + (int)(strct.next[i].height / 2);
				/*x2 = x1;
				y2 = y3;
				g.drawLine(x1,  y1,  x2,  y2);
				g.drawLine(x2,  y2,  x3,  y3);*/
				g.drawLine(x1,  y1,  x3,  y3);
				break;
				
			case 1:
				x1 = strct.x + strct.width;
				y1 = strct.y + (int)(strct.height /2 );
				x3 = strct.next[i].x;
				y3 = strct.next[i].y + (int)(strct.next[i].height / 2);
				g.drawLine(x1,  y1,  x3,  y3);
				break;
				
			case 2:
				x1 = strct.x + (int)(strct.width / 2);
				y1 = strct.y + strct.height;
				x3 = strct.next[i].x;
				y3 = strct.next[i].y + (int)(strct.next[i].height / 2);
				/*x2 = x1;
				y2 = y3;
				g.drawLine(x1,  y1,  x2,  y2);
				g.drawLine(x2,  y2,  x3 , y3);*/
				g.drawLine(x1,  y1,  x3,  y3);
				break;
			}
			
			if(strct.next[0] != null)
				new DrawKit(strct.next[i]).EastLine(g);
		}
	}
	public void SouthLine(Graphics g) {
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0, x3 = 0, y3 = 0;
		
		for (int i = 0; i < 3; i++) {
			if(strct.next[i] == null)
				break;
			
			switch(i) {
			case 0:
				x1= strct.x;
				y1 = strct.y + (int)(strct.height / 2);
				x3 = strct.next[i].x + (int)(strct.next[i].width / 2);
				y3 = strct.next[i].y;
				//x2 = x3;
				//y2 = y1;
				//g.drawLine(x1,  y1,  x2,  y2);
				//g.drawLine(x2,  y2,  x3,  y3);
				g.drawLine(x1,  y1,  x3,  y3);
				break;
				
			case 1:
				x1 = strct.x + (int)(strct.width / 2);
				y1 = strct.y + strct.height;
				x3 = strct.next[i].x + (int)(strct.next[i].width / 2);
				y3 = strct.next[i].y;
				g.drawLine(x1,  y1,  x3,  y3);
				break;
				
			case 2:
				x1 = strct.x + strct.width;
				y1 = strct.y + (int)(strct.height / 2);
				x3 = strct.next[i].x + (int)(strct.next[i].width / 2);
				y3 = strct.next[i].y;
				/*x2 = x3;
				y2 = y1;
				g.drawLine(x1,  y1,  x2,  y2);
				g.drawLine(x2,  y2,  x3 , y3);*/
				g.drawLine(x1,  y1,  x3,  y3);
				break;
			}
			
			if(strct.next[0] != null)
				new DrawKit(strct.next[i]).SouthLine(g);
		}
	}


	
	void SetWest() {
		for(int i = 0; i < 3; i++) {
			if (strct.next[i] == null)
				break;
			
			switch (i) {					//************2. 그 트리 height 한계.(node 개수)문제
			case 0 :
				strct.next[i].x = strct.x - 90;
				strct.next[i].y = strct.y - 60;
				break;
			case 1 :
				strct.next[i].x = strct.x - 90;
				strct.next[i].y = strct.y;
				break;
			case 2 :
				strct.next[i].x = strct.x - 90;
				strct.next[i].y = strct.y + 60;
				break;

			}
			if (strct.next[0] != null)
				new DrawKit(strct.next[i]).SetWest();
			
		}
	}
	void SetEast() {
		for(int i = 0; i < 3; i++) {
			if (strct.next[i] == null)
				break;
			
			switch (i) {					//************2. 그 트리 height 한계.(node 개수)문제
			case 0 :
				strct.next[i].x = strct.x + 90;
				strct.next[i].y = strct.y - 60;
				break;
			case 1 :
				strct.next[i].x = strct.x + 90;
				strct.next[i].y = strct.y;
				break;
			case 2 :
				strct.next[i].x = strct.x + 90;
				strct.next[i].y = strct.y + 60;
				break;
				
			}
			if (strct.next[0] != null)
				new DrawKit(strct.next[i]).SetEast();
			
		}
	}
	void SetNorth() {
		for(int i = 0; i < 3; i++) {
			if (strct.next[i] == null)
				break;
			
			switch (i) {					//************2. 그 트리 height 한계.(node 개수)문제
			case 0 :
				strct.next[i].x = strct.x - 90;
				strct.next[i].y = strct.y - 60;
				break;
			case 1 :
				strct.next[i].x = strct.x;
				strct.next[i].y = strct.y - 60;
				break;
			case 2 :
				strct.next[i].x = strct.x + 90;
				strct.next[i].y = strct.y - 60;
				break;
				
			}
			if (strct.next[0] != null)
				new DrawKit(strct.next[i]).SetNorth();
			
		}
	}
	void SetSouth() {
		for(int i = 0; i < 3; i++) {
			if (strct.next[i] == null)
				break;
			
			switch (i) {					//************2. 그 트리 height 한계.(node 개수)문제
			case 0 :
				strct.next[i].x = strct.x - 90;
				strct.next[i].y = strct.y + 60;
				break;
			case 1 :
				strct.next[i].x = strct.x;
				strct.next[i].y = strct.y + 60;
				break;
			case 2 :
				strct.next[i].x = strct.x + 90;
				strct.next[i].y = strct.y + 60;
				break;
				
			}
			if (strct.next[0] != null)
				new DrawKit(strct.next[i]).SetSouth();
			
		}
	}
}
