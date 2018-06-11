package MouseOption;

import javax.swing.*;
import template.ResizePanelSize;
import java.awt.*;
import java.awt.event.*;
import Structure.*;
import MindMapPane.DrawInfo;

public class ApplyMouseListener extends MouseAdapter{
	JTextField name, x, y, width, height, color;
	MakeStructure objectStrct, strct;
	DrawInfo objectNode;
	JPanel mapPanel;
	
	public ApplyMouseListener(JPanel mapPanel, JTextField name, JTextField x, JTextField y, JTextField width, JTextField height, JTextField color, 
			MakeStructure objectStrct, DrawInfo objectNode, MakeStructure strct) {
		this.mapPanel = mapPanel;
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.objectStrct = objectStrct;
		this.objectNode = objectNode;
		this.strct = strct;
	}
	
	public void mouseClicked(MouseEvent e) {
		objectStrct.x = Integer.parseInt(x.getText());
		objectStrct.y = Integer.parseInt(y.getText());
		objectStrct.width = Integer.parseInt(width.getText());
		objectStrct.height = Integer.parseInt(height.getText());
		objectStrct.background = new Color(Integer.parseInt(color.getText()));
		objectNode.node.setLocation(objectStrct.x, objectStrct.y);
		objectNode.node.setSize(objectStrct.width, objectStrct.height);
		objectNode.node.setBackground(objectStrct.background);
		new ResizePanelSize(strct, mapPanel);
		
		mapPanel.repaint();
		
	}
}
