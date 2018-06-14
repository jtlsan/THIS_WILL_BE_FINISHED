package MouseOption;

import template.ResizePanelSize;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Structure.*;
import MindMapPane.DrawInfo;

public class AxelListener implements MouseListener, MouseMotionListener{
	MakeStructure objectStrct, strct;
	JLabel axis[], edge[];
	int way;
	JPanel mapPanel;
	DrawInfo objectNode;
	JTextField name, x, y, width, height, color;
	public AxelListener(JLabel edge[], JLabel axis[], int way, JTextField name, JTextField x, JTextField y, JTextField width, 
			JTextField height, JTextField color,MakeStructure objectStrct, MakeStructure strct, 
			JPanel mapPanel, DrawInfo objectNode) {
		this.objectStrct = objectStrct;
		this.strct = strct;
		this.mapPanel = mapPanel;
		this.objectNode = objectNode;
		this.name = name;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.way = way;
		this.axis = axis;
		this.edge = edge;
	}
	
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseDragged(MouseEvent e) {
		

		int mouseX = e.getXOnScreen() - 220;
		int mouseY = e.getYOnScreen() - 110;
		
		//1부터수정
		switch(way) {
			case 0:
				
				if(mouseY < objectStrct.y) {
					objectStrct.height += Math.abs(objectStrct.y - mouseY);
					objectStrct.y = mouseY;
				}
				else  if (mouseY >= objectStrct.y){
					objectStrct.height -= Math.abs(objectStrct.y - mouseY);
					objectStrct.y = mouseY;
				}
				break;
			case 1:
				if(mouseX > objectStrct.x + objectStrct.width) {
					objectStrct.width += Math.abs(objectStrct.x + objectStrct.width - mouseX);
					objectStrct.x = mouseX - objectStrct.width;
				}
				else if (mouseX <= objectStrct.x + objectStrct.width) {
					objectStrct.width -= Math.abs(objectStrct.x + objectStrct.width - mouseX);
					objectStrct.x = mouseX - objectStrct.width;
				}
				break;
			case 2:
				if(mouseY > objectStrct.y + objectStrct.height) {					
					objectStrct.height += Math.abs(objectStrct.y + objectStrct.height - mouseY);
					objectStrct.y = mouseY - objectStrct.height;
				}
				else if (mouseY <= objectStrct.y + objectStrct.height) {
					objectStrct.height -= Math.abs(objectStrct.y + objectStrct.height - mouseY);
					objectStrct.y = mouseY - objectStrct.height;
				}
				break;
			case 3:
				if(mouseX < objectStrct.x) {
					objectStrct.width += Math.abs(objectStrct.x - mouseX);
					objectStrct.x = mouseX;
				}
				else if (mouseX >= objectStrct.x) {
					objectStrct.width -= Math.abs(objectStrct.x - mouseX);
					objectStrct.x = mouseX;
				}
				break;
			
		}
		
		
		objectNode.node.setLocation(objectStrct.x, objectStrct.y);
		objectNode.node.setSize(objectStrct.width, objectStrct.height);
		name.setText(objectStrct.name);
		x.setText(Integer.toString(objectStrct.x));
		y.setText(Integer.toString(objectStrct.y));
		width.setText(Integer.toString(objectStrct.width));
		height.setText(Integer.toString(objectStrct.height));
		color.setText((Integer.toHexString(objectStrct.r) + Integer.toHexString(objectStrct.g) + Integer.toHexString(objectStrct.b)).toUpperCase());
		
		axis[0].setLocation(objectStrct.width / 2 - 3, 0);
		axis[1].setLocation(objectStrct.width - 6, objectStrct.height/2 - 3);
		axis[2].setLocation(objectStrct.width/2 - 3, objectStrct.height - 6);
		axis[3].setLocation(0, objectStrct.height/2 - 3);
		edge[0].setLocation(0, 0);
		edge[1].setLocation(objectStrct.width - 6, 0);
		edge[2].setLocation(objectStrct.width - 6, objectStrct.height - 6);
		edge[3].setLocation(0, objectStrct.height - 6);
		axis[0].getParent().repaint();
		mapPanel.repaint();
		
	}
	
	public void mouseReleased(MouseEvent e) {
		for(int i = 0; i < 4; i++) {
			edge[i].setVisible(false);
			edge[i].setOpaque(false);
			objectNode.node.remove(edge[i]);
			axis[i].setVisible(false);
			axis[i].setOpaque(false);
			objectNode.node.remove(axis[i]);
		}

	}
	public void mouseMoved(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	

}
