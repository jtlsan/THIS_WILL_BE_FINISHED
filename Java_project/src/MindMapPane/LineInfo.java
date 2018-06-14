package MindMapPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Structure.*;

public class LineInfo {	//new LineInfo(strct);				***상수쓰지 말 것!
	MakeStructure strct;
	JPanel panel;
	public LineInfo(MakeStructure strct, JPanel panel) {
		this.strct = strct;
		this.panel = panel;
	}
	
	void FirstDraw() {
		int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
		for (int i = 0; i < strct.next.length; i++) {
			switch(i) {
			case 0 :
				x1 = strct.x;
				y1 = strct.y + (int)(strct.height / 2);
				x2 = strct.next[i].x + strct.width;
				y2 = strct.next[i].y + (int)(strct.next[i].height / 2);
				new DrawLine(x1, y1, x2, y2);
			}
		}
	}
	
	class DrawLine extends JPanel{
		int x1, y1, x2, y2;
		public DrawLine( int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.drawLine(x1, y1, x2, y2);
		}
	}
}
