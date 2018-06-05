package MindMapPane;

//속성이나 마우스로 노드의 정보를 변경하면 자료의 정보를 변경하고 즉각 draw함수를 다시 쓴다. 근데 color가 동일해야 할 때가 있으므로 Draw함수를 또 하나 만들어서 color를 유지시키되 모양만
//변하는 함수를 만들어야 할 것 같다.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Structure.*;

public class DrawInfo {
	MakeStructure structure;
	JPanel panel;
	DrawInfo next[] = new DrawInfo[4];
	public String name;
	JLabel node;
	Color background;
	
	public DrawInfo(MakeStructure structure, JPanel panel, Color background) {		//600 x 500
		this.structure = structure;
		this.panel = panel;
		this.name = structure.name;
		this.background = background;
		
		int r = 0, g = 0, b = 0;
		
		if (background == null) {
			while(r < 100 || g < 100 || b < 100) {		//배경이 너무 진해서 글자가 안보이는 것 방지
				r = (int)(Math.random() * 256);
				g = (int)(Math.random() * 256);
				b = (int)(Math.random() * 256);
			}
			background = new Color(r, g, b);
			r = 0; g = 0; b = 0;
		}
		while(r < 100 || g < 100 || b < 100) {		//배경이 너무 진해서 글자가 안보이는 것 방지
			r = (int)(Math.random() * 256);
			g = (int)(Math.random() * 256);
			b = (int)(Math.random() * 256);
		}

		Color setNextColor = new Color(r, g, b);
		
		structure.background = this.background;
		node = new JLabel(name);
		node.setHorizontalAlignment(SwingConstants.CENTER);
		node.setSize(50, 20);					//add를 한 다음에야 background설정을 해야 되는 듯
		node.setLocation(structure.x, structure.y);
		panel.add(node);
		//색깔설정
		node.setBackground(background);
		node.setOpaque(true);
		
		
		for(int i = 0; i < 4; i++) {
			if (structure.next[i] == null)
				break;
			new DrawInfo(structure.next[i], panel, setNextColor);
		}
	}
	

	


}
