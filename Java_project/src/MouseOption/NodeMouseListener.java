package MouseOption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Structure.*;
import MindMapPane.DrawInfo;

public class NodeMouseListener extends MouseAdapter{
	JTextField name, x, y, width, height, color;
	MakeStructure strct;
	MakeStructure objectStrct;
	DrawInfo nodeInfo;
	String objectText;
	public NodeMouseListener(JTextField name, JTextField x, JTextField y, JTextField width, JTextField height, JTextField color, 
			MakeStructure strct) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.strct = strct;
		this.nodeInfo = nodeInfo;
		int e = MouseEvent.MOUSE_CLICKED;
		
	}
	public void mouseClicked(MouseEvent e) {
		JLabel label = (JLabel)e.getSource();

		objectText = label.getText();
		Search(strct);
		name.setText(objectStrct.name);
		x.setText(Integer.toString(objectStrct.x));
		y.setText(Integer.toString(objectStrct.y));
		width.setText(Integer.toString(objectStrct.width));
		height.setText(Integer.toString(objectStrct.height));
		color.setText(Integer.toString(objectStrct.background.getRGB()));


	}
	
	void Search(MakeStructure structure) {
		
		MakeStructure tmp = structure;
		
		if(objectText.equals(tmp.name)) {
			objectStrct = tmp;
		}
		else {		
			for (int i = 0; i < 4; i++) {			
				if(tmp.next[i] == null)
					break;	
				
				Search(tmp.next[i]);
			}
		}
		
		
	}
	

}
