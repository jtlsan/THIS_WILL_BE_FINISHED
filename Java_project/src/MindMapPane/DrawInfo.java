package MindMapPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Structure.*;

public class DrawInfo {
	MakeStructure structure;
	JPanel panel;
	int x, y, width, height;
	DrawInfo next[] = new DrawInfo[4];
	public String name;
	
	public DrawInfo(MakeStructure structure, JPanel panel) {		//600 x 500
		this.structure = structure;
		this.panel = panel;
		this.name = structure.name;
		int r = 0, g = 0, b = 0;
		while(r < 100 || g < 100 || b < 100) {		//����� �ʹ� ���ؼ� ���ڰ� �Ⱥ��̴� �� ����
			r = (int)(Math.random() * 256);
			g = (int)(Math.random() * 256);
			b = (int)(Math.random() * 256);
		}
		Color background = new Color(r, g, b);
		
		Draw(structure, panel, background);
	}
	

	
	public void Draw(MakeStructure strct, JPanel Map, Color background) {
		int r = 0, g = 0, b = 0;
		
		while(r < 100 || g < 100 || b < 100) {
			r = (int)(Math.random() * 256);
			g = (int)(Math.random() * 256);
			b = (int)(Math.random() * 256);
		}
		Color newBackground = new Color(r, g, b);
		
		MakeStructure tmp = strct;
		JLabel node = new JLabel(strct.name);
		node.setHorizontalAlignment(SwingConstants.CENTER);
		node.setSize(50, 20);					//add�� �� �������� background������ �ؾ� �Ǵ� ��
		node.setLocation(strct.x, strct.y);
		Map.add(node);
		//������
		node.setBackground(background);
		node.setOpaque(true);
		
		Map.add(node);
		for(int i = 0; i < 4; i++) {		
			if (tmp.next[i] == null) {
				break;
			}
			Draw(tmp.next[i], Map, newBackground);
		}
		
	}

}
