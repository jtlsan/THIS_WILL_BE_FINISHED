package MouseOption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Structure.*;
import MindMapPane.DrawInfo;
public class NodeMouseMotionListener implements MouseMotionListener{
	JTextField name, x, y, width, height, color;
	MakeStructure strct;
	MakeStructure objectStrct;
	DrawInfo nodeInfo;
	DrawInfo objectNode;
	JButton chg;
	String objectText;
	JPanel mapPanel;
	int objectX = 0, objectY = 0;
	
	public NodeMouseMotionListener(JPanel mapPanel, JTextField name, JTextField x, JTextField y, JTextField width, JTextField height, JTextField color, 
	MakeStructure strct, DrawInfo nodeInfo, JButton chg) {
		this.mapPanel = mapPanel;
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.strct = strct;
		this.nodeInfo = nodeInfo;
		this.chg = chg;
	}
	
	public void mousePressed(MouseEvent e) {
		JLabel label = (JLabel)e.getSource();
		
		
		objectX = label.getX();
		objectY = label.getY();
		objectStrct = new NodeMouseListener(strct, nodeInfo, objectX, objectY).objectStrct;
		objectNode = new NodeMouseListener(strct, nodeInfo, objectX, objectY).objectNode;
		name.setText(objectStrct.name);
		x.setText(Integer.toString(objectStrct.x));
		y.setText(Integer.toString(objectStrct.y));
		width.setText(Integer.toString(objectStrct.width));
		height.setText(Integer.toString(objectStrct.height));
		color.setText(Integer.toString(objectStrct.background.getRGB()));
		
	}
	
}
